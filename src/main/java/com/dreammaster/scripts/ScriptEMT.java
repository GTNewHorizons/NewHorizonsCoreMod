package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import com.dreammaster.thaumcraft.TCHelper;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptEMT implements IScriptLoader {
    @Override
    public void initScriptData() {}

    @Override
    public void loadRecipes() {
        ItemStack missing = new ItemStack(Blocks.dirt);

        // --- Electro Magic Tools
        {
            TCHelper.removeResearch("Electric Magic Tools");
            ResearchItem research = new ResearchItem(
                            "ElectricMagicTools",
                            "EMT",
                            new AspectList().add(Aspect.getAspect("terra"), 0),
                            0,
                            0,
                            0,
                            getModItem("dreamcraft", "item.EMT", 1, missing))
                    .setPages(new ResearchPage("tc.research_page.ElectricMagicTools"))
                    .setAutoUnlock()
                    .setSpecial();
            ResearchCategories.addResearch(research);
        }

        // --- Diamond Chain Saw
        {
            TCHelper.removeResearch("Diamond Chainsaw");
            ShapedArcaneRecipe recipe = ThaumcraftApi.addArcaneCraftingRecipe(
                    "DiamondChainsaw",
                    getModItem("EMT", "DiamondChainsaw", 1, 27, missing),
                    new AspectList()
                            .add(Aspect.getAspect("aer"), 35)
                            .add(Aspect.getAspect("terra"), 35)
                            .add(Aspect.getAspect("ignis"), 35)
                            .add(Aspect.getAspect("aqua"), 35)
                            .add(Aspect.getAspect("ordo"), 35)
                            .add(Aspect.getAspect("perditio"), 35),
                    "ABA",
                    "CDC",
                    "EFG",
                    'A',
                    "screwTitanium",
                    'B',
                    "toolHeadChainsawThaumium",
                    'C',
                    "plateDiamond",
                    'D',
                    "circuitAdvanced",
                    'E',
                    "craftingToolHardHammer",
                    'F',
                    getModItem("gregtech", "gt.metaitem.01", 1, 32528, missing),
                    'G',
                    "craftingToolWrench");
            ResearchItem research = new ResearchItem(
                            "DiamondChainsaw",
                            "EMT",
                            new AspectList()
                                    .add(Aspect.getAspect("lucrum"), 12)
                                    .add(Aspect.getAspect("ignis"), 9)
                                    .add(Aspect.getAspect("metallum"), 6)
                                    .add(Aspect.getAspect("terra"), 3),
                            0,
                            -2,
                            2,
                            getModItem("EMT", "DiamondChainsaw", 1, 27, missing))
                    .setPages(new ResearchPage("tc.research_page.DiamondChainsaw"), new ResearchPage(recipe))
                    .setParents("ElectricMagicTools")
                    .setRound();
            ResearchCategories.addResearch(research);
        }

        // --- Thaumic Plate
        {
            TCHelper.removeResearch("Thaumium Plate");
            ResearchItem research = new ResearchItem(
                            "ThaumiumPlate",
                            "EMT",
                            new AspectList(),
                            6,
                            -6,
                            0,
                            getModItem("EMT", "EMTItems", 1, 5, missing))
                    .setPages(new ResearchPage("tc.research_page.ThaumiumPlate"))
                    .setRound()
                    .setAutoUnlock();
            ResearchCategories.addResearch(research);
        }

    }
}
