package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptStevesFactoryManager implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Steves Factory Manager";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList("StevesFactoryManager", Mods.AppliedEnergistics2.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("StevesFactoryManager", "BlockMachineManagerName", 1, 0, missing),
                new Object[] { "plateStainlessSteel", getModItem("dreamcraft", "item.Display", 1, 0, missing),
                        "plateStainlessSteel", "plateRedAlloy",
                        getModItem("gregtech", "gt.blockcasings2", 1, 6, missing), "plateRedAlloy",
                        "plateStainlessSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing),
                        "plateStainlessSteel" });
        addShapedRecipe(
                getModItem("StevesFactoryManager", "BlockCableName", 2, 0, missing),
                new Object[] { "plateStainlessSteel",
                        getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                        "plateStainlessSteel", getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing), "plateStainlessSteel",
                        getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                        "plateStainlessSteel" });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing),
                        getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing))
                .itemOutputs(getModItem("StevesFactoryManager", "BlockCableName", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.stainlesssteel", 144)).noFluidOutputs().duration(150)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("StevesFactoryManager", "BlockCableName", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing))
                .itemOutputs(getModItem("StevesFactoryManager", "BlockCableInputName", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("StevesFactoryManager", "BlockCableName", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32682, missing))
                .itemOutputs(getModItem("StevesFactoryManager", "BlockCableOutputName", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("StevesFactoryManager", "BlockCableName", 1, 0, missing),
                        getModItem("Railcraft", "detector", 1, 9, missing))
                .itemOutputs(getModItem("StevesFactoryManager", "BlockCableRelayName", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("StevesFactoryManager", "BlockCableName", 1, 0, missing),
                        getModItem("computronics", "computronics.detector", 1, 0, missing))
                .itemOutputs(getModItem("StevesFactoryManager", "BlockCableRelayName", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).noFluidOutputs().duration(300)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("StevesFactoryManager", "BlockCableName", 1, 0, missing),
                        getModItem("OpenBlocks", "vacuumhopper", 1, 0, missing))
                .itemOutputs(getModItem("StevesFactoryManager", "BlockCableIntakeName", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("StevesFactoryManager", "BlockCableIntakeName", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32612, missing))
                .itemOutputs(getModItem("StevesFactoryManager", "BlockCableIntakeName", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).noFluidOutputs().duration(300)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("StevesFactoryManager", "BlockCableName", 1, 0, missing),
                        getModItem("ExtraUtilities", "budoff", 1, 3, missing))
                .itemOutputs(getModItem("StevesFactoryManager", "BlockCableBUDName", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("StevesFactoryManager", "BlockCableName", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing))
                .itemOutputs(getModItem("StevesFactoryManager", "BlockCableBreakerName", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("StevesFactoryManager", "BlockCableBreakerName", 1, 0, missing),
                        getModItem("OpenBlocks", "generic", 1, 11, missing))
                .itemOutputs(getModItem("StevesFactoryManager", "BlockCableSignName", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).noFluidOutputs().duration(300)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("StevesFactoryManager", "BlockCableName", 8, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("StevesFactoryManager", "BlockCableClusterName", 1, 8, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("StevesFactoryManager", "BlockCableName", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32705, missing))
                .itemOutputs(getModItem("StevesFactoryManager", "BlockCableClusterName", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("StevesFactoryManager", "BlockCableName", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32740, missing))
                .itemOutputs(getModItem("StevesFactoryManager", "BlockCableCamouflageName", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("StevesFactoryManager", "BlockCableCamouflageName", 1, 0, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 2, 0, missing))
                .itemOutputs(getModItem("StevesFactoryManager", "BlockCableCamouflageName", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).noFluidOutputs().duration(300)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("StevesFactoryManager", "BlockCableCamouflageName", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32670, missing))
                .itemOutputs(getModItem("StevesFactoryManager", "BlockCableCamouflageName", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 864)).noFluidOutputs().duration(400)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("StevesFactoryManager", "BlockCableName", 1, 0, missing),
                        getModItem("EnderIO", "itemPowerConduit", 1, 0, missing))
                .itemOutputs(getModItem("StevesAddons", "cable_rf", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32762, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32708, missing))
                .itemOutputs(getModItem("StevesAddons", "duplicator", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(150)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.Display", 1, 0, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 2, 0, missing))
                .itemOutputs(getModItem("StevesAddons", "labeler", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(150)
                .eut(480).addTo(sAssemblerRecipes);

    }
}
