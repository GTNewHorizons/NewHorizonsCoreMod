package com.dreammaster.scripts;

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

public class ScriptExtraUtilities implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "ExtraUtilities";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Mods.ExtraUtilities.ID,
                Mods.Thaumcraft.ID,
                Mods.ProjectRedIllumination.ID,
                Mods.TinkerConstruct.ID,
                Mods.Avaritia.ID,
                Mods.GTPlusPlus.ID,
                Mods.TwilightForest.ID,
                Mods.Botania.ID);
    }

    @Override
    public void loadRecipes() {
        ThaumcraftApi.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem("ExtraUtilities", "angelRing", 1, 0, missing),
                30,
                new AspectList().add(Aspect.getAspect("praecantatio"), 200).add(Aspect.getAspect("volatus"), 200)
                        .add(Aspect.getAspect("tempestas"), 200).add(Aspect.getAspect("nebrisum"), 200)
                        .add(Aspect.getAspect("motus"), 200).add(Aspect.getAspect("terminus"), 200),
                createItemStack(
                        "TConstruct",
                        "travelWings",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:2.0d,Built:1b,MaxDefense:8.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}",
                        missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 28084, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27329, missing),
                        getModItem("dreamcraft", "item.EngravedGoldChip", 1, 0, missing),
                        getModItem("ExtraUtilities", "angelBlock", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                        getModItem("miscutils", "magicfeather", 1, 0, missing),
                        getModItem("minecraft", "nether_star", 1, 0, missing),
                        getModItem("Avaritia", "big_pearl", 1, 0, missing),
                        getModItem("minecraft", "nether_star", 1, 0, missing),
                        getModItem("miscutils", "magicfeather", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                        getModItem("ExtraUtilities", "angelBlock", 1, 0, missing),
                        getModItem("dreamcraft", "item.EngravedGoldChip", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27329, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem("ExtraUtilities", "angelRing", 1, 1, missing),
                4,
                new AspectList().add(Aspect.getAspect("permutatio"), 50).add(Aspect.getAspect("volatus"), 50)
                        .add(Aspect.getAspect("aer"), 50),
                getModItem("ExtraUtilities", "angelRing", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("TConstruct", "fletching", 1, 0, missing),
                        getModItem("TConstruct", "fletching", 1, 0, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem("ExtraUtilities", "angelRing", 1, 2, missing),
                4,
                new AspectList().add(Aspect.getAspect("permutatio"), 50).add(Aspect.getAspect("volatus"), 50)
                        .add(Aspect.getAspect("auram"), 50),
                getModItem("ExtraUtilities", "angelRing", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("TwilightForest", "tile.TFCicada", 1, 0, missing),
                        getModItem("TwilightForest", "tile.TFFirefly", 1, 0, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem("ExtraUtilities", "angelRing", 1, 3, missing),
                4,
                new AspectList().add(Aspect.getAspect("permutatio"), 50).add(Aspect.getAspect("bestia"), 50)
                        .add(Aspect.getAspect("infernus"), 50),
                getModItem("ExtraUtilities", "angelRing", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("minecraft", "dragon_egg", 1, 0, missing),
                        getModItem("Botania", "manaResource", 1, 9, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem("ExtraUtilities", "angelRing", 1, 4, missing),
                4,
                new AspectList().add(Aspect.getAspect("permutatio"), 50).add(Aspect.getAspect("metallum"), 50)
                        .add(Aspect.getAspect("lucrum"), 50),
                getModItem("ExtraUtilities", "angelRing", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 29351, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 29351, missing), });
        new ResearchItem(
                "EXURINGS",
                "ARTIFICE",
                new AspectList().add(Aspect.getAspect("praecantatio"), 10).add(Aspect.getAspect("volatus"), 10)
                        .add(Aspect.getAspect("tempestas"), 100).add(Aspect.getAspect("nebrisum"), 10)
                        .add(Aspect.getAspect("motus"), 10).add(Aspect.getAspect("terminus"), 10),
                1,
                -5,
                3,
                getModItem("TConstruct", "travelWings", 1, 0, missing)).setRound().setConcealed()
                        .setParentsHidden("INFUSION")
                        .setPages(
                                new ResearchPage("tc.research_page.EXURINGS.1"),
                                new ResearchPage("tc.research_page.EXURINGS.2"),
                                new ResearchPage("tc.research_page.EXURINGS.3"),
                                new ResearchPage("tc.research_page.EXURINGS.4"),
                                new ResearchPage("tc.research_page.EXURINGS.5"),
                                new ResearchPage("tc.research_page.EXURINGS.6"))
                        .registerResearchItem();
        new ResearchItem(
                "EXURINGS_CRAFTING",
                "ARTIFICE",
                new AspectList().add(Aspect.getAspect("praecantatio"), 10).add(Aspect.getAspect("volatus"), 10)
                        .add(Aspect.getAspect("tempestas"), 10).add(Aspect.getAspect("nebrisum"), 10)
                        .add(Aspect.getAspect("motus"), 10).add(Aspect.getAspect("terminus"), 10),
                -1,
                -5,
                3,
                getModItem("ExtraUtilities", "angelRing", 1, 0, missing)).setParents("EXURINGS").setConcealed()
                        .registerResearchItem();
        ThaumcraftApi.addWarpToResearch("EXURINGS_CRAFTING", 16);
        TCHelper.addResearchPage("EXURINGS_CRAFTING", new ResearchPage("tc.research_page.EXURINGS_CRAFTING.1"));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("ExtraUtilities", "angelRing", 1, 0, missing))));
        TCHelper.addResearchPage("EXURINGS_CRAFTING", new ResearchPage("tc.research_page.EXURINGS_CRAFTING.2"));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("ExtraUtilities", "angelRing", 1, 1, missing))));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("ExtraUtilities", "angelRing", 1, 2, missing))));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("ExtraUtilities", "angelRing", 1, 3, missing))));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("ExtraUtilities", "angelRing", 1, 4, missing))));
    }
}
