package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.*;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.GT_Values;
import gregtech.api.util.GT_Utility;

public class ScriptOpenBlocks implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "OpenBlocks";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(OpenBlocks.ID, RandomThings.ID, ExtraUtilities.ID, Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {
        ItemStack devNull = getModItem(OpenBlocks.ID, "devnull", 1);
        ItemStack voidDropFilter = getModItem(RandomThings.ID, "dropFilter", 1, 1);
        ItemStack trashCan = getModItem(ExtraUtilities.ID, "trashcan", 1);
        ItemStack circuit2 = GT_Utility.getIntegratedCircuit(2);

        FluidStack ender250 = FluidRegistry.getFluidStack("ender", 250);

        addShapelessCraftingRecipe(devNull, new Object[] { voidDropFilter });

        GT_Values.RA.addAssemblerRecipe(new ItemStack[] { trashCan, circuit2 }, ender250, devNull, 300, 30);

        new ResearchItem(
                "GOLDENEGG",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("bestia"), 12)
                        .add(Aspect.getAspect("victus"), 9).add(Aspect.getAspect("humanus"), 6),
                -4,
                5,
                3,
                getModItem("OpenBlocks", "goldenegg", 1, 0, missing)).setParents("MB_DimensionalSingularity")
                        .setConcealed().setPages(new ResearchPage("OpenBlocks.research_page.GOLDENEGG"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "GOLDENEGG",
                getModItem("OpenBlocks", "goldenegg", 1, 0, missing),
                2,
                new AspectList().add(Aspect.getAspect("alienis"), 75).add(Aspect.getAspect("bestia"), 50)
                        .add(Aspect.getAspect("victus"), 50).add(Aspect.getAspect("humanus"), 25),
                getModItem("minecraft", "egg", 1, 0, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 22086, missing),
                        getModItem("minecraft", "skull", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 22086, missing),
                        getModItem("minecraft", "skull", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 22086, missing),
                        getModItem("minecraft", "skull", 1, 3, missing), });
        TCHelper.addResearchPage(
                "GOLDENEGG",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("OpenBlocks", "goldenegg", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("GOLDENEGG", 2);
    }
}
