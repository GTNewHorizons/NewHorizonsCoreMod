package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

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
