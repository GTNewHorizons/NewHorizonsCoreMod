package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchPage;

import com.dreammaster.thaumcraft.TCHelper;
import gregtech.api.enums.Mods;

public class ScriptRailcraft implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Railcraft";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.Railcraft.ID, Mods.Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {
        ItemStack missing = new ItemStack(Blocks.dirt);

        TCHelper.removeArcaneRecipe(getModItem("Railcraft", "tool.crowbar.magic", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Railcraft", "tool.crowbar.void", 1, 0, missing));
        TCHelper.moveResearch("RC_Crowbar", "ARTIFICE", 0, -4);
        TCHelper.clearPrereq("RC_Crowbar");
        TCHelper.addResearchPrereq("RC_Crowbar", "THAUMIUM", false);
        TCHelper.clearPages("RC_Crowbar");
        TCHelper.addResearchPage("RC_Crowbar", new ResearchPage("thaumcraft.research.RC_Crowbar.page.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RC_Crowbar",
                getModItem("Railcraft", "tool.crowbar.magic", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 24).add(Aspect.getAspect("ignis"), 24)
                        .add(Aspect.getAspect("aer"), 24),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolHardHammer",
                'b',
                "dyeRed",
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 23330, missing),
                'd',
                "dyeRed",
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 23330, missing),
                'f',
                "dyeRed",
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 23330, missing),
                'h',
                "dyeRed",
                'i',
                "craftingToolFile");
        TCHelper.addResearchPage(
                "RC_Crowbar",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("Railcraft", "tool.crowbar.magic", 1, 0, missing))));
        TCHelper.refreshResearchPages("RC_Crowbar");
        TCHelper.moveResearch("RC_Crowbar_Void", "ELDRITCH", 2, -4);
        TCHelper.clearPrereq("RC_Crowbar_Void");
        TCHelper.addResearchPrereq("RC_Crowbar_Void", "VOIDMETAL", false);
        TCHelper.addResearchPrereq("RC_Crowbar_Void", "RC_Crowbar", false);
        TCHelper.clearPages("RC_Crowbar_Void");
        TCHelper.addResearchPage("RC_Crowbar_Void", new ResearchPage("thaumcraft.research.RC_Crowbar_Void.page.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RC_Crowbar_Void",
                getModItem("Railcraft", "tool.crowbar.void", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 50).add(Aspect.getAspect("ignis"), 50)
                        .add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("terra"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolHardHammer",
                'b',
                "dyeRed",
                'c',
                "stickVoid",
                'd',
                "dyeRed",
                'e',
                "stickVoid",
                'f',
                "dyeRed",
                'g',
                "stickVoid",
                'h',
                "dyeRed",
                'i',
                "craftingToolFile");
        TCHelper.addResearchPage(
                "RC_Crowbar_Void",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("Railcraft", "tool.crowbar.void", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("RC_Crowbar_Void", 2);
        TCHelper.refreshResearchPages("RC_Crowbar_Void");
        ResearchCategories.researchCategories.remove("RAILCRAFT");
    }
}
