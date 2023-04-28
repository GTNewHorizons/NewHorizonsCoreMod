package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.*;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptBloodArsenal implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Blood Arsenal";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.BloodArsenal.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("BloodArsenal", "blood_lamp", 1, 0, missing),
                new Object[] { "plateBloodInfusedIron",
                        getModItem("BloodArsenal", "blood_stained_glass", 1, 0, missing), "plateBloodInfusedIron",
                        getModItem("BloodArsenal", "blood_stained_glass", 1, 0, missing),
                        getModItem("minecraft", "redstone_lamp", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_stained_glass", 1, 0, missing), "plateBloodInfusedIron",
                        getModItem("BloodArsenal", "blood_stained_glass", 1, 0, missing), "plateBloodInfusedIron" });

        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "blood_money", 1, 1, missing))
                .itemOutputs(
                        getModItem("BloodArsenal", "blood_money", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_money", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_money", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_money", 1, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).noFluidInputs().noFluidOutputs().duration(400).eut(30)
                .addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "blood_money", 1, 2, missing))
                .itemOutputs(
                        getModItem("BloodArsenal", "blood_money", 1, 1, missing),
                        getModItem("BloodArsenal", "blood_money", 1, 1, missing),
                        getModItem("BloodArsenal", "blood_money", 1, 1, missing),
                        getModItem("BloodArsenal", "blood_money", 1, 1, missing))
                .outputChances(10000, 10000, 10000, 10000).noFluidInputs().noFluidOutputs().duration(400).eut(30)
                .addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "blood_money", 1, 3, missing))
                .itemOutputs(
                        getModItem("BloodArsenal", "blood_money", 1, 2, missing),
                        getModItem("BloodArsenal", "blood_money", 1, 2, missing),
                        getModItem("BloodArsenal", "blood_money", 1, 2, missing),
                        getModItem("BloodArsenal", "blood_money", 1, 2, missing))
                .outputChances(10000, 10000, 10000, 10000).noFluidInputs().noFluidOutputs().duration(400).eut(30)
                .addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing))
                .itemOutputs(getModItem("BloodArsenal", "blood_infused_planks", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 10)).noFluidOutputs().duration(200).eut(120)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing))
                .itemOutputs(getModItem("BloodArsenal", "blood_infused_planks", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 6)).noFluidOutputs().duration(200)
                .eut(120).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing))
                .itemOutputs(getModItem("BloodArsenal", "blood_infused_planks", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).noFluidOutputs().duration(100).eut(120)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "blood_infused_planks", 1, 0, missing))
                .itemOutputs(getModItem("BloodArsenal", "blood_infused_stick", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(8).addTo(sLatheRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "blood_infused_iron", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 2977, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "blood_infused_iron_block", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 9, 2977, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);

    }
}
