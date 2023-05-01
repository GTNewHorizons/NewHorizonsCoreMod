package com.dreammaster.scripts;

import static com.dreammaster.scripts.TemporaryMods.TinkersMechworks;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sWiremillRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;

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
                new Object[] { "plateBrass", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing), "plateBrass",
                        "gearSteel", getModItem(Minecraft.ID, "dispenser", 1, 0, missing), "gearSteel", "plateBrass",
                        "craftingPiston", "plateBrass" });
        addShapedRecipe(
                getModItem(TinkersMechworks.ID, "RedstoneMachine", 1, 1, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "heavyPlate", 1, 7, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 7, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 7, missing), "plateBrass",
                        getModItem(Minecraft.ID, "flint_and_steel", 1, 0, missing), "plateBrass", "plateBrass",
                        "plateBrass", "plateBrass" });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersMechworks.ID, "RedstoneMachine", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 9241, missing))
                .itemOutputs(getModItem(TinkersMechworks.ID, "RedstoneMachine", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersMechworks.ID, "RedstoneMachine", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 17033, missing))
                .itemOutputs(getModItem(TinkersMechworks.ID, "RedstoneMachine", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1152)).noFluidOutputs().duration(1200)
                .eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23305, missing),
                        getModItem(TinkersMechworks.ID, "LengthWire", 1, 0, missing))
                .itemOutputs(getModItem(TinkersMechworks.ID, "SpoolWire", 1, 256, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersMechworks.ID, "LengthWire", 64, 0, missing),
                        getModItem(TinkersMechworks.ID, "SpoolWire", 1, 256, missing))
                .itemOutputs(getModItem(TinkersMechworks.ID, "SpoolWire", 1, 192, missing)).noFluidInputs()
                .noFluidOutputs().duration(1280).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersMechworks.ID, "LengthWire", 64, 0, missing),
                        getModItem(TinkersMechworks.ID, "SpoolWire", 1, 192, missing))
                .itemOutputs(getModItem(TinkersMechworks.ID, "SpoolWire", 1, 128, missing)).noFluidInputs()
                .noFluidOutputs().duration(1280).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersMechworks.ID, "LengthWire", 64, 0, missing),
                        getModItem(TinkersMechworks.ID, "SpoolWire", 1, 128, missing))
                .itemOutputs(getModItem(TinkersMechworks.ID, "SpoolWire", 1, 64, missing)).noFluidInputs()
                .noFluidOutputs().duration(1280).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersMechworks.ID, "LengthWire", 64, 0, missing),
                        getModItem(TinkersMechworks.ID, "SpoolWire", 1, 64, missing))
                .itemOutputs(getModItem(TinkersMechworks.ID, "SpoolWire", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1280).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersMechworks.ID, "LengthWire", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(TinkersMechworks.ID, "SignalBus", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 432)).noFluidOutputs().duration(200).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersMechworks.ID, "SignalBus", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem(TinkersMechworks.ID, "SignalTerminal", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 288)).noFluidOutputs().duration(300).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "materials", 1, 14, missing))
                .itemOutputs(getModItem(TinkersMechworks.ID, "LengthWire", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(16).addTo(sWiremillRecipes);

    }
}
