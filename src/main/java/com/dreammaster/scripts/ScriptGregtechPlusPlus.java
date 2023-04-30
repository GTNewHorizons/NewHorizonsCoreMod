package com.dreammaster.scripts;

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
        return Arrays.asList(Mods.GTPlusPlus.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("gregtech", "gt.blockmachines", 1, 875, missing),
                new Object[] { getModItem("RIO", "tile.machine", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 363, missing),
                        getModItem("RIO", "tile.machine", 1, 1, missing), "gearGtTungstenSteel", "circuitElite",
                        "gearGtTungstenSteel", getModItem("RIO", "tile.machine", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 363, missing),
                        getModItem("RIO", "tile.machine", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("dreamcraft", "item.CoinBeesI", 16, 0, missing),
                new Object[] { getModItem("miscutils", "frameUseless", 1, 0, missing) });
        addShapedRecipe(
                getModItem("miscutils", "itemRodTumbaga", 1, 0, missing),
                new Object[] { "craftingToolFile", null, null, null,
                        getModItem("miscutils", "itemIngotTumbaga", 1, 0, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("miscutils", "blockFrameGtTumbaga", 2, 0, missing),
                new Object[] { getModItem("miscutils", "itemRodTumbaga", 1, 0, missing),
                        getModItem("miscutils", "itemRodTumbaga", 1, 0, missing),
                        getModItem("miscutils", "itemRodTumbaga", 1, 0, missing),
                        getModItem("miscutils", "itemRodTumbaga", 1, 0, missing), "craftingToolWrench",
                        getModItem("miscutils", "itemRodTumbaga", 1, 0, missing),
                        getModItem("miscutils", "itemRodTumbaga", 1, 0, missing),
                        getModItem("miscutils", "itemRodTumbaga", 1, 0, missing),
                        getModItem("miscutils", "itemRodTumbaga", 1, 0, missing) });
        addShapedRecipe(
                getModItem("miscutils", "itemGearTumbaga", 1, 0, missing),
                new Object[] { getModItem("miscutils", "itemRodTumbaga", 1, 0, missing),
                        getModItem("miscutils", "itemPlateTumbaga", 1, 0, missing),
                        getModItem("miscutils", "itemRodTumbaga", 1, 0, missing),
                        getModItem("miscutils", "itemPlateTumbaga", 1, 0, missing), "craftingToolWrench",
                        getModItem("miscutils", "itemPlateTumbaga", 1, 0, missing),
                        getModItem("miscutils", "itemRodTumbaga", 1, 0, missing),
                        getModItem("miscutils", "itemPlateTumbaga", 1, 0, missing),
                        getModItem("miscutils", "itemRodTumbaga", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.blockmachines", 1, 798, missing),
                new Object[] { "plateBlueSteel", getModItem("gregtech", "gt.blockcasings", 1, 5, missing),
                        "plateBlueSteel", "circuitElite", getModItem("gregtech", "gt.blockmachines", 1, 355, missing),
                        "circuitElite", "plateBlueSteel", getModItem("gregtech", "gt.blockcasings", 1, 5, missing),
                        "plateBlueSteel" });
        addShapedRecipe(
                getModItem("gregtech", "gt.blockmachines", 1, 753, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing), "circuitBasic",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                        getModItem("miscutils", "itemBoilerChassis", 1, 0, missing),
                        getModItem("gregtech", "gt.blockcasings", 1, 1, missing),
                        getModItem("miscutils", "itemBoilerChassis", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 5134, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 101, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 5134, missing) });
        addShapedRecipe(
                getModItem("miscutils", "itemBoilerChassis", 1, 0, missing),
                new Object[] { "plateDoubleLead", getModItem("gregtech", "gt.blockmachines", 1, 5132, missing),
                        "plateDoubleLead", getModItem("gregtech", "gt.blockmachines", 1, 5122, missing),
                        getModItem("irontank", "silverTank", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 5122, missing), "plateDoubleLead",
                        getModItem("gregtech", "gt.blockmachines", 1, 5132, missing), "plateDoubleLead" });
        addShapedRecipe(
                getModItem("gregtech", "gt.blockmachines", 1, 754, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32611, missing), "circuitGood",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32611, missing),
                        getModItem("miscutils", "itemBoilerChassis", 1, 1, missing),
                        getModItem("gregtech", "gt.blockcasings", 1, 2, missing),
                        getModItem("miscutils", "itemBoilerChassis", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 5144, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 101, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 5144, missing) });
        addShapedRecipe(
                getModItem("miscutils", "itemBoilerChassis", 1, 1, missing),
                new Object[] { "plateDoubleStainlessSteel",
                        getModItem("gregtech", "gt.blockmachines", 1, 5142, missing), "plateDoubleStainlessSteel",
                        getModItem("gregtech", "gt.blockmachines", 1, 5132, missing),
                        getModItem("irontank", "stainlesssteelTank", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 5132, missing), "plateDoubleStainlessSteel",
                        getModItem("gregtech", "gt.blockmachines", 1, 5142, missing), "plateDoubleStainlessSteel" });
        addShapedRecipe(
                getModItem("gregtech", "gt.blockmachines", 1, 755, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32612, missing), "circuitAdvanced",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32612, missing),
                        getModItem("miscutils", "itemBoilerChassis", 1, 2, missing),
                        getModItem("gregtech", "gt.blockcasings", 1, 3, missing),
                        getModItem("miscutils", "itemBoilerChassis", 1, 2, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 5154, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 101, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 5154, missing) });
        addShapedRecipe(
                getModItem("miscutils", "itemBoilerChassis", 1, 2, missing),
                new Object[] { "plateDoubleTitanium", getModItem("gregtech", "gt.blockmachines", 1, 5152, missing),
                        "plateDoubleTitanium", getModItem("gregtech", "gt.blockmachines", 1, 5142, missing),
                        getModItem("irontank", "titaniumTank", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 5142, missing), "plateDoubleTitanium",
                        getModItem("gregtech", "gt.blockmachines", 1, 5152, missing), "plateDoubleTitanium" });
        addShapedRecipe(
                getModItem("gregtech", "gt.blockmachines", 1, 820, missing),
                new Object[] { "circuitPrimitive", "plateAluminium", "circuitPrimitive", "plateDarkSteel",
                        "pipeMediumSteel", "plateDarkSteel", "circuitPrimitive",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32611, missing), "circuitPrimitive" });

        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem("Forestry", "frameImpregnated", 1, 0, missing),
                getModItem("miscutils", "frameAccelerated", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.02", 1, 22303, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 23303, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.02", 1, 22303, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 23303, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 29303, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 23303, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.02", 1, 22303, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 23303, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.02", 1, 22303, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem("Forestry", "frameImpregnated", 1, 0, missing),
                getModItem("miscutils", "frameMutagenic", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.02", 1, 22097, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 23101, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.02", 1, 22097, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 23101, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 29101, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 23101, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.02", 1, 22097, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 23101, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.02", 1, 22097, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem("Forestry", "frameImpregnated", 1, 0, missing),
                getModItem("miscutils", "frameBusy", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.02", 1, 22349, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 23349, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.02", 1, 22349, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 23349, missing),
                'e',
                getModItem("minecraft", "nether_star", 1, 0, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 23349, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.02", 1, 22349, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 23349, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.02", 1, 22349, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem("Forestry", "frameImpregnated", 1, 0, missing),
                getModItem("miscutils", "frameDecaying", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.02", 1, 22304, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 23304, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.02", 1, 22304, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 23304, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 29304, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 23304, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.02", 1, 22304, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 23304, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.02", 1, 22304, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem("Forestry", "frameImpregnated", 1, 0, missing),
                getModItem("miscutils", "frameSlowing", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("miscutils", "itemRodLongTumbaga", 1, 0, missing),
                'b',
                getModItem("miscutils", "itemRodTumbaga", 1, 0, missing),
                'c',
                getModItem("miscutils", "itemRodLongTumbaga", 1, 0, missing),
                'd',
                getModItem("miscutils", "itemRodTumbaga", 1, 0, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 29303, missing),
                'f',
                getModItem("miscutils", "itemRodTumbaga", 1, 0, missing),
                'g',
                getModItem("miscutils", "itemRodLongTumbaga", 1, 0, missing),
                'h',
                getModItem("miscutils", "itemRodTumbaga", 1, 0, missing),
                'i',
                getModItem("miscutils", "itemRodLongTumbaga", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem("Forestry", "frameImpregnated", 1, 0, missing),
                getModItem("miscutils", "frameStabilizing", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.02", 1, 22317, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 23317, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.02", 1, 22317, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 23317, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 29317, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 23317, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.02", 1, 22317, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 23317, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.02", 1, 22317, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem("Forestry", "frameImpregnated", 1, 0, missing),
                getModItem("miscutils", "frameArborists", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.02", 1, 22889, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 23889, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.02", 1, 22889, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 23889, missing),
                'e',
                getModItem("minecraft", "paper", 1, 0, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 23889, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.02", 1, 22889, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 23889, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.02", 1, 22889, missing));

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemPartIridium", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32597, missing))
                .itemOutputs(getModItem("miscutils", "personalCloakingDevice-0.0", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.nichrome", 1440)).noFluidOutputs().duration(2400)
                .eut(7860).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("miscutils", "item.BasicMetaFood", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 2892, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(100).eut(4).addTo(sMaceratorRecipes);

    }
}
