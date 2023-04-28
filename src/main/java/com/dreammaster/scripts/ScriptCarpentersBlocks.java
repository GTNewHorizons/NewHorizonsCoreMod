package com.dreammaster.scripts;

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
        return Arrays.asList(Mods.CarpentersBlocks.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("CarpentersBlocks", "blockCarpentersBlock", 2, 0, missing),
                new Object[] { "frameGtWood", getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing),
                        "frameGtWood", getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing),
                        "craftingToolScrewdriver", getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing),
                        "frameGtWood", getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing), "frameGtWood" });
        addShapedRecipe(
                getModItem("CarpentersBlocks", "blockCarpentersBlock", 8, 0, missing),
                new Object[] { "frameGtWood", getModItem("gregtech", "gt.metaitem.01", 1, 27032, missing),
                        "frameGtWood", "frameGtWood", "craftingToolScrewdriver", "frameGtWood", "frameGtWood",
                        getModItem("gregtech", "gt.metaitem.01", 1, 27032, missing), "frameGtWood" });
        addShapedRecipe(
                getModItem("CarpentersBlocks", "blockCarpentersBlock", 12, 0, missing),
                new Object[] { "frameGtWood", getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                        "frameGtWood", "frameGtWood", "craftingToolScrewdriver", "frameGtWood", "frameGtWood",
                        getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing), "frameGtWood" });
        addShapedRecipe(
                getModItem("CarpentersBlocks", "blockCarpentersBlock", 16, 0, missing),
                new Object[] { "frameGtWood", getModItem("gregtech", "gt.metaitem.01", 1, 27019, missing),
                        "frameGtWood", "frameGtWood", "craftingToolScrewdriver", "frameGtWood", "frameGtWood",
                        getModItem("gregtech", "gt.metaitem.01", 1, 27019, missing), "frameGtWood" });
        addShapedRecipe(
                getModItem("CarpentersBlocks", "blockCarpentersBlock", 20, 0, missing),
                new Object[] { "frameGtWood", getModItem("gregtech", "gt.metaitem.01", 1, 27306, missing),
                        "frameGtWood", "frameGtWood", "craftingToolScrewdriver", "frameGtWood", "frameGtWood",
                        getModItem("gregtech", "gt.metaitem.01", 1, 27306, missing), "frameGtWood" });
        addShapedRecipe(
                getModItem("CarpentersBlocks", "blockCarpentersBlock", 24, 0, missing),
                new Object[] { "frameGtWood", getModItem("gregtech", "gt.metaitem.01", 1, 27028, missing),
                        "frameGtWood", "frameGtWood", "craftingToolScrewdriver", "frameGtWood", "frameGtWood",
                        getModItem("gregtech", "gt.metaitem.01", 1, 27028, missing), "frameGtWood" });
        addShapedRecipe(
                getModItem("CarpentersBlocks", "blockCarpentersCollapsibleBlock", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing), "craftingToolScrewdriver",
                        getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32470, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32470, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32470, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing) });
        addShapedRecipe(
                getModItem("CarpentersBlocks", "itemCarpentersChisel", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("TConstruct", "chiselHead", 1, 2, missing),
                        "craftingToolSaw", getModItem("gregtech", "gt.metaitem.01", 1, 27032, missing), "stickAnyIron",
                        getModItem("gregtech", "gt.metaitem.01", 1, 27032, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), "stickAnyIron",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem("CarpentersBlocks", "itemCarpentersHammer", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("gregtech", "gt.metaitem.02", 1, 5032, missing),
                        "craftingToolSaw", getModItem("gregtech", "gt.metaitem.01", 1, 27032, missing), "stickAnyIron",
                        getModItem("gregtech", "gt.metaitem.01", 1, 27032, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), "stickAnyIron",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem("CarpentersBlocks", "blockCarpentersSafe", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 27032, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersCollapsibleBlock", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27032, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersCollapsibleBlock", 1, 0, missing),
                        getModItem("IC2", "blockPersonal", 1, 0, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersCollapsibleBlock", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27032, missing), "craftingToolScrewdriver",
                        getModItem("gregtech", "gt.metaitem.01", 1, 27032, missing) });
        addShapedRecipe(
                getModItem("CarpentersBlocks", "blockCarpentersDaylightSensor", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 27032, missing), "craftingToolScrewdriver",
                        getModItem("gregtech", "gt.metaitem.01", 1, 27032, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("minecraft", "daylight_detector", 1, 0, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), "dustRedstone",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem("CarpentersBlocks", "itemCarpentersBed", 1, 0, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 32767, missing),
                        getModItem("minecraft", "carpet", 1, 32767, missing),
                        getModItem("minecraft", "carpet", 1, 32767, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBarrier", 1, 0, missing),
                        "craftingToolSoftHammer",
                        getModItem("CarpentersBlocks", "blockCarpentersBarrier", 1, 0, missing) });
        addShapedRecipe(
                getModItem("CarpentersBlocks", "blockCarpentersTorch", 2, 0, missing),
                new Object[] { getModItem("minecraft", "torch", 1, 0, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("minecraft", "torch", 1, 0, missing) });
        addShapedRecipe(
                getModItem("CarpentersBlocks", "blockCarpentersGarageDoor", 5, 0, missing),
                new Object[] { getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), "ringIron",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), "ringIron",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), "ringIron",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), "ringIron",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem("CarpentersBlocks", "blockCarpentersLadder", 1, 0, missing),
                new Object[] { getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("minecraft", "ladder", 1, 0, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing), "craftingToolScrewdriver",
                        getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing) });
        addShapedRecipe(
                getModItem("CarpentersBlocks", "blockCarpentersBarrier", 1, 0, missing),
                new Object[] { getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), "fenceWood",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing), "craftingToolScrewdriver",
                        getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing) });
        addShapedRecipe(
                getModItem("CarpentersBlocks", "blockCarpentersPressurePlate", 2, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), "springAnyIron",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing), "craftingToolScrewdriver",
                        getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing) });
        addShapelessCraftingRecipe(
                getModItem("CarpentersBlocks", "blockCarpentersButton", 1, 0, missing),
                new Object[] { "craftingToolSaw",
                        getModItem("CarpentersBlocks", "blockCarpentersPressurePlate", 1, 0, missing) });
        addShapedRecipe(
                getModItem("CarpentersBlocks", "blockCarpentersFlowerPot", 1, 0, missing),
                new Object[] { getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("minecraft", "flower_pot", 1, 0, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), null,
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("CarpentersBlocks", "blockCarpentersGate", 1, 0, missing),
                new Object[] { getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("minecraft", "fence_gate", 1, 0, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing), "craftingToolScrewdriver",
                        getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing) });
        addShapedRecipe(
                getModItem("CarpentersBlocks", "blockCarpentersHatch", 1, 0, missing),
                new Object[] { getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("minecraft", "trapdoor", 1, 0, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing), "craftingToolScrewdriver",
                        getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing) });
        addShapedRecipe(
                getModItem("CarpentersBlocks", "blockCarpentersLever", 1, 0, missing),
                new Object[] { getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("minecraft", "lever", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing), null, "craftingToolScrewdriver",
                        null });
        addShapelessCraftingRecipe(
                getModItem("CarpentersBlocks", "blockCarpentersSlope", 2, 0, missing),
                new Object[] { getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        "craftingToolSaw" });
        addShapelessCraftingRecipe(
                getModItem("CarpentersBlocks", "blockCarpentersStairs", 1, 0, missing),
                new Object[] { "craftingToolSaw",
                        getModItem("CarpentersBlocks", "blockCarpentersSlope", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("CarpentersBlocks", "itemCarpentersTile", 1, 0, missing),
                new Object[] { getModItem("CarpentersBlocks", "blockCarpentersPressurePlate", 1, 0, missing),
                        "craftingToolRollingPin", "itemClay" });
        addShapedRecipe(
                getModItem("CarpentersBlocks", "itemCarpentersDoor", 1, 0, missing),
                new Object[] { getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("minecraft", "wooden_door", 1, 0, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing), "craftingToolScrewdriver",
                        getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing) });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 2, 4905, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 27809, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersBlock", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 3, 4905, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27032, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersBlock", 8, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 3, 4905, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersBlock", 12, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(48).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 3, 4905, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27019, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersBlock", 16, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 3, 4905, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27306, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersBlock", 20, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 3, 4905, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27028, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersBlock", 24, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "fence", 1, 0, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersBarrier", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32470, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersCollapsibleBlock", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("minecraft", "flower_pot", 1, 0, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersFlowerPot", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28032, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersGarageDoor", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(150).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28305, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersGarageDoor", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "fence_gate", 1, 0, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersGate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("minecraft", "trapdoor", 1, 0, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersHatch", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("minecraft", "ladder", 1, 0, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersLadder", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("minecraft", "lever", 1, 0, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersLever", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("CarpentersBlocks", "blockCarpentersCollapsibleBlock", 3, 0, missing),
                        getModItem("IC2", "blockPersonal", 1, 0, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersSafe", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("minecraft", "torch", 10, 0, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersTorch", 10, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("TConstruct", "chiselHead", 1, 2, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "itemCarpentersChisel", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 5032, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "itemCarpentersHammer", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("CarpentersBlocks", "blockCarpentersPressurePlate", 1, 0, missing),
                        getModItem("minecraft", "clay_ball", 1, 0, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "itemCarpentersTile", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("minecraft", "wooden_door", 1, 0, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "itemCarpentersDoor", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(150).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersPressurePlate", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersPressurePlate", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("CarpentersBlocks", "blockCarpentersPressurePlate", 1, 0, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersButton", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 20)).noFluidOutputs().duration(100).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("CarpentersBlocks", "blockCarpentersPressurePlate", 1, 0, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersButton", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 10)).noFluidOutputs().duration(100)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("CarpentersBlocks", "blockCarpentersPressurePlate", 1, 0, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersButton", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).noFluidOutputs().duration(50).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("CarpentersBlocks", "blockCarpentersSlope", 1, 0, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersStairs", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 20)).noFluidOutputs().duration(100).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("CarpentersBlocks", "blockCarpentersSlope", 1, 0, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersStairs", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 10)).noFluidOutputs().duration(100)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("CarpentersBlocks", "blockCarpentersSlope", 1, 0, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersStairs", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).noFluidOutputs().duration(50).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersSlope", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 20)).noFluidOutputs().duration(100).eut(16)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersSlope", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 10)).noFluidOutputs().duration(100)
                .eut(16).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing))
                .itemOutputs(getModItem("CarpentersBlocks", "blockCarpentersSlope", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).noFluidOutputs().duration(50).eut(16)
                .addTo(sCutterRecipes);

    }
}
