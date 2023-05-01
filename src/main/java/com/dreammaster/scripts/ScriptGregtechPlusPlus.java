package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronTanks;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.RemoteIO;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptGregtechPlusPlus implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "GT++";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.GTPlusPlus.ID, Forestry.ID, IndustrialCraft2.ID, IronTanks.ID, RemoteIO.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockmachines", 1, 875, missing),
                new Object[] { getModItem(RemoteIO.ID, "tile.machine", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 363, missing),
                        getModItem(RemoteIO.ID, "tile.machine", 1, 1, missing), "gearGtTungstenSteel", "circuitElite",
                        "gearGtTungstenSteel", getModItem(RemoteIO.ID, "tile.machine", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 363, missing),
                        getModItem(RemoteIO.ID, "tile.machine", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.CoinBeesI", 16, 0, missing),
                new Object[] { getModItem(GTPlusPlus.ID, "frameUseless", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                new Object[] { "craftingToolFile", null, null, null,
                        getModItem(GTPlusPlus.ID, "itemIngotTumbaga", 1, 0, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(GTPlusPlus.ID, "blockFrameGtTumbaga", 2, 0, missing),
                new Object[] { getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                        getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                        getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                        getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing), "craftingToolWrench",
                        getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                        getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                        getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                        getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GTPlusPlus.ID, "itemGearTumbaga", 1, 0, missing),
                new Object[] { getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                        getModItem(GTPlusPlus.ID, "itemPlateTumbaga", 1, 0, missing),
                        getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                        getModItem(GTPlusPlus.ID, "itemPlateTumbaga", 1, 0, missing), "craftingToolWrench",
                        getModItem(GTPlusPlus.ID, "itemPlateTumbaga", 1, 0, missing),
                        getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                        getModItem(GTPlusPlus.ID, "itemPlateTumbaga", 1, 0, missing),
                        getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockmachines", 1, 798, missing),
                new Object[] { "plateBlueSteel", getModItem(GregTech.ID, "gt.blockcasings", 1, 5, missing),
                        "plateBlueSteel", "circuitElite", getModItem(GregTech.ID, "gt.blockmachines", 1, 355, missing),
                        "circuitElite", "plateBlueSteel", getModItem(GregTech.ID, "gt.blockcasings", 1, 5, missing),
                        "plateBlueSteel" });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockmachines", 1, 753, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing), "circuitBasic",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                        getModItem(GTPlusPlus.ID, "itemBoilerChassis", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockcasings", 1, 1, missing),
                        getModItem(GTPlusPlus.ID, "itemBoilerChassis", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5134, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 101, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5134, missing) });
        addShapedRecipe(
                getModItem(GTPlusPlus.ID, "itemBoilerChassis", 1, 0, missing),
                new Object[] { "plateDoubleLead", getModItem(GregTech.ID, "gt.blockmachines", 1, 5132, missing),
                        "plateDoubleLead", getModItem(GregTech.ID, "gt.blockmachines", 1, 5122, missing),
                        getModItem(IronTanks.ID, "silverTank", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5122, missing), "plateDoubleLead",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5132, missing), "plateDoubleLead" });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockmachines", 1, 754, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32611, missing), "circuitGood",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32611, missing),
                        getModItem(GTPlusPlus.ID, "itemBoilerChassis", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.blockcasings", 1, 2, missing),
                        getModItem(GTPlusPlus.ID, "itemBoilerChassis", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5144, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 101, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5144, missing) });
        addShapedRecipe(
                getModItem(GTPlusPlus.ID, "itemBoilerChassis", 1, 1, missing),
                new Object[] { "plateDoubleStainlessSteel",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5142, missing), "plateDoubleStainlessSteel",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5132, missing),
                        getModItem(IronTanks.ID, "stainlesssteelTank", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5132, missing), "plateDoubleStainlessSteel",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5142, missing), "plateDoubleStainlessSteel" });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockmachines", 1, 755, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32612, missing), "circuitAdvanced",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32612, missing),
                        getModItem(GTPlusPlus.ID, "itemBoilerChassis", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.blockcasings", 1, 3, missing),
                        getModItem(GTPlusPlus.ID, "itemBoilerChassis", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5154, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 101, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5154, missing) });
        addShapedRecipe(
                getModItem(GTPlusPlus.ID, "itemBoilerChassis", 1, 2, missing),
                new Object[] { "plateDoubleTitanium", getModItem(GregTech.ID, "gt.blockmachines", 1, 5152, missing),
                        "plateDoubleTitanium", getModItem(GregTech.ID, "gt.blockmachines", 1, 5142, missing),
                        getModItem(IronTanks.ID, "titaniumTank", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5142, missing), "plateDoubleTitanium",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5152, missing), "plateDoubleTitanium" });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockmachines", 1, 820, missing),
                new Object[] { "circuitPrimitive", "plateAluminium", "circuitPrimitive", "plateDarkSteel",
                        "pipeMediumSteel", "plateDarkSteel", "circuitPrimitive",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32611, missing), "circuitPrimitive" });

        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "frameAccelerated", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22303, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23303, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22303, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23303, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 29303, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23303, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22303, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23303, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22303, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "frameMutagenic", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22097, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23101, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22097, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23101, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 29101, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23101, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22097, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23101, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22097, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "frameBusy", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22349, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23349, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22349, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23349, missing),
                'e',
                getModItem(Minecraft.ID, "nether_star", 1, 0, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23349, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22349, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23349, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22349, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "frameDecaying", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22304, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23304, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22304, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23304, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 29304, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23304, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22304, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23304, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22304, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "frameSlowing", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GTPlusPlus.ID, "itemRodLongTumbaga", 1, 0, missing),
                'b',
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                'c',
                getModItem(GTPlusPlus.ID, "itemRodLongTumbaga", 1, 0, missing),
                'd',
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 29303, missing),
                'f',
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                'g',
                getModItem(GTPlusPlus.ID, "itemRodLongTumbaga", 1, 0, missing),
                'h',
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                'i',
                getModItem(GTPlusPlus.ID, "itemRodLongTumbaga", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "frameStabilizing", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22317, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23317, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22317, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23317, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 29317, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23317, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22317, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23317, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22317, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "frameArborists", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22889, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23889, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22889, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23889, missing),
                'e',
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23889, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22889, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23889, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22889, missing));

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32597, missing))
                .itemOutputs(getModItem(GTPlusPlus.ID, "personalCloakingDevice-0.0", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.nichrome", 1440)).noFluidOutputs().duration(2400)
                .eut(7860).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GTPlusPlus.ID, "item.BasicMetaFood", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2892, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(100).eut(4).addTo(sMaceratorRecipes);

    }
}
