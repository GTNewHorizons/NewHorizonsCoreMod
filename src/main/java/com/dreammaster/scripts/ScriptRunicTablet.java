package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Automagy;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicExploration;

import java.util.Arrays;
import java.util.List;

import com.dreammaster.thaumcraft.TCHelper;

import fox.spiteful.forbidden.DarkAspects;
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
        return Arrays.asList(Automagy.ID, DraconicEvolution.ID, Thaumcraft.ID, ThaumicExploration.ID);
    }

    @Override
    public void loadRecipes() {
        new ResearchItem(
                "RUNEDTABLET",
                "ELDRITCH",
                new AspectList().add(Aspect.ELDRITCH, 30).add(Aspect.MAGIC, 24).add(DarkAspects.PRIDE, 18)
                        .add(Aspect.SOUL, 12).add(DarkAspects.NETHER, 6),
                -5,
                0,
                3,
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 2)).setParents("OCULUS").setSiblings("OCULUS")
                        .setConcealed().setPages(new ResearchPage("kosh.research_page.RUNEDTABLET"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "RUNEDTABLET",
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 2),
                10,
                new AspectList().add(Aspect.ELDRITCH, 64).add(Aspect.TRAVEL, 32).add(Aspect.DARKNESS, 32)
                        .add(Aspect.VOID, 32).add(Aspect.MIND, 64).add(Aspect.MAGIC, 128),
                getModItem(DraconicEvolution.ID, "infoTablet", 1, 0),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 17),
                getModItem(ThaumicExploration.ID, "pureZombieBrain", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 17),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 17),
                getModItem(Automagy.ID, "crystalBrain", 1, 3),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 17));
        TCHelper.addResearchPage(
                "RUNEDTABLET",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 2))));
        ThaumcraftApi.addWarpToResearch("RUNEDTABLET", 5);
    }
}
