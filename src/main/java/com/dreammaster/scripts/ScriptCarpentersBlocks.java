package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.CarpentersBlocks;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCutterRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptCarpentersBlocks implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Carpenters Blocks";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.CarpentersBlocks.ID, IndustrialCraft2.ID, TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 2, 0, missing),
                new Object[] { "frameGtWood", getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing),
                        "frameGtWood", getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing),
                        "craftingToolScrewdriver", getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing),
                        "frameGtWood", getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing), "frameGtWood" });
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 8, 0, missing),
                new Object[] { "frameGtWood", getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing),
                        "frameGtWood", "frameGtWood", "craftingToolScrewdriver", "frameGtWood", "frameGtWood",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing), "frameGtWood" });
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 12, 0, missing),
                new Object[] { "frameGtWood", getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                        "frameGtWood", "frameGtWood", "craftingToolScrewdriver", "frameGtWood", "frameGtWood",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing), "frameGtWood" });
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 16, 0, missing),
                new Object[] { "frameGtWood", getModItem(GregTech.ID, "gt.metaitem.01", 1, 27019, missing),
                        "frameGtWood", "frameGtWood", "craftingToolScrewdriver", "frameGtWood", "frameGtWood",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27019, missing), "frameGtWood" });
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 20, 0, missing),
                new Object[] { "frameGtWood", getModItem(GregTech.ID, "gt.metaitem.01", 1, 27306, missing),
                        "frameGtWood", "frameGtWood", "craftingToolScrewdriver", "frameGtWood", "frameGtWood",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27306, missing), "frameGtWood" });
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 24, 0, missing),
                new Object[] { "frameGtWood", getModItem(GregTech.ID, "gt.metaitem.01", 1, 27028, missing),
                        "frameGtWood", "frameGtWood", "craftingToolScrewdriver", "frameGtWood", "frameGtWood",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27028, missing), "frameGtWood" });
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersCollapsibleBlock", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing), "craftingToolScrewdriver",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32470, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32470, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32470, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing) });
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "itemCarpentersChisel", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", getModItem(TinkerConstruct.ID, "chiselHead", 1, 2, missing),
                        "craftingToolSaw", getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing), "stickAnyIron",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing), "stickAnyIron",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "itemCarpentersHammer", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", getModItem(GregTech.ID, "gt.metaitem.02", 1, 5032, missing),
                        "craftingToolSaw", getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing), "stickAnyIron",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing), "stickAnyIron",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersSafe", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersCollapsibleBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersCollapsibleBlock", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockPersonal", 1, 0, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersCollapsibleBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing), "craftingToolScrewdriver",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing) });
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersDaylightSensor", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing), "craftingToolScrewdriver",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(Minecraft.ID, "daylight_detector", 1, 0, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing), "dustRedstone",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "itemCarpentersBed", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 32767, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 32767, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 32767, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBarrier", 1, 0, missing),
                        "craftingToolSoftHammer",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBarrier", 1, 0, missing) });
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersTorch", 2, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "torch", 1, 0, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(Minecraft.ID, "torch", 1, 0, missing) });
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersGarageDoor", 5, 0, missing),
                new Object[] { getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing), "ringIron",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing), "ringIron",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing), "ringIron",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing), "ringIron",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersLadder", 1, 0, missing),
                new Object[] { getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(Minecraft.ID, "ladder", 1, 0, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing), "craftingToolScrewdriver",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing) });
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersBarrier", 1, 0, missing),
                new Object[] { getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing), "fenceWood",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing), "craftingToolScrewdriver",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing) });
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 2, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing), "craftingToolHardHammer",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing), "springAnyIron",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing), "craftingToolScrewdriver",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing) });
        addShapelessCraftingRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersButton", 1, 0, missing),
                new Object[] { "craftingToolSaw",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 1, 0, missing) });
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersFlowerPot", 1, 0, missing),
                new Object[] { getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(Minecraft.ID, "flower_pot", 1, 0, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing), null,
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersGate", 1, 0, missing),
                new Object[] { getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(Minecraft.ID, "fence_gate", 1, 0, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing), "craftingToolScrewdriver",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing) });
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersHatch", 1, 0, missing),
                new Object[] { getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing), "craftingToolScrewdriver",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing) });
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersLever", 1, 0, missing),
                new Object[] { getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(Minecraft.ID, "lever", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing), null, "craftingToolScrewdriver",
                        null });
        addShapelessCraftingRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 2, 0, missing),
                new Object[] { getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        "craftingToolSaw" });
        addShapelessCraftingRecipe(
                getModItem(CarpentersBlocks.ID, "blockCarpentersStairs", 1, 0, missing),
                new Object[] { "craftingToolSaw",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(CarpentersBlocks.ID, "itemCarpentersTile", 1, 0, missing),
                new Object[] { getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 1, 0, missing),
                        "craftingToolRollingPin", "itemClay" });
        addShapedRecipe(
                getModItem(CarpentersBlocks.ID, "itemCarpentersDoor", 1, 0, missing),
                new Object[] { getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(Minecraft.ID, "wooden_door", 1, 0, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing), "craftingToolScrewdriver",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing) });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 4905, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 27809, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 3, 4905, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 8, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 3, 4905, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 12, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(48).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 3, 4905, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27019, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 16, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 3, 4905, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27306, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 20, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 3, 4905, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27028, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 24, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "fence", 1, 0, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBarrier", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32470, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersCollapsibleBlock", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(Minecraft.ID, "flower_pot", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersFlowerPot", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28032, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersGarageDoor", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(150).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28305, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersGarageDoor", 4, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "fence_gate", 1, 0, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersGate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersHatch", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(Minecraft.ID, "ladder", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersLadder", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(Minecraft.ID, "lever", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersLever", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersCollapsibleBlock", 3, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockPersonal", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSafe", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(Minecraft.ID, "torch", 10, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersTorch", 10, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "chiselHead", 1, 2, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "itemCarpentersChisel", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 5032, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "itemCarpentersHammer", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 1, 0, missing),
                        getModItem(Minecraft.ID, "clay_ball", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "itemCarpentersTile", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(Minecraft.ID, "wooden_door", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "itemCarpentersDoor", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(150).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersButton", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 20)).noFluidOutputs().duration(100).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersButton", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 10)).noFluidOutputs().duration(100)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersButton", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).noFluidOutputs().duration(50).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersStairs", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 20)).noFluidOutputs().duration(100).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersStairs", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 10)).noFluidOutputs().duration(100)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersStairs", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).noFluidOutputs().duration(50).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 20)).noFluidOutputs().duration(100).eut(16)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 10)).noFluidOutputs().duration(100)
                .eut(16).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing))
                .itemOutputs(getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).noFluidOutputs().duration(50).eut(16)
                .addTo(sCutterRecipes);

    }
}
