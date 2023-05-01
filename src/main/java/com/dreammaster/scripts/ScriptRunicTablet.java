package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Automagy;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicExploration;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.Mods;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptRunicTablet implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Runic Tablet";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays
                .asList(Mods.Thaumcraft.ID, Mods.DraconicEvolution.ID, Mods.ThaumicExploration.ID, Mods.Automagy.ID);
    }

    @Override
    public void loadRecipes() {
        new ResearchItem(
                "RUNEDTABLET",
                "ELDRITCH",
                new AspectList().add(Aspect.getAspect("alienis"), 30).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("superbia"), 18).add(Aspect.getAspect("spiritus"), 12)
                        .add(Aspect.getAspect("infernus"), 6),
                -5,
                0,
                3,
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 2, missing)).setParents("OCULUS")
                        .setSiblings("OCULUS").setConcealed()
                        .setPages(new ResearchPage("kosh.research_page.RUNEDTABLET")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNEDTABLET",
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 2, missing),
                10,
                new AspectList().add(Aspect.getAspect("alienis"), 64).add(Aspect.getAspect("iter"), 32)
                        .add(Aspect.getAspect("tenebrae"), 32).add(Aspect.getAspect("vacuos"), 32)
                        .add(Aspect.getAspect("cognitio"), 64).add(Aspect.getAspect("praecantatio"), 128),
                getModItem(DraconicEvolution.ID, "infoTablet", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 17, missing),
                        getModItem(ThaumicExploration.ID, "pureZombieBrain", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 17, missing),
                        getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 17, missing),
                        getModItem(Automagy.ID, "crystalBrain", 1, 3, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 17, missing), });
        TCHelper.addResearchPage(
                "RUNEDTABLET",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 2, missing))));
        ThaumcraftApi.addWarpToResearch("RUNEDTABLET", 5);
    }
}
