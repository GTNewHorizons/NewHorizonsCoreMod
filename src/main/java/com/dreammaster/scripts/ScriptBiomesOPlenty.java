package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IguanaTweaksTinkerConstruct;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCompressorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sExtractorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sFluidCannerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sFluidExtractionRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sFluidSolidficationRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.util.GT_ModHandler;

public class ScriptBiomesOPlenty implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Biomes o Plenty";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                BiomesOPlenty.ID,
                Forestry.ID,
                GTPlusPlus.ID,
                IguanaTweaksTinkerConstruct.ID,
                PamsHarvestCraft.ID);
    }

    @Override
    public void loadRecipes() {
        addShapelessCraftingRecipe(
                getModItem(BiomesOPlenty.ID, "jarEmpty", 1, 0, missing),
                new Object[] { "bottleEmpty" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "glass_bottle", 1, 0, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "jarEmpty", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(BiomesOPlenty.ID, "mudball", 2, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                        getModItem(Minecraft.ID, "water_bucket", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(BiomesOPlenty.ID, "mudball", 2, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                        getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing) });
        addShapedRecipe(
                getModItem(BiomesOPlenty.ID, "dartBlower", 1, 0, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "plants", 1, 8, missing), "ringWood",
                        getModItem(BiomesOPlenty.ID, "plants", 1, 8, missing),
                        getModItem(BiomesOPlenty.ID, "plants", 1, 8, missing), null,
                        getModItem(BiomesOPlenty.ID, "plants", 1, 8, missing),
                        getModItem(BiomesOPlenty.ID, "plants", 1, 8, missing), "ringWood",
                        getModItem(BiomesOPlenty.ID, "plants", 1, 8, missing) });
        addShapedRecipe(
                getModItem(BiomesOPlenty.ID, "dart", 1, 0, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "plants", 1, 5, missing), null, null,
                        getModItem(BiomesOPlenty.ID, "plants", 1, 8, missing), null, null,
                        getModItem(Minecraft.ID, "feather", 1, 0, missing), null, null });
        addShapedRecipe(
                getModItem(BiomesOPlenty.ID, "scytheDiamond", 1, 0, missing),
                new Object[] { "gemDiamond", "plateDiamond", "craftingToolHardHammer", "stickWood", "craftingToolFile",
                        "plateDiamond", "stickWood", null, null });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2816, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "misc", 1, 1, missing),
                        getModItem(BiomesOPlenty.ID, "misc", 1, 1, missing),
                        getModItem(BiomesOPlenty.ID, "misc", 1, 1, missing),
                        getModItem(BiomesOPlenty.ID, "misc", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(BiomesOPlenty.ID, "planks", 2, 14, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "logs4", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "bucket", 1, 0, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "bopBucket", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(BiomesOPlenty.ID, "rocks", 1, 1, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "rocks", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(BiomesOPlenty.ID, "rocks", 1, 0, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "rocks", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(BiomesOPlenty.ID, "coral1", 1, 15, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "coral2", 1, 8, missing), "dustGlowstone" });
        addShapelessCraftingRecipe(
                getModItem(BiomesOPlenty.ID, "coral1", 1, 15, missing),
                new Object[] { getModItem(GTPlusPlus.ID, "item.BasicAgrichemItem", 1, 1, missing), "dustGlowstone" });
        addShapelessCraftingRecipe(
                getModItem(BiomesOPlenty.ID, "coral1", 1, 12, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "coral2", 1, 8, missing), "dustGlowstone", "dyePink" });
        addShapelessCraftingRecipe(
                getModItem(BiomesOPlenty.ID, "coral1", 1, 13, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "coral2", 1, 8, missing), "dustGlowstone", "dyeOrange" });
        addShapelessCraftingRecipe(
                getModItem(BiomesOPlenty.ID, "coral1", 1, 14, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "coral2", 1, 8, missing), "dustGlowstone", "dyeBlue" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32414, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "flowers", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32429, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "flowers", 1, 9, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32429, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "flowers2", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32418, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "flowers2", 1, 5, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32418, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "mushrooms", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32416, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32417, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "mushrooms", 1, 4, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32417, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing) });

        GT_ModHandler.addSmeltingRecipe(
                getModItem(BiomesOPlenty.ID, "driedDirt", 1, 0, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing));
        GT_ModHandler.setFuelValue(getModItem(BiomesOPlenty.ID, "bamboo", 1, 0, missing), (short) 100);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "packed_ice", 16, 0, missing))
                .itemOutputs(getModItem(BiomesOPlenty.ID, "hardIce", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "bones", 2, 0, missing))
                .itemOutputs(getModItem(BiomesOPlenty.ID, "bones", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "bones", 2, 1, missing))
                .itemOutputs(getModItem(BiomesOPlenty.ID, "bones", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "beeswax", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem(BiomesOPlenty.ID, "misc", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(120).eut(20).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "propolis", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem(BiomesOPlenty.ID, "hive", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(40).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stone", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 2823, missing))
                .itemOutputs(getModItem(BiomesOPlenty.ID, "rocks", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(50).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "honeyBlock", 1, 0, missing))
                .itemOutputs(
                        getModItem(Forestry.ID, "honeyDrop", 7, 0, missing),
                        getModItem(Forestry.ID, "honeyDrop", 1, 0, missing),
                        getModItem(Forestry.ID, "honeyDrop", 1, 0, missing),
                        getModItem(Forestry.ID, "honeyDrop", 1, 0, missing))
                .outputChances(10000, 5000, 2500, 1200).noFluidInputs().noFluidOutputs().duration(4000).eut(8)
                .addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "misc", 1, 2, missing))
                .itemOutputs(getModItem(Forestry.ID, "beeswax", 1, 0, missing)).outputChances(10000).noFluidInputs()
                .noFluidOutputs().duration(120).eut(5).addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "waxcombItem", 1, 0, missing))
                .itemOutputs(getModItem(Forestry.ID, "beeswax", 1, 0, missing)).outputChances(10000).noFluidInputs()
                .noFluidOutputs().duration(120).eut(5).addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "food", 1, 9, missing))
                .itemOutputs(
                        getModItem(Forestry.ID, "beeswax", 1, 0, missing),
                        getModItem(Forestry.ID, "honeyDrop", 1, 0, missing))
                .outputChances(10000, 9000).noFluidInputs().noFluidOutputs().duration(120).eut(5)
                .addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "honeycombItem", 1, 0, missing))
                .itemOutputs(
                        getModItem(Forestry.ID, "beeswax", 1, 0, missing),
                        getModItem(Forestry.ID, "honeyDrop", 1, 0, missing))
                .outputChances(10000, 9000).noFluidInputs().noFluidOutputs().duration(120).eut(5)
                .addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers", 1, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 6, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers", 1, 2, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 2, 32414, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers", 1, 4, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 12, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers2", 1, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 12, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers", 1, 5, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 14, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers2", 1, 2, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 14, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers", 1, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 9, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers2", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 9, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers", 1, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 13, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers", 1, 8, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 5, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers2", 1, 3, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 5, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers", 1, 9, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 2, 32429, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers2", 1, 1, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 2, 32429, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers", 1, 15, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 7, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers2", 1, 4, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers2", 1, 5, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 2, 32418, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "mushrooms", 1, 2, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 2, 32418, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers2", 1, 8, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 2, 32416, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "mushrooms", 1, 4, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 2, 32417, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 2, 32417, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "mud", 1, 0, missing))
                .itemOutputs(getModItem(BiomesOPlenty.ID, "mudball", 4, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(8).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "jarFilled", 1, 1, missing))
                .itemOutputs(getModItem(BiomesOPlenty.ID, "jarEmpty", 1, 0, missing)).outputChances(2).noFluidInputs()
                .fluidOutputs(FluidRegistry.getFluidStack("poison", 1000)).duration(10000).eut(20)
                .addTo(sFluidExtractionRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "honeyBlock", 1, 0, missing)).noItemOutputs()
                .noFluidInputs().fluidOutputs(FluidRegistry.getFluidStack("for.honey", 1000)).duration(10000).eut(1200)
                .addTo(sFluidExtractionRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "misc", 1, 2, missing))
                .itemOutputs(getModItem(BiomesOPlenty.ID, "food", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 100)).noFluidOutputs().duration(1).eut(1)
                .addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem(BiomesOPlenty.ID, "honeyBlock", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 1000)).noFluidOutputs().duration(400).eut(40)
                .addTo(sFluidSolidficationRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "bones", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 8, 15, missing)).outputChances(10000).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "bones", 1, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 12, 15, missing)).outputChances(10000).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "bones", 1, 2, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 24, 15, missing)).outputChances(10000).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "hardSand", 1, 0, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.SandDust", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 1802, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 1937, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 1833, missing))
                .outputChances(10000, 5000, 1000, 500).noFluidInputs().noFluidOutputs().duration(200).eut(8)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "hardDirt", 1, 0, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 1805, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 1622, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 1934, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 1823, missing))
                .outputChances(10000, 7500, 2500, 2500).noFluidInputs().noFluidOutputs().duration(200).eut(8)
                .addTo(sMaceratorRecipes);

    }
}
