package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMixerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.forestry.ForestryHelper;

import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptGenetics implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Genetics";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.Genetics.ID);
    }

    @Override
    public void loadRecipes() {
        addShapelessCraftingRecipe(
                getModItem("Genetics", "database", 1, 0, missing),
                new Object[] { getModItem("Genetics", "database", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Genetics", "misc", 1, 9, missing),
                new Object[] { "screwStainlessSteel", "craftingToolScrewdriver", "screwStainlessSteel",
                        "circuitAdvanced", getModItem("Forestry", "chipsets", 1, 1, missing), "circuitAdvanced",
                        "screwStainlessSteel", "craftingToolWrench", "screwStainlessSteel" });
        addShapedRecipe(
                getModItem("Genetics", "machine", 1, 0, missing),
                new Object[] { getModItem("Genetics", "misc", 1, 3, missing), "chestIron",
                        getModItem("Genetics", "misc", 1, 3, missing), getModItem("Genetics", "misc", 1, 9, missing),
                        getModItem("Genetics", "misc", 1, 0, missing), getModItem("Genetics", "misc", 1, 9, missing),
                        "gearGtSmallStainlessSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing),
                        "gearGtSmallStainlessSteel" });
        addShapedRecipe(
                getModItem("Genetics", "machine", 1, 1, missing),
                new Object[] { getModItem("Genetics", "misc", 1, 2, missing), "chestIron",
                        getModItem("Genetics", "misc", 1, 2, missing), getModItem("Genetics", "misc", 1, 9, missing),
                        getModItem("Genetics", "misc", 1, 0, missing), getModItem("Genetics", "misc", 1, 9, missing),
                        "gearGtSmallStainlessSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing),
                        "gearGtSmallStainlessSteel" });
        addShapedRecipe(
                getModItem("Genetics", "machine", 1, 2, missing),
                new Object[] { getModItem("Genetics", "misc", 1, 7, missing), "chestIron",
                        getModItem("Genetics", "misc", 1, 7, missing), getModItem("Genetics", "misc", 1, 9, missing),
                        getModItem("Genetics", "misc", 1, 0, missing), getModItem("Genetics", "misc", 1, 9, missing),
                        "gearGtSmallStainlessSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing),
                        "gearGtSmallStainlessSteel" });
        addShapedRecipe(
                getModItem("Genetics", "machine", 1, 3, missing),
                new Object[] { "plateEmerald", "chestIron", "plateEmerald",
                        getModItem("Genetics", "misc", 1, 9, missing), getModItem("Genetics", "misc", 1, 0, missing),
                        getModItem("Genetics", "misc", 1, 9, missing), "gearGtSmallStainlessSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing), "gearGtSmallStainlessSteel" });
        addShapedRecipe(
                getModItem("Genetics", "labMachine", 1, 1, missing),
                new Object[] { getModItem("Genetics", "misc", 1, 1, missing), "chestIron",
                        getModItem("Genetics", "misc", 1, 1, missing), getModItem("Genetics", "misc", 1, 9, missing),
                        getModItem("Genetics", "misc", 1, 0, missing), getModItem("Genetics", "misc", 1, 9, missing),
                        "gearGtSmallStainlessSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing),
                        "gearGtSmallStainlessSteel" });
        addShapedRecipe(
                getModItem("Genetics", "labMachine", 1, 2, missing),
                new Object[] { getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing), "craftingIronFurnace",
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                        getModItem("Genetics", "misc", 1, 9, missing), getModItem("Genetics", "misc", 1, 0, missing),
                        getModItem("Genetics", "misc", 1, 9, missing), "gearGtSmallStainlessSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing), "gearGtSmallStainlessSteel" });
        addShapedRecipe(
                getModItem("Genetics", "labMachine", 1, 3, missing),
                new Object[] { getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing), "chestIron",
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                        getModItem("Genetics", "misc", 1, 9, missing), getModItem("Genetics", "misc", 1, 0, missing),
                        getModItem("Genetics", "misc", 1, 9, missing), "gearGtSmallStainlessSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing), "gearGtSmallStainlessSteel" });
        addShapedRecipe(
                getModItem("Genetics", "labMachine", 1, 4, missing),
                new Object[] { "bucketWater", "bucketLava", "bucketWater",
                        getModItem("Genetics", "misc", 1, 9, missing), getModItem("Genetics", "misc", 1, 0, missing),
                        getModItem("Genetics", "misc", 1, 9, missing), "gearGtSmallStainlessSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing), "gearGtSmallStainlessSteel" });
        addShapedRecipe(
                getModItem("Genetics", "labMachine", 1, 0, missing),
                new Object[] { "plateStainlessSteel", "paneGlass", "plateStainlessSteel", "paneGlass",
                        getModItem("Genetics", "misc", 1, 0, missing), "paneGlass", "plateStainlessSteel", "paneGlass",
                        "plateStainlessSteel" });
        addShapedRecipe(
                getModItem("Genetics", "advMachine", 1, 0, missing),
                new Object[] { "plateKanthal", "chestDiamond", "plateKanthal",
                        getModItem("Genetics", "misc", 1, 10, missing), getModItem("Genetics", "misc", 1, 11, missing),
                        getModItem("Genetics", "misc", 1, 10, missing), "gearGtSmallDiamond",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing), "gearGtSmallDiamond" });

        ForestryHelper.removeCarpenterRecipe(getModItem("Genetics", "database", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 2880),
                getModItem("dreamcraft", "item.Display", 1, 0, missing),
                getModItem("Genetics", "database", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27533, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27533, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                'e',
                "circuitData",
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27533, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27533, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 4320),
                getModItem("dreamcraft", "item.Display", 1, 0, missing),
                getModItem("Genetics", "analyst", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Genetics", "misc", 1, 9, missing),
                'b',
                getModItem("Forestry", "treealyzer", 1, 0, missing),
                'c',
                getModItem("Genetics", "misc", 1, 9, missing),
                'd',
                getModItem("Forestry", "beealyzer", 1, 0, missing),
                'e',
                getModItem("Genetics", "misc", 1, 10, missing),
                'f',
                getModItem("Forestry", "flutterlyzer", 1, 0, missing),
                'g',
                getModItem("Genetics", "misc", 1, 9, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                'i',
                getModItem("Genetics", "misc", 1, 9, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 4320),
                getModItem("dreamcraft", "item.Display", 1, 0, missing),
                getModItem("Genetics", "registry", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Genetics", "misc", 1, 9, missing),
                'b',
                getModItem("ExtraTrees", "database", 1, 0, missing),
                'c',
                getModItem("Genetics", "misc", 1, 9, missing),
                'd',
                getModItem("Botany", "database", 1, 0, missing),
                'e',
                getModItem("Genetics", "misc", 1, 10, missing),
                'f',
                getModItem("ExtraBees", "dictionary", 1, 0, missing),
                'g',
                getModItem("Genetics", "misc", 1, 9, missing),
                'h',
                getModItem("ExtraTrees", "databaseMoth", 1, 0, missing),
                'i',
                getModItem("Genetics", "misc", 1, 9, missing));

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "sturdyMachine", 1, 0, missing),
                        getModItem("dreamcraft", "item.AluminiumItemCasing", 8, 0, missing))
                .itemOutputs(getModItem("Genetics", "misc", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "sturdyMachine", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 8, 18019, missing))
                .itemOutputs(getModItem("Genetics", "misc", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glass_pane", 6, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 6, missing))
                .itemOutputs(getModItem("Genetics", "misc", 1, 8, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glass_pane", 2, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("Genetics", "misc", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 288)).noFluidOutputs().duration(200).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glass_pane", 4, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem("Genetics", "misc", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 144)).noFluidOutputs().duration(200).eut(48)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Genetics", "misc", 10, 6, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 10, missing))
                .itemOutputs(getModItem("Genetics", "misc", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 576)).noFluidOutputs().duration(200).eut(96)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "chipsets", 1, 1, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 2, 0, missing))
                .itemOutputs(getModItem("Genetics", "misc", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.stainlesssteel", 64)).noFluidOutputs().duration(400)
                .eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "chipsets", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32082, missing))
                .itemOutputs(getModItem("Genetics", "misc", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.stainlesssteel", 64)).noFluidOutputs().duration(400)
                .eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "chipsets", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32703, missing))
                .itemOutputs(getModItem("Genetics", "misc", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.stainlesssteel", 64)).noFluidOutputs().duration(400)
                .eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "hardenedMachine", 1, 0, missing),
                        getModItem("Genetics", "misc", 2, 10, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("Genetics", "misc", 1, 11, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glowstone", 288)).noFluidOutputs().duration(1500)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.03", 1, 32106, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 5, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("Genetics", "misc", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glowstone", 144)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "redstone", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32418, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32419, missing))
                .itemOutputs(getModItem("Genetics", "misc", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.blaze", 144)).noFluidOutputs().duration(100).eut(30)
                .addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "redstone", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32428, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32425, missing))
                .itemOutputs(getModItem("Genetics", "misc", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.blaze", 144)).noFluidOutputs().duration(100).eut(30)
                .addTo(sMixerRecipes);

    }
}
