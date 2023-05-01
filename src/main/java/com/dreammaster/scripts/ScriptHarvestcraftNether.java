package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.PamsHarvestTheNether;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCutterRecipes;

import java.util.Collections;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;

public class ScriptHarvestcraftNether implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Harvestcraft Nether";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.singletonList(PamsHarvestTheNether.ID);
    }

    @Override
    public void loadRecipes() {
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, 0, missing),
                new Object[] { getModItem(PamsHarvestTheNether.ID, "netherLog", 1, 0, missing) });
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "netherPlanks", 4, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(PamsHarvestTheNether.ID, "netherLog", 1, 0, missing),
                        null });
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "netherbedItem", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestTheNether.ID, "bloodleafItem", 1, 0, missing),
                        getModItem(PamsHarvestTheNether.ID, "bloodleafItem", 1, 0, missing),
                        getModItem(PamsHarvestTheNether.ID, "bloodleafItem", 1, 0, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 1, 0, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 1, 0, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 1, 0, missing),
                        getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing), "craftingToolHardHammer",
                        getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing) });
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "Quartz Sword", 1, 0, missing),
                new Object[] { null, getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing), null,
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing),
                        getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 64, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing), "craftingToolFile",
                        getModItem(Minecraft.ID, "stick", 1, 0, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "Quartz Shovel", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing),
                        getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 64, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing), "craftingToolFile",
                        getModItem(Minecraft.ID, "stick", 1, 0, missing), "craftingToolHardHammer", null,
                        getModItem(Minecraft.ID, "stick", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "Quartz Pickaxe", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing),
                        getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                        getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing), "craftingToolFile",
                        getModItem(Minecraft.ID, "stick", 1, 0, missing), "craftingToolHardHammer", null,
                        getModItem(Minecraft.ID, "stick", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "Quartz Axe", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing),
                        getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing), "craftingToolHardHammer",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing),
                        getModItem(Minecraft.ID, "stick", 1, 0, missing), null, "craftingToolFile",
                        getModItem(Minecraft.ID, "stick", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "Quartz Hoe", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing),
                        getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing), "craftingToolHardHammer",
                        "craftingToolFile", getModItem(Minecraft.ID, "stick", 1, 0, missing), null, null,
                        getModItem(Minecraft.ID, "stick", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "quartzhelmItem", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                        getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                        getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing), "craftingToolHardHammer",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing), null, null, null });
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "quartzchestItem", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing), "craftingToolHardHammer",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing),
                        getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                        getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                        getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing) });
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "quartzleggingsItem", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                        getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                        getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing), "craftingToolHardHammer",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing), null,
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing) });
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "quartzbootsItem", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing), null,
                        getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing), "craftingToolHardHammer",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17522, missing), null, null, null });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestTheNether.ID, "glowflowerseedItem", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestTheNether.ID, "glowFlower", 1, 0, missing) });

        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestTheNether.ID, "netherLog", 1, 0, missing))
                .itemOutputs(
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 6, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(200).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestTheNether.ID, "netherLog", 1, 0, missing))
                .itemOutputs(
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 6, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(200).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestTheNether.ID, "netherLog", 1, 0, missing))
                .itemOutputs(
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 6, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "stone_slab", 1, 7, missing))
                .itemOutputs(getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(100).eut(16)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "stone_slab", 1, 7, missing))
                .itemOutputs(getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(100).eut(16)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "stone_slab", 1, 7, missing))
                .itemOutputs(getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(100).eut(16)
                .addTo(sCutterRecipes);

    }
}
