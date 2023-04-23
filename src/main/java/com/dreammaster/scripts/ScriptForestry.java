package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

import com.dreammaster.thaumcraft.TCHelper;
import gregtech.api.enums.Mods;

public class ScriptForestry implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Forestry";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.Forestry.ID, Mods.Thaumcraft.ID, Mods.MagicBees.ID);
    }

    @Override
    public void loadRecipes() {
        new ResearchItem(
                "PROVENFRAME",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("potentia"), 6),
                7,
                0,
                3,
                getModItem("Forestry", "frameProven", 1, 0, missing)).setParents("MB_EssenceArmor").setConcealed()
                        .setPages(new ResearchPage("Forestry.research_page.PROVENFRAME")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "PROVENFRAME",
                getModItem("Forestry", "frameProven", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("perditio"), 15)
                        .add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("aqua"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem("Forestry", "honeydew", 1, 0, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem("Forestry", "propolis", 1, 0, missing),
                'e',
                getModItem("Forestry", "frameImpregnated", 1, 0, missing),
                'f',
                getModItem("Forestry", "propolis", 1, 3, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem("Forestry", "royalJelly", 1, 0, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing));
        TCHelper.addResearchPage(
                "PROVENFRAME",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Forestry", "frameProven", 1, 0, missing))));
        new ResearchItem(
                "PROVENGRAFTER",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("permutatio"), 12)
                        .add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("arbor"), 6),
                -5,
                -3,
                3,
                getModItem("Forestry", "grafterProven", 1, 0, missing)).setParents("MB_Scoop").setConcealed()
                        .setPages(new ResearchPage("Forestry.research_page.PROVENGRAFTER")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "PROVENGRAFTER",
                getModItem("Forestry", "grafterProven", 1, 0, missing),
                3,
                new AspectList().add(Aspect.getAspect("instrumentum"), 25).add(Aspect.getAspect("permutatio"), 25)
                        .add(Aspect.getAspect("metallum"), 20).add(Aspect.getAspect("arbor"), 10),
                getModItem("Forestry", "grafter", 1, 0, missing),
                new ItemStack[] { getModItem("minecraft", "sapling", 1, 1, missing),
                        getModItem("minecraft", "sapling", 1, 2, missing),
                        getModItem("Forestry", "pollen", 1, 0, missing),
                        getModItem("minecraft", "sapling", 1, 3, missing),
                        getModItem("minecraft", "sapling", 1, 4, missing),
                        getModItem("minecraft", "sapling", 1, 5, missing),
                        getModItem("Forestry", "pollen", 1, 1, missing),
                        getModItem("minecraft", "sapling", 1, 0, missing), });
        TCHelper.addResearchPage(
                "PROVENGRAFTER",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("Forestry", "grafterProven", 1, 0, missing))));
    }
}
