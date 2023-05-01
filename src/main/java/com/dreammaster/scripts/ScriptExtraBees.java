package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.ExtraBees;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.MagicBees;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sFluidExtractionRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.forestry.ForestryHelper;
import com.dreammaster.thaumcraft.TCHelper;

import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GT_Values;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptExtraBees implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Extra Bees";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                ExtraBees.ID,
                Thaumcraft.ID,
                MagicBees.ID,
                Forestry.ID,
                PamsHarvestCraft.ID,
                IndustrialCraft2.ID);
    }

    @Override
    public void loadRecipes() {

        addShapelessCraftingRecipe(
                getModItem(ExtraBees.ID, "dictionary", 1, 0, missing),
                new Object[] { getModItem(ExtraBees.ID, "dictionary", 1, 0, missing) });

        ForestryHelper.removeCarpenterRecipe(getModItem(ExtraBees.ID, "dictionary", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(ExtraBees.ID, "misc", 1, 0, missing));
        ForestryHelper.removeSqueezerRecipe(
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(ExtraBees.ID, "honeyDrop", 1, 8, missing));
        ForestryHelper.removeSqueezerRecipe(
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(ExtraBees.ID, "honeyDrop", 1, 9, missing));
        ForestryHelper.removeSqueezerRecipe(
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(ExtraBees.ID, "honeyDrop", 1, 10, missing));
        ForestryHelper.removeSqueezerRecipe(
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(ExtraBees.ID, "honeyDrop", 1, 11, missing));
        ForestryHelper.removeSqueezerRecipe(
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(ExtraBees.ID, "honeyDrop", 1, 12, missing));
        ForestryHelper.removeSqueezerRecipe(
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(ExtraBees.ID, "honeyDrop", 1, 13, missing));
        ForestryHelper.removeSqueezerRecipe(
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(ExtraBees.ID, "honeyDrop", 1, 14, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 1440),
                getModItem(Forestry.ID, "beealyzer", 1, 32767, missing),
                getModItem(ExtraBees.ID, "dictionary", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17501, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing),
                'd',
                "itemCasingGold",
                'e',
                "circuitAdvanced",
                'f',
                "itemCasingGold",
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0, missing),
                getModItem(ExtraBees.ID, "alveary", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 12, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17533, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 12, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17532, missing),
                'e',
                getModItem(ExtraBees.ID, "hiveFrame.soul", 1, 0, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17532, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 12, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17533, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 12, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0, missing),
                getModItem(ExtraBees.ID, "alveary", 1, 1, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10, missing),
                'b',
                getModItem(Forestry.ID, "frameProven", 1, 0, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10, missing),
                'd',
                getModItem(Forestry.ID, "frameProven", 1, 0, missing),
                'e',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 4985, missing),
                'f',
                getModItem(Forestry.ID, "frameProven", 1, 0, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10, missing),
                'h',
                getModItem(Forestry.ID, "frameProven", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0, missing),
                getModItem(ExtraBees.ID, "alveary", 1, 2, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 8, missing),
                'b',
                getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 8, missing),
                'd',
                getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0, missing),
                'e',
                getModItem(Minecraft.ID, "brick_block", 1, 0, missing),
                'f',
                getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 8, missing),
                'h',
                getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 8, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0, missing),
                getModItem(ExtraBees.ID, "alveary", 1, 3, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'b',
                getModItem(Minecraft.ID, "stained_glass", 1, 32767, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'd',
                getModItem(Minecraft.ID, "stained_glass", 1, 32767, missing),
                'e',
                getModItem(Minecraft.ID, "redstone_lamp", 1, 0, missing),
                'f',
                getModItem(Minecraft.ID, "stained_glass", 1, 32767, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'h',
                getModItem(Minecraft.ID, "stained_glass", 1, 32767, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0, missing),
                getModItem(ExtraBees.ID, "alveary", 1, 4, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'b',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 1460, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'd',
                getModItem(Forestry.ID, "chipsets", 1, 2, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing),
                'f',
                getModItem(Forestry.ID, "chipsets", 1, 2, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'h',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 1460, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0, missing),
                getModItem(ExtraBees.ID, "alveary", 1, 5, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 3, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17810, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 3, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32631, missing),
                'e',
                getModItem(Forestry.ID, "apiculture", 1, 0, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32631, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 3, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17810, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 3, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0, missing),
                getModItem(ExtraBees.ID, "alveary", 1, 6, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 0, missing),
                'b',
                "circuitAdvanced",
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 0, missing),
                'd',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 1587, missing),
                'e',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 13, missing),
                'f',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 1587, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 0, missing),
                'h',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 1587, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("for.honey", 1000),
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31889, missing),
                getModItem(ExtraBees.ID, "misc", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "beeswax", 1, 0, missing),
                'b',
                getModItem(Forestry.ID, "pollen", 1, 0, missing),
                'c',
                getModItem(Forestry.ID, "beeswax", 1, 2, missing),
                'd',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'e',
                getModItem(Forestry.ID, "beeswax", 1, 0, missing),
                'f',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'g',
                getModItem(Forestry.ID, "beeswax", 1, 2, missing),
                'h',
                getModItem(Forestry.ID, "pollen", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "beeswax", 1, 2, missing));
        RecipeManagers.squeezerManager.addRecipe(
                20,
                new ItemStack[] { getModItem(ExtraBees.ID, "honeyDrop", 1, 8, missing), },
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32415, missing),
                100);
        RecipeManagers.squeezerManager.addRecipe(
                20,
                new ItemStack[] { getModItem(ExtraBees.ID, "honeyDrop", 1, 9, missing), },
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32425, missing),
                100);
        RecipeManagers.squeezerManager.addRecipe(
                20,
                new ItemStack[] { getModItem(ExtraBees.ID, "honeyDrop", 1, 10, missing), },
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32418, missing),
                100);
        RecipeManagers.squeezerManager.addRecipe(
                20,
                new ItemStack[] { getModItem(ExtraBees.ID, "honeyDrop", 1, 11, missing), },
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32416, missing),
                100);
        RecipeManagers.squeezerManager.addRecipe(
                20,
                new ItemStack[] { getModItem(ExtraBees.ID, "honeyDrop", 1, 13, missing), },
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32429, missing),
                100);
        RecipeManagers.squeezerManager.addRecipe(
                20,
                new ItemStack[] { getModItem(ExtraBees.ID, "honeyDrop", 1, 12, missing), },
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32414, missing),
                100);
        RecipeManagers.squeezerManager.addRecipe(
                20,
                new ItemStack[] { getModItem(ExtraBees.ID, "honeyDrop", 1, 14, missing), },
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32417, missing),
                100);

        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "misc", 1, 1, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 500, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "misc", 1, 2, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 501, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "misc", 1, 3, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 502, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "misc", 1, 4, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 503, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "misc", 1, 5, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 526, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "honeyDrop", 1, 8, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 32415, missing)).outputChances(1000)
                .noFluidInputs().fluidOutputs(FluidRegistry.getFluidStack("for.honey", 200)).duration(32).eut(7)
                .addTo(sFluidExtractionRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "honeyDrop", 1, 9, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 32425, missing)).outputChances(1000)
                .noFluidInputs().fluidOutputs(FluidRegistry.getFluidStack("for.honey", 200)).duration(32).eut(7)
                .addTo(sFluidExtractionRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "honeyDrop", 1, 10, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 32418, missing)).outputChances(1000)
                .noFluidInputs().fluidOutputs(FluidRegistry.getFluidStack("for.honey", 200)).duration(32).eut(7)
                .addTo(sFluidExtractionRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "honeyDrop", 1, 11, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 32416, missing)).outputChances(1000)
                .noFluidInputs().fluidOutputs(FluidRegistry.getFluidStack("for.honey", 200)).duration(32).eut(7)
                .addTo(sFluidExtractionRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "honeyDrop", 1, 13, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 32429, missing)).outputChances(1000)
                .noFluidInputs().fluidOutputs(FluidRegistry.getFluidStack("for.honey", 200)).duration(32).eut(7)
                .addTo(sFluidExtractionRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "honeyDrop", 1, 12, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 32414, missing)).outputChances(1000)
                .noFluidInputs().fluidOutputs(FluidRegistry.getFluidStack("for.honey", 200)).duration(32).eut(7)
                .addTo(sFluidExtractionRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "honeyDrop", 1, 14, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 32417, missing)).outputChances(1000)
                .noFluidInputs().fluidOutputs(FluidRegistry.getFluidStack("for.honey", 200)).duration(32).eut(7)
                .addTo(sFluidExtractionRecipes);

        new ResearchItem(
                "HEALINGFRAME",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("victus"), 6),
                7,
                -2,
                3,
                getModItem(ExtraBees.ID, "hiveFrame.clay", 1, 0, missing)).setParents("MB_EssenceLife").setConcealed()
                        .setPages(new ResearchPage("ExtraBees.research_page.HEALINGFRAME")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "HEALINGFRAME",
                getModItem(ExtraBees.ID, "hiveFrame.clay", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("terra"), 4)
                        .add(Aspect.getAspect("aer"), 4).add(Aspect.getAspect("perditio"), 4)
                        .add(Aspect.getAspect("ignis"), 4).add(Aspect.getAspect("aqua"), 4),
                "abc",
                "def",
                "ghi",
                'a',
                "screwIron",
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2805, missing),
                'c',
                "screwIron",
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2805, missing),
                'e',
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2805, missing),
                'g',
                "screwIron",
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2805, missing),
                'i',
                "screwIron");
        TCHelper.addResearchPage(
                "HEALINGFRAME",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ExtraBees.ID, "hiveFrame.clay", 1, 0, missing))));
        new ResearchItem(
                "CHOCOLATEFRAME",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("fames"), 6),
                7,
                2,
                3,
                getModItem(ExtraBees.ID, "hiveFrame.cocoa", 1, 0, missing)).setParents("MB_EssenceUnstable")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("ExtraBees.research_page.CHOCOLATEFRAME_1"),
                                new ResearchPage("ExtraBees.research_page.CHOCOLATEFRAME_2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CHOCOLATEFRAME",
                getModItem(ExtraBees.ID, "hiveFrame.cocoa", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("terra"), 4)
                        .add(Aspect.getAspect("aer"), 4).add(Aspect.getAspect("perditio"), 4)
                        .add(Aspect.getAspect("ignis"), 4).add(Aspect.getAspect("aqua"), 4),
                "abc",
                "def",
                "ghi",
                'a',
                "screwIron",
                'b',
                getModItem(Minecraft.ID, "sugar", 1, 0, missing),
                'c',
                "screwIron",
                'd',
                getModItem(PamsHarvestCraft.ID, "cocoapowderItem", 1, 0, missing),
                'e',
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                'f',
                getModItem(PamsHarvestCraft.ID, "cocoapowderItem", 1, 0, missing),
                'g',
                "screwIron",
                'h',
                getModItem(Minecraft.ID, "sugar", 1, 0, missing),
                'i',
                "screwIron");
        TCHelper.addResearchPage(
                "CHOCOLATEFRAME",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ExtraBees.ID, "hiveFrame.cocoa", 1, 0, missing))));
        new ResearchItem(
                "RESTRAINTFRAME",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("metallum"), 6),
                9,
                0,
                3,
                getModItem(ExtraBees.ID, "hiveFrame.cage", 1, 0, missing))
                        .setParents("PROVENFRAME", "HEALINGFRAME", "CHOCOLATEFRAME").setConcealed()
                        .setPages(new ResearchPage("ExtraBees.research_page.RESTRAINTFRAME")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RESTRAINTFRAME",
                getModItem(ExtraBees.ID, "hiveFrame.cage", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 8).add(Aspect.getAspect("terra"), 8)
                        .add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("perditio"), 8)
                        .add(Aspect.getAspect("ignis"), 8).add(Aspect.getAspect("aqua"), 8),
                "abc",
                "def",
                "ghi",
                'a',
                "screwSteel",
                'b',
                "barsIron",
                'c',
                "screwSteel",
                'd',
                "barsIron",
                'e',
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                'f',
                "barsIron",
                'g',
                "screwSteel",
                'h',
                "barsIron",
                'i',
                "screwSteel");
        TCHelper.addResearchPage(
                "RESTRAINTFRAME",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ExtraBees.ID, "hiveFrame.cage", 1, 0, missing))));
        new ResearchItem(
                "SOULFRAME",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("spiritus"), 6),
                11,
                0,
                3,
                getModItem(ExtraBees.ID, "hiveFrame.soul", 1, 0, missing)).setParents("RESTRAINTFRAME").setConcealed()
                        .setPages(new ResearchPage("ExtraBees.research_page.SOULFRAME")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SOULFRAME",
                getModItem(ExtraBees.ID, "hiveFrame.soul", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 16).add(Aspect.getAspect("terra"), 16)
                        .add(Aspect.getAspect("aer"), 16).add(Aspect.getAspect("perditio"), 16)
                        .add(Aspect.getAspect("ignis"), 16).add(Aspect.getAspect("aqua"), 16),
                "abc",
                "def",
                "ghi",
                'a',
                "screwAluminium",
                'b',
                getModItem(Minecraft.ID, "soul_sand", 1, 0, missing),
                'c',
                "screwAluminium",
                'd',
                getModItem(Minecraft.ID, "soul_sand", 1, 0, missing),
                'e',
                getModItem(ExtraBees.ID, "hiveFrame.cage", 1, 0, missing),
                'f',
                getModItem(Minecraft.ID, "soul_sand", 1, 0, missing),
                'g',
                "screwAluminium",
                'h',
                getModItem(Minecraft.ID, "soul_sand", 1, 0, missing),
                'i',
                "screwAluminium");
        TCHelper.addResearchPage(
                "SOULFRAME",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ExtraBees.ID, "hiveFrame.soul", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("SOULFRAME", 1);
    }
}
