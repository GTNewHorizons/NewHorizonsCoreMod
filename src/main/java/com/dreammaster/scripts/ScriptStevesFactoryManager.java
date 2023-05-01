package com.dreammaster.scripts;

import static com.dreammaster.scripts.TemporaryMods.ProjectRedTransmission;
import static com.dreammaster.scripts.TemporaryMods.StevesAddons;
import static com.dreammaster.scripts.TemporaryMods.StevesFactoryManager;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Computronics;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;

public class ScriptStevesFactoryManager implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Steves Factory Manager";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                StevesFactoryManager.ID,
                StevesAddons.ID,
                AppliedEnergistics2.ID,
                ProjectRedTransmission.ID,
                Computronics.ID,
                EnderIO.ID,
                ExtraUtilities.ID,
                IndustrialCraft2.ID,
                OpenBlocks.ID,
                Railcraft.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(StevesFactoryManager.ID, "BlockMachineManagerName", 1, 0, missing),
                new Object[] { "plateStainlessSteel", getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        "plateStainlessSteel", "plateRedAlloy",
                        getModItem(GregTech.ID, "gt.blockcasings2", 1, 6, missing), "plateRedAlloy",
                        "plateStainlessSteel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing),
                        "plateStainlessSteel" });
        addShapedRecipe(
                getModItem(StevesFactoryManager.ID, "BlockCableName", 2, 0, missing),
                new Object[] { "plateStainlessSteel",
                        getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 17, missing),
                        "plateStainlessSteel", getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing), "plateStainlessSteel",
                        getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 17, missing),
                        "plateStainlessSteel" });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                        getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 17, missing))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.stainlesssteel", 144)).noFluidOutputs().duration(150)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableInputName", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32682, missing))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableOutputName", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0, missing),
                        getModItem(Railcraft.ID, "detector", 1, 9, missing))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableRelayName", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0, missing),
                        getModItem(Computronics.ID, "computronics.detector", 1, 0, missing))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableRelayName", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).noFluidOutputs().duration(300)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0, missing),
                        getModItem(OpenBlocks.ID, "vacuumhopper", 1, 0, missing))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableIntakeName", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableIntakeName", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32612, missing))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableIntakeName", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).noFluidOutputs().duration(300)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "budoff", 1, 3, missing))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableBUDName", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableBreakerName", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableBreakerName", 1, 0, missing),
                        getModItem(OpenBlocks.ID, "generic", 1, 11, missing))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableSignName", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).noFluidOutputs().duration(300)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableName", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableClusterName", 1, 8, missing))
                .noFluidInputs().noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32705, missing))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableClusterName", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32740, missing))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableCamouflageName", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableCamouflageName", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 2, 0, missing))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableCamouflageName", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).noFluidOutputs().duration(300)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableCamouflageName", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32670, missing))
                .itemOutputs(getModItem(StevesFactoryManager.ID, "BlockCableCamouflageName", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 864)).noFluidOutputs().duration(400)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesFactoryManager.ID, "BlockCableName", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemPowerConduit", 1, 0, missing))
                .itemOutputs(getModItem(StevesAddons.ID, "cable_rf", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32762, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32708, missing))
                .itemOutputs(getModItem(StevesAddons.ID, "duplicator", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(150)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 2, 0, missing))
                .itemOutputs(getModItem(StevesAddons.ID, "labeler", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(150)
                .eut(480).addTo(sAssemblerRecipes);

    }
}
