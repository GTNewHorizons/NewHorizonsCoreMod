package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Botany;
import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.ExtraBees;
import static gregtech.api.enums.Mods.ExtraTrees;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.Genetics;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
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
        return Arrays.asList(
                Mods.Genetics.ID,
                Botany.ID,
                BuildCraftFactory.ID,
                ExtraBees.ID,
                ExtraTrees.ID,
                Forestry.ID,
                IndustrialCraft2.ID);
    }

    @Override
    public void loadRecipes() {
        addShapelessCraftingRecipe(
                getModItem(Genetics.ID, "database", 1, 0, missing),
                new Object[] { getModItem(Genetics.ID, "database", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                new Object[] { "screwStainlessSteel", "craftingToolScrewdriver", "screwStainlessSteel",
                        "circuitAdvanced", getModItem(Forestry.ID, "chipsets", 1, 1, missing), "circuitAdvanced",
                        "screwStainlessSteel", "craftingToolWrench", "screwStainlessSteel" });
        addShapedRecipe(
                getModItem(Genetics.ID, "machine", 1, 0, missing),
                new Object[] { getModItem(Genetics.ID, "misc", 1, 3, missing), "chestIron",
                        getModItem(Genetics.ID, "misc", 1, 3, missing), getModItem(Genetics.ID, "misc", 1, 9, missing),
                        getModItem(Genetics.ID, "misc", 1, 0, missing), getModItem(Genetics.ID, "misc", 1, 9, missing),
                        "gearGtSmallStainlessSteel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing),
                        "gearGtSmallStainlessSteel" });
        addShapedRecipe(
                getModItem(Genetics.ID, "machine", 1, 1, missing),
                new Object[] { getModItem(Genetics.ID, "misc", 1, 2, missing), "chestIron",
                        getModItem(Genetics.ID, "misc", 1, 2, missing), getModItem(Genetics.ID, "misc", 1, 9, missing),
                        getModItem(Genetics.ID, "misc", 1, 0, missing), getModItem(Genetics.ID, "misc", 1, 9, missing),
                        "gearGtSmallStainlessSteel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing),
                        "gearGtSmallStainlessSteel" });
        addShapedRecipe(
                getModItem(Genetics.ID, "machine", 1, 2, missing),
                new Object[] { getModItem(Genetics.ID, "misc", 1, 7, missing), "chestIron",
                        getModItem(Genetics.ID, "misc", 1, 7, missing), getModItem(Genetics.ID, "misc", 1, 9, missing),
                        getModItem(Genetics.ID, "misc", 1, 0, missing), getModItem(Genetics.ID, "misc", 1, 9, missing),
                        "gearGtSmallStainlessSteel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing),
                        "gearGtSmallStainlessSteel" });
        addShapedRecipe(
                getModItem(Genetics.ID, "machine", 1, 3, missing),
                new Object[] { "plateEmerald", "chestIron", "plateEmerald",
                        getModItem(Genetics.ID, "misc", 1, 9, missing), getModItem(Genetics.ID, "misc", 1, 0, missing),
                        getModItem(Genetics.ID, "misc", 1, 9, missing), "gearGtSmallStainlessSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing), "gearGtSmallStainlessSteel" });
        addShapedRecipe(
                getModItem(Genetics.ID, "labMachine", 1, 1, missing),
                new Object[] { getModItem(Genetics.ID, "misc", 1, 1, missing), "chestIron",
                        getModItem(Genetics.ID, "misc", 1, 1, missing), getModItem(Genetics.ID, "misc", 1, 9, missing),
                        getModItem(Genetics.ID, "misc", 1, 0, missing), getModItem(Genetics.ID, "misc", 1, 9, missing),
                        "gearGtSmallStainlessSteel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing),
                        "gearGtSmallStainlessSteel" });
        addShapedRecipe(
                getModItem(Genetics.ID, "labMachine", 1, 2, missing),
                new Object[] { getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing), "craftingIronFurnace",
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        getModItem(Genetics.ID, "misc", 1, 9, missing), getModItem(Genetics.ID, "misc", 1, 0, missing),
                        getModItem(Genetics.ID, "misc", 1, 9, missing), "gearGtSmallStainlessSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing), "gearGtSmallStainlessSteel" });
        addShapedRecipe(
                getModItem(Genetics.ID, "labMachine", 1, 3, missing),
                new Object[] { getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing), "chestIron",
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        getModItem(Genetics.ID, "misc", 1, 9, missing), getModItem(Genetics.ID, "misc", 1, 0, missing),
                        getModItem(Genetics.ID, "misc", 1, 9, missing), "gearGtSmallStainlessSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing), "gearGtSmallStainlessSteel" });
        addShapedRecipe(
                getModItem(Genetics.ID, "labMachine", 1, 4, missing),
                new Object[] { "bucketWater", "bucketLava", "bucketWater",
                        getModItem(Genetics.ID, "misc", 1, 9, missing), getModItem(Genetics.ID, "misc", 1, 0, missing),
                        getModItem(Genetics.ID, "misc", 1, 9, missing), "gearGtSmallStainlessSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing), "gearGtSmallStainlessSteel" });
        addShapedRecipe(
                getModItem(Genetics.ID, "labMachine", 1, 0, missing),
                new Object[] { "plateStainlessSteel", "paneGlass", "plateStainlessSteel", "paneGlass",
                        getModItem(Genetics.ID, "misc", 1, 0, missing), "paneGlass", "plateStainlessSteel", "paneGlass",
                        "plateStainlessSteel" });
        addShapedRecipe(
                getModItem(Genetics.ID, "advMachine", 1, 0, missing),
                new Object[] { "plateKanthal", "chestDiamond", "plateKanthal",
                        getModItem(Genetics.ID, "misc", 1, 10, missing),
                        getModItem(Genetics.ID, "misc", 1, 11, missing),
                        getModItem(Genetics.ID, "misc", 1, 10, missing), "gearGtSmallDiamond",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing), "gearGtSmallDiamond" });

        ForestryHelper.removeCarpenterRecipe(getModItem(Genetics.ID, "database", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 2880),
                getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                getModItem(Genetics.ID, "database", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27533, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27533, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                'e',
                "circuitData",
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27533, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27533, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 4320),
                getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                getModItem(Genetics.ID, "analyst", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                'b',
                getModItem(Forestry.ID, "treealyzer", 1, 0, missing),
                'c',
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                'd',
                getModItem(Forestry.ID, "beealyzer", 1, 0, missing),
                'e',
                getModItem(Genetics.ID, "misc", 1, 10, missing),
                'f',
                getModItem(Forestry.ID, "flutterlyzer", 1, 0, missing),
                'g',
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                'i',
                getModItem(Genetics.ID, "misc", 1, 9, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 4320),
                getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                getModItem(Genetics.ID, "registry", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                'b',
                getModItem(ExtraTrees.ID, "database", 1, 0, missing),
                'c',
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                'd',
                getModItem(Botany.ID, "database", 1, 0, missing),
                'e',
                getModItem(Genetics.ID, "misc", 1, 10, missing),
                'f',
                getModItem(ExtraBees.ID, "dictionary", 1, 0, missing),
                'g',
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                'h',
                getModItem(ExtraTrees.ID, "databaseMoth", 1, 0, missing),
                'i',
                getModItem(Genetics.ID, "misc", 1, 9, missing));

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.AluminiumItemCasing", 8, 0, missing))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 8, 18019, missing))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass_pane", 6, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 6, missing))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 8, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass_pane", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 288)).noFluidOutputs().duration(200).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass_pane", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 144)).noFluidOutputs().duration(200).eut(48)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Genetics.ID, "misc", 10, 6, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 10, missing))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 576)).noFluidOutputs().duration(200).eut(96)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "chipsets", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 2, 0, missing))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.stainlesssteel", 64)).noFluidOutputs().duration(400)
                .eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "chipsets", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32082, missing))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.stainlesssteel", 64)).noFluidOutputs().duration(400)
                .eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "chipsets", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32703, missing))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.stainlesssteel", 64)).noFluidOutputs().duration(400)
                .eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing),
                        getModItem(Genetics.ID, "misc", 2, 10, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 11, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glowstone", 288)).noFluidOutputs().duration(1500)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32106, missing),
                        getModItem(Forestry.ID, "thermionicTubes", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glowstone", 144)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32418, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32419, missing))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.blaze", 144)).noFluidOutputs().duration(100).eut(30)
                .addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32428, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32425, missing))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.blaze", 144)).noFluidOutputs().duration(100).eut(30)
                .addTo(sMixerRecipes);

    }
}
