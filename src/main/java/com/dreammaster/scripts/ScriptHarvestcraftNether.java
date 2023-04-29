package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCutterRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptHarvestcraftNether implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Harvestcraft Nether";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.PamsHarvestCraft.ID, Mods.PamsHarvestTheNether.ID);
    }

    @Override
    public void loadRecipes() {
        addShapelessCraftingRecipe(
                getModItem("harvestthenether", "netherPlanks", 2, 0, missing),
                new Object[] { getModItem("harvestthenether", "netherLog", 1, 0, missing) });
        addShapedRecipe(
                getModItem("harvestthenether", "netherPlanks", 4, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("harvestthenether", "netherLog", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("harvestthenether", "netherbedItem", 1, 0, missing),
                new Object[] { getModItem("harvestthenether", "bloodleafItem", 1, 0, missing),
                        getModItem("harvestthenether", "bloodleafItem", 1, 0, missing),
                        getModItem("harvestthenether", "bloodleafItem", 1, 0, missing),
                        getModItem("harvestthenether", "netherPlanks", 1, 0, missing),
                        getModItem("harvestthenether", "netherPlanks", 1, 0, missing),
                        getModItem("harvestthenether", "netherPlanks", 1, 0, missing),
                        getModItem("harvestthenether", "quartzingotItem", 1, 0, missing), "craftingToolHardHammer",
                        getModItem("harvestthenether", "quartzingotItem", 1, 0, missing) });
        addShapedRecipe(
                getModItem("harvestthenether", "Quartz Sword", 1, 0, missing),
                new Object[] { null, getModItem("harvestthenether", "quartzingotItem", 1, 0, missing), null,
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("harvestthenether", "quartzingotItem", 64, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing), "craftingToolFile",
                        getModItem("minecraft", "stick", 1, 0, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("harvestthenether", "Quartz Shovel", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("harvestthenether", "quartzingotItem", 64, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing), "craftingToolFile",
                        getModItem("minecraft", "stick", 1, 0, missing), "craftingToolHardHammer", null,
                        getModItem("minecraft", "stick", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("harvestthenether", "Quartz Pickaxe", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("harvestthenether", "quartzingotItem", 1, 0, missing),
                        getModItem("harvestthenether", "quartzingotItem", 1, 0, missing), "craftingToolFile",
                        getModItem("minecraft", "stick", 1, 0, missing), "craftingToolHardHammer", null,
                        getModItem("minecraft", "stick", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("harvestthenether", "Quartz Axe", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("harvestthenether", "quartzingotItem", 1, 0, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("minecraft", "stick", 1, 0, missing), null, "craftingToolFile",
                        getModItem("minecraft", "stick", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("harvestthenether", "Quartz Hoe", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("harvestthenether", "quartzingotItem", 1, 0, missing), "craftingToolHardHammer",
                        "craftingToolFile", getModItem("minecraft", "stick", 1, 0, missing), null, null,
                        getModItem("minecraft", "stick", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("harvestthenether", "quartzhelmItem", 1, 0, missing),
                new Object[] { getModItem("harvestthenether", "quartzingotItem", 1, 0, missing),
                        getModItem("harvestthenether", "quartzingotItem", 1, 0, missing),
                        getModItem("harvestthenether", "quartzingotItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing), null, null, null });
        addShapedRecipe(
                getModItem("harvestthenether", "quartzchestItem", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("harvestthenether", "quartzingotItem", 1, 0, missing),
                        getModItem("harvestthenether", "quartzingotItem", 1, 0, missing),
                        getModItem("harvestthenether", "quartzingotItem", 1, 0, missing) });
        addShapedRecipe(
                getModItem("harvestthenether", "quartzleggingsItem", 1, 0, missing),
                new Object[] { getModItem("harvestthenether", "quartzingotItem", 1, 0, missing),
                        getModItem("harvestthenether", "quartzingotItem", 1, 0, missing),
                        getModItem("harvestthenether", "quartzingotItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing), null,
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing) });
        addShapedRecipe(
                getModItem("harvestthenether", "quartzbootsItem", 1, 0, missing),
                new Object[] { getModItem("harvestthenether", "quartzingotItem", 1, 0, missing), null,
                        getModItem("harvestthenether", "quartzingotItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing), null, null, null });
        addShapelessCraftingRecipe(
                getModItem("harvestthenether", "glowflowerseedItem", 1, 0, missing),
                new Object[] { getModItem("harvestthenether", "glowFlower", 1, 0, missing) });

        GT_Values.RA.stdBuilder().itemInputs(getModItem("harvestthenether", "netherLog", 1, 0, missing))
                .itemOutputs(
                        getModItem("harvestthenether", "netherPlanks", 6, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(200).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("harvestthenether", "netherLog", 1, 0, missing))
                .itemOutputs(
                        getModItem("harvestthenether", "netherPlanks", 6, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(200).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("harvestthenether", "netherLog", 1, 0, missing))
                .itemOutputs(
                        getModItem("harvestthenether", "netherPlanks", 6, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "stone_slab", 1, 7, missing))
                .itemOutputs(getModItem("harvestthenether", "quartzingotItem", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(100).eut(16)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "stone_slab", 1, 7, missing))
                .itemOutputs(getModItem("harvestthenether", "quartzingotItem", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(100).eut(16)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "stone_slab", 1, 7, missing))
                .itemOutputs(getModItem("harvestthenether", "quartzingotItem", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(100).eut(16)
                .addTo(sCutterRecipes);

    }
}
