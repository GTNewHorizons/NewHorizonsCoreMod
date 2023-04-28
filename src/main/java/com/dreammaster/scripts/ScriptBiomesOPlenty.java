package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.*;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;
import gregtech.api.util.GT_ModHandler;

public class ScriptBiomesOPlenty implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Biomes o Plenty";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.BiomesOPlenty.ID);
    }

    @Override
    public void loadRecipes() {
        addShapelessCraftingRecipe(
                getModItem("BiomesOPlenty", "jarEmpty", 1, 0, missing),
                new Object[] { "bottleEmpty" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "glass_bottle", 1, 0, missing),
                new Object[] { getModItem("BiomesOPlenty", "jarEmpty", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("BiomesOPlenty", "mudball", 2, 0, missing),
                new Object[] { getModItem("minecraft", "dirt", 1, 0, missing),
                        getModItem("minecraft", "water_bucket", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("BiomesOPlenty", "mudball", 2, 0, missing),
                new Object[] { getModItem("minecraft", "dirt", 1, 0, missing),
                        getModItem("IguanaTweaksTConstruct", "clayBucketWater", 1, 0, missing) });
        addShapedRecipe(
                getModItem("BiomesOPlenty", "dartBlower", 1, 0, missing),
                new Object[] { getModItem("BiomesOPlenty", "plants", 1, 8, missing), "ringWood",
                        getModItem("BiomesOPlenty", "plants", 1, 8, missing),
                        getModItem("BiomesOPlenty", "plants", 1, 8, missing), null,
                        getModItem("BiomesOPlenty", "plants", 1, 8, missing),
                        getModItem("BiomesOPlenty", "plants", 1, 8, missing), "ringWood",
                        getModItem("BiomesOPlenty", "plants", 1, 8, missing) });
        addShapedRecipe(
                getModItem("BiomesOPlenty", "dart", 1, 0, missing),
                new Object[] { getModItem("BiomesOPlenty", "plants", 1, 5, missing), null, null,
                        getModItem("BiomesOPlenty", "plants", 1, 8, missing), null, null,
                        getModItem("minecraft", "feather", 1, 0, missing), null, null });
        addShapedRecipe(
                getModItem("BiomesOPlenty", "scytheDiamond", 1, 0, missing),
                new Object[] { "gemDiamond", "plateDiamond", "craftingToolHardHammer", "stickWood", "craftingToolFile",
                        "plateDiamond", "stickWood", null, null });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2816, missing),
                new Object[] { getModItem("BiomesOPlenty", "misc", 1, 1, missing),
                        getModItem("BiomesOPlenty", "misc", 1, 1, missing),
                        getModItem("BiomesOPlenty", "misc", 1, 1, missing),
                        getModItem("BiomesOPlenty", "misc", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("BiomesOPlenty", "planks", 2, 14, missing),
                new Object[] { getModItem("BiomesOPlenty", "logs4", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "bucket", 1, 0, missing),
                new Object[] { getModItem("BiomesOPlenty", "bopBucket", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("BiomesOPlenty", "rocks", 1, 1, missing),
                new Object[] { getModItem("BiomesOPlenty", "rocks", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("BiomesOPlenty", "rocks", 1, 0, missing),
                new Object[] { getModItem("BiomesOPlenty", "rocks", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("BiomesOPlenty", "coral1", 1, 15, missing),
                new Object[] { getModItem("BiomesOPlenty", "coral2", 1, 8, missing), "dustGlowstone" });
        addShapelessCraftingRecipe(
                getModItem("BiomesOPlenty", "coral1", 1, 15, missing),
                new Object[] { getModItem("miscutils", "item.BasicAgrichemItem", 1, 1, missing), "dustGlowstone" });
        addShapelessCraftingRecipe(
                getModItem("BiomesOPlenty", "coral1", 1, 12, missing),
                new Object[] { getModItem("BiomesOPlenty", "coral2", 1, 8, missing), "dustGlowstone", "dyePink" });
        addShapelessCraftingRecipe(
                getModItem("BiomesOPlenty", "coral1", 1, 13, missing),
                new Object[] { getModItem("BiomesOPlenty", "coral2", 1, 8, missing), "dustGlowstone", "dyeOrange" });
        addShapelessCraftingRecipe(
                getModItem("BiomesOPlenty", "coral1", 1, 14, missing),
                new Object[] { getModItem("BiomesOPlenty", "coral2", 1, 8, missing), "dustGlowstone", "dyeBlue" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32414, missing),
                new Object[] { getModItem("BiomesOPlenty", "flowers", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32429, missing),
                new Object[] { getModItem("BiomesOPlenty", "flowers", 1, 9, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32429, missing),
                new Object[] { getModItem("BiomesOPlenty", "flowers2", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32418, missing),
                new Object[] { getModItem("BiomesOPlenty", "flowers2", 1, 5, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32418, missing),
                new Object[] { getModItem("BiomesOPlenty", "mushrooms", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32416, missing),
                new Object[] { getModItem("BiomesOPlenty", "moss", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32417, missing),
                new Object[] { getModItem("BiomesOPlenty", "mushrooms", 1, 4, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32417, missing),
                new Object[] { getModItem("BiomesOPlenty", "plants", 1, 7, missing) });

        GT_ModHandler.addSmeltingRecipe(
                getModItem("BiomesOPlenty", "driedDirt", 1, 0, missing),
                getModItem("minecraft", "dirt", 1, 0, missing));
        GT_ModHandler.setFuelValue(getModItem("BiomesOPlenty", "bamboo", 1, 0, missing), (short) 100);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "beeswax", 2, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("BiomesOPlenty", "misc", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(120).eut(20).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "propolis", 2, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("BiomesOPlenty", "hive", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(40).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stone", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 2823, missing))
                .itemOutputs(getModItem("BiomesOPlenty", "rocks", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(50).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "honeyBlock", 1, 0, missing))
                .itemOutputs(
                        getModItem("Forestry", "honeyDrop", 7, 0, missing),
                        getModItem("Forestry", "honeyDrop", 1, 0, missing),
                        getModItem("Forestry", "honeyDrop", 1, 0, missing),
                        getModItem("Forestry", "honeyDrop", 1, 0, missing))
                .outputChances(10000, 5000, 2500, 1200).noFluidInputs().noFluidOutputs().duration(4000).eut(8)
                .addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "misc", 1, 2, missing))
                .itemOutputs(getModItem("Forestry", "beeswax", 1, 0, missing)).outputChances(10000).noFluidInputs()
                .noFluidOutputs().duration(120).eut(5).addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("harvestcraft", "waxcombItem", 1, 0, missing))
                .itemOutputs(getModItem("Forestry", "beeswax", 1, 0, missing)).outputChances(10000).noFluidInputs()
                .noFluidOutputs().duration(120).eut(5).addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "food", 1, 9, missing))
                .itemOutputs(
                        getModItem("Forestry", "beeswax", 1, 0, missing),
                        getModItem("Forestry", "honeyDrop", 1, 0, missing))
                .outputChances(10000, 9000).noFluidInputs().noFluidOutputs().duration(120).eut(5)
                .addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("harvestcraft", "honeycombItem", 1, 0, missing))
                .itemOutputs(
                        getModItem("Forestry", "beeswax", 1, 0, missing),
                        getModItem("Forestry", "honeyDrop", 1, 0, missing))
                .outputChances(10000, 9000).noFluidInputs().noFluidOutputs().duration(120).eut(5)
                .addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "flowers", 1, 1, missing))
                .itemOutputs(getModItem("minecraft", "dye", 2, 6, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "flowers", 1, 2, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.02", 2, 32414, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "flowers", 1, 4, missing))
                .itemOutputs(getModItem("minecraft", "dye", 2, 12, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "flowers2", 1, 7, missing))
                .itemOutputs(getModItem("minecraft", "dye", 2, 12, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "flowers", 1, 5, missing))
                .itemOutputs(getModItem("minecraft", "dye", 2, 14, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "flowers2", 1, 2, missing))
                .itemOutputs(getModItem("minecraft", "dye", 2, 14, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "flowers", 1, 6, missing))
                .itemOutputs(getModItem("minecraft", "dye", 2, 9, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "flowers2", 1, 0, missing))
                .itemOutputs(getModItem("minecraft", "dye", 2, 9, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "flowers", 1, 7, missing))
                .itemOutputs(getModItem("minecraft", "dye", 2, 13, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "flowers", 1, 8, missing))
                .itemOutputs(getModItem("minecraft", "dye", 2, 5, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "flowers2", 1, 3, missing))
                .itemOutputs(getModItem("minecraft", "dye", 2, 5, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "flowers", 1, 9, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.02", 2, 32429, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "flowers2", 1, 1, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.02", 2, 32429, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "flowers", 1, 15, missing))
                .itemOutputs(getModItem("minecraft", "dye", 2, 7, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "flowers2", 1, 4, missing))
                .itemOutputs(getModItem("minecraft", "dye", 2, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "flowers2", 1, 5, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.02", 2, 32418, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "mushrooms", 1, 2, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.02", 2, 32418, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "flowers2", 1, 8, missing))
                .itemOutputs(getModItem("minecraft", "dye", 2, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "moss", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.02", 2, 32416, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "mushrooms", 1, 4, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.02", 2, 32417, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "plants", 1, 7, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.02", 2, 32417, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "mud", 1, 0, missing))
                .itemOutputs(getModItem("BiomesOPlenty", "mudball", 4, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(8).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "jarFilled", 1, 1, missing))
                .itemOutputs(getModItem("BiomesOPlenty", "jarEmpty", 1, 0, missing)).outputChances(2).noFluidInputs()
                .fluidOutputs(FluidRegistry.getFluidStack("poison", 1000)).duration(10000).eut(20)
                .addTo(sFluidExtractionRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "honeyBlock", 1, 0, missing)).noItemOutputs()
                .outputChances(40).noFluidInputs().fluidOutputs(FluidRegistry.getFluidStack("for.honey", 1000))
                .duration(10000).eut(1200).addTo(sFluidExtractionRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "misc", 1, 2, missing))
                .itemOutputs(getModItem("BiomesOPlenty", "food", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 100)).noFluidOutputs().duration(1).eut(1)
                .addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem("BiomesOPlenty", "honeyBlock", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 1000)).noFluidOutputs().duration(400).eut(40)
                .addTo(sFluidSolidficationRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "bones", 1, 0, missing))
                .itemOutputs(getModItem("minecraft", "dye", 8, 15, missing)).outputChances(10000).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "bones", 1, 1, missing))
                .itemOutputs(getModItem("minecraft", "dye", 12, 15, missing)).outputChances(10000).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "bones", 1, 2, missing))
                .itemOutputs(getModItem("minecraft", "dye", 24, 15, missing)).outputChances(10000).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "hardSand", 1, 0, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.SandDust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 1802, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 1937, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 1833, missing))
                .outputChances(10000, 5000, 1000, 500).noFluidInputs().noFluidOutputs().duration(200).eut(8)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "hardDirt", 1, 0, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 1805, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 1622, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 1934, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 1823, missing))
                .outputChances(10000, 7500, 2500, 2500).noFluidInputs().noFluidOutputs().duration(200).eut(8)
                .addTo(sMaceratorRecipes);

    }
}
