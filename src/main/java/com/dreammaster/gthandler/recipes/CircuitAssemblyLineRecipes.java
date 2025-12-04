package com.dreammaster.gthandler.recipes;

import static bartworks.API.recipe.BartWorksRecipeMaps.circuitAssemblyLineRecipes;
import static gregtech.api.enums.GTValues.RA;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.EIGHTH_INGOTS;
import static gregtech.api.util.GTRecipeBuilder.HALF_INGOTS;
import static gregtech.api.util.GTRecipeBuilder.INGOTS;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import net.minecraft.item.Item;

public class CircuitAssemblyLineRecipes implements Runnable{

    public void run(){
        // Integrated Logic Circuit
        RA.stdBuilder()
            .itemInputs(
                ItemList.Wrap_CircuitBoards.get(1),
                ItemList.Wrap_IntegratedLogicCircuits.get(1),
                ItemList.Wrap_SMDResistors.get(2),
                ItemList.Wrap_SMDDiodes.get(2),
                GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Copper, 2),
                GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 32))
            .itemOutputs(
                ItemList.Circuit_Basic.get(16))
            .fluidInputs(Materials.SolderingAlloy.getMolten(1*HALF_INGOTS))
            .special(ItemList.CircuitImprint_IntegratedLogicCircuit.get(0))
            .eut(16)
            .duration(2*MINUTES)
            .addTo(circuitAssemblyLineRecipes);

        // Good Integrated Circuit
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_GoodCircuitBoards.get(1),
                        ItemList.Circuit_Basic.get(32),
                        ItemList.Wrap_AdvancedSMDResistors.get(1),
                        ItemList.Wrap_AdvancedSMDDiodes.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Gold, 4),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 64))
                .itemOutputs(
                        ItemList.Circuit_Integrated_Good.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1*HALF_INGOTS))
                .special(ItemList.CircuitImprint_GoodIntegratedCircuit.get(0))
                .eut(24)
                .duration(2*MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_GoodCircuitBoards.get(1),
                        ItemList.Circuit_Basic.get(32),
                        ItemList.Wrap_SMDResistors.get(4),
                        ItemList.Wrap_SMDDiodes.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Gold, 4),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 64))
                .itemOutputs(
                        ItemList.Circuit_Integrated_Good.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1*HALF_INGOTS))
                .special(ItemList.CircuitImprint_GoodIntegratedCircuit.get(0))
                .eut(24)
                .duration(4*MINUTES)
                .addTo(circuitAssemblyLineRecipes);


        // Basic Circuit Board
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_CircuitBoards.get(1),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 32),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Iron, 32),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 64),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Iron, 1),
                        GTUtility.getIntegratedCircuit(1)
                )
                .itemOutputs(getModItem(Forestry.ID, "chipsets", 16, 0))
                .fluidInputs(Materials.SolderingAlloy.getMolten(4*INGOTS))
                .special(ItemList.CircuitImprint_BasicCircuitBoard.get(0))
                .eut(TierEU.LV)
                .duration(2*MINUTES)
                .requireMods(Forestry)
                .addTo(circuitAssemblyLineRecipes);

        // Enhanced Circuit Board
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_CircuitBoards.get(1),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 32),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Bronze, 32),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 64),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Bronze, 16),
                        GTUtility.getIntegratedCircuit(1)
                )
                .itemOutputs(getModItem(Forestry.ID, "chipsets", 16, 1))
                .fluidInputs(Materials.SolderingAlloy.getMolten(4*INGOTS))
                .special(ItemList.CircuitImprint_EnhancedCircuitBoard.get(0))
                .eut(TierEU.RECIPE_LV)
                .duration(2*MINUTES)
                .requireMods(Forestry)
                .addTo(circuitAssemblyLineRecipes);

        // Refined Circuit Board
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_GoodCircuitBoards.get(1),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 32),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Steel, 32),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 64),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Steel, 1),
                        GTUtility.getIntegratedCircuit(1)
                )
                .itemOutputs(getModItem(Forestry.ID, "chipsets", 16, 2))
                .fluidInputs(Materials.SolderingAlloy.getMolten(4*INGOTS))
                .special(ItemList.CircuitImprint_RefinedCircuitBoard.get(0))
                .eut(TierEU.RECIPE_LV)
                .duration(2*MINUTES)
                .requireMods(Forestry)
                .addTo(circuitAssemblyLineRecipes);

        // Intricate Circuit Board
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_GoodCircuitBoards.get(1),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 32),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 32),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Electrum, 64),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 1),
                        GTUtility.getIntegratedCircuit(1)
                )
                .itemOutputs(getModItem(Forestry.ID, "chipsets", 16, 3))
                .fluidInputs(Materials.SolderingAlloy.getMolten(4*INGOTS))
                .special(ItemList.CircuitImprint_IntricateCircuitBoard.get(0))
                .eut(TierEU.RECIPE_LV)
                .duration(2*MINUTES)
                .requireMods(Forestry)
                .addTo(circuitAssemblyLineRecipes);

        // Controller Circuit
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_CircuitBoards.get(1),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 16),
                        ItemList.Cover_Controller.get(16)

                )
                .itemOutputs(GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 0))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1*HALF_INGOTS))
                .special(ItemList.CircuitImprint_ControllerCircuit.get(0))
                .eut(TierEU.RECIPE_LV)
                .duration(3*MINUTES)
                .requireMods(Railcraft)
                .addTo(circuitAssemblyLineRecipes);

        // Receiver Circuit
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_CircuitBoards.get(1),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 16),
                        ItemList.Sensor_LV.get(16)

                )
                .itemOutputs(GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 1))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1*HALF_INGOTS))
                .special(ItemList.CircuitImprint_ReceiverCircuit.get(0))
                .eut(TierEU.RECIPE_LV)
                .duration(3*MINUTES)
                .requireMods(Railcraft)
                .addTo(circuitAssemblyLineRecipes);

        // Signal Circuit
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_CircuitBoards.get(1),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 16),
                        GTModHandler.getModItem(Railcraft.ID, "part.signal.lamp", 64, 1)

                )
                .itemOutputs(GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 2))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1*HALF_INGOTS))
                .special(ItemList.CircuitImprint_SignalCircuit.get(0))
                .eut(TierEU.RECIPE_LV)
                .duration(3*MINUTES)
                .requireMods(Railcraft)
                .addTo(circuitAssemblyLineRecipes);

        // Good Electronic Circuit
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_GoodCircuitBoards.get(1),
                        GTModHandler.getIC2Item("itemPartCircuit", 32),
                        ItemList.Wrap_SMDDiodes.get(2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.Copper, 2)
                )
                .itemOutputs(ItemList.Circuit_Integrated_Good.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1*HALF_INGOTS))
                .special(ItemList.CircuitImprint_GoodElectronicCircuit.get(0))
                .eut(TierEU.RECIPE_LV)
                .duration(3*MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Controller Circuit
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_GoodCircuitBoards.get(1),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 16),
                        ItemList.Cover_Controller.get(16)

                )
                .itemOutputs(
                        GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 0),
                        GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 0)
                )
                .fluidInputs(Materials.SolderingAlloy.getMolten(1*HALF_INGOTS))
                .special(ItemList.CircuitImprint_ControllerCircuit.get(0))
                .eut(TierEU.RECIPE_LV)
                .duration(4*MINUTES)
                .requireMods(Railcraft)
                .addTo(circuitAssemblyLineRecipes);

        // Receiver Circuit
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_GoodCircuitBoards.get(1),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 16),
                        ItemList.Sensor_LV.get(16)

                )
                .itemOutputs(
                        GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 1),
                        GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 1)
                )
                .fluidInputs(Materials.SolderingAlloy.getMolten(1*HALF_INGOTS))
                .special(ItemList.CircuitImprint_ReceiverCircuit.get(0))
                .eut(TierEU.RECIPE_LV)
                .duration(4*MINUTES)
                .requireMods(Railcraft)
                .addTo(circuitAssemblyLineRecipes);

        // Signal Circuit
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_GoodCircuitBoards.get(1),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 16),
                        GTModHandler.getModItem(Railcraft.ID, "part.signal.lamp", 64, 1)
                )
                .itemOutputs(
                        GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 2),
                        GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 2)
                )
                .fluidInputs(Materials.SolderingAlloy.getMolten(1*HALF_INGOTS))
                .special(ItemList.CircuitImprint_SignalCircuit.get(0))
                .eut(TierEU.RECIPE_LV)
                .duration(4*MINUTES)
                .requireMods(Railcraft)
                .addTo(circuitAssemblyLineRecipes);

        // Controller Circuit
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_AdvancedCircuitBoards.get(1),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 16),
                        ItemList.Cover_Controller.get(16)

                )
                .itemOutputs(
                        GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 0),
                        GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 0),
                        GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 0),
                        GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 0)
                )
                .fluidInputs(Materials.SolderingAlloy.getMolten(1*HALF_INGOTS))
                .special(ItemList.CircuitImprint_ControllerCircuit.get(0))
                .eut(TierEU.RECIPE_LV)
                .duration(5*MINUTES)
                .requireMods(Railcraft)
                .addTo(circuitAssemblyLineRecipes);

        // Receiver Circuit
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_AdvancedCircuitBoards.get(1),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 16),
                        ItemList.Sensor_LV.get(16)

                )
                .itemOutputs(
                        GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 1),
                        GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 1),
                        GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 1),
                        GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 1)
                )
                .fluidInputs(Materials.SolderingAlloy.getMolten(1*HALF_INGOTS))
                .special(ItemList.CircuitImprint_ReceiverCircuit.get(0))
                .eut(TierEU.RECIPE_LV)
                .duration(5*MINUTES)
                .requireMods(Railcraft)
                .addTo(circuitAssemblyLineRecipes);

        // Signal Circuit
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_AdvancedCircuitBoards.get(1),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 16),
                        GTModHandler.getModItem(Railcraft.ID, "part.signal.lamp", 64, 1)
                )
                .itemOutputs(
                        GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 2),
                        GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 2),
                        GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 2),
                        GTModHandler.getModItem(Railcraft.ID, "part.circuit", 64, 2)
                )
                .fluidInputs(Materials.SolderingAlloy.getMolten(1*HALF_INGOTS))
                .special(ItemList.CircuitImprint_SignalCircuit.get(0))
                .eut(TierEU.RECIPE_LV)
                .duration(5*MINUTES)
                .requireMods(Railcraft)
                .addTo(circuitAssemblyLineRecipes);

        // Integrated Processor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_PlasticCircuitBoards2.get(1),
                        ItemList.Wrap_CentralProcessingUnits.get(1),
                        ItemList.Wrap_AdvancedSMDResistors.get(1),
                        ItemList.Wrap_AdvancedSMDCapacitors.get(1),
                        ItemList.Wrap_AdvancedSMDTransistors.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.RedAlloy, 4)
                )
                .itemOutputs(ItemList.Circuit_Processor.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1*HALF_INGOTS))
                .special(ItemList.CircuitImprint_IntegratedProcessor.get(0))
                .eut(60)
                .duration(1*MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Microprocessor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_PlasticCircuitBoards2.get(1),
                        ItemList.Wrap_CentralProcessingUnits.get(1),
                        ItemList.Wrap_SMDResistors.get(2),
                        ItemList.Wrap_SMDCapacitors.get(2),
                        ItemList.Wrap_SMDTransistors.get(2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Copper, 2)
                )
                .itemOutputs(ItemList.Circuit_Microprocessor.get(32))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1*HALF_INGOTS))
                .special(ItemList.CircuitImprint_Microprocessor.get(0))
                .eut(60)
                .duration(2*MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Integrated Processor
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_PlasticCircuitBoards2.get(1),
                        ItemList.Wrap_CentralProcessingUnits.get(1),
                        ItemList.Wrap_SMDResistors.get(4),
                        ItemList.Wrap_SMDCapacitors.get(4),
                        ItemList.Wrap_SMDTransistors.get(4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.RedAlloy, 4)
                )
                .itemOutputs(ItemList.Circuit_Processor.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1*HALF_INGOTS))
                .special(ItemList.CircuitImprint_IntegratedProcessor.get(0))
                .eut(60)
                .duration(2*MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // Processor Assembly
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_PlasticCircuitBoards2.get(1),
                        ItemList.Circuit_Processor.get(32),
                        ItemList.Wrap_AdvancedSMDInductors.get(1),
                        ItemList.Wrap_AdvancedSMDCapacitors.get(2),
                        ItemList.Wrap_RandomAccessMemoryChips.get(4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.RedAlloy, 8)
                )
                .itemOutputs(ItemList.Circuit_Advanced.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1*INGOTS))
                .special(ItemList.CircuitImprint_ProcessorAssembly.get(0))
                .eut(96)
                .duration(1*MINUTES+30*SECONDS)
                .addTo(circuitAssemblyLineRecipes);

        // NAND Chip Array
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_GoodCircuitBoards.get(1),
                        ItemList.Wrap_SimpleSOCs.get(1),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 16),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.AnnealedCopper, 1)

                )
                .itemOutputs(ItemList.NandChip.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1*EIGHTH_INGOTS))
                .special(ItemList.CircuitImprint_NANDChipArray.get(0))
                .eut(TierEU.RECIPE_MV)
                .duration(1*MINUTES+30*SECONDS)
                .addTo(circuitAssemblyLineRecipes);

        // Workstation
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_PlasticCircuitBoards2.get(1),
                        ItemList.Circuit_Advanced.get(32),
                        ItemList.Wrap_AdvancedSMDDiodes.get(1),
                        ItemList.Wrap_RandomAccessMemoryChips.get(8),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 16),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.BlueAlloy, 64)

                )
                .itemOutputs(ItemList.Circuit_Data.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1*INGOTS))
                .special(ItemList.CircuitImprint_Workstation.get(0))
                .eut(TierEU.RECIPE_MV)
                .duration(2*MINUTES)
                .addTo(circuitAssemblyLineRecipes);

        // NAND Chip Array
        RA.stdBuilder()
                .itemInputs(
                        ItemList.Wrap_GoodCircuitBoards.get(1),
                        ItemList.Wrap_SimpleSOCs.get(1),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 16),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Copper, 1)

                )
                .itemOutputs(ItemList.NandChip.get(16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1*EIGHTH_INGOTS))
                .special(ItemList.CircuitImprint_NANDChipArray.get(0))
                .eut(TierEU.RECIPE_MV)
                .duration(3*MINUTES)
                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);
//
//        RA.stdBuilder()
//                .itemInputs()
//                .itemOutputs()
//                .fluidInputs()
//                .special()
//                .eut()
//                .duration()
//                .addTo(circuitAssemblyLineRecipes);

    }
}
