package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.ExtraBees;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.Gendustry;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronTanks;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.gthandler.CustomItemList;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.common.items.CombType;
import gregtech.loaders.misc.GTBees;
import gtPlusPlus.core.material.MaterialsElements;

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
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing),
                "gearOsmium",
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing),
                getModItem(Gendustry.ID, "BeeReceptacle", 1, 0, missing),
                getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing),
                getModItem(Gendustry.ID, "BeeReceptacle", 1, 0, missing),
                "gearOsmium",
                getModItem(Gendustry.ID, "PowerModule", 1, 0, missing),
                "gearOsmium");
        addShapedRecipe(
                getModItem(Gendustry.ID, "Sampler", 1, 0, missing),
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing),
                getModItem(Gendustry.ID, "BeeReceptacle", 1, 0, missing),
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing),
                CustomItemList.EngravedDiamondCrystalChip.get(1L),
                getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing),
                CustomItemList.EngravedDiamondCrystalChip.get(1L),
                "gearOsmium",
                getModItem(Gendustry.ID, "PowerModule", 1, 0, missing),
                "gearOsmium");
        addShapedRecipe(
                getModItem(Gendustry.ID, "Liquifier", 1, 0, missing),
                "gearOsmium",
                "blockHopper",
                "gearOsmium",
                ItemList.Electric_Piston_LuV.get(1L),
                getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing),
                ItemList.Electric_Piston_LuV.get(1L),
                "gearOsmium",
                getModItem(Gendustry.ID, "PowerModule", 1, 0, missing),
                "gearOsmium");
        addShapedRecipe(
                getModItem(Gendustry.ID, "Extractor", 1, 0, missing),
                ItemList.Electric_Piston_LuV.get(1L),
                getModItem(Gendustry.ID, "BeeReceptacle", 1, 0, missing),
                ItemList.Electric_Piston_LuV.get(1L),
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing),
                getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing),
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing),
                "gearOsmium",
                getModItem(Gendustry.ID, "PowerModule", 1, 0, missing),
                "gearOsmium");
        addShapedRecipe(
                getModItem(Gendustry.ID, "Transposer", 1, 0, missing),
                ItemList.Robot_Arm_LuV.get(1L),
                "gearOsmium",
                ItemList.Robot_Arm_LuV.get(1L),
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing),
                getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing),
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing),
                "gearOsmium",
                getModItem(Gendustry.ID, "PowerModule", 1, 0, missing),
                "gearOsmium");
        addShapedRecipe(
                getModItem(Gendustry.ID, "Replicator", 1, 0, missing),
                ItemList.Robot_Arm_LuV.get(1L),
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing),
                ItemList.Robot_Arm_LuV.get(1L),
                getModItem(Gendustry.ID, "PowerModule", 1, 0, missing),
                getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing),
                getModItem(Gendustry.ID, "PowerModule", 1, 0, missing),
                "gearOsmium",
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing),
                "gearOsmium");
        addShapedRecipe(
                getModItem(Gendustry.ID, "BeeReceptacle", 1, 0, missing),
                "screwHSSS",
                GTBees.combs.getStackForType(CombType.PLUTONIUM),
                "screwHSSS",
                CustomItemList.IridiumAlloyItemCasing.get(1L),
                CustomItemList.OsmiumBars.get(1L),
                CustomItemList.IridiumAlloyItemCasing.get(1L),
                "screwHSSS",
                "craftingToolScrewdriver",
                "screwHSSS");
        addShapedRecipe(
                getModItem(Gendustry.ID, "PowerModule", 1, 0, missing),
                "cableGt01VanadiumGallium",
                GTBees.combs.getStackForType(CombType.NAQUADAH),
                "cableGt01VanadiumGallium",
                CustomItemList.IridiumAlloyItemCasing.get(1L),
                "circuitMaster",
                CustomItemList.IridiumAlloyItemCasing.get(1L),
                "gearGtSmallOsmium",
                ItemList.Electric_Motor_LuV.get(1L),
                "gearGtSmallOsmium");
        addShapedRecipe(
                getModItem(Gendustry.ID, "IndustrialGrafter", 1, 100, missing),
                "screwStainlessSteel",
                getModItem(Forestry.ID, "grafter", 1, 0, missing),
                "screwStainlessSteel",
                "gearGtSmallStainlessSteel",
                ItemList.Electric_Motor_LV.get(1L),
                "gearGtSmallStainlessSteel",
                "plateStainlessSteel",
                "batteryBasic",
                "plateStainlessSteel");
        addShapedRecipe(
                getModItem(Gendustry.ID, "IndustrialScoop", 1, 100, missing),
                "screwStainlessSteel",
                "craftingToolScoop",
                "screwStainlessSteel",
                "gearGtSmallStainlessSteel",
                ItemList.Electric_Motor_LV.get(1L),
                "gearGtSmallStainlessSteel",
                "plateStainlessSteel",
                "batteryBasic",
                "plateStainlessSteel");
        addShapedRecipe(
                getModItem(Gendustry.ID, "ClimateModule", 1, 0, missing),
                GTBees.combs.getStackForType(CombType.IRIDIUM),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                GTBees.combs.getStackForType(CombType.URANIUM),
                "stickPalladium",
                "rotorOsmium",
                "stickPalladium",
                CustomItemList.IridiumAlloyItemCasing.get(1L),
                ItemList.Electric_Motor_LuV.get(1L),
                CustomItemList.IridiumAlloyItemCasing.get(1L));

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
                ItemList.Electric_Pump_ZPM.get(1L),
                'e',
                ItemList.Robot_Arm_ZPM.get(1L),
                'f',
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing),
                'g',
                getModItem(Gendustry.ID, "BeeReceptacle", 1, 0, missing),
                'h',
                "gearOsmium",
                'i',
                getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing),
                'j',
                ItemList.Electric_Motor_ZPM.get(1L));
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
                ItemList.Casing_HeatProof.get(1L),
                'b',
                getModItem(ExtraBees.ID, "alveary", 1, 5, missing),
                'c',
                getModItem(Forestry.ID, "factory", 1, 2, missing),
                'd',
                GTBees.combs.getStackForType(CombType.NAQUADAH),
                'e',
                ItemList.Robot_Arm_LuV.get(1L),
                'f',
                getModItem(Gendustry.ID, "MutagenTank", 1, 0, missing),
                'g',
                MaterialsElements.getInstance().RUTHENIUM.getPlate(1),
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
                GTOreDictUnificator.get(OrePrefixes.plateQuintuple, Materials.Europium, 1L),
                'b',
                getModItem(Gendustry.ID, "Replicator", 1, 0, missing),
                'c',
                GTOreDictUnificator.get(OrePrefixes.plateQuintuple, Materials.Naquadria, 1L),
                'd',
                getModItem(Gendustry.ID, "Liquifier", 1, 0, missing),
                'e',
                getModItem(Gendustry.ID, "Labware", 1, 0, missing),
                'f',
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing),
                'g',
                ItemList.Robot_Arm_ZPM.get(1L),
                'h',
                getModItem(Gendustry.ID, "Sampler", 1, 0, missing),
                'i',
                GTBees.combs.getStackForType(CombType.NEUTRONIUM),
                'j',
                getModItem(Gendustry.ID, "Mutatron", 1, 0, missing),
                'k',
                getModItem(Gendustry.ID, "Imprinter", 1, 0, missing),
                'l',
                getModItem(Gendustry.ID, "Transposer", 1, 0, missing),
                'm',
                getModItem(Gendustry.ID, "Extractor", 1, 0, missing));

        GTModHandler.addSmeltingRecipe(
                getModItem(Gendustry.ID, "GeneSample", 1, 0, missing),
                getModItem(Gendustry.ID, "GeneSampleBlank", 1, 0, missing));
        GTModHandler.addSmeltingRecipe(
                getModItem(Gendustry.ID, "GeneTemplate", 1, 0, missing),
                getModItem(Gendustry.ID, "GeneTemplate", 1, 0, missing));
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1L))
                .itemOutputs(getModItem(Gendustry.ID, "Labware", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 576)).duration(5 * SECONDS).eut(1920)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.RedAlloy, 1L))
                .itemOutputs(getModItem(Gendustry.ID, "GeneSampleBlank", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 144)).duration(20).eut(1920)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Gendustry.ID, "GeneSampleBlank", 4, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L))
                .itemOutputs(getModItem(Gendustry.ID, "GeneTemplate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).duration(10 * SECONDS).eut(1920)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronTanks.ID, "diamondTank", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Palladium, 1L))
                .itemOutputs(getModItem(Gendustry.ID, "MutagenTank", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plutonium", 576)).duration(15 * SECONDS).eut(1920)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        com.dreammaster.item.ItemList.GeneticCircuit.getIS(1),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 1))
                .itemOutputs(getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing)).duration(20 * SECONDS)
                .eut(1920).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        com.dreammaster.item.ItemList.EnvironmentalCircuit.getIS(1),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 1))
                .itemOutputs(getModItem(Gendustry.ID, "EnvProcessor", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("liquiddna", 500)).duration(20 * SECONDS).eut(1920)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Palladium, 1L),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 3, missing))
                .itemOutputs(getModItem(Gendustry.ID, "EjectCover", 1, 0, missing)).duration(10 * SECONDS).eut(1920)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Palladium, 1L),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 6, missing))
                .itemOutputs(getModItem(Gendustry.ID, "ImportCover", 1, 0, missing)).duration(10 * SECONDS).eut(1920)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Palladium, 1L),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 5, missing))
                .itemOutputs(getModItem(Gendustry.ID, "ErrorSensorCover", 1, 0, missing)).duration(10 * SECONDS)
                .eut(1920).addTo(assemblerRecipes);

    }
}
