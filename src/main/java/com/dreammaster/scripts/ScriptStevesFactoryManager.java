package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Computronics;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.ProjectRedTransmission;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.StevesAddons;
import static gregtech.api.enums.Mods.StevesFactoryManager;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.item.NHItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;

public class ScriptStevesFactoryManager implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Steves Factory Manager";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                AppliedEnergistics2.ID,
                Computronics.ID,
                EnderIO.ID,
                ExtraUtilities.ID,
                IndustrialCraft2.ID,
                OpenBlocks.ID,
                ProjectRedTransmission.ID,
                Railcraft.ID,
                StevesFactoryManager.ID,
                StevesAddons.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(StevesFactoryManager.ID, "BlockMachineManagerName", 1, 0),
                "plateStainlessSteel",
                NHItemList.Display.get(),
                "plateStainlessSteel",
                "plateRedAlloy",
                ItemList.Casing_Processor.get(1L),
                "plateRedAlloy",
                "plateStainlessSteel",
                ItemList.Electric_Motor_HV.get(1L),
                "plateStainlessSteel");
        addShapedRecipe(
                getModItem(StevesFactoryManager.ID, "BlockCableName", 2, 0),
                "plateStainlessSteel",
                getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 17),
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                "plateStainlessSteel",
                getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 17),
                "plateStainlessSteel");

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                        getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 17))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.stainlesssteel", 144))
                .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0), ItemList.Sensor_HV.get(1L))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableInputName", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0), ItemList.Emitter_HV.get(1L))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableOutputName", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0),
                        getModItem(Railcraft.ID, "detector", 1, 9))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableRelayName", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0),
                        getModItem(Computronics.ID, "computronics.detector", 1, 0))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableRelayName", 1, 8))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0),
                        getModItem(OpenBlocks.ID, "vacuumhopper", 1, 0))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableIntakeName", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableIntakeName", 1, 0),
                        ItemList.Electric_Pump_HV.get(1L))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableIntakeName", 1, 8))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0),
                        getModItem(ExtraUtilities.ID, "budoff", 1, 3))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableBUDName", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0), ItemList.Robot_Arm_HV.get(1L))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableBreakerName", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableBreakerName", 1, 0),
                        getModItem(OpenBlocks.ID, "generic", 1, 11))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableSignName", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesFactoryManager.ID, "BlockCableName", 8, 0)).circuit(1)
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableClusterName", 1, 8)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 1))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableClusterName", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0), ItemList.Cover_Screen.get(2L))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableCamouflageName", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableCamouflageName", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 2))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableCamouflageName", 1, 1))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableCamouflageName", 1, 1),
                        ItemList.Field_Generator_LV.get(1L))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableCamouflageName", 1, 2))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 864)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0),
                        getModItem(EnderIO.ID, "itemPowerConduit", 1, 0))
                .itemOutputs(getModItem(StevesAddons.ID, "cable_rf", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(ItemList.Tool_Scanner.get(1L), ItemList.Tool_DataStick.get(1L))
                .itemOutputs(getModItem(StevesAddons.ID, "duplicator", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(NHItemList.Display.get(), GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 2))
                .itemOutputs(getModItem(StevesAddons.ID, "labeler", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

    }
}
