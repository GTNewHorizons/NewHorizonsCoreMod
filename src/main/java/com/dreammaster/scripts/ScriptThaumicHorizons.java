package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import com.dreammaster.thaumcraft.TCHelper;
import gregtech.api.enums.Mods;

public class ScriptThaumicHorizons implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Thaumic Horizons";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.ThaumicHorizons.ID, Mods.Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {
        TCHelper.removeArcaneRecipe(getModItem("ThaumicHorizons", "planarConduit", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("ThaumicHorizons", "transductionAmplifier", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("ThaumicHorizons", "vortexStabilizer", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("ThaumicHorizons", "recombinator", 1, 0, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "planarTheory",
                getModItem("ThaumicHorizons", "planarConduit", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                "plateVoid",
                'b',
                "plateEnderEye",
                'c',
                "plateVoid",
                'd',
                "plateEnderEye",
                'e',
                getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                'f',
                "plateEnderEye",
                'g',
                "plateVoid",
                'h',
                "plateEnderEye",
                'i',
                "plateVoid");
        TCHelper.setResearchAspects(
                "planarTheory",
                new AspectList().add(Aspect.getAspect("vacuos"), 18).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("auram"), 9)
                        .add(Aspect.getAspect("perditio"), 6).add(Aspect.getAspect("tenebrae"), 3));
        TCHelper.setResearchComplexity("planarTheory", 4);
        ThaumcraftApi.addWarpToResearch("planarTheory", 1);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "transductionAmplifier",
                getModItem("ThaumicHorizons", "transductionAmplifier", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("ignis"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("aqua"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                getModItem("ThaumicHorizons", "planarConduit", 1, 0, missing),
                'c',
                "screwThaumium",
                'd',
                "gemFlawlessAmber",
                'e',
                getModItem("Thaumcraft", "blockStoneDevice", 1, 11, missing),
                'f',
                "gemFlawlessAmber",
                'g',
                "plateRedstoneAlloy",
                'h',
                getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                'i',
                "plateRedstoneAlloy");
        TCHelper.setResearchAspects(
                "transductionAmplifier",
                new AspectList().add(Aspect.getAspect("auram"), 18).add(Aspect.getAspect("potentia"), 15)
                        .add(Aspect.getAspect("vacuos"), 12).add(Aspect.getAspect("alienis"), 9));
        TCHelper.setResearchComplexity("transductionAmplifier", 4);
        ThaumcraftApi.addWarpToResearch("transductionAmplifier", 2);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "vortexStabilizer",
                getModItem("ThaumicHorizons", "vortexStabilizer", 1, 0, missing),
                7,
                new AspectList().add(Aspect.getAspect("auram"), 64).add(Aspect.getAspect("fames"), 32)
                        .add(Aspect.getAspect("machina"), 48).add(Aspect.getAspect("ordo"), 32)
                        .add(Aspect.getAspect("potentia"), 48).add(Aspect.getAspect("vinculum"), 32),
                getModItem("Thaumcraft", "blockStoneDevice", 1, 10, missing),
                new ItemStack[] { getModItem("ThaumicHorizons", "planarConduit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30514, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 24505, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 24505, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30514, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing), });
        TCHelper.setResearchAspects(
                "vortexStabilizer",
                new AspectList().add(Aspect.getAspect("auram"), 21).add(Aspect.getAspect("fames"), 18)
                        .add(Aspect.getAspect("machina"), 15).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("vinculum"), 6));
        TCHelper.setResearchComplexity("vortexStabilizer", 4);
        ThaumcraftApi.addWarpToResearch("vortexStabilizer", 2);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "recombinator",
                getModItem("ThaumicHorizons", "recombinator", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("permutatio"), 64).add(Aspect.getAspect("auram"), 48)
                        .add(Aspect.getAspect("fabrico"), 32).add(Aspect.getAspect("potentia"), 32)
                        .add(Aspect.getAspect("sensus"), 16).add(Aspect.getAspect("praecantatio"), 24),
                getModItem("Thaumcraft", "ItemEldritchObject", 1, 3, missing),
                new ItemStack[] { getModItem("Thaumcraft", "blockStoneDevice", 1, 11, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30514, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 8, missing),
                        getModItem("ThaumicHorizons", "planarConduit", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30514, missing),
                        getModItem("Thaumcraft", "blockStoneDevice", 1, 10, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30514, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 8, missing),
                        getModItem("ThaumicHorizons", "planarConduit", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30514, missing), });
        TCHelper.setResearchAspects(
                "recombinator",
                new AspectList().add(Aspect.getAspect("auram"), 21).add(Aspect.getAspect("permutatio"), 18)
                        .add(Aspect.getAspect("fabrico"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("sensus"), 6));
        TCHelper.setResearchComplexity("recombinator", 4);
        ThaumcraftApi.addWarpToResearch("recombinator", 3);
        TCHelper.refreshResearchPages("planarTheory");
        TCHelper.refreshResearchPages("transductionAmplifier");
        TCHelper.refreshResearchPages("vortexStabilizer");
        TCHelper.refreshResearchPages("recombinator");
    }
}
