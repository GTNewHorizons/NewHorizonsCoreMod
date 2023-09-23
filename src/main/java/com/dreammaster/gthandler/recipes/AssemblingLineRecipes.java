package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.AE2FluidCraft;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.TecTech;
import static gregtech.api.util.GT_RecipeBuilder.HOURS;
import static gregtech.api.util.GT_RecipeBuilder.INGOTS;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.WILDCARD;
import static gregtech.api.util.GT_RecipeConstants.AssemblyLine;
import static gregtech.api.util.GT_RecipeConstants.RESEARCH_ITEM;
import static gregtech.api.util.GT_RecipeConstants.RESEARCH_TIME;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;
import com.github.technus.tectech.recipe.TT_recipeAdder;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class AssemblingLineRecipes implements Runnable {

    @Override
    public void run() {
        Fluid solderIndalloy = FluidRegistry.getFluid("molten.indalloy140") != null
                ? FluidRegistry.getFluid("molten.indalloy140")
                : FluidRegistry.getFluid("molten.solderingalloy");

        // Heavy duty alloy ingot T5
        GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, CustomItemList.HeavyDutyPlateTier4.get(1L))
                .metadata(RESEARCH_TIME, 4 * MINUTES + 10 * SECONDS)
                .itemInputs(
                        CustomItemList.HeavyDutyPlateTier4.get(1L),
                        CustomItemList.QuantinumCompressedPlate.get(4L),
                        CustomItemList.QuantinumCompressedPlate.get(4L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Europium, 8))
                .fluidInputs(new FluidStack(solderIndalloy, 72))
                .itemOutputs(CustomItemList.HeavyDutyAlloyIngotT5.get(1L)).eut(TierEU.RECIPE_ZPM).duration(15 * SECONDS)
                .addTo(AssemblyLine);

        // Heavy duty alloy ingot T6
        GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, CustomItemList.HeavyDutyPlateTier5.get(1L))
                .metadata(RESEARCH_TIME, 375 * SECONDS)
                .itemInputs(
                        CustomItemList.HeavyDutyPlateTier5.get(1L),
                        CustomItemList.LeadOriharukonPlate.get(5L),
                        CustomItemList.LeadOriharukonPlate.get(5L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tritanium, 8))
                .fluidInputs(new FluidStack(solderIndalloy, 144))
                .itemOutputs(CustomItemList.HeavyDutyAlloyIngotT6.get(1L)).eut(TierEU.RECIPE_UV).duration(15 * SECONDS)
                .addTo(AssemblyLine);

        // Heavy duty alloy ingot T7
        GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, CustomItemList.HeavyDutyPlateTier6.get(1L))
                .metadata(RESEARCH_TIME, 500 * SECONDS)
                .itemInputs(
                        CustomItemList.HeavyDutyPlateTier6.get(1L),
                        CustomItemList.MysteriousCrystalCompressedPlate.get(6L),
                        CustomItemList.MysteriousCrystalCompressedPlate.get(6L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Neutronium, 10))
                .fluidInputs(new FluidStack(solderIndalloy, 288))
                .itemOutputs(CustomItemList.HeavyDutyAlloyIngotT7.get(1L)).eut(TierEU.RECIPE_UHV).duration(15 * SECONDS)
                .addTo(AssemblyLine);

        // Heavy duty alloy ingot T8
        GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, CustomItemList.HeavyDutyPlateTier7.get(1L))
                .metadata(RESEARCH_TIME, 625 * SECONDS)
                .itemInputs(
                        CustomItemList.HeavyDutyPlateTier7.get(1L),
                        CustomItemList.BlackPlutoniumCompressedPlate.get(7L),
                        CustomItemList.BlackPlutoniumCompressedPlate.get(7L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.BlackPlutonium, 12))
                .fluidInputs(new FluidStack(solderIndalloy, 576))
                .itemOutputs(CustomItemList.HeavyDutyAlloyIngotT8.get(1L)).eut(TierEU.RECIPE_UEV).duration(15 * SECONDS)
                .addTo(AssemblyLine);

        // Mainframe Circuits and Neuro CPU
        GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Circuit_Chip_Stemcell.get(1L))
                .metadata(RESEARCH_TIME, 1 * HOURS)
                .itemInputs(
                        ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                        ItemList.Circuit_Chip_Stemcell.get(16L),
                        ItemList.Circuit_Parts_Reinforced_Glass_Tube.get(16L),
                        GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Polybenzimidazole, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.NaquadahEnriched, 4L),
                        new Object[] { OrePrefixes.foil.get(Materials.AnySyntheticRubber), 64L },
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 32L))
                .fluidInputs(
                        Materials.GrowthMediumSterilized.getFluid(250L),
                        Materials.UUMatter.getFluid(250L),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000))
                .itemOutputs(ItemList.Circuit_Chip_NeuroCPU.get(1L)).eut(TierEU.RECIPE_ZPM).duration(30 * SECONDS)
                .addTo(AssemblyLine);

        GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Circuit_Chip_NeuroCPU.get(1L))
                .metadata(RESEARCH_TIME, 2 * HOURS)
                .itemInputs(
                        ItemList.Circuit_Board_Bio_Ultra.get(1L),
                        ItemList.Circuit_Chip_Biocell.get(16L),
                        ItemList.Circuit_Parts_Reinforced_Glass_Tube.get(16L),
                        GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Polybenzimidazole, 16),
                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.ElectrumFlux, 16L),
                        new Object[] { OrePrefixes.foil.get(Materials.AnySyntheticRubber), 64L },
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSS, 32L))
                .fluidInputs(
                        Materials.BioMediumSterilized.getFluid(500L),
                        Materials.UUMatter.getFluid(500L),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000))
                .itemOutputs(ItemList.Circuit_Chip_BioCPU.get(1L)).eut(TierEU.RECIPE_UHV / 2).duration(30 * SECONDS)
                .addTo(AssemblyLine);

        GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Energy_LapotronicOrb.get(1L))
                .metadata(RESEARCH_TIME, 4 * HOURS)
                .itemInputs(
                        ItemList.Circuit_Board_Multifiberglass.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NaquadahAlloy, 64L),
                        new Object[] { OrePrefixes.circuit.get(Materials.Master), 4L },
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(36L),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(36L),
                        ItemList.Circuit_Chip_HPIC.get(64L),
                        ItemList.Circuit_Parts_DiodeASMD.get(8L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                        ItemList.Circuit_Parts_ResistorASMD.get(8L),
                        ItemList.Circuit_Parts_TransistorASMD.get(8L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 64))
                .fluidInputs(new FluidStack(solderIndalloy, 720)).itemOutputs(ItemList.Energy_LapotronicOrb2.get(1L))
                .eut(TierEU.RECIPE_ZPM).duration(50 * SECONDS).addTo(AssemblyLine);

        if (TecTech.isModLoaded()) {
            TT_recipeAdder.addResearchableAssemblylineRecipe(
                    ItemList.Hatch_CraftingInput_Bus_ME_ItemOnly.get(1L),
                    2000 * 60 * 8,
                    2000,
                    3000000,
                    2,
                    new ItemStack[] { ItemList.Hatch_Input_Bus_ME.get(1L), ItemList.Hatch_Input_Multi_2x2_UEV.get(1L),
                            // 16384k storage component
                            GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 8, 60),
                            // 16384k fluid storage component
                            GT_ModHandler.getModItem(AE2FluidCraft.ID, "fluid_part", 8, 7),
                            // ME Controller
                            GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockController", 1, WILDCARD),
                            // Dual Interface
                            GT_ModHandler.getModItem(AE2FluidCraft.ID, "part_fluid_interface", 1, WILDCARD),
                            // Pattern capacity card
                            GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 3, 54) },
                    new FluidStack[] { FluidRegistry.getFluidStack("molten.spacetime", 16 * INGOTS),
                            FluidRegistry.getFluidStack("molten.mutatedlivingsolder", 2000), },
                    ItemList.Hatch_CraftingInput_Bus_ME.get(1L),
                    30 * SECONDS,
                    (int) TierEU.RECIPE_UIV);
        }

        GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Hatch_Input_Bus_ME.get(1L))
                .metadata(RESEARCH_TIME, 1 * HOURS).itemInputs(
                        ItemList.Hatch_Input_Bus_ME.get(1L),
                        // 4096k Me Storage Component
                        GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 59),
                        // ME Controller
                        GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockController", 1, WILDCARD),
                        // Interface
                        GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 440),
                        // Pattern capacity card
                        GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 3, 54))
                .fluidInputs(new FluidStack(solderIndalloy, 1152))
                .itemOutputs(ItemList.Hatch_CraftingInput_Bus_ME_ItemOnly.get(1L)).eut(TierEU.RECIPE_LuV)
                .duration(30 * SECONDS).addTo(AssemblyLine);

        if (GraviSuite.isModLoaded()) {
            GT_Values.RA.stdBuilder()
                    .metadata(RESEARCH_ITEM, GT_ModHandler.getIC2Item("quantumBodyarmor", 1L, GT_Values.W))
                    .metadata(RESEARCH_TIME, 2 * HOURS)
                    .itemInputs(
                            GT_ModHandler.getIC2Item("quantumBodyarmor", 1L, WILDCARD),
                            ItemList.Transformer_ZPM_LuV.get(1L),
                            GT_ModHandler.getModItem(GraviSuite.ID, "ultimateLappack", 1, WILDCARD),
                            GT_ModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 6, 1),
                            GT_ModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 2, 2),
                            GT_ModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 2, 3),
                            new Object[] { OrePrefixes.circuit.get(Materials.Ultimate), 2L },
                            GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Duranium, 2),
                            ItemList.Energy_LapotronicOrb2.get(1L),
                            ItemList.Field_Generator_IV.get(2L),
                            ItemList.Electric_Motor_ZPM.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Duranium, 4))
                    .fluidInputs(new FluidStack(solderIndalloy, 2304), Materials.Tritanium.getMolten(1440L))
                    .itemOutputs(GT_ModHandler.getModItem(GraviSuite.ID, "graviChestPlate", 1, 26))
                    .eut(TierEU.RECIPE_LuV / 2).duration(1 * MINUTES + 15 * SECONDS).addTo(AssemblyLine);

            GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Casing_Coil_Superconductor.get(1L))
                    .metadata(RESEARCH_TIME, 4 * HOURS)
                    .itemInputs(
                            ItemList.Casing_Fusion_Coil.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUV, 16L),
                            new Object[] { OrePrefixes.circuit.get(Materials.SuperconductorUHV), 16L },
                            ItemList.Sensor_UV.get(16L),
                            ItemList.Emitter_UV.get(16L),
                            ItemList.Field_Generator_UV.get(8L),
                            ItemList.Circuit_Wafer_QPIC.get(64L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L))
                    .fluidInputs(
                            Materials.Longasssuperconductornameforuvwire.getMolten(2880L),
                            Materials.Americium.getPlasma(2880L),
                            Materials.Enderium.getMolten(5760L))
                    .itemOutputs(GT_ModHandler.getModItem(GraviSuite.ID, "relocator", 1, 26)).eut(TierEU.RECIPE_UV)
                    .duration(50 * MINUTES).addTo(AssemblyLine);
        }

    }
}
