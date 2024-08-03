package com.dreammaster.gthandler.recipes;

import static com.github.technus.tectech.thing.CustomItemList.DATApipe;
import static com.github.technus.tectech.thing.CustomItemList.Machine_Multi_DataBank;
import static com.github.technus.tectech.thing.CustomItemList.Machine_Multi_Switch;
import static gregtech.api.enums.Mods.AE2FluidCraft;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.SGCraft;
import static gregtech.api.enums.Mods.TecTech;
import static gregtech.api.util.GT_ModHandler.getModItem;
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
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class AssemblingLineRecipes implements Runnable {

    @Override
    public void run() {

        Fluid solderUEV = FluidRegistry.getFluid("molten.mutatedlivingsolder") != null
                ? FluidRegistry.getFluid("molten.mutatedlivingsolder")
                : FluidRegistry.getFluid("molten.solderingalloy");

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
                        new Object[] { OrePrefixes.circuit.get(Materials.LuV), 4L },
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

        // Advanced Stocking Input Bus (ME)
        GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Hatch_Input_Bus_ME.get(1L))
                .metadata(RESEARCH_TIME, 1 * HOURS)
                .itemInputs(
                        ItemList.Hatch_Input_Bus_LuV.get(1L),
                        GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1L),
                        ItemList.Conveyor_Module_IV.get(1L),
                        // Acceleration Card
                        GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4L, 30))
                .fluidInputs(new FluidStack(solderIndalloy, 288), FluidRegistry.getFluidStack("lubricant", 500))
                .itemOutputs(ItemList.Hatch_Input_Bus_ME_Advanced.get(1L)).eut(TierEU.RECIPE_LuV).duration(15 * SECONDS)
                .addTo(AssemblyLine);

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

            // Cloud Computation Client Hatch
            TT_recipeAdder.addResearchableAssemblylineRecipe(
                    // Optical Slave Connector
                    getModItem(GregTech.ID, "gt.blockmachines", 1, 15440),
                    512000,
                    2000,
                    100_000_000,
                    2,
                    new ItemStack[] {
                            // Regular slave connector
                            getModItem(GregTech.ID, "gt.blockmachines", 1, 15440),
                            // Network Switch With QoS
                            Machine_Multi_Switch.get(1),
                            // Data pipe
                            DATApipe.get(64),
                            // Internet card
                            GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 44),
                            // Dense infinity plate
                            GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Infinity, 64),
                            // Shirabon foil
                            GT_OreDictUnificator.get("foilShirabon", 64),
                            // Quantum circuit
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Cosmic, 1),
                            // Energized tesseract
                            ItemList.EnergisedTesseract.get(1) },
                    new FluidStack[] { new FluidStack(solderUEV, 1296), MaterialsUEVplus.ExcitedDTEC.getFluid(500L) },
                    // Cloud Computation Client Hatch
                    getModItem(GregTech.ID, "gt.blockmachines", 1, 15445),
                    30 * SECONDS,
                    (int) TierEU.RECIPE_UMV);

            // Cloud computation server hatch
            TT_recipeAdder.addResearchableAssemblylineRecipe(
                    // Optical Master Connector
                    getModItem(GregTech.ID, "gt.blockmachines", 1, 15441),
                    512000,
                    2000,
                    100_000_000,
                    2,
                    new ItemStack[] {
                            // Regular master connector
                            getModItem(GregTech.ID, "gt.blockmachines", 1, 15441),
                            // Network Switch With QoS
                            Machine_Multi_Switch.get(1),
                            // Data pipe
                            DATApipe.get(64),
                            // Internet card
                            GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 44),
                            // Dense infinity plate
                            GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Infinity, 64),
                            // Shirabon foil
                            GT_OreDictUnificator.get("foilShirabon", 64),
                            // Quantum circuit
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Cosmic, 1),
                            // Energized tesseract
                            ItemList.EnergisedTesseract.get(1) },
                    new FluidStack[] { new FluidStack(solderUEV, 1296), MaterialsUEVplus.ExcitedDTEC.getFluid(500L) },
                    // Cloud Computation Server Hatch
                    getModItem(GregTech.ID, "gt.blockmachines", 1, 15444),
                    30 * SECONDS,
                    (int) TierEU.RECIPE_UMV);

            // Wireless assembly line slave connector
            TT_recipeAdder.addResearchableAssemblylineRecipe(
                    // Assembly line slave connector
                    getModItem(GregTech.ID, "gt.blockmachines", 1, 15442),
                    512000,
                    2000,
                    100_000_000,
                    2,
                    new ItemStack[] {
                            // Assembly line slave connector
                            getModItem(GregTech.ID, "gt.blockmachines", 1, 15442),
                            // Data bank
                            Machine_Multi_DataBank.get(1),
                            // Data pipe
                            DATApipe.get(64),
                            // Internet card
                            GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 44),
                            // Dense infinity plate
                            GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Infinity, 64),
                            // Shirabon foil
                            GT_OreDictUnificator.get("foilShirabon", 64),
                            // Quantum circuit
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Cosmic, 1),
                            // Energized tesseract
                            ItemList.EnergisedTesseract.get(1) },
                    new FluidStack[] { new FluidStack(solderUEV, 1296), MaterialsUEVplus.ExcitedDTEC.getFluid(500L) },
                    // Wireless assembly line slave connector
                    getModItem(GregTech.ID, "gt.blockmachines", 1, 15446),
                    30 * SECONDS,
                    (int) TierEU.RECIPE_UMV);

            // Wireless data bank master connector
            TT_recipeAdder.addResearchableAssemblylineRecipe(
                    // Data bank master connector
                    getModItem(GregTech.ID, "gt.blockmachines", 1, 15443),
                    512000,
                    2000,
                    100_000_000,
                    2,
                    new ItemStack[] {
                            // Data bank master connector
                            getModItem(GregTech.ID, "gt.blockmachines", 1, 15443),
                            // Data bank
                            Machine_Multi_DataBank.get(1),
                            // Data pipe
                            DATApipe.get(64),
                            // Internet card
                            GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 44),
                            // Dense infinity plate
                            GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Infinity, 64),
                            // Shirabon foil
                            GT_OreDictUnificator.get("foilShirabon", 64),
                            // Quantum circuit
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Cosmic, 1),
                            // Energized tesseract
                            ItemList.EnergisedTesseract.get(1) },
                    new FluidStack[] { new FluidStack(solderUEV, 1296), MaterialsUEVplus.ExcitedDTEC.getFluid(500L) },
                    // Wireless data bank master connector
                    getModItem(GregTech.ID, "gt.blockmachines", 1, 15447),
                    30 * SECONDS,
                    (int) TierEU.RECIPE_UMV);

            if (SGCraft.isModLoaded() && EternalSingularity.isModLoaded()) {

                // The first crafted gate
                TT_recipeAdder.addResearchableAssemblylineRecipe(
                        ItemList.Circuit_Biomainframe.get(1L),
                        192_000,
                        512,
                        2_000_000,
                        32,
                        new Object[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Tritanium, 8),
                                ItemList.Circuit_Biomainframe.get(2L), ItemList.Circuit_Parts_CapacitorASMD.get(32L),
                                ItemList.Circuit_Parts_ResistorASMD.get(32L),
                                ItemList.Circuit_Parts_TransistorASMD.get(32L),
                                ItemList.Circuit_Parts_DiodeASMD.get(32L), ItemList.Circuit_Chip_Ram.get(64L),
                                ItemList.Circuit_Chip_NPIC.get(64L),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Draconium, 64),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUHV, 64),
                                new Object[] { OrePrefixes.foil.get(Materials.AnySyntheticRubber), 64L },
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Polybenzimidazole, 64) },
                        new FluidStack[] { Materials.SolderingAlloy.getMolten(3_744L),
                                Materials.Naquadria.getMolten(4_032L),
                                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 20_000) },
                        com.dreammaster.item.ItemList.NanoCircuitOrigin.getIS(1),
                        400 * SECONDS,
                        (int) TierEU.RECIPE_UEV);

                TT_recipeAdder.addResearchableAssemblylineRecipe(
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Infinity, 1L),
                        192_000,
                        512,
                        2_000_000,
                        32,
                        new ItemStack[] { GT_ModHandler.getModItem("eternalsingularity", "eternal_singularity", 1L),
                                ItemList.Sensor_UV.get(16L),
                                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 16L),
                                GT_OreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 16L),
                                GT_OreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L),
                                com.dreammaster.item.ItemList.NanoCircuitOrigin.getIS(16) },
                        new FluidStack[] { Materials.Neutronium.getMolten(36_864L),
                                Materials.Tritanium.getMolten(36_864L),
                                Materials.Tetranaquadahdiindiumhexaplatiumosminid.getMolten(36_864L),
                                Materials.Silver.getPlasma(36_864L) },
                        com.dreammaster.item.ItemList.GatePlateOrigin.getIS(1),
                        1 * HOURS,
                        (int) TierEU.RECIPE_UHV);

                TT_recipeAdder.addResearchableAssemblylineRecipe(
                        GT_OreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 1L),
                        192_000,
                        512,
                        2_000_000,
                        32,
                        new ItemStack[] { ItemList.Electric_Piston_UV.get(16L), ItemList.Electric_Motor_UV.get(64L),
                                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 16L),
                                GT_OreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.block, Materials.NetherStar, 16L),
                                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Ardite, 8L),
                                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Ardite, 8L),
                                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Ardite, 8L),
                                GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Ruby, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Jasper, 64L),
                                com.dreammaster.item.ItemList.NanoCircuitOrigin.getIS(32) },
                        new FluidStack[] { Materials.Neutronium.getMolten(9_216L),
                                Materials.Tritanium.getMolten(9_216L),
                                Materials.Tetranaquadahdiindiumhexaplatiumosminid.getMolten(9_216L),
                                Materials.Silver.getPlasma(9_216L) },
                        com.dreammaster.item.ItemList.ChevronOrigin.getIS(1),
                        1 * HOURS,
                        (int) TierEU.RECIPE_UHV);

                TT_recipeAdder.addResearchableAssemblylineRecipe(
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Neutronium, 1L),
                        192_000,
                        512,
                        2_000_000,
                        32,
                        new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Infinity, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.NaquadahAlloy, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.CosmicNeutronium, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Neutronium, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Osmiridium, 64L) },
                        new FluidStack[] { Materials.Neutronium.getMolten(73728L),
                                Materials.Tritanium.getMolten(73_728L), Materials.Concrete.getMolten(73_728L) },
                        com.dreammaster.item.ItemList.FramePartOrigin.getIS(1),
                        1 * HOURS,
                        (int) TierEU.RECIPE_UHV);

                // UEV Gate
                TT_recipeAdder.addResearchableAssemblylineRecipe(
                        com.dreammaster.item.ItemList.NanoCircuitOrigin.getIS(1),
                        192000 * 2,
                        512 * 2,
                        2_000_000 * 2,
                        32 * 2,
                        new Object[] { ItemList.Circuit_Board_Bio_Ultra.get(1L),
                                com.dreammaster.item.ItemList.PicoWafer.getIS(4),
                                com.dreammaster.item.ItemList.NanoCircuitOrigin.getIS(2),
                                ItemList.Circuit_Parts_TransistorXSMD.get(48L),
                                ItemList.Circuit_Parts_ResistorXSMD.get(48L),
                                ItemList.Circuit_Parts_CapacitorXSMD.get(48L),
                                ItemList.Circuit_Parts_DiodeXSMD.get(48L), ItemList.Circuit_Chip_PPIC.get(64L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 16),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Osmium, 32),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Neutronium, 16),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Lanthanum, 64) },
                        new FluidStack[] { Materials.SolderingAlloy.getMolten(3744L),
                                Materials.UUMatter.getFluid(8_000L), Materials.Osmium.getMolten(1_152L) },
                        com.dreammaster.item.ItemList.PikoCircuitPolychrome.getIS(1),
                        500 * SECONDS,
                        (int) TierEU.RECIPE_UEV);

                TT_recipeAdder.addResearchableAssemblylineRecipe(
                        com.dreammaster.item.ItemList.PikoCircuitPolychrome.getIS(1),
                        192000 * 4,
                        512 * 4,
                        2_000_000 * 4,
                        32 * 4,
                        new Object[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 16),
                                com.dreammaster.item.ItemList.PikoCircuitPolychrome.getIS(2),
                                ItemList.Circuit_Parts_CapacitorXSMD.get(64L),
                                ItemList.Circuit_Parts_DiodeXSMD.get(64L),
                                ItemList.Circuit_Parts_TransistorXSMD.get(64L),
                                ItemList.Circuit_Parts_ResistorXSMD.get(64L), ItemList.Circuit_Chip_QPIC.get(64L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 64),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Indium, 64),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Bedrockium, 8),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Lanthanum, 64) },
                        new FluidStack[] { Materials.SolderingAlloy.getMolten(3744L),
                                Materials.UUMatter.getFluid(24_000L), Materials.Osmium.getMolten(2_304L) },
                        com.dreammaster.item.ItemList.QuantumCircuitPolychrome.getIS(1),
                        1000 * SECONDS,
                        (int) TierEU.RECIPE_UIV);

                TT_recipeAdder.addResearchableAssemblylineRecipe(
                        com.dreammaster.item.ItemList.GatePlateOrigin.getIS(1),
                        32_000_000 * 12,
                        8192,
                        32_000_000,
                        64,
                        new ItemStack[] { GT_ModHandler.getModItem("eternalsingularity", "eternal_singularity", 1L),
                                ItemList.Sensor_UEV.get(16L),
                                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 16L),
                                GT_OreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 16L),
                                GT_OreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L),
                                com.dreammaster.item.ItemList.QuantumCircuitPolychrome.getIS(16) },
                        new FluidStack[] { Materials.Neutronium.getMolten(36_864L),
                                Materials.Tritanium.getMolten(36_864L),
                                Materials.Longasssuperconductornameforuhvwire.getMolten(36_864L),
                                Materials.Silver.getPlasma(36_864L) },
                        com.dreammaster.item.ItemList.GatePlatePolychrome.getIS(1),
                        1 * HOURS,
                        (int) TierEU.RECIPE_UIV);

                TT_recipeAdder.addResearchableAssemblylineRecipe(
                        com.dreammaster.item.ItemList.ChevronOrigin.getIS(1),
                        32_000_000 * 12,
                        8192,
                        32_000_000,
                        64,
                        new ItemStack[] { ItemList.Electric_Piston_UEV.get(16L), ItemList.Electric_Motor_UEV.get(64L),
                                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 16L),
                                GT_OreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.block, Materials.NetherStar, 16L),
                                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Ardite, 8L),
                                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Ardite, 8L),
                                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Ardite, 8L),
                                GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Ruby, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Jasper, 64L),
                                com.dreammaster.item.ItemList.QuantumCircuitPolychrome.getIS(32) },
                        new FluidStack[] { Materials.Neutronium.getMolten(9_216L),
                                Materials.Tritanium.getMolten(9_216L),
                                Materials.Longasssuperconductornameforuhvwire.getMolten(9_216L),
                                Materials.Silver.getPlasma(9_216L) },
                        com.dreammaster.item.ItemList.ChevronPolychrome.getIS(1),
                        1 * HOURS,
                        (int) TierEU.RECIPE_UIV);

                TT_recipeAdder.addResearchableAssemblylineRecipe(
                        com.dreammaster.item.ItemList.FramePartOrigin.getIS(1),
                        32_000_000 * 12,
                        8192,
                        32_000_000,
                        64,
                        new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Infinity, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.NaquadahAlloy, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.CosmicNeutronium, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Neutronium, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Osmiridium, 64L) },
                        new FluidStack[] { Materials.Neutronium.getMolten(73_728L),
                                Materials.Tritanium.getMolten(73_728L), Materials.Concrete.getMolten(73_728L) },
                        com.dreammaster.item.ItemList.FramePartPolychrome.getIS(1),
                        1 * HOURS,
                        (int) TierEU.RECIPE_UIV);

                // UMV Gate
                TT_recipeAdder.addResearchableAssemblylineRecipe(
                        ItemList.Circuit_Wafer_NPIC.get(1L),
                        192_000,
                        512,
                        2_000_000,
                        32,
                        new Object[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Tritanium, 8),
                                ItemList.Circuit_Biomainframe.get(2L), ItemList.Circuit_Parts_CapacitorXSMD.get(32L),
                                ItemList.Circuit_Parts_ResistorXSMD.get(32L),
                                ItemList.Circuit_Parts_TransistorXSMD.get(32L),
                                ItemList.Circuit_Parts_DiodeXSMD.get(32L), ItemList.Circuit_Chip_Ram.get(64L),
                                ItemList.Circuit_Chip_NPIC.get(64L),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Draconium, 64),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUHV, 64),
                                new Object[] { OrePrefixes.foil.get(Materials.AnySyntheticRubber), 64L },
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Polybenzimidazole, 64) },
                        new FluidStack[] { new FluidStack(FluidRegistry.getFluid("molten.mutatedlivingsolder"), 3_744),
                                Materials.Naquadria.getMolten(4_032L),
                                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 20_000) },
                        com.dreammaster.item.ItemList.NanoCircuit.getIS(1),
                        400 * SECONDS,
                        (int) TierEU.RECIPE_UIV);

                TT_recipeAdder.addResearchableAssemblylineRecipe(
                        com.dreammaster.item.ItemList.NanoCircuit.getIS(1),
                        384_000,
                        1_024,
                        4_000_000,
                        64,
                        new Object[] { ItemList.Circuit_Board_Bio_Ultra.get(1L),
                                com.dreammaster.item.ItemList.PicoWafer.getIS(4),
                                com.dreammaster.item.ItemList.NanoCircuit.getIS(2),
                                ItemList.Circuit_Parts_TransistorXSMD.get(48L),
                                ItemList.Circuit_Parts_ResistorXSMD.get(48L),
                                ItemList.Circuit_Parts_CapacitorXSMD.get(48L),
                                ItemList.Circuit_Parts_DiodeXSMD.get(48L), ItemList.Circuit_Chip_PPIC.get(64L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 16),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Osmium, 32),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Neutronium, 16),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Lanthanum, 64) },
                        new FluidStack[] { new FluidStack(FluidRegistry.getFluid("molten.mutatedlivingsolder"), 3_744),
                                Materials.UUMatter.getFluid(8000L), Materials.Osmium.getMolten(1152L) },
                        com.dreammaster.item.ItemList.PikoCircuitDimensional.getIS(1),
                        500 * SECONDS,
                        (int) TierEU.RECIPE_UMV);

                TT_recipeAdder.addResearchableAssemblylineRecipe(
                        com.dreammaster.item.ItemList.PikoCircuitDimensional.getIS(1),
                        720_000,
                        2_048,
                        8_000_000,
                        128,
                        new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 16),
                                com.dreammaster.item.ItemList.PikoCircuitDimensional.getIS(2),
                                ItemList.Circuit_Parts_CapacitorXSMD.get(64L),
                                ItemList.Circuit_Parts_DiodeXSMD.get(64L),
                                ItemList.Circuit_Parts_TransistorXSMD.get(64L),
                                ItemList.Circuit_Parts_ResistorXSMD.get(64L), ItemList.Circuit_Chip_QPIC.get(64L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 64),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Indium, 64),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, MaterialsUEVplus.SpaceTime, 8),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Lanthanum, 64) },
                        new FluidStack[] { new FluidStack(FluidRegistry.getFluid("molten.mutatedlivingsolder"), 3_744),
                                Materials.UUMatter.getFluid(24_000L), Materials.Osmium.getMolten(2_304L) },
                        com.dreammaster.item.ItemList.QuantumCircuitDimensional.getIS(1),
                        1000 * SECONDS,
                        (int) TierEU.RECIPE_UXV);

                TT_recipeAdder.addResearchableAssemblylineRecipe(
                        com.dreammaster.item.ItemList.GatePlatePolychrome.getIS(1),
                        2_000_000_000,
                        32_768,
                        500_000_000,
                        64,
                        new ItemStack[] { ItemList.Casing_Dim_Bridge.get(64),
                                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.block, MaterialsUEVplus.SpaceTime, 16L),
                                com.dreammaster.item.ItemList.QuantumCircuitDimensional.getIS(16),
                                GT_OreDictUnificator.get(OrePrefixes.plateDense, MaterialsUEVplus.SpaceTime, 8L),
                                GT_OreDictUnificator.get(OrePrefixes.plateDense, MaterialsUEVplus.SpaceTime, 8L),
                                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Infinity, 8L),
                                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Infinity, 8L),
                                ItemList.Sensor_UMV.get(16L), ItemList.Emitter_UMV.get(16L),
                                GT_ModHandler.getModItem("eternalsingularity", "eternal_singularity", 16L) },
                        new FluidStack[] { Materials.Neutronium.getMolten(32_768_000L),
                                MaterialsUEVplus.SpaceTime.getMolten(4 * 36864L),
                                Materials.SuperconductorUMVBase.getMolten(4 * 36864L),
                                MaterialsUEVplus.ExcitedDTEC.getFluid(4 * 36864L) },
                        com.dreammaster.item.ItemList.GatePlateDimensional.getIS(1),
                        1 * HOURS,
                        (int) TierEU.RECIPE_UXV);

                TT_recipeAdder.addResearchableAssemblylineRecipe(
                        com.dreammaster.item.ItemList.ChevronPolychrome.getIS(1),
                        2_000_000_000,
                        32_768,
                        500_000_000,
                        64,
                        new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L),
                                ItemList.Casing_Dim_Bridge.get(64), ItemList.Casing_Dim_Bridge.get(64),
                                GT_OreDictUnificator.get(OrePrefixes.frameGt, MaterialsUEVplus.SpaceTime, 16L),
                                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Infinity, 16L),
                                GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Ruby, 16L),
                                GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Jasper, 16L),
                                GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Opal, 16L),
                                GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Sapphire, 16L),
                                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Osmiridium, 8L),
                                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Osmiridium, 8L),
                                ItemList.Electric_Motor_UMV.get(64L), ItemList.Electric_Piston_UMV.get(64L),
                                ItemList.Field_Generator_UMV.get(16L),
                                com.dreammaster.item.ItemList.QuantumCircuitDimensional.getIS(32), },
                        new FluidStack[] { Materials.Neutronium.getMolten(32_768_000L),
                                MaterialsUEVplus.SpaceTime.getMolten(4 * 36864L),
                                Materials.SuperconductorUMVBase.getMolten(4 * 36864L),
                                MaterialsUEVplus.ExcitedDTEC.getFluid(4 * 36864L) },
                        com.dreammaster.item.ItemList.ChevronDimensional.getIS(1),
                        1 * HOURS,
                        (int) TierEU.RECIPE_UXV);

                TT_recipeAdder.addResearchableAssemblylineRecipe(
                        com.dreammaster.item.ItemList.FramePartPolychrome.getIS(1),
                        2_000_000_000,
                        32_768,
                        500_000_000,
                        64,
                        new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Infinity, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.stickLong, MaterialsUEVplus.SpaceTime, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.NaquadahAlloy, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.CosmicNeutronium, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Neutronium, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Osmiridium, 64L),
                                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedstickLong", 64L, 39),
                                GT_ModHandler.getModItem("miscutils", "itemRodLongQuantum", 64L),
                                GT_ModHandler.getModItem("miscutils", "itemRodLongHypogen", 64L),
                                GT_ModHandler.getModItem("miscutils", "itemRodLongCelestialTungsten", 64L),
                                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedstickLong", 64L, 10106),
                                GT_ModHandler.getModItem("miscutils", "itemRodLongAstralTitanium", 64L),
                                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.SuperconductorUMVBase, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Sunnarium, 64L),
                                GT_ModHandler.getModItem("miscutils", "itemRodLongAbyssalAlloy", 64L),
                                GT_OreDictUnificator
                                        .get(OrePrefixes.stickLong, MaterialsUEVplus.TranscendentMetal, 64L), },
                        new FluidStack[] { Materials.Neutronium.getMolten(32_768_000L),
                                MaterialsUEVplus.SpaceTime.getMolten(4 * 36864L),
                                Materials.SuperconductorUMVBase.getMolten(4 * 36864L),
                                MaterialsUEVplus.ExcitedDTEC.getFluid(4 * 36864L) },
                        com.dreammaster.item.ItemList.FramePartDimensional.getIS(1),
                        1 * HOURS,
                        (int) TierEU.RECIPE_UXV);
            }
        }

        GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Hatch_Input_Bus_ME_Advanced.get(1L))
                .metadata(RESEARCH_TIME, 1 * HOURS).itemInputs(
                        ItemList.Hatch_Input_Bus_ME_Advanced.get(1L),
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

        // Electromagnets
        {
            // Steel Electromagnet
            GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, getModItem(GregTech.ID, "gt.metaitem.01", 1, 32345))
                    .metadata(RESEARCH_TIME, 60 * SECONDS)
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NickelZincFerrite, 32L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.SteelMagnetic, 16L),
                            ItemList.LuV_Coil.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorLuV, 32L),
                            ItemList.Field_Generator_LuV.get(2))
                    .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 32346))
                    .fluidInputs(
                            new FluidStack(FluidRegistry.getFluid("ic2coolant"), 8000),
                            Materials.Cobalt.getMolten(2304),
                            Materials.VanadiumGallium.getMolten(2304))
                    .duration(60 * SECONDS).eut((int) TierEU.RECIPE_LuV).addTo(AssemblyLine);

            // Neodymium Electromagnet
            GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, getModItem(GregTech.ID, "gt.metaitem.01", 1, 32346))
                    .metadata(RESEARCH_TIME, 60 * SECONDS)
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 32L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.NeodymiumMagnetic, 16L),
                            ItemList.ZPM_Coil.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorZPM, 32L),
                            ItemList.Field_Generator_ZPM.get(2))
                    .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 32347))
                    .fluidInputs(
                            new FluidStack(FluidRegistry.getFluid("ic2coolant"), 16000),
                            Materials.Cobalt.getMolten(4608),
                            Materials.Osmiridium.getMolten(2304))
                    .duration(60 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(AssemblyLine);

            // Samarium Electromagnet
            GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, getModItem(GregTech.ID, "gt.metaitem.01", 1, 32347))
                    .metadata(RESEARCH_TIME, 60 * SECONDS)
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Neutronium, 32L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.SamariumMagnetic, 32L),
                            ItemList.UV_Coil.get(32L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUV, 64L),
                            ItemList.Field_Generator_UV.get(2))
                    .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 32348))
                    .fluidInputs(
                            new FluidStack(FluidRegistry.getFluid("supercoolant"), 32000),
                            Materials.Cobalt.getMolten(6912),
                            Materials.ElectrumFlux.getMolten(2304))
                    .duration(60 * SECONDS).eut(TierEU.RECIPE_UV).addTo(AssemblyLine);

            // Tengam Electromagnet
            GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, getModItem(GregTech.ID, "gt.metaitem.01", 1, 32348))
                    .metadata(RESEARCH_TIME, 60 * SECONDS)
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.CosmicNeutronium, 32L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.TengamAttuned, 32L),
                            ItemList.UHV_Coil.get(32L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorUHV, 64L),
                            ItemList.Field_Generator_UHV.get(2))
                    .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 32349))
                    .fluidInputs(
                            new FluidStack(FluidRegistry.getFluid("supercoolant"), 64000),
                            Materials.Cobalt.getMolten(9216),
                            Materials.Naquadria.getMolten(2304))
                    .duration(60 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(AssemblyLine);
        }

        // Piko Circuit
        TT_recipeAdder.addResearchableAssemblylineRecipe(
                ItemList.Circuit_OpticalMainframe.get(1L),
                384000,
                1024,
                4000000,
                64,
                new Object[] { ItemList.Circuit_Board_Optical.get(1L), CustomItemList.PicoWafer.get(4L),
                        new Object[] { OrePrefixes.circuit.get(Materials.Optical), 2L },
                        ItemList.Circuit_Parts_TransistorXSMD.get(48L), ItemList.Circuit_Parts_ResistorXSMD.get(48L),
                        ItemList.Circuit_Parts_CapacitorXSMD.get(48L), ItemList.Circuit_Parts_DiodeXSMD.get(48L),
                        ItemList.Circuit_Chip_PPIC.get(64L), GT_OreDictUnificator.get("foilRadoxPoly", 16L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, MaterialsUEVplus.TranscendentMetal, 32),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Neutronium, 16),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Lanthanum, 64) },
                new FluidStack[] { new FluidStack(solderUEV, 3744), Materials.UUMatter.getFluid(8000L),
                        Materials.Osmium.getMolten(1152L) },
                com.dreammaster.item.ItemList.PikoCircuit.getIS(1),
                10000,
                128_000_000);

        // Quantum Circuit
        TT_recipeAdder.addResearchableAssemblylineRecipe(
                CustomItemList.PikoCircuit.get(1L),
                720000,
                2048,
                8000000,
                128,
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 16),
                        CustomItemList.PikoCircuit.get(2L), ItemList.Circuit_Parts_CapacitorXSMD.get(64L),
                        ItemList.Circuit_Parts_DiodeXSMD.get(64L), ItemList.Circuit_Parts_TransistorXSMD.get(64L),
                        ItemList.Circuit_Parts_ResistorXSMD.get(64L), ItemList.Circuit_Chip_QPIC.get(64L),
                        GT_OreDictUnificator.get("foilShirabon", 64),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Indium, 64),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, MaterialsUEVplus.SpaceTime, 8),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Lanthanum, 16) },
                new FluidStack[] { new FluidStack(solderUEV, 3744), Materials.UUMatter.getFluid(24000L),
                        Materials.Osmium.getMolten(2304L) },
                com.dreammaster.item.ItemList.QuantumCircuit.getIS(1),
                20000,
                (int) TierEU.RECIPE_UMV);

    }
}
