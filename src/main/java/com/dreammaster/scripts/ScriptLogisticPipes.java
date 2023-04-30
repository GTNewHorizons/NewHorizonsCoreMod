package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sChemicalBathRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sPressRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptLogisticPipes implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Logistic Pipes";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList("LogisticsPipes", Mods.ProjectRedCore.ID);
    }

    @Override
    public void loadRecipes() {
        addShapelessCraftingRecipe(
                getModItem("LogisticsPipes", "item.itemModule", 1, 0, missing),
                new Object[] { getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                new Object[] { getModItem("LogisticsPipes", "item.itemModule", 1, 0, missing) });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.logisticsParts", 1, 2, missing),
                new Object[] { "boltRedSteel", "stickDiamond", "boltRedSteel", "craftingToolFile", "screwTitanium",
                        "craftingToolSoftHammer", null, "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.logisticsHUDGlasses", 1, 0, missing),
                new Object[] { getModItem("LogisticsPipes", "item.logisticsParts", 1, 1, missing),
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 2, missing),
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 1, missing), "screwTitanium",
                        "circuitAdvanced", "screwTitanium",
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 0, missing) });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemDisk", 1, 0, missing),
                new Object[] { "plateCarbon", "plateCarbon", "plateCarbon", "plateCarbon",
                        getModItem("OpenComputers", "item", 1, 19, missing), "plateCarbon", "plateCarbon",
                        "circuitPrimitive", "plateCarbon" });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 0, missing),
                new Object[] { null, null, "craftingToolScrewdriver", null,
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 1, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 0, missing),
                new Object[] { null, null, "craftingToolScrewdriver", null,
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 2, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 0, missing),
                new Object[] { null, null, "craftingToolScrewdriver", null,
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 3, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 0, missing),
                new Object[] { null, null, "craftingToolScrewdriver", null,
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 4, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 0, missing),
                new Object[] { null, null, "craftingToolScrewdriver", null,
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 5, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 1, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 0, missing),
                        null, null, null, "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 1, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 2, missing),
                        null, null, null, "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 1, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 3, missing),
                        null, null, null, "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 1, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 4, missing),
                        null, null, null, "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 1, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 5, missing),
                        null, null, null, "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 2, missing),
                new Object[] { null, "craftingToolScrewdriver", null, null,
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 1, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 2, missing),
                new Object[] { null, "craftingToolScrewdriver", null, null,
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 0, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 2, missing),
                new Object[] { null, "craftingToolScrewdriver", null, null,
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 3, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 2, missing),
                new Object[] { null, "craftingToolScrewdriver", null, null,
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 4, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 2, missing),
                new Object[] { null, "craftingToolScrewdriver", null, null,
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 5, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 3, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 1, missing),
                        null, null, "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 3, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 2, missing),
                        null, null, "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 3, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 0, missing),
                        null, null, "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 3, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 4, missing),
                        null, null, "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 3, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 5, missing),
                        null, null, "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 4, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 1, missing),
                        "craftingToolScrewdriver", null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 4, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 2, missing),
                        "craftingToolScrewdriver", null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 4, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 3, missing),
                        "craftingToolScrewdriver", null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 4, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 0, missing),
                        "craftingToolScrewdriver", null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 4, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 5, missing),
                        "craftingToolScrewdriver", null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 5, missing),
                new Object[] { null, null, null, "craftingToolScrewdriver",
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 1, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 5, missing),
                new Object[] { null, null, null, "craftingToolScrewdriver",
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 2, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 5, missing),
                new Object[] { null, null, null, "craftingToolScrewdriver",
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 3, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 5, missing),
                new Object[] { null, null, null, "craftingToolScrewdriver",
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 4, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 5, missing),
                new Object[] { null, null, null, "craftingToolScrewdriver",
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 0, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 10, missing),
                new Object[] { null, null, "craftingToolScrewdriver", null,
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 11, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 10, missing),
                new Object[] { null, null, "craftingToolScrewdriver", null,
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 12, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 10, missing),
                new Object[] { null, null, "craftingToolScrewdriver", null,
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 13, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 10, missing),
                new Object[] { null, null, "craftingToolScrewdriver", null,
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 14, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 10, missing),
                new Object[] { null, null, "craftingToolScrewdriver", null,
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 15, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 11, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 10, missing),
                        null, null, null, "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 11, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 12, missing),
                        null, null, null, "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 11, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 13, missing),
                        null, null, null, "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 11, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 14, missing),
                        null, null, null, "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 11, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 15, missing),
                        null, null, null, "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 12, missing),
                new Object[] { null, "craftingToolScrewdriver", null, null,
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 11, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 12, missing),
                new Object[] { null, "craftingToolScrewdriver", null, null,
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 10, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 12, missing),
                new Object[] { null, "craftingToolScrewdriver", null, null,
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 13, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 12, missing),
                new Object[] { null, "craftingToolScrewdriver", null, null,
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 14, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 12, missing),
                new Object[] { null, "craftingToolScrewdriver", null, null,
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 15, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 13, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 11, missing),
                        null, null, "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 13, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 12, missing),
                        null, null, "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 13, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 10, missing),
                        null, null, "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 13, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 14, missing),
                        null, null, "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 13, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 15, missing),
                        null, null, "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 14, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 11, missing),
                        "craftingToolScrewdriver", null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 14, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 12, missing),
                        "craftingToolScrewdriver", null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 14, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 13, missing),
                        "craftingToolScrewdriver", null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 14, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 10, missing),
                        "craftingToolScrewdriver", null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 14, missing),
                new Object[] { null, null, null, null, getModItem("LogisticsPipes", "item.itemUpgrade", 1, 15, missing),
                        "craftingToolScrewdriver", null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 15, missing),
                new Object[] { null, null, null, "craftingToolScrewdriver",
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 11, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 15, missing),
                new Object[] { null, null, null, "craftingToolScrewdriver",
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 12, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 15, missing),
                new Object[] { null, null, null, "craftingToolScrewdriver",
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 13, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 15, missing),
                new Object[] { null, null, null, "craftingToolScrewdriver",
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 14, missing), null, null, null, null });
        addShapedRecipe(
                getModItem("LogisticsPipes", "item.itemUpgrade", 1, 15, missing),
                new Object[] { null, null, null, "craftingToolScrewdriver",
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 10, missing), null, null, null, null });

        recipes1();
        recipes2();
        recipes3();

    }

    private void recipes1() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("IC2", "itemPartCircuit", 2, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1368, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32701, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1368, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32078, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1368, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1368, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("IC2", "itemPartCircuit", 2, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1388, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32701, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1388, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32078, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1388, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1388, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("IC2", "itemPartCircuit", 2, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1368, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32701, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1368, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32078, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1368, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1368, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("IC2", "itemPartCircuit", 2, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1388, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32701, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1388, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32078, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1388, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1388, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("IC2", "itemPartCircuit", 2, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1368, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32701, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1368, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32078, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1368, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1368, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("IC2", "itemPartCircuit", 2, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1388, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32701, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1388, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32078, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1388, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1388, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.02", 2, 22305, missing),
                        getModItem("bartworks", "BWPumpParts", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 19086, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 8, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.02", 2, 22305, missing),
                        getModItem("Railcraft", "glass", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 8, 19086, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 32, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.02", 2, 22305, missing),
                        getModItem("ExtraUtilities", "decorativeBlock2", 4, 5, missing),
                        getModItem("gregtech", "gt.metaitem.02", 8, 19086, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 32, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.02", 2, 22019, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17602, missing),
                        getModItem("gregtech", "gt.metaitem.02", 16, 19086, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 64, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.02", 2, 22019, missing),
                        getModItem("dreamcraft", "item.ReinforcedGlassPlate", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 16, 19086, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 64, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.02", 1, 22306, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17611, missing),
                        getModItem("gregtech", "gt.metaitem.02", 16, 19086, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 64, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 20086, missing),
                        getModItem("gregtech", "gt.metaitem.02", 8, 28500, missing),
                        getModItem("IC2", "itemPartCircuit", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 16, 19054, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 20086, missing),
                        getModItem("gregtech", "gt.metaitem.02", 8, 28500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.02", 16, 19054, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 20086, missing),
                        getModItem("gregtech", "gt.metaitem.02", 8, 28500, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.02", 16, 19054, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 20086, missing),
                        getModItem("gregtech", "gt.metaitem.02", 8, 28500, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem("gregtech", "gt.metaitem.02", 16, 19054, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 20086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 23500, missing),
                        getModItem("IC2", "itemPartCircuit", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 16, 19054, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 20086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 23500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.02", 16, 19054, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 20086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 23500, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.02", 16, 19054, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 20086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 23500, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem("gregtech", "gt.metaitem.02", 16, 19054, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 16, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 20086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 23500, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 16, 19054, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 16, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 16, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 20086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 23500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32702, missing),
                        getModItem("gregtech", "gt.metaitem.02", 16, 19054, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 16, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 16, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 20086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 23500, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32079, missing),
                        getModItem("gregtech", "gt.metaitem.02", 16, 19054, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 16, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 16, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 20086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 23500, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32080, missing),
                        getModItem("gregtech", "gt.metaitem.02", 16, 19054, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 16, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 16, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 20086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 23500, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 2, 6, missing),
                        getModItem("gregtech", "gt.metaitem.02", 16, 19054, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 16, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 32, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 20086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 23500, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 16, 19054, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 32, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 32, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 20086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 23500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32703, missing),
                        getModItem("gregtech", "gt.metaitem.02", 16, 19054, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 32, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 32, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 20086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 23500, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32082, missing),
                        getModItem("gregtech", "gt.metaitem.02", 16, 19054, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 32, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicTransport", 32, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 20086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 23500, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.02", 16, 19054, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 32, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("minecraft", "enchanted_book", 1, 32767, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 31, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 31, missing),
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 131, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 12, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 12, missing),
                        getModItem("minecraft", "writable_book", 1, 32767, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 13, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("Thaumcraft", "ItemShard", 4, 6, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 30, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 12, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 2, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 16, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("ExtraUtilities", "trashcan", 1, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 6, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 3, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 3, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 3, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 3, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 3, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 3, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 3, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 3, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 3, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 3, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 3, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 3, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 3, 2, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 2, 2, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 3, 502, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26086, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 500, missing),
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 6, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 3, missing),
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 103, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 3, missing),
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 6, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 203, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 3, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 3, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 3, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 3, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 3, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 3, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 7, missing),
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 107, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 103, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 3, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 107, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 107, missing),
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 6, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 207, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 203, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 3, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 207, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("IC2", "itemBatREDischarged", 1, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 300, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("IC2", "itemBatRE", 1, 32767, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 300, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
    }

    private void recipes2() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 30, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 17, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 30, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 17, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 30, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 17, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 2, 2, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26334, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 2, 2, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26334, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 2, 2, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26334, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 2, 2, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26334, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 2, 2, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26334, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 2, 2, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26334, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 2, 2, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26334, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 2, 2, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26334, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 2, 2, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26334, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 2, 2, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26334, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 2, 2, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26334, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 2, 2, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26334, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 2, 2, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26334, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 2, 2, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26334, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 2, 2, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26334, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing),
                        getModItem("IC2", "upgradeModule", 4, 0, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 2, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing),
                        getModItem("IC2", "upgradeModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32703, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing),
                        getModItem("IC2", "upgradeModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32082, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing),
                        getModItem("IC2", "upgradeModule", 4, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 2, 7, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing),
                        getModItem("IC2", "upgradeModule", 4, 0, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 2, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing),
                        getModItem("IC2", "upgradeModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32703, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing),
                        getModItem("IC2", "upgradeModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32082, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing),
                        getModItem("IC2", "upgradeModule", 4, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 2, 7, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing),
                        getModItem("IC2", "upgradeModule", 4, 0, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 2, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing),
                        getModItem("IC2", "upgradeModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32703, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing),
                        getModItem("IC2", "upgradeModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32082, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing),
                        getModItem("IC2", "upgradeModule", 4, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 2, 7, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing),
                        getModItem("dreamcraft", "item.GoldCoreChip", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32651, missing),
                        getModItem("IC2", "upgradeModule", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 288)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing),
                        getModItem("dreamcraft", "item.GoldCoreChip", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32651, missing),
                        getModItem("IC2", "upgradeModule", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 5, missing),
                        getModItem("dreamcraft", "item.GoldCoreChip", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32651, missing),
                        getModItem("IC2", "upgradeModule", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 7, missing),
                        getModItem("dreamcraft", "item.DiamondCoreChip", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("IC2", "upgradeModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 32, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 576)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 7, missing),
                        getModItem("dreamcraft", "item.DiamondCoreChip", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("IC2", "upgradeModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 32, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 288)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 7, missing),
                        getModItem("dreamcraft", "item.DiamondCoreChip", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("IC2", "upgradeModule", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 32, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 144)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("dreamcraft", "item.Display", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("OpenComputers", "keyboard", 1, 0, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem("IronChest", "BlockIronChest", 1, 3, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 2, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeBlockRequestTable", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("dreamcraft", "item.Display", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("OpenComputers", "keyboard", 1, 0, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem("IronChest", "BlockIronChest", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32702, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeBlockRequestTable", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("dreamcraft", "item.Display", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("OpenComputers", "keyboard", 1, 0, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem("IronChest", "BlockIronChest", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32079, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeBlockRequestTable", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("dreamcraft", "item.Display", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("OpenComputers", "keyboard", 1, 0, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem("IronChest", "BlockIronChest", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32080, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeBlockRequestTable", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("dreamcraft", "item.Display", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("OpenComputers", "keyboard", 1, 0, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem("IronChest", "BlockIronChest", 1, 3, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 2, 6, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeBlockRequestTable", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32703, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32082, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32703, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32082, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32703, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32082, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32703, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32082, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32703, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32082, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem("IC2", "itemPlates", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32703, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32082, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 5, missing),
                        getModItem("OpenComputers", "item", 1, 70, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 14, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("OpenComputers", "item", 1, 70, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 15, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 17019, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 2, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1369, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 17019, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32703, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1369, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 17019, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32082, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1369, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 17019, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 2, 7, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1369, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("Forestry", "factory2", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32651, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 600, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 2, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 1369, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("Forestry", "factory2", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32651, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 600, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32703, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 1369, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("Forestry", "factory2", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32651, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 600, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32082, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 1369, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("Forestry", "factory2", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32651, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 600, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 2, 7, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 1369, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 10, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32651, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 600, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 2, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 1369, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 10, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32651, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 600, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32703, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 1369, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 10, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32651, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 600, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32082, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 1369, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 10, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32651, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 600, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 2, 7, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 1369, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26348, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 3, missing),
                        getModItem("LogisticsPipes", "item.itemUpgrade", 1, 25, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 17019, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 2, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1367, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 17019, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32703, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1367, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 17019, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32082, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1367, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 17019, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 2, 7, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1367, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "logisticsSolidBlock", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 5, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 5, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 5, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 5, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 5, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 5, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 5, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 5, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 5, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 5, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 5, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 5, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 5, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 5, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 5, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 600, missing),
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 7, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 601, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(1920).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 2, 601, missing),
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 8, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 2, 602, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(7680).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("dreamcraft", "item.Display", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17019, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1360, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 27500, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("dreamcraft", "item.Display", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17019, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32703, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1360, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 27500, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("dreamcraft", "item.Display", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17019, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32082, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1360, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 27500, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("dreamcraft", "item.Display", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17019, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1360, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 27500, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 32767, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("chlorine", 1000)).noFluidOutputs().duration(1600).eut(30)
                .addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 1, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyeblack", 288)).noFluidOutputs().duration(1600)
                .eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 2, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyered", 288)).noFluidOutputs().duration(1600)
                .eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 3, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyegreen", 288)).noFluidOutputs().duration(1600)
                .eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 4, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyebrown", 288)).noFluidOutputs().duration(1600)
                .eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 5, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyeblue", 288)).noFluidOutputs().duration(1600)
                .eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 6, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyepurple", 288)).noFluidOutputs().duration(1600)
                .eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 7, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyecyan", 288)).noFluidOutputs().duration(1600)
                .eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 8, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyelightgray", 288)).noFluidOutputs()
                .duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 9, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyegray", 288)).noFluidOutputs().duration(1600)
                .eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 10, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyepink", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 11, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyelime", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 12, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyeyellow", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 13, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyelightblue", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 14, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyemagenta", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 15, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyeorange", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.remoteOrdererItem", 1, 16, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyewhite", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.Display", 1, 0, missing),
                        getModItem("OpenComputers", "keyboard", 1, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.pipeController", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.Display", 1, 0, missing),
                        getModItem("OpenComputers", "keyboard", 1, 0, missing),
                        getModItem("minecraft", "sign", 16, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.ItemPipeSignCreator", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 26348, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 22500, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 2, 3, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28019, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28019, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28019, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28019, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28019, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("Forestry", "apicultureChest", 1, 0, missing),
                        getModItem("Forestry", "propolis", 4, 0, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 1000)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("Forestry", "apicultureChest", 1, 0, missing),
                        getModItem("Forestry", "propolis", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 1000)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("Forestry", "apicultureChest", 1, 0, missing),
                        getModItem("Forestry", "propolis", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 1000)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("Forestry", "apicultureChest", 1, 0, missing),
                        getModItem("Forestry", "propolis", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 1000)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 1, missing),
                        getModItem("Forestry", "apicultureChest", 1, 0, missing),
                        getModItem("Forestry", "propolis", 4, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 1000)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsApiaristSink", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("ExtraUtilities", "trashcan", 1, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(120).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32682, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32682, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32682, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32682, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32682, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32682, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32682, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32682, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32682, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32682, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32682, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32682, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32682, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32682, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32682, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
    }

    private void recipes3() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.itemModule", 1, 9, missing),
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 8, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsApiaristAnalyser", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(1600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 600, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsCraftingLogistics", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsCraftingLogistics", 2, 0, missing),
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 7, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsCraftingLogisticsMk2", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 601, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsCraftingLogisticsMk2", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsCraftingLogisticsMk2", 2, 0, missing),
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 8, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsCraftingLogisticsMk3", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 602, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsCraftingLogisticsMk3", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32631, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 4, 1, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsRequestLogistics", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 6, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsRequestLogisticsMk2", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 500, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsProviderLogistics", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsProviderLogistics", 2, 0, missing),
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 6, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsProviderLogisticsMk2", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 501, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsProviderLogisticsMk2", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 502, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsSupplierLogistics", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17532, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsSatelliteLogistics", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.remoteOrdererItem", 0, 32767, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsRemoteOrdererLogistics", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem("minecraft", "web", 1, 0, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsFirewall", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(
                getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 2, 0, missing),
                getModItem("gregtech", "gt.metaitem.01", 2, 17381, missing),
                createItemStack("minecraft", "chest", 1, 0, "{display:{Name:\"Invalid OreDictionary Tag\"}}", missing),
                getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk1", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(
                getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 2, 0, missing),
                getModItem("miscutils", "itemPlateRedstoneAlloy", 2, 0, missing),
                createItemStack("minecraft", "chest", 1, 0, "{display:{Name:\"Invalid OreDictionary Tag\"}}", missing),
                getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk1", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17381, missing),
                        createItemStack(
                                "minecraft",
                                "trapped_chest",
                                1,
                                0,
                                "{display:{Name:\"Invalid OreDictionary Tag\"}}",
                                missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk1", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem("miscutils", "itemPlateRedstoneAlloy", 2, 0, missing),
                        createItemStack(
                                "minecraft",
                                "trapped_chest",
                                1,
                                0,
                                "{display:{Name:\"Invalid OreDictionary Tag\"}}",
                                missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk1", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk1", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17364, missing),
                        getModItem("IronChest", "BlockIronChest", 1, 3, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk2", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk2", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17351, missing),
                        getModItem("IronChest", "BlockIronChest", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk3", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk3", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17348, missing),
                        getModItem("IronChest", "BlockIronChest", 1, 4, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk4", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk4", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17028, missing),
                        getModItem("IronChest", "BlockIronChest", 1, 1, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk5", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17364, missing),
                        getModItem("IronChest", "BlockIronChest", 2, 3, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk2", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17364, missing),
                        getModItem("IronChest", "BlockIronChest", 2, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk2", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17364, missing),
                        getModItem("IronChest", "BlockIronChest", 2, 3, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk2", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17364, missing),
                        getModItem("IronChest", "BlockIronChest", 2, 3, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk2", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 6, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17351, missing),
                        getModItem("IronChest", "BlockIronChest", 2, 0, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk3", 6, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 6, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17351, missing),
                        getModItem("IronChest", "BlockIronChest", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk3", 6, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 6, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17351, missing),
                        getModItem("IronChest", "BlockIronChest", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk3", 6, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 6, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17351, missing),
                        getModItem("IronChest", "BlockIronChest", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk3", 6, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 6, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17351, missing),
                        getModItem("IronChest", "BlockIronChest", 2, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk3", 6, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 8, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17348, missing),
                        getModItem("IronChest", "BlockIronChest", 2, 4, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk4", 8, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 8, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17348, missing),
                        getModItem("IronChest", "BlockIronChest", 2, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32703, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk4", 8, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 8, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17348, missing),
                        getModItem("IronChest", "BlockIronChest", 2, 4, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32082, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk4", 8, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 8, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17348, missing),
                        getModItem("IronChest", "BlockIronChest", 2, 4, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk4", 8, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 12, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17028, missing),
                        getModItem("IronChest", "BlockIronChest", 2, 1, missing),
                        getModItem("dreamcraft", "item.CircuitEV", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk5", 12, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 12, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17028, missing),
                        getModItem("IronChest", "BlockIronChest", 2, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32704, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk5", 12, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 12, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17028, missing),
                        getModItem("IronChest", "BlockIronChest", 2, 1, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32083, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk5", 12, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 12, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17028, missing),
                        getModItem("IronChest", "BlockIronChest", 2, 1, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32085, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk5", 12, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 12, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17028, missing),
                        getModItem("IronChest", "BlockIronChest", 2, 1, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 8, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeLogisticsChassiMk5", 12, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("dreamcraft", "item.CircuitULV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32700, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32075, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("dreamcraft", "item.CircuitULV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19345, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32700, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19345, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32075, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19345, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19345, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("dreamcraft", "item.CircuitULV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32700, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32075, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("dreamcraft", "item.CircuitULV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19345, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32700, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19345, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32075, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19345, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19345, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("dreamcraft", "item.CircuitULV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32700, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32075, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("dreamcraft", "item.CircuitULV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19345, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32700, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19345, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32075, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19345, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 29057, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19345, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(
                getModItem("LogisticsPipes", "item.logisticsParts", 2, 4, missing),
                getModItem("dreamcraft", "item.CircuitULV", 1, 0, missing),
                createItemStack("minecraft", "chest", 1, 0, "{display:{Name:\"Invalid OreDictionary Tag\"}}", missing),
                getModItem("ProjRed|Core", "projectred.core.part", 2, 34, missing),
                getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(
                getModItem("LogisticsPipes", "item.logisticsParts", 2, 4, missing),
                getModItem("gregtech", "gt.metaitem.01", 1, 32700, missing),
                createItemStack("minecraft", "chest", 1, 0, "{display:{Name:\"Invalid OreDictionary Tag\"}}", missing),
                getModItem("ProjRed|Core", "projectred.core.part", 2, 34, missing),
                getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(
                getModItem("LogisticsPipes", "item.logisticsParts", 2, 4, missing),
                getModItem("gregtech", "gt.metaitem.03", 1, 32075, missing),
                createItemStack("minecraft", "chest", 1, 0, "{display:{Name:\"Invalid OreDictionary Tag\"}}", missing),
                getModItem("ProjRed|Core", "projectred.core.part", 2, 34, missing),
                getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(
                getModItem("LogisticsPipes", "item.logisticsParts", 2, 4, missing),
                getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 4, missing),
                createItemStack("minecraft", "chest", 1, 0, "{display:{Name:\"Invalid OreDictionary Tag\"}}", missing),
                getModItem("ProjRed|Core", "projectred.core.part", 2, 34, missing),
                getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 2, 4, missing),
                        getModItem("dreamcraft", "item.CircuitULV", 1, 0, missing),
                        createItemStack(
                                "minecraft",
                                "trapped_chest",
                                1,
                                0,
                                "{display:{Name:\"Invalid OreDictionary Tag\"}}",
                                missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 34, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 2, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32700, missing),
                        createItemStack(
                                "minecraft",
                                "trapped_chest",
                                1,
                                0,
                                "{display:{Name:\"Invalid OreDictionary Tag\"}}",
                                missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 34, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 2, 4, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32075, missing),
                        createItemStack(
                                "minecraft",
                                "trapped_chest",
                                1,
                                0,
                                "{display:{Name:\"Invalid OreDictionary Tag\"}}",
                                missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 34, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 2, 4, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        createItemStack(
                                "minecraft",
                                "trapped_chest",
                                1,
                                0,
                                "{display:{Name:\"Invalid OreDictionary Tag\"}}",
                                missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 34, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 2, 4, missing),
                        getModItem("minecraft", "wool", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 29305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 26, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 2, 25, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 2, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 2, 20, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1000)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 2, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32650, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 29308, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 2, 24, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 2, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 29308, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 33, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 2, 23, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 4, missing),
                        getModItem("IC2", "itemPlates", 1, 1, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 4, 42, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17057, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 4, 42, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 2, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 23, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 1, 21, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 4, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 207, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 2, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 33, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 1, 26, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 3, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 24, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 1, 41, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32682, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 33, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 1, 21, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing),
                        getModItem("miscutils", "MU-metaitem.01", 1, 32036, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 29300, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 33, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing),
                        getModItem("miscutils", "MU-metaitem.01", 1, 32036, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 29300, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 33, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 6, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing),
                        getModItem("miscutils", "MU-metaitem.01", 1, 32036, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 29300, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 33, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing),
                        getModItem("miscutils", "MU-metaitem.01", 1, 32036, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 29300, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 33, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 1, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing),
                        getModItem("miscutils", "MU-metaitem.01", 1, 32036, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 29300, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 33, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 4, 4, missing),
                        getModItem("miscutils", "MU-metaitem.01", 1, 32036, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 29300, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 33, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 1, 5, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 27, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 4, 10, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 4, missing),
                        getModItem("Railcraft", "part.plate", 1, 1, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 27, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 4, 10, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 27, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 6, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 4, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 4, missing),
                        getModItem("Railcraft", "part.plate", 1, 1, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 27, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 6, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 4, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 27, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 4, 12, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 4, missing),
                        getModItem("Railcraft", "part.plate", 1, 1, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 27, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 4, 12, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 27, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 4, 13, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 4, missing),
                        getModItem("Railcraft", "part.plate", 1, 1, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 27, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 4, 13, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 27, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 4, 14, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 4, missing),
                        getModItem("Railcraft", "part.plate", 1, 1, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 27, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 4, 14, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 27, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 4, 15, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 4, missing),
                        getModItem("Railcraft", "part.plate", 1, 1, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 27, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 4, 15, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 6, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32405, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeFluidBasic", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 6, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32405, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeFluidBasic", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeItemsBasicLogistics", 6, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32405, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeFluidBasic", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeFluidBasic", 3, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 502, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32405, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeFluidSupplierMk2", 3, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeFluidBasic", 3, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing),
                        getModItem("minecraft", "bucket", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32405, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeItemsFluidSupplier", 3, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeFluidBasic", 3, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32405, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeFluidProvider", 3, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeFluidBasic", 3, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32611, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32405, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeFluidInsertion", 3, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeFluidBasic", 1, 0, missing),
                        getModItem("LogisticsPipes", "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32405, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeFluidRequestLogistics", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeFluidBasic", 1, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17532, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeFluidSatellite", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.PipeFluidBasic", 4, 0, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32405, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.PipeFluidExtractor", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("LogisticsPipes", "item.logisticsParts", 1, 4, missing),
                        getModItem("LogisticsPipes", "item.itemModule", 1, 600, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32405, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem("LogisticsPipes", "item.itemUpgrade", 4, 22, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
    }
}
