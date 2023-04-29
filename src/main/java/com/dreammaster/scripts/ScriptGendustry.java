package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;
import gregtech.api.util.GT_ModHandler;

public class ScriptGendustry implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Gendustry";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.Gendustry.ID, Mods.IronTanks.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("gendustry", "Imprinter", 1, 0, missing),
                new Object[] { getModItem("gendustry", "GeneticsProcessor", 1, 0, missing), "gearOsmium",
                        getModItem("gendustry", "GeneticsProcessor", 1, 0, missing),
                        getModItem("gendustry", "BeeReceptacle", 1, 0, missing),
                        getModItem("Forestry", "hardenedMachine", 1, 0, missing),
                        getModItem("gendustry", "BeeReceptacle", 1, 0, missing), "gearOsmium",
                        getModItem("gendustry", "PowerModule", 1, 0, missing), "gearOsmium" });
        addShapedRecipe(
                getModItem("gendustry", "Sampler", 1, 0, missing),
                new Object[] { getModItem("gendustry", "GeneticsProcessor", 1, 0, missing),
                        getModItem("gendustry", "BeeReceptacle", 1, 0, missing),
                        getModItem("gendustry", "GeneticsProcessor", 1, 0, missing),
                        getModItem("dreamcraft", "item.EngravedDiamondCrystalChip", 1, 0, missing),
                        getModItem("Forestry", "hardenedMachine", 1, 0, missing),
                        getModItem("dreamcraft", "item.EngravedDiamondCrystalChip", 1, 0, missing), "gearOsmium",
                        getModItem("gendustry", "PowerModule", 1, 0, missing), "gearOsmium" });
        addShapedRecipe(
                getModItem("gendustry", "Liquifier", 1, 0, missing),
                new Object[] { "gearOsmium", "blockHopper", "gearOsmium",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32645, missing),
                        getModItem("Forestry", "hardenedMachine", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32645, missing), "gearOsmium",
                        getModItem("gendustry", "PowerModule", 1, 0, missing), "gearOsmium" });
        addShapedRecipe(
                getModItem("gendustry", "Extractor", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32645, missing),
                        getModItem("gendustry", "BeeReceptacle", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32645, missing),
                        getModItem("gendustry", "GeneticsProcessor", 1, 0, missing),
                        getModItem("Forestry", "hardenedMachine", 1, 0, missing),
                        getModItem("gendustry", "GeneticsProcessor", 1, 0, missing), "gearOsmium",
                        getModItem("gendustry", "PowerModule", 1, 0, missing), "gearOsmium" });
        addShapedRecipe(
                getModItem("gendustry", "Transposer", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32655, missing), "gearOsmium",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32655, missing),
                        getModItem("gendustry", "GeneticsProcessor", 1, 0, missing),
                        getModItem("Forestry", "hardenedMachine", 1, 0, missing),
                        getModItem("gendustry", "GeneticsProcessor", 1, 0, missing), "gearOsmium",
                        getModItem("gendustry", "PowerModule", 1, 0, missing), "gearOsmium" });
        addShapedRecipe(
                getModItem("gendustry", "Replicator", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32655, missing),
                        getModItem("gendustry", "GeneticsProcessor", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32655, missing),
                        getModItem("gendustry", "PowerModule", 1, 0, missing),
                        getModItem("Forestry", "hardenedMachine", 1, 0, missing),
                        getModItem("gendustry", "PowerModule", 1, 0, missing), "gearOsmium",
                        getModItem("gendustry", "GeneticsProcessor", 1, 0, missing), "gearOsmium" });
        addShapedRecipe(
                getModItem("gendustry", "BeeReceptacle", 1, 0, missing),
                new Object[] { "screwHSSS", getModItem("gregtech", "gt.comb", 1, 78, missing), "screwHSSS",
                        getModItem("dreamcraft", "item.IridiumAlloyItemCasing", 1, 0, missing),
                        getModItem("dreamcraft", "item.OsmiumBars", 1, 0, missing),
                        getModItem("dreamcraft", "item.IridiumAlloyItemCasing", 1, 0, missing), "screwHSSS",
                        "craftingToolScrewdriver", "screwHSSS" });
        addShapedRecipe(
                getModItem("gendustry", "PowerModule", 1, 0, missing),
                new Object[] { "cableGt01VanadiumGallium", getModItem("gregtech", "gt.comb", 1, 79, missing),
                        "cableGt01VanadiumGallium",
                        getModItem("dreamcraft", "item.IridiumAlloyItemCasing", 1, 0, missing), "circuitMaster",
                        getModItem("dreamcraft", "item.IridiumAlloyItemCasing", 1, 0, missing), "gearGtSmallOsmium",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32606, missing), "gearGtSmallOsmium" });
        addShapedRecipe(
                getModItem("gendustry", "IndustrialGrafter", 1, 100, missing),
                new Object[] { "screwStainlessSteel", getModItem("Forestry", "grafter", 1, 0, missing),
                        "screwStainlessSteel", "gearGtSmallStainlessSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "gearGtSmallStainlessSteel",
                        "plateStainlessSteel", "batteryBasic", "plateStainlessSteel" });
        addShapedRecipe(
                getModItem("gendustry", "IndustrialScoop", 1, 100, missing),
                new Object[] { "screwStainlessSteel", "craftingToolScoop", "screwStainlessSteel",
                        "gearGtSmallStainlessSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                        "gearGtSmallStainlessSteel", "plateStainlessSteel", "batteryBasic", "plateStainlessSteel" });
        addShapedRecipe(
                getModItem("gendustry", "ClimateModule", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.comb", 1, 70, missing),
                        getModItem("IC2", "itemRecipePart", 1, 0, missing),
                        getModItem("gregtech", "gt.comb", 1, 77, missing), "stickPalladium", "rotorOsmium",
                        "stickPalladium", getModItem("dreamcraft", "item.IridiumAlloyItemCasing", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32606, missing),
                        getModItem("dreamcraft", "item.IridiumAlloyItemCasing", 1, 0, missing) });

        GT_ModHandler.addSmeltingRecipe(
                getModItem("gendustry", "GeneSample", 1, 0, missing),
                getModItem("gendustry", "GeneSampleBlank", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem("gendustry", "GeneTemplate", 1, 0, missing),
                getModItem("gendustry", "GeneTemplate", 1, 0, missing));
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28305, missing))
                .itemOutputs(getModItem("gendustry", "Labware", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 576)).noFluidOutputs().duration(100).eut(1920)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 17057, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2308, missing))
                .itemOutputs(getModItem("gendustry", "GeneSampleBlank", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 144)).noFluidOutputs().duration(20).eut(1920)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gendustry", "GeneSampleBlank", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing))
                .itemOutputs(getModItem("gendustry", "GeneTemplate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).noFluidOutputs().duration(200)
                .eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("irontank", "diamondTank", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 18052, missing))
                .itemOutputs(getModItem("gendustry", "MutagenTank", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plutonium", 576)).noFluidOutputs().duration(300)
                .eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.GeneticCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32705, missing))
                .itemOutputs(getModItem("gendustry", "GeneticsProcessor", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.GeneticCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32084, missing))
                .itemOutputs(getModItem("gendustry", "GeneticsProcessor", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.GeneticCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32086, missing))
                .itemOutputs(getModItem("gendustry", "GeneticsProcessor", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.GeneticCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32089, missing))
                .itemOutputs(getModItem("gendustry", "GeneticsProcessor", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.EnvironmentalCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32705, missing))
                .itemOutputs(getModItem("gendustry", "EnvProcessor", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("liquiddna", 500)).noFluidOutputs().duration(400).eut(1920)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.EnvironmentalCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32084, missing))
                .itemOutputs(getModItem("gendustry", "EnvProcessor", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("liquiddna", 500)).noFluidOutputs().duration(400).eut(1920)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.EnvironmentalCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32086, missing))
                .itemOutputs(getModItem("gendustry", "EnvProcessor", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("liquiddna", 500)).noFluidOutputs().duration(400).eut(1920)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.EnvironmentalCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32089, missing))
                .itemOutputs(getModItem("gendustry", "EnvProcessor", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("liquiddna", 500)).noFluidOutputs().duration(400).eut(1920)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17052, missing),
                        getModItem("IC2", "upgradeModule", 1, 3, missing))
                .itemOutputs(getModItem("gendustry", "EjectCover", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17052, missing),
                        getModItem("IC2", "upgradeModule", 1, 6, missing))
                .itemOutputs(getModItem("gendustry", "ImportCover", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17052, missing),
                        getModItem("IC2", "upgradeModule", 1, 5, missing))
                .itemOutputs(getModItem("gendustry", "ErrorSensorCover", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(1920).addTo(sAssemblerRecipes);

    }
}
