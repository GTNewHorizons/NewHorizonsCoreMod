package com.dreammaster.thaumcraft;

import static gregtech.api.util.GT_ModHandler.getModItem;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

import com.dreammaster.lib.Refstrings;

public class TCLoader {

    public static final String category = "NEWHORIZONS";

    public static void run() {
        ResearchCategories.registerCategory(
                category,
                new ResourceLocation(Refstrings.MODID, "textures/thaumcraft/icon/icon_GTNH.png"),
                new ResourceLocation(Refstrings.MODID, "textures/thaumcraft/tab/tab_GTNH.png"));
        registerResearch();
    }

    private static void registerResearch() {
        ItemStack missing = new ItemStack(Blocks.dirt);

        // --- Wither Ring
        {
            InfusionRecipe recipe = ThaumcraftApi.addInfusionCraftingRecipe(
                    "WITHERRING",
                    getModItem("dreamcraft", "item.WitherProtectionRing", 1, missing),
                    3,
                    new AspectList().add(Aspect.getAspect("alienis"), 45).add(Aspect.getAspect("praecantatio"), 35)
                            .add(Aspect.getAspect("spiritus"), 30).add(Aspect.getAspect("superbia"), 25)
                            .add(Aspect.getAspect("infernus"), 15),
                    getModItem("Thaumcraft", "ItemBaubleBlanks", 1, 1, missing),
                    new ItemStack[] { getModItem("minecraft", "nether_star", 1, missing),
                            getModItem("minecraft", "milk_bucket", 1, missing),
                            getModItem("minecraft", "skull", 1, 1, missing),
                            getModItem("minecraft", "milk_bucket", 1, missing),
                            getModItem("minecraft", "skull", 1, 1, missing) });
            ResearchItem research = new ResearchItem(
                    "WITHERRING",
                    "ARTIFICE",
                    new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                            .add(Aspect.getAspect("superbia"), 9).add(Aspect.getAspect("spiritus"), 6)
                            .add(Aspect.getAspect("infernus"), 3),
                    3,
                    2,
                    4,
                    getModItem("dreamcraft", "item.WitherProtectionRing", 1, missing))
                            .setPages(
                                    new ResearchPage("NewHorizons.research_page.WITHERRING"),
                                    new ResearchPage(recipe))
                            .setParents("RUNICARMOR").setSiblings("RUNICARMOR").setConcealed();
            ThaumcraftApi.addWarpToResearch("WITHERRING", 2);
            ResearchCategories.addResearch(research);
        }
    }
}
