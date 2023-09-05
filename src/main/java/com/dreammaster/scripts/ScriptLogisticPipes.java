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
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sPressRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

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
        addShapelessRecipe(
                getModItem(LogisticsPipes.ID, "item.itemModule", 1, 0, missing),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 44, missing));
        addShapelessRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 44, missing),
                getModItem(LogisticsPipes.ID, "item.itemModule", 1, 0, missing));
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 2, missing),
                "boltRedSteel",
                "stickDiamond",
                "boltRedSteel",
                "craftingToolFile",
                "screwTitanium",
                "craftingToolSoftHammer",
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.logisticsHUDGlasses", 1, 0, missing),
                getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 1, missing),
                getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 2, missing),
                getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 1, missing),
                "screwTitanium",
                "circuitAdvanced",
                "screwTitanium",
                getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 0, missing));
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemDisk", 1, 0, missing),
                "plateCarbon",
                "plateCarbon",
                "plateCarbon",
                "plateCarbon",
                getModItem(OpenComputers.ID, "item", 1, 19, missing),
                "plateCarbon",
                "plateCarbon",
                "circuitPrimitive",
                "plateCarbon");
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing),
                null,
                null,
                null,
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing),
                null,
                null,
                null,
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing),
                null,
                null,
                null,
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing),
                null,
                null,
                null,
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing),
                null,
                null,
                null,
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing),
                null,
                "craftingToolScrewdriver",
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing),
                null,
                "craftingToolScrewdriver",
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing),
                null,
                "craftingToolScrewdriver",
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing),
                null,
                "craftingToolScrewdriver",
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing),
                null,
                "craftingToolScrewdriver",
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing),
                "craftingToolScrewdriver",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing),
                "craftingToolScrewdriver",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing),
                "craftingToolScrewdriver",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing),
                "craftingToolScrewdriver",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing),
                "craftingToolScrewdriver",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing),
                null,
                null,
                null,
                "craftingToolScrewdriver",
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing),
                null,
                null,
                null,
                "craftingToolScrewdriver",
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing),
                null,
                null,
                null,
                "craftingToolScrewdriver",
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing),
                null,
                null,
                null,
                "craftingToolScrewdriver",
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing),
                null,
                null,
                null,
                "craftingToolScrewdriver",
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 10, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 11, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 10, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 12, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 10, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 13, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 10, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 14, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 10, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 15, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 11, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 10, missing),
                null,
                null,
                null,
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 11, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 12, missing),
                null,
                null,
                null,
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 11, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 13, missing),
                null,
                null,
                null,
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 11, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 14, missing),
                null,
                null,
                null,
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 11, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 15, missing),
                null,
                null,
                null,
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 12, missing),
                null,
                "craftingToolScrewdriver",
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 11, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 12, missing),
                null,
                "craftingToolScrewdriver",
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 10, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 12, missing),
                null,
                "craftingToolScrewdriver",
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 13, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 12, missing),
                null,
                "craftingToolScrewdriver",
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 14, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 12, missing),
                null,
                "craftingToolScrewdriver",
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 15, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 13, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 11, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 13, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 12, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 13, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 10, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 13, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 14, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 13, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 15, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 14, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 11, missing),
                "craftingToolScrewdriver",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 14, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 12, missing),
                "craftingToolScrewdriver",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 14, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 13, missing),
                "craftingToolScrewdriver",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 14, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 10, missing),
                "craftingToolScrewdriver",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 14, missing),
                null,
                null,
                null,
                null,
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 15, missing),
                "craftingToolScrewdriver",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 15, missing),
                null,
                null,
                null,
                "craftingToolScrewdriver",
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 11, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 15, missing),
                null,
                null,
                null,
                "craftingToolScrewdriver",
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 12, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 15, missing),
                null,
                null,
                null,
                "craftingToolScrewdriver",
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 13, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 15, missing),
                null,
                null,
                null,
                "craftingToolScrewdriver",
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 14, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 15, missing),
                null,
                null,
                null,
                "craftingToolScrewdriver",
                getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 10, missing),
                null,
                null,
                null,
                null);

        recipes1();
        recipes2();
        recipes3();

    }

    private void recipes1() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        ItemList.Circuit_Basic.get(2L),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        ItemList.Circuit_Microprocessor.get(2L),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        ItemList.Circuit_Basic.get(2L),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        ItemList.Circuit_Microprocessor.get(2L),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 1152)).noFluidOutputs().duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        ItemList.Circuit_Basic.get(2L),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        ItemList.Circuit_Microprocessor.get(2L),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        ItemList.Circuit_Basic.get(2L),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        ItemList.Circuit_Microprocessor.get(2L),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 576)).noFluidOutputs().duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        ItemList.Circuit_Basic.get(2L),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        ItemList.Circuit_Microprocessor.get(2L),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1368, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        ItemList.Circuit_Basic.get(2L),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        ItemList.Circuit_Microprocessor.get(2L),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1388, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 27305, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 22305, missing),
                        getModItem(BartWorks.ID, "BWPumpParts", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 19086, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 8, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 22305, missing),
                        getModItem(Railcraft.ID, "glass", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 8, 19086, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 32, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 22305, missing),
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 4, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 8, 19086, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 32, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 22019, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.ReinforceGlass, 4),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19086, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 64, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22306, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17611, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19086, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 64, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 8, 28500, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 8, 28500, missing),
                        ItemList.Circuit_Basic.get(2L),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 8, 28500, missing),
                        ItemList.Circuit_Microprocessor.get(2L),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 8, 28500, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        ItemList.Circuit_Basic.get(2L),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        ItemList.Circuit_Microprocessor.get(2L),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 16, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        ItemList.Circuit_Good.get(2L),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 16, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        ItemList.Circuit_Integrated_Good.get(2L),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 16, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        ItemList.Circuit_Processor.get(2L),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 16, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 6, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 16, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 32, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 32, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 32, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        ItemList.Circuit_Computer.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 32, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 32, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        ItemList.Circuit_Nanoprocessor.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 32, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 32, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 20086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23500, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 16, 19054, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 32, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, wildcard, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 31, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 31, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 131, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 12, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 12, missing),
                        getModItem(Minecraft.ID, "writable_book", 1, wildcard, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 13, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "ItemShard", 4, 6, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 30, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 12, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 2, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 16, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(ExtraUtilities.ID, "trashcan", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 6, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 0, missing),
                        ItemList.Component_Filter.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 3, 2, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 3, 502, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26086, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 500, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 6, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 3, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 103, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 3, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 6, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 203, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 3, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 3, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 3, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 7, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 107, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 103, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 107, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 107, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 6, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 207, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 203, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 207, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 300, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "itemBatRE", 1, wildcard, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 300, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sPressRecipes);
    }

    private void recipes2() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 1, missing),
                        ItemList.Conveyor_Module_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 30, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 17, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 1, missing),
                        ItemList.Conveyor_Module_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 30, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 17, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 1, missing),
                        ItemList.Conveyor_Module_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 30, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 17, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        ItemList.Circuit_Good.get(1L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        ItemList.Circuit_Integrated_Good.get(1L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        ItemList.Circuit_Processor.get(1L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        ItemList.Circuit_Good.get(1L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        ItemList.Circuit_Integrated_Good.get(1L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        ItemList.Circuit_Processor.get(1L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        ItemList.Circuit_Good.get(1L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        ItemList.Circuit_Integrated_Good.get(1L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        ItemList.Circuit_Processor.get(1L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26334, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 2, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        ItemList.Circuit_Computer.get(2L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        ItemList.Circuit_Nanoprocessor.get(2L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 7, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 2, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        ItemList.Circuit_Computer.get(2L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        ItemList.Circuit_Nanoprocessor.get(2L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 7, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 2, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        ItemList.Circuit_Computer.get(2L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        ItemList.Circuit_Nanoprocessor.get(2L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 7, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.GoldCoreChip", 1, 0, missing),
                        ItemList.Robot_Arm_MV.get(2L),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 288)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.GoldCoreChip", 1, 0, missing),
                        ItemList.Robot_Arm_MV.get(2L),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.GoldCoreChip", 1, 0, missing),
                        ItemList.Robot_Arm_MV.get(2L),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 7, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.DiamondCoreChip", 1, 0, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 32, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 576)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 7, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.DiamondCoreChip", 1, 0, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 32, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 288)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 7, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.DiamondCoreChip", 1, 0, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 32, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 144)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 3, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 2, 0, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeBlockRequestTable", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 3, missing),
                        ItemList.Circuit_Good.get(2L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeBlockRequestTable", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 3, missing),
                        ItemList.Circuit_Integrated_Good.get(2L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeBlockRequestTable", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 3, missing),
                        ItemList.Circuit_Processor.get(2L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeBlockRequestTable", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 3, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 6, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeBlockRequestTable", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Circuit_Computer.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Circuit_Nanoprocessor.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Circuit_Computer.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Circuit_Nanoprocessor.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Circuit_Computer.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Circuit_Nanoprocessor.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Circuit_Computer.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Circuit_Nanoprocessor.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Circuit_Computer.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Circuit_Nanoprocessor.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Circuit_Computer.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Circuit_Nanoprocessor.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17526, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5, missing),
                        getModItem(OpenComputers.ID, "item", 1, 70, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 14, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(OpenComputers.ID, "item", 1, 70, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 15, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 17019, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 17019, missing),
                        ItemList.Circuit_Computer.get(2L),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 17019, missing),
                        ItemList.Circuit_Nanoprocessor.get(2L),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 17019, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 7, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(Forestry.ID, "factory2", 1, 2, missing),
                        ItemList.Robot_Arm_MV.get(2L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(Forestry.ID, "factory2", 1, 2, missing),
                        ItemList.Robot_Arm_MV.get(2L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600, missing),
                        ItemList.Circuit_Computer.get(2L),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(Forestry.ID, "factory2", 1, 2, missing),
                        ItemList.Robot_Arm_MV.get(2L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600, missing),
                        ItemList.Circuit_Nanoprocessor.get(2L),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(Forestry.ID, "factory2", 1, 2, missing),
                        ItemList.Robot_Arm_MV.get(2L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 7, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 10, missing),
                        ItemList.Robot_Arm_MV.get(2L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 10, missing),
                        ItemList.Robot_Arm_MV.get(2L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600, missing),
                        ItemList.Circuit_Computer.get(2L),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 10, missing),
                        ItemList.Robot_Arm_MV.get(2L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600, missing),
                        ItemList.Circuit_Nanoprocessor.get(2L),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 10, missing),
                        ItemList.Robot_Arm_MV.get(2L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 7, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1369, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 26348, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 3, missing),
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 25, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        ItemList.Sensor_HV.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 17019, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1367, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        ItemList.Sensor_HV.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 17019, missing),
                        ItemList.Circuit_Computer.get(2L),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1367, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        ItemList.Sensor_HV.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 17019, missing),
                        ItemList.Circuit_Nanoprocessor.get(2L),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1367, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        ItemList.Sensor_HV.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 17019, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 2, 7, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1367, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 576)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        ItemList.Circuit_Good.get(1L),
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        ItemList.Circuit_Integrated_Good.get(1L),
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        ItemList.Circuit_Processor.get(1L),
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        ItemList.Circuit_Good.get(1L),
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        ItemList.Circuit_Integrated_Good.get(1L),
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        ItemList.Circuit_Processor.get(1L),
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        ItemList.Circuit_Good.get(1L),
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        ItemList.Circuit_Integrated_Good.get(1L),
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        ItemList.Circuit_Processor.get(1L),
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0, missing),
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 600, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 7, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 601, missing)).noFluidInputs()
                .noFluidOutputs().duration(80 * SECONDS).eut(TierEU.RECIPE_EV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 2, 601, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 8, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 602, missing)).noFluidInputs()
                .noFluidOutputs().duration(80 * SECONDS).eut(TierEU.RECIPE_IV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17019, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1360, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 27500, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17019, missing),
                        ItemList.Circuit_Computer.get(1L),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1360, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 27500, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17019, missing),
                        ItemList.Circuit_Nanoprocessor.get(1L),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1360, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 27500, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17019, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 1360, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 27500, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.pipeController", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        getModItem(Minecraft.ID, "sign", 16, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.ItemPipeSignCreator", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26348, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22500, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 3, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).noFluidOutputs()
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28019, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).noFluidOutputs()
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28019, missing),
                        ItemList.Circuit_Good.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).noFluidOutputs()
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28019, missing),
                        ItemList.Circuit_Integrated_Good.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).noFluidOutputs()
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28019, missing),
                        ItemList.Circuit_Processor.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).noFluidOutputs()
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28019, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).noFluidOutputs()
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(Forestry.ID, "apicultureChest", 1, 0, missing),
                        getModItem(Forestry.ID, "propolis", 4, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 1000)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(Forestry.ID, "apicultureChest", 1, 0, missing),
                        getModItem(Forestry.ID, "propolis", 4, 0, missing),
                        ItemList.Circuit_Good.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 1000)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(Forestry.ID, "apicultureChest", 1, 0, missing),
                        getModItem(Forestry.ID, "propolis", 4, 0, missing),
                        ItemList.Circuit_Integrated_Good.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 1000)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(Forestry.ID, "apicultureChest", 1, 0, missing),
                        getModItem(Forestry.ID, "propolis", 4, 0, missing),
                        ItemList.Circuit_Processor.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 1000)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1, missing),
                        getModItem(Forestry.ID, "apicultureChest", 1, 0, missing),
                        getModItem(Forestry.ID, "propolis", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 1000)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsApiaristSink", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(ExtraUtilities.ID, "trashcan", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Emitter_HV.get(1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Emitter_HV.get(1L),
                        ItemList.Circuit_Good.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Emitter_HV.get(1L),
                        ItemList.Circuit_Integrated_Good.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Emitter_HV.get(1L),
                        ItemList.Circuit_Processor.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Emitter_HV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Emitter_HV.get(1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Emitter_HV.get(1L),
                        ItemList.Circuit_Good.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Emitter_HV.get(1L),
                        ItemList.Circuit_Integrated_Good.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Emitter_HV.get(1L),
                        ItemList.Circuit_Processor.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Emitter_HV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Emitter_HV.get(1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Emitter_HV.get(1L),
                        ItemList.Circuit_Good.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Emitter_HV.get(1L),
                        ItemList.Circuit_Integrated_Good.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Emitter_HV.get(1L),
                        ItemList.Circuit_Processor.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Emitter_HV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Circuit_Good.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Circuit_Integrated_Good.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Circuit_Processor.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Circuit_Good.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Circuit_Integrated_Good.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Circuit_Processor.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Circuit_Good.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Circuit_Integrated_Good.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
    }

    private void recipes3() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Circuit_Processor.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                        ItemList.Conveyor_Module_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsApiaristAnalyser", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsCraftingLogistics", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsCraftingLogistics", 2, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 7, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsCraftingLogisticsMk2", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 601, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsCraftingLogisticsMk2", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsCraftingLogisticsMk2", 2, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 8, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsCraftingLogisticsMk3", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 602, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsCraftingLogisticsMk3", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Conveyor_Module_MV.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 4, 1, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 6, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogisticsMk2", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 500, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsProviderLogistics", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsProviderLogistics", 2, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 6, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsProviderLogisticsMk2", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsProviderLogisticsMk2", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 502, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsSupplierLogistics", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17532, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsSatelliteLogistics", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 0, wildcard, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsRemoteOrdererLogistics", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0, missing),
                        getModItem(Minecraft.ID, "web", 1, 0, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsFirewall", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17381, missing),
                        getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk1", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem(GTPlusPlus.ID, "itemPlateRedstoneAlloy", 2, 0, missing),
                        getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk1", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17381, missing),
                        getModItem(Minecraft.ID, "trapped_chest", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk1", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0, missing),
                        getModItem(GTPlusPlus.ID, "itemPlateRedstoneAlloy", 2, 0, missing),
                        getModItem(Minecraft.ID, "trapped_chest", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk1", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk1", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17364, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 3, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk2", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk2", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17351, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk3", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk3", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17348, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 4, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk4", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk4", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17028, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 1, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk5", 2, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17364, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 3, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk2", 4, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17364, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 3, missing),
                        ItemList.Circuit_Basic.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk2", 4, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17364, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 3, missing),
                        ItemList.Circuit_Microprocessor.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk2", 4, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17364, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 3, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk2", 4, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 6, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17351, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk3", 6, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 6, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17351, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 0, missing),
                        ItemList.Circuit_Good.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk3", 6, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 6, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17351, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 0, missing),
                        ItemList.Circuit_Integrated_Good.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk3", 6, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 6, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17351, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 0, missing),
                        ItemList.Circuit_Processor.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk3", 6, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 6, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17351, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk3", 6, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17348, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 4, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk4", 8, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17348, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 4, missing),
                        ItemList.Circuit_Computer.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk4", 8, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17348, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 4, missing),
                        ItemList.Circuit_Nanoprocessor.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk4", 8, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17348, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 4, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 7, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk4", 8, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17028, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 1, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitEV", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk5", 12, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17028, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 1, missing),
                        ItemList.Circuit_Data.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk5", 12, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17028, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 1, missing),
                        ItemList.Circuit_Nanocomputer.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk5", 12, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17028, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 1, missing),
                        ItemList.Circuit_Quantumprocessor.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk5", 12, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17028, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 1, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 8, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk5", 12, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitULV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        ItemList.Circuit_Parts_Vacuum_Tube.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        ItemList.NandChip.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitULV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        ItemList.Circuit_Parts_Vacuum_Tube.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        ItemList.NandChip.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitULV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        ItemList.Circuit_Parts_Vacuum_Tube.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        ItemList.NandChip.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitULV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        ItemList.Circuit_Parts_Vacuum_Tube.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        ItemList.NandChip.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitULV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        ItemList.Circuit_Parts_Vacuum_Tube.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        ItemList.NandChip.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19035, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitULV", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        ItemList.Circuit_Parts_Vacuum_Tube.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        ItemList.NandChip.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 19345, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitULV", 1, 0, missing),
                        getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 34, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                        ItemList.Circuit_Parts_Vacuum_Tube.get(1L),
                        getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 34, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                        ItemList.NandChip.get(1L),
                        getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 34, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 34, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CircuitULV", 1, 0, missing),
                        getModItem(Minecraft.ID, "trapped_chest", 1, 0, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 34, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                        ItemList.Circuit_Parts_Vacuum_Tube.get(1L),
                        getModItem(Minecraft.ID, "trapped_chest", 1, 0, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 34, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                        ItemList.NandChip.get(1L),
                        getModItem(Minecraft.ID, "trapped_chest", 1, 0, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 34, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 4, missing),
                        getModItem(Minecraft.ID, "trapped_chest", 1, 0, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 34, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                        getModItem(Minecraft.ID, "wool", 1, wildcard, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 29305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 26, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 25, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                        ItemList.Electric_Piston_LV.get(1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 20, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1000)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                        ItemList.Robot_Arm_LV.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 29308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 24, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4, missing),
                        ItemList.Conveyor_Module_LV.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 29308, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 33, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 23, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 1, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 42, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17057, missing))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 42, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        ItemList.Sensor_HV.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 23, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 21, missing)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 207, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 2, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 33, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 26, missing)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 24, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 41, missing)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        ItemList.Sensor_HV.get(1L),
                        ItemList.Emitter_HV.get(1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 33, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 21, missing)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing),
                        getModItem(GTPlusPlus.ID, "MU-metaitem.01", 1, 32036, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 29300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33, missing),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing),
                        getModItem(GTPlusPlus.ID, "MU-metaitem.01", 1, 32036, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 29300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33, missing),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing),
                        getModItem(GTPlusPlus.ID, "MU-metaitem.01", 1, 32036, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 29300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing),
                        getModItem(GTPlusPlus.ID, "MU-metaitem.01", 1, 32036, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 29300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33, missing),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing),
                        getModItem(GTPlusPlus.ID, "MU-metaitem.01", 1, 32036, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 29300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33, missing),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4, missing),
                        getModItem(GTPlusPlus.ID, "MU-metaitem.01", 1, 32036, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 29300, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33, missing),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 10, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(Railcraft.ID, "part.plate", 1, 1, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 10, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(Railcraft.ID, "part.plate", 1, 1, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 12, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(Railcraft.ID, "part.plate", 1, 1, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 12, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 13, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(Railcraft.ID, "part.plate", 1, 1, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 13, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 14, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(Railcraft.ID, "part.plate", 1, 1, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 14, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17305, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 15, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(Railcraft.ID, "part.plate", 1, 1, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 15, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 6, 0, missing),
                        ItemList.Large_Fluid_Cell_Steel.get(1L),
                        ItemList.Electric_Pump_LV.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 6, 0, missing),
                        ItemList.Large_Fluid_Cell_Steel.get(1L),
                        ItemList.Electric_Pump_LV.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 6, 0, missing),
                        ItemList.Large_Fluid_Cell_Steel.get(1L),
                        ItemList.Electric_Pump_LV.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs()
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 3, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 502, missing),
                        ItemList.Large_Fluid_Cell_Steel.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidSupplierMk2", 3, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 3, 0, missing),
                        ItemList.Robot_Arm_MV.get(1L),
                        getModItem(Minecraft.ID, "bucket", 1, 0, missing),
                        ItemList.Large_Fluid_Cell_Steel.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsFluidSupplier", 3, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 3, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 500, missing),
                        ItemList.Large_Fluid_Cell_Steel.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidProvider", 3, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 3, 0, missing),
                        ItemList.Electric_Pump_MV.get(1L),
                        ItemList.Large_Fluid_Cell_Steel.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidInsertion", 3, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0, missing),
                        ItemList.Large_Fluid_Cell_Steel.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidRequestLogistics", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 1, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 0, missing),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Sensor_HV.get(1L),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17532, missing),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidSatellite", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 4, 0, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 3, missing),
                        ItemList.Large_Fluid_Cell_Steel.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidExtractor", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4, missing),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600, missing),
                        ItemList.Large_Fluid_Cell_Steel.get(1L),
                        GT_Utility.getIntegratedCircuit(18))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 22, missing)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
    }
}
