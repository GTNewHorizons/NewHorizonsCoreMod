package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TinkersMechworks;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.wiremillRecipes;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class ScriptMechworks implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Mechworks";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(TinkersMechworks.ID, TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(TinkersMechworks.ID, "RedstoneMachine", 1, 0, missing),
                "plateBrass",
                ItemList.Conveyor_Module_LV.get(1L),
                "plateBrass",
                "gearSteel",
                getModItem(Minecraft.ID, "dispenser", 1, 0, missing),
                "gearSteel",
                "plateBrass",
                "craftingPiston",
                "plateBrass");
        addShapedRecipe(
                getModItem(TinkersMechworks.ID, "RedstoneMachine", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 7, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 7, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 7, missing),
                "plateBrass",
                getModItem(Minecraft.ID, "flint_and_steel", 1, 0, missing),
                "plateBrass",
                "plateBrass",
                "plateBrass",
                "plateBrass");

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersMechworks.ID, "RedstoneMachine", 1, 0, missing),
                        ItemList.Automation_Filter_LV.get(1L))
                .itemOutputs(getModItem(TinkersMechworks.ID, "RedstoneMachine", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).duration(30 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersMechworks.ID, "RedstoneMachine", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Cobalt, 6L))
                .itemOutputs(getModItem(TinkersMechworks.ID, "RedstoneMachine", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1152)).duration(1 * MINUTES).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 1L),
                        getModItem(TinkersMechworks.ID, "LengthWire", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(TinkersMechworks.ID, "SpoolWire", 1, 256, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersMechworks.ID, "LengthWire", 64, 0, missing),
                        getModItem(TinkersMechworks.ID, "SpoolWire", 1, 256, missing))
                .itemOutputs(getModItem(TinkersMechworks.ID, "SpoolWire", 1, 192, missing))
                .duration(1 * MINUTES + 4 * SECONDS).eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersMechworks.ID, "LengthWire", 64, 0, missing),
                        getModItem(TinkersMechworks.ID, "SpoolWire", 1, 192, missing))
                .itemOutputs(getModItem(TinkersMechworks.ID, "SpoolWire", 1, 128, missing))
                .duration(1 * MINUTES + 4 * SECONDS).eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersMechworks.ID, "LengthWire", 64, 0, missing),
                        getModItem(TinkersMechworks.ID, "SpoolWire", 1, 128, missing))
                .itemOutputs(getModItem(TinkersMechworks.ID, "SpoolWire", 1, 64, missing))
                .duration(1 * MINUTES + 4 * SECONDS).eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersMechworks.ID, "LengthWire", 64, 0, missing),
                        getModItem(TinkersMechworks.ID, "SpoolWire", 1, 64, missing))
                .itemOutputs(getModItem(TinkersMechworks.ID, "SpoolWire", 1, 0, missing))
                .duration(1 * MINUTES + 4 * SECONDS).eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 1L),
                        getModItem(TinkersMechworks.ID, "LengthWire", 64, 0, missing),
                        getModItem(TinkersMechworks.ID, "LengthWire", 64, 0, missing),
                        getModItem(TinkersMechworks.ID, "LengthWire", 64, 0, missing),
                        getModItem(TinkersMechworks.ID, "LengthWire", 64, 0, missing),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(TinkersMechworks.ID, "SpoolWire", 1, 0, missing))
                .duration(2 * MINUTES + 8 * SECONDS).eut(64).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersMechworks.ID, "LengthWire", 3, 0, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(TinkersMechworks.ID, "SignalBus", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 432)).duration(10 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersMechworks.ID, "SignalBus", 2, 0, missing),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(TinkersMechworks.ID, "SignalTerminal", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 288)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "materials", 1, 14, missing))
                .itemOutputs(getModItem(TinkersMechworks.ID, "LengthWire", 2, 0, missing))
                .duration(2 * SECONDS + 10 * TICKS).eut(16).addTo(wiremillRecipes);

    }
}
