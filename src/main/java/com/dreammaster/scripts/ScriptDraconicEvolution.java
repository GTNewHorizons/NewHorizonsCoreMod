package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.*;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptDraconicEvolution implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Draconic Evolution";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.DraconicEvolution.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("DraconicEvolution", "magnet", 1, 0, missing),
                new Object[] { "blockSteelMagnetic", "ingotSteelMagnetic", "ingotSteelMagnetic", null, null,
                        getModItem("gregtech", "gt.metaitem.01", 1, 32518, missing), "blockSteelMagnetic",
                        "ingotSteelMagnetic", "ingotSteelMagnetic" });
        addShapedRecipe(
                getModItem("DraconicEvolution", "draconiumChest", 1, 0, missing),
                new Object[] { "plateObsidian", getModItem("EnderIO", "blockCapBank", 1, 1, missing), "plateObsidian",
                        getModItem("IC2", "blockMachine", 1, 1, missing),
                        getModItem("avaritiaddons", "CompressedChest", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing), "plateObsidian", "plateObsidian",
                        "plateObsidian" });
        addShapelessCraftingRecipe(
                getModItem("DraconicEvolution", "safetyMatch", 1, 1000, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32471, missing), "dustDraconium" });
        addShapedRecipe(
                getModItem("DraconicEvolution", "xRayBlock", 8, 0, missing),
                new Object[] { getModItem("minecraft", "glass_pane", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("minecraft", "glass_pane", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 29500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("minecraft", "glass_pane", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("minecraft", "glass_pane", 1, 0, missing) });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 17299, missing),
                        getModItem("DraconicEvolution", "draconiumDust", 1, 0, missing))
                .itemOutputs(getModItem("DraconicEvolution", "infoTablet", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("DraconicEvolution", "energyCrystal", 1, 0, missing),
                        getModItem("DraconicEvolution", "particleGenerator", 2, 0, missing))
                .itemOutputs(getModItem("DraconicEvolution", "energyCrystal", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.enderium", 864)).noFluidOutputs().duration(1200)
                .eut(1024).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("DraconicEvolution", "energyCrystal", 1, 1, missing),
                        getModItem("DraconicEvolution", "particleGenerator", 2, 0, missing))
                .itemOutputs(getModItem("DraconicEvolution", "energyCrystal", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.enderium", 864)).noFluidOutputs().duration(2400)
                .eut(4096).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "arrow", 1, 0, missing),
                        getModItem("minecraft", "ender_pearl", 1, 0, missing))
                .itemOutputs(getModItem("DraconicEvolution", "enderArrow", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Railcraft", "detector", 1, 5, missing),
                        getModItem("DraconicEvolution", "draconicCore", 1, 0, missing))
                .itemOutputs(getModItem("DraconicEvolution", "playerDetector", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Integration", "projectred.integration.gate", 1, 16, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17975, missing))
                .itemOutputs(getModItem("DraconicEvolution", "rainSensor", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "obsidian", 1, 0, missing),
                        getModItem("minecraft", "blaze_powder", 1, 0, missing))
                .itemOutputs(getModItem("DraconicEvolution", "infusedObsidian", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.draconium", 144)).noFluidOutputs().duration(1200)
                .eut(1920).specialValue(7500).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("DraconicEvolution", "chaosShard", 1, 0, missing))
                .itemOutputs(getModItem("DraconicEvolution", "chaosFragment", 9, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(480).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("DraconicEvolution", "chaosFragment", 1, 2, missing))
                .itemOutputs(getModItem("DraconicEvolution", "chaosFragment", 9, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(480).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("DraconicEvolution", "chaosFragment", 1, 1, missing))
                .itemOutputs(getModItem("DraconicEvolution", "chaosFragment", 9, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(25).eut(480).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("DraconicEvolution", "safetyMatch", 16, 1000, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 18879, missing))
                .itemOutputs(getModItem("DraconicEvolution", "safetyMatch", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(64).eut(16).addTo(sBoxinatorRecipes);

    }
}
