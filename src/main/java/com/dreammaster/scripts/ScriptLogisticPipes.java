package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.BuildCraftSilicon;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.LogisticsPipes;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.ProjectRedCore;
import static gregtech.api.enums.Mods.ProjectRedExpansion;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sChemicalBathRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sPressRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;

public class ScriptLogisticPipes implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Logistic Pipes";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                LogisticsPipes.ID,
                ProjectRedExpansion.ID,
                ProjectRedCore.ID,
                AppliedEnergistics2.ID,
                BartWorks.ID,
                BuildCraftSilicon.ID,
                ExtraUtilities.ID,
                Forestry.ID,
                GTPlusPlus.ID,
                GalacticraftCore.ID,
                IndustrialCraft2.ID,
                IronChests.ID,
                OpenComputers.ID,
                Railcraft.ID,
                Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {
        addShapelessCraftingRecipe(
                getModItem(LogisticsPipes.ID, "item.itemModule", 1, 0, missing),
                new Object[] { getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 44, missing) });
        addShapelessCraftingRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 44, missing),
                new Object[] { getModItem(LogisticsPipes.ID, "item.itemModule", 1, 0, missing) });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 2, missing),
                new Object[] { "boltRedSteel", "stickDiamond", "boltRedSteel", "craftingToolFile", "screwTitanium",
                        "craftingToolSoftHammer", null, "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.logisticsHUDGlasses", 1, 0, missing),
                new Object[] { getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 1, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 2, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 1, missing), "screwTitanium",
                        "circuitAdvanced", "screwTitanium",
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 0, missing) });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemDisk", 1, 0, missing),
                new Object[] { "plateCarbon", "plateCarbon", "plateCarbon", "plateCarbon",
                        getModItem(OpenComputers.ID, "item", 1, 19, missing), "plateCarbon", "plateCarbon",
                        "circuitPrimitive", "plateCarbon" });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing),
                new Object[] { null, null, "craftingToolScrewdriver", null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing),
                new Object[] { null, null, "craftingToolScrewdriver", null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing),
                new Object[] { null, null, "craftingToolScrewdriver", null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing),
                new Object[] { null, null, "craftingToolScrewdriver", null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing),
                new Object[] { null, null, "craftingToolScrewdriver", null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing),
                new Object[] { null, null, null, null, getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing),
                        null, null, null, "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing),
                new Object[] { null, null, null, null, getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing),
                        null, null, null, "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing),
                new Object[] { null, null, null, null, getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing),
                        null, null, null, "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing),
                new Object[] { null, null, null, null, getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing),
                        null, null, null, "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing),
                new Object[] { null, null, null, null, getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing),
                        null, null, null, "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing),
                new Object[] { null, "craftingToolScrewdriver", null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing),
                new Object[] { null, "craftingToolScrewdriver", null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing),
                new Object[] { null, "craftingToolScrewdriver", null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing),
                new Object[] { null, "craftingToolScrewdriver", null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing),
                new Object[] { null, "craftingToolScrewdriver", null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing),
                new Object[] { null, null, null, null, getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing),
                        null, null, "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing),
                new Object[] { null, null, null, null, getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing),
                        null, null, "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing),
                new Object[] { null, null, null, null, getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing),
                        null, null, "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing),
                new Object[] { null, null, null, null, getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing),
                        null, null, "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing),
                new Object[] { null, null, null, null, getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing),
                        null, null, "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing),
                new Object[] { null, null, null, null, getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing),
                        "craftingToolScrewdriver", null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing),
                new Object[] { null, null, null, null, getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing),
                        "craftingToolScrewdriver", null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing),
                new Object[] { null, null, null, null, getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing),
                        "craftingToolScrewdriver", null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing),
                new Object[] { null, null, null, null, getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing),
                        "craftingToolScrewdriver", null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing),
                new Object[] { null, null, null, null, getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing),
                        "craftingToolScrewdriver", null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing),
                new Object[] { null, null, null, "craftingToolScrewdriver",
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing),
                new Object[] { null, null, null, "craftingToolScrewdriver",
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing),
                new Object[] { null, null, null, "craftingToolScrewdriver",
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing),
                new Object[] { null, null, null, "craftingToolScrewdriver",
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing),
                new Object[] { null, null, null, "craftingToolScrewdriver",
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 10, missing),
                new Object[] { null, null, "craftingToolScrewdriver", null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 11, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 10, missing),
                new Object[] { null, null, "craftingToolScrewdriver", null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 12, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 10, missing),
                new Object[] { null, null, "craftingToolScrewdriver", null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 13, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 10, missing),
                new Object[] { null, null, "craftingToolScrewdriver", null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 14, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 10, missing),
                new Object[] { null, null, "craftingToolScrewdriver", null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 15, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 11, missing),
                new Object[] { null, null, null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 10, missing), null, null, null,
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 11, missing),
                new Object[] { null, null, null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 12, missing), null, null, null,
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 11, missing),
                new Object[] { null, null, null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 13, missing), null, null, null,
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 11, missing),
                new Object[] { null, null, null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 14, missing), null, null, null,
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 11, missing),
                new Object[] { null, null, null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 15, missing), null, null, null,
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 12, missing),
                new Object[] { null, "craftingToolScrewdriver", null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 11, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 12, missing),
                new Object[] { null, "craftingToolScrewdriver", null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 10, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 12, missing),
                new Object[] { null, "craftingToolScrewdriver", null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 13, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 12, missing),
                new Object[] { null, "craftingToolScrewdriver", null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 14, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 12, missing),
                new Object[] { null, "craftingToolScrewdriver", null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 15, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 13, missing),
                new Object[] { null, null, null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 11, missing), null, null,
                        "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 13, missing),
                new Object[] { null, null, null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 12, missing), null, null,
                        "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 13, missing),
                new Object[] { null, null, null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 10, missing), null, null,
                        "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 13, missing),
                new Object[] { null, null, null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 14, missing), null, null,
                        "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 13, missing),
                new Object[] { null, null, null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 15, missing), null, null,
                        "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 14, missing),
                new Object[] { null, null, null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 11, missing), "craftingToolScrewdriver",
                        null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 14, missing),
                new Object[] { null, null, null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 12, missing), "craftingToolScrewdriver",
                        null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 14, missing),
                new Object[] { null, null, null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 13, missing), "craftingToolScrewdriver",
                        null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 14, missing),
                new Object[] { null, null, null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 10, missing), "craftingToolScrewdriver",
                        null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 14, missing),
                new Object[] { null, null, null, null,
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 15, missing), "craftingToolScrewdriver",
                        null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 15, missing),
                new Object[] { null, null, null, "craftingToolScrewdriver",
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 11, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 15, missing),
                new Object[] { null, null, null, "craftingToolScrewdriver",
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 12, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 15, missing),
                new Object[] { null, null, null, "craftingToolScrewdriver",
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 13, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 15, missing),
                new Object[] { null, null, null, "craftingToolScrewdriver",
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 14, missing), null, null, null, null });
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 15, missing),
                new Object[] { null, null, null, "craftingToolScrewdriver",
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 10, missing), null, null, null, null });

        recipes1();
        recipes2();
        recipes3();

    }

    private void recipes1() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32701, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32078, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32701, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32078, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32701, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32078, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32701, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32078, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32701, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32078, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32701, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32078, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 22305, missing),
                        getModItem(BartWorks.ID, "BWPumpParts", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 19086, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 8, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 22305, missing),
                        getModItem(Railcraft.ID, "glass", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 8, 19086, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 32, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 22305, missing),
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 4, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 8, 19086, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 32, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 22019, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17602, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19086, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 64, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 22019, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.ReinforcedGlassPlate", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19086, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 64, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22306, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17611, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19086, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 64, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 8, 28500, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 8, 28500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32701, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 8, 28500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32078, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 8, 28500, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32701, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32078, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 16, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32702, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 16, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32079, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 16, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32080, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 16, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 6, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 16, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 32, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 32, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 32, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32703, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 32, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 32, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32082, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 32, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 32, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 32, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 32767, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 31, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 31, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 131, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 12, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 12, missing),
                        getModItem(Minecraft.ID, "writable_book", 1, 32767, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 13, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "ItemShard", 4, 6, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 30, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 12, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 2, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 16, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(ExtraUtilities.ID, "trashcan", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 6, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 502, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 500, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 6, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 3, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 103, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 3, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 6, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 203, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 3, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 3, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 3, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 7, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 107, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 103, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 107, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 107, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 6, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 207, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 203, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 207, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 300, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "itemBatRE", 1, 32767, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 300, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
    }

    private void recipes2() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 30, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 17, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 30, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 17, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 30, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 17, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32702, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32079, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32080, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32702, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32079, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32080, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32702, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32079, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32080, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 2, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32703, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32082, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 7, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 2, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32703, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32082, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 7, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 2, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32703, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32082, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 7, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.GoldCoreChip", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32651, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 288)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.GoldCoreChip", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32651, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.GoldCoreChip", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32651, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 7, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.DiamondCoreChip", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 32, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 576)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 7, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.DiamondCoreChip", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 32, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 288)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 7, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.DiamondCoreChip", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 32, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 144)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 3, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeBlockRequestTable", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32702, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeBlockRequestTable", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32079, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeBlockRequestTable", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32080, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeBlockRequestTable", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 3, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 6, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeBlockRequestTable", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32703, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32082, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32703, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32082, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32703, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32082, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32703, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32082, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32703, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32082, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32703, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32082, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing),
                        getModItem(OpenComputers.ID, "item", 1, 70, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 14, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(OpenComputers.ID, "item", 1, 70, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 15, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 17019, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 17019, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32703, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 17019, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32082, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 17019, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 7, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(Forestry.ID, "factory2", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32651, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(Forestry.ID, "factory2", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32651, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32703, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(Forestry.ID, "factory2", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32651, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32082, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(Forestry.ID, "factory2", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32651, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 7, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 10, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32651, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 10, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32651, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32703, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 10, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32651, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32082, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 10, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32651, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 7, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(900).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 3, missing),
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 25, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 17019, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1367, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 17019, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32703, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1367, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 17019, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32082, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1367, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 17019, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 7, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1367, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32702, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32079, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32080, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32702, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32079, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32080, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32702, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32079, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32080, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 600, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 7, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 601, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(1920).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 601, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 8, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 602, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(7680).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17019, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1360, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 27500, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17019, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32703, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1360, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 27500, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17019, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32082, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1360, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 27500, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17019, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1360, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 27500, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 32767, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("chlorine", 1000)).noFluidOutputs()
                .duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 1, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyeblack", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 2, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyered", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 3, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyegreen", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 4, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyebrown", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 5, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyeblue", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 6, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyepurple", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 7, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyecyan", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 8, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyelightgray", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 9, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyegray", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 10, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyepink", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 11, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyelime", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 12, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyeyellow", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 13, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyelightblue", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 14, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyemagenta", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 15, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyeorange", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 16, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyewhite", 288))
                .noFluidOutputs().duration(1600).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.pipeController", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        getModItem(Minecraft.ID, "sign", 16, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.ItemPipeSignCreator", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26348, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22500, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 3, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28019, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28019, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32702, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28019, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32079, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28019, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32080, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28019, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(Forestry.ID, "apicultureChest", 1, 0, missing),
                        getModItem(Forestry.ID, "propolis", 4, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 1000)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(Forestry.ID, "apicultureChest", 1, 0, missing),
                        getModItem(Forestry.ID, "propolis", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32702, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 1000)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(Forestry.ID, "apicultureChest", 1, 0, missing),
                        getModItem(Forestry.ID, "propolis", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32079, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 1000)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(Forestry.ID, "apicultureChest", 1, 0, missing),
                        getModItem(Forestry.ID, "propolis", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32080, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 1000)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(Forestry.ID, "apicultureChest", 1, 0, missing),
                        getModItem(Forestry.ID, "propolis", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 1000)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsApiaristSink", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(ExtraUtilities.ID, "trashcan", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(120).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32682, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32682, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32702, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32682, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32079, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32682, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32080, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32682, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32682, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32682, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32702, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32682, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32079, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32682, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32080, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32682, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32682, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32682, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32702, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32682, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32079, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32682, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32080, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32682, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32702, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32079, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32080, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32702, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32079, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32080, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(1600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32702, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32079, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
    }

    private void recipes3() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32080, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(1600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsApiaristAnalyser", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(1600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsCraftingLogistics", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsCraftingLogistics", 2, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsCraftingLogisticsMk2", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 601, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsCraftingLogisticsMk2", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsCraftingLogisticsMk2", 2, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsCraftingLogisticsMk3", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 602, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsCraftingLogisticsMk3", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32631, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 4, 1, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogisticsMk2", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 500, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsProviderLogistics", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsProviderLogistics", 2, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsProviderLogisticsMk2", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsProviderLogisticsMk2", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 502, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsSupplierLogistics", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17532, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsSatelliteLogistics", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 0, 32767, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsRemoteOrdererLogistics", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(Minecraft.ID, "web", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsFirewall", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(
                getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                getModItem(GregTech.ID, "gt.metaitem.01", 2, 17381, missing),
                createItemStack(Minecraft.ID, "chest", 1, 0, "{display:{Name:\"Invalid OreDictionary Tag\"}}", missing),
                getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk1", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(
                getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                getModItem(GTPlusPlus.ID, "itemPlateRedstoneAlloy", 2, 0, missing),
                createItemStack(Minecraft.ID, "chest", 1, 0, "{display:{Name:\"Invalid OreDictionary Tag\"}}", missing),
                getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk1", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17381, missing),
                        createItemStack(
                                Minecraft.ID,
                                "trapped_chest",
                                1,
                                0,
                                "{display:{Name:\"Invalid OreDictionary Tag\"}}",
                                missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk1", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem(GTPlusPlus.ID, "itemPlateRedstoneAlloy", 2, 0, missing),
                        createItemStack(
                                Minecraft.ID,
                                "trapped_chest",
                                1,
                                0,
                                "{display:{Name:\"Invalid OreDictionary Tag\"}}",
                                missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk1", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk1", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17364, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk2", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk2", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17351, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk3", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk3", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17348, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk4", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk4", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17028, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk5", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17364, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 3, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk2", 4, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17364, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk2", 4, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17364, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk2", 4, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17364, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 3, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk2", 4, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 6, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17351, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk3", 6, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 6, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17351, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32702, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk3", 6, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 6, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17351, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32079, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk3", 6, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 6, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17351, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32080, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk3", 6, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 6, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17351, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk3", 6, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17348, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 4, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk4", 8, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17348, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32703, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk4", 8, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17348, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32082, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk4", 8, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17348, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 4, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk4", 8, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17028, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 1, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitEV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk5", 12, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17028, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32704, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk5", 12, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17028, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32083, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk5", 12, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17028, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32085, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk5", 12, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17028, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 1, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk5", 12, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitULV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32700, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32075, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitULV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32700, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32075, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitULV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32700, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32075, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitULV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32700, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32075, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitULV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32700, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32075, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitULV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32700, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32075, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(
                getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                getModItem(NewHorizonsCoreMod.ID, "item.CircuitULV", 1, 0, missing),
                createItemStack(Minecraft.ID, "chest", 1, 0, "{display:{Name:\"Invalid OreDictionary Tag\"}}", missing),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 34, missing),
                getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(
                getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32700, missing),
                createItemStack(Minecraft.ID, "chest", 1, 0, "{display:{Name:\"Invalid OreDictionary Tag\"}}", missing),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 34, missing),
                getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(
                getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32075, missing),
                createItemStack(Minecraft.ID, "chest", 1, 0, "{display:{Name:\"Invalid OreDictionary Tag\"}}", missing),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 34, missing),
                getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(
                getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 4, missing),
                createItemStack(Minecraft.ID, "chest", 1, 0, "{display:{Name:\"Invalid OreDictionary Tag\"}}", missing),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 34, missing),
                getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitULV", 1, 0, missing),
                        createItemStack(
                                Minecraft.ID,
                                "trapped_chest",
                                1,
                                0,
                                "{display:{Name:\"Invalid OreDictionary Tag\"}}",
                                missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 34, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32700, missing),
                        createItemStack(
                                Minecraft.ID,
                                "trapped_chest",
                                1,
                                0,
                                "{display:{Name:\"Invalid OreDictionary Tag\"}}",
                                missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 34, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32075, missing),
                        createItemStack(
                                Minecraft.ID,
                                "trapped_chest",
                                1,
                                0,
                                "{display:{Name:\"Invalid OreDictionary Tag\"}}",
                                missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 34, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        createItemStack(
                                Minecraft.ID,
                                "trapped_chest",
                                1,
                                0,
                                "{display:{Name:\"Invalid OreDictionary Tag\"}}",
                                missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 34, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                        getModItem(Minecraft.ID, "wool", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 29305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 26, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 25, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 20, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1000)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 29308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 24, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 29308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 33, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 23, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 1, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 42, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17057, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 42, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 23, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 21, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 207, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 33, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 26, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 41, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32682, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 33, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 21, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing),
                        getModItem(GTPlusPlus.ID, "MU-metaitem.01", 1, 32036, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 29300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing),
                        getModItem(GTPlusPlus.ID, "MU-metaitem.01", 1, 32036, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 29300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 6, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing),
                        getModItem(GTPlusPlus.ID, "MU-metaitem.01", 1, 32036, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 29300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing),
                        getModItem(GTPlusPlus.ID, "MU-metaitem.01", 1, 32036, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 29300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing),
                        getModItem(GTPlusPlus.ID, "MU-metaitem.01", 1, 32036, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 29300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing),
                        getModItem(GTPlusPlus.ID, "MU-metaitem.01", 1, 32036, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 29300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 10, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(Railcraft.ID, "part.plate", 1, 1, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 10, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 6, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(Railcraft.ID, "part.plate", 1, 1, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 6, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 12, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(Railcraft.ID, "part.plate", 1, 1, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 12, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 13, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(Railcraft.ID, "part.plate", 1, 1, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 13, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 14, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(Railcraft.ID, "part.plate", 1, 1, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 14, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 15, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(Railcraft.ID, "part.plate", 1, 1, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 15, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 6, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32405, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 6, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32405, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 6, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32405, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(800)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 3, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 502, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32405, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidSupplierMk2", 3, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing),
                        getModItem(Minecraft.ID, "bucket", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32405, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsFluidSupplier", 3, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 3, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32405, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidProvider", 3, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32611, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32405, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidInsertion", 3, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32405, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidRequestLogistics", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17532, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidSatellite", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 4, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32405, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidExtractor", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32405, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 18, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 22, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
    }
}
