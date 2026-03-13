package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
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
        ItemStack transposer = getModItem(OpenComputers.ID, "transposer", aAmount, 0);
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
                        getModItem(OpenComputers.ID, "item", 1, 61),
                        getModItem(OpenComputers.ID, "item", 1, 77),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Polyethylene, 2),
                        getModItem(OpenComputers.ID, "cable", 2, 0))
                .circuit(1).itemOutputs(getTransposer(2, 2_560)).fluidInputs(Materials.Polyethylene.getMolten(72L))
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
                getModItem(OpenComputers.ID, "item", 1, 23),
                ItemList.Circuit_Parts_Transistor.get(1));
        addShapelessRecipe(
                ItemList.Circuit_Parts_Transistor.get(1),
                getModItem(OpenComputers.ID, "item", 1, 23));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(OpenComputers.ID, "item", 1, 69),
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
                getModItem(OpenComputers.ID, "item", 1, 103),
                'e',
                getModItem(OpenComputers.ID, "case3", 1, 0));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(OpenComputers.ID, "item", 1, 103),
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
                getModItem(OpenComputers.ID, "item", 1, 10),
                'e',
                getModItem(OpenComputers.ID, "item", 1, 102),
                'f',
                getModItem(OpenComputers.ID, "item", 1, 43));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(OpenComputers.ID, "item", 1, 90),
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
                getModItem(IndustrialCraft2.ID, "itemRTGPellet", 1, 0),
                'g',
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 6));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(OpenComputers.ID, "item", 1, 93),
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
                getModItem(OpenComputers.ID, "screen3", 1, 0),
                'f',
                getModItem(IndustrialCraft2.ID, "itemRTGPellet", 1, 0),
                'g',
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 6));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(OpenComputers.ID, "item", 1, 91),
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
                getModItem(HardcoreEnderExpansion.ID, "biome_compass", 1, 0),
                'g',
                getModItem(OpenComputers.ID, "item", 1, 90));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(OpenComputers.ID, "item", 1, 114),
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
                getModItem(OpenComputers.ID, "item", 1, 72),
                'b',
                getModItem(OpenComputers.ID, "item", 1, 39),
                'c',
                getModItem(OpenComputers.ID, "item", 1, 26),
                'd',
                getModItem(OpenComputers.ID, "item", 1, 106),
                'e',
                ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                'f',
                "circuitSuperconductor",
                'g',
                getModItem(OpenComputers.ID, "item", 1, 7));

    }
}
