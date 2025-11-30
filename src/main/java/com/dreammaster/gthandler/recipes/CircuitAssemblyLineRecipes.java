package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.GTValues.RA;
import static gregtech.api.util.GTRecipeBuilder.HALF_INGOTS;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;

public class CircuitAssemblyLineRecipes implements Runnable{

    public void run(){
        RA.stdBuilder()
            .itemInputs(
                ItemList.Wrap_CircuitBoards.get(1),
                ItemList.Wrap_IntegratedLogicCircuits.get(1),
                ItemList.Wrap_SMDResistors.get(2),
                ItemList.Wrap_SMDDiodes.get(2),
                GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Copper, 2),
                GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 32))
            .itemOutputs(
                ItemList.Circuit_Chip_ILC.get(16))
            .fluidInputs(Materials.SolderingAlloy.getMolten(1*HALF_INGOTS))
            .special(ItemList.CircuitImprint_IntegratedLogicCircuit.get(1))
        ;
    }
}
