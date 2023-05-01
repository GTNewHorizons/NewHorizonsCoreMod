package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.ExtraBees;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.Gendustry;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronTanks;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GT_Values;
import gregtech.api.util.GT_ModHandler;

public class ScriptGendustry implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Gendustry";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Gendustry.ID, IronTanks.ID, ExtraBees.ID, Forestry.ID, GTPlusPlus.ID, IndustrialCraft2.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(Gendustry.ID, "Imprinter", 1, 0, missing),
                new Object[] { getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing), "gearOsmium",
                        getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing),
                        getModItem(Gendustry.ID, "BeeReceptacle", 1, 0, missing),
                        getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing),
                        getModItem(Gendustry.ID, "BeeReceptacle", 1, 0, missing), "gearOsmium",
                        getModItem(Gendustry.ID, "PowerModule", 1, 0, missing), "gearOsmium" });
        addShapedRecipe(
                getModItem(Gendustry.ID, "Sampler", 1, 0, missing),
                new Object[] { getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing),
                        getModItem(Gendustry.ID, "BeeReceptacle", 1, 0, missing),
                        getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.EngravedDiamondCrystalChip", 1, 0, missing),
                        getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.EngravedDiamondCrystalChip", 1, 0, missing),
                        "gearOsmium", getModItem(Gendustry.ID, "PowerModule", 1, 0, missing), "gearOsmium" });
        addShapedRecipe(
                getModItem(Gendustry.ID, "Liquifier", 1, 0, missing),
                new Object[] { "gearOsmium", "blockHopper", "gearOsmium",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32645, missing),
                        getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32645, missing), "gearOsmium",
                        getModItem(Gendustry.ID, "PowerModule", 1, 0, missing), "gearOsmium" });
        addShapedRecipe(
                getModItem(Gendustry.ID, "Extractor", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32645, missing),
                        getModItem(Gendustry.ID, "BeeReceptacle", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32645, missing),
                        getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing),
                        getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing),
                        getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing), "gearOsmium",
                        getModItem(Gendustry.ID, "PowerModule", 1, 0, missing), "gearOsmium" });
        addShapedRecipe(
                getModItem(Gendustry.ID, "Transposer", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32655, missing), "gearOsmium",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32655, missing),
                        getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing),
                        getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing),
                        getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing), "gearOsmium",
                        getModItem(Gendustry.ID, "PowerModule", 1, 0, missing), "gearOsmium" });
        addShapedRecipe(
                getModItem(Gendustry.ID, "Replicator", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32655, missing),
                        getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32655, missing),
                        getModItem(Gendustry.ID, "PowerModule", 1, 0, missing),
                        getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing),
                        getModItem(Gendustry.ID, "PowerModule", 1, 0, missing), "gearOsmium",
                        getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing), "gearOsmium" });
        addShapedRecipe(
                getModItem(Gendustry.ID, "BeeReceptacle", 1, 0, missing),
                new Object[] { "screwHSSS", getModItem(GregTech.ID, "gt.comb", 1, 78, missing), "screwHSSS",
                        getModItem(NewHorizonsCoreMod.ID, "item.IridiumAlloyItemCasing", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.OsmiumBars", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.IridiumAlloyItemCasing", 1, 0, missing), "screwHSSS",
                        "craftingToolScrewdriver", "screwHSSS" });
        addShapedRecipe(
                getModItem(Gendustry.ID, "PowerModule", 1, 0, missing),
                new Object[] { "cableGt01VanadiumGallium", getModItem(GregTech.ID, "gt.comb", 1, 79, missing),
                        "cableGt01VanadiumGallium",
                        getModItem(NewHorizonsCoreMod.ID, "item.IridiumAlloyItemCasing", 1, 0, missing),
                        "circuitMaster",
                        getModItem(NewHorizonsCoreMod.ID, "item.IridiumAlloyItemCasing", 1, 0, missing),
                        "gearGtSmallOsmium", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32606, missing),
                        "gearGtSmallOsmium" });
        addShapedRecipe(
                getModItem(Gendustry.ID, "IndustrialGrafter", 1, 100, missing),
                new Object[] { "screwStainlessSteel", getModItem(Forestry.ID, "grafter", 1, 0, missing),
                        "screwStainlessSteel", "gearGtSmallStainlessSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "gearGtSmallStainlessSteel",
                        "plateStainlessSteel", "batteryBasic", "plateStainlessSteel" });
        addShapedRecipe(
                getModItem(Gendustry.ID, "IndustrialScoop", 1, 100, missing),
                new Object[] { "screwStainlessSteel", "craftingToolScoop", "screwStainlessSteel",
                        "gearGtSmallStainlessSteel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        "gearGtSmallStainlessSteel", "plateStainlessSteel", "batteryBasic", "plateStainlessSteel" });
        addShapedRecipe(
                getModItem(Gendustry.ID, "ClimateModule", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.comb", 1, 70, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.comb", 1, 77, missing), "stickPalladium", "rotorOsmium",
                        "stickPalladium",
                        getModItem(NewHorizonsCoreMod.ID, "item.IridiumAlloyItemCasing", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32606, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.IridiumAlloyItemCasing", 1, 0, missing) });

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(Gendustry.ID, "MutagenProducer", 1, 0, missing),
                "---------",
                "---------",
                "--abcba--",
                "--defed--",
                "--ghihg--",
                "--djfjd--",
                "--abcba--",
                "---------",
                "---------",
                'a',
                getModItem(Gendustry.ID, "MutagenTank", 1, 0, missing),
                'b',
                "plateBlackPlutonium",
                'c',
                getModItem(Gendustry.ID, "PowerModule", 1, 0, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32616, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32656, missing),
                'f',
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing),
                'g',
                getModItem(Gendustry.ID, "BeeReceptacle", 1, 0, missing),
                'h',
                "gearOsmium",
                'i',
                getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing),
                'j',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32607, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(Gendustry.ID, "Mutatron", 1, 0, missing),
                "---------",
                "---------",
                "--abcba--",
                "--defed--",
                "--ghihg--",
                "--defed--",
                "--abjba--",
                "---------",
                "---------",
                'a',
                getModItem(GregTech.ID, "gt.blockcasings", 1, 11, missing),
                'b',
                getModItem(ExtraBees.ID, "alveary", 1, 5, missing),
                'c',
                getModItem(Forestry.ID, "factory", 1, 2, missing),
                'd',
                getModItem(GregTech.ID, "gt.comb", 1, 79, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32655, missing),
                'f',
                getModItem(Gendustry.ID, "MutagenTank", 1, 0, missing),
                'g',
                getModItem(GTPlusPlus.ID, "itemGearRuthenium", 1, 0, missing),
                'h',
                getModItem(ExtraBees.ID, "alveary", 1, 6, missing),
                'i',
                getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing),
                'j',
                getModItem(Forestry.ID, "factory", 1, 5, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(Gendustry.ID, "MutatronAdv", 1, 0, missing),
                "---------",
                "-aaaaaaa-",
                "-abcccda-",
                "-aefgfea-",
                "-ahijika-",
                "-aefgfea-",
                "-alcccma-",
                "-aaaaaaa-",
                "---------",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 21070, missing),
                'b',
                getModItem(Gendustry.ID, "Replicator", 1, 0, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 21327, missing),
                'd',
                getModItem(Gendustry.ID, "Liquifier", 1, 0, missing),
                'e',
                getModItem(Gendustry.ID, "Labware", 1, 0, missing),
                'f',
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32656, missing),
                'h',
                getModItem(Gendustry.ID, "Sampler", 1, 0, missing),
                'i',
                getModItem(GregTech.ID, "gt.comb", 1, 85, missing),
                'j',
                getModItem(Gendustry.ID, "Mutatron", 1, 0, missing),
                'k',
                getModItem(Gendustry.ID, "Imprinter", 1, 0, missing),
                'l',
                getModItem(Gendustry.ID, "Transposer", 1, 0, missing),
                'm',
                getModItem(Gendustry.ID, "Extractor", 1, 0, missing));

        GT_ModHandler.addSmeltingRecipe(
                getModItem(Gendustry.ID, "GeneSample", 1, 0, missing),
                getModItem(Gendustry.ID, "GeneSampleBlank", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem(Gendustry.ID, "GeneTemplate", 1, 0, missing),
                getModItem(Gendustry.ID, "GeneTemplate", 1, 0, missing));
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28305, missing))
                .itemOutputs(getModItem(Gendustry.ID, "Labware", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 576)).noFluidOutputs().duration(100).eut(1920)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2308, missing))
                .itemOutputs(getModItem(Gendustry.ID, "GeneSampleBlank", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 144)).noFluidOutputs().duration(20).eut(1920)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Gendustry.ID, "GeneSampleBlank", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing))
                .itemOutputs(getModItem(Gendustry.ID, "GeneTemplate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).noFluidOutputs().duration(200)
                .eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronTanks.ID, "diamondTank", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 18052, missing))
                .itemOutputs(getModItem(Gendustry.ID, "MutagenTank", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plutonium", 576)).noFluidOutputs().duration(300)
                .eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.GeneticCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32705, missing))
                .itemOutputs(getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.GeneticCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32084, missing))
                .itemOutputs(getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.GeneticCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32086, missing))
                .itemOutputs(getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.GeneticCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32089, missing))
                .itemOutputs(getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.EnvironmentalCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32705, missing))
                .itemOutputs(getModItem(Gendustry.ID, "EnvProcessor", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("liquiddna", 500)).noFluidOutputs().duration(400).eut(1920)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.EnvironmentalCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32084, missing))
                .itemOutputs(getModItem(Gendustry.ID, "EnvProcessor", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("liquiddna", 500)).noFluidOutputs().duration(400).eut(1920)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.EnvironmentalCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32086, missing))
                .itemOutputs(getModItem(Gendustry.ID, "EnvProcessor", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("liquiddna", 500)).noFluidOutputs().duration(400).eut(1920)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.EnvironmentalCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32089, missing))
                .itemOutputs(getModItem(Gendustry.ID, "EnvProcessor", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("liquiddna", 500)).noFluidOutputs().duration(400).eut(1920)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17052, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 3, missing))
                .itemOutputs(getModItem(Gendustry.ID, "EjectCover", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17052, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 6, missing))
                .itemOutputs(getModItem(Gendustry.ID, "ImportCover", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17052, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 5, missing))
                .itemOutputs(getModItem(Gendustry.ID, "ErrorSensorCover", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(1920).addTo(sAssemblerRecipes);

    }
}
