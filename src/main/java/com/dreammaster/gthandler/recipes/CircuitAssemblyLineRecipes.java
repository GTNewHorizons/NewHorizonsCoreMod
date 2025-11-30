package com.dreammaster.gthandler.recipes;

import static bartworks.API.recipe.BartWorksRecipeMaps.circuitAssemblyLineRecipes;
import static gregtech.api.enums.GTValues.RA;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.util.GTModHandler.getModItem;
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
