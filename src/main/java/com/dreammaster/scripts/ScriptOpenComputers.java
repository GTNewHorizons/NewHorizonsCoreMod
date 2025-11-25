package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gtPlusPlus.core.material.MaterialMisc;
import gtPlusPlus.core.material.MaterialsAlloy;

public class ScriptOpenComputers implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Open Computers";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(HardcoreEnderExpansion.ID, IndustrialCraft2.ID, OpenComputers.ID);
    }

    private static ItemStack getTransposer(int aAmount, int rate) {
        ItemStack transposer = GTModHandler.getModItem(OpenComputers.ID, "transposer", aAmount, 0);
        transposer.setTagCompound(new NBTTagCompound());
        transposer.getTagCompound().setInteger("oc:fluidTransferRate", rate);
        return transposer;
    }

    @Override
    public void loadRecipes() {
        // Transposers
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Automation_ChestBuffer_LV.get(1L),
                        GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 61),
                        GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 77),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Polyethylene, 2),
                        GTModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getTransposer(2, 2_560)).fluidInputs(Materials.Polyethylene.getMolten(72L))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getTransposer(1, 2_560), ItemList.FluidRegulator_HV.get(1L))
                .itemOutputs(getTransposer(1, 10_240)).fluidInputs(Materials.SolderingAlloy.getMolten(72L))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getTransposer(1, 2_560), ItemList.FluidRegulator_EV.get(1L))
                .itemOutputs(getTransposer(1, 40_960)).fluidInputs(Materials.SolderingAlloy.getMolten(72L))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getTransposer(1, 2_560), ItemList.FluidRegulator_IV.get(1L))
                .itemOutputs(getTransposer(1, 163_840)).fluidInputs(Materials.SolderingAlloy.getMolten(72L))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getTransposer(1, 2_560), ItemList.FluidRegulator_LuV.get(1L))
                .itemOutputs(getTransposer(1, 655_360)).fluidInputs(MaterialsAlloy.INDALLOY_140.getFluidStack(72))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getTransposer(1, 2_560), ItemList.FluidRegulator_ZPM.get(1L))
                .itemOutputs(getTransposer(1, 2_621_440)).fluidInputs(MaterialsAlloy.INDALLOY_140.getFluidStack(72))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getTransposer(1, 2_560), ItemList.FluidRegulator_UV.get(1L))
                .itemOutputs(getTransposer(1, 10_485_760)).fluidInputs(MaterialsAlloy.INDALLOY_140.getFluidStack(72))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getTransposer(1, 2_560), ItemList.FluidRegulator_UHV.get(1L))
                .itemOutputs(getTransposer(1, 20_971_520)).fluidInputs(MaterialsAlloy.INDALLOY_140.getFluidStack(72))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getTransposer(1, 2_560), ItemList.FluidRegulator_UEV.get(1L))
                .itemOutputs(getTransposer(1, 41_943_040))
                .fluidInputs(MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(72)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getTransposer(1, 2_560), ItemList.FluidRegulator_UIV.get(1L))
                .itemOutputs(getTransposer(1, 83_886_080))
                .fluidInputs(MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(72)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getTransposer(1, 2_560), ItemList.FluidRegulator_UMV.get(1L))
                .itemOutputs(getTransposer(1, 167_772_160))
                .fluidInputs(MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(72)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getTransposer(1, 2_560), ItemList.FluidRegulator_UXV.get(1L))
                .itemOutputs(getTransposer(1, 335_544_320))
                .fluidInputs(MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(72)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        addShapelessRecipe(
                getModItem(OpenComputers.ID, "item", 1, 23, missing),
                ItemList.Circuit_Parts_Transistor.get(1));
        addShapelessRecipe(
                ItemList.Circuit_Parts_Transistor.get(1),
                getModItem(OpenComputers.ID, "item", 1, 23, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(OpenComputers.ID, "item", 1, 69, missing),
                "---------",
                "---------",
                "--aaaaa--",
                "--abcba--",
                "--adeda--",
                "--abcba--",
                "--aaaaa--",
                "---------",
                "---------",
                'a',
                "circuitMaster",
                'b',
                "circuitElite",
                'c',
                "circuitSuperconductor",
                'd',
                getModItem(OpenComputers.ID, "item", 1, 103, missing),
                'e',
                getModItem(OpenComputers.ID, "case3", 1, 0, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(OpenComputers.ID, "item", 1, 103, missing),
                "---------",
                "---------",
                "--aaaaa--",
                "--abcba--",
                "--adefa--",
                "--abcba--",
                "--aaaaa--",
                "---------",
                "---------",
                'a',
                "circuitElite",
                'b',
                "circuitMaster",
                'c',
                "circuitSuperconductor",
                'd',
                getModItem(OpenComputers.ID, "item", 1, 10, missing),
                'e',
                getModItem(OpenComputers.ID, "item", 1, 102, missing),
                'f',
                getModItem(OpenComputers.ID, "item", 1, 43, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(OpenComputers.ID, "item", 1, 90, missing),
                "---------",
                "---------",
                "--abcbd--",
                "--eeeee--",
                "--efgfe--",
                "--eeeee--",
                "--dbcba--",
                "---------",
                "---------",
                'a',
                "wireGt16Electrum",
                'b',
                "circuitMaster",
                'c',
                "circuitSuperconductor",
                'd',
                "circuitElite",
                'e',
                "plateDenseObsidian",
                'f',
                getModItem(IndustrialCraft2.ID, "itemRTGPellet", 1, 0, missing),
                'g',
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 6, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(OpenComputers.ID, "item", 1, 93, missing),
                "---------",
                "---------",
                "--abcba--",
                "--ddedd--",
                "--dfgfd--",
                "--ddddd--",
                "--abcba--",
                "---------",
                "---------",
                'a',
                "circuitMaster",
                'b',
                "circuitElite",
                'c',
                "circuitSuperconductor",
                'd',
                "plateDenseChrome",
                'e',
                getModItem(OpenComputers.ID, "screen3", 1, 0, missing),
                'f',
                getModItem(IndustrialCraft2.ID, "itemRTGPellet", 1, 0, missing),
                'g',
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 6, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(OpenComputers.ID, "item", 1, 91, missing),
                "---------",
                "---------",
                "--ababa--",
                "--cdedc--",
                "--fdgdf--",
                "--cdedc--",
                "--ababa--",
                "---------",
                "---------",
                'a',
                "circuitMaster",
                'b',
                ItemList.Electric_Motor_LuV.get(1L),
                'c',
                "circuitElite",
                'd',
                "turbineBladeChrome",
                'e',
                "circuitSuperconductor",
                'f',
                getModItem(HardcoreEnderExpansion.ID, "biome_compass", 1, 0, missing),
                'g',
                getModItem(OpenComputers.ID, "item", 1, 90, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(OpenComputers.ID, "item", 1, 114, missing),
                "aaaaaaaaa",
                "abacdcaba",
                "aaaaaaaaa",
                "abaefeaba",
                "aaaagaaaa",
                "abaefeaba",
                "aaaaaaaaa",
                "abacdcaba",
                "aaaaaaaaa",
                'a',
                getModItem(OpenComputers.ID, "item", 1, 72, missing),
                'b',
                getModItem(OpenComputers.ID, "item", 1, 39, missing),
                'c',
                getModItem(OpenComputers.ID, "item", 1, 26, missing),
                'd',
                getModItem(OpenComputers.ID, "item", 1, 106, missing),
                'e',
                ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                'f',
                "circuitSuperconductor",
                'g',
                getModItem(OpenComputers.ID, "item", 1, 7, missing));

    }
}
