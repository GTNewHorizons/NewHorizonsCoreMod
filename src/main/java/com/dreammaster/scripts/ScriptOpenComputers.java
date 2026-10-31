package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.VoltageIndex;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gtPlusPlus.core.material.MaterialMisc;
import gtPlusPlus.core.material.MaterialsAlloy;

public class ScriptOpenComputers implements IScriptLoader {

    private static final long[] TRANSPOSER_RATES = { 0L, 0L, 2_560L, 10_240L, 40_960L, 163_840L, 655_360L, 2_621_440L,
            10_485_760L, 41_943_040L, 167_772_160L, 671_088_640L, 2_684_354_560L, 10_737_418_240L };

    @Override
    public String getScriptName() {
        return "Open Computers";
    }

    @Override
    public List<Mods> getDependencies() {
        return Arrays.asList(HardcoreEnderExpansion, IndustrialCraft2, OpenComputers);
    }

    public static ItemStack getTransposer(ItemStack baseTransposer, int aAmount, int aTier) {
        ItemStack transposer = GTUtility.copyAmount(aAmount, baseTransposer);
        transposer.setTagCompound(new NBTTagCompound());
        transposer.getTagCompound().setLong("oc:fluidTransferRate", TRANSPOSER_RATES[aTier]);
        transposer.getTagCompound().setString("oc:tier", GTValues.VN[aTier]);
        return transposer;
    }

    @Override
    public void loadRecipes() {
        // Transposers
        ItemStack baseTransposer = getTransposer(getModItem(OpenComputers.ID, "transposer", 1, 0), 1, VoltageIndex.MV);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Automation_ChestBuffer_LV.get(1L),
                        getModItem(OpenComputers.ID, "item", 1, 61),
                        getModItem(OpenComputers.ID, "item", 1, 77),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Polyethylene, 2),
                        getModItem(OpenComputers.ID, "cable", 2, 0))
                .circuit(1).itemOutputs(GTUtility.copyAmount(2, baseTransposer))
                .fluidInputs(Materials.Polyethylene.getMolten(72L)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(baseTransposer, ItemList.FluidRegulator_HV.get(1L))
                .itemOutputs(getTransposer(baseTransposer, 1, VoltageIndex.HV)).nbtSensitive()
                .fluidInputs(Materials.SolderingAlloy.getMolten(72L)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(baseTransposer, ItemList.FluidRegulator_EV.get(1L))
                .itemOutputs(getTransposer(baseTransposer, 1, VoltageIndex.EV)).nbtSensitive()
                .fluidInputs(Materials.SolderingAlloy.getMolten(72L)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(baseTransposer, ItemList.FluidRegulator_IV.get(1L))
                .itemOutputs(getTransposer(baseTransposer, 1, VoltageIndex.IV)).nbtSensitive()
                .fluidInputs(Materials.SolderingAlloy.getMolten(72L)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(baseTransposer, ItemList.FluidRegulator_LuV.get(1L))
                .itemOutputs(getTransposer(baseTransposer, 1, VoltageIndex.LuV)).nbtSensitive()
                .fluidInputs(MaterialsAlloy.INDALLOY_140.getFluidStack(72)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(baseTransposer, ItemList.FluidRegulator_ZPM.get(1L))
                .itemOutputs(getTransposer(baseTransposer, 1, VoltageIndex.ZPM)).nbtSensitive()
                .fluidInputs(MaterialsAlloy.INDALLOY_140.getFluidStack(72)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(baseTransposer, ItemList.FluidRegulator_UV.get(1L))
                .itemOutputs(getTransposer(baseTransposer, 1, VoltageIndex.UV)).nbtSensitive()
                .fluidInputs(MaterialsAlloy.INDALLOY_140.getFluidStack(72)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(baseTransposer, ItemList.FluidRegulator_UHV.get(1L))
                .itemOutputs(getTransposer(baseTransposer, 1, VoltageIndex.UHV)).nbtSensitive()
                .fluidInputs(MaterialsAlloy.INDALLOY_140.getFluidStack(72)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(baseTransposer, ItemList.FluidRegulator_UEV.get(1L))
                .itemOutputs(getTransposer(baseTransposer, 1, VoltageIndex.UEV)).nbtSensitive()
                .fluidInputs(MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(72)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(baseTransposer, ItemList.FluidRegulator_UIV.get(1L))
                .itemOutputs(getTransposer(baseTransposer, 1, VoltageIndex.UIV)).nbtSensitive()
                .fluidInputs(MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(72)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(baseTransposer, ItemList.FluidRegulator_UMV.get(1L))
                .itemOutputs(getTransposer(baseTransposer, 1, VoltageIndex.UMV)).nbtSensitive()
                .fluidInputs(MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(72)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(baseTransposer, ItemList.FluidRegulator_UXV.get(1L))
                .itemOutputs(getTransposer(baseTransposer, 1, VoltageIndex.UXV)).nbtSensitive()
                .fluidInputs(Materials.BoundlessCosmicSolder.getFluid(72)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        addShapelessRecipe(getModItem(OpenComputers.ID, "item", 1, 23), ItemList.Circuit_Parts_Transistor.get(1));
        addShapelessRecipe(ItemList.Circuit_Parts_Transistor.get(1), getModItem(OpenComputers.ID, "item", 1, 23));
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
                "turbineBladeRhodium-PlatedPalladium",
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
