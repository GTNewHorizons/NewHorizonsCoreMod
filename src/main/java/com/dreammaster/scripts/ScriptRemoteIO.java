package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.createItemStack;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.EnderStorage;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.ProjectRedIntegration;
import static gregtech.api.enums.Mods.RandomThings;
import static gregtech.api.enums.Mods.RemoteIO;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.WirelessRedstoneCBELogic;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

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

public class ScriptRemoteIO implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Remote IO";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                AppliedEnergistics2.ID,
                EnderStorage.ID,
                ExtraUtilities.ID,
                IndustrialCraft2.ID,
                ProjectRedIntegration.ID,
                RandomThings.ID,
                RemoteIO.ID,
                Thaumcraft.ID,
                TinkerConstruct.ID,
                WirelessRedstoneCBELogic.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(RemoteIO.ID, "tile.remote_interface", 2, 0),
                ItemList.Automation_Regulator_IV.get(1L),
                ItemList.Sensor_EV.get(1L),
                ItemList.Automation_Regulator_IV.get(1L),
                "circuitElite",
                GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.BlackSteel, 1L),
                "circuitElite",
                ItemList.Automation_Regulator_IV.get(1L),
                ItemList.Emitter_EV.get(1L),
                ItemList.Automation_Regulator_IV.get(1L));
        addShapelessRecipe(
                getModItem(RemoteIO.ID, "tile.remote_interface", 1, 0),
                getModItem(RandomThings.ID, "playerinterface", 1, 0));
        addShapedRecipe(
                getModItem(RemoteIO.ID, "tile.machine", 1, 0),
                ItemList.Electric_Pump_EV.get(1L),
                "pipeMediumTitanium",
                ItemList.Electric_Pump_EV.get(1L),
                "pipeMediumTitanium",
                ItemList.Casing_HV.get(1L),
                "pipeMediumTitanium",
                ItemList.Electric_Pump_EV.get(1L),
                "pipeMediumTitanium",
                ItemList.Electric_Pump_EV.get(1L));
        addShapedRecipe(
                getModItem(RemoteIO.ID, "tile.machine", 1, 1),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0),
                ItemList.Electric_Pump_EV.get(1L),
                ItemList.Casing_HV.get(1L),
                ItemList.Electric_Pump_EV.get(1L),
                "plateTitanium",
                "plateTitanium",
                "plateTitanium");
        addShapedRecipe(
                getModItem(RemoteIO.ID, "skylight", 1, 0),
                "plateObsidian",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                "plateObsidian",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 21),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                "plateObsidian",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                "plateObsidian");
        addShapedRecipe(
                getModItem(RemoteIO.ID, "intelligentWorkbench", 1, 0),
                null,
                getModItem(RemoteIO.ID, "item.chip.location", 1, 0),
                null,
                "screwTitanium",
                ItemList.Casing_RobustTungstenSteel.get(1L),
                "screwTitanium",
                null,
                "craftingToolScrewdriver",
                null);
        addShapelessRecipe(
                getModItem(RemoteIO.ID, "item.chip.location", 1, 0),
                getModItem(RemoteIO.ID, "item.chip.location", 1, 0));
        addShapedRecipe(
                getModItem(RemoteIO.ID, "item.io_tool", 1, 0),
                "plateTungstenSteel",
                "craftingToolSaw",
                "plateTungstenSteel",
                "screwTungstenSteel",
                "stickTungstenSteel",
                "screwTungstenSteel",
                "craftingToolScrewdriver",
                "stickTungstenSteel",
                "craftingToolFile");
        addShapedRecipe(
                getModItem(RemoteIO.ID, "item.linker", 1, 0),
                "craftingToolScrewdriver",
                "boltElectrum",
                "screwIron",
                "boltElectrum",
                "lensEnderEye",
                "ringSteel",
                "screwIron",
                "ringSteel",
                getModItem(RemoteIO.ID, "item.io_tool", 1, 0));
        addShapedRecipe(
                getModItem(RemoteIO.ID, "item.remoteAccessor", 1, 0),
                "itemCasingTungstenSteel",
                getModItem(RemoteIO.ID, "tile.remote_interface", 1, 0),
                "itemCasingTungstenSteel",
                getModItem(RemoteIO.ID, "item.linker", 1, 0),
                getModItem(RemoteIO.ID, "item.chip.location", 1, 0),
                getModItem(RemoteIO.ID, "item.linker", 1, 0),
                "screwTungstenSteel",
                getModItem(RemoteIO.ID, "item.wireless_transmitter", 1, 0),
                "screwTungstenSteel");
        addShapedRecipe(
                getModItem(RemoteIO.ID, "item.pda", 1, 0),
                "screwIron",
                "itemCasingAluminium",
                "screwIron",
                "circuitBasic",
                NHItemList.Display.get(),
                "circuitBasic",
                "itemCasingAluminium",
                createItemStack(GregTech.ID, "gt.metaitem.01", 1, 32518, "{GT.ItemCharge:100000L}"),
                "itemCasingAluminium");

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(WirelessRedstoneCBELogic.ID, "wirelessLogic", 1, 0),
                        getModItem(WirelessRedstoneCBELogic.ID, "wirelessLogic", 1, 1))
                .itemOutputs(getModItem(RemoteIO.ID, "item.wireless_transmitter", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1000)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "blankPattern", 1, 1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1L))
                .itemOutputs(getModItem(RemoteIO.ID, "item.blank_plate", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 2),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 2))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(NHItemList.BlankPlatedChip.get(1), getModItem(EnderStorage.ID, "enderChest", 1, 0))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.transfer", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.BlankPlatedChip.get(1),
                        getModItem(EnderStorage.ID, "enderChest", 1, 4096))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.transfer", 1, 1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(NHItemList.BlankPlatedChip.get(1), getModItem(Thaumcraft.ID, "blockJar", 2, 0))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.transfer", 1, 2)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.BlankPlatedChip.get(1),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.BlackSteel, 2L))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.transfer", 1, 10)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.BlankPlatedChip.get(1),
                        getModItem(ExtraUtilities.ID, "extractor_base", 2, 12))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.transfer", 1, 12)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.BlankPlatedChip.get(1),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockController", 1, 0))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.transfer", 1, 20)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.BlankPlatedChip.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 2L))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.transfer", 1, 21)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.BlankPlatedChip.get(1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Enderium, 4L))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.upgrade", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.BlankPlatedChip.get(1),
                        getModItem(RemoteIO.ID, "item.wireless_transmitter", 1, 0))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.upgrade", 1, 1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

    }
}
