package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.ElectroMagicTools;
import static gregtech.api.enums.Mods.EnderStorage;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCompressorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCutterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sLaserEngraverRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.GT_Values;
import gregtech.api.util.GT_ModHandler;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptThaumicTinkerer implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Thaumic Tinkering";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                ThaumicTinkerer.ID,
                Thaumcraft.ID,
                Forestry.ID,
                PamsHarvestCraft.ID,
                ElectroMagicTools.ID,
                ForbiddenMagic.ID,
                IndustrialCraft2.ID,
                StevesCarts2.ID,
                ExtraUtilities.ID,
                EnderStorage.ID,
                AppliedEnergistics2.ID);
    }

    @Override
    public void loadRecipes() {

        addShapedRecipe(
                getModItem(ThaumicTinkerer.ID, "darkQuartzSlab", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(ThaumicTinkerer.ID, "darkQuartz", 1, 0, missing) });

        GT_ModHandler.addSmeltingRecipe(
                getModItem(GregTech.ID, "gt.blockmetal8", 1, 13, missing),
                getModItem(GregTech.ID, "gt.metaitem.01", 2, 11978, missing));

        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicTinkerer.ID, "darkQuartzItem", 4, 0, missing))
                .itemOutputs(getModItem(ThaumicTinkerer.ID, "darkQuartz", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicTinkerer.ID, "darkQuartz", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicTinkerer.ID, "darkQuartzSlab", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(100).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicTinkerer.ID, "darkQuartz", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicTinkerer.ID, "darkQuartzSlab", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 4)).noFluidOutputs().duration(100).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicTinkerer.ID, "darkQuartz", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicTinkerer.ID, "darkQuartzSlab", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(50).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 24506, missing),
                        getModItem(ThaumicTinkerer.ID, "darkQuartz", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicTinkerer.ID, "darkQuartz", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(16).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 24515, missing),
                        getModItem(ThaumicTinkerer.ID, "darkQuartz", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicTinkerer.ID, "darkQuartz", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(16).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 24545, missing),
                        getModItem(ThaumicTinkerer.ID, "darkQuartz", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicTinkerer.ID, "darkQuartz", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(16).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 24890, missing),
                        getModItem(ThaumicTinkerer.ID, "darkQuartz", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicTinkerer.ID, "darkQuartz", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(16).addTo(sLaserEngraverRecipes);

        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "interface", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "connector", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "dislocator", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicTinkerer.ID, "gaseousLightItem", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicTinkerer.ID, "gaseousShadowItem", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "gasRemover", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicTinkerer.ID, "brightNitor", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicTinkerer.ID, "fireFire", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicTinkerer.ID, "fireWater", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicTinkerer.ID, "fireEarth", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicTinkerer.ID, "fireOrder", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicTinkerer.ID, "fireAir", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicTinkerer.ID, "fireChaos", 1, 0, missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(
                        ThaumicTinkerer.ID,
                        "infusedSeeds",
                        1,
                        0,
                        "{mainAspect:{Aspects:[0:{amount:1,key:\"aer\"}]}}",
                        missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(
                        ThaumicTinkerer.ID,
                        "infusedSeeds",
                        1,
                        0,
                        "{mainAspect:{Aspects:[0:{amount:1,key:\"ignis\"}]}}",
                        missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(
                        ThaumicTinkerer.ID,
                        "infusedSeeds",
                        1,
                        0,
                        "{mainAspect:{Aspects:[0:{amount:1,key:\"terra\"}]}}",
                        missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(
                        ThaumicTinkerer.ID,
                        "infusedSeeds",
                        1,
                        0,
                        "{mainAspect:{Aspects:[0:{amount:1,key:\"aqua\"}]}}",
                        missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(
                        ThaumicTinkerer.ID,
                        "infusedSeeds",
                        1,
                        0,
                        "{mainAspect:{Aspects:[0:{amount:1,key:\"ordo\"}]}}",
                        missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(
                        ThaumicTinkerer.ID,
                        "infusedSeeds",
                        1,
                        0,
                        "{mainAspect:{Aspects:[0:{amount:1,key:\"perditio\"}]}}",
                        missing));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicTinkerer.ID, "infusedPotion", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicTinkerer.ID, "infusedPotion", 1, 1, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicTinkerer.ID, "infusedPotion", 1, 2, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicTinkerer.ID, "infusedPotion", 1, 3, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "funnel", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "repairer", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "magnet", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "magnet", 1, 1, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicTinkerer.ID, "soulMould", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "animationTablet", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "Levitational Locomotive", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "Levitational Locomotive Relay", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "cleansingTalisman", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "platform", 2, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "bloodSword", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "spawner", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "focusSmelt", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "focusFlight", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "focusDeflect", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "focusEnderChest", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "focusTelekinesis", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "focusDislocation", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "focusHeal", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "enchanter", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicTinkerer.ID, "spellCloth", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "xpTalisman", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "revealingHelm", 1, 0, missing));
        TCHelper.orphanResearch("SHARE_TOME");
        TCHelper.removeResearch("SHARE_TOME");
        new ResearchItem(
                "SHARETOME",
                "TT_CATEGORY",
                new AspectList().add(Aspect.getAspect("cognitio"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("instrumentum"), 6)
                        .add(Aspect.getAspect("terra"), 3),
                0,
                -1,
                3,
                getModItem(ThaumicTinkerer.ID, "shareBook", 1, 0, missing)).setParents("INFUSION")
                        .setPages(new ResearchPage("ttresearch.page.SHARE_TOME.0")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SHARETOME",
                getModItem(ThaumicTinkerer.ID, "shareBook", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("cognitio"), 32).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("permutatio"), 32).add(Aspect.getAspect("pannus"), 16),
                getModItem(Minecraft.ID, "skull", 1, 3, missing),
                new ItemStack[] { getModItem(Minecraft.ID, "nether_star", 1, 0, missing),
                        getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemInkwell", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemThaumonomicon", 1, 0, missing),
                        getModItem(Minecraft.ID, "paper", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SHARETOME",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ThaumicTinkerer.ID, "shareBook", 1, 0, missing))));
        TCHelper.orphanResearch("DARK_QUARTZ");
        TCHelper.removeResearch("DARK_QUARTZ");
        new ResearchItem(
                "DARKQUARTZ",
                "TT_CATEGORY",
                new AspectList(),
                -2,
                2,
                1,
                getModItem(ThaumicTinkerer.ID, "darkQuartzItem", 1, 0, missing)).setRound().setAutoUnlock()
                        .setPages(new ResearchPage("ttresearch.page.DARK_QUARTZ.0")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DARKQUARTZ",
                getModItem(ThaumicTinkerer.ID, "darkQuartzItem", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 8),
                "abc",
                "def",
                "ghi",
                'a',
                "gemQuartz",
                'b',
                "gemQuartz",
                'c',
                "gemQuartz",
                'd',
                "gemQuartz",
                'e',
                "coal",
                'f',
                "gemQuartz",
                'g',
                "gemQuartz",
                'h',
                "gemQuartz",
                'i',
                "gemQuartz");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DARKQUARTZ",
                getModItem(ThaumicTinkerer.ID, "darkQuartzItem", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 8),
                "abc",
                "def",
                "ghi",
                'a',
                "gemQuartz",
                'b',
                "gemQuartz",
                'c',
                "gemQuartz",
                'd',
                "gemQuartz",
                'e',
                "charcoal",
                'f',
                "gemQuartz",
                'g',
                "gemQuartz",
                'h',
                "gemQuartz",
                'i',
                "gemQuartz");
        TCHelper.addResearchPage(
                "DARKQUARTZ",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ThaumicTinkerer.ID, "darkQuartzItem", 1, 0, missing))));
        TCHelper.addResearchPage(
                "DARKQUARTZ",
                new ResearchPage(
                        TCHelper.findCraftingRecipe(getModItem(ThaumicTinkerer.ID, "darkQuartz", 1, 2, missing))));
        TCHelper.addResearchPage(
                "DARKQUARTZ",
                new ResearchPage(
                        TCHelper.findCraftingRecipe(getModItem(ThaumicTinkerer.ID, "darkQuartzSlab", 1, 0, missing))));
        TCHelper.addResearchPage(
                "DARKQUARTZ",
                new ResearchPage(
                        TCHelper.findCraftingRecipe(
                                getModItem(ThaumicTinkerer.ID, "darkQuartzStairs", 1, 0, missing))));
        TCHelper.addResearchPrereq("INTERFACE", "INFUSION", false);
        TCHelper.addResearchPrereq("INTERFACE", "DARKQUARTZ", false);
        ResearchCategories.getResearch("INTERFACE").setConcealed();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "INTERFACE",
                getModItem(ThaumicTinkerer.ID, "interface", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 32).add(Aspect.getAspect("perditio"), 32)
                        .add(Aspect.getAspect("terra"), 16),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6, missing),
                'b',
                "pipeLargeSteel",
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6, missing),
                'd',
                "pipeLargeElectrum",
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32670, missing),
                'f',
                "pipeLargeElectrum",
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6, missing),
                'h',
                "pipeLargeSteel",
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "INTERFACE",
                getModItem(ThaumicTinkerer.ID, "connector", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 16),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 1, missing),
                'b',
                "screwThaumium",
                'c',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 2, missing),
                'e',
                getModItem(Forestry.ID, "oakStick", 1, 0, missing),
                'f',
                "screwThaumium",
                'g',
                getModItem(Forestry.ID, "oakStick", 1, 0, missing),
                'i',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 3, missing));
        TCHelper.setResearchAspects(
                "INTERFACE",
                new AspectList().add(Aspect.getAspect("ordo"), 12).add(Aspect.getAspect("perditio"), 9)
                        .add(Aspect.getAspect("potentia"), 6).add(Aspect.getAspect("aqua"), 3));
        TCHelper.setResearchComplexity("INTERFACE", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DISLOCATOR",
                getModItem(ThaumicTinkerer.ID, "dislocator", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 48).add(Aspect.getAspect("perditio"), 48)
                        .add(Aspect.getAspect("terra"), 24),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 10, missing),
                'c',
                "plateEnderPearl",
                'd',
                "circuitBasic",
                'e',
                getModItem(ThaumicTinkerer.ID, "interface", 1, 0, missing),
                'f',
                "circuitBasic",
                'g',
                "plateEnderPearl",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 10, missing),
                'i',
                "screwThaumium");
        TCHelper.setResearchAspects(
                "DISLOCATOR",
                new AspectList().add(Aspect.getAspect("cognitio"), 15).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("perditio"), 9).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("aqua"), 3));
        TCHelper.setResearchComplexity("DISLOCATOR", 4);
        ThaumcraftApi.addCrucibleRecipe(
                "GASEOUS_LIGHT",
                getModItem(ThaumicTinkerer.ID, "gaseousLightItem", 1, 0, missing),
                getModItem(Thaumcraft.ID, "ItemEssence", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("lux"), 16).add(Aspect.getAspect("aer"), 12)
                        .add(Aspect.getAspect("motus"), 10));
        TCHelper.setResearchAspects(
                "GASEOUS_LIGHT",
                new AspectList().add(Aspect.getAspect("lux"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("motus"), 3).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("GASEOUS_LIGHT", 2);
        ResearchCategories.getResearch("GASEOUS_SHADOW").setConcealed();
        ThaumcraftApi.addCrucibleRecipe(
                "GASEOUS_SHADOW",
                getModItem(ThaumicTinkerer.ID, "gaseousShadowItem", 1, 0, missing),
                getModItem(Thaumcraft.ID, "ItemEssence", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("tenebrae"), 16).add(Aspect.getAspect("aer"), 12)
                        .add(Aspect.getAspect("motus"), 10));
        TCHelper.setResearchAspects(
                "GASEOUS_SHADOW",
                new AspectList().add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("motus"), 3).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("GASEOUS_SHADOW", 2);
        ResearchCategories.getResearch("GAS_REMOVER").setConcealed();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GAS_REMOVER",
                getModItem(ThaumicTinkerer.ID, "gasRemover", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 16).add(Aspect.getAspect("aer"), 12)
                        .add(Aspect.getAspect("perditio"), 8),
                "abc",
                "def",
                "ghi",
                'a',
                "gemQuartz",
                'b',
                "screwThaumium",
                'c',
                "gemQuartz",
                'd',
                getModItem(ThaumicTinkerer.ID, "gaseousLightItem", 1, 0, missing),
                'e',
                getModItem(ThaumicTinkerer.ID, "interface", 1, 0, missing),
                'f',
                getModItem(ThaumicTinkerer.ID, "gaseousShadowItem", 1, 0, missing),
                'g',
                getModItem(ThaumicTinkerer.ID, "darkQuartzItem", 1, 0, missing),
                'h',
                "screwThaumium",
                'i',
                getModItem(ThaumicTinkerer.ID, "darkQuartzItem", 1, 0, missing));
        TCHelper.setResearchAspects(
                "GASEOUS_SHADOW",
                new AspectList().add(Aspect.getAspect("ignis"), 12).add(Aspect.getAspect("tenebrae"), 12)
                        .add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("motus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("GASEOUS_SHADOW", 3);
        TCHelper.addResearchPrereq("BRIGHT_NITOR", "INFUSION", false);
        ThaumcraftApi.addCrucibleRecipe(
                "BRIGHT_NITOR",
                getModItem(ThaumicTinkerer.ID, "brightNitor", 1, 0, missing),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 16).add(Aspect.getAspect("aer"), 16)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("lux"), 32));
        TCHelper.setResearchAspects(
                "BRIGHT_NITOR",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("lux"), 12)
                        .add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("BRIGHT_NITOR", 3);
        TCHelper.orphanResearch("FIRE_IGNIS");
        TCHelper.removeResearch("FIRE_IGNIS");
        new ResearchItem(
                "FIREIGNIS",
                "TT_CATEGORY",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("lux"), 12)
                        .add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("praecantatio"), 3),
                4,
                -4,
                3,
                getModItem(ThaumicTinkerer.ID, "fireFire", 1, 0, missing))
                        .setParents("INFUSION", "BRIGHT_NITOR", "ELDRITCHMINOR").setConcealed()
                        .setPages(new ResearchPage("ttresearch.page.FIRE_IGNIS.0")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FIREIGNIS",
                getModItem(ThaumicTinkerer.ID, "fireFire", 1, 0, missing),
                16,
                new AspectList().add(Aspect.getAspect("ignis"), 10).add(Aspect.getAspect("lux"), 10)
                        .add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("praecantatio"), 10),
                createItemStack(Thaumcraft.ID, "ItemEssence", 1, 1, "{Aspects:[0:{amount:8,key:\"ignis\"}]}", missing),
                new ItemStack[] { getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 1, missing),
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 1, missing), });
        TCHelper.addResearchPage(
                "FIREIGNIS",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ThaumicTinkerer.ID, "fireFire", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("FIREIGNIS", 10);
        TCHelper.orphanResearch("FIRE_AQUA");
        TCHelper.removeResearch("FIRE_AQUA");
        new ResearchItem(
                "FIREAQUA",
                "TT_CATEGORY",
                new AspectList().add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("lux"), 12)
                        .add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("praecantatio"), 3),
                2,
                -2,
                3,
                getModItem(ThaumicTinkerer.ID, "fireWater", 1, 0, missing))
                        .setParents("INFUSION", "BRIGHT_NITOR", "ELDRITCHMINOR").setConcealed()
                        .setPages(new ResearchPage("ttresearch.page.FIRE_AQUA.0")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FIREAQUA",
                getModItem(ThaumicTinkerer.ID, "fireWater", 1, 0, missing),
                16,
                new AspectList().add(Aspect.getAspect("aqua"), 10).add(Aspect.getAspect("lux"), 10)
                        .add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("praecantatio"), 10),
                createItemStack(Thaumcraft.ID, "ItemEssence", 1, 1, "{Aspects:[0:{amount:8,key:\"aqua\"}]}", missing),
                new ItemStack[] { getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing),
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing), });
        TCHelper.addResearchPage(
                "FIREAQUA",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ThaumicTinkerer.ID, "fireWater", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("FIREAQUA", 10);
        TCHelper.orphanResearch("FIRE_TERRA");
        TCHelper.removeResearch("FIRE_TERRA");
        new ResearchItem(
                "FIRETERRA",
                "TT_CATEGORY",
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("lux"), 12)
                        .add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("praecantatio"), 3),
                4,
                -6,
                3,
                getModItem(ThaumicTinkerer.ID, "fireEarth", 1, 0, missing))
                        .setParents("INFUSION", "BRIGHT_NITOR", "ELDRITCHMINOR").setConcealed()
                        .setPages(new ResearchPage("ttresearch.page.FIRE_TERRA.0")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FIRETERRA",
                getModItem(ThaumicTinkerer.ID, "fireEarth", 1, 0, missing),
                16,
                new AspectList().add(Aspect.getAspect("terra"), 10).add(Aspect.getAspect("lux"), 10)
                        .add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("praecantatio"), 10),
                createItemStack(Thaumcraft.ID, "ItemEssence", 1, 1, "{Aspects:[0:{amount:8,key:\"terra\"}]}", missing),
                new ItemStack[] { getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 3, missing),
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 3, missing), });
        TCHelper.addResearchPage(
                "FIRETERRA",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ThaumicTinkerer.ID, "fireEarth", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("FIRETERRA", 10);
        TCHelper.orphanResearch("FIRE_ORDO");
        TCHelper.removeResearch("FIRE_ORDO");
        new ResearchItem(
                "FIREORDO",
                "TT_CATEGORY",
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("lux"), 12)
                        .add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("praecantatio"), 3),
                3,
                -3,
                3,
                getModItem(ThaumicTinkerer.ID, "fireOrder", 1, 0, missing))
                        .setParents("INFUSION", "BRIGHT_NITOR", "ELDRITCHMINOR").setConcealed()
                        .setPages(new ResearchPage("ttresearch.page.FIRE_ORDO.0")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FIREORDO",
                getModItem(ThaumicTinkerer.ID, "fireOrder", 1, 0, missing),
                16,
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("lux"), 10)
                        .add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("praecantatio"), 10),
                createItemStack(Thaumcraft.ID, "ItemEssence", 1, 1, "{Aspects:[0:{amount:8,key:\"ordo\"}]}", missing),
                new ItemStack[] { getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 4, missing),
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 4, missing), });
        TCHelper.addResearchPage(
                "FIREORDO",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ThaumicTinkerer.ID, "fireOrder", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("FIREORDO", 10);
        TCHelper.orphanResearch("FIRE_AER");
        TCHelper.removeResearch("FIRE_AER");
        new ResearchItem(
                "FIREAER",
                "TT_CATEGORY",
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("lux"), 12)
                        .add(Aspect.getAspect("motus"), 9).add(Aspect.getAspect("praecantatio"), 3),
                3,
                -7,
                3,
                getModItem(ThaumicTinkerer.ID, "fireAir", 1, 0, missing))
                        .setParents("INFUSION", "BRIGHT_NITOR", "ELDRITCHMINOR").setConcealed()
                        .setPages(new ResearchPage("ttresearch.page.FIRE_AER.0")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FIREAER",
                getModItem(ThaumicTinkerer.ID, "fireAir", 1, 0, missing),
                16,
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("lux"), 10)
                        .add(Aspect.getAspect("motus"), 10).add(Aspect.getAspect("praecantatio"), 10),
                createItemStack(Thaumcraft.ID, "ItemEssence", 1, 1, "{Aspects:[0:{amount:8,key:\"aer\"}]}", missing),
                new ItemStack[] { getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing),
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing), });
        TCHelper.addResearchPage(
                "FIREAER",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ThaumicTinkerer.ID, "fireAir", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("FIREAER", 10);
        TCHelper.orphanResearch("FIRE_PERDITIO");
        TCHelper.removeResearch("FIRE_PERDITIO");
        new ResearchItem(
                "FIREPERDITIO",
                "TT_CATEGORY",
                new AspectList().add(Aspect.getAspect("perditio"), 15).add(Aspect.getAspect("lux"), 12)
                        .add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("praecantatio"), 3),
                2,
                -8,
                3,
                getModItem(ThaumicTinkerer.ID, "fireChaos", 1, 0, missing))
                        .setParents("INFUSION", "BRIGHT_NITOR", "ELDRITCHMINOR").setConcealed()
                        .setPages(new ResearchPage("ttresearch.page.FIRE_PERDITIO.0")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FIREPERDITIO",
                getModItem(ThaumicTinkerer.ID, "fireChaos", 1, 0, missing),
                16,
                new AspectList().add(Aspect.getAspect("perditio"), 10).add(Aspect.getAspect("lux"), 10)
                        .add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("praecantatio"), 10),
                createItemStack(
                        Thaumcraft.ID,
                        "ItemEssence",
                        1,
                        1,
                        "{Aspects:[0:{amount:8,key:\"perditio\"}]}",
                        missing),
                new ItemStack[] { getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 5, missing),
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 5, missing), });
        TCHelper.addResearchPage(
                "FIREPERDITIO",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ThaumicTinkerer.ID, "fireChaos", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("FIREPERDITIO", 10);
        TCHelper.orphanResearch("INFUSED_POTIONS");
        TCHelper.removeResearch("INFUSED_POTIONS");
        new ResearchItem(
                "INFUSEDSEED",
                "TT_CATEGORY",
                new AspectList().add(Aspect.getAspect("perditio"), 15).add(Aspect.getAspect("lux"), 12)
                        .add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("praecantatio"), 3),
                7,
                -5,
                3,
                createItemStack(
                        ThaumicTinkerer.ID,
                        "infusedSeeds",
                        1,
                        0,
                        "{mainAspect:{Aspects:[0:{amount:1,key:\"ignis\"}]},aspectTendencies:{Aspects:[]}}",
                        missing))
                                .setParents(
                                        "INFUSION",
                                        "FIREIGNIS",
                                        "FIREAQUA",
                                        "FIRETERRA",
                                        "FIREAER",
                                        "FIREORDO",
                                        "FIREPERDITIO")
                                .setConcealed()
                                .setPages(
                                        new ResearchPage("ttresearch.page.INFUSED_POTIONS.0"),
                                        new ResearchPage("ttresearch.page.INFUSED_POTIONS.1"),
                                        new ResearchPage("ttresearch.page.INFUSED_POTIONS.2"),
                                        new ResearchPage("ttresearch.page.INFUSED_POTIONS.3"))
                                .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "INFUSEDSEED",
                createItemStack(
                        ThaumicTinkerer.ID,
                        "infusedSeeds",
                        1,
                        0,
                        "{mainAspect:{Aspects:[0:{amount:1,key:\"aer\"}]},aspectTendencies:{Aspects:[]}}",
                        missing),
                4,
                new AspectList().add(Aspect.getAspect("messis"), 32).add(Aspect.getAspect("meto"), 32)
                        .add(Aspect.getAspect("aer"), 16),
                getModItem(Minecraft.ID, "wheat_seeds", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing), });
        TCHelper.addResearchPage(
                "INFUSEDSEED",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                createItemStack(
                                        ThaumicTinkerer.ID,
                                        "infusedSeeds",
                                        1,
                                        0,
                                        "{mainAspect:{Aspects:[0:{amount:1,key:\"aer\"}]},aspectTendencies:{Aspects:[]}}",
                                        missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "INFUSEDSEED",
                createItemStack(
                        ThaumicTinkerer.ID,
                        "infusedSeeds",
                        1,
                        0,
                        "{mainAspect:{Aspects:[0:{amount:1,key:\"ignis\"}]},aspectTendencies:{Aspects:[]}}",
                        missing),
                4,
                new AspectList().add(Aspect.getAspect("messis"), 32).add(Aspect.getAspect("meto"), 32)
                        .add(Aspect.getAspect("ignis"), 16),
                getModItem(Minecraft.ID, "wheat_seeds", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "blockCrystal", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 1, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "INFUSEDSEED",
                createItemStack(
                        ThaumicTinkerer.ID,
                        "infusedSeeds",
                        1,
                        0,
                        "{mainAspect:{Aspects:[0:{amount:1,key:\"aqua\"}]},aspectTendencies:{Aspects:[]}}",
                        missing),
                4,
                new AspectList().add(Aspect.getAspect("messis"), 32).add(Aspect.getAspect("meto"), 32)
                        .add(Aspect.getAspect("aqua"), 16),
                getModItem(Minecraft.ID, "wheat_seeds", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "INFUSEDSEED",
                createItemStack(
                        ThaumicTinkerer.ID,
                        "infusedSeeds",
                        1,
                        0,
                        "{mainAspect:{Aspects:[0:{amount:1,key:\"terra\"}]},aspectTendencies:{Aspects:[]}}",
                        missing),
                4,
                new AspectList().add(Aspect.getAspect("messis"), 32).add(Aspect.getAspect("meto"), 32)
                        .add(Aspect.getAspect("terra"), 16),
                getModItem(Minecraft.ID, "wheat_seeds", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "blockCrystal", 1, 3, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 3, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 3, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 3, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "INFUSEDSEED",
                createItemStack(
                        ThaumicTinkerer.ID,
                        "infusedSeeds",
                        1,
                        0,
                        "{mainAspect:{Aspects:[0:{amount:1,key:\"ordo\"}]},aspectTendencies:{Aspects:[]}}",
                        missing),
                4,
                new AspectList().add(Aspect.getAspect("messis"), 32).add(Aspect.getAspect("meto"), 32)
                        .add(Aspect.getAspect("ordo"), 16),
                getModItem(Minecraft.ID, "wheat_seeds", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "blockCrystal", 1, 4, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 4, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 4, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 4, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "INFUSEDSEED",
                createItemStack(
                        ThaumicTinkerer.ID,
                        "infusedSeeds",
                        1,
                        0,
                        "{mainAspect:{Aspects:[0:{amount:1,key:\"perditio\"}]},aspectTendencies:{Aspects:[]}}",
                        missing),
                4,
                new AspectList().add(Aspect.getAspect("messis"), 32).add(Aspect.getAspect("meto"), 32)
                        .add(Aspect.getAspect("perditio"), 16),
                getModItem(Minecraft.ID, "wheat_seeds", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "blockCrystal", 1, 5, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 5, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 5, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 5, missing), });
        TCHelper.addResearchPage("INFUSEDSEED", new ResearchPage("tt.research.page.INFUSEDSEED.3"));
        ThaumcraftApi.addWarpToResearch("INFUSEDSEED", 2);
        new ResearchItem(
                "INFUSEDPOTIONS",
                "TT_CATEGORY",
                new AspectList().add(Aspect.getAspect("auram"), 15).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("aqua"), 9)
                        .add(Aspect.getAspect("terra"), 9),
                9,
                -5,
                3,
                getModItem(ThaumicTinkerer.ID, "infusedPotion", 1, 1, missing)).setParents("INFUSION", "INFUSEDSEED")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("ttresearch.page.INFUSED_POTIONS.4"),
                                new ResearchPage("ttresearch.page.INFUSED_POTIONS.5"))
                        .registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "INFUSEDPOTIONS",
                getModItem(ThaumicTinkerer.ID, "infusedPotion", 1, 0, missing),
                getModItem(ThaumicTinkerer.ID, "infusedGrain", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("auram"), 16).add(Aspect.getAspect("aer"), 16)
                        .add(Aspect.getAspect("praecantatio"), 8));
        TCHelper.addResearchPage(
                "INFUSEDPOTIONS",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ThaumicTinkerer.ID, "infusedPotion", 1, 0, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "INFUSEDPOTIONS",
                getModItem(ThaumicTinkerer.ID, "infusedPotion", 1, 1, missing),
                getModItem(ThaumicTinkerer.ID, "infusedGrain", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("auram"), 16).add(Aspect.getAspect("ignis"), 16)
                        .add(Aspect.getAspect("praecantatio"), 8));
        TCHelper.addResearchPage(
                "INFUSEDPOTIONS",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ThaumicTinkerer.ID, "infusedPotion", 1, 1, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "INFUSEDPOTIONS",
                getModItem(ThaumicTinkerer.ID, "infusedPotion", 1, 2, missing),
                getModItem(ThaumicTinkerer.ID, "infusedGrain", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("auram"), 16).add(Aspect.getAspect("terra"), 16)
                        .add(Aspect.getAspect("praecantatio"), 8));
        TCHelper.addResearchPage(
                "INFUSEDPOTIONS",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ThaumicTinkerer.ID, "infusedPotion", 1, 2, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "INFUSEDPOTIONS",
                getModItem(ThaumicTinkerer.ID, "infusedPotion", 1, 3, missing),
                getModItem(ThaumicTinkerer.ID, "infusedGrain", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("auram"), 16).add(Aspect.getAspect("aqua"), 16)
                        .add(Aspect.getAspect("praecantatio"), 8));
        TCHelper.addResearchPage(
                "INFUSEDPOTIONS",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ThaumicTinkerer.ID, "infusedPotion", 1, 3, missing))));
        ThaumcraftApi.addWarpToResearch("INFUSEDPOTIONS", 2);
        TCHelper.addResearchPrereq("FUNNEL", "INFUSION", false);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FUNNEL",
                getModItem(ThaumicTinkerer.ID, "funnel", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 8).add(Aspect.getAspect("perditio"), 8)
                        .add(Aspect.getAspect("aqua"), 8),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                "craftingToolScrewdriver",
                'c',
                "screwThaumium",
                'd',
                "plateThaumium",
                'e',
                "pipeMediumStainlessSteel",
                'f',
                "plateThaumium");
        TCHelper.setResearchAspects(
                "FUNNEL",
                new AspectList().add(Aspect.getAspect("iter"), 15).add(Aspect.getAspect("instrumentum"), 12)
                        .add(Aspect.getAspect("aqua"), 9).add(Aspect.getAspect("metallum"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("FUNNEL", 3);
        TCHelper.addResearchPrereq("REPAIRER", "INFUSION", false);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "REPAIRER",
                getModItem(ThaumicTinkerer.ID, "repairer", 1, 0, missing),
                8,
                new AspectList().add(Aspect.getAspect("fabrico"), 32).add(Aspect.getAspect("instrumentum"), 32)
                        .add(Aspect.getAspect("ordo"), 16).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("potentia"), 8),
                getModItem(GregTech.ID, "gt.blockmetal7", 1, 4, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17330, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17032, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17602, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17602, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17086, missing), });
        TCHelper.setResearchAspects(
                "REPAIRER",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("ordo"), 9).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("REPAIRER", 4);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MAGNETS",
                getModItem(ThaumicTinkerer.ID, "magnet", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("terra"), 25)
                        .add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("perditio"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                "plateSteelMagnetic",
                'c',
                "screwThaumium",
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3, missing),
                'e',
                "plateThaumium",
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing),
                'g',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0, missing),
                'h',
                getModItem(ThaumicTinkerer.ID, "focusTelekinesis", 1, 0, missing),
                'i',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0, missing));
        TCHelper.setResearchAspects(
                "MAGNETS",
                new AspectList().add(Aspect.getAspect("bestia"), 15).add(Aspect.getAspect("machina"), 15)
                        .add(Aspect.getAspect("motus"), 12).add(Aspect.getAspect("sensus"), 9)
                        .add(Aspect.getAspect("ordo"), 6).add(Aspect.getAspect("spiritus"), 3));
        TCHelper.setResearchComplexity("MAGNETS", 4);
        ThaumcraftApi.addWarpToResearch("MAGNETS", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MAGNETS",
                getModItem(ThaumicTinkerer.ID, "magnet", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aer"), 25).add(Aspect.getAspect("terra"), 30)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("perditio"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                "plateThaumium",
                'c',
                "screwThaumium",
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3, missing),
                'e',
                "plateSteelMagnetic",
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing),
                'g',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 1, missing),
                'h',
                getModItem(ThaumicTinkerer.ID, "focusTelekinesis", 1, 0, missing),
                'i',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 1, missing));
        ThaumcraftApi.addCrucibleRecipe(
                "MAGNETS",
                getModItem(ThaumicTinkerer.ID, "soulMould", 1, 0, missing),
                getModItem(Minecraft.ID, "ender_eye", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("bestia"), 8).add(Aspect.getAspect("cognitio"), 8)
                        .add(Aspect.getAspect("sensus"), 8).add(Aspect.getAspect("spiritus"), 8));
        ResearchCategories.getResearch("ANIMATION_TABLET").setConcealed();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ANIMATION_TABLET",
                getModItem(ThaumicTinkerer.ID, "animationTablet", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 35).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "plateRoseGold",
                'b',
                "plateThaumium",
                'c',
                "plateRoseGold",
                'd',
                "plateElectrum",
                'e',
                "plateThaumium",
                'f',
                "plateElectrum",
                'g',
                "screwThaumium",
                'h',
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 100, missing),
                'i',
                "screwThaumium");
        TCHelper.setResearchAspects(
                "ANIMATION_TABLET",
                new AspectList().add(Aspect.getAspect("machina"), 15).add(Aspect.getAspect("metallum"), 15)
                        .add(Aspect.getAspect("motus"), 12).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("ordo"), 6).add(Aspect.getAspect("exanimis"), 3));
        TCHelper.setResearchComplexity("ANIMATION_TABLET", 4);
        ThaumcraftApi.addWarpToResearch("ANIMATION_TABLET", 3);
        ResearchCategories.getResearch("LEVITATOR_LOCOMOTIVE").setConcealed();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "LEVITATOR_LOCOMOTIVE",
                getModItem(ThaumicTinkerer.ID, "Levitational Locomotive", 1, 0, missing),
                4,
                new AspectList().add(Aspect.getAspect("motus"), 30).add(Aspect.getAspect("ordo"), 20)
                        .add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("aer"), 25)
                        .add(Aspect.getAspect("potentia"), 10),
                getModItem(Thaumcraft.ID, "blockLifter", 1, 0, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17804, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17804, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing), });
        TCHelper.setResearchAspects(
                "LEVITATOR_LOCOMOTIVE",
                new AspectList().add(Aspect.getAspect("motus"), 15).add(Aspect.getAspect("ordo"), 15)
                        .add(Aspect.getAspect("machina"), 12).add(Aspect.getAspect("aer"), 9)
                        .add(Aspect.getAspect("potentia"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("LEVITATOR_LOCOMOTIVE", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "LEVITATOR_LOCOMOTIVE",
                getModItem(ThaumicTinkerer.ID, "Levitational Locomotive Relay", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("ordo"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "paneGlassColorless",
                'b',
                "lensInfusedWater",
                'c',
                "paneGlassColorless",
                'd',
                "lensInfusedWater",
                'e',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0, missing),
                'f',
                "lensInfusedWater",
                'g',
                "paneGlassColorless",
                'h',
                "lensInfusedWater",
                'i',
                "paneGlassColorless");
        TCHelper.addResearchPrereq("CLEANSING_TALISMAN", "DARKQUARTZ", false);
        TCHelper.addResearchPrereq("CLEANSING_TALISMAN", "INFUSION", false);
        TCHelper.addResearchPrereq("CLEANSING_TALISMAN", "RUNICARMOR", false);
        ResearchCategories.getResearch("INFUSEDPOTIONS").setConcealed();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CLEANSING_TALISMAN",
                getModItem(ThaumicTinkerer.ID, "cleansingTalisman", 1, 0, missing),
                4,
                new AspectList().add(Aspect.getAspect("humanus"), 32).add(Aspect.getAspect("instrumentum"), 24)
                        .add(Aspect.getAspect("sano"), 16).add(Aspect.getAspect("victus"), 16),
                getModItem(Minecraft.ID, "ender_eye", 1, 0, missing),
                new ItemStack[] { getModItem(ThaumicTinkerer.ID, "darkQuartzItem", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                        getModItem(ThaumicTinkerer.ID, "darkQuartzItem", 1, 0, missing),
                        getModItem(Minecraft.ID, "ghast_tear", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "darkQuartzItem", 1, 0, missing),
                        getModItem(Minecraft.ID, "ghast_tear", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "darkQuartzItem", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing), });
        TCHelper.setResearchAspects(
                "CLEANSING_TALISMAN",
                new AspectList().add(Aspect.getAspect("sano"), 15).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("mortuus"), 9).add(Aspect.getAspect("victus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("CLEANSING_TALISMAN", 3);
        ResearchCategories.getResearch("INFUSEDPOTIONS").setConcealed();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "PLATFORM",
                getModItem(ThaumicTinkerer.ID, "platform", 2, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("perditio"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                "craftingToolScrewdriver",
                'c',
                "screwThaumium",
                'd',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6, missing),
                'e',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 7, missing),
                'f',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6, missing));
        TCHelper.setResearchAspects(
                "PLATFORM",
                new AspectList().add(Aspect.getAspect("sensus"), 12).add(Aspect.getAspect("arbor"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("iter"), 3)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("PLATFORM", 3);
        ResearchCategories.getResearch("BLOOD_SWORD").setConcealed();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "BLOOD_SWORD",
                getModItem(ThaumicTinkerer.ID, "bloodSword", 1, 0, missing),
                8,
                new AspectList().add(Aspect.getAspect("fames"), 32).add(Aspect.getAspect("humanus"), 8)
                        .add(Aspect.getAspect("spiritus"), 16).add(Aspect.getAspect("tenebrae"), 24)
                        .add(Aspect.getAspect("telum"), 16),
                getModItem(Thaumcraft.ID, "ItemSwordThaumium", 1, 0, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 29500, missing),
                        getModItem(Minecraft.ID, "ghast_tear", 1, 0, missing),
                        getModItem(Minecraft.ID, "rotten_flesh", 1, 0, missing),
                        getModItem(Minecraft.ID, "porkchop", 1, 0, missing),
                        getModItem(Minecraft.ID, "fish", 1, 0, missing),
                        getModItem(Minecraft.ID, "nether_wart", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 29500, missing),
                        getModItem(Minecraft.ID, "bone", 1, 0, missing),
                        getModItem(Minecraft.ID, "beef", 1, 0, missing),
                        getModItem(Minecraft.ID, "blaze_powder", 1, 0, missing),
                        getModItem(Minecraft.ID, "spider_eye", 1, 0, missing),
                        getModItem(Minecraft.ID, "chicken", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "BLOOD_SWORD",
                new AspectList().add(Aspect.getAspect("fames"), 15).add(Aspect.getAspect("telum"), 12)
                        .add(Aspect.getAspect("corpus"), 9).add(Aspect.getAspect("spiritus"), 6)
                        .add(Aspect.getAspect("tenebrae"), 3));
        TCHelper.setResearchComplexity("BLOOD_SWORD", 4);
        ThaumcraftApi.addWarpToResearch("BLOOD_SWORD", 3);
        ResearchCategories.getResearch("SUMMON").setConcealed();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SUMMON",
                getModItem(ThaumicTinkerer.ID, "spawner", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75)
                        .add(Aspect.getAspect("terra"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                "gemFlawlessRuby",
                'b',
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 5, missing),
                'c',
                "gemFlawlessRuby",
                'd',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 0, missing),
                'e',
                "plateDenseObsidian",
                'f',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 0, missing),
                'g',
                "screwThaumium",
                'h',
                "craftingToolScrewdriver",
                'i',
                "screwThaumium");
        TCHelper.setResearchAspects(
                "SUMMON",
                new AspectList().add(Aspect.getAspect("telum"), 15).add(Aspect.getAspect("bestia"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("spiritus"), 6)
                        .add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("SUMMON", 4);
        ThaumcraftApi.addWarpToResearch("SUMMON", 5);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FOCUS_SMELT",
                getModItem(ThaumicTinkerer.ID, "focusSmelt", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 16).add(Aspect.getAspect("perditio"), 12)
                        .add(Aspect.getAspect("ordo"), 12).add(Aspect.getAspect("aer"), 8),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'b',
                getModItem(Thaumcraft.ID, "FocusExcavation", 1, 0, missing),
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                'e',
                getModItem(Minecraft.ID, "furnace", 1, 0, missing),
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                'g',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'h',
                getModItem(Thaumcraft.ID, "FocusFire", 1, 0, missing),
                'i',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing));
        TCHelper.setResearchAspects(
                "FOCUS_SMELT",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("FOCUS_SMELT", 3);
        TCHelper.addResearchPrereq("FOCUS_FLIGHT", "FOCUSFIRE", false);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FOCUS_FLIGHT",
                getModItem(ThaumicTinkerer.ID, "focusFlight", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("aer"), 48).add(Aspect.getAspect("iter"), 24)
                        .add(Aspect.getAspect("motus"), 32).add(Aspect.getAspect("volatus"), 24),
                getModItem(Thaumcraft.ID, "ItemSwordElemental", 1, 0, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 21330, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2532, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 21330, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2532, missing), });
        TCHelper.setResearchAspects(
                "FOCUS_FLIGHT",
                new AspectList().add(Aspect.getAspect("motus"), 15).add(Aspect.getAspect("aer"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("volatus"), 6)
                        .add(Aspect.getAspect("iter"), 3));
        TCHelper.setResearchComplexity("FOCUS_FLIGHT", 4);
        TCHelper.addResearchPrereq("FOCUS_DEFLECT", "FOCUS_FLIGHT", false);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FOCUS_DEFLECT",
                getModItem(ThaumicTinkerer.ID, "focusDeflect", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("aer"), 32).add(Aspect.getAspect("ordo"), 24)
                        .add(Aspect.getAspect("tutamen"), 32).add(Aspect.getAspect("auram"), 24)
                        .add(Aspect.getAspect("alienis"), 16),
                getModItem(ThaumicTinkerer.ID, "focusFlight", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemResource", 1, 10, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 3, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 4, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 10, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 3, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 4, missing), });
        TCHelper.setResearchAspects(
                "FOCUS_DEFLECT",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("auram"), 6)
                        .add(Aspect.getAspect("aer"), 3));
        TCHelper.setResearchComplexity("FOCUS_DEFLECT", 4);
        TCHelper.addResearchPrereq("FOCUS_ENDER_CHEST", "ENDERCHEST", false);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FOCUS_ENDER_CHEST",
                getModItem(ThaumicTinkerer.ID, "focusEnderChest", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 50).add(Aspect.getAspect("ordo"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'b',
                getModItem(Thaumcraft.ID, "blockMirror", 1, 0, missing),
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'd',
                "plateEnderium",
                'e',
                getModItem(Thaumcraft.ID, "FocusPortableHole", 1, 0, missing),
                'f',
                "plateEnderium",
                'g',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'h',
                "plateNetherStar",
                'i',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing));
        TCHelper.setResearchAspects(
                "FOCUS_ENDER_CHEST",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("vacuos"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("tenebrae"), 6)
                        .add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("FOCUS_ENDER_CHEST", 4);
        ThaumcraftApi.addWarpToResearch("ANIMATION_TABLET", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FOCUS_TELEKINESIS",
                getModItem(ThaumicTinkerer.ID, "focusTelekinesis", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("aer"), 24).add(Aspect.getAspect("cognitio"), 32)
                        .add(Aspect.getAspect("motus"), 32).add(Aspect.getAspect("perditio"), 24)
                        .add(Aspect.getAspect("lucrum"), 16),
                getModItem(ThaumicTinkerer.ID, "focusFlight", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17355, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17355, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing), });
        TCHelper.setResearchAspects(
                "FOCUS_TELEKINESIS",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("motus"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("cognitio"), 9)
                        .add(Aspect.getAspect("lucrum"), 6));
        TCHelper.setResearchComplexity("FOCUS_TELEKINESIS", 4);
        TCHelper.addResearchPrereq("FOCUS_DISLOCATION", "FOCUSTRADE", false);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FOCUS_DISLOCATION",
                getModItem(ThaumicTinkerer.ID, "focusDislocation", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("alienis"), 64).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("tenebrae"), 32).add(Aspect.getAspect("vacuos"), 32)
                        .add(Aspect.getAspect("vitium"), 16).add(Aspect.getAspect("permutatio"), 16),
                getModItem(Thaumcraft.ID, "FocusTrade", 1, 0, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 29500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 29514, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 29500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 29514, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing), });
        TCHelper.setResearchAspects(
                "FOCUS_DISLOCATION",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("permutatio"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("tenebrae"), 9)
                        .add(Aspect.getAspect("vacuos"), 6).add(Aspect.getAspect("vitium"), 3));
        TCHelper.setResearchComplexity("FOCUS_DISLOCATION", 4);
        ThaumcraftApi.addWarpToResearch("FOCUS_DISLOCATION", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FOCUS_HEAL",
                getModItem(ThaumicTinkerer.ID, "focusHeal", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("sano"), 24).add(Aspect.getAspect("spiritus"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("victus"), 24),
                getModItem(Thaumcraft.ID, "FocusPech", 1, 0, missing),
                new ItemStack[] { getModItem(Minecraft.ID, "golden_apple", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17351, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(Minecraft.ID, "golden_carrot", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17351, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing), });
        TCHelper.setResearchAspects(
                "FOCUS_HEAL",
                new AspectList().add(Aspect.getAspect("sano"), 15).add(Aspect.getAspect("victus"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("spiritus"), 9)
                        .add(Aspect.getAspect("cognitio"), 6));
        TCHelper.setResearchComplexity("FOCUS_HEAL", 4);
        TCHelper.addResearchPrereq("ENCHANTER", "ENCHANTINGTABLE", false);
        TCHelper.addResearchPrereq("ENCHANTER", "INFUSION", false);
        ResearchCategories.getResearch("ENCHANTER").setConcealed();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ENCHANTER",
                getModItem(ThaumicTinkerer.ID, "enchanter", 1, 0, missing),
                12,
                new AspectList().add(Aspect.getAspect("alienis"), 64).add(Aspect.getAspect("cognitio"), 64)
                        .add(Aspect.getAspect("potentia"), 64).add(Aspect.getAspect("praecantatio"), 64)
                        .add(Aspect.getAspect("auram"), 64).add(Aspect.getAspect("vacuos"), 64),
                getModItem(Minecraft.ID, "enchanting_table", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17330, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17330, missing),
                        getModItem(ThaumicTinkerer.ID, "spellCloth", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "spellCloth", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17330, missing),
                        getModItem(ThaumicTinkerer.ID, "spellCloth", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "spellCloth", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17330, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "ENCHANTER",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("auram"), 12).add(Aspect.getAspect("tenebrae"), 12)
                        .add(Aspect.getAspect("vacuos"), 9).add(Aspect.getAspect("cognitio"), 6)
                        .add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ENCHANTER", 4);
        ThaumcraftApi.addWarpToResearch("ENCHANTER", 3);
        TCHelper.addResearchPrereq("SPELL_CLOTH", "INFUSION", false);
        ResearchCategories.getResearch("SPELL_CLOTH").setConcealed();
        ThaumcraftApi.addCrucibleRecipe(
                "SPELL_CLOTH",
                getModItem(ThaumicTinkerer.ID, "spellCloth", 1, 0, missing),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 16).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("permutatio"), 8).add(Aspect.getAspect("alienis"), 8));
        TCHelper.setResearchAspects(
                "SPELL_CLOTH",
                new AspectList().add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("pannus"), 9)
                        .add(Aspect.getAspect("auram"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("SPELL_CLOTH", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "XP_TALISMAN",
                getModItem(ThaumicTinkerer.ID, "xpTalisman", 1, 0, missing),
                8,
                new AspectList().add(Aspect.getAspect("bestia"), 24).add(Aspect.getAspect("lucrum"), 32)
                        .add(Aspect.getAspect("machina"), 16).add(Aspect.getAspect("permutatio"), 16)
                        .add(Aspect.getAspect("humanus"), 8),
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing),
                        getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17086, missing),
                        getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing),
                        getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing), });
        TCHelper.setResearchAspects(
                "XP_TALISMAN",
                new AspectList().add(Aspect.getAspect("lucrum"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("humanus"), 9).add(Aspect.getAspect("auram"), 6)
                        .add(Aspect.getAspect("machina"), 3));
        TCHelper.setResearchComplexity("XP_TALISMAN", 4);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "REVEALING_HELM",
                getModItem(ThaumicTinkerer.ID, "revealingHelm", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 35).add(Aspect.getAspect("aqua"), 35)
                        .add(Aspect.getAspect("terra"), 35).add(Aspect.getAspect("ignis"), 35)
                        .add(Aspect.getAspect("ordo"), 35).add(Aspect.getAspect("perditio"), 35),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                "craftingToolScrewdriver",
                'c',
                "screwThaumium",
                'd',
                "plateThaumium",
                'e',
                getModItem(Thaumcraft.ID, "ItemGoggles", 1, 0, missing),
                'f',
                "plateThaumium",
                'h',
                getModItem(Thaumcraft.ID, "ItemHelmetThaumium", 1, 0, missing));
        TCHelper.setResearchAspects(
                "REVEALING_HELM",
                new AspectList().add(Aspect.getAspect("tutamen"), 15).add(Aspect.getAspect("auram"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("metallum"), 6)
                        .add(Aspect.getAspect("sensus"), 3));
        TCHelper.setResearchComplexity("REVEALING_HELM", 4);
        ResearchCategories.getResearch("TTENCH_ASCENT_BOOST").setConcealed();
        TCHelper.setResearchAspects(
                "TTENCH_ASCENT_BOOST",
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("motus"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("auram"), 6)
                        .add(Aspect.getAspect("tempus"), 3));
        TCHelper.setResearchComplexity("TTENCH_ASCENT_BOOST", 3);
        ResearchCategories.getResearch("TTENCH_SLOW_FALL").setConcealed();
        TCHelper.setResearchAspects(
                "TTENCH_SLOW_FALL",
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("motus"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("auram"), 6)
                        .add(Aspect.getAspect("tempus"), 3));
        TCHelper.setResearchComplexity("TTENCH_SLOW_FALL", 3);
        ResearchCategories.getResearch("TTENCH_AUTO_SMELT").setConcealed();
        TCHelper.setResearchAspects(
                "TTENCH_AUTO_SMELT",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("perditio"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("auram"), 6)
                        .add(Aspect.getAspect("metallum"), 3));
        TCHelper.setResearchComplexity("TTENCH_AUTO_SMELT", 3);
        ResearchCategories.getResearch("TTENCH_DESINTEGRATE").setConcealed();
        TCHelper.setResearchAspects(
                "TTENCH_DESINTEGRATE",
                new AspectList().add(Aspect.getAspect("vacuos"), 15).add(Aspect.getAspect("perditio"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("auram"), 6)
                        .add(Aspect.getAspect("tempus"), 3));
        TCHelper.setResearchComplexity("TTENCH_DESINTEGRATE", 3);
        ResearchCategories.getResearch("TTENCH_QUICK_DRAW").setConcealed();
        TCHelper.setResearchAspects(
                "TTENCH_QUICK_DRAW",
                new AspectList().add(Aspect.getAspect("telum"), 15).add(Aspect.getAspect("sensus"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("auram"), 6)
                        .add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("TTENCH_QUICK_DRAW", 3);
        ResearchCategories.getResearch("TTENCH_VAMPIRISM").setConcealed();
        TCHelper.setResearchAspects(
                "TTENCH_VAMPIRISM",
                new AspectList().add(Aspect.getAspect("fames"), 15).add(Aspect.getAspect("telum"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("auram"), 6)
                        .add(Aspect.getAspect("lucrum"), 3));
        TCHelper.setResearchComplexity("TTENCH_VAMPIRISM", 3);
        ResearchCategories.getResearch("TTENCH_POUNCE").setConcealed();
        TCHelper.setResearchAspects(
                "TTENCH_POUNCE",
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ordo"), 15)
                        .add(Aspect.getAspect("tutamen"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("auram"), 6).add(Aspect.getAspect("volatus"), 3));
        TCHelper.setResearchComplexity("TTENCH_POUNCE", 4);
        ResearchCategories.getResearch("TTENCH_SHOCKWAVE").setConcealed();
        TCHelper.setResearchAspects(
                "TTENCH_SHOCKWAVE",
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("perditio"), 15)
                        .add(Aspect.getAspect("tutamen"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("auram"), 6).add(Aspect.getAspect("volatus"), 3));
        TCHelper.setResearchComplexity("TTENCH_SHOCKWAVE", 4);
        ResearchCategories.getResearch("TTENCH_TUNNEL").setConcealed();
        TCHelper.setResearchAspects(
                "TTENCH_TUNNEL",
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ordo"), 15)
                        .add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("auram"), 6).add(Aspect.getAspect("perfodio"), 3));
        TCHelper.setResearchComplexity("TTENCH_TUNNEL", 4);
        ResearchCategories.getResearch("TTENCH_SHATTER").setConcealed();
        TCHelper.setResearchAspects(
                "TTENCH_SHATTER",
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("perditio"), 15)
                        .add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("auram"), 6).add(Aspect.getAspect("perfodio"), 3));
        TCHelper.setResearchComplexity("TTENCH_SHATTER", 4);
        ResearchCategories.getResearch("TTENCH_FOCUSED").setConcealed();
        TCHelper.setResearchAspects(
                "TTENCH_FOCUSED",
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("telum"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("auram"), 6).add(Aspect.getAspect("bestia"), 3));
        TCHelper.setResearchComplexity("TTENCH_FOCUSED", 4);
        ResearchCategories.getResearch("TTENCH_DISPERSED").setConcealed();
        TCHelper.setResearchAspects(
                "TTENCH_DISPERSED",
                new AspectList().add(Aspect.getAspect("perditio"), 15).add(Aspect.getAspect("telum"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("auram"), 6).add(Aspect.getAspect("bestia"), 3));
        TCHelper.setResearchComplexity("TTENCH_DISPERSED", 4);
        ResearchCategories.getResearch("TTENCH_VALIANCE").setConcealed();
        TCHelper.setResearchAspects(
                "TTENCH_VALIANCE",
                new AspectList().add(Aspect.getAspect("sano"), 15).add(Aspect.getAspect("telum"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("auram"), 6).add(Aspect.getAspect("bestia"), 3));
        TCHelper.setResearchComplexity("TTENCH_VALIANCE", 4);
        ResearchCategories.getResearch("TTENCH_FINAL").setConcealed();
        TCHelper.setResearchAspects(
                "TTENCH_FINAL",
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("perditio"), 15)
                        .add(Aspect.getAspect("telum"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("alienis"), 9).add(Aspect.getAspect("auram"), 6)
                        .add(Aspect.getAspect("superbia"), 3));
        TCHelper.setResearchComplexity("TTENCH_FINAL", 4);
        TCHelper.refreshResearchPages("INTERFACE");
        TCHelper.refreshResearchPages("DISLOCATOR");
        TCHelper.refreshResearchPages("GASEOUS_LIGHT");
        TCHelper.refreshResearchPages("GASEOUS_SHADOW");
        TCHelper.refreshResearchPages("GAS_REMOVER");
        TCHelper.refreshResearchPages("BRIGHT_NITOR");
        TCHelper.refreshResearchPages("FUNNEL");
        TCHelper.refreshResearchPages("REPAIRER");
        TCHelper.refreshResearchPages("MAGNETS");
        TCHelper.refreshResearchPages("ANIMATION_TABLET");
        TCHelper.refreshResearchPages("LEVITATOR_LOCOMOTIVE");
        TCHelper.refreshResearchPages("CLEANSING_TALISMAN");
        TCHelper.refreshResearchPages("PLATFORM");
        TCHelper.refreshResearchPages("BLOOD_SWORD");
        TCHelper.refreshResearchPages("SUMMON");
        TCHelper.refreshResearchPages("FOCUS_SMELT");
        TCHelper.refreshResearchPages("FOCUS_FLIGHT");
        TCHelper.refreshResearchPages("FOCUS_DEFLECT");
        TCHelper.refreshResearchPages("FOCUS_ENDER_CHEST");
        TCHelper.refreshResearchPages("FOCUS_TELEKINESIS");
        TCHelper.refreshResearchPages("FOCUS_DISLOCATION");
        TCHelper.refreshResearchPages("FOCUS_HEAL");
        TCHelper.refreshResearchPages("ENCHANTER");
        TCHelper.refreshResearchPages("SPELL_CLOTH");
        TCHelper.refreshResearchPages("XP_TALISMAN");
        TCHelper.refreshResearchPages("REVEALING_HELM");
        TCHelper.refreshResearchPages("TTENCH_ASCENT_BOOST");
        TCHelper.refreshResearchPages("TTENCH_SLOW_FALL");
        TCHelper.refreshResearchPages("TTENCH_AUTO_SMELT");
        TCHelper.refreshResearchPages("TTENCH_DESINTEGRATE");
        TCHelper.refreshResearchPages("TTENCH_QUICK_DRAW");
        TCHelper.refreshResearchPages("TTENCH_VAMPIRISM");
        TCHelper.refreshResearchPages("TTENCH_POUNCE");
        TCHelper.refreshResearchPages("TTENCH_SHOCKWAVE");
        TCHelper.refreshResearchPages("TTENCH_TUNNEL");
        TCHelper.refreshResearchPages("TTENCH_SHATTER");
        TCHelper.refreshResearchPages("TTENCH_FOCUSED");
        TCHelper.refreshResearchPages("TTENCH_DISPERSED");
        TCHelper.refreshResearchPages("TTENCH_VALIANCE");
        TCHelper.refreshResearchPages("TTENCH_FINAL");

        // KAMI

        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "kamiResource", 8, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "kamiResource", 3, 1, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "kamiResource", 2, 4, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "catAmulet", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "ichorPouch", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "ichorclothHelm", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "ichorclothChest", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "ichorclothLegs", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "ichorclothBoots", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 5, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "focusShadowbeam", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "focusXPDrain", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "ichorclothHelmGem", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "ichorclothChestGem", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "ichorclothLegsGem", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "ichorclothBootsGem", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "warpGate", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "skyPearl", 2, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "focusRecall", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "ichorPick", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "ichorShovel", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "ichorAxe", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicTinkerer.ID, "ichorSword", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "ichorPickGem", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "ichorShovelGem", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "ichorAxeGem", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "ichorSwordGem", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "protoclay", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "blockTalisman", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicTinkerer.ID, "placementMirror", 1, 0, missing));
        TCHelper.removeResearch("DIMENSION_SHARDS");
        new ResearchItem(
                "DIMENSIONSHARDS",
                "TT_CATEGORY",
                new AspectList().add(Aspect.getAspect("infernus"), 15).add(Aspect.getAspect("luxuria"), 15)
                        .add(Aspect.getAspect("superbia"), 15).add(Aspect.getAspect("gula"), 12)
                        .add(Aspect.getAspect("invidia"), 9).add(Aspect.getAspect("desidia"), 6)
                        .add(Aspect.getAspect("ira"), 3),
                7,
                8,
                3,
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 7, missing)).setParents("INFUSION")
                        .setPages(new ResearchPage("tt.research.page.DIMENSIONSHARDS")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "DIMENSIONSHARDS",
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                8,
                new AspectList().add(Aspect.getAspect("infernus"), 8).add(Aspect.getAspect("praecantatio"), 8)
                        .add(Aspect.getAspect("vitreus"), 8).add(Aspect.getAspect("vitium"), 8)
                        .add(Aspect.getAspect("luxuria"), 8).add(Aspect.getAspect("superbia"), 8)
                        .add(Aspect.getAspect("gula"), 8).add(Aspect.getAspect("invidia"), 8)
                        .add(Aspect.getAspect("desidia"), 8).add(Aspect.getAspect("ira"), 8)
                        .add(Aspect.getAspect("alienis"), 8),
                getModItem(Minecraft.ID, "blaze_rod", 1, 0, missing),
                new ItemStack[] { getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0, missing),
                        getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1, missing),
                        getModItem(ForbiddenMagic.ID, "NetherShard", 1, 2, missing),
                        getModItem(ForbiddenMagic.ID, "NetherShard", 1, 3, missing),
                        getModItem(ForbiddenMagic.ID, "NetherShard", 1, 4, missing),
                        getModItem(ForbiddenMagic.ID, "NetherShard", 1, 5, missing),
                        getModItem(ForbiddenMagic.ID, "NetherShard", 1, 6, missing),
                        getModItem(ForbiddenMagic.ID, "GluttonyShard", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemShard", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemShard", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "ItemShard", 1, 2, missing),
                        getModItem(Thaumcraft.ID, "ItemShard", 1, 3, missing),
                        getModItem(Thaumcraft.ID, "ItemShard", 1, 4, missing),
                        getModItem(Thaumcraft.ID, "ItemShard", 1, 5, missing),
                        getModItem(Thaumcraft.ID, "ItemShard", 1, 6, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "DIMENSIONSHARDS",
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 7, missing),
                8,
                new AspectList().add(Aspect.getAspect("infernus"), 8).add(Aspect.getAspect("praecantatio"), 8)
                        .add(Aspect.getAspect("vitreus"), 8).add(Aspect.getAspect("vitium"), 8)
                        .add(Aspect.getAspect("luxuria"), 8).add(Aspect.getAspect("superbia"), 8)
                        .add(Aspect.getAspect("gula"), 8).add(Aspect.getAspect("invidia"), 8)
                        .add(Aspect.getAspect("desidia"), 8).add(Aspect.getAspect("ira"), 8)
                        .add(Aspect.getAspect("alienis"), 8),
                getModItem(Minecraft.ID, "ender_eye", 1, 0, missing),
                new ItemStack[] { getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0, missing),
                        getModItem(ForbiddenMagic.ID, "NetherShard", 1, 1, missing),
                        getModItem(ForbiddenMagic.ID, "NetherShard", 1, 2, missing),
                        getModItem(ForbiddenMagic.ID, "NetherShard", 1, 3, missing),
                        getModItem(ForbiddenMagic.ID, "NetherShard", 1, 4, missing),
                        getModItem(ForbiddenMagic.ID, "NetherShard", 1, 5, missing),
                        getModItem(ForbiddenMagic.ID, "NetherShard", 1, 6, missing),
                        getModItem(ForbiddenMagic.ID, "GluttonyShard", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemShard", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemShard", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "ItemShard", 1, 2, missing),
                        getModItem(Thaumcraft.ID, "ItemShard", 1, 3, missing),
                        getModItem(Thaumcraft.ID, "ItemShard", 1, 4, missing),
                        getModItem(Thaumcraft.ID, "ItemShard", 1, 5, missing),
                        getModItem(Thaumcraft.ID, "ItemShard", 1, 6, missing), });
        TCHelper.addResearchPage(
                "DIMENSIONSHARDS",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing))));
        TCHelper.addResearchPage(
                "DIMENSIONSHARDS",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 7, missing))));
        TCHelper.addResearchPrereq("ICHOR", "DIMENSIONSHARDS", false);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ICHOR",
                getModItem(ThaumicTinkerer.ID, "kamiResource", 2, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("humanus"), 32).add(Aspect.getAspect("lux"), 32)
                        .add(Aspect.getAspect("spiritus"), 64).add(Aspect.getAspect("alienis"), 16)
                        .add(Aspect.getAspect("ordo"), 16),
                getModItem(Minecraft.ID, "nether_star", 1, 0, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 29500, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        getModItem(Minecraft.ID, "ender_eye", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 7, missing), });
        TCHelper.setResearchAspects(
                "ICHOR",
                new AspectList().add(Aspect.getAspect("humanus"), 15).add(Aspect.getAspect("spiritus"), 15)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("vitium"), 12).add(Aspect.getAspect("lux"), 9)
                        .add(Aspect.getAspect("infernus"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("ICHOR", 4);
        ThaumcraftApi.addWarpToResearch("ICHOR", 5);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ICHOR_CLOTH",
                getModItem(ThaumicTinkerer.ID, "kamiResource", 2, 1, missing),
                new AspectList().add(Aspect.getAspect("aer"), 125).add(Aspect.getAspect("aqua"), 125)
                        .add(Aspect.getAspect("ignis"), 125).add(Aspect.getAspect("terra"), 125)
                        .add(Aspect.getAspect("ordo"), 125).add(Aspect.getAspect("perditio"), 125),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 0, missing),
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7, missing),
                'c',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 0, missing),
                'd',
                "gemFlawlessDiamond",
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7, missing),
                'f',
                "gemFlawlessDiamond",
                'g',
                "screwOsmiridium",
                'h',
                "craftingToolScrewdriver",
                'i',
                "screwOsmiridium");
        TCHelper.setResearchAspects(
                "ICHOR_CLOTH",
                new AspectList().add(Aspect.getAspect("pannus"), 15).add(Aspect.getAspect("fabrico"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("sensus"), 9)
                        .add(Aspect.getAspect("lux"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("ICHOR_CLOTH", 4);
        ThaumcraftApi.addWarpToResearch("ICHOR_CLOTH", 1);
        TCHelper.clearPages("ICHORIUM");
        TCHelper.addResearchPage("ICHORIUM", new ResearchPage("ttresearch.page.ICHORIUM.0"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ICHORIUM",
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                new AspectList().add(Aspect.getAspect("aer"), 125).add(Aspect.getAspect("aqua"), 125)
                        .add(Aspect.getAspect("ignis"), 125).add(Aspect.getAspect("terra"), 125)
                        .add(Aspect.getAspect("ordo"), 125).add(Aspect.getAspect("perditio"), 125),
                "abc",
                "def",
                "ghi",
                'a',
                "ingotVoid",
                'b',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 0, missing),
                'c',
                "ingotVoid",
                'd',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 0, missing),
                'e',
                "ingotOsmiridium",
                'f',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 0, missing),
                'g',
                "gemFlawlessDiamond",
                'h',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 0, missing),
                'i',
                "gemFlawlessDiamond");
        TCHelper.addResearchPage(
                "ICHORIUM",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing))));
        TCHelper.setResearchAspects(
                "ICHORIUM",
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("fabrico"), 15)
                        .add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("lux"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("ICHORIUM", 4);
        ThaumcraftApi.addWarpToResearch("ICHORIUM", 2);
        TCHelper.clearPrereq("ICHORIUM");
        TCHelper.addResearchPrereq("ICHORIUM", "ICHOR", true);
        TCHelper.orphanResearch("CAP_ICHOR");
        TCHelper.removeResearch("CAP_ICHOR");
        new ResearchItem(
                "CAP_ICHOR",
                "TT_CATEGORY",
                new AspectList().add(Aspect.getAspect("cognitio"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("instrumentum"), 6)
                        .add(Aspect.getAspect("terra"), 3),
                11,
                11,
                3,
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 4, missing)).setParents("ICHORIUM").setConcealed()
                        .setPages(new ResearchPage("ttresearch.page.CAP_ICHOR.0")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_ICHOR",
                getModItem(ThaumicTinkerer.ID, "kamiResource", 2, 4, missing),
                new AspectList().add(Aspect.getAspect("aer"), 150).add(Aspect.getAspect("aqua"), 150)
                        .add(Aspect.getAspect("ignis"), 150).add(Aspect.getAspect("terra"), 150)
                        .add(Aspect.getAspect("ordo"), 150).add(Aspect.getAspect("perditio"), 150),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 0, missing),
                'b',
                getModItem(Thaumcraft.ID, "WandCap", 1, 7, missing),
                'c',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 0, missing),
                'd',
                "ringVoid",
                'e',
                "ingotIchorium",
                'f',
                "ringVoid",
                'g',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 0, missing),
                'h',
                getModItem(Thaumcraft.ID, "WandCap", 1, 7, missing),
                'i',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 0, missing));
        TCHelper.addResearchPage(
                "CAP_ICHOR",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 4, missing))));
        TCHelper.setResearchAspects(
                "CAP_ICHOR",
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("instrumentum"), 15)
                        .add(Aspect.getAspect("tenebrae"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("lux"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("CAP_ICHOR", 4);
        ThaumcraftApi.addWarpToResearch("CAP_ICHOR", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CAT_AMULET",
                getModItem(ThaumicTinkerer.ID, "catAmulet", 1, 0, missing),
                8,
                new AspectList().add(Aspect.getAspect("cognitio"), 16).add(Aspect.getAspect("ordo"), 32)
                        .add(Aspect.getAspect("tenebrae"), 16).add(Aspect.getAspect("mortuus"), 16),
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 0, missing),
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 10, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28086, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                        getModItem(Minecraft.ID, "fish", 1, 0, missing), getModItem(Minecraft.ID, "dye", 1, 3, missing),
                        getModItem(Minecraft.ID, "leaves", 1, 3, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28086, missing), });
        TCHelper.setResearchAspects(
                "CAT_AMULET",
                new AspectList().add(Aspect.getAspect("cognitio"), 15).add(Aspect.getAspect("ordo"), 15)
                        .add(Aspect.getAspect("tenebrae"), 12).add(Aspect.getAspect("mortuus"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("CAT_AMULET", 4);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ICHOR_POUCH",
                getModItem(ThaumicTinkerer.ID, "ichorPouch", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("vacuos"), 64).add(Aspect.getAspect("humanus"), 48)
                        .add(Aspect.getAspect("pannus"), 48).add(Aspect.getAspect("alienis"), 48)
                        .add(Aspect.getAspect("aer"), 64),
                getModItem(Thaumcraft.ID, "FocusPouch", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "blockJar", 1, 3, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "FocusPortableHole", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "TrunkSpawner", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30500, missing), });
        TCHelper.setResearchAspects(
                "ICHOR_POUCH",
                new AspectList().add(Aspect.getAspect("vacuos"), 15).add(Aspect.getAspect("pannus"), 15)
                        .add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("humanus"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("aer"), 3));
        TCHelper.setResearchComplexity("ICHOR_POUCH", 4);
        ThaumcraftApi.addWarpToResearch("ICHOR_POUCH", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ICHORCLOTH_ARMOR",
                getModItem(ThaumicTinkerer.ID, "ichorclothHelm", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 75).add(Aspect.getAspect("perditio"), 50)
                        .add(Aspect.getAspect("ordo"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'b',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'c',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'd',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'e',
                "plateOsmiridium",
                'f',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'h',
                "screwOsmiridium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ICHORCLOTH_ARMOR",
                getModItem(ThaumicTinkerer.ID, "ichorclothChest", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("perditio"), 50)
                        .add(Aspect.getAspect("ordo"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'b',
                "screwOsmiridium",
                'c',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'd',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'e',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'f',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'g',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'h',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'i',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ICHORCLOTH_ARMOR",
                getModItem(ThaumicTinkerer.ID, "ichorclothLegs", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("perditio"), 50)
                        .add(Aspect.getAspect("ordo"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'b',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'c',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'd',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'e',
                "plateOsmiridium",
                'f',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'g',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'h',
                "screwOsmiridium",
                'i',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ICHORCLOTH_ARMOR",
                getModItem(ThaumicTinkerer.ID, "ichorclothBoots", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 75).add(Aspect.getAspect("perditio"), 50)
                        .add(Aspect.getAspect("ordo"), 25),
                "abc",
                "def",
                "ghi",
                'd',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'e',
                "plateOsmiridium",
                'f',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'g',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'h',
                "screwOsmiridium",
                'i',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing));
        TCHelper.setResearchAspects(
                "ICHORCLOTH_ARMOR",
                new AspectList().add(Aspect.getAspect("tutamen"), 15).add(Aspect.getAspect("pannus"), 15)
                        .add(Aspect.getAspect("lux"), 12).add(Aspect.getAspect("perfodio"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("ICHORCLOTH_ARMOR", 4);
        ThaumcraftApi.addWarpToResearch("ICHORCLOTH_ARMOR", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ROD_ICHORCLOTH",
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 5, missing),
                10,
                new AspectList().add(Aspect.getAspect("praecantatio"), 150).add(Aspect.getAspect("lux"), 100)
                        .add(Aspect.getAspect("instrumentum"), 100).add(Aspect.getAspect("arbor"), 75)
                        .add(Aspect.getAspect("alienis"), 50),
                getModItem(Thaumcraft.ID, "WandRod", 1, 2, missing),
                new ItemStack[] { getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(Minecraft.ID, "ghast_tear", 1, 0, missing),
                        getModItem(Minecraft.ID, "ghast_tear", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "ROD_ICHORCLOTH",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("pannus"), 15)
                        .add(Aspect.getAspect("lux"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("arbor"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("ROD_ICHORCLOTH", 4);
        ThaumcraftApi.addWarpToResearch("ROD_ICHORCLOTH", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FOCUS_SHADOWBEAM",
                getModItem(ThaumicTinkerer.ID, "focusShadowbeam", 1, 0, missing),
                12,
                new AspectList().add(Aspect.getAspect("alienis"), 64).add(Aspect.getAspect("praecantatio"), 64)
                        .add(Aspect.getAspect("telum"), 64).add(Aspect.getAspect("tenebrae"), 64)
                        .add(Aspect.getAspect("tempestas"), 32),
                getModItem(Thaumcraft.ID, "FocusShock", 1, 0, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(ThaumicTinkerer.ID, "focusDeflect", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 29501, missing),
                        createItemStack(
                                GregTech.ID,
                                "gt.metaitem.02",
                                1,
                                25543,
                                "{ench:[0:{lvl:3s,id:21s}],GT.HasBeenUpdated:1b}",
                                missing),
                        createItemStack(
                                GregTech.ID,
                                "gt.metaitem.02",
                                1,
                                25543,
                                "{ench:[0:{lvl:3s,id:21s}],GT.HasBeenUpdated:1b}",
                                missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 29500, missing),
                        getModItem(Thaumcraft.ID, "FocusExcavation", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "FOCUS_SHADOWBEAM",
                new AspectList().add(Aspect.getAspect("tenebrae"), 15).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("telum"), 9)
                        .add(Aspect.getAspect("tempestas"), 6).add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("FOCUS_SHADOWBEAM", 4);
        ThaumcraftApi.addWarpToResearch("FOCUS_SHADOWBEAM", 4);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FOCUS_XP_DRAIN",
                getModItem(ThaumicTinkerer.ID, "focusXPDrain", 1, 0, missing),
                12,
                new AspectList().add(Aspect.getAspect("auram"), 64).add(Aspect.getAspect("cognitio"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("vitium"), 32),
                getModItem(Minecraft.ID, "experience_bottle", 1, 0, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(ThaumicTinkerer.ID, "enchanter", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 29500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 24532, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 29501, missing),
                        getModItem(ThaumicTinkerer.ID, "xpTalisman", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "FOCUS_XP_DRAIN",
                new AspectList().add(Aspect.getAspect("cognitio"), 15).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("auram"), 12).add(Aspect.getAspect("humanus"), 9)
                        .add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("FOCUS_XP_DRAIN", 4);
        ThaumcraftApi.addWarpToResearch("FOCUS_XP_DRAIN", 4);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ICHORCLOTH_HELM_GEM",
                getModItem(ThaumicTinkerer.ID, "ichorclothHelmGem", 1, 0, missing),
                16,
                new AspectList().add(Aspect.getAspect("aqua"), 64).add(Aspect.getAspect("auram"), 64)
                        .add(Aspect.getAspect("cognitio"), 64).add(Aspect.getAspect("corpus"), 64)
                        .add(Aspect.getAspect("fames"), 64).add(Aspect.getAspect("lux"), 64)
                        .add(Aspect.getAspect("tutamen"), 64),
                getModItem(ThaumicTinkerer.ID, "ichorclothHelm", 1, 0, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(Thaumcraft.ID, "ItemHelmetThaumium", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 24533, missing),
                        getModItem(Thaumcraft.ID, "ItemThaumonomicon", 1, 0, missing),
                        getModItem(Minecraft.ID, "potion", 1, 8262, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(Minecraft.ID, "ghast_tear", 1, 0, missing),
                        getModItem(Minecraft.ID, "fish", 1, 32767, missing),
                        getModItem(Minecraft.ID, "cake", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "FocusPrimal", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemGoggles", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "ICHORCLOTH_HELM_GEM",
                new AspectList().add(Aspect.getAspect("aqua"), 24).add(Aspect.getAspect("sano"), 21)
                        .add(Aspect.getAspect("fames"), 18).add(Aspect.getAspect("auram"), 15)
                        .add(Aspect.getAspect("cognitio"), 12).add(Aspect.getAspect("corpus"), 9)
                        .add(Aspect.getAspect("lux"), 6).add(Aspect.getAspect("tutamen"), 3));
        TCHelper.setResearchComplexity("ICHORCLOTH_HELM_GEM", 4);
        ThaumcraftApi.addWarpToResearch("ICHORCLOTH_HELM_GEM", 4);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ICHORCLOTH_CHEST_GEM",
                getModItem(ThaumicTinkerer.ID, "ichorclothChestGem", 1, 0, missing),
                16,
                new AspectList().add(Aspect.getAspect("aer"), 64).add(Aspect.getAspect("alienis"), 64)
                        .add(Aspect.getAspect("lux"), 64).add(Aspect.getAspect("ordo"), 64)
                        .add(Aspect.getAspect("sensus"), 64).add(Aspect.getAspect("tutamen"), 64)
                        .add(Aspect.getAspect("volatus"), 64),
                getModItem(ThaumicTinkerer.ID, "ichorclothChest", 1, 0, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(Thaumcraft.ID, "ItemChestplateThaumium", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "focusFlight", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemThaumonomicon", 1, 0, missing),
                        createItemStack(
                                GregTech.ID,
                                "gt.metaitem.02",
                                1,
                                25330,
                                "{ench:[0:{lvl:2s,id:21s}],GT.HasBeenUpdated:1b}",
                                missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(Minecraft.ID, "ghast_tear", 1, 0, missing),
                        createItemStack(
                                GregTech.ID,
                                "gt.metaitem.02",
                                1,
                                25330,
                                "{ench:[0:{lvl:2s,id:21s}],GT.HasBeenUpdated:1b}",
                                missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 7, missing),
                        getModItem(ThaumicTinkerer.ID, "focusDeflect", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "HoverHarness", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "ICHORCLOTH_CHEST_GEM",
                new AspectList().add(Aspect.getAspect("aer"), 24).add(Aspect.getAspect("motus"), 21)
                        .add(Aspect.getAspect("volatus"), 18).add(Aspect.getAspect("alienis"), 15)
                        .add(Aspect.getAspect("lux"), 12).add(Aspect.getAspect("sensus"), 9)
                        .add(Aspect.getAspect("ordo"), 6).add(Aspect.getAspect("tutamen"), 3));
        TCHelper.setResearchComplexity("ICHORCLOTH_CHEST_GEM", 4);
        ThaumcraftApi.addWarpToResearch("ICHORCLOTH_CHEST_GEM", 4);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ICHORCLOTH_LEGS_GEM",
                getModItem(ThaumicTinkerer.ID, "ichorclothLegsGem", 1, 0, missing),
                16,
                new AspectList().add(Aspect.getAspect("alienis"), 64).add(Aspect.getAspect("ignis"), 64)
                        .add(Aspect.getAspect("lucrum"), 64).add(Aspect.getAspect("lux"), 64)
                        .add(Aspect.getAspect("potentia"), 64).add(Aspect.getAspect("sano"), 64)
                        .add(Aspect.getAspect("tutamen"), 64),
                getModItem(ThaumicTinkerer.ID, "ichorclothLegs", 1, 0, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(Thaumcraft.ID, "ItemLeggingsThaumium", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "focusSmelt", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemThaumonomicon", 1, 0, missing),
                        getModItem(Minecraft.ID, "potion", 1, 8259, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(ThaumicTinkerer.ID, "brightNitor", 1, 0, missing),
                        getModItem(Minecraft.ID, "fire_charge", 1, 0, missing),
                        getModItem(Minecraft.ID, "blaze_rod", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "FocusPrimal", 1, 0, missing),
                        getModItem(Minecraft.ID, "lava_bucket", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "ICHORCLOTH_LEGS_GEM",
                new AspectList().add(Aspect.getAspect("ignis"), 24).add(Aspect.getAspect("sano"), 21)
                        .add(Aspect.getAspect("lucrum"), 18).add(Aspect.getAspect("potentia"), 15)
                        .add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("aer"), 9)
                        .add(Aspect.getAspect("lux"), 6).add(Aspect.getAspect("tutamen"), 3));
        TCHelper.setResearchComplexity("ICHORCLOTH_LEGS_GEM", 4);
        ThaumcraftApi.addWarpToResearch("ICHORCLOTH_LEGS_GEM", 4);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ICHORCLOTH_BOOTS_GEM",
                getModItem(ThaumicTinkerer.ID, "ichorclothBootsGem", 1, 0, missing),
                16,
                new AspectList().add(Aspect.getAspect("herba"), 64).add(Aspect.getAspect("iter"), 64)
                        .add(Aspect.getAspect("lux"), 64).add(Aspect.getAspect("motus"), 64)
                        .add(Aspect.getAspect("perfodio"), 64).add(Aspect.getAspect("terra"), 64)
                        .add(Aspect.getAspect("tutamen"), 64),
                getModItem(ThaumicTinkerer.ID, "ichorclothBoots", 1, 0, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(Thaumcraft.ID, "ItemBootsThaumium", 1, 0, missing),
                        createItemStack(
                                ThaumicTinkerer.ID,
                                "infusedSeeds",
                                1,
                                0,
                                "{mainAspect:{Aspects:[0:{amount:1,key:\"terra\"}]}}",
                                missing),
                        getModItem(Thaumcraft.ID, "ItemThaumonomicon", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 8, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 5, missing),
                        getModItem(Minecraft.ID, "lead", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "FocusPrimal", 1, 0, missing),
                        getModItem(Minecraft.ID, "grass", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "ICHORCLOTH_BOOTS_GEM",
                new AspectList().add(Aspect.getAspect("terra"), 24).add(Aspect.getAspect("iter"), 21)
                        .add(Aspect.getAspect("perfodio"), 18).add(Aspect.getAspect("herba"), 15)
                        .add(Aspect.getAspect("lux"), 12).add(Aspect.getAspect("motus"), 9)
                        .add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("tutamen"), 3));
        TCHelper.setResearchComplexity("ICHORCLOTH_BOOTS_GEM", 4);
        ThaumcraftApi.addWarpToResearch("ICHORCLOTH_BOOTS_GEM", 4);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "WARP_GATE",
                getModItem(ThaumicTinkerer.ID, "warpGate", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("alienis"), 64).add(Aspect.getAspect("iter"), 72)
                        .add(Aspect.getAspect("volatus"), 64).add(Aspect.getAspect("terra"), 32)
                        .add(Aspect.getAspect("aer"), 32),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 2, missing),
                new ItemStack[] { getModItem(ThaumicTinkerer.ID, "dislocator", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 7, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 7, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30500, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "WARP_GATE",
                getModItem(ThaumicTinkerer.ID, "skyPearl", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("aer"), 24).add(Aspect.getAspect("alienis"), 32)
                        .add(Aspect.getAspect("volatus"), 32).add(Aspect.getAspect("iter"), 32)
                        .add(Aspect.getAspect("vitreus"), 24),
                getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing),
                new ItemStack[] { getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 8, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 7, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 7, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30500, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing), });
        TCHelper.setResearchAspects(
                "WARP_GATE",
                new AspectList().add(Aspect.getAspect("iter"), 18).add(Aspect.getAspect("volatus"), 15)
                        .add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("machina"), 9)
                        .add(Aspect.getAspect("vitreus"), 6).add(Aspect.getAspect("aer"), 3));
        TCHelper.setResearchComplexity("WARP_GATE", 4);
        ThaumcraftApi.addWarpToResearch("WARP_GATE", 4);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FOCUS_RECALL",
                getModItem(ThaumicTinkerer.ID, "focusRecall", 1, 0, missing),
                14,
                new AspectList().add(Aspect.getAspect("alienis"), 64).add(Aspect.getAspect("iter"), 128)
                        .add(Aspect.getAspect("praecantatio"), 96).add(Aspect.getAspect("volatus"), 48)
                        .add(Aspect.getAspect("aer"), 32),
                getModItem(ThaumicTinkerer.ID, "focusEnderChest", 1, 0, missing),
                new ItemStack[] { getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "skyPearl", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30500, missing),
                        getModItem(ThaumicTinkerer.ID, "skyPearl", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "FOCUS_RECALL",
                new AspectList().add(Aspect.getAspect("iter"), 18).add(Aspect.getAspect("alienis"), 15)
                        .add(Aspect.getAspect("volatus"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("FOCUS_RECALL", 4);
        ThaumcraftApi.addWarpToResearch("FOCUS_RECALL", 4);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ICHOR_TOOLS",
                getModItem(ThaumicTinkerer.ID, "ichorPick", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("perditio"), 50)
                        .add(Aspect.getAspect("ordo"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                "ingotIchorium",
                'b',
                "ingotIchorium",
                'c',
                "ingotIchorium",
                'd',
                "plateOsmiridium",
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 2, missing),
                'f',
                "plateOsmiridium",
                'g',
                "screwOsmiridium",
                'h',
                getModItem(Thaumcraft.ID, "WandRod", 1, 2, missing),
                'i',
                "screwOsmiridium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ICHOR_TOOLS",
                getModItem(ThaumicTinkerer.ID, "ichorShovel", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 75).add(Aspect.getAspect("perditio"), 50)
                        .add(Aspect.getAspect("ordo"), 25),
                "abc",
                "def",
                "ghi",
                'b',
                "ingotIchorium",
                'd',
                "plateOsmiridium",
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 2, missing),
                'f',
                "plateOsmiridium",
                'g',
                "screwOsmiridium",
                'h',
                getModItem(Thaumcraft.ID, "WandRod", 1, 2, missing),
                'i',
                "screwOsmiridium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ICHOR_TOOLS",
                getModItem(ThaumicTinkerer.ID, "ichorAxe", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 75).add(Aspect.getAspect("perditio"), 50)
                        .add(Aspect.getAspect("ordo"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                "ingotIchorium",
                'b',
                "ingotIchorium",
                'c',
                "plateOsmiridium",
                'd',
                "ingotIchorium",
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 2, missing),
                'f',
                "screwOsmiridium",
                'g',
                "plateOsmiridium",
                'h',
                getModItem(Thaumcraft.ID, "WandRod", 1, 2, missing),
                'i',
                "screwOsmiridium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ICHOR_TOOLS",
                getModItem(ThaumicTinkerer.ID, "ichorSword", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("perditio"), 50)
                        .add(Aspect.getAspect("ordo"), 25),
                "abc",
                "def",
                "ghi",
                'b',
                "ingotIchorium",
                'd',
                "plateOsmiridium",
                'e',
                "ingotIchorium",
                'f',
                "plateOsmiridium",
                'g',
                "screwOsmiridium",
                'h',
                getModItem(Thaumcraft.ID, "WandRod", 1, 2, missing),
                'i',
                "screwOsmiridium");
        TCHelper.setResearchAspects(
                "ICHOR_TOOLS",
                new AspectList().add(Aspect.getAspect("instrumentum"), 18).add(Aspect.getAspect("telum"), 15)
                        .add(Aspect.getAspect("metallum"), 12).add(Aspect.getAspect("fabrico"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("ICHOR_TOOLS", 4);
        ThaumcraftApi.addWarpToResearch("ICHOR_TOOLS", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ICHOR_PICK_GEM",
                getModItem(ThaumicTinkerer.ID, "ichorPickGem", 1, 0, missing),
                18,
                new AspectList().add(Aspect.getAspect("ignis"), 64).add(Aspect.getAspect("lucrum"), 64)
                        .add(Aspect.getAspect("metallum"), 64).add(Aspect.getAspect("meto"), 64)
                        .add(Aspect.getAspect("messis"), 64).add(Aspect.getAspect("perfodio"), 64)
                        .add(Aspect.getAspect("terra"), 64).add(Aspect.getAspect("sensus"), 64),
                getModItem(ThaumicTinkerer.ID, "ichorPick", 1, 0, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(Thaumcraft.ID, "ItemPickaxeElemental", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "FocusFire", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 9, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30500, missing),
                        getModItem(IndustrialCraft2.ID, "blockITNT", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 9, missing),
                        getModItem(Thaumcraft.ID, "FocusFire", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemPickaxeElemental", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "ICHOR_PICK_GEM",
                new AspectList().add(Aspect.getAspect("ignis"), 24).add(Aspect.getAspect("lucrum"), 21)
                        .add(Aspect.getAspect("metallum"), 18).add(Aspect.getAspect("meto"), 15)
                        .add(Aspect.getAspect("messis"), 12).add(Aspect.getAspect("perfodio"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("sensus"), 3));
        TCHelper.setResearchComplexity("ICHOR_PICK_GEM", 4);
        ThaumcraftApi.addWarpToResearch("ICHOR_PICK_GEM", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ICHOR_SHOVEL_GEM",
                getModItem(ThaumicTinkerer.ID, "ichorShovelGem", 1, 0, missing),
                18,
                new AspectList().add(Aspect.getAspect("instrumentum"), 64).add(Aspect.getAspect("meto"), 64)
                        .add(Aspect.getAspect("perfodio"), 64).add(Aspect.getAspect("sensus"), 64)
                        .add(Aspect.getAspect("terra"), 64).add(Aspect.getAspect("vinculum"), 64)
                        .add(Aspect.getAspect("ordo"), 64),
                getModItem(ThaumicTinkerer.ID, "ichorShovel", 1, 0, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(Thaumcraft.ID, "ItemShovelElemental", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "FocusExcavation", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32642, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30500, missing),
                        getModItem(IndustrialCraft2.ID, "blockITNT", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32642, missing),
                        getModItem(Thaumcraft.ID, "FocusExcavation", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemShovelElemental", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "ICHOR_SHOVEL_GEM",
                new AspectList().add(Aspect.getAspect("instrumentum"), 21).add(Aspect.getAspect("meto"), 18)
                        .add(Aspect.getAspect("perfodio"), 15).add(Aspect.getAspect("sensus"), 12)
                        .add(Aspect.getAspect("terra"), 9).add(Aspect.getAspect("vinculum"), 6)
                        .add(Aspect.getAspect("ordo"), 3));
        TCHelper.setResearchComplexity("ICHOR_SHOVEL_GEM", 4);
        ThaumcraftApi.addWarpToResearch("ICHOR_SHOVEL_GEM", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ICHOR_AXE_GEM",
                getModItem(ThaumicTinkerer.ID, "ichorAxeGem", 1, 0, missing),
                18,
                new AspectList().add(Aspect.getAspect("aqua"), 64).add(Aspect.getAspect("arbor"), 64)
                        .add(Aspect.getAspect("instrumentum"), 64).add(Aspect.getAspect("messis"), 64)
                        .add(Aspect.getAspect("meto"), 64).add(Aspect.getAspect("perfodio"), 64)
                        .add(Aspect.getAspect("sensus"), 64),
                getModItem(ThaumicTinkerer.ID, "ichorAxe", 1, 0, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(Thaumcraft.ID, "ItemAxeElemental", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "FocusExcavation", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32721, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30500, missing),
                        getModItem(IndustrialCraft2.ID, "blockITNT", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32721, missing),
                        getModItem(Thaumcraft.ID, "FocusExcavation", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemAxeElemental", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "ICHOR_AXE_GEM",
                new AspectList().add(Aspect.getAspect("aqua"), 21).add(Aspect.getAspect("arbor"), 18)
                        .add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("messis"), 12)
                        .add(Aspect.getAspect("meto"), 9).add(Aspect.getAspect("perfodio"), 6)
                        .add(Aspect.getAspect("sensus"), 3));
        TCHelper.setResearchComplexity("ICHOR_AXE_GEM", 4);
        ThaumcraftApi.addWarpToResearch("ICHOR_AXE_GEM", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ICHOR_SWORD_GEM",
                getModItem(ThaumicTinkerer.ID, "ichorSwordGem", 1, 0, missing),
                18,
                new AspectList().add(Aspect.getAspect("aer"), 64).add(Aspect.getAspect("fames"), 64)
                        .add(Aspect.getAspect("ordo"), 64).add(Aspect.getAspect("potentia"), 64)
                        .add(Aspect.getAspect("spiritus"), 64).add(Aspect.getAspect("telum"), 64)
                        .add(Aspect.getAspect("vitreus"), 64),
                getModItem(ThaumicTinkerer.ID, "ichorSword", 1, 0, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(Thaumcraft.ID, "ItemSwordElemental", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "FocusFrost", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "spike_base_diamond", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30500, missing),
                        getModItem(IndustrialCraft2.ID, "blockITNT", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "spike_base_diamond", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "FocusFrost", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemSwordElemental", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "ICHOR_SWORD_GEM",
                new AspectList().add(Aspect.getAspect("aer"), 21).add(Aspect.getAspect("fames"), 18)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("spiritus"), 9).add(Aspect.getAspect("telum"), 6)
                        .add(Aspect.getAspect("vitreus"), 3));
        TCHelper.setResearchComplexity("ICHOR_SWORD_GEM", 4);
        ThaumcraftApi.addWarpToResearch("ICHOR_SWORD_GEM", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "PROTOCLAY",
                getModItem(ThaumicTinkerer.ID, "protoclay", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("instrumentum"), 32).add(Aspect.getAspect("perfodio"), 32)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("aer"), 16),
                getModItem(Minecraft.ID, "clay_ball", 1, 0, missing),
                new ItemStack[] { getModItem(Minecraft.ID, "stone", 1, 0, missing),
                        getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 7, missing),
                        getModItem(Minecraft.ID, "sand", 1, 32767, missing),
                        getModItem(Minecraft.ID, "cobblestone", 1, 0, missing),
                        getModItem(Minecraft.ID, "log", 1, 32767, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        getModItem(Minecraft.ID, "grass", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "PROTOCLAY",
                new AspectList().add(Aspect.getAspect("instrumentum"), 18).add(Aspect.getAspect("humanus"), 15)
                        .add(Aspect.getAspect("machina"), 12).add(Aspect.getAspect("perfodio"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("aer"), 3));
        TCHelper.setResearchComplexity("PROTOCLAY", 4);
        ThaumcraftApi.addWarpToResearch("PROTOCLAY", 1);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "BLOCK_TALISMAN",
                getModItem(ThaumicTinkerer.ID, "blockTalisman", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("alienis"), 64).add(Aspect.getAspect("praecantatio"), 64)
                        .add(Aspect.getAspect("vacuos"), 72).add(Aspect.getAspect("tenebrae"), 48)
                        .add(Aspect.getAspect("spiritus"), 32),
                getModItem(Thaumcraft.ID, "FocusPortableHole", 1, 0, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30500, missing),
                        getModItem(EnderStorage.ID, "enderChest", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 11, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 11, missing),
                        getModItem(Thaumcraft.ID, "blockJar", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30501, missing), });
        TCHelper.setResearchAspects(
                "BLOCK_TALISMAN",
                new AspectList().add(Aspect.getAspect("vacuos"), 15).add(Aspect.getAspect("tenebrae"), 12)
                        .add(Aspect.getAspect("alienis"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("spiritus"), 3));
        TCHelper.setResearchComplexity("BLOCK_TALISMAN", 4);
        ThaumcraftApi.addWarpToResearch("BLOCK_TALISMAN", 6);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "PLACEMENT_MIRROR",
                getModItem(ThaumicTinkerer.ID, "placementMirror", 1, 0, missing),
                16,
                new AspectList().add(Aspect.getAspect("cognitio"), 64).add(Aspect.getAspect("fabrico"), 72)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("vitreus"), 48)
                        .add(Aspect.getAspect("alienis"), 32),
                getModItem(ThaumicTinkerer.ID, "blockTalisman", 1, 0, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30500, missing),
                        getModItem(Minecraft.ID, "dropper", 1, 0, missing),
                        getModItem(Minecraft.ID, "blaze_rod", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(Minecraft.ID, "blaze_rod", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockMirror", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30501, missing), });
        TCHelper.setResearchAspects(
                "PLACEMENT_MIRROR",
                new AspectList().add(Aspect.getAspect("cognitio"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("vitreus"), 6)
                        .add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("PLACEMENT_MIRROR", 4);
        ThaumcraftApi.addWarpToResearch("PLACEMENT_MIRROR", 8);
        TCHelper.refreshResearchPages("ICHOR");
        TCHelper.refreshResearchPages("ICHOR_CLOTH");
        TCHelper.refreshResearchPages("ICHORIUM");
        TCHelper.refreshResearchPages("CAT_AMULET");
        TCHelper.refreshResearchPages("ICHOR_POUCH");
        TCHelper.refreshResearchPages("ICHORCLOTH_ARMOR");
        TCHelper.refreshResearchPages("ROD_ICHORCLOTH");
        TCHelper.refreshResearchPages("FOCUS_SHADOWBEAM");
        TCHelper.refreshResearchPages("FOCUS_XP_DRAIN");
        TCHelper.refreshResearchPages("ICHORCLOTH_HELM_GEM");
        TCHelper.refreshResearchPages("ICHORCLOTH_CHEST_GEM");
        TCHelper.refreshResearchPages("ICHORCLOTH_LEGS_GEM");
        TCHelper.refreshResearchPages("ICHORCLOTH_BOOTS_GEM");
        TCHelper.refreshResearchPages("WARP_GATE");
        TCHelper.refreshResearchPages("FOCUS_RECALL");
        TCHelper.refreshResearchPages("ICHOR_TOOLS");
        TCHelper.refreshResearchPages("ICHOR_PICK_GEM");
        TCHelper.refreshResearchPages("ICHOR_SHOVEL_GEM");
        TCHelper.refreshResearchPages("ICHOR_AXE_GEM");
        TCHelper.refreshResearchPages("ICHOR_SWORD_GEM");
        TCHelper.refreshResearchPages("PROTOCLAY");
        TCHelper.refreshResearchPages("BLOCK_TALISMAN");
        TCHelper.refreshResearchPages("PLACEMENT_MIRROR");

    }
}
