package com.dreammaster.gthandler;

import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.AIR_FILTER_CONTROLLER_T1;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.AIR_FILTER_CONTROLLER_T2;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.AIR_FILTER_CONTROLLER_T3;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ALLOY_SMELTER_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ALLOY_SMELTER_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ALLOY_SMELTER_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ALLOY_SMELTER_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ALLOY_SMELTER_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ALLOY_SMELTER_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ALLOY_SMELTER_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ARC_FURNACE_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ARC_FURNACE_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ARC_FURNACE_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ARC_FURNACE_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ARC_FURNACE_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ARC_FURNACE_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ARC_FURNACE_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ASSEMBLING_MACHINE_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ASSEMBLING_MACHINE_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ASSEMBLING_MACHINE_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ASSEMBLING_MACHINE_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ASSEMBLING_MACHINE_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ASSEMBLING_MACHINE_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ASSEMBLING_MACHINE_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.AUTOCLAVE_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.AUTOCLAVE_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.AUTOCLAVE_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.AUTOCLAVE_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.AUTOCLAVE_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.AUTOCLAVE_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.AUTOCLAVE_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_BUFFER_1_BY_1_MAX;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_BUFFER_1_BY_1_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_BUFFER_1_BY_1_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_BUFFER_1_BY_1_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_BUFFER_1_BY_1_UXV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_BUFFER_2_BY_2_MAX;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_BUFFER_2_BY_2_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_BUFFER_2_BY_2_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_BUFFER_2_BY_2_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_BUFFER_2_BY_2_UXV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_BUFFER_3_BY_3_MAX;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_BUFFER_3_BY_3_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_BUFFER_3_BY_3_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_BUFFER_3_BY_3_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_BUFFER_3_BY_3_UXV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_BUFFER_4_BY_4_MAX;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_BUFFER_4_BY_4_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_BUFFER_4_BY_4_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_BUFFER_4_BY_4_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_BUFFER_4_BY_4_UXV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_CHARGER_4_4_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_CHARGER_4_4_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_CHARGER_4_4_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BATTERY_CHARGER_4_4_UXV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BENDING_MACHINE_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BENDING_MACHINE_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BENDING_MACHINE_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BENDING_MACHINE_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BENDING_MACHINE_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BENDING_MACHINE_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BENDING_MACHINE_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BREWERY_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BREWERY_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BREWERY_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BREWERY_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BREWERY_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BREWERY_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.BREWERY_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CANNING_MACHINE_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CANNING_MACHINE_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CANNING_MACHINE_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CANNING_MACHINE_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CANNING_MACHINE_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CANNING_MACHINE_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CANNING_MACHINE_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CENTRIFUGE_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CENTRIFUGE_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CENTRIFUGE_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CENTRIFUGE_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CENTRIFUGE_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CENTRIFUGE_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CENTRIFUGE_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CHEMICAL_BATH_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CHEMICAL_BATH_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CHEMICAL_BATH_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CHEMICAL_BATH_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CHEMICAL_BATH_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CHEMICAL_BATH_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CHEMICAL_BATH_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CHEMICAL_REACTOR_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CHEMICAL_REACTOR_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CHEMICAL_REACTOR_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CHEMICAL_REACTOR_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CHEMICAL_REACTOR_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CHEMICAL_REACTOR_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CHEMICAL_REACTOR_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CHEST_BUFFER_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CHEST_BUFFER_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CHEST_BUFFER_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CIRCUIT_ASSEMBLER_MAX;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CIRCUIT_ASSEMBLER_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CIRCUIT_ASSEMBLER_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CIRCUIT_ASSEMBLER_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CIRCUIT_ASSEMBLER_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CIRCUIT_ASSEMBLER_UXV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.COMPRESSOR_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.COMPRESSOR_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.COMPRESSOR_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.COMPRESSOR_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.COMPRESSOR_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.COMPRESSOR_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.COMPRESSOR_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CUTTING_MACHINE_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CUTTING_MACHINE_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CUTTING_MACHINE_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CUTTING_MACHINE_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CUTTING_MACHINE_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CUTTING_MACHINE_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.CUTTING_MACHINE_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.DISTILLERY_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.DISTILLERY_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.DISTILLERY_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.DISTILLERY_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.DISTILLERY_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.DISTILLERY_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.DISTILLERY_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.DYNAMO_HATCH_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.DYNAMO_HATCH_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.DYNAMO_HATCH_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.DYNAMO_HATCH_UXV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ELECTRIC_FURNACE_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ELECTRIC_FURNACE_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ELECTRIC_FURNACE_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ELECTRIC_FURNACE_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ELECTRIC_FURNACE_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ELECTRIC_FURNACE_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ELECTRIC_FURNACE_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ELECTROLYZER_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ELECTROLYZER_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ELECTROLYZER_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ELECTROLYZER_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ELECTROLYZER_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ELECTROLYZER_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ELECTROLYZER_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ELECTROMAGNETIC_SEPARATOR_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ELECTROMAGNETIC_SEPARATOR_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ELECTROMAGNETIC_SEPARATOR_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ELECTROMAGNETIC_SEPARATOR_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ELECTROMAGNETIC_SEPARATOR_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ELECTROMAGNETIC_SEPARATOR_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ELECTROMAGNETIC_SEPARATOR_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ENERGY_HATCH_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ENERGY_HATCH_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ENERGY_HATCH_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ENERGY_HATCH_UXV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.EXTRACTOR_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.EXTRACTOR_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.EXTRACTOR_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.EXTRACTOR_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.EXTRACTOR_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.EXTRACTOR_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.EXTRACTOR_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.EXTRUDER_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.EXTRUDER_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.EXTRUDER_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.EXTRUDER_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.EXTRUDER_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.EXTRUDER_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.EXTRUDER_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FERMENTER_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FERMENTER_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FERMENTER_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FERMENTER_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FERMENTER_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FERMENTER_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FERMENTER_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_CANNER_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_CANNER_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_CANNER_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_CANNER_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_CANNER_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_CANNER_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_CANNER_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_EXTRACTOR_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_EXTRACTOR_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_EXTRACTOR_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_EXTRACTOR_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_EXTRACTOR_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_EXTRACTOR_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_EXTRACTOR_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_HEATER_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_HEATER_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_HEATER_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_HEATER_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_HEATER_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_HEATER_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_HEATER_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_SOLIDIFIER_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_SOLIDIFIER_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_SOLIDIFIER_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_SOLIDIFIER_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_SOLIDIFIER_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_SOLIDIFIER_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FLUID_SOLIDIFIER_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FORGE_HAMMER_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FORGE_HAMMER_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FORGE_HAMMER_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FORGE_HAMMER_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FORGE_HAMMER_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FORGE_HAMMER_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FORGE_HAMMER_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FORMING_PRESS_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FORMING_PRESS_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FORMING_PRESS_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FORMING_PRESS_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FORMING_PRESS_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FORMING_PRESS_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.FORMING_PRESS_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.HIGH_AMP_TRANSFORMER_MAX_UXV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.HIGH_AMP_TRANSFORMER_UEV_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.HIGH_AMP_TRANSFORMER_UIV_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.HIGH_AMP_TRANSFORMER_UMV_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.HIGH_AMP_TRANSFORMER_UXV_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.HULL_MAX;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.HULL_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.HULL_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.HULL_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.HULL_UXV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.INPUT_HATCH_MAX;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.INPUT_HATCH_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.INPUT_HATCH_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.INPUT_HATCH_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.INPUT_HATCH_UXV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.LATHE_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.LATHE_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.LATHE_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.LATHE_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.LATHE_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.LATHE_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.LATHE_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MACERATOR_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MACERATOR_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MACERATOR_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MACERATOR_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MACERATOR_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MACERATOR_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MACERATOR_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MATTER_AMPLIFIER_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MATTER_AMPLIFIER_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MATTER_AMPLIFIER_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MATTER_AMPLIFIER_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MATTER_AMPLIFIER_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MATTER_AMPLIFIER_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MATTER_AMPLIFIER_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MATTER_FABRICATOR_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MATTER_FABRICATOR_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MATTER_FABRICATOR_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MATTER_FABRICATOR_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MATTER_FABRICATOR_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MATTER_FABRICATOR_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MATTER_FABRICATOR_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MATTER_REPLICATOR_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MATTER_REPLICATOR_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MATTER_REPLICATOR_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MATTER_REPLICATOR_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MATTER_REPLICATOR_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MATTER_REPLICATOR_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MATTER_REPLICATOR_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MICROWAVE_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MICROWAVE_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MICROWAVE_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MICROWAVE_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MICROWAVE_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MICROWAVE_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MICROWAVE_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MIXER_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MIXER_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MIXER_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MIXER_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MIXER_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MIXER_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.MIXER_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.NAME_REMOVER;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ORE_WASHING_PLANT_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ORE_WASHING_PLANT_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ORE_WASHING_PLANT_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ORE_WASHING_PLANT_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ORE_WASHING_PLANT_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ORE_WASHING_PLANT_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ORE_WASHING_PLANT_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.OUTPUT_HATCH_MAX;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.OUTPUT_HATCH_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.OUTPUT_HATCH_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.OUTPUT_HATCH_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.OUTPUT_HATCH_UXV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.PLASMA_ARC_FURNACE_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.PLASMA_ARC_FURNACE_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.PLASMA_ARC_FURNACE_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.PLASMA_ARC_FURNACE_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.PLASMA_ARC_FURNACE_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.PLASMA_ARC_FURNACE_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.PLASMA_ARC_FURNACE_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.PLASMA_GENERATOR_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.PLASMA_GENERATOR_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.POLARIZER_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.POLARIZER_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.POLARIZER_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.POLARIZER_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.POLARIZER_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.POLARIZER_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.POLARIZER_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.PRECISION_LASER_ENGRAVER_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.PRECISION_LASER_ENGRAVER_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.PRECISION_LASER_ENGRAVER_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.PRECISION_LASER_ENGRAVER_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.PRECISION_LASER_ENGRAVER_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.PRECISION_LASER_ENGRAVER_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.PRECISION_LASER_ENGRAVER_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.PUMP_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.PUMP_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.RECYCLER_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.RECYCLER_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.RECYCLER_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.RECYCLER_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.RECYCLER_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.RECYCLER_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.RECYCLER_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ROCK_BREAKER_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ROCK_BREAKER_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ROCK_BREAKER_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ROCK_BREAKER_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ROCK_BREAKER_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ROCK_BREAKER_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.ROCK_BREAKER_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.SCANNER_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.SCANNER_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.SCANNER_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.SCANNER_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.SCANNER_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.SCANNER_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.SCANNER_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.SIFTING_MACHINE_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.SIFTING_MACHINE_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.SIFTING_MACHINE_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.SIFTING_MACHINE_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.SIFTING_MACHINE_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.SIFTING_MACHINE_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.SIFTING_MACHINE_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.SLICING_MACHINE_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.SLICING_MACHINE_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.SLICING_MACHINE_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.SLICING_MACHINE_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.SLICING_MACHINE_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.SLICING_MACHINE_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.SLICING_MACHINE_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.THERMAL_CENTRIFUGE_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.THERMAL_CENTRIFUGE_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.THERMAL_CENTRIFUGE_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.THERMAL_CENTRIFUGE_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.THERMAL_CENTRIFUGE_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.THERMAL_CENTRIFUGE_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.THERMAL_CENTRIFUGE_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.TRANSFORMER_MAX_UXV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.TRANSFORMER_UEV_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.TRANSFORMER_UIV_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.TRANSFORMER_UMV_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.TRANSFORMER_UXV_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.TURBO_CHARGER_EV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.TURBO_CHARGER_HV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.TURBO_CHARGER_IV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.TURBO_CHARGER_LV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.TURBO_CHARGER_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.TURBO_CHARGER_MV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.TURBO_CHARGER_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.TURBO_CHARGER_ULV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.TURBO_CHARGER_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.TURBO_CHARGER_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.WET_TRANSFORMER_EV_HV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.WET_TRANSFORMER_HV_MV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.WET_TRANSFORMER_IV_EV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.WET_TRANSFORMER_LV_ULV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.WET_TRANSFORMER_LuV_IV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.WET_TRANSFORMER_MAX_UXV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.WET_TRANSFORMER_MV_LV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.WET_TRANSFORMER_UEV_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.WET_TRANSFORMER_UHV_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.WET_TRANSFORMER_UIV_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.WET_TRANSFORMER_UMV_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.WET_TRANSFORMER_UV_ZPM;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.WET_TRANSFORMER_UXV_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.WET_TRANSFORMER_ZPM_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.WIREMILL_LuV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.WIREMILL_UEV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.WIREMILL_UHV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.WIREMILL_UIV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.WIREMILL_UMV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.WIREMILL_UV;
import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.WIREMILL_ZPM;
import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.amplifierRecipes;
import static gregtech.api.recipe.RecipeMaps.arcFurnaceRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.autoclaveRecipes;
import static gregtech.api.recipe.RecipeMaps.benderRecipes;
import static gregtech.api.recipe.RecipeMaps.cannerRecipes;
import static gregtech.api.recipe.RecipeMaps.centrifugeRecipes;
import static gregtech.api.recipe.RecipeMaps.chemicalBathRecipes;
import static gregtech.api.recipe.RecipeMaps.chemicalReactorRecipes;
import static gregtech.api.recipe.RecipeMaps.circuitAssemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.compressorRecipes;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.recipe.RecipeMaps.distilleryRecipes;
import static gregtech.api.recipe.RecipeMaps.electroMagneticSeparatorRecipes;
import static gregtech.api.recipe.RecipeMaps.electrolyzerRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.recipe.RecipeMaps.extruderRecipes;
import static gregtech.api.recipe.RecipeMaps.fermentingRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidCannerRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidExtractionRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidHeaterRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidSolidifierRecipes;
import static gregtech.api.recipe.RecipeMaps.formingPressRecipes;
import static gregtech.api.recipe.RecipeMaps.furnaceRecipes;
import static gregtech.api.recipe.RecipeMaps.hammerRecipes;
import static gregtech.api.recipe.RecipeMaps.laserEngraverRecipes;
import static gregtech.api.recipe.RecipeMaps.latheRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.recipe.RecipeMaps.microwaveRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.recipe.RecipeMaps.oreWasherRecipes;
import static gregtech.api.recipe.RecipeMaps.plasmaArcFurnaceRecipes;
import static gregtech.api.recipe.RecipeMaps.polarizerRecipes;
import static gregtech.api.recipe.RecipeMaps.recyclerRecipes;
import static gregtech.api.recipe.RecipeMaps.sifterRecipes;
import static gregtech.api.recipe.RecipeMaps.slicerRecipes;
import static gregtech.api.recipe.RecipeMaps.thermalCentrifugeRecipes;
import static gregtech.api.recipe.RecipeMaps.wiremillRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_BasicMachine;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.dreammaster.gthandler.multiAirFilter.GT_MetaTileEntity_AirFilterT1;
import com.dreammaster.gthandler.multiAirFilter.GT_MetaTileEntity_AirFilterT2;
import com.dreammaster.gthandler.multiAirFilter.GT_MetaTileEntity_AirFilterT3;
import com.dreammaster.gthandler.nameRemover.NameRemover;
import com.dreammaster.gthandler.transformers.GT_MetaTileEntity_WetTransformer;
import com.dreammaster.gthandler.turboCharger.GT_MetaTileEntity_TurboCharger;
import com.dreammaster.item.food.QuantumBread;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.MachineType;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsKevlar;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OreDictNames;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SoundResource;
import gregtech.api.enums.TierEU;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_BasicBatteryBuffer;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_BasicHull;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_BasicMachine_GT_Recipe;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch_Dynamo;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch_Energy;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch_Input;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch_Output;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Transformer;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_Utility;
import gregtech.common.tileentities.automation.GT_MetaTileEntity_ChestBuffer;
import gregtech.common.tileentities.generators.GT_MetaTileEntity_PlasmaGenerator;
import gregtech.common.tileentities.machines.basic.GT_MetaTileEntity_Charger;
import gregtech.common.tileentities.machines.basic.GT_MetaTileEntity_Massfabricator;
import gregtech.common.tileentities.machines.basic.GT_MetaTileEntity_PotionBrewer;
import gregtech.common.tileentities.machines.basic.GT_MetaTileEntity_Pump;
import gregtech.common.tileentities.machines.basic.GT_MetaTileEntity_Replicator;
import gregtech.common.tileentities.machines.basic.GT_MetaTileEntity_RockBreaker;
import gregtech.common.tileentities.machines.basic.GT_MetaTileEntity_Scanner;
import gregtech.loaders.preload.GT_Loader_MetaTileEntities;
import gtPlusPlus.xmod.gregtech.api.metatileentity.implementations.base.GregtechMetaTransformerHiAmp;

public class GT_Loader_Machines {

    public static long bitsd = GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE
            | GT_ModHandler.RecipeBits.REVERSIBLE
            | GT_ModHandler.RecipeBits.BUFFERED;
    private Materials LuVMat2;

    public void run() {
        LuVMat2 = BartWorks.isModLoaded() ? Materials.get("Rhodium-PlatedPalladium") : Materials.Chrome;
        registerMachineHulls();
        registerPlasmaGenerators();
        registerAlloySmelter();
        registerMatterAmplifier();
        registerAssemblingMachine();
        registerAutoclave();
        registerBendingMachine();
        registerCompressor();
        registerCuttingMachine();
        registerDistillery();
        registerElectricFurnace();
        registerElectrolyzer();
        registerElectromagneticSeparator();
        registerExtractor();
        registerExtruder();
        registerFluidSolidifier();
        registerFormingPress();
        registerForgeHammer();
        registerLathe();
        registerPrecisionLaserEngraver();
        registerMacerator();
        registerMatterFabricator();
        registerMicrowave();
        registerOreWashingPlant();
        registerPolarizer();
        registerRecycler();
        registerReplicator();
        registerScanner();
        registerSiftingMachine();
        registerSlicingMachine();
        registerThermalCentrifuge();
        registerWiremill();
        registerPump();
        registerArcFurnace();
        registerCentrifuge();
        registerPlasmaArcFurnace();
        registerBrewery();
        registerCanningMachine();
        registerChemicalBath();
        registerChemicalReactor();

        registerFermenter();
        registerFluidCanner();
        registerFluidExtractor();
        registerFluidHeater();
        registerMixer();
        registerTransformer();
        registerBatteryBuffer4By4();
        registerBatteryBuffer3By3();
        registerBatteryBuffer2By2();
        registerBatteryBuffer1By1();
        registerBatteryCharger4By4();
        registerDynamoHatches();
        registerEnergyHatches();
        registerWetTransformer();
        registerHighAmpTransformer();
        registerAirFilter();
        registerTurboCharger4By4();
        registerChestBuffer();
        registerRockBreaker();
        registerNameRemover();
        registerCircuitAssembler();
        registerInputHatch();
        registerOutputHatches();

        registerMachines2();
        recipes();
    }

    public void recipes() {

        Materials LuVMat2 = BartWorks.isModLoaded() ? Materials.get("Rhodium-PlatedPalladium") : Materials.Chrome;

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Hull_UEV.get(1L),
                bitsd,
                new Object[] { "PHP", "WMW", 'M', CustomItemList.Casing_UEV, 'W',
                        OrePrefixes.cableGt08.get(Materials.Draconium), 'H',
                        OrePrefixes.plate.get(Materials.Bedrockium), 'P',
                        OrePrefixes.plateDouble.get(Materials.Polybenzimidazole) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Hull_UIV.get(1L),
                bitsd,
                new Object[] { "PHP", "WMW", 'M', CustomItemList.Casing_UIV, 'W',
                        OrePrefixes.cableGt08.get(Materials.NetherStar), 'H',
                        OrePrefixes.plate.get(Materials.BlackPlutonium), 'P',
                        OrePrefixes.plateDouble.get(Materials.Polybenzimidazole) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Hull_UMV.get(1L),
                GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "PHP", "WMW", 'M', CustomItemList.Casing_UMV, 'W',
                        OrePrefixes.wireGt12.get(Materials.Quantium), 'H',
                        OrePrefixes.plate.get(MaterialsUEVplus.SpaceTime), 'P',
                        OrePrefixes.plateDouble.get(Materials.Polybenzimidazole) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Hull_UXV.get(1L),
                GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "PHP", "WMW", 'M', CustomItemList.Casing_UXV, 'W',
                        OrePrefixes.wireGt16.get(Materials.BlackPlutonium), 'H',
                        OrePrefixes.plate.get(MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter), 'P',
                        OrePrefixes.plateDense.get(MaterialsKevlar.Kevlar) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Generator_Plasma_ZPMV.get(1L),
                bitsd,
                new Object[] { "UCU", "FMF", "WCW", 'M', ItemList.Hull_UV, 'F', ItemList.Field_Generator_ZPM, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        OrePrefixes.wireGt08.get(Materials.SuperconductorUHV), 'U',
                        OrePrefixes.stick.get(Materials.Americium) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Generator_Plasma_UV.get(1L),
                bitsd,
                new Object[] { "UCU", "FMF", "WCW", 'M', ItemList.Hull_UV, 'F', ItemList.Field_Generator_UV, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        OrePrefixes.wireGt12.get(Materials.SuperconductorUHV), 'U',
                        OrePrefixes.stick.get(Materials.Americium) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MassFabricatorLuV.get(1L),
                bitsd,
                new Object[] { "CFC", "WMW", "CFC", 'M', ItemList.Hull_LuV, 'F', ItemList.Field_Generator_LuV, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MassFabricatorZPM.get(1L),
                bitsd,
                new Object[] { "CFC", "WMW", "CFC", 'M', ItemList.Hull_ZPM, 'F', ItemList.Field_Generator_ZPM, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable4() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MassFabricatorUV.get(1L),
                bitsd,
                new Object[] { "CFC", "WMW", "CFC", 'M', ItemList.Hull_UV, 'F', ItemList.Field_Generator_UV, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MassFabricatorUHV.get(1L),
                bitsd,
                new Object[] { "CFC", "WMW", "CFC", 'M', ItemList.Hull_MAX, 'F', ItemList.Field_Generator_UHV, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable4() });
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MassFabricatorUEV.get(1L),
                bitsd,
                new Object[] { "CFC", "WMW", "CFC", 'M', CustomItemList.Hull_UEV, 'F', ItemList.Field_Generator_UEV,
                        'C', GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MassFabricatorUIV.get(1L),
                bitsd,
                new Object[] { "CFC", "WMW", "CFC", 'M', CustomItemList.Hull_UIV, 'F', ItemList.Field_Generator_UIV,
                        'C', GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MassFabricatorUMV.get(1L),
                bitsd,
                new Object[] { "CFC", "WMW", "CFC", 'M', CustomItemList.Hull_UMV, 'F', ItemList.Field_Generator_UMV,
                        'C', GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ReplicatorLuV.get(1L),
                bitsd,
                new Object[] { "EFE", "CMC", "EWE", 'M', ItemList.Hull_LuV, 'F', ItemList.Field_Generator_LuV, 'E',
                        ItemList.Emitter_LuV, 'C', GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ReplicatorZPM.get(1L),
                bitsd,
                new Object[] { "EFE", "CMC", "EWE", 'M', ItemList.Hull_ZPM, 'F', ItemList.Field_Generator_ZPM, 'E',
                        ItemList.Emitter_ZPM, 'C', GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable4() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ReplicatorUV.get(1L),
                bitsd,
                new Object[] { "EFE", "CMC", "EWE", 'M', ItemList.Hull_UV, 'F', ItemList.Field_Generator_UV, 'E',
                        ItemList.Emitter_UV, 'C', GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ReplicatorUHV.get(1L),
                bitsd,
                new Object[] { "EFE", "CMC", "EWE", 'M', ItemList.Hull_MAX, 'F', ItemList.Field_Generator_UHV, 'E',
                        ItemList.Emitter_UHV, 'C', GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ReplicatorUEV.get(1L),
                bitsd,
                new Object[] { "EFE", "CMC", "EWE", 'M', CustomItemList.Hull_UEV, 'F', ItemList.Field_Generator_UEV,
                        'E', ItemList.Emitter_UEV, 'C', GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ReplicatorUIV.get(1L),
                bitsd,
                new Object[] { "EFE", "CMC", "EWE", 'M', CustomItemList.Hull_UIV, 'F', ItemList.Field_Generator_UIV,
                        'E', ItemList.Emitter_UIV, 'C', GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ReplicatorUMV.get(1L),
                bitsd,
                new Object[] { "EFE", "CMC", "EWE", 'M', CustomItemList.Hull_UMV, 'F', ItemList.Field_Generator_UMV,
                        'E', ItemList.Emitter_UMV, 'C', GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ScannerLuV.get(1L),
                bitsd,
                new Object[] { "CTC", "WMW", "CRC", 'M', ItemList.Hull_LuV, 'T', ItemList.Emitter_LuV, 'R',
                        ItemList.Sensor_LuV, 'C', GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ScannerZPM.get(1L),
                bitsd,
                new Object[] { "CTC", "WMW", "CRC", 'M', ItemList.Hull_ZPM, 'T', ItemList.Emitter_ZPM, 'R',
                        ItemList.Sensor_ZPM, 'C', GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ScannerUV.get(1L),
                bitsd,
                new Object[] { "CTC", "WMW", "CRC", 'M', ItemList.Hull_UV, 'T', ItemList.Emitter_UV, 'R',
                        ItemList.Sensor_UV, 'C', OrePrefixes.circuit.get(Materials.UHV), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ScannerUHV.get(1L),
                bitsd,
                new Object[] { "CTC", "WMW", "CRC", 'M', ItemList.Hull_MAX, 'T', ItemList.Emitter_UHV, 'R',
                        ItemList.Sensor_UHV, 'C', OrePrefixes.circuit.get(Materials.UEV), 'W',
                        OrePrefixes.cableGt01.get(Materials.Bedrockium) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ScannerUEV.get(1L),
                bitsd,
                new Object[] { "CTC", "WMW", "CRC", 'M', CustomItemList.Hull_UEV, 'T', ItemList.Emitter_UEV, 'R',
                        ItemList.Sensor_UEV, 'C', OrePrefixes.circuit.get(Materials.UIV), 'W',
                        OrePrefixes.cableGt01.get(Materials.Draconium) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ScannerUIV.get(1L),
                bitsd,
                new Object[] { "CTC", "WMW", "CRC", 'M', CustomItemList.Hull_UIV, 'T', ItemList.Emitter_UIV, 'R',
                        ItemList.Sensor_UIV, 'C', OrePrefixes.circuit.get(Materials.UMV), 'W',
                        OrePrefixes.cableGt01.get(Materials.Draconium) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ScannerUMV.get(1L),
                bitsd,
                new Object[] { "CTC", "WMW", "CRC", 'M', CustomItemList.Hull_UMV, 'T', ItemList.Emitter_UMV, 'R',
                        ItemList.Sensor_UMV, 'C', OrePrefixes.circuit.get(Materials.UXV), 'W',
                        OrePrefixes.cableGt01.get(Materials.Draconium) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PumpLuV.get(1L),
                bitsd,
                new Object[] { "CPC", "PMP", "BPB", 'M', ItemList.Hull_LuV, 'B',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getPipeL(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'P', ItemList.Electric_Pump_LuV });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PumpZPM.get(1L),
                bitsd,
                new Object[] { "CPC", "PMP", "BPB", 'M', ItemList.Hull_ZPM, 'B',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getPipeL(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'P', ItemList.Electric_Pump_ZPM });

        GT_ModHandler.addCraftingRecipe(
                ItemList.AcceleratorLV.get(1L),
                bitsd,
                new Object[] { "RMR", "PBC", "IMI", 'R', ItemList.Robot_Arm_LV, 'M', ItemList.Electric_Motor_LV, 'P',
                        ItemList.Electric_Pump_LV, 'B', ItemList.Hull_LV, 'C', ItemList.Conveyor_Module_LV, 'I',
                        ItemList.Electric_Piston_LV });

        GT_ModHandler.addCraftingRecipe(
                ItemList.AcceleratorMV.get(1L),
                bitsd,
                new Object[] { "RMR", "PBC", "IMI", 'R', ItemList.Robot_Arm_MV, 'M', ItemList.Electric_Motor_MV, 'P',
                        ItemList.Electric_Pump_MV, 'B', ItemList.Hull_MV, 'C', ItemList.Conveyor_Module_MV, 'I',
                        ItemList.Electric_Piston_MV });

        GT_ModHandler.addCraftingRecipe(
                ItemList.AcceleratorHV.get(1L),
                bitsd,
                new Object[] { "RMR", "PBC", "IMI", 'R', ItemList.Robot_Arm_HV, 'M', ItemList.Electric_Motor_HV, 'P',
                        ItemList.Electric_Pump_HV, 'B', ItemList.Hull_HV, 'C', ItemList.Conveyor_Module_HV, 'I',
                        ItemList.Electric_Piston_HV });

        GT_ModHandler.addCraftingRecipe(
                ItemList.AcceleratorEV.get(1L),
                bitsd,
                new Object[] { "RMR", "PBC", "IMI", 'R', ItemList.Robot_Arm_EV, 'M', ItemList.Electric_Motor_EV, 'P',
                        ItemList.Electric_Pump_EV, 'B', ItemList.Hull_EV, 'C', ItemList.Conveyor_Module_EV, 'I',
                        ItemList.Electric_Piston_EV });

        GT_ModHandler.addCraftingRecipe(
                ItemList.AcceleratorIV.get(1L),
                bitsd,
                new Object[] { "RMR", "PBC", "IMI", 'R', ItemList.Robot_Arm_IV, 'M', ItemList.Electric_Motor_IV, 'P',
                        ItemList.Electric_Pump_IV, 'B', ItemList.Hull_IV, 'C', ItemList.Conveyor_Module_IV, 'I',
                        ItemList.Electric_Piston_IV });

        GT_ModHandler.addCraftingRecipe(
                ItemList.AcceleratorLuV.get(1L),
                bitsd,
                new Object[] { "RMR", "PBC", "IMI", 'R', ItemList.Robot_Arm_LuV, 'M', ItemList.Electric_Motor_LuV, 'P',
                        ItemList.Electric_Pump_LuV, 'B', ItemList.Hull_LuV, 'C', ItemList.Conveyor_Module_LuV, 'I',
                        ItemList.Electric_Piston_LuV });

        GT_ModHandler.addCraftingRecipe(
                ItemList.AcceleratorZPM.get(1L),
                bitsd,
                new Object[] { "RMR", "PBC", "IMI", 'R', ItemList.Robot_Arm_ZPM, 'M', ItemList.Electric_Motor_ZPM, 'P',
                        ItemList.Electric_Pump_ZPM, 'B', ItemList.Hull_ZPM, 'C', ItemList.Conveyor_Module_ZPM, 'I',
                        ItemList.Electric_Piston_ZPM });

        GT_ModHandler.addCraftingRecipe(
                ItemList.AcceleratorUV.get(1L),
                bitsd,
                new Object[] { "RMR", "PBC", "IMI", 'R', ItemList.Robot_Arm_UV, 'M', ItemList.Electric_Motor_UV, 'P',
                        ItemList.Electric_Pump_UV, 'B', ItemList.Hull_UV, 'C', ItemList.Conveyor_Module_UV, 'I',
                        ItemList.Electric_Piston_UV });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.BreweryLuV.get(1L),
                bitsd,
                new Object[] { "GPG", "WBW", "CZC", 'W', OrePrefixes.cableGt01.get(Materials.VanadiumGallium), 'P',
                        ItemList.Electric_Pump_LuV, 'B', ItemList.Hull_LuV, 'C', OrePrefixes.circuit.get(Materials.LuV),
                        'G', GT_CustomLoader.AdvancedGTMaterials.LuV.getGlass(), 'Z',
                        new ItemStack(Items.brewing_stand, 1, 32767) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.BreweryZPM.get(1L),
                bitsd,
                new Object[] { "GPG", "WBW", "CZC", 'W', OrePrefixes.cableGt01.get(Materials.Naquadah), 'P',
                        ItemList.Electric_Pump_ZPM, 'B', ItemList.Hull_ZPM, 'C', OrePrefixes.circuit.get(Materials.ZPM),
                        'G', GT_CustomLoader.AdvancedGTMaterials.ZPM.getGlass(), 'Z',
                        new ItemStack(Items.brewing_stand, 1, 32767) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.BreweryUV.get(1L),
                bitsd,
                new Object[] { "GPG", "WBW", "CZC", 'W', OrePrefixes.cableGt01.get(Materials.ElectrumFlux), 'P',
                        ItemList.Electric_Pump_UV, 'B', ItemList.Hull_UV, 'C', OrePrefixes.circuit.get(Materials.UV),
                        'G', GT_CustomLoader.AdvancedGTMaterials.UV.getGlass(), 'Z',
                        new ItemStack(Items.brewing_stand, 1, 32767) });
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.BreweryUHV.get(1L),
                bitsd,
                new Object[] { "GPG", "WBW", "CZC", 'W', GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'P',
                        ItemList.Electric_Pump_UHV, 'B', ItemList.Hull_MAX, 'C', OrePrefixes.circuit.get(Materials.UHV),
                        'G', GT_CustomLoader.AdvancedGTMaterials.UHV.getGlass(), 'Z',
                        new ItemStack(Items.brewing_stand, 1, 32767) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.BreweryUEV.get(1L),
                bitsd,
                new Object[] { "GPG", "WBW", "CZC", 'W', OrePrefixes.cableGt01.get(Materials.Draconium), 'P',
                        ItemList.Electric_Pump_UEV, 'B', CustomItemList.Hull_UEV, 'C',
                        OrePrefixes.circuit.get(Materials.UEV), 'G', GT_CustomLoader.AdvancedGTMaterials.UEV.getGlass(),
                        'Z', new ItemStack(Items.brewing_stand, 1, 32767) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.BreweryUIV.get(1L),
                bitsd,
                new Object[] { "GPG", "WBW", "CZC", 'W', GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'P',
                        ItemList.Electric_Pump_UIV, 'B', CustomItemList.Hull_UIV, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getGlass(), 'Z',
                        new ItemStack(Items.brewing_stand, 1, 32767) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.BreweryUMV.get(1L),
                bitsd,
                new Object[] { "GPG", "WBW", "CZC", 'W', GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'P',
                        ItemList.Electric_Pump_UMV, 'B', CustomItemList.Hull_UMV, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getGlass(), 'Z',
                        new ItemStack(Items.brewing_stand, 1, 32767) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ChemicalReactorLuV.get(1L),
                bitsd,
                new Object[] { "PRP", "WMW", "CHC", 'H', ItemList.Hull_LuV, 'R', OrePrefixes.rotor.get(LuVMat2), 'P',
                        OrePrefixes.pipeMedium.get(Materials.PolyvinylChloride), 'M', ItemList.Electric_Motor_LuV, 'C',
                        OrePrefixes.circuit.get(Materials.LuV), 'W',
                        OrePrefixes.cableGt01.get(Materials.VanadiumGallium) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ChemicalReactorZPM.get(1L),
                bitsd,
                new Object[] { "PRP", "WMW", "CHC", 'H', ItemList.Hull_ZPM, 'R',
                        OrePrefixes.rotor.get(Materials.Iridium), 'P',
                        OrePrefixes.pipeLarge.get(Materials.PolyvinylChloride), 'M', ItemList.Electric_Motor_ZPM, 'C',
                        OrePrefixes.circuit.get(Materials.ZPM), 'W', OrePrefixes.cableGt01.get(Materials.Naquadah) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ChemicalReactorUV.get(1L),
                bitsd,
                new Object[] { "PRP", "WMW", "CHC", 'H', ItemList.Hull_UV, 'R', OrePrefixes.rotor.get(Materials.Osmium),
                        'P', OrePrefixes.pipeHuge.get(Materials.PolyvinylChloride), 'M', ItemList.Electric_Motor_UV,
                        'C', OrePrefixes.circuit.get(Materials.UV), 'W',
                        OrePrefixes.cableGt01.get(Materials.ElectrumFlux) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ChemicalReactorUHV.get(1L),
                bitsd,
                new Object[] { "PRP", "WMW", "CHC", 'H', ItemList.Hull_MAX, 'R',
                        OrePrefixes.rotor.get(Materials.Osmiridium), 'P',
                        OrePrefixes.pipeHuge.get(Materials.PolyvinylChloride), 'M', ItemList.Electric_Motor_UHV, 'C',
                        OrePrefixes.circuit.get(Materials.UHV), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ChemicalReactorUEV.get(1L),
                bitsd,
                new Object[] { "PRP", "WMW", "CHC", 'H', CustomItemList.Hull_UEV, 'R',
                        OrePrefixes.rotor.get(Materials.InfinityCatalyst), 'P',
                        OrePrefixes.pipeHuge.get(Materials.PolyvinylChloride), 'M', ItemList.Electric_Motor_UEV, 'C',
                        OrePrefixes.circuit.get(Materials.UEV), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ChemicalReactorUIV.get(1L),
                bitsd,
                new Object[] { "PRP", "WMW", "CHC", 'H', CustomItemList.Hull_UIV, 'R',
                        OrePrefixes.rotor.get(Materials.Infinity), 'P',
                        OrePrefixes.pipeMedium.get(Materials.Polybenzimidazole), 'M', ItemList.Electric_Motor_UIV, 'C',
                        OrePrefixes.circuit.get(Materials.UIV), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ChemicalReactorUMV.get(1L),
                bitsd,
                new Object[] { "PRP", "WMW", "CHC", 'H', CustomItemList.Hull_UMV, 'R',
                        OrePrefixes.rotor.get(MaterialsUEVplus.TranscendentMetal), 'P',
                        OrePrefixes.pipeLarge.get(Materials.Polybenzimidazole), 'M', ItemList.Electric_Motor_UMV, 'C',
                        OrePrefixes.circuit.get(Materials.UMV), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FermenterLuV.get(1L),
                bitsd,
                new Object[] { "WPW", "GBG", "WCW", 'W', OrePrefixes.cableGt01.get(Materials.VanadiumGallium), 'P',
                        ItemList.Electric_Pump_LuV, 'B', ItemList.Hull_LuV, 'C', OrePrefixes.circuit.get(Materials.LuV),
                        'G', GT_CustomLoader.AdvancedGTMaterials.LuV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FermenterZPM.get(1L),
                bitsd,
                new Object[] { "WPW", "GBG", "WCW", 'W', OrePrefixes.cableGt01.get(Materials.Naquadah), 'P',
                        ItemList.Electric_Pump_ZPM, 'B', ItemList.Hull_ZPM, 'C', OrePrefixes.circuit.get(Materials.ZPM),
                        'G', GT_CustomLoader.AdvancedGTMaterials.ZPM.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FermenterUV.get(1L),
                bitsd,
                new Object[] { "WPW", "GBG", "WCW", 'W', OrePrefixes.cableGt01.get(Materials.ElectrumFlux), 'P',
                        ItemList.Electric_Pump_UV, 'B', ItemList.Hull_UV, 'C', OrePrefixes.circuit.get(Materials.UV),
                        'G', GT_CustomLoader.AdvancedGTMaterials.UV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FermenterUHV.get(1L),
                bitsd,
                new Object[] { "WPW", "GBG", "WCW", 'W', GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'P',
                        ItemList.Electric_Pump_UHV, 'B', ItemList.Hull_MAX, 'C', OrePrefixes.circuit.get(Materials.UHV),
                        'G', GT_CustomLoader.AdvancedGTMaterials.UHV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FermenterUEV.get(1L),
                bitsd,
                new Object[] { "WPW", "GBG", "WCW", 'W', GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'P',
                        ItemList.Electric_Pump_UEV, 'B', CustomItemList.Hull_UEV, 'C',
                        OrePrefixes.circuit.get(Materials.UEV), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FermenterUIV.get(1L),
                bitsd,
                new Object[] { "WPW", "GBG", "WCW", 'W', GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'P',
                        ItemList.Electric_Pump_UIV, 'B', CustomItemList.Hull_UIV, 'C',
                        OrePrefixes.circuit.get(Materials.UIV), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FermenterUMV.get(1L),
                bitsd,
                new Object[] { "WPW", "GBG", "WCW", 'W', GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'P',
                        ItemList.Electric_Pump_UMV, 'B', CustomItemList.Hull_UMV, 'C',
                        OrePrefixes.circuit.get(Materials.UMV), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidCannerLuV.get(1L),
                bitsd,
                new Object[] { "GCG", "GBG", "WPW", 'W', OrePrefixes.cableGt01.get(Materials.VanadiumGallium), 'P',
                        ItemList.Electric_Pump_LuV, 'B', ItemList.Hull_LuV, 'C', OrePrefixes.circuit.get(Materials.LuV),
                        'G', GT_CustomLoader.AdvancedGTMaterials.LuV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidCannerZPM.get(1L),
                bitsd,
                new Object[] { "GCG", "GBG", "WPW", 'W', OrePrefixes.cableGt01.get(Materials.Naquadah), 'P',
                        ItemList.Electric_Pump_ZPM, 'B', ItemList.Hull_ZPM, 'C', OrePrefixes.circuit.get(Materials.ZPM),
                        'G', GT_CustomLoader.AdvancedGTMaterials.ZPM.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidCannerUV.get(1L),
                bitsd,
                new Object[] { "GCG", "GBG", "WPW", 'W', OrePrefixes.cableGt01.get(Materials.ElectrumFlux), 'P',
                        ItemList.Electric_Pump_UV, 'B', ItemList.Hull_UV, 'C', OrePrefixes.circuit.get(Materials.UV),
                        'G', GT_CustomLoader.AdvancedGTMaterials.UV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidCannerUHV.get(1L),
                bitsd,
                new Object[] { "GCG", "GBG", "WPW", 'W', GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'P',
                        ItemList.Electric_Pump_UHV, 'B', ItemList.Hull_MAX, 'C', OrePrefixes.circuit.get(Materials.UV),
                        'G', GT_CustomLoader.AdvancedGTMaterials.UHV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidCannerUEV.get(1L),
                bitsd,
                new Object[] { "GCG", "GBG", "WPW", 'W', GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'P',
                        ItemList.Electric_Pump_UEV, 'B', CustomItemList.Hull_UEV, 'C',
                        OrePrefixes.circuit.get(Materials.UV), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidCannerUIV.get(1L),
                bitsd,
                new Object[] { "GCG", "GBG", "WPW", 'W', GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'P',
                        ItemList.Electric_Pump_UIV, 'B', CustomItemList.Hull_UIV, 'C',
                        OrePrefixes.circuit.get(Materials.UV), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidCannerUMV.get(1L),
                bitsd,
                new Object[] { "GCG", "GBG", "WPW", 'W', GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'P',
                        ItemList.Electric_Pump_UMV, 'B', CustomItemList.Hull_UMV, 'C',
                        OrePrefixes.circuit.get(Materials.UV), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidExtractorLuV.get(1L),
                bitsd,
                new Object[] { "GEG", "WPW", "CMC", 'M', ItemList.Hull_LuV, 'E', ItemList.Electric_Piston_LuV, 'P',
                        ItemList.Electric_Pump_LuV, 'C', OrePrefixes.circuit.get(Materials.LuV), 'W',
                        OrePrefixes.cableGt01.get(Materials.VanadiumGallium), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidExtractorZPM.get(1L),
                bitsd,
                new Object[] { "GEG", "WPW", "CMC", 'M', ItemList.Hull_ZPM, 'E', ItemList.Electric_Piston_ZPM, 'P',
                        ItemList.Electric_Pump_ZPM, 'C', OrePrefixes.circuit.get(Materials.ZPM), 'W',
                        OrePrefixes.cableGt01.get(Materials.Naquadah), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidExtractorUV.get(1L),
                bitsd,
                new Object[] { "GEG", "WPW", "CMC", 'M', ItemList.Hull_UV, 'E', ItemList.Electric_Piston_UV, 'P',
                        ItemList.Electric_Pump_UV, 'C', OrePrefixes.circuit.get(Materials.UV), 'W',
                        OrePrefixes.cableGt01.get(Materials.ElectrumFlux), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidExtractorUHV.get(1L),
                bitsd,
                new Object[] { "GEG", "WPW", "CMC", 'M', ItemList.Hull_MAX, 'E', ItemList.Electric_Piston_UHV, 'P',
                        ItemList.Electric_Pump_UHV, 'C', GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidExtractorUEV.get(1L),
                bitsd,
                new Object[] { "GEG", "WPW", "CMC", 'M', CustomItemList.Hull_UEV, 'E', ItemList.Electric_Piston_UEV,
                        'P', ItemList.Electric_Pump_UEV, 'C', GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidExtractorUIV.get(1L),
                bitsd,
                new Object[] { "GEG", "WPW", "CMC", 'M', CustomItemList.Hull_UIV, 'E', ItemList.Electric_Piston_UIV,
                        'P', ItemList.Electric_Pump_UIV, 'C', GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidExtractorUMV.get(1L),
                bitsd,
                new Object[] { "GEG", "WPW", "CMC", 'M', CustomItemList.Hull_UMV, 'E', ItemList.Electric_Piston_UMV,
                        'P', ItemList.Electric_Pump_UMV, 'C', GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidHeaterLuV.get(1L),
                bitsd,
                new Object[] { "WGW", "PMP", "RCR", 'M', ItemList.Hull_LuV, 'P', ItemList.Electric_Pump_LuV, 'C',
                        OrePrefixes.circuit.get(Materials.LuV), 'W',
                        OrePrefixes.wireGt04.get(Materials.NiobiumTitanium), 'R',
                        OrePrefixes.cableGt01.get(Materials.VanadiumGallium), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidHeaterZPM.get(1L),
                bitsd,
                new Object[] { "WGW", "PMP", "WCW", 'M', ItemList.Hull_ZPM, 'P', ItemList.Electric_Pump_ZPM, 'C',
                        OrePrefixes.circuit.get(Materials.ZPM), 'W', OrePrefixes.wireGt04.get(Materials.Naquadah), 'R',
                        OrePrefixes.cableGt01.get(Materials.Naquadah), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidHeaterUV.get(1L),
                bitsd,
                new Object[] { "WGW", "PMP", "WCW", 'M', ItemList.Hull_UV, 'P', ItemList.Electric_Pump_UV, 'C',
                        OrePrefixes.circuit.get(Materials.UV), 'W', OrePrefixes.wireGt04.get(Materials.NaquadahAlloy),
                        'R', OrePrefixes.cableGt01.get(Materials.ElectrumFlux), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidHeaterUHV.get(1L),
                bitsd,
                new Object[] { "WGW", "PMP", "WCW", 'M', ItemList.Hull_MAX, 'P', ItemList.Electric_Pump_UHV, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getHCoil(), 'R',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidHeaterUEV.get(1L),
                bitsd,
                new Object[] { "WGW", "PMP", "WCW", 'M', CustomItemList.Hull_UEV, 'P', ItemList.Electric_Pump_UEV, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getHCoil(), 'R',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidHeaterUIV.get(1L),
                bitsd,
                new Object[] { "WGW", "PMP", "WCW", 'M', CustomItemList.Hull_UIV, 'P', ItemList.Electric_Pump_UIV, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getHCoil(), 'R',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidHeaterUMV.get(1L),
                bitsd,
                new Object[] { "WGW", "PMP", "WCW", 'M', CustomItemList.Hull_UMV, 'P', ItemList.Electric_Pump_UMV, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getHCoil(), 'R',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MixerLuV.get(1L),
                bitsd,
                new Object[] { "GRG", "GMG", "CBC", 'R', OrePrefixes.rotor.get(LuVMat2), 'M',
                        ItemList.Electric_Motor_LuV, 'B', ItemList.Hull_LuV, 'C',
                        OrePrefixes.circuit.get(Materials.LuV), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MixerZPM.get(1L),
                bitsd,
                new Object[] { "GRG", "GMG", "CBC", 'R', OrePrefixes.rotor.get(Materials.Iridium), 'M',
                        ItemList.Electric_Motor_ZPM, 'B', ItemList.Hull_ZPM, 'C',
                        OrePrefixes.circuit.get(Materials.ZPM), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MixerUV.get(1L),
                bitsd,
                new Object[] { "GRG", "GMG", "CBC", 'R', OrePrefixes.rotor.get(Materials.Osmium), 'M',
                        ItemList.Electric_Motor_UV, 'B', ItemList.Hull_UV, 'C', OrePrefixes.circuit.get(Materials.UV),
                        'G', GT_CustomLoader.AdvancedGTMaterials.UV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MixerUHV.get(1L),
                bitsd,
                new Object[] { "GRG", "GMG", "CBC", 'R', OrePrefixes.rotor.get(Materials.Neutronium), 'M',
                        ItemList.Electric_Motor_UHV, 'B', ItemList.Hull_MAX, 'C',
                        OrePrefixes.circuit.get(Materials.UHV), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MixerUEV.get(1L),
                bitsd,
                new Object[] { "GRG", "GMG", "CBC", 'R', OrePrefixes.rotor.get(Materials.Neutronium), 'M',
                        ItemList.Electric_Motor_UEV, 'B', CustomItemList.Hull_UEV, 'C',
                        OrePrefixes.circuit.get(Materials.UEV), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MixerUIV.get(1L),
                bitsd,
                new Object[] { "GRG", "GMG", "CBC", 'R', OrePrefixes.rotor.get(Materials.CosmicNeutronium), 'M',
                        ItemList.Electric_Motor_UIV, 'B', CustomItemList.Hull_UIV, 'C',
                        OrePrefixes.circuit.get(Materials.UIV), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MixerUMV.get(1L),
                bitsd,
                new Object[] { "GRG", "GMG", "CBC", 'R', OrePrefixes.rotor.get(Materials.CosmicNeutronium), 'M',
                        ItemList.Electric_Motor_UMV, 'B', CustomItemList.Hull_UMV, 'C',
                        OrePrefixes.circuit.get(Materials.UMV), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Transformer_UEV_UHV.get(1L),
                bitsd,
                new Object[] { "KBB", "CM ", "KBB", 'M', ItemList.Hull_MAX, 'C',
                        OrePrefixes.wireGt01.get(Materials.Draconium), 'B',
                        OrePrefixes.wireGt04.get(Materials.SuperconductorUHV), 'K', ItemList.Circuit_Chip_PPIC });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Transformer_UIV_UEV.get(1L),
                bitsd,
                new Object[] { "KBB", "CM ", "KBB", 'M', CustomItemList.Hull_UEV, 'C',
                        OrePrefixes.wireGt01.get(Materials.NetherStar), 'B',
                        OrePrefixes.wireGt04.get(Materials.Draconium), 'K', ItemList.Circuit_Chip_QPIC });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Transformer_UMV_UIV.get(1L),
                bitsd,
                new Object[] { "KBB", "CM ", "KBB", 'M', CustomItemList.Hull_UIV, 'C',
                        OrePrefixes.wireGt01.get(Materials.Quantium), 'B',
                        OrePrefixes.wireGt04.get(Materials.NetherStar), 'K', ItemList.Circuit_Chip_QPIC });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Transformer_UXV_UMV.get(1L),
                bitsd,
                new Object[] { "KBB", "CM ", "KBB", 'M', CustomItemList.Hull_UMV, 'C',
                        OrePrefixes.wireGt01.get(Materials.BlackPlutonium), 'B',
                        OrePrefixes.wireGt04.get(Materials.Quantium), 'K', ItemList.Circuit_Chip_QPIC });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Transformer_MAX_UXV.get(1L),
                bitsd,
                new Object[] { "KBB", "CM ", "KBB", 'M', CustomItemList.Hull_UXV, 'C',
                        OrePrefixes.wireGt01.get(Materials.Infinity), 'B',
                        OrePrefixes.wireGt04.get(Materials.BlackPlutonium), 'K', ItemList.Circuit_Chip_QPIC });
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_Buffer_4by4_UEV.get(1L),
                bitsd,
                new Object[] { "WTW", "WMW", 'M', CustomItemList.Hull_UEV, 'W',
                        OrePrefixes.wireGt16.get(Materials.Draconium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_Buffer_3by3_UIV.get(1L),
                bitsd,
                new Object[] { "WTW", "WMW", 'M', CustomItemList.Hull_UIV, 'W',
                        OrePrefixes.wireGt08.get(Materials.NetherStar), 'T', OreDictNames.craftingChest });
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_Buffer_3by3_UMV.get(1L),
                bitsd,
                new Object[] { "WTW", "WMW", 'M', CustomItemList.Hull_UMV, 'W',
                        OrePrefixes.wireGt08.get(Materials.Quantium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_Buffer_3by3_UXV.get(1L),
                bitsd,
                new Object[] { "WTW", "WMW", 'M', CustomItemList.Hull_UXV, 'W',
                        OrePrefixes.wireGt08.get(Materials.BlackPlutonium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_Buffer_2by2_UEV.get(1L),
                bitsd,
                new Object[] { "WTW", "WMW", 'M', CustomItemList.Hull_UEV, 'W',
                        OrePrefixes.wireGt04.get(Materials.Draconium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_Buffer_2by2_UIV.get(1L),
                bitsd,
                new Object[] { "WTW", "WMW", 'M', CustomItemList.Hull_UIV, 'W',
                        OrePrefixes.wireGt04.get(Materials.NetherStar), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_Buffer_2by2_UMV.get(1L),
                bitsd,
                new Object[] { "WTW", "WMW", 'M', CustomItemList.Hull_UMV, 'W',
                        OrePrefixes.wireGt04.get(Materials.Quantium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_Buffer_2by2_UXV.get(1L),
                bitsd,
                new Object[] { "WTW", "WMW", 'M', CustomItemList.Hull_UXV, 'W',
                        OrePrefixes.wireGt04.get(Materials.BlackPlutonium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_Buffer_1by1_UEV.get(1L),
                bitsd,
                new Object[] { "WTW", "WMW", 'M', CustomItemList.Hull_UEV, 'W',
                        OrePrefixes.wireGt01.get(Materials.Draconium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_Buffer_1by1_UIV.get(1L),
                bitsd,
                new Object[] { "WTW", "WMW", 'M', CustomItemList.Hull_UIV, 'W',
                        OrePrefixes.wireGt01.get(Materials.NetherStar), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_Buffer_1by1_UMV.get(1L),
                bitsd,
                new Object[] { "WTW", "WMW", 'M', CustomItemList.Hull_UMV, 'W',
                        OrePrefixes.wireGt01.get(Materials.Quantium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_Buffer_1by1_UXV.get(1L),
                bitsd,
                new Object[] { "WTW", "WMW", 'M', CustomItemList.Hull_UXV, 'W',
                        OrePrefixes.wireGt01.get(Materials.BlackPlutonium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_Buffer_4by4_UIV.get(1L),
                bitsd,
                new Object[] { "WTW", "WMW", 'M', CustomItemList.Hull_UIV, 'W',
                        OrePrefixes.wireGt16.get(Materials.NetherStar), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_Buffer_4by4_UMV.get(1L),
                bitsd,
                new Object[] { "WTW", "WMW", 'M', CustomItemList.Hull_UMV, 'W',
                        OrePrefixes.wireGt16.get(Materials.Quantium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_Buffer_4by4_UXV.get(1L),
                bitsd,
                new Object[] { "WTW", "WMW", 'M', CustomItemList.Hull_UXV, 'W',
                        OrePrefixes.wireGt16.get(Materials.BlackPlutonium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_Buffer_3by3_UEV.get(1L),
                bitsd,
                new Object[] { "WTW", "WMW", 'M', CustomItemList.Hull_UEV, 'W',
                        OrePrefixes.wireGt08.get(Materials.Draconium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_TurboCharger_4by4_ULV.get(1L),
                bitsd,
                new Object[] { "BTB", "CMC", "BXB", 'T', CustomItemList.WetTransformer_LV_ULV, 'M',
                        ItemList.Battery_Charger_4by4_ULV, 'B', ItemList.Battery_RE_ULV_Tantalum, 'C',
                        OrePrefixes.cableGt16.get(Materials.Lead), 'X', OrePrefixes.circuit.get(Materials.ULV) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_TurboCharger_4by4_LV.get(1L),
                bitsd,
                new Object[] { "BTB", "CMC", "BXB", 'T', CustomItemList.WetTransformer_MV_LV, 'M',
                        ItemList.Battery_Charger_4by4_LV, 'B', ItemList.Battery_RE_LV_Lithium, 'C',
                        OrePrefixes.cableGt16.get(Materials.Tin), 'X', OrePrefixes.circuit.get(Materials.LV) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_TurboCharger_4by4_MV.get(1L),
                bitsd,
                new Object[] { "BTB", "CMC", "BXB", 'T', CustomItemList.WetTransformer_HV_MV, 'M',
                        ItemList.Battery_Charger_4by4_MV, 'B', ItemList.Battery_RE_MV_Lithium, 'C',
                        OrePrefixes.cableGt16.get(Materials.AnyCopper), 'X', OrePrefixes.circuit.get(Materials.MV) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_TurboCharger_4by4_HV.get(1L),
                bitsd,
                new Object[] { "BTB", "CMC", "BXB", 'T', CustomItemList.WetTransformer_EV_HV, 'M',
                        ItemList.Battery_Charger_4by4_HV, 'B', ItemList.Battery_RE_HV_Lithium, 'C',
                        OrePrefixes.cableGt16.get(Materials.Gold), 'X', OrePrefixes.circuit.get(Materials.HV) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_TurboCharger_4by4_EV.get(1L),
                bitsd,
                new Object[] { "BTB", "CMC", "BXB", 'T', CustomItemList.WetTransformer_IV_EV, 'M',
                        ItemList.Battery_Charger_4by4_EV, 'B', OrePrefixes.battery.get(Materials.EV), 'C',
                        OrePrefixes.cableGt16.get(Materials.Aluminium), 'X', OrePrefixes.circuit.get(Materials.EV) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_TurboCharger_4by4_IV.get(1L),
                bitsd,
                new Object[] { "BTB", "CMC", "BXB", 'T', CustomItemList.WetTransformer_LuV_IV, 'M',
                        ItemList.Battery_Charger_4by4_IV, 'B', ItemList.Energy_LapotronicOrb, 'C',
                        OrePrefixes.cableGt16.get(Materials.Tungsten), 'X', OrePrefixes.circuit.get(Materials.IV) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_TurboCharger_4by4_LuV.get(1L),
                bitsd,
                new Object[] { "BTB", "CMC", "BXB", 'T', CustomItemList.WetTransformer_ZPM_LuV, 'M',
                        ItemList.Battery_Charger_4by4_LuV, 'B', ItemList.Energy_LapotronicOrb2, 'C',
                        OrePrefixes.cableGt16.get(Materials.VanadiumGallium), 'X',
                        OrePrefixes.circuit.get(Materials.LuV) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_TurboCharger_4by4_ZPM.get(1L),
                bitsd,
                new Object[] { "BTB", "CMC", "BXB", 'T', CustomItemList.WetTransformer_UV_ZPM, 'M',
                        ItemList.Battery_Charger_4by4_ZPM, 'B', ItemList.Energy_LapotronicOrb2, 'C',
                        OrePrefixes.cableGt16.get(Materials.Naquadah), 'X', OrePrefixes.circuit.get(Materials.ZPM) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_TurboCharger_4by4_UV.get(1L),
                bitsd,
                new Object[] { "BTB", "CMC", "BXB", 'T', CustomItemList.WetTransformer_UHV_UV, 'M',
                        ItemList.Battery_Charger_4by4_UV, 'B', ItemList.ZPM2, 'C',
                        OrePrefixes.cableGt16.get(Materials.NaquadahAlloy), 'X',
                        OrePrefixes.circuit.get(Materials.UV) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Battery_TurboCharger_4by4_UHV.get(1L),
                bitsd,
                new Object[] { "BTB", "CMC", "BXB", 'T', CustomItemList.WetTransformer_UEV_UHV, 'M',
                        ItemList.Battery_Charger_4by4_MAX, 'B', ItemList.ZPM2, 'C',
                        OrePrefixes.wireGt16.get(Materials.SuperconductorUHV), 'X',
                        OrePrefixes.circuit.get(Materials.UHV) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Automation_ChestBuffer_UEV.get(1L),
                bitsd,
                new Object[] { "CMV", " X ", 'M', CustomItemList.Hull_UEV, 'V', ItemList.Conveyor_Module_UEV, 'C',
                        OreDictNames.craftingChest, 'X', OrePrefixes.circuit.get(Materials.UEV) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Automation_ChestBuffer_UIV.get(1L),
                bitsd,
                new Object[] { "CMV", " X ", 'M', CustomItemList.Hull_UIV, 'V', ItemList.Conveyor_Module_UIV, 'C',
                        OreDictNames.craftingChest, 'X', OrePrefixes.circuit.get(Materials.UIV) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.Automation_ChestBuffer_UMV.get(1L),
                bitsd,
                new Object[] { "CMV", " X ", 'M', CustomItemList.Hull_UMV, 'V', ItemList.Conveyor_Module_UMV, 'C',
                        OreDictNames.craftingChest, 'X', OrePrefixes.circuit.get(Materials.UMV) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.nameRemover.get(1L),
                bitsd,
                new Object[] { "SsS", "VMV", "SXS", 'M', ItemList.Hull_ULV, 'V',
                        OrePrefixes.gearGtSmall.get(Materials.AnyBronze), 'S', OrePrefixes.screw.get(Materials.AnyIron),
                        'X', OreDictNames.craftingPiston });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.RockBreakerLuV.get(1L),
                bitsd,
                new Object[] { "PED", "WMW", "GGG", 'P', ItemList.Electric_Piston_LuV, 'E', ItemList.Electric_Motor_LuV,
                        'D', OreDictNames.craftingGrinder, 'G', GT_CustomLoader.AdvancedGTMaterials.LuV.getGlass(), 'W',
                        OrePrefixes.cableGt01.get(Materials.VanadiumGallium), 'M', ItemList.Hull_LuV });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.RockBreakerZPM.get(1L),
                bitsd,
                new Object[] { "PED", "WMW", "GGG", 'P', ItemList.Electric_Piston_ZPM, 'E', ItemList.Electric_Motor_ZPM,
                        'D', OreDictNames.craftingGrinder, 'G', GT_CustomLoader.AdvancedGTMaterials.ZPM.getGlass(), 'W',
                        OrePrefixes.cableGt01.get(Materials.Naquadah), 'M', ItemList.Hull_ZPM });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.RockBreakerUV.get(1L),
                bitsd,
                new Object[] { "PED", "WMW", "GGG", 'P', ItemList.Electric_Piston_UV, 'E', ItemList.Electric_Motor_UV,
                        'D', OreDictNames.craftingGrinder, 'G', GT_CustomLoader.AdvancedGTMaterials.UV.getGlass(), 'W',
                        OrePrefixes.cableGt01.get(Materials.NaquadahAlloy), 'M', ItemList.Hull_UV });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.RockBreakerUHV.get(1L),
                bitsd,
                new Object[] { "PED", "WMW", "GGG", 'P', ItemList.Electric_Piston_UHV, 'E', ItemList.Electric_Motor_UHV,
                        'D', OreDictNames.craftingGrinder, 'G', GT_CustomLoader.AdvancedGTMaterials.UHV.getGlass(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'M', ItemList.Hull_MAX });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.RockBreakerUEV.get(1L),
                bitsd,
                new Object[] { "PED", "WMW", "GGG", 'P', ItemList.Electric_Piston_UEV, 'E', ItemList.Electric_Motor_UEV,
                        'D', OreDictNames.craftingGrinder, 'G', GT_CustomLoader.AdvancedGTMaterials.UEV.getGlass(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'M', CustomItemList.Hull_UEV });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.RockBreakerUIV.get(1L),
                bitsd,
                new Object[] { "PED", "WMW", "GGG", 'P', ItemList.Electric_Piston_UIV, 'E', ItemList.Electric_Motor_UIV,
                        'D', OreDictNames.craftingGrinder, 'G', GT_CustomLoader.AdvancedGTMaterials.UIV.getGlass(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'M', CustomItemList.Hull_UIV });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.RockBreakerUMV.get(1L),
                bitsd,
                new Object[] { "PED", "WMW", "GGG", 'P', ItemList.Electric_Piston_UMV, 'E', ItemList.Electric_Motor_UMV,
                        'D', OreDictNames.craftingGrinder, 'G', GT_CustomLoader.AdvancedGTMaterials.UMV.getGlass(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'M', CustomItemList.Hull_UMV });

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Food_Sliced_Breads.get(1L), ItemList.Shape_Slicer_Flat.get(0L))
                .itemOutputs(new ItemStack(QuantumBread.Instance(), 1)).duration(20 * TICKS).eut(TierEU.RECIPE_UV)
                .addTo(slicerRecipes);

        if (GTPlusPlus.isModLoaded()) {
            GT_ModHandler.addCraftingRecipe(
                    CustomItemList.Transformer_HA_UEV_UHV.get(1L),
                    bitsd,
                    new Object[] { "KBB", "CM ", "KBB", 'M', CustomItemList.Transformer_UEV_UHV, 'C',
                            OrePrefixes.wireGt04.get(Materials.Draconium), 'B',
                            OrePrefixes.wireGt04.get(Materials.Bedrockium), 'K', ItemList.Casing_Coil_Superconductor });
            GT_ModHandler.addCraftingRecipe(
                    CustomItemList.Transformer_HA_UIV_UEV.get(1L),
                    bitsd,
                    new Object[] { "KBB", "CM ", "KBB", 'M', CustomItemList.Transformer_UIV_UEV, 'C',
                            OrePrefixes.wireGt04.get(Materials.NetherStar), 'B',
                            OrePrefixes.wireGt04.get(Materials.Draconium), 'K', ItemList.Casing_Fusion_Coil });
            GT_ModHandler.addCraftingRecipe(
                    CustomItemList.Transformer_HA_UMV_UIV.get(1L),
                    bitsd,
                    new Object[] { "KBB", "CMK", "KBB", 'M', CustomItemList.Transformer_UMV_UIV, 'C',
                            OrePrefixes.wireGt04.get(Materials.Quantium), 'B',
                            OrePrefixes.wireGt04.get(Materials.NetherStar), 'K', ItemList.Casing_Fusion_Coil });

            GT_ModHandler.addCraftingRecipe(
                    CustomItemList.Transformer_HA_UXV_UMV.get(1L),
                    bitsd,
                    new Object[] { "KBB", "CMK", "KBB", 'M', CustomItemList.Transformer_UXV_UMV, 'C',
                            OrePrefixes.wireGt04.get(Materials.BlackPlutonium), 'B',
                            OrePrefixes.wireGt04.get(Materials.Quantium), 'K', ItemList.Casing_Fusion_Coil });

            GT_ModHandler.addCraftingRecipe(
                    CustomItemList.Transformer_HA_MAX_UXV.get(1L),
                    bitsd,
                    new Object[] { "KBB", "CMK", "KBB", 'M', CustomItemList.Transformer_MAX_UXV, 'C',
                            OrePrefixes.wireGt04.get(Materials.Infinity), 'B',
                            OrePrefixes.wireGt04.get(Materials.BlackPlutonium), 'K', ItemList.Casing_Coil_Infinity });

            GT_ModHandler.addCraftingRecipe(
                    CustomItemList.WetTransformer_LV_ULV.get(1L),
                    bitsd,
                    new Object[] { "XOC", "STA", "POC", 'A', OrePrefixes.springSmall.get(Materials.Lead), 'C',
                            OrePrefixes.cableGt16.get(Materials.Lead), 'S', OrePrefixes.spring.get(Materials.Tin), 'X',
                            OrePrefixes.cableGt08.get(Materials.Tin), 'O', OrePrefixes.cell.get(Materials.Lubricant),
                            'P', ItemList.Electric_Pump_LV, 'T',
                            GT_ModHandler.getModItem(GregTech.ID, "gt.blockmachines", 1, 877) });

            GT_ModHandler.addCraftingRecipe(
                    CustomItemList.WetTransformer_MV_LV.get(1L),
                    bitsd,
                    new Object[] { "XOC", "STA", "POC", 'A', OrePrefixes.springSmall.get(Materials.Tin), 'C',
                            OrePrefixes.cableGt16.get(Materials.Tin), 'S', OrePrefixes.spring.get(Materials.AnyCopper),
                            'X', OrePrefixes.cableGt08.get(Materials.AnyCopper), 'O',
                            OrePrefixes.cell.get(Materials.Lubricant), 'P', ItemList.Electric_Pump_LV, 'T',
                            GT_ModHandler.getModItem(GregTech.ID, "gt.blockmachines", 1, 878) });

            GT_ModHandler.addCraftingRecipe(
                    CustomItemList.WetTransformer_HV_MV.get(1L),
                    bitsd,
                    new Object[] { "XOC", "STA", "POC", 'A', OrePrefixes.springSmall.get(Materials.AnyCopper), 'C',
                            OrePrefixes.cableGt16.get(Materials.AnyCopper), 'S', OrePrefixes.spring.get(Materials.Gold),
                            'X', OrePrefixes.cableGt08.get(Materials.Gold), 'O',
                            OrePrefixes.cell.get(Materials.Lubricant), 'P', ItemList.Electric_Pump_LV, 'T',
                            GT_ModHandler.getModItem(GregTech.ID, "gt.blockmachines", 1, 879) });

            GT_ModHandler.addCraftingRecipe(
                    CustomItemList.WetTransformer_EV_HV.get(1L),
                    bitsd,
                    new Object[] { "XOC", "STA", "POC", 'A', OrePrefixes.springSmall.get(Materials.Gold), 'C',
                            OrePrefixes.cableGt16.get(Materials.Gold), 'S', OrePrefixes.spring.get(Materials.Aluminium),
                            'X', OrePrefixes.cableGt08.get(Materials.Aluminium), 'O',
                            OrePrefixes.cell.get(Materials.Lubricant), 'P', ItemList.Electric_Pump_LV, 'T',
                            GT_ModHandler.getModItem(GregTech.ID, "gt.blockmachines", 1, 880) });

            GT_ModHandler.addCraftingRecipe(
                    CustomItemList.WetTransformer_IV_EV.get(1L),
                    bitsd,
                    new Object[] { "XOC", "STA", "POC", 'A', OrePrefixes.springSmall.get(Materials.Aluminium), 'C',
                            OrePrefixes.cableGt16.get(Materials.Aluminium), 'S',
                            OrePrefixes.spring.get(Materials.Tungsten), 'X',
                            OrePrefixes.cableGt08.get(Materials.Tungsten), 'O',
                            OrePrefixes.cell.get(Materials.Lubricant), 'P', ItemList.Electric_Pump_LV, 'T',
                            GT_ModHandler.getModItem(GregTech.ID, "gt.blockmachines", 1, 881) });

            GT_ModHandler.addCraftingRecipe(
                    CustomItemList.WetTransformer_LuV_IV.get(1L),
                    bitsd,
                    new Object[] { "XOC", "STA", "POC", 'A', OrePrefixes.springSmall.get(Materials.Tungsten), 'C',
                            OrePrefixes.cableGt16.get(Materials.Tungsten), 'S',
                            OrePrefixes.spring.get(Materials.VanadiumGallium), 'X',
                            OrePrefixes.cableGt08.get(Materials.VanadiumGallium), 'O',
                            OrePrefixes.cell.get(Materials.Lubricant), 'P', ItemList.Electric_Pump_LV, 'T',
                            GT_ModHandler.getModItem(GregTech.ID, "gt.blockmachines", 1, 882) });

            GT_ModHandler.addCraftingRecipe(
                    CustomItemList.WetTransformer_ZPM_LuV.get(1L),
                    bitsd,
                    new Object[] { "XOC", "STA", "POC", 'A', OrePrefixes.springSmall.get(Materials.VanadiumGallium),
                            'C', OrePrefixes.cableGt16.get(Materials.VanadiumGallium), 'S',
                            OrePrefixes.spring.get(Materials.Naquadah), 'X',
                            OrePrefixes.cableGt08.get(Materials.Naquadah), 'O',
                            OrePrefixes.cell.get(Materials.Lubricant), 'P', ItemList.Electric_Pump_LV, 'T',
                            GT_ModHandler.getModItem(GregTech.ID, "gt.blockmachines", 1, 883) });

            GT_ModHandler.addCraftingRecipe(
                    CustomItemList.WetTransformer_UV_ZPM.get(1L),
                    bitsd,
                    new Object[] { "XOC", "STA", "POC", 'A', OrePrefixes.springSmall.get(Materials.Naquadah), 'C',
                            OrePrefixes.cableGt16.get(Materials.Naquadah), 'S',
                            OrePrefixes.spring.get(Materials.NaquadahAlloy), 'X',
                            OrePrefixes.cableGt08.get(Materials.NaquadahAlloy), 'O',
                            OrePrefixes.cell.get(Materials.Lubricant), 'P', ItemList.Electric_Pump_LV, 'T',
                            GT_ModHandler.getModItem(GregTech.ID, "gt.blockmachines", 1, 884) });

            GT_ModHandler.addCraftingRecipe(
                    CustomItemList.WetTransformer_UHV_UV.get(1L),
                    bitsd,
                    new Object[] { "XOC", "STA", "POC", 'A', OrePrefixes.springSmall.get(Materials.NaquadahAlloy), 'C',
                            OrePrefixes.cableGt16.get(Materials.NaquadahAlloy), 'S',
                            OrePrefixes.spring.get(Materials.Neutronium), 'X',
                            OrePrefixes.wireGt08.get(Materials.Bedrockium), 'O',
                            OrePrefixes.cell.get(Materials.Lubricant), 'P', ItemList.Electric_Pump_LV, 'T',
                            GT_ModHandler.getModItem(GregTech.ID, "gt.blockmachines", 1, 885) });

            GT_ModHandler.addCraftingRecipe(
                    CustomItemList.WetTransformer_UEV_UHV.get(1L),
                    bitsd,
                    new Object[] { "XOC", "STA", "POC", 'A', OrePrefixes.springSmall.get(Materials.Neutronium), 'C',
                            OrePrefixes.wireGt16.get(Materials.SuperconductorUHV), 'S',
                            OrePrefixes.spring.get(Materials.Draconium), 'X',
                            OrePrefixes.wireGt08.get(Materials.Draconium), 'O', ItemList.Reactor_Coolant_He_1, 'P',
                            ItemList.Electric_Pump_MV, 'T', CustomItemList.Transformer_HA_UEV_UHV });

            GT_ModHandler.addCraftingRecipe(
                    CustomItemList.WetTransformer_UIV_UEV.get(1L),
                    bitsd,
                    new Object[] { "XOC", "STA", "POC", 'A', OrePrefixes.springSmall.get(Materials.Draconium), 'C',
                            OrePrefixes.wireGt16.get(Materials.Draconium), 'S',
                            OrePrefixes.spring.get(Materials.BlackPlutonium), 'X',
                            OrePrefixes.wireGt08.get(Materials.NetherStar), 'O', ItemList.Reactor_Coolant_He_3, 'P',
                            ItemList.Electric_Pump_HV, 'T', CustomItemList.Transformer_HA_UIV_UEV });

            GT_ModHandler.addCraftingRecipe(
                    CustomItemList.WetTransformer_UMV_UIV.get(1L),
                    bitsd,
                    new Object[] { "XOC", "STA", "POC", 'A', OrePrefixes.springSmall.get(Materials.BlackPlutonium), 'C',
                            OrePrefixes.wireGt16.get(Materials.NetherStar), 'S',
                            OrePrefixes.spring.get(Materials.Quantium), 'X',
                            OrePrefixes.wireGt08.get(Materials.Quantium), 'O', ItemList.Reactor_Coolant_He_6, 'P',
                            ItemList.Electric_Pump_IV, 'T', CustomItemList.Transformer_HA_UMV_UIV });

            GT_ModHandler.addCraftingRecipe(
                    CustomItemList.WetTransformer_UXV_UMV.get(1L),
                    bitsd,
                    new Object[] { "XOC", "STA", "POC", 'A', OrePrefixes.springSmall.get(MaterialsUEVplus.SpaceTime),
                            'C', OrePrefixes.wireGt16.get(Materials.Quantium), 'S',
                            OrePrefixes.spring.get(Materials.Infinity), 'X',
                            OrePrefixes.wireGt08.get(Materials.BlackPlutonium), 'O', ItemList.Reactor_Coolant_Sp_1, 'P',
                            ItemList.Electric_Pump_LuV, 'T', CustomItemList.Transformer_HA_UXV_UMV });

            GT_ModHandler.addCraftingRecipe(
                    CustomItemList.WetTransformer_MAX_UXV.get(1L),
                    bitsd,
                    new Object[] { "XOC", "STA", "POC", 'A', OrePrefixes.springSmall.get(MaterialsUEVplus.Universium),
                            'C', OrePrefixes.wireGt16.get(Materials.BlackPlutonium), 'S',
                            OrePrefixes.spring.get(MaterialsUEVplus.SpaceTime), 'X',
                            OrePrefixes.wireGt08.get(Materials.Infinity), 'O', ItemList.Reactor_Coolant_Sp_2, 'P',
                            ItemList.Electric_Pump_ZPM, 'T', CustomItemList.Transformer_HA_MAX_UXV });
        }

        ItemStack[] inHatches = { CustomItemList.Hatch_Input_UEV.get(1), CustomItemList.Hatch_Input_UIV.get(1),
                CustomItemList.Hatch_Input_UMV.get(1), CustomItemList.Hatch_Input_UXV.get(1),
                CustomItemList.Hatch_Input_MAX.get(1) };
        ItemStack[] outHatches = { CustomItemList.Hatch_Output_UEV.get(1), CustomItemList.Hatch_Output_UIV.get(1),
                CustomItemList.Hatch_Output_UMV.get(1), CustomItemList.Hatch_Output_UXV.get(1),
                CustomItemList.Hatch_Output_MAX.get(1) };
        ItemStack[][] flInputs = new ItemStack[5][3];
        ItemStack[][] flInputs2 = new ItemStack[5][3];
        ItemStack[] tanks = { ItemList.Super_Tank_HV.get(1L), ItemList.Super_Tank_EV.get(1L),
                ItemList.Super_Tank_IV.get(1L), ItemList.Quantum_Tank_LV.get(1L), ItemList.Quantum_Tank_MV.get(1L),
                ItemList.Quantum_Tank_HV.get(1L), };
        ItemStack[] hulls = { CustomItemList.Hull_UEV.get(1), CustomItemList.Hull_UIV.get(1),
                CustomItemList.Hull_UMV.get(1), CustomItemList.Hull_UXV.get(1), CustomItemList.Hull_MAXV.get(1), };

        for (int i = 0; i < hulls.length; i++) {
            flInputs[i] = new ItemStack[] { hulls[i].copy(), tanks[i].copy(), GT_Utility.getIntegratedCircuit(1) };
            flInputs2[i] = new ItemStack[] { hulls[i].copy(), tanks[i].copy(), GT_Utility.getIntegratedCircuit(2) };
        }

        for (int aTier = 10; aTier < 15; aTier++) {
            GT_Values.RA.stdBuilder().itemInputs(flInputs[aTier - 10]).itemOutputs(inHatches[aTier - 10])
                    .fluidInputs(GT_CoreModSupport.RadoxPolymer.getMolten((long) (2.25 * Math.pow(2, (aTier - 9)))))
                    .duration(24 * SECONDS).eut((int) (30 * Math.pow(4, (aTier - 1)))).addTo(assemblerRecipes);
            GT_Values.RA.stdBuilder().itemInputs(flInputs2[aTier - 10]).itemOutputs(outHatches[aTier - 10])
                    .fluidInputs(GT_CoreModSupport.RadoxPolymer.getMolten((long) (2.25 * Math.pow(2, (aTier - 9)))))
                    .duration(24 * SECONDS).eut((int) (30 * Math.pow(4, (aTier - 1)))).addTo(assemblerRecipes);
        }

    }

    private void registerMachineHulls() {
        CustomItemList.Hull_UEV.set(
                new GT_MetaTileEntity_BasicHull(
                        HULL_UEV.ID,
                        "hull.tier.10",
                        "UEV Machine Hull",
                        10,
                        GT_Loader_MetaTileEntities.imagination).getStackForm(1L));

        CustomItemList.Hull_UIV.set(
                new GT_MetaTileEntity_BasicHull(
                        HULL_UIV.ID,
                        "hull.tier.11",
                        "UIV Machine Hull",
                        11,
                        GT_Loader_MetaTileEntities.imagination).getStackForm(1L));

        CustomItemList.Hull_UMV.set(
                new GT_MetaTileEntity_BasicHull(
                        HULL_UMV.ID,
                        "hull.tier.12",
                        "UMV Machine Hull",
                        12,
                        GT_Loader_MetaTileEntities.imagination).getStackForm(1L));

        CustomItemList.Hull_UXV.set(
                new GT_MetaTileEntity_BasicHull(
                        HULL_UXV.ID,
                        "hull.tier.13",
                        "UXV Machine Hull",
                        13,
                        GT_Loader_MetaTileEntities.imagination).getStackForm(1L));

        CustomItemList.Hull_MAXV.set(
                new GT_MetaTileEntity_BasicHull(
                        HULL_MAX.ID,
                        "hull.tier.14",
                        "MAX Machine Hull",
                        14,
                        GT_Loader_MetaTileEntities.imagination).getStackForm(1L));
    }

    private void registerPlasmaGenerators() {
        CustomItemList.Generator_Plasma_ZPMV.set(
                new GT_MetaTileEntity_PlasmaGenerator(
                        PLASMA_GENERATOR_ZPM.ID,
                        "basicgenerator.plasmagenerator.tier.08",
                        "Plasma Generator Mark IV",
                        7).getStackForm(1L));

        CustomItemList.Generator_Plasma_UV.set(
                new GT_MetaTileEntity_PlasmaGenerator(
                        PLASMA_GENERATOR_UV.ID,
                        "basicgenerator.plasmagenerator.tier.09",
                        "Ultimate Pocket Sun",
                        8).getStackForm(1L));
    }

    private void registerAlloySmelter() {
        CustomItemList.AlloySmelterLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ALLOY_SMELTER_LuV.ID,
                        "basicmachine.alloysmelter.tier.06",
                        "Elite Alloy Smelter",
                        6,
                        MachineType.ALLOY_SMELTER.tooltipDescription(),
                        alloySmelterRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "ALLOY_SMELTER",
                        null).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AlloySmelterLuV.get(1L),
                bitsd,
                new Object[] { "ECE", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getHCoil()});

        CustomItemList.AlloySmelterZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ALLOY_SMELTER_ZPM.ID,
                        "basicmachine.alloysmelter.tier.07",
                        "Elite Alloy Smelter II",
                        7,
                        MachineType.ALLOY_SMELTER.tooltipDescription(),
                        alloySmelterRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "ALLOY_SMELTER",
                        null).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AlloySmelterZPM.get(1L),
                bitsd,new Object[] { "ECE", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getHCoil() });

        CustomItemList.AlloySmelterUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ALLOY_SMELTER_UV.ID,
                        "basicmachine.alloysmelter.tier.08",
                        "Ultimate Alloy Integrator",
                        8,
                        MachineType.ALLOY_SMELTER.tooltipDescription(),
                        alloySmelterRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "ALLOY_SMELTER",
                        null).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AlloySmelterUV.get(1L),
                bitsd,new Object[] { "ECE", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getHCoil() });

        CustomItemList.AlloySmelterUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ALLOY_SMELTER_UHV.ID,
                        "basicmachine.alloysmelter.tier.09",
                        "Epic Alloy Integrator",
                        9,
                        MachineType.ALLOY_SMELTER.tooltipDescription(),
                        alloySmelterRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "ALLOY_SMELTER",
                        null).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AlloySmelterUHV.get(1L),
                bitsd,new Object[] { "ECE", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getHCoil() });

        CustomItemList.AlloySmelterUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ALLOY_SMELTER_UEV.ID,
                        "basicmachine.alloysmelter.tier.10",
                        "Epic Alloy Integrator II",
                        10,
                        MachineType.ALLOY_SMELTER.tooltipDescription(),
                        alloySmelterRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "ALLOY_SMELTER",
                        null).getStackForm(1L));
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AlloySmelterUEV.get(1L),
                bitsd,new Object[] { "ECE", "CMC", "WCW", 'M', CustomItemList.Hull_UEV, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getHCoil() });

        // Nulling recipes for now
        CustomItemList.AlloySmelterUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ALLOY_SMELTER_UIV.ID,
                        "basicmachine.alloysmelter.tier.11",
                        "Epic Alloy Integrator III",
                        11,
                        MachineType.ALLOY_SMELTER.tooltipDescription(),
                        alloySmelterRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "ALLOY_SMELTER",
                        null).getStackForm(1L));
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AlloySmelterUIV.get(1L),
                bitsd,new Object[] { "ECE", "CMC", "WCW", 'M', CustomItemList.Hull_UIV, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getHCoil() });

        CustomItemList.AlloySmelterUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ALLOY_SMELTER_UMV.ID,
                        "basicmachine.alloysmelter.tier.12",
                        "Epic Alloy Integrator IV",
                        12,
                        MachineType.ALLOY_SMELTER.tooltipDescription(),
                        alloySmelterRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "ALLOY_SMELTER",
                        null).getStackForm(1L));
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AlloySmelterUMV.get(1L),
                bitsd,new Object[] { "ECE", "CMC", "WCW", 'M', CustomItemList.Hull_UMV, 'E',
            GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
            GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'C',
            GT_CustomLoader.AdvancedGTMaterials.UMV.getHCoil()});
    }

    private void registerMatterAmplifier() {
        CustomItemList.AmplifabricatorLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MATTER_AMPLIFIER_LuV.ID,
                        "basicmachine.amplifab.tier.06",
                        "Elite Amplifabricator",
                        6,
                        MachineType.MATTER_AMPLIFIER.tooltipDescription(),
                        amplifierRecipes,
                        1,
                        1,
                        1000,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "AMPLIFAB",
                        null).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AmplifabricatorLuV.get(1L),
                bitsd,
                new Object[] { "WPW", "PMP", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable4(), });

        CustomItemList.AmplifabricatorZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MATTER_AMPLIFIER_ZPM.ID,
                        "basicmachine.amplifab.tier.07",
                        "Elite Amplifabricator II",
                        7,
                        MachineType.MATTER_AMPLIFIER.tooltipDescription(),
                        amplifierRecipes,
                        1,
                        1,
                        1000,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "AMPLIFAB",
                        null).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AmplifabricatorZPM.get(1L),
                bitsd,
                new Object[] { "WPW", "PMP", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable4(), });

        CustomItemList.AmplifabricatorUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MATTER_AMPLIFIER_UV.ID,
                        "basicmachine.amplifab.tier.08",
                        "Ultimate Amplicreator",
                        8,
                        MachineType.MATTER_AMPLIFIER.tooltipDescription(),
                        amplifierRecipes,
                        1,
                        1,
                        1000,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "AMPLIFAB",
                        null).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AmplifabricatorUV.get(1L),
                bitsd,
                new Object[] { "WPW", "PMP", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable4(), });

        CustomItemList.AmplifabricatorUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MATTER_AMPLIFIER_UHV.ID,
                        "basicmachine.amplifab.tier.09",
                        "Epic Amplicreator",
                        9,
                        MachineType.MATTER_AMPLIFIER.tooltipDescription(),
                        amplifierRecipes,
                        1,
                        1,
                        1000,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "AMPLIFAB",
                        null).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AmplifabricatorUHV.get(1L),
                bitsd,
                new Object[] { "WPW", "PMP", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable4(), });

        CustomItemList.AmplifabricatorUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MATTER_AMPLIFIER_UEV.ID,
                        "basicmachine.amplifab.tier.10",
                        "Epic Amplicreator II",
                        10,
                        MachineType.MATTER_AMPLIFIER.tooltipDescription(),
                        amplifierRecipes,
                        1,
                        1,
                        1000,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "AMPLIFAB",
                        null).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AmplifabricatorUEV.get(1L),
                bitsd,
                new Object[] { "WPW", "PMP", "CPC", 'M', CustomItemList.Hull_UEV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable4(), });

        CustomItemList.AmplifabricatorUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MATTER_AMPLIFIER_UIV.ID,
                        "basicmachine.amplifab.tier.11",
                        "Epic Amplicreator III",
                        11,
                        MachineType.MATTER_AMPLIFIER.tooltipDescription(),
                        amplifierRecipes,
                        1,
                        1,
                        1000,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "AMPLIFAB",
                        null).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AmplifabricatorUIV.get(1L),
                bitsd,
                new Object[] { "WPW", "PMP", "CPC", 'M', CustomItemList.Hull_UIV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable4(), });

        CustomItemList.AmplifabricatorUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MATTER_AMPLIFIER_UMV.ID,
                        "basicmachine.amplifab.tier.12",
                        "Epic Amplicreator IV",
                        12,
                        MachineType.MATTER_AMPLIFIER.tooltipDescription(),
                        amplifierRecipes,
                        1,
                        1,
                        1000,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "AMPLIFAB",
                        null).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AmplifabricatorUMV.get(1L),
                bitsd,
                new Object[] { "WPW", "PMP", "CPC", 'M', CustomItemList.Hull_UMV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable4(), });
    }

    private void registerAssemblingMachine() {
        CustomItemList.AssemblingMachineLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ASSEMBLING_MACHINE_LuV.ID,
                        "basicmachine.assembler.tier.06",
                        "Elite Assembling Machine",
                        6,
                        MachineType.ASSEMBLER.tooltipDescription(),
                        assemblerRecipes,
                        9,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "ASSEMBLER",
                        null).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AssemblingMachineLuV.get(1L),
                bitsd,
                new Object[] { "ACA", "VMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'A',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.ROBOT_ARM, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() });

        CustomItemList.AssemblingMachineZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ASSEMBLING_MACHINE_ZPM.ID,
                        "basicmachine.assembler.tier.07",
                        "Elite Assembling Machine II",
                        7,
                        MachineType.ASSEMBLER.tooltipDescription(),
                        assemblerRecipes,
                        9,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "ASSEMBLER",
                        null).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AssemblingMachineZPM.get(1L),
                bitsd,
                new Object[] { "ACA", "VMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'A',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.ROBOT_ARM, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() });

        CustomItemList.AssemblingMachineUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ASSEMBLING_MACHINE_UV.ID,
                        "basicmachine.assembler.tier.08",
                        "Ultimate Assembly Constructor",
                        8,
                        MachineType.ASSEMBLER.tooltipDescription(),
                        assemblerRecipes,
                        9,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "ASSEMBLER",
                        null).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AssemblingMachineUV.get(1L),
                bitsd,
                new Object[] { "ACA", "VMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'A',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.ROBOT_ARM, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable() });

        CustomItemList.AssemblingMachineUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ASSEMBLING_MACHINE_UHV.ID,
                        "basicmachine.assembler.tier.09",
                        "Epic Assembly Constructor",
                        9,
                        MachineType.ASSEMBLER.tooltipDescription(),
                        assemblerRecipes,
                        9,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "ASSEMBLER",
                        null).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AssemblingMachineUHV.get(1L),
                bitsd,
                new Object[] { "ACA", "VMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'A',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.ROBOT_ARM, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() });

        CustomItemList.AssemblingMachineUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ASSEMBLING_MACHINE_UEV.ID,
                        "basicmachine.assembler.tier.10",
                        "Epic Assembly Constructor II",
                        10,
                        MachineType.ASSEMBLER.tooltipDescription(),
                        assemblerRecipes,
                        9,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "ASSEMBLER",
                        null).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AssemblingMachineUEV.get(1L),
                bitsd,
                new Object[] { "ACA", "VMV", "WCW", 'M', CustomItemList.Hull_UEV, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'A',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.ROBOT_ARM, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() });

        CustomItemList.AssemblingMachineUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ASSEMBLING_MACHINE_UIV.ID,
                        "basicmachine.assembler.tier.11",
                        "Epic Assembly Constructor III",
                        11,
                        MachineType.ASSEMBLER.tooltipDescription(),
                        assemblerRecipes,
                        9,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "ASSEMBLER",
                        null).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AssemblingMachineUIV.get(1L),
                bitsd,
                new Object[] { "ACA", "VMV", "WCW", 'M', CustomItemList.Hull_UIV, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'A',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.ROBOT_ARM, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() });

        CustomItemList.AssemblingMachineUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ASSEMBLING_MACHINE_UMV.ID,
                        "basicmachine.assembler.tier.12",
                        "Epic Assembly Constructor IV",
                        12,
                        MachineType.ASSEMBLER.tooltipDescription(),
                        assemblerRecipes,
                        9,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "ASSEMBLER",
                        null).getStackForm(1L));

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AssemblingMachineUMV.get(1L),
                bitsd,
                new Object[] { "ACA", "VMV", "WCW", 'M', CustomItemList.Hull_UMV, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'A',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.ROBOT_ARM, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() });
    }

    private void registerAutoclave() {
        CustomItemList.AutoclaveLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        AUTOCLAVE_LuV.ID,
                        "basicmachine.autoclave.tier.06",
                        "Elite Autoclave",
                        6,
                        MachineType.AUTOCLAVE.tooltipDescription(),
                        autoclaveRecipes,
                        2,
                        4,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "AUTOCLAVE",
                        new Object[] { "IGI", "IMI", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'I',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getPlate(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getGlass() }).getStackForm(1L));

        CustomItemList.AutoclaveZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        AUTOCLAVE_ZPM.ID,
                        "basicmachine.autoclave.tier.07",
                        "Elite Autoclave II",
                        7,
                        MachineType.AUTOCLAVE.tooltipDescription(),
                        autoclaveRecipes,
                        2,
                        4,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "AUTOCLAVE",
                        new Object[] { "IGI", "IMI", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'I',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getPlate(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getGlass() }).getStackForm(1L));

        CustomItemList.AutoclaveUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        AUTOCLAVE_UV.ID,
                        "basicmachine.autoclave.tier.08",
                        "Ultimate Pressure Cooker",
                        8,
                        MachineType.AUTOCLAVE.tooltipDescription(),
                        autoclaveRecipes,
                        2,
                        4,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "AUTOCLAVE",
                        new Object[] { "IGI", "IMI", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'I',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getPlate(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getGlass(), }).getStackForm(1L));

        CustomItemList.AutoclaveUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        AUTOCLAVE_UHV.ID,
                        "basicmachine.autoclave.tier.09",
                        "Epic Pressure Cooker",
                        9,
                        MachineType.AUTOCLAVE.tooltipDescription(),
                        autoclaveRecipes,
                        2,
                        4,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "AUTOCLAVE",
                        new Object[] { "IGI", "IMI", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'I',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getPlate(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getGlass(), }).getStackForm(1L));

        CustomItemList.AutoclaveUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        AUTOCLAVE_UEV.ID,
                        "basicmachine.autoclave.tier.10",
                        "Epic Pressure Cooker II",
                        10,
                        MachineType.AUTOCLAVE.tooltipDescription(),
                        autoclaveRecipes,
                        2,
                        4,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "AUTOCLAVE",
                        new Object[] { "IGI", "IMI", "CPC", 'M', CustomItemList.Hull_UEV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'I',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getPlate(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getGlass(), }).getStackForm(1L));

        CustomItemList.AutoclaveUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        AUTOCLAVE_UIV.ID,
                        "basicmachine.autoclave.tier.11",
                        "Epic Pressure Cooker III",
                        11,
                        MachineType.AUTOCLAVE.tooltipDescription(),
                        autoclaveRecipes,
                        2,
                        4,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "AUTOCLAVE",
                        new Object[] { "IGI", "IMI", "CPC", 'M', CustomItemList.Hull_UIV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'I',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getPlate(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getGlass(), }).getStackForm(1L));

        CustomItemList.AutoclaveUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        AUTOCLAVE_UMV.ID,
                        "basicmachine.autoclave.tier.12",
                        "Epic Pressure Cooker IV",
                        12,
                        MachineType.AUTOCLAVE.tooltipDescription(),
                        autoclaveRecipes,
                        2,
                        4,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "AUTOCLAVE",
                        new Object[] { "IGI", "IMI", "CPC", 'M', CustomItemList.Hull_UMV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'I',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getPlate(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getGlass(), }).getStackForm(1L));
    }

    private void registerBendingMachine() {

        CustomItemList.BendingMachineLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        BENDING_MACHINE_LuV.ID,
                        "basicmachine.bender.tier.06",
                        "Elite Bending Machine",
                        6,
                        MachineType.BENDING_MACHINE.tooltipDescription(),
                        benderRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                        SpecialEffects.NONE,
                        "BENDER",
                        new Object[] { "PWP", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() }).getStackForm(1L));

        CustomItemList.BendingMachineZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        BENDING_MACHINE_ZPM.ID,
                        "basicmachine.bender.tier.07",
                        "Elite Bending Machine II",
                        7,
                        MachineType.BENDING_MACHINE.tooltipDescription(),
                        benderRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                        SpecialEffects.NONE,
                        "BENDER",
                        new Object[] { "PWP", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() }).getStackForm(1L));

        CustomItemList.BendingMachineUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        BENDING_MACHINE_UV.ID,
                        "basicmachine.bender.tier.08",
                        "Ultimate Bending Unit",
                        8,
                        MachineType.BENDING_MACHINE.tooltipDescription(),
                        benderRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                        SpecialEffects.NONE,
                        "BENDER",
                        new Object[] { "PWP", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable() }).getStackForm(1L));

        CustomItemList.BendingMachineUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        BENDING_MACHINE_UHV.ID,
                        "basicmachine.bender.tier.09",
                        "Epic Bending Unit",
                        9,
                        MachineType.BENDING_MACHINE.tooltipDescription(),
                        benderRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                        SpecialEffects.NONE,
                        "BENDER",
                        new Object[] { "PWP", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));

        CustomItemList.BendingMachineUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        BENDING_MACHINE_UEV.ID,
                        "basicmachine.bender.tier.10",
                        "Epic Bending Unit II",
                        10,
                        MachineType.BENDING_MACHINE.tooltipDescription(),
                        benderRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                        SpecialEffects.NONE,
                        "BENDER",
                        new Object[] { "PWP", "CMC", "EWE", 'M', CustomItemList.Hull_UEV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        CustomItemList.BendingMachineUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        BENDING_MACHINE_UIV.ID,
                        "basicmachine.bender.tier.11",
                        "Epic Bending Unit III",
                        11,
                        MachineType.BENDING_MACHINE.tooltipDescription(),
                        benderRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                        SpecialEffects.NONE,
                        "BENDER",
                        new Object[] { "PWP", "CMC", "EWE", 'M', CustomItemList.Hull_UIV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));

        CustomItemList.BendingMachineUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        BENDING_MACHINE_UMV.ID,
                        "basicmachine.bender.tier.12",
                        "Epic Bending Unit IV",
                        12,
                        MachineType.BENDING_MACHINE.tooltipDescription(),
                        benderRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                        SpecialEffects.NONE,
                        "BENDER",
                        new Object[] { "PWP", "CMC", "EWE", 'M', CustomItemList.Hull_UMV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));

    }

    private void registerCompressor() {

        CustomItemList.CompressorLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        COMPRESSOR_LuV.ID,
                        "basicmachine.compressor.tier.06",
                        "Elite Compressor",
                        6,
                        MachineType.COMPRESSOR.tooltipDescription(),
                        compressorRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                        SpecialEffects.NONE,
                        "COMPRESSOR",
                        new Object[] { "WCW", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() }).getStackForm(1L));

        CustomItemList.CompressorZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        COMPRESSOR_ZPM.ID,
                        "basicmachine.compressor.tier.07",
                        "Elite Compressor II",
                        7,
                        MachineType.COMPRESSOR.tooltipDescription(),
                        compressorRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                        SpecialEffects.NONE,
                        "COMPRESSOR",
                        new Object[] { "WCW", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() }).getStackForm(1L));

        CustomItemList.CompressorUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        COMPRESSOR_UV.ID,
                        "basicmachine.compressor.tier.08",
                        "Ultimate Matter Constrictor",
                        8,
                        MachineType.COMPRESSOR.tooltipDescription(),
                        compressorRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                        SpecialEffects.NONE,
                        "COMPRESSOR",
                        new Object[] { "WCW", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable() }).getStackForm(1L));

        CustomItemList.CompressorUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        COMPRESSOR_UHV.ID,
                        "basicmachine.compressor.tier.09",
                        "Epic Matter Constrictor",
                        9,
                        MachineType.COMPRESSOR.tooltipDescription(),
                        compressorRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                        SpecialEffects.NONE,
                        "COMPRESSOR",
                        new Object[] { "WCW", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));

        CustomItemList.CompressorUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        COMPRESSOR_UEV.ID,
                        "basicmachine.compressor.tier.10",
                        "Epic Matter Constrictor II",
                        10,
                        MachineType.COMPRESSOR.tooltipDescription(),
                        compressorRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                        SpecialEffects.NONE,
                        "COMPRESSOR",
                        new Object[] { "WCW", "PMP", "WCW", 'M', CustomItemList.Hull_UEV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        CustomItemList.CompressorUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        COMPRESSOR_UIV.ID,
                        "basicmachine.compressor.tier.11",
                        "Epic Matter Constrictor III",
                        11,
                        MachineType.COMPRESSOR.tooltipDescription(),
                        compressorRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                        SpecialEffects.NONE,
                        "COMPRESSOR",
                        new Object[] { "WCW", "PMP", "WCW", 'M', CustomItemList.Hull_UIV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));

        CustomItemList.CompressorUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        COMPRESSOR_UMV.ID,
                        "basicmachine.compressor.tier.12",
                        "Epic Matter Constrictor IV",
                        12,
                        MachineType.COMPRESSOR.tooltipDescription(),
                        compressorRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                        SpecialEffects.NONE,
                        "COMPRESSOR",
                        new Object[] { "WCW", "PMP", "WCW", 'M', CustomItemList.Hull_UMV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));

    }

    private void registerCuttingMachine() {

        CustomItemList.CuttingMachineLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CUTTING_MACHINE_LuV.ID,
                        "basicmachine.cutter.tier.06",
                        "Elite Cutting Machine",
                        6,
                        MachineType.CUTTING_MACHINE.tooltipDescription(),
                        cutterRecipes,
                        2,
                        4,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CUTTER",
                        new Object[] { "WCG", "VMB", "CWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getGlass(), 'B',
                                OreDictNames.craftingDiamondBlade }).getStackForm(1L));

        CustomItemList.CuttingMachineZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CUTTING_MACHINE_ZPM.ID,
                        "basicmachine.cutter.tier.07",
                        "Elite Cutting Machine II",
                        7,
                        MachineType.CUTTING_MACHINE.tooltipDescription(),
                        cutterRecipes,
                        2,
                        4,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CUTTER",
                        new Object[] { "WCG", "VMB", "CWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getGlass(), 'B',
                                OreDictNames.craftingDiamondBlade }).getStackForm(1L));

        CustomItemList.CuttingMachineUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CUTTING_MACHINE_UV.ID,
                        "basicmachine.cutter.tier.08",
                        "Ultimate Object Divider",
                        8,
                        MachineType.CUTTING_MACHINE.tooltipDescription(),
                        cutterRecipes,
                        2,
                        4,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CUTTER",
                        new Object[] { "WCG", "VMB", "CWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getGlass(), 'B',
                                OreDictNames.craftingDiamondBlade }).getStackForm(1L));

        CustomItemList.CuttingMachineUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CUTTING_MACHINE_UHV.ID,
                        "basicmachine.cutter.tier.09",
                        "Epic Object Divider",
                        9,
                        MachineType.CUTTING_MACHINE.tooltipDescription(),
                        cutterRecipes,
                        2,
                        4,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CUTTER",
                        new Object[] { "WCG", "VMB", "CWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getGlass(), 'B',
                                OreDictNames.craftingDiamondBlade }).getStackForm(1L));

        CustomItemList.CuttingMachineUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CUTTING_MACHINE_UEV.ID,
                        "basicmachine.cutter.tier.10",
                        "Epic Object Divider II",
                        10,
                        MachineType.CUTTING_MACHINE.tooltipDescription(),
                        cutterRecipes,
                        2,
                        4,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CUTTER",
                        new Object[] { "WCG", "VMB", "CWE", 'M', CustomItemList.Hull_UEV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getGlass(), 'B',
                                OreDictNames.craftingDiamondBlade }).getStackForm(1L));

        CustomItemList.CuttingMachineUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CUTTING_MACHINE_UIV.ID,
                        "basicmachine.cutter.tier.11",
                        "Epic Object Divider III",
                        11,
                        MachineType.CUTTING_MACHINE.tooltipDescription(),
                        cutterRecipes,
                        2,
                        4,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CUTTER",
                        new Object[] { "WCG", "VMB", "CWE", 'M', CustomItemList.Hull_UIV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getGlass(), 'B',
                                OreDictNames.craftingDiamondBlade }).getStackForm(1L));

        CustomItemList.CuttingMachineUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CUTTING_MACHINE_UMV.ID,
                        "basicmachine.cutter.tier.12",
                        "Epic Object Divider IV",
                        12,
                        MachineType.CUTTING_MACHINE.tooltipDescription(),
                        cutterRecipes,
                        2,
                        4,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CUTTER",
                        new Object[] { "WCG", "VMB", "CWE", 'M', CustomItemList.Hull_UMV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getGlass(), 'B',
                                OreDictNames.craftingDiamondBlade }).getStackForm(1L));

    }

    private void registerDistillery() {

        CustomItemList.DistilleryLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        DISTILLERY_LuV.ID,
                        "basicmachine.distillery.tier.06",
                        "Elite Distillery",
                        6,
                        MachineType.DISTILLERY.tooltipDescription(),
                        distilleryRecipes,
                        1,
                        1,
                        true,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "DISTILLERY",
                        new Object[] { "GBG", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'B',
                                OrePrefixes.pipeMedium.get(Materials.Enderium), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getGlass() }).getStackForm(1L));

        CustomItemList.DistilleryZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        DISTILLERY_ZPM.ID,
                        "basicmachine.distillery.tier.07",
                        "Elite Distillery II",
                        7,
                        MachineType.DISTILLERY.tooltipDescription(),
                        distilleryRecipes,
                        1,
                        1,
                        true,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "DISTILLERY",
                        new Object[] { "GBG", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'B',
                                OrePrefixes.pipeMedium.get(Materials.Naquadah), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getGlass() }).getStackForm(1L));

        CustomItemList.DistilleryUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        DISTILLERY_UV.ID,
                        "basicmachine.distillery.tier.08",
                        "Ultimate Fraction Splitter",
                        8,
                        MachineType.DISTILLERY.tooltipDescription(),
                        distilleryRecipes,
                        1,
                        1,
                        true,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "DISTILLERY",
                        new Object[] { "GBG", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'B',
                                OrePrefixes.pipeMedium.get(Materials.Neutronium), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getGlass() }).getStackForm(1L));

        CustomItemList.DistilleryUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        DISTILLERY_UHV.ID,
                        "basicmachine.distillery.tier.09",
                        "Epic Fraction Splitter",
                        9,
                        MachineType.DISTILLERY.tooltipDescription(),
                        distilleryRecipes,
                        1,
                        1,
                        true,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "DISTILLERY",
                        new Object[] { "GBG", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'B',
                                OrePrefixes.pipeLarge.get(Materials.Neutronium), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getGlass() }).getStackForm(1L));

        CustomItemList.DistilleryUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        DISTILLERY_UEV.ID,
                        "basicmachine.distillery.tier.10",
                        "Epic Fraction Splitter II",
                        10,
                        MachineType.DISTILLERY.tooltipDescription(),
                        distilleryRecipes,
                        1,
                        1,
                        true,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "DISTILLERY",
                        new Object[] { "GBG", "CMC", "WPW", 'M', CustomItemList.Hull_UEV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'B',
                                OrePrefixes.pipeHuge.get(Materials.Neutronium), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getGlass() }).getStackForm(1L));

        CustomItemList.DistilleryUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        DISTILLERY_UIV.ID,
                        "basicmachine.distillery.tier.11",
                        "Epic Fraction Splitter III",
                        11,
                        MachineType.DISTILLERY.tooltipDescription(),
                        distilleryRecipes,
                        1,
                        1,
                        true,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "DISTILLERY",
                        new Object[] { "GBG", "CMC", "WPW", 'M', CustomItemList.Hull_UIV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'B',
                                OrePrefixes.pipeMedium.get(Materials.Infinity), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getGlass() }).getStackForm(1L));

        CustomItemList.DistilleryUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        DISTILLERY_UMV.ID,
                        "basicmachine.distillery.tier.12",
                        "Epic Fraction Splitter IV",
                        12,
                        MachineType.DISTILLERY.tooltipDescription(),
                        distilleryRecipes,
                        1,
                        1,
                        true,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "DISTILLERY",
                        new Object[] { "GBG", "CMC", "WPW", 'M', CustomItemList.Hull_UMV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'B',
                                OrePrefixes.pipeMedium.get(MaterialsUEVplus.SpaceTime), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getGlass() }).getStackForm(1L));

    }

    private void registerElectricFurnace() {

        CustomItemList.ElectricFurnaceLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ELECTRIC_FURNACE_LuV.ID,
                        "basicmachine.e_furnace.tier.06",
                        "Elite Electric Furnace",
                        6,
                        MachineType.ELECTRIC_FURNACE.tooltipDescription(),
                        furnaceRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                        SpecialEffects.NONE,
                        "ELECTRIC_FURNACE",
                        new Object[] { "WCW", "CMC", "ECE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getHCoil() }).getStackForm(1L));

        CustomItemList.ElectricFurnaceZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ELECTRIC_FURNACE_ZPM.ID,
                        "basicmachine.e_furnace.tier.07",
                        "Elite Electric Furnace II",
                        7,
                        MachineType.ELECTRIC_FURNACE.tooltipDescription(),
                        furnaceRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                        SpecialEffects.NONE,
                        "ELECTRIC_FURNACE",
                        new Object[] { "WCW", "CMC", "ECE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getHCoil() }).getStackForm(1L));

        CustomItemList.ElectricFurnaceUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ELECTRIC_FURNACE_UV.ID,
                        "basicmachine.e_furnace.tier.08",
                        "Ultimate Atom Stimulator",
                        8,
                        MachineType.ELECTRIC_FURNACE.tooltipDescription(),
                        furnaceRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                        SpecialEffects.NONE,
                        "ELECTRIC_FURNACE",
                        new Object[] { "WCW", "CMC", "ECE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getHCoil() }).getStackForm(1L));

        CustomItemList.ElectricFurnaceUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ELECTRIC_FURNACE_UHV.ID,
                        "basicmachine.e_furnace.tier.09",
                        "Epic Atom Stimulator",
                        9,
                        MachineType.ELECTRIC_FURNACE.tooltipDescription(),
                        furnaceRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                        SpecialEffects.NONE,
                        "ELECTRIC_FURNACE",
                        new Object[] { "WCW", "CMC", "ECE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getHCoil() }).getStackForm(1L));

        CustomItemList.ElectricFurnaceUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ELECTRIC_FURNACE_UEV.ID,
                        "basicmachine.e_furnace.tier.10",
                        "Epic Atom Stimulator II",
                        10,
                        MachineType.ELECTRIC_FURNACE.tooltipDescription(),
                        furnaceRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                        SpecialEffects.NONE,
                        "ELECTRIC_FURNACE",
                        new Object[] { "WCW", "CMC", "ECE", 'M', CustomItemList.Hull_UEV, 'E',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getHCoil() }).getStackForm(1L));

        CustomItemList.ElectricFurnaceUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ELECTRIC_FURNACE_UIV.ID,
                        "basicmachine.e_furnace.tier.11",
                        "Epic Atom Stimulator III",
                        11,
                        MachineType.ELECTRIC_FURNACE.tooltipDescription(),
                        furnaceRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                        SpecialEffects.NONE,
                        "ELECTRIC_FURNACE",
                        new Object[] { "WCW", "CMC", "ECE", 'M', CustomItemList.Hull_UIV, 'E',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getHCoil() }).getStackForm(1L));

        CustomItemList.ElectricFurnaceUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ELECTRIC_FURNACE_UMV.ID,
                        "basicmachine.e_furnace.tier.12",
                        "Epic Atom Stimulator IV",
                        12,
                        MachineType.ELECTRIC_FURNACE.tooltipDescription(),
                        furnaceRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                        SpecialEffects.NONE,
                        "ELECTRIC_FURNACE",
                        new Object[] { "WCW", "CMC", "ECE", 'M', CustomItemList.Hull_UMV, 'E',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getHCoil() }).getStackForm(1L));

    }

    private void registerElectrolyzer() {

        CustomItemList.ElectrolyzerLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ELECTROLYZER_LuV.ID,
                        "basicmachine.electrolyzer.tier.06",
                        "Elite Electrolyzer",
                        6,
                        MachineType.ELECTROLYZER.tooltipDescription(),
                        electrolyzerRecipes,
                        2,
                        6,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "ELECTROLYZER",
                        new Object[] { "IGI", "IMI", "CWC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'I',
                                OrePrefixes.wireGt02.get(Materials.Osmium), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getGlass() }).getStackForm(1L));

        CustomItemList.ElectrolyzerZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ELECTROLYZER_ZPM.ID,
                        "basicmachine.electrolyzer.tier.07",
                        "Elite Electrolyzer II",
                        7,
                        MachineType.ELECTROLYZER.tooltipDescription(),
                        electrolyzerRecipes,
                        2,
                        6,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "ELECTROLYZER",
                        new Object[] { "IGI", "IMI", "CWC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'I',
                                OrePrefixes.wireGt02.get(Materials.NiobiumTitanium), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getGlass() }).getStackForm(1L));

        CustomItemList.ElectrolyzerUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ELECTROLYZER_UV.ID,
                        "basicmachine.electrolyzer.tier.08",
                        "Ultimate Ionizer",
                        8,
                        MachineType.ELECTROLYZER.tooltipDescription(),
                        electrolyzerRecipes,
                        2,
                        6,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "ELECTROLYZER",
                        new Object[] { "IGI", "IMI", "CWC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'I',
                                OrePrefixes.wireGt04.get(Materials.VanadiumGallium), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getGlass() }).getStackForm(1L));

        CustomItemList.ElectrolyzerUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ELECTROLYZER_UHV.ID,
                        "basicmachine.electrolyzer.tier.09",
                        "Epic Ionizer",
                        9,
                        MachineType.ELECTROLYZER.tooltipDescription(),
                        electrolyzerRecipes,
                        2,
                        6,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "ELECTROLYZER",
                        new Object[] { "IGI", "IMI", "CWC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'I',
                                OrePrefixes.wireGt04.get(Materials.Osmiridium), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getGlass() }).getStackForm(1L));

        CustomItemList.ElectrolyzerUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ELECTROLYZER_UEV.ID,
                        "basicmachine.electrolyzer.tier.10",
                        "Epic Ionizer II",
                        10,
                        MachineType.ELECTROLYZER.tooltipDescription(),
                        electrolyzerRecipes,
                        2,
                        6,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "ELECTROLYZER",
                        new Object[] { "IGI", "IMI", "CWC", 'M', CustomItemList.Hull_UEV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'I',
                                OrePrefixes.wireGt04.get(Materials.Draconium), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getGlass() }).getStackForm(1L));

        CustomItemList.ElectrolyzerUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ELECTROLYZER_UIV.ID,
                        "basicmachine.electrolyzer.tier.11",
                        "Epic Ionizer III",
                        11,
                        MachineType.ELECTROLYZER.tooltipDescription(),
                        electrolyzerRecipes,
                        2,
                        6,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "ELECTROLYZER",
                        new Object[] { "IGI", "IMI", "CWC", 'M', CustomItemList.Hull_UIV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'I',
                                OrePrefixes.wireGt04.get(Materials.DraconiumAwakened), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getGlass() }).getStackForm(1L));

        CustomItemList.ElectrolyzerUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ELECTROLYZER_UMV.ID,
                        "basicmachine.electrolyzer.tier.12",
                        "Epic Ionizer IV",
                        12,
                        MachineType.ELECTROLYZER.tooltipDescription(),
                        electrolyzerRecipes,
                        2,
                        6,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "ELECTROLYZER",
                        new Object[] { "IGI", "IMI", "CWC", 'M', CustomItemList.Hull_UMV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'I',
                                OrePrefixes.wireGt04.get(Materials.Infinity), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getGlass() }).getStackForm(1L));

    }

    private void registerElectromagneticSeparator() {

        CustomItemList.ElectromagneticSeparatorLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ELECTROMAGNETIC_SEPARATOR_LuV.ID,
                        "basicmachine.electromagneticseparator.tier.06",
                        "Elite Electromagnetic Separator",
                        6,
                        MachineType.ELECTROMAGNETIC_SEPARATOR.tooltipDescription(),
                        electroMagneticSeparatorRecipes,
                        1,
                        3,
                        false,
                        SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                        SpecialEffects.NONE,
                        "ELECTROMAGNETIC_SEPARATOR",
                        new Object[] { "VWZ", "WMS", "CWZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getWire(), 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() }).getStackForm(1L));

        CustomItemList.ElectromagneticSeparatorZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ELECTROMAGNETIC_SEPARATOR_ZPM.ID,
                        "basicmachine.electromagneticseparator.tier.07",
                        "Elite Electromagnetic Separator II",
                        7,
                        MachineType.ELECTROMAGNETIC_SEPARATOR.tooltipDescription(),
                        electroMagneticSeparatorRecipes,
                        1,
                        3,
                        false,
                        SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                        SpecialEffects.NONE,
                        "ELECTROMAGNETIC_SEPARATOR",
                        new Object[] { "VWZ", "WMS", "CWZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getWire(), 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() }).getStackForm(1L));

        CustomItemList.ElectromagneticSeparatorUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ELECTROMAGNETIC_SEPARATOR_UV.ID,
                        "basicmachine.electromagneticseparator.tier.08",
                        "Ultimate Magnetar Separator",
                        8,
                        MachineType.ELECTROMAGNETIC_SEPARATOR.tooltipDescription(),
                        electroMagneticSeparatorRecipes,
                        1,
                        3,
                        false,
                        SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                        SpecialEffects.NONE,
                        "ELECTROMAGNETIC_SEPARATOR",
                        new Object[] { "VWZ", "WMS", "CWZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getWire(), 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable() }).getStackForm(1L));

        CustomItemList.ElectromagneticSeparatorUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ELECTROMAGNETIC_SEPARATOR_UHV.ID,
                        "basicmachine.electromagneticseparator.tier.09",
                        "Epic Magnetar Separator",
                        9,
                        MachineType.ELECTROMAGNETIC_SEPARATOR.tooltipDescription(),
                        electroMagneticSeparatorRecipes,
                        1,
                        3,
                        false,
                        SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                        SpecialEffects.NONE,
                        "ELECTROMAGNETIC_SEPARATOR",
                        new Object[] { "VWZ", "WMS", "CWZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getWire(), 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));

        CustomItemList.ElectromagneticSeparatorUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ELECTROMAGNETIC_SEPARATOR_UEV.ID,
                        "basicmachine.electromagneticseparator.tier.10",
                        "Epic Magnetar Separator II",
                        10,
                        MachineType.ELECTROMAGNETIC_SEPARATOR.tooltipDescription(),
                        electroMagneticSeparatorRecipes,
                        1,
                        3,
                        false,
                        SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                        SpecialEffects.NONE,
                        "ELECTROMAGNETIC_SEPARATOR",
                        new Object[] { "VWZ", "WMS", "CWZ", 'M', CustomItemList.Hull_UEV, 'S',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getWire(), 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        CustomItemList.ElectromagneticSeparatorUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ELECTROMAGNETIC_SEPARATOR_UIV.ID,
                        "basicmachine.electromagneticseparator.tier.11",
                        "Epic Magnetar Separator III",
                        11,
                        MachineType.ELECTROMAGNETIC_SEPARATOR.tooltipDescription(),
                        electroMagneticSeparatorRecipes,
                        1,
                        3,
                        false,
                        SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                        SpecialEffects.NONE,
                        "ELECTROMAGNETIC_SEPARATOR",
                        new Object[] { "VWZ", "WMS", "CWZ", 'M', CustomItemList.Hull_UIV, 'S',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getWire(), 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));

        CustomItemList.ElectromagneticSeparatorUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ELECTROMAGNETIC_SEPARATOR_UMV.ID,
                        "basicmachine.electromagneticseparator.tier.12",
                        "Epic Magnetar Separator IV",
                        12,
                        MachineType.ELECTROMAGNETIC_SEPARATOR.tooltipDescription(),
                        electroMagneticSeparatorRecipes,
                        1,
                        3,
                        false,
                        SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                        SpecialEffects.NONE,
                        "ELECTROMAGNETIC_SEPARATOR",
                        new Object[] { "VWZ", "WMS", "CWZ", 'M', CustomItemList.Hull_UMV, 'S',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getWire(), 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));

    }

    private void registerExtractor() {

        CustomItemList.ExtractorLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        EXTRACTOR_LuV.ID,
                        "basicmachine.extractor.tier.06",
                        "Elite Extractor",
                        6,
                        MachineType.EXTRACTOR.tooltipDescription(),
                        extractorRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "EXTRACTOR",
                        new Object[] { "GCG", "EMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getGlass() }).getStackForm(1L));

        CustomItemList.ExtractorZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        EXTRACTOR_ZPM.ID,
                        "basicmachine.extractor.tier.07",
                        "Elite Extractor II",
                        7,
                        MachineType.EXTRACTOR.tooltipDescription(),
                        extractorRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "EXTRACTOR",
                        new Object[] { "GCG", "EMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getGlass() }).getStackForm(1L));

        CustomItemList.ExtractorUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        EXTRACTOR_UV.ID,
                        "basicmachine.extractor.tier.08",
                        "Ultimate Extractinator",
                        8,
                        MachineType.EXTRACTOR.tooltipDescription(),
                        extractorRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "EXTRACTOR",
                        new Object[] { "GCG", "EMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getGlass() }).getStackForm(1L));

        CustomItemList.ExtractorUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        EXTRACTOR_UHV.ID,
                        "basicmachine.extractor.tier.09",
                        "Epic Extractinator",
                        9,
                        MachineType.EXTRACTOR.tooltipDescription(),
                        extractorRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "EXTRACTOR",
                        new Object[] { "GCG", "EMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getGlass() }).getStackForm(1L));

        CustomItemList.ExtractorUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        EXTRACTOR_UEV.ID,
                        "basicmachine.extractor.tier.10",
                        "Epic Extractinator II",
                        10,
                        MachineType.EXTRACTOR.tooltipDescription(),
                        extractorRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "EXTRACTOR",
                        new Object[] { "GCG", "EMP", "WCW", 'M', CustomItemList.Hull_UEV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getGlass() }).getStackForm(1L));

        CustomItemList.ExtractorUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        EXTRACTOR_UIV.ID,
                        "basicmachine.extractor.tier.11",
                        "Epic Extractinator III",
                        11,
                        MachineType.EXTRACTOR.tooltipDescription(),
                        extractorRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "EXTRACTOR",
                        new Object[] { "GCG", "EMP", "WCW", 'M', CustomItemList.Hull_UIV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getGlass() }).getStackForm(1L));

        CustomItemList.ExtractorUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        EXTRACTOR_UMV.ID,
                        "basicmachine.extractor.tier.12",
                        "Epic Extractinator IV",
                        12,
                        MachineType.EXTRACTOR.tooltipDescription(),
                        extractorRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "EXTRACTOR",
                        new Object[] { "GCG", "EMP", "WCW", 'M', CustomItemList.Hull_UMV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getGlass() }).getStackForm(1L));

    }

    private void registerExtruder() {

        CustomItemList.ExtruderLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        EXTRUDER_LuV.ID,
                        "basicmachine.extruder.tier.06",
                        "Elite Extruder",
                        6,
                        MachineType.EXTRUDER.tooltipDescription(),
                        extruderRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "EXTRUDER",
                        new Object[] { "CCE", "XMP", "CCE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'X',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'E',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'P',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getPipe(), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getHCoil() }).getStackForm(1L));

        CustomItemList.ExtruderZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        EXTRUDER_ZPM.ID,
                        "basicmachine.extruder.tier.07",
                        "Elite Extruder II",
                        7,
                        MachineType.EXTRUDER.tooltipDescription(),
                        extruderRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "EXTRUDER",
                        new Object[] { "CCE", "XMP", "CCE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'X',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'E',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'P',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getPipe(), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getHCoil() }).getStackForm(1L));

        CustomItemList.ExtruderUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        EXTRUDER_UV.ID,
                        "basicmachine.extruder.tier.08",
                        "Ultimate Shape Driver",
                        8,
                        MachineType.EXTRUDER.tooltipDescription(),
                        extruderRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "EXTRUDER",
                        new Object[] { "CCE", "XMP", "CCE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'X',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'E',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'P',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getPipe(), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getHCoil() }).getStackForm(1L));

        CustomItemList.ExtruderUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        EXTRUDER_UHV.ID,
                        "basicmachine.extruder.tier.09",
                        "Epic Shape Driver",
                        9,
                        MachineType.EXTRUDER.tooltipDescription(),
                        extruderRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "EXTRUDER",
                        new Object[] { "CCE", "XMP", "CCE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'X',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'E',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'P',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getPipe(), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getHCoil() }).getStackForm(1L));

        CustomItemList.ExtruderUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        EXTRUDER_UEV.ID,
                        "basicmachine.extruder.tier.10",
                        "Epic Shape Driver II",
                        10,
                        MachineType.EXTRUDER.tooltipDescription(),
                        extruderRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "EXTRUDER",
                        new Object[] { "CCE", "XMP", "CCE", 'M', CustomItemList.Hull_UEV, 'X',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'E',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'P',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getPipe(), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getHCoil() }).getStackForm(1L));

        CustomItemList.ExtruderUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        EXTRUDER_UIV.ID,
                        "basicmachine.extruder.tier.11",
                        "Epic Shape Driver III",
                        11,
                        MachineType.EXTRUDER.tooltipDescription(),
                        extruderRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "EXTRUDER",
                        new Object[] { "CCE", "XMP", "CCE", 'M', CustomItemList.Hull_UIV, 'X',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'E',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'P',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getPipe(), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getHCoil() }).getStackForm(1L));

        CustomItemList.ExtruderUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        EXTRUDER_UMV.ID,
                        "basicmachine.extruder.tier.12",
                        "Epic Shape Driver IV",
                        12,
                        MachineType.EXTRUDER.tooltipDescription(),
                        extruderRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "EXTRUDER",
                        new Object[] { "CCE", "XMP", "CCE", 'M', CustomItemList.Hull_UMV, 'X',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'E',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'P',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getPipe(), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getHCoil() }).getStackForm(1L));

    }

    private void registerFluidSolidifier() {

        CustomItemList.FluidSolidifierLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_SOLIDIFIER_LuV.ID,
                        "basicmachine.fluidsolidifier.tier.06",
                        "Elite Fluid Solidifier",
                        6,
                        MachineType.FLUID_SOLIDIFIER.tooltipDescription(),
                        fluidSolidifierRecipes,
                        1,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FLUID_SOLIDIFIER",
                        new Object[] { "PGP", "WMW", "CBC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getGlass(), 'B', OreDictNames.craftingChest })
                                        .getStackForm(1L));

        CustomItemList.FluidSolidifierZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_SOLIDIFIER_ZPM.ID,
                        "basicmachine.fluidsolidifier.tier.07",
                        "Elite Fluid Solidifier II",
                        7,
                        MachineType.FLUID_SOLIDIFIER.tooltipDescription(),
                        fluidSolidifierRecipes,
                        1,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FLUID_SOLIDIFIER",
                        new Object[] { "PGP", "WMW", "CBC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getGlass(), 'B', OreDictNames.craftingChest })
                                        .getStackForm(1L));

        CustomItemList.FluidSolidifierUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_SOLIDIFIER_UV.ID,
                        "basicmachine.fluidsolidifier.tier.08",
                        "Ultimate Fluid Petrificator",
                        8,
                        MachineType.FLUID_SOLIDIFIER.tooltipDescription(),
                        fluidSolidifierRecipes,
                        1,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FLUID_SOLIDIFIER",
                        new Object[] { "PGP", "WMW", "CBC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getGlass(), 'B', OreDictNames.craftingChest })
                                        .getStackForm(1L));

        CustomItemList.FluidSolidifierUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_SOLIDIFIER_UHV.ID,
                        "basicmachine.fluidsolidifier.tier.09",
                        "Epic Fluid Petrificator",
                        9,
                        MachineType.FLUID_SOLIDIFIER.tooltipDescription(),
                        fluidSolidifierRecipes,
                        1,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FLUID_SOLIDIFIER",
                        new Object[] { "PGP", "WMW", "CBC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getGlass(), 'B', OreDictNames.craftingChest })
                                        .getStackForm(1L));

        CustomItemList.FluidSolidifierUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_SOLIDIFIER_UEV.ID,
                        "basicmachine.fluidsolidifier.tier.10",
                        "Epic Fluid Petrificator II",
                        10,
                        MachineType.FLUID_SOLIDIFIER.tooltipDescription(),
                        fluidSolidifierRecipes,
                        1,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FLUID_SOLIDIFIER",
                        new Object[] { "PGP", "WMW", "CBC", 'M', CustomItemList.Hull_UEV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getGlass(), 'B', OreDictNames.craftingChest })
                                        .getStackForm(1L));

        CustomItemList.FluidSolidifierUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_SOLIDIFIER_UIV.ID,
                        "basicmachine.fluidsolidifier.tier.11",
                        "Epic Fluid Petrificator III",
                        11,
                        MachineType.FLUID_SOLIDIFIER.tooltipDescription(),
                        fluidSolidifierRecipes,
                        1,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FLUID_SOLIDIFIER",
                        new Object[] { "PGP", "WMW", "CBC", 'M', CustomItemList.Hull_UIV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getGlass(), 'B', OreDictNames.craftingChest })
                                        .getStackForm(1L));

        CustomItemList.FluidSolidifierUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_SOLIDIFIER_UMV.ID,
                        "basicmachine.fluidsolidifier.tier.12",
                        "Epic Fluid Petrificator IV",
                        12,
                        MachineType.FLUID_SOLIDIFIER.tooltipDescription(),
                        fluidSolidifierRecipes,
                        1,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FLUID_SOLIDIFIER",
                        new Object[] { "PGP", "WMW", "CBC", 'M', CustomItemList.Hull_UMV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'G',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getGlass(), 'B', OreDictNames.craftingChest })
                                        .getStackForm(1L));

    }

    private void registerFormingPress() {

        CustomItemList.FormingPressLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FORMING_PRESS_LuV.ID,
                        "basicmachine.press.tier.06",
                        "Elite Forming Press",
                        6,
                        MachineType.FORMING_PRESS.tooltipDescription(),
                        formingPressRecipes,
                        6,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                        SpecialEffects.NONE,
                        "PRESS",
                        new Object[] { "WPW", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() }).getStackForm(1L));

        CustomItemList.FormingPressZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FORMING_PRESS_ZPM.ID,
                        "basicmachine.press.tier.07",
                        "Elite Forming Press II",
                        7,
                        MachineType.FORMING_PRESS.tooltipDescription(),
                        formingPressRecipes,
                        6,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                        SpecialEffects.NONE,
                        "PRESS",
                        new Object[] { "WPW", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() }).getStackForm(1L));

        CustomItemList.FormingPressUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FORMING_PRESS_UV.ID,
                        "basicmachine.press.tier.08",
                        "Ultimate Surface Shifter",
                        8,
                        MachineType.FORMING_PRESS.tooltipDescription(),
                        formingPressRecipes,
                        6,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                        SpecialEffects.NONE,
                        "PRESS",
                        new Object[] { "WPW", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable() }).getStackForm(1L));

        CustomItemList.FormingPressUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FORMING_PRESS_UHV.ID,
                        "basicmachine.press.tier.09",
                        "Epic Surface Shifter",
                        9,
                        MachineType.FORMING_PRESS.tooltipDescription(),
                        formingPressRecipes,
                        6,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                        SpecialEffects.NONE,
                        "PRESS",
                        new Object[] { "WPW", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));

        CustomItemList.FormingPressUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FORMING_PRESS_UEV.ID,
                        "basicmachine.press.tier.10",
                        "Epic Surface Shifter II",
                        10,
                        MachineType.FORMING_PRESS.tooltipDescription(),
                        formingPressRecipes,
                        6,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                        SpecialEffects.NONE,
                        "PRESS",
                        new Object[] { "WPW", "CMC", "WPW", 'M', CustomItemList.Hull_UEV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        CustomItemList.FormingPressUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FORMING_PRESS_UIV.ID,
                        "basicmachine.press.tier.11",
                        "Epic Surface Shifter III",
                        11,
                        MachineType.FORMING_PRESS.tooltipDescription(),
                        formingPressRecipes,
                        6,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                        SpecialEffects.NONE,
                        "PRESS",
                        new Object[] { "WPW", "CMC", "WPW", 'M', CustomItemList.Hull_UIV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));

        CustomItemList.FormingPressUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FORMING_PRESS_UMV.ID,
                        "basicmachine.press.tier.12",
                        "Epic Surface Shifter IV",
                        12,
                        MachineType.FORMING_PRESS.tooltipDescription(),
                        formingPressRecipes,
                        6,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                        SpecialEffects.NONE,
                        "PRESS",
                        new Object[] { "WPW", "CMC", "WPW", 'M', CustomItemList.Hull_UMV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));

    }

    private void registerForgeHammer() {

        CustomItemList.ForgeHammerLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FORGE_HAMMER_LuV.ID,
                        "basicmachine.hammer.tier.06",
                        "Elite Forge Hammer",
                        6,
                        MachineType.FORGE_HAMMER.tooltipDescription(),
                        hammerRecipes,
                        1,
                        1,
                        true,
                        SoundResource.RANDOM_ANVIL_USE,
                        SpecialEffects.NONE,
                        "HAMMER",
                        new Object[] { "WPW", "CMC", "WAW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'O',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getHCoil(), 'A', OreDictNames.craftingAnvil })
                                        .getStackForm(1L));

        CustomItemList.ForgeHammerZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FORGE_HAMMER_ZPM.ID,
                        "basicmachine.hammer.tier.07",
                        "Elite Forge Hammer II",
                        7,
                        MachineType.FORGE_HAMMER.tooltipDescription(),
                        hammerRecipes,
                        1,
                        1,
                        true,
                        SoundResource.RANDOM_ANVIL_USE,
                        SpecialEffects.NONE,
                        "HAMMER",
                        new Object[] { "WPW", "CMC", "WAW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'O',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getHCoil(), 'A', OreDictNames.craftingAnvil })
                                        .getStackForm(1L));

        CustomItemList.ForgeHammerUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FORGE_HAMMER_UV.ID,
                        "basicmachine.hammer.tier.08",
                        "Ultimate Impact Modulator",
                        8,
                        MachineType.FORGE_HAMMER.tooltipDescription(),
                        hammerRecipes,
                        1,
                        1,
                        true,
                        SoundResource.RANDOM_ANVIL_USE,
                        SpecialEffects.NONE,
                        "HAMMER",
                        new Object[] { "WPW", "CMC", "WAW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'O',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getHCoil(), 'A', OreDictNames.craftingAnvil })
                                        .getStackForm(1L));

        CustomItemList.ForgeHammerUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FORGE_HAMMER_UHV.ID,
                        "basicmachine.hammer.tier.09",
                        "Epic Impact Modulator",
                        9,
                        MachineType.FORGE_HAMMER.tooltipDescription(),
                        hammerRecipes,
                        1,
                        1,
                        true,
                        SoundResource.RANDOM_ANVIL_USE,
                        SpecialEffects.NONE,
                        "HAMMER",
                        new Object[] { "WPW", "CMC", "WAW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'O',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getHCoil(), 'A', OreDictNames.craftingAnvil })
                                        .getStackForm(1L));

        CustomItemList.ForgeHammerUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FORGE_HAMMER_UEV.ID,
                        "basicmachine.hammer.tier.10",
                        "Epic Impact Modulator II",
                        10,
                        MachineType.FORGE_HAMMER.tooltipDescription(),
                        hammerRecipes,
                        1,
                        1,
                        true,
                        SoundResource.RANDOM_ANVIL_USE,
                        SpecialEffects.NONE,
                        "HAMMER",
                        new Object[] { "WPW", "CMC", "WAW", 'M', CustomItemList.Hull_UEV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'O',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getHCoil(), 'A', OreDictNames.craftingAnvil })
                                        .getStackForm(1L));

        CustomItemList.ForgeHammerUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FORGE_HAMMER_UIV.ID,
                        "basicmachine.hammer.tier.11",
                        "Epic Impact Modulator III",
                        11,
                        MachineType.FORGE_HAMMER.tooltipDescription(),
                        hammerRecipes,
                        1,
                        1,
                        true,
                        SoundResource.RANDOM_ANVIL_USE,
                        SpecialEffects.NONE,
                        "HAMMER",
                        new Object[] { "WPW", "CMC", "WAW", 'M', CustomItemList.Hull_UIV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'O',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getHCoil(), 'A', OreDictNames.craftingAnvil })
                                        .getStackForm(1L));

        CustomItemList.ForgeHammerUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FORGE_HAMMER_UMV.ID,
                        "basicmachine.hammer.tier.12",
                        "Epic Impact Modulator IV",
                        12,
                        MachineType.FORGE_HAMMER.tooltipDescription(),
                        hammerRecipes,
                        1,
                        1,
                        true,
                        SoundResource.RANDOM_ANVIL_USE,
                        SpecialEffects.NONE,
                        "HAMMER",
                        new Object[] { "WPW", "CMC", "WAW", 'M', CustomItemList.Hull_UMV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'O',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getHCoil(), 'A', OreDictNames.craftingAnvil })
                                        .getStackForm(1L));

    }

    private void registerLathe() {

        CustomItemList.LatheLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        LATHE_LuV.ID,
                        "basicmachine.lathe.tier.06",
                        "Elite Lathe",
                        6,
                        MachineType.LATHE.tooltipDescription(),
                        latheRecipes,
                        1,
                        2,
                        false,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "LATHE",
                        new Object[] { "WCW", "EMD", "CWP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'D',
                                OreDictNames.craftingIndustrialDiamond }).getStackForm(1L));

        CustomItemList.LatheZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        LATHE_ZPM.ID,
                        "basicmachine.lathe.tier.07",
                        "Elite Lathe II",
                        7,
                        MachineType.LATHE.tooltipDescription(),
                        latheRecipes,
                        1,
                        2,
                        false,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "LATHE",
                        new Object[] { "WCW", "EMD", "CWP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'D',
                                OreDictNames.craftingIndustrialDiamond }).getStackForm(1L));

        CustomItemList.LatheUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        LATHE_UV.ID,
                        "basicmachine.lathe.tier.08",
                        "Ultimate Turn-O-Matic",
                        8,
                        MachineType.LATHE.tooltipDescription(),
                        latheRecipes,
                        1,
                        2,
                        false,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "LATHE",
                        new Object[] { "WCW", "EMD", "CWP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'D',
                                OreDictNames.craftingIndustrialDiamond }).getStackForm(1L));

        CustomItemList.LatheUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        LATHE_UHV.ID,
                        "basicmachine.lathe.tier.09",
                        "Epic Turn-O-Matic",
                        9,
                        MachineType.LATHE.tooltipDescription(),
                        latheRecipes,
                        1,
                        2,
                        false,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "LATHE",
                        new Object[] { "WCW", "EMD", "CWP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'D',
                                OreDictNames.craftingIndustrialDiamond }).getStackForm(1L));

        CustomItemList.LatheUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        LATHE_UEV.ID,
                        "basicmachine.lathe.tier.10",
                        "Epic Turn-O-Matic II",
                        10,
                        MachineType.LATHE.tooltipDescription(),
                        latheRecipes,
                        1,
                        2,
                        false,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "LATHE",
                        new Object[] { "WCW", "EMD", "CWP", 'M', CustomItemList.Hull_UEV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'D',
                                OreDictNames.craftingIndustrialDiamond }).getStackForm(1L));

        CustomItemList.LatheUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        LATHE_UIV.ID,
                        "basicmachine.lathe.tier.11",
                        "Epic Turn-O-Matic III",
                        11,
                        MachineType.LATHE.tooltipDescription(),
                        latheRecipes,
                        1,
                        2,
                        false,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "LATHE",
                        new Object[] { "WCW", "EMD", "CWP", 'M', CustomItemList.Hull_UIV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'D',
                                OreDictNames.craftingIndustrialDiamond }).getStackForm(1L));

        CustomItemList.LatheUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        LATHE_UMV.ID,
                        "basicmachine.lathe.tier.12",
                        "Epic Turn-O-Matic IV",
                        12,
                        MachineType.LATHE.tooltipDescription(),
                        latheRecipes,
                        1,
                        2,
                        false,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "LATHE",
                        new Object[] { "WCW", "EMD", "CWP", 'M', CustomItemList.Hull_UMV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'D',
                                OreDictNames.craftingIndustrialDiamond }).getStackForm(1L));
    }

    private void registerPrecisionLaserEngraver() {

        CustomItemList.PrecisionLaserEngraverLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        PRECISION_LASER_ENGRAVER_LuV.ID,
                        "basicmachine.laserengraver.tier.06",
                        "Elite Precision Laser Engraver",
                        6,
                        MachineType.LASER_ENGRAVER.tooltipDescription(),
                        laserEngraverRecipes,
                        4,
                        1,
                        true,
                        SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                        SpecialEffects.NONE,
                        "LASER_ENGRAVER",
                        new Object[] { "PEP", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() }).getStackForm(1L));

        CustomItemList.PrecisionLaserEngraverZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        PRECISION_LASER_ENGRAVER_ZPM.ID,
                        "basicmachine.laserengraver.tier.07",
                        "Elite Precision Laser Engraver II",
                        7,
                        MachineType.LASER_ENGRAVER.tooltipDescription(),
                        laserEngraverRecipes,
                        4,
                        1,
                        true,
                        SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                        SpecialEffects.NONE,
                        "LASER_ENGRAVER",
                        new Object[] { "PEP", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() }).getStackForm(1L));

        CustomItemList.PrecisionLaserEngraverUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        PRECISION_LASER_ENGRAVER_UV.ID,
                        "basicmachine.laserengraver.tier.08",
                        "Ultimate Exact Photon Cannon",
                        8,
                        MachineType.LASER_ENGRAVER.tooltipDescription(),
                        laserEngraverRecipes,
                        4,
                        1,
                        true,
                        SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                        SpecialEffects.NONE,
                        "LASER_ENGRAVER",
                        new Object[] { "PEP", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable() }).getStackForm(1L));

        CustomItemList.PrecisionLaserEngraverUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        PRECISION_LASER_ENGRAVER_UHV.ID,
                        "basicmachine.laserengraver.tier.09",
                        "Epic Exact Photon Cannon",
                        9,
                        MachineType.LASER_ENGRAVER.tooltipDescription(),
                        laserEngraverRecipes,
                        4,
                        1,
                        true,
                        SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                        SpecialEffects.NONE,
                        "LASER_ENGRAVER",
                        new Object[] { "PEP", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));

        CustomItemList.PrecisionLaserEngraverUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        PRECISION_LASER_ENGRAVER_UEV.ID,
                        "basicmachine.laserengraver.tier.10",
                        "Epic Exact Photon Cannon II",
                        10,
                        MachineType.LASER_ENGRAVER.tooltipDescription(),
                        laserEngraverRecipes,
                        4,
                        1,
                        true,
                        SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                        SpecialEffects.NONE,
                        "LASER_ENGRAVER",
                        new Object[] { "PEP", "CMC", "WCW", 'M', CustomItemList.Hull_UEV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        CustomItemList.PrecisionLaserEngraverUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        PRECISION_LASER_ENGRAVER_UIV.ID,
                        "basicmachine.laserengraver.tier.11",
                        "Epic Exact Photon Cannon III",
                        11,
                        MachineType.LASER_ENGRAVER.tooltipDescription(),
                        laserEngraverRecipes,
                        4,
                        1,
                        true,
                        SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                        SpecialEffects.NONE,
                        "LASER_ENGRAVER",
                        new Object[] { "PEP", "CMC", "WCW", 'M', CustomItemList.Hull_UIV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));

        CustomItemList.PrecisionLaserEngraverUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        PRECISION_LASER_ENGRAVER_UMV.ID,
                        "basicmachine.laserengraver.tier.12",
                        "Epic Exact Photon Cannon IV",
                        12,
                        MachineType.LASER_ENGRAVER.tooltipDescription(),
                        laserEngraverRecipes,
                        4,
                        1,
                        true,
                        SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                        SpecialEffects.NONE,
                        "LASER_ENGRAVER",
                        new Object[] { "PEP", "CMC", "WCW", 'M', CustomItemList.Hull_UMV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));

    }

    private void registerMacerator() {

        CustomItemList.MaceratorLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MACERATOR_LuV.ID,
                        "basicmachine.macerator.tier.06",
                        "Elite Pulverizer",
                        6,
                        MachineType.MACERATOR.tooltipDescription(),
                        maceratorRecipes,
                        1,
                        4,
                        false,
                        SoundResource.IC2_MACHINES_MACERATOR_OP,
                        SpecialEffects.TOP_SMOKE,
                        "PULVERIZER",
                        new Object[] { "PEG", "WWM", "CCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'G', OreDictNames.craftingGrinder })
                                        .getStackForm(1L));

        CustomItemList.MaceratorZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MACERATOR_ZPM.ID,
                        "basicmachine.macerator.tier.07",
                        "Elite Pulverizer II",
                        7,
                        MachineType.MACERATOR.tooltipDescription(),
                        maceratorRecipes,
                        1,
                        4,
                        false,
                        SoundResource.IC2_MACHINES_MACERATOR_OP,
                        SpecialEffects.TOP_SMOKE,
                        "PULVERIZER",
                        new Object[] { "PEG", "WWM", "CCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'G', OreDictNames.craftingGrinder })
                                        .getStackForm(1L));

        CustomItemList.MaceratorUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MACERATOR_UV.ID,
                        "basicmachine.macerator.tier.08",
                        "Ultimate Shape Eliminator",
                        8,
                        MachineType.MACERATOR.tooltipDescription(),
                        maceratorRecipes,
                        1,
                        4,
                        false,
                        SoundResource.IC2_MACHINES_MACERATOR_OP,
                        SpecialEffects.TOP_SMOKE,
                        "PULVERIZER",
                        new Object[] { "PEG", "WWM", "CCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'G', OreDictNames.craftingGrinder })
                                        .getStackForm(1L));

        CustomItemList.MaceratorUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MACERATOR_UHV.ID,
                        "basicmachine.macerator.tier.09",
                        "Epic Shape Eliminator",
                        9,
                        MachineType.MACERATOR.tooltipDescription(),
                        maceratorRecipes,
                        1,
                        4,
                        false,
                        SoundResource.IC2_MACHINES_MACERATOR_OP,
                        SpecialEffects.TOP_SMOKE,
                        "PULVERIZER",
                        new Object[] { "PEG", "WWM", "CCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'G', OreDictNames.craftingGrinder })
                                        .getStackForm(1L));

        CustomItemList.MaceratorUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MACERATOR_UEV.ID,
                        "basicmachine.macerator.tier.10",
                        "Epic Shape Eliminator II",
                        10,
                        MachineType.MACERATOR.tooltipDescription(),
                        maceratorRecipes,
                        1,
                        4,
                        false,
                        SoundResource.IC2_MACHINES_MACERATOR_OP,
                        SpecialEffects.TOP_SMOKE,
                        "PULVERIZER",
                        new Object[] { "PEG", "WWM", "CCW", 'M', CustomItemList.Hull_UEV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'G', OreDictNames.craftingGrinder })
                                        .getStackForm(1L));

        CustomItemList.MaceratorUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MACERATOR_UIV.ID,
                        "basicmachine.macerator.tier.11",
                        "Epic Shape Eliminator III",
                        11,
                        MachineType.MACERATOR.tooltipDescription(),
                        maceratorRecipes,
                        1,
                        4,
                        false,
                        SoundResource.IC2_MACHINES_MACERATOR_OP,
                        SpecialEffects.TOP_SMOKE,
                        "PULVERIZER",
                        new Object[] { "PEG", "WWM", "CCW", 'M', CustomItemList.Hull_UIV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'G', OreDictNames.craftingGrinder })
                                        .getStackForm(1L));

        CustomItemList.MaceratorUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MACERATOR_UMV.ID,
                        "basicmachine.macerator.tier.12",
                        "Epic Shape Eliminator IV",
                        12,
                        MachineType.MACERATOR.tooltipDescription(),
                        maceratorRecipes,
                        1,
                        4,
                        false,
                        SoundResource.IC2_MACHINES_MACERATOR_OP,
                        SpecialEffects.TOP_SMOKE,
                        "PULVERIZER",
                        new Object[] { "PEG", "WWM", "CCW", 'M', CustomItemList.Hull_UMV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'G', OreDictNames.craftingGrinder })
                                        .getStackForm(1L));

    }

    private void registerMatterFabricator() {

        CustomItemList.MassFabricatorLuV.set(
                new GT_MetaTileEntity_Massfabricator(
                        MATTER_FABRICATOR_LuV.ID,
                        "basicmachine.massfab.tier.06",
                        "Elite Mass Fabricator",
                        6).getStackForm(1L));
        CustomItemList.MassFabricatorZPM.set(
                new GT_MetaTileEntity_Massfabricator(
                        MATTER_FABRICATOR_ZPM.ID,
                        "basicmachine.massfab.tier.07",
                        "Elite Mass Fabricator II",
                        7).getStackForm(1L));
        CustomItemList.MassFabricatorUV.set(
                new GT_MetaTileEntity_Massfabricator(
                        MATTER_FABRICATOR_UV.ID,
                        "basicmachine.massfab.tier.08",
                        "Ultimate Existence Initiator",
                        8).getStackForm(1L));
        CustomItemList.MassFabricatorUHV.set(
                new GT_MetaTileEntity_Massfabricator(
                        MATTER_FABRICATOR_UHV.ID,
                        "basicmachine.massfab.tier.09",
                        "Epic Existence Initiator",
                        9).getStackForm(1L));
        CustomItemList.MassFabricatorUEV.set(
                new GT_MetaTileEntity_Massfabricator(
                        MATTER_FABRICATOR_UEV.ID,
                        "basicmachine.massfab.tier.10",
                        "Epic Existence Initiator II",
                        10).getStackForm(1L));
        CustomItemList.MassFabricatorUIV.set(
                new GT_MetaTileEntity_Massfabricator(
                        MATTER_FABRICATOR_UIV.ID,
                        "basicmachine.massfab.tier.11",
                        "Epic Existence Initiator III",
                        11).getStackForm(1L));
        CustomItemList.MassFabricatorUMV.set(
                new GT_MetaTileEntity_Massfabricator(
                        MATTER_FABRICATOR_UMV.ID,
                        "basicmachine.massfab.tier.12",
                        "Epic Existence Initiator IV",
                        12).getStackForm(1L));
    }

    private void registerMicrowave() {

        CustomItemList.MicrowaveLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MICROWAVE_LuV.ID,
                        "basicmachine.microwave.tier.06",
                        "Elite Microwave",
                        6,
                        MachineType.MICROWAVE.tooltipDescription(),
                        microwaveRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                        SpecialEffects.NONE,
                        "MICROWAVE",
                        new Object[] { "LWC", "LMR", "LEC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'R',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'C',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CIRCUIT, 'W',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.WIRE, 'L',
                                OrePrefixes.plateDense.get(Materials.Lead) }).getStackForm(1L));

        CustomItemList.MicrowaveZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MICROWAVE_ZPM.ID,
                        "basicmachine.microwave.tier.07",
                        "Elite Microwave II",
                        7,
                        MachineType.MICROWAVE.tooltipDescription(),
                        microwaveRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                        SpecialEffects.NONE,
                        "MICROWAVE",
                        new Object[] { "LWC", "LMR", "LEC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'R',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'C',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CIRCUIT, 'W',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.WIRE, 'L',
                                OrePrefixes.plateDense.get(Materials.Lead) }).getStackForm(1L));

        CustomItemList.MicrowaveUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MICROWAVE_UV.ID,
                        "basicmachine.microwave.tier.08",
                        "Ultimate UFO Engine",
                        8,
                        MachineType.MICROWAVE.tooltipDescription(),
                        microwaveRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                        SpecialEffects.NONE,
                        "MICROWAVE",
                        new Object[] { "LWC", "LMR", "LEC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'R',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'C',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CIRCUIT, 'W',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.WIRE, 'L',
                                OrePrefixes.plateDense.get(Materials.Lead) }).getStackForm(1L));

        CustomItemList.MicrowaveUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MICROWAVE_UHV.ID,
                        "basicmachine.microwave.tier.09",
                        "Epic UFO Engine",
                        9,
                        MachineType.MICROWAVE.tooltipDescription(),
                        microwaveRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                        SpecialEffects.NONE,
                        "MICROWAVE",
                        new Object[] { "LWC", "LMR", "LEC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'R',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getWire(), 'L',
                                OrePrefixes.plateDense.get(Materials.Lead) }).getStackForm(1L));

        CustomItemList.MicrowaveUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MICROWAVE_UEV.ID,
                        "basicmachine.microwave.tier.10",
                        "Epic UFO Engine II",
                        10,
                        MachineType.MICROWAVE.tooltipDescription(),
                        microwaveRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                        SpecialEffects.NONE,
                        "MICROWAVE",
                        new Object[] { "LWC", "LMR", "LEC", 'M', CustomItemList.Hull_UEV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'R',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getWire(), 'L',
                                OrePrefixes.plateDense.get(Materials.Lead) }).getStackForm(1L));

        CustomItemList.MicrowaveUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MICROWAVE_UIV.ID,
                        "basicmachine.microwave.tier.11",
                        "Epic UFO Engine III",
                        11,
                        MachineType.MICROWAVE.tooltipDescription(),
                        microwaveRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                        SpecialEffects.NONE,
                        "MICROWAVE",
                        new Object[] { "LWC", "LMR", "LEC", 'M', CustomItemList.Hull_UIV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'R',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getWire(), 'L',
                                OrePrefixes.plateDense.get(Materials.Lead) }).getStackForm(1L));

        CustomItemList.MicrowaveUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MICROWAVE_UMV.ID,
                        "basicmachine.microwave.tier.12",
                        "Epic UFO Engine IV",
                        12,
                        MachineType.MICROWAVE.tooltipDescription(),
                        microwaveRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                        SpecialEffects.NONE,
                        "MICROWAVE",
                        new Object[] { "LWC", "LMR", "LEC", 'M', CustomItemList.Hull_UMV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'R',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getWire(), 'L',
                                OrePrefixes.plateDense.get(Materials.Lead) }).getStackForm(1L));

    }

    private void registerOreWashingPlant() {

        CustomItemList.OreWashingPlantLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ORE_WASHING_PLANT_LuV.ID,
                        "basicmachine.orewasher.tier.06",
                        "Elite Ore Washing Plant",
                        6,
                        MachineType.ORE_WASHER.tooltipDescription(),
                        oreWasherRecipes,
                        1,
                        3,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "ORE_WASHER",
                        new Object[] { "RGR", "CEC", "WMW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'R',
                                OrePrefixes.rotor.get(LuVMat2), 'E', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR,
                                'C', GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'G',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP }).getStackForm(1L));

        CustomItemList.OreWashingPlantZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ORE_WASHING_PLANT_ZPM.ID,
                        "basicmachine.orewasher.tier.07",
                        "Elite Ore Washing Plant II",
                        7,
                        MachineType.ORE_WASHER.tooltipDescription(),
                        oreWasherRecipes,
                        1,
                        3,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "ORE_WASHER",
                        new Object[] { "RGR", "CEC", "WMW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'R',
                                OrePrefixes.rotor.get(Materials.Iridium), 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'G',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP }).getStackForm(1L));

        CustomItemList.OreWashingPlantUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ORE_WASHING_PLANT_UV.ID,
                        "basicmachine.orewasher.tier.08",
                        "Ultimate Ore Washing Machine",
                        8,
                        MachineType.ORE_WASHER.tooltipDescription(),
                        oreWasherRecipes,
                        1,
                        3,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "ORE_WASHER",
                        new Object[] { "RGR", "CEC", "WMW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'R',
                                OrePrefixes.rotor.get(Materials.Osmium), 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'G',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP }).getStackForm(1L));

        CustomItemList.OreWashingPlantUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ORE_WASHING_PLANT_UHV.ID,
                        "basicmachine.orewasher.tier.09",
                        "Epic Ore Washing Machine",
                        9,
                        MachineType.ORE_WASHER.tooltipDescription(),
                        oreWasherRecipes,
                        1,
                        3,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "ORE_WASHER",
                        new Object[] { "RGR", "CEC", "WMW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'R',
                                OrePrefixes.rotor.get(Materials.Neutronium), 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'G',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP }).getStackForm(1L));

        CustomItemList.OreWashingPlantUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ORE_WASHING_PLANT_UEV.ID,
                        "basicmachine.orewasher.tier.10",
                        "Epic Ore Washing Machine II",
                        10,
                        MachineType.ORE_WASHER.tooltipDescription(),
                        oreWasherRecipes,
                        1,
                        3,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "ORE_WASHER",
                        new Object[] { "RGR", "CEC", "WMW", 'M', CustomItemList.Hull_UEV, 'R',
                                OrePrefixes.rotor.get(Materials.CosmicNeutronium), 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'G',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP }).getStackForm(1L));

        CustomItemList.OreWashingPlantUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ORE_WASHING_PLANT_UIV.ID,
                        "basicmachine.orewasher.tier.11",
                        "Epic Ore Washing Machine III",
                        11,
                        MachineType.ORE_WASHER.tooltipDescription(),
                        oreWasherRecipes,
                        1,
                        3,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "ORE_WASHER",
                        new Object[] { "RGR", "CEC", "WMW", 'M', CustomItemList.Hull_UIV, 'R',
                                OrePrefixes.rotor.get(Materials.Infinity), 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'G',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP }).getStackForm(1L));

        CustomItemList.OreWashingPlantUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ORE_WASHING_PLANT_UMV.ID,
                        "basicmachine.orewasher.tier.12",
                        "Epic Ore Washing Machine IV",
                        12,
                        MachineType.ORE_WASHER.tooltipDescription(),
                        oreWasherRecipes,
                        1,
                        3,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "ORE_WASHER",
                        new Object[] { "RGR", "CEC", "WMW", 'M', CustomItemList.Hull_UMV, 'R',
                                OrePrefixes.rotor.get(MaterialsUEVplus.SpaceTime), 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'G',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP }).getStackForm(1L));

    }

    private void registerPolarizer() {

        CustomItemList.PolarizerLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        POLARIZER_LuV.ID,
                        "basicmachine.polarizer.tier.06",
                        "Elite Polarizer",
                        6,
                        MachineType.POLARIZER.tooltipDescription(),
                        polarizerRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                        SpecialEffects.NONE,
                        "POLARIZER",
                        new Object[] { "ZSZ", "WMW", "ZSZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                                OrePrefixes.wireGt02.get(Materials.Osmium), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() }).getStackForm(1L));

        CustomItemList.PolarizerZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        POLARIZER_ZPM.ID,
                        "basicmachine.polarizer.tier.07",
                        "Elite Polarizer II",
                        7,
                        MachineType.POLARIZER.tooltipDescription(),
                        polarizerRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                        SpecialEffects.NONE,
                        "POLARIZER",
                        new Object[] { "ZSZ", "WMW", "ZSZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                                OrePrefixes.wireGt04.get(Materials.Osmium), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() }).getStackForm(1L));

        CustomItemList.PolarizerUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        POLARIZER_UV.ID,
                        "basicmachine.polarizer.tier.08",
                        "Ultimate Magnetism Inducer",
                        8,
                        MachineType.POLARIZER.tooltipDescription(),
                        polarizerRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                        SpecialEffects.NONE,
                        "POLARIZER",
                        new Object[] { "ZSZ", "WMW", "ZSZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                                OrePrefixes.wireGt08.get(Materials.Osmium), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable() }).getStackForm(1L));

        CustomItemList.PolarizerUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        POLARIZER_UHV.ID,
                        "basicmachine.polarizer.tier.09",
                        "Epic Magnetism Inducer",
                        9,
                        MachineType.POLARIZER.tooltipDescription(),
                        polarizerRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                        SpecialEffects.NONE,
                        "POLARIZER",
                        new Object[] { "ZSZ", "WMW", "ZSZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                                OrePrefixes.wireGt08.get(Materials.Osmium), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));

        CustomItemList.PolarizerUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        POLARIZER_UEV.ID,
                        "basicmachine.polarizer.tier.10",
                        "Epic Magnetism Inducer II",
                        10,
                        MachineType.POLARIZER.tooltipDescription(),
                        polarizerRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                        SpecialEffects.NONE,
                        "POLARIZER",
                        new Object[] { "ZSZ", "WMW", "ZSZ", 'M', CustomItemList.Hull_UEV, 'S',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                                OrePrefixes.wireGt08.get(Materials.Osmium), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        CustomItemList.PolarizerUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        POLARIZER_UIV.ID,
                        "basicmachine.polarizer.tier.11",
                        "Epic Magnetism Inducer III",
                        11,
                        MachineType.POLARIZER.tooltipDescription(),
                        polarizerRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                        SpecialEffects.NONE,
                        "POLARIZER",
                        new Object[] { "ZSZ", "WMW", "ZSZ", 'M', CustomItemList.Hull_UIV, 'S',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                                OrePrefixes.wireGt08.get(Materials.Osmium), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));

        CustomItemList.PolarizerUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        POLARIZER_UMV.ID,
                        "basicmachine.polarizer.tier.12",
                        "Epic Magnetism Inducer IV",
                        12,
                        MachineType.POLARIZER.tooltipDescription(),
                        polarizerRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                        SpecialEffects.NONE,
                        "POLARIZER",
                        new Object[] { "ZSZ", "WMW", "ZSZ", 'M', CustomItemList.Hull_UMV, 'S',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                                OrePrefixes.wireGt08.get(Materials.Osmium), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));

    }

    private void registerRecycler() {

        CustomItemList.RecyclerLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        RECYCLER_LuV.ID,
                        "basicmachine.recycler.tier.06",
                        "Elite Recycler",
                        6,
                        MachineType.RECYCLER.tooltipDescription(),
                        recyclerRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_RECYCLER_OP,
                        SpecialEffects.NONE,
                        "RECYCLER",
                        new Object[] { "GCG", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'G',
                                OrePrefixes.dust.get(Materials.NetherStar) }).getStackForm(1L));

        CustomItemList.RecyclerZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        RECYCLER_ZPM.ID,
                        "basicmachine.recycler.tier.07",
                        "Elite Recycler II",
                        7,
                        MachineType.RECYCLER.tooltipDescription(),
                        recyclerRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_RECYCLER_OP,
                        SpecialEffects.NONE,
                        "RECYCLER",
                        new Object[] { "GCG", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'G',
                                OrePrefixes.dust.get(Materials.NetherStar) }).getStackForm(1L));

        CustomItemList.RecyclerUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        RECYCLER_UV.ID,
                        "basicmachine.recycler.tier.08",
                        "Ultimate Scrap-O-Matic",
                        8,
                        MachineType.RECYCLER.tooltipDescription(),
                        recyclerRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_RECYCLER_OP,
                        SpecialEffects.NONE,
                        "RECYCLER",
                        new Object[] { "GCG", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'G',
                                OrePrefixes.dust.get(Materials.NetherStar) }).getStackForm(1L));

        CustomItemList.RecyclerUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        RECYCLER_UHV.ID,
                        "basicmachine.recycler.tier.09",
                        "Epic Scrap-O-Matic",
                        9,
                        MachineType.RECYCLER.tooltipDescription(),
                        recyclerRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_RECYCLER_OP,
                        SpecialEffects.NONE,
                        "RECYCLER",
                        new Object[] { "GCG", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'G',
                                OrePrefixes.dust.get(Materials.NetherStar) }).getStackForm(1L));

        CustomItemList.RecyclerUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        RECYCLER_UEV.ID,
                        "basicmachine.recycler.tier.10",
                        "Epic Scrap-O-Matic II",
                        10,
                        MachineType.RECYCLER.tooltipDescription(),
                        recyclerRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_RECYCLER_OP,
                        SpecialEffects.NONE,
                        "RECYCLER",
                        new Object[] { "GCG", "PMP", "WCW", 'M', CustomItemList.Hull_UEV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'G',
                                OrePrefixes.dust.get(Materials.NetherStar) }).getStackForm(1L));

        CustomItemList.RecyclerUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        RECYCLER_UIV.ID,
                        "basicmachine.recycler.tier.11",
                        "Epic Scrap-O-Matic III",
                        11,
                        MachineType.RECYCLER.tooltipDescription(),
                        recyclerRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_RECYCLER_OP,
                        SpecialEffects.NONE,
                        "RECYCLER",
                        new Object[] { "GCG", "PMP", "WCW", 'M', CustomItemList.Hull_UIV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'G',
                                OrePrefixes.dust.get(Materials.NetherStar) }).getStackForm(1L));

        CustomItemList.RecyclerUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        RECYCLER_UMV.ID,
                        "basicmachine.recycler.tier.12",
                        "Epic Scrap-O-Matic IV",
                        12,
                        MachineType.RECYCLER.tooltipDescription(),
                        recyclerRecipes,
                        1,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_RECYCLER_OP,
                        SpecialEffects.NONE,
                        "RECYCLER",
                        new Object[] { "GCG", "PMP", "WCW", 'M', CustomItemList.Hull_UMV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'G',
                                OrePrefixes.dust.get(Materials.NetherStar) }).getStackForm(1L));

    }

    private void registerReplicator() {

        CustomItemList.ReplicatorLuV.set(
                new GT_MetaTileEntity_Replicator(
                        MATTER_REPLICATOR_LuV.ID,
                        "basicmachine.replicator.tier.06",
                        "Elite Replicator",
                        6).getStackForm(1L));
        CustomItemList.ReplicatorZPM.set(
                new GT_MetaTileEntity_Replicator(
                        MATTER_REPLICATOR_ZPM.ID,
                        "basicmachine.replicator.tier.07",
                        "Elite Replicator II",
                        7).getStackForm(1L));
        CustomItemList.ReplicatorUV.set(
                new GT_MetaTileEntity_Replicator(
                        MATTER_REPLICATOR_UV.ID,
                        "basicmachine.replicator.tier.08",
                        "Ultimate Elemental Composer",
                        8).getStackForm(1L));
        CustomItemList.ReplicatorUHV.set(
                new GT_MetaTileEntity_Replicator(
                        MATTER_REPLICATOR_UHV.ID,
                        "basicmachine.replicator.tier.09",
                        "Epic Elemental Composer",
                        9).getStackForm(1L));
        CustomItemList.ReplicatorUEV.set(
                new GT_MetaTileEntity_Replicator(
                        MATTER_REPLICATOR_UEV.ID,
                        "basicmachine.replicator.tier.10",
                        "Epic Elemental Composer II",
                        10).getStackForm(1L));
        CustomItemList.ReplicatorUIV.set(
                new GT_MetaTileEntity_Replicator(
                        MATTER_REPLICATOR_UIV.ID,
                        "basicmachine.replicator.tier.11",
                        "Epic Elemental Composer III",
                        11).getStackForm(1L));
        CustomItemList.ReplicatorUMV.set(
                new GT_MetaTileEntity_Replicator(
                        MATTER_REPLICATOR_UMV.ID,
                        "basicmachine.replicator.tier.12",
                        "Epic Elemental Composer IV",
                        12).getStackForm(1L));
    }

    private void registerScanner() {

        CustomItemList.ScannerLuV.set(
                new GT_MetaTileEntity_Scanner(SCANNER_LuV.ID, "basicmachine.scanner.tier.06", "Elite Scanner", 6)
                        .getStackForm(1L));
        CustomItemList.ScannerZPM.set(
                new GT_MetaTileEntity_Scanner(SCANNER_ZPM.ID, "basicmachine.scanner.tier.07", "Elite Scanner II", 7)
                        .getStackForm(1L));
        CustomItemList.ScannerUV.set(
                new GT_MetaTileEntity_Scanner(
                        SCANNER_UV.ID,
                        "basicmachine.scanner.tier.08",
                        "Ultimate Electron Microscope",
                        8).getStackForm(1L));
        CustomItemList.ScannerUHV.set(
                new GT_MetaTileEntity_Scanner(
                        SCANNER_UHV.ID,
                        "basicmachine.scanner.tier.09",
                        "Epic Electron Microscope",
                        9).getStackForm(1L));
        CustomItemList.ScannerUEV.set(
                new GT_MetaTileEntity_Scanner(
                        SCANNER_UEV.ID,
                        "basicmachine.scanner.tier.10",
                        "Epic Electron Microscope II",
                        10).getStackForm(1L));
        CustomItemList.ScannerUIV.set(
                new GT_MetaTileEntity_Scanner(
                        SCANNER_UIV.ID,
                        "basicmachine.scanner.tier.11",
                        "Epic Electron Microscope III",
                        11).getStackForm(1L));
        CustomItemList.ScannerUMV.set(
                new GT_MetaTileEntity_Scanner(
                        SCANNER_UMV.ID,
                        "basicmachine.scanner.tier.12",
                        "Epic Electron Microscope IV",
                        12).getStackForm(1L));

    }

    private void registerSiftingMachine() {

        CustomItemList.SiftingMachineLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        SIFTING_MACHINE_LuV.ID,
                        "basicmachine.sifter.tier.06",
                        "Elite Sifting Machine",
                        6,
                        MachineType.SIFTER.tooltipDescription(),
                        sifterRecipes,
                        1,
                        9,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "SIFTER",
                        new Object[] { "WFW", "PMP", "CFC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'F', OreDictNames.craftingFilter,
                                'C', GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() }).getStackForm(1L));

        CustomItemList.SiftingMachineZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        SIFTING_MACHINE_ZPM.ID,
                        "basicmachine.sifter.tier.07",
                        "Elite Sifting Machine II",
                        7,
                        MachineType.SIFTER.tooltipDescription(),
                        sifterRecipes,
                        1,
                        9,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "SIFTER",
                        new Object[] { "WFW", "PMP", "CFC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'F', OreDictNames.craftingFilter,
                                'C', GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() }).getStackForm(1L));

        CustomItemList.SiftingMachineUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        SIFTING_MACHINE_UV.ID,
                        "basicmachine.sifter.tier.08",
                        "Ultimate Pulsation Filter",
                        8,
                        MachineType.SIFTER.tooltipDescription(),
                        sifterRecipes,
                        1,
                        9,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "SIFTER",
                        new Object[] { "WFW", "PMP", "CFC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'F', OreDictNames.craftingFilter,
                                'C', GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable() }).getStackForm(1L));

        CustomItemList.SiftingMachineUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        SIFTING_MACHINE_UHV.ID,
                        "basicmachine.sifter.tier.09",
                        "Epic Pulsation Filter",
                        9,
                        MachineType.SIFTER.tooltipDescription(),
                        sifterRecipes,
                        1,
                        9,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "SIFTER",
                        new Object[] { "WFW", "PMP", "CFC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'F', OreDictNames.craftingFilter,
                                'C', GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));

        CustomItemList.SiftingMachineUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        SIFTING_MACHINE_UEV.ID,
                        "basicmachine.sifter.tier.10",
                        "Epic Pulsation Filter II",
                        10,
                        MachineType.SIFTER.tooltipDescription(),
                        sifterRecipes,
                        1,
                        9,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "SIFTER",
                        new Object[] { "WFW", "PMP", "CFC", 'M', CustomItemList.Hull_UEV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'F', OreDictNames.craftingFilter,
                                'C', GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        CustomItemList.SiftingMachineUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        SIFTING_MACHINE_UIV.ID,
                        "basicmachine.sifter.tier.11",
                        "Epic Pulsation Filter III",
                        11,
                        MachineType.SIFTER.tooltipDescription(),
                        sifterRecipes,
                        1,
                        9,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "SIFTER",
                        new Object[] { "WFW", "PMP", "CFC", 'M', CustomItemList.Hull_UIV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'F', OreDictNames.craftingFilter,
                                'C', GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));

        CustomItemList.SiftingMachineUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        SIFTING_MACHINE_UMV.ID,
                        "basicmachine.sifter.tier.12",
                        "Epic Pulsation Filter IV",
                        12,
                        MachineType.SIFTER.tooltipDescription(),
                        sifterRecipes,
                        1,
                        9,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "SIFTER",
                        new Object[] { "WFW", "PMP", "CFC", 'M', CustomItemList.Hull_UMV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'F', OreDictNames.craftingFilter,
                                'C', GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));

    }

    private void registerSlicingMachine() {

        CustomItemList.SlicingMachineLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        SLICING_MACHINE_LuV.ID,
                        "basicmachine.slicer.tier.06",
                        "Elite Slicing Machine",
                        6,
                        MachineType.SLICER.tooltipDescription(),
                        slicerRecipes,
                        2,
                        1,
                        false,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "SLICER",
                        new Object[] { "WCW", "PMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() }).getStackForm(1L));

        CustomItemList.SlicingMachineZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        SLICING_MACHINE_ZPM.ID,
                        "basicmachine.slicer.tier.07",
                        "Elite Slicing Machine II",
                        7,
                        MachineType.SLICER.tooltipDescription(),
                        slicerRecipes,
                        2,
                        1,
                        false,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "SLICER",
                        new Object[] { "WCW", "PMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() }).getStackForm(1L));

        CustomItemList.SlicingMachineUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        SLICING_MACHINE_UV.ID,
                        "basicmachine.slicer.tier.08",
                        "Ultimate Quantum Slicer",
                        8,
                        MachineType.SLICER.tooltipDescription(),
                        slicerRecipes,
                        2,
                        1,
                        false,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "SLICER",
                        new Object[] { "WCW", "PMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable() }).getStackForm(1L));

        CustomItemList.SlicingMachineUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        SLICING_MACHINE_UHV.ID,
                        "basicmachine.slicer.tier.09",
                        "Epic Quantum Slicer",
                        9,
                        MachineType.SLICER.tooltipDescription(),
                        slicerRecipes,
                        2,
                        1,
                        false,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "SLICER",
                        new Object[] { "WCW", "PMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));

        CustomItemList.SlicingMachineUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        SLICING_MACHINE_UEV.ID,
                        "basicmachine.slicer.tier.10",
                        "Epic Quantum Slicer II",
                        10,
                        MachineType.SLICER.tooltipDescription(),
                        slicerRecipes,
                        2,
                        1,
                        false,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "SLICER",
                        new Object[] { "WCW", "PMV", "WCW", 'M', CustomItemList.Hull_UEV.get(1), 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        CustomItemList.SlicingMachineUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        SLICING_MACHINE_UIV.ID,
                        "basicmachine.slicer.tier.11",
                        "Epic Quantum Slicer III",
                        11,
                        MachineType.SLICER.tooltipDescription(),
                        slicerRecipes,
                        2,
                        1,
                        false,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "SLICER",
                        new Object[] { "WCW", "PMV", "WCW", 'M', CustomItemList.Hull_UIV.get(1), 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));

        CustomItemList.SlicingMachineUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        SLICING_MACHINE_UMV.ID,
                        "basicmachine.slicer.tier.12",
                        "Epic Quantum Slicer IV",
                        12,
                        MachineType.SLICER.tooltipDescription(),
                        slicerRecipes,
                        2,
                        1,
                        false,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "SLICER",
                        new Object[] { "WCW", "PMV", "WCW", 'M', CustomItemList.Hull_UMV.get(1), 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));

    }

    private void registerThermalCentrifuge() {

        CustomItemList.ThermalCentrifugeLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        THERMAL_CENTRIFUGE_LuV.ID,
                        "basicmachine.thermalcentrifuge.tier.06",
                        "Elite Thermal Centrifuge",
                        6,
                        MachineType.THERMAL_CENTRIFUGE.tooltipDescription(),
                        thermalCentrifugeRecipes,
                        1,
                        3,
                        false,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "THERMAL_CENTRIFUGE",
                        new Object[] { "CEC", "OMO", "WEW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'O',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getHCoil() }).getStackForm(1L));

        CustomItemList.ThermalCentrifugeZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        THERMAL_CENTRIFUGE_ZPM.ID,
                        "basicmachine.thermalcentrifuge.tier.07",
                        "Elite Thermal Centrifuge II",
                        7,
                        MachineType.THERMAL_CENTRIFUGE.tooltipDescription(),
                        thermalCentrifugeRecipes,
                        1,
                        3,
                        false,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "THERMAL_CENTRIFUGE",
                        new Object[] { "CEC", "OMO", "WEW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'O',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getHCoil() }).getStackForm(1L));

        CustomItemList.ThermalCentrifugeUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        THERMAL_CENTRIFUGE_UV.ID,
                        "basicmachine.thermalcentrifuge.tier.08",
                        "Ultimate Fire Cyclone",
                        8,
                        MachineType.THERMAL_CENTRIFUGE.tooltipDescription(),
                        thermalCentrifugeRecipes,
                        1,
                        3,
                        false,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "THERMAL_CENTRIFUGE",
                        new Object[] { "CEC", "OMO", "WEW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'O',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getHCoil() }).getStackForm(1L));

        CustomItemList.ThermalCentrifugeUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        THERMAL_CENTRIFUGE_UHV.ID,
                        "basicmachine.thermalcentrifuge.tier.09",
                        "Epic Fire Cyclone",
                        9,
                        MachineType.THERMAL_CENTRIFUGE.tooltipDescription(),
                        thermalCentrifugeRecipes,
                        1,
                        3,
                        false,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "THERMAL_CENTRIFUGE",
                        new Object[] { "CEC", "OMO", "WEW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'O',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getHCoil() }).getStackForm(1L));

        CustomItemList.ThermalCentrifugeUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        THERMAL_CENTRIFUGE_UEV.ID,
                        "basicmachine.thermalcentrifuge.tier.10",
                        "Epic Fire Cyclone II",
                        10,
                        MachineType.THERMAL_CENTRIFUGE.tooltipDescription(),
                        thermalCentrifugeRecipes,
                        1,
                        3,
                        false,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "THERMAL_CENTRIFUGE",
                        new Object[] { "CEC", "OMO", "WEW", 'M', CustomItemList.Hull_UEV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'O',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getHCoil() }).getStackForm(1L));

        CustomItemList.ThermalCentrifugeUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        THERMAL_CENTRIFUGE_UIV.ID,
                        "basicmachine.thermalcentrifuge.tier.11",
                        "Epic Fire Cyclone III",
                        11,
                        MachineType.THERMAL_CENTRIFUGE.tooltipDescription(),
                        thermalCentrifugeRecipes,
                        1,
                        3,
                        false,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "THERMAL_CENTRIFUGE",
                        new Object[] { "CEC", "OMO", "WEW", 'M', CustomItemList.Hull_UIV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'O',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getHCoil() }).getStackForm(1L));

        CustomItemList.ThermalCentrifugeUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        THERMAL_CENTRIFUGE_UMV.ID,
                        "basicmachine.thermalcentrifuge.tier.12",
                        "Epic Fire Cyclone IV",
                        12,
                        MachineType.THERMAL_CENTRIFUGE.tooltipDescription(),
                        thermalCentrifugeRecipes,
                        1,
                        3,
                        false,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "THERMAL_CENTRIFUGE",
                        new Object[] { "CEC", "OMO", "WEW", 'M', CustomItemList.Hull_UMV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'O',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getHCoil() }).getStackForm(1L));

    }

    private void registerWiremill() {

        CustomItemList.WiremillLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        WIREMILL_LuV.ID,
                        "basicmachine.wiremill.tier.06",
                        "Elite Wiremill",
                        6,
                        MachineType.WIREMILL.tooltipDescription(),
                        wiremillRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_RECYCLER_OP,
                        SpecialEffects.NONE,
                        "WIREMILL",
                        new Object[] { "EWE", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() }).getStackForm(1L));

        CustomItemList.WiremillZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        WIREMILL_ZPM.ID,
                        "basicmachine.wiremill.tier.07",
                        "Elite Wiremill II",
                        7,
                        MachineType.WIREMILL.tooltipDescription(),
                        wiremillRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_RECYCLER_OP,
                        SpecialEffects.NONE,
                        "WIREMILL",
                        new Object[] { "EWE", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() }).getStackForm(1L));

        CustomItemList.WiremillUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        WIREMILL_UV.ID,
                        "basicmachine.wiremill.tier.08",
                        "Ultimate Wire Transfigurator",
                        8,
                        MachineType.WIREMILL.tooltipDescription(),
                        wiremillRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_RECYCLER_OP,
                        SpecialEffects.NONE,
                        "WIREMILL",
                        new Object[] { "EWE", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable() }).getStackForm(1L));

        CustomItemList.WiremillUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        WIREMILL_UHV.ID,
                        "basicmachine.wiremill.tier.09",
                        "Epic Wire Transfigurator",
                        9,
                        MachineType.WIREMILL.tooltipDescription(),
                        wiremillRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_RECYCLER_OP,
                        SpecialEffects.NONE,
                        "WIREMILL",
                        new Object[] { "EWE", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));

        CustomItemList.WiremillUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        WIREMILL_UEV.ID,
                        "basicmachine.wiremill.tier.10",
                        "Epic Wire Transfigurator II",
                        10,
                        MachineType.WIREMILL.tooltipDescription(),
                        wiremillRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_RECYCLER_OP,
                        SpecialEffects.NONE,
                        "WIREMILL",
                        new Object[] { "EWE", "CMC", "EWE", 'M', CustomItemList.Hull_UEV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        CustomItemList.WiremillUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        WIREMILL_UIV.ID,
                        "basicmachine.wiremill.tier.11",
                        "Epic Wire Transfigurator III",
                        11,
                        MachineType.WIREMILL.tooltipDescription(),
                        wiremillRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_RECYCLER_OP,
                        SpecialEffects.NONE,
                        "WIREMILL",
                        new Object[] { "EWE", "CMC", "EWE", 'M', CustomItemList.Hull_UIV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));

        CustomItemList.WiremillUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        WIREMILL_UMV.ID,
                        "basicmachine.wiremill.tier.12",
                        "Epic Wire Transfigurator IV",
                        12,
                        MachineType.WIREMILL.tooltipDescription(),
                        wiremillRecipes,
                        2,
                        1,
                        false,
                        SoundResource.IC2_MACHINES_RECYCLER_OP,
                        SpecialEffects.NONE,
                        "WIREMILL",
                        new Object[] { "EWE", "CMC", "EWE", 'M', CustomItemList.Hull_UMV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));

    }

    private void registerPump() {

        CustomItemList.PumpLuV.set(
                new GT_MetaTileEntity_Pump(PUMP_LuV.ID, "basicmachine.pump.tier.06", "Lake Dislocator", 6)
                        .getStackForm(1L));
        CustomItemList.PumpZPM.set(
                new GT_MetaTileEntity_Pump(PUMP_ZPM.ID, "basicmachine.pump.tier.07", "Ocean Transposer", 7)
                        .getStackForm(1L));

    }

    private void registerArcFurnace() {

        CustomItemList.ArcFurnaceLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ARC_FURNACE_LuV.ID,
                        "basicmachine.arcfurnace.tier.06",
                        "Elite Arc Furnace",
                        6,
                        MachineType.ARC_FURNACE.tooltipDescription(),
                        arcFurnaceRecipes,
                        1,
                        9,
                        true,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "ARC_FURNACE",
                        new Object[] { "WGW", "CMC", "PPP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                OrePrefixes.plateDouble.get(LuVMat2), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable4(), 'G',
                                OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        CustomItemList.ArcFurnaceZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ARC_FURNACE_ZPM.ID,
                        "basicmachine.arcfurnace.tier.07",
                        "Elite Arc Furnace II",
                        7,
                        MachineType.ARC_FURNACE.tooltipDescription(),
                        arcFurnaceRecipes,
                        1,
                        9,
                        true,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "ARC_FURNACE",
                        new Object[] { "WGW", "CMC", "PPP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                OrePrefixes.plateDouble.get(Materials.Iridium), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable4(), 'G',
                                OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        CustomItemList.ArcFurnaceUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ARC_FURNACE_UV.ID,
                        "basicmachine.arcfurnace.tier.08",
                        "Ultimate Short Circuit Heater",
                        8,
                        MachineType.ARC_FURNACE.tooltipDescription(),
                        arcFurnaceRecipes,
                        1,
                        9,
                        true,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "ARC_FURNACE",
                        new Object[] { "WGW", "CMC", "PPP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                OrePrefixes.plateDouble.get(Materials.Osmium), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable4(), 'G',
                                OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        CustomItemList.ArcFurnaceUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ARC_FURNACE_UHV.ID,
                        "basicmachine.arcfurnace.tier.09",
                        "Epic Short Circuit Heater",
                        9,
                        MachineType.ARC_FURNACE.tooltipDescription(),
                        arcFurnaceRecipes,
                        1,
                        9,
                        true,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "ARC_FURNACE",
                        new Object[] { "WGW", "CMC", "PPP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                OrePrefixes.plateTriple.get(Materials.Osmium), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable4(), 'G',
                                OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        CustomItemList.ArcFurnaceUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ARC_FURNACE_UEV.ID,
                        "basicmachine.arcfurnace.tier.10",
                        "Epic Short Circuit Heater II",
                        10,
                        MachineType.ARC_FURNACE.tooltipDescription(),
                        arcFurnaceRecipes,
                        1,
                        9,
                        true,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "ARC_FURNACE",
                        new Object[] { "WGW", "CMC", "PPP", 'M', CustomItemList.Hull_UEV, 'P',
                                OrePrefixes.plateQuadruple.get(Materials.Osmium), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable4(), 'G',
                                OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        CustomItemList.ArcFurnaceUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ARC_FURNACE_UIV.ID,
                        "basicmachine.arcfurnace.tier.11",
                        "Epic Short Circuit Heater III",
                        11,
                        MachineType.ARC_FURNACE.tooltipDescription(),
                        arcFurnaceRecipes,
                        1,
                        9,
                        true,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "ARC_FURNACE",
                        new Object[] { "WGW", "CMC", "PPP", 'M', CustomItemList.Hull_UIV, 'P',
                                OrePrefixes.plateDouble.get(Materials.Osmiridium), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable4(), 'G',
                                OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        CustomItemList.ArcFurnaceUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        ARC_FURNACE_UMV.ID,
                        "basicmachine.arcfurnace.tier.12",
                        "Epic Short Circuit Heater IV",
                        12,
                        MachineType.ARC_FURNACE.tooltipDescription(),
                        arcFurnaceRecipes,
                        1,
                        9,
                        true,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "ARC_FURNACE",
                        new Object[] { "WGW", "CMC", "PPP", 'M', CustomItemList.Hull_UMV, 'P',
                                OrePrefixes.plateQuadruple.get(Materials.Osmiridium), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable4(), 'G',
                                OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

    }

    private void registerCentrifuge() {

        CustomItemList.CentrifugeLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CENTRIFUGE_LuV.ID,
                        "basicmachine.centrifuge.tier.06",
                        "Elite Centrifuge",
                        6,
                        MachineType.CENTRIFUGE.tooltipDescription(),
                        centrifugeRecipes,
                        2,
                        6,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CENTRIFUGE",
                        new Object[] { "CEC", "WMW", "CEC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() }).getStackForm(1L));

        CustomItemList.CentrifugeZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CENTRIFUGE_ZPM.ID,
                        "basicmachine.centrifuge.tier.07",
                        "Elite Centrifuge II",
                        7,
                        MachineType.CENTRIFUGE.tooltipDescription(),
                        centrifugeRecipes,
                        2,
                        6,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CENTRIFUGE",
                        new Object[] { "CEC", "WMW", "CEC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() }).getStackForm(1L));

        CustomItemList.CentrifugeUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CENTRIFUGE_UV.ID,
                        "basicmachine.centrifuge.tier.08",
                        "Ultimate Molecular Tornado",
                        8,
                        MachineType.CENTRIFUGE.tooltipDescription(),
                        centrifugeRecipes,
                        2,
                        6,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CENTRIFUGE",
                        new Object[] { "CEC", "WMW", "CEC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable() }).getStackForm(1L));

        CustomItemList.CentrifugeUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CENTRIFUGE_UHV.ID,
                        "basicmachine.centrifuge.tier.09",
                        "Epic Molecular Tornado",
                        9,
                        MachineType.CENTRIFUGE.tooltipDescription(),
                        centrifugeRecipes,
                        2,
                        6,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CENTRIFUGE",
                        new Object[] { "CEC", "WMW", "CEC", 'M', ItemList.Hull_MAX, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));

        CustomItemList.CentrifugeUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CENTRIFUGE_UEV.ID,
                        "basicmachine.centrifuge.tier.10",
                        "Epic Molecular Tornado II",
                        10,
                        MachineType.CENTRIFUGE.tooltipDescription(),
                        centrifugeRecipes,
                        2,
                        6,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CENTRIFUGE",
                        new Object[] { "CEC", "WMW", "CEC", 'M', CustomItemList.Hull_UEV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        CustomItemList.CentrifugeUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CENTRIFUGE_UIV.ID,
                        "basicmachine.centrifuge.tier.11",
                        "Epic Molecular Tornado III",
                        11,
                        MachineType.CENTRIFUGE.tooltipDescription(),
                        centrifugeRecipes,
                        2,
                        6,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CENTRIFUGE",
                        new Object[] { "CEC", "WMW", "CEC", 'M', CustomItemList.Hull_UIV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));

        CustomItemList.CentrifugeUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CENTRIFUGE_UMV.ID,
                        "basicmachine.centrifuge.tier.12",
                        "Epic Molecular Tornado IV",
                        12,
                        MachineType.CENTRIFUGE.tooltipDescription(),
                        centrifugeRecipes,
                        2,
                        6,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CENTRIFUGE",
                        new Object[] { "CEC", "WMW", "CEC", 'M', CustomItemList.Hull_UMV, 'E',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));

    }

    private void registerPlasmaArcFurnace() {

        CustomItemList.PlasmaArcFurnaceLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        PLASMA_ARC_FURNACE_LuV.ID,
                        "basicmachine.plasmaarcfurnace.tier.06",
                        "Elite Plasma Arc Furnace",
                        6,
                        MachineType.PLASMA_ARC_FURNACE.tooltipDescription(),
                        plasmaArcFurnaceRecipes,
                        1,
                        9,
                        true,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "PLASMA_ARC_FURNACE",
                        new Object[] { "WGW", "CMC", "TPT", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                OrePrefixes.plateDouble.get(LuVMat2), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable4(), 'T',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'G',
                                OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        CustomItemList.PlasmaArcFurnaceZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        PLASMA_ARC_FURNACE_ZPM.ID,
                        "basicmachine.plasmaarcfurnace.tier.07",
                        "Elite Plasma Arc Furnace II",
                        7,
                        MachineType.PLASMA_ARC_FURNACE.tooltipDescription(),
                        plasmaArcFurnaceRecipes,
                        1,
                        9,
                        true,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "PLASMA_ARC_FURNACE",
                        new Object[] { "WGW", "CMC", "TPT", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                OrePrefixes.plateDouble.get(Materials.Iridium), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable4(), 'T',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'G',
                                OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        CustomItemList.PlasmaArcFurnaceUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        PLASMA_ARC_FURNACE_UV.ID,
                        "basicmachine.plasmaarcfurnace.tier.08",
                        "Ultimate Plasma Discharge Heater",
                        8,
                        MachineType.PLASMA_ARC_FURNACE.tooltipDescription(),
                        plasmaArcFurnaceRecipes,
                        1,
                        9,
                        true,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "PLASMA_ARC_FURNACE",
                        new Object[] { "WGW", "CMC", "TPT", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                OrePrefixes.plateDouble.get(Materials.Osmium), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable4(), 'T',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'G',
                                OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        CustomItemList.PlasmaArcFurnaceUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        PLASMA_ARC_FURNACE_UHV.ID,
                        "basicmachine.plasmaarcfurnace.tier.09",
                        "Epic Plasma Discharge Heater",
                        9,
                        MachineType.PLASMA_ARC_FURNACE.tooltipDescription(),
                        plasmaArcFurnaceRecipes,
                        1,
                        9,
                        true,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "PLASMA_ARC_FURNACE",
                        new Object[] { "WGW", "CMC", "TPT", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                OrePrefixes.plateTriple.get(Materials.Osmium), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable4(), 'T',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'G',
                                OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        CustomItemList.PlasmaArcFurnaceUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        PLASMA_ARC_FURNACE_UEV.ID,
                        "basicmachine.plasmaarcfurnace.tier.10",
                        "Epic Plasma Discharge Heater II",
                        10,
                        MachineType.PLASMA_ARC_FURNACE.tooltipDescription(),
                        plasmaArcFurnaceRecipes,
                        1,
                        9,
                        true,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "PLASMA_ARC_FURNACE",
                        new Object[] { "WGW", "CMC", "TPT", 'M', CustomItemList.Hull_UEV, 'P',
                                OrePrefixes.plateQuadruple.get(Materials.Osmium), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable4(), 'T',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'G',
                                OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        CustomItemList.PlasmaArcFurnaceUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        PLASMA_ARC_FURNACE_UIV.ID,
                        "basicmachine.plasmaarcfurnace.tier.11",
                        "Epic Plasma Discharge Heater III",
                        11,
                        MachineType.PLASMA_ARC_FURNACE.tooltipDescription(),
                        plasmaArcFurnaceRecipes,
                        1,
                        9,
                        true,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "PLASMA_ARC_FURNACE",
                        new Object[] { "WGW", "CMC", "TPT", 'M', CustomItemList.Hull_UIV, 'P',
                                OrePrefixes.plateDouble.get(Materials.Osmiridium), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable4(), 'T',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'G',
                                OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        CustomItemList.PlasmaArcFurnaceUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        PLASMA_ARC_FURNACE_UMV.ID,
                        "basicmachine.plasmaarcfurnace.tier.12",
                        "Epic Plasma Discharge Heater IV",
                        12,
                        MachineType.PLASMA_ARC_FURNACE.tooltipDescription(),
                        plasmaArcFurnaceRecipes,
                        1,
                        9,
                        true,
                        SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                        SpecialEffects.NONE,
                        "PLASMA_ARC_FURNACE",
                        new Object[] { "WGW", "CMC", "TPT", 'M', CustomItemList.Hull_UMV, 'P',
                                OrePrefixes.plateQuadruple.get(Materials.Osmiridium), 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable4(), 'T',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'G',
                                OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));
    }

    private void registerBrewery() {

        CustomItemList.BreweryLuV.set(
                new GT_MetaTileEntity_PotionBrewer(BREWERY_LuV.ID, "basicmachine.brewery.tier.06", "Elite Brewery", 6)
                        .getStackForm(1L));
        CustomItemList.BreweryZPM.set(
                new GT_MetaTileEntity_PotionBrewer(
                        BREWERY_ZPM.ID,
                        "basicmachine.brewery.tier.07",
                        "Elite Brewery II",
                        7).getStackForm(1L));
        CustomItemList.BreweryUV.set(
                new GT_MetaTileEntity_PotionBrewer(
                        BREWERY_UV.ID,
                        "basicmachine.brewery.tier.08",
                        "Ultimate Brew Rusher",
                        8).getStackForm(1L));
        CustomItemList.BreweryUHV.set(
                new GT_MetaTileEntity_PotionBrewer(
                        BREWERY_UHV.ID,
                        "basicmachine.brewery.tier.09",
                        "Epic Brew Rusher",
                        9).getStackForm(1L));
        CustomItemList.BreweryUEV.set(
                new GT_MetaTileEntity_PotionBrewer(
                        BREWERY_UEV.ID,
                        "basicmachine.brewery.tier.10",
                        "Epic Brew Rusher II",
                        10).getStackForm(1L));
        CustomItemList.BreweryUIV.set(
                new GT_MetaTileEntity_PotionBrewer(
                        BREWERY_UIV.ID,
                        "basicmachine.brewery.tier.11",
                        "Epic Brew Rusher III",
                        11).getStackForm(1L));
        CustomItemList.BreweryUMV.set(
                new GT_MetaTileEntity_PotionBrewer(
                        BREWERY_UMV.ID,
                        "basicmachine.brewery.tier.12",
                        "Epic Brew Rusher IV",
                        12).getStackForm(1L));

    }

    private void registerCanningMachine() {

        CustomItemList.CanningMachineLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CANNING_MACHINE_LuV.ID,
                        "basicmachine.canner.tier.06",
                        "Elite Canning Machine",
                        6,
                        MachineType.CANNER.tooltipDescription(),
                        cannerRecipes,
                        2,
                        2,
                        false,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "CANNER",
                        new Object[] { "WPW", "CMC", "GGG", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'G',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        CustomItemList.CanningMachineZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CANNING_MACHINE_ZPM.ID,
                        "basicmachine.canner.tier.07",
                        "Elite Canning Machine II",
                        7,
                        MachineType.CANNER.tooltipDescription(),
                        cannerRecipes,
                        2,
                        2,
                        false,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "CANNER",
                        new Object[] { "WPW", "CMC", "GGG", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'G',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        CustomItemList.CanningMachineUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CANNING_MACHINE_UV.ID,
                        "basicmachine.canner.tier.08",
                        "Ultimate Can Operator",
                        8,
                        MachineType.CANNER.tooltipDescription(),
                        cannerRecipes,
                        2,
                        2,
                        false,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "CANNER",
                        new Object[] { "WPW", "CMC", "GGG", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'G',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        CustomItemList.CanningMachineUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CANNING_MACHINE_UHV.ID,
                        "basicmachine.canner.tier.09",
                        "Epic Can Operator",
                        9,
                        MachineType.CANNER.tooltipDescription(),
                        cannerRecipes,
                        2,
                        2,
                        false,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "CANNER",
                        new Object[] { "WPW", "CMC", "GGG", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'G',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        CustomItemList.CanningMachineUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CANNING_MACHINE_UEV.ID,
                        "basicmachine.canner.tier.10",
                        "Epic Can Operator II",
                        10,
                        MachineType.CANNER.tooltipDescription(),
                        cannerRecipes,
                        2,
                        2,
                        false,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "CANNER",
                        new Object[] { "WPW", "CMC", "GGG", 'M', CustomItemList.Hull_UEV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'G',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        CustomItemList.CanningMachineUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CANNING_MACHINE_UIV.ID,
                        "basicmachine.canner.tier.11",
                        "Epic Can Operator III",
                        11,
                        MachineType.CANNER.tooltipDescription(),
                        cannerRecipes,
                        2,
                        2,
                        false,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "CANNER",
                        new Object[] { "WPW", "CMC", "GGG", 'M', CustomItemList.Hull_UIV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'G',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        CustomItemList.CanningMachineUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CANNING_MACHINE_UMV.ID,
                        "basicmachine.canner.tier.12",
                        "Epic Can Operator IV",
                        12,
                        MachineType.CANNER.tooltipDescription(),
                        cannerRecipes,
                        2,
                        2,
                        false,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "CANNER",
                        new Object[] { "WPW", "CMC", "GGG", 'M', CustomItemList.Hull_UMV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'G',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

    }

    private void registerChemicalBath() {

        CustomItemList.ChemicalBathLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CHEMICAL_BATH_LuV.ID,
                        "basicmachine.chemicalbath.tier.06",
                        "Elite Chemical Bath",
                        6,
                        MachineType.CHEMICAL_BATH.tooltipDescription(),
                        chemicalBathRecipes,
                        1,
                        3,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CHEMICAL_BATH",
                        new Object[] { "VGW", "PGV", "CMC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'G',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        CustomItemList.ChemicalBathZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CHEMICAL_BATH_ZPM.ID,
                        "basicmachine.chemicalbath.tier.07",
                        "Elite Chemical Bath II",
                        7,
                        MachineType.CHEMICAL_BATH.tooltipDescription(),
                        chemicalBathRecipes,
                        1,
                        3,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CHEMICAL_BATH",
                        new Object[] { "VGW", "PGV", "CMC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'G',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        CustomItemList.ChemicalBathUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CHEMICAL_BATH_UV.ID,
                        "basicmachine.chemicalbath.tier.08",
                        "Ultimate Chemical Dunktron",
                        8,
                        MachineType.CHEMICAL_BATH.tooltipDescription(),
                        chemicalBathRecipes,
                        1,
                        3,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CHEMICAL_BATH",
                        new Object[] { "VGW", "PGV", "CMC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'G',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        CustomItemList.ChemicalBathUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CHEMICAL_BATH_UHV.ID,
                        "basicmachine.chemicalbath.tier.09",
                        "Epic Chemical Dunktron",
                        9,
                        MachineType.CHEMICAL_BATH.tooltipDescription(),
                        chemicalBathRecipes,
                        1,
                        3,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CHEMICAL_BATH",
                        new Object[] { "VGW", "PGV", "CMC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'G',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        CustomItemList.ChemicalBathUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CHEMICAL_BATH_UEV.ID,
                        "basicmachine.chemicalbath.tier.10",
                        "Epic Chemical Dunktron II",
                        10,
                        MachineType.CHEMICAL_BATH.tooltipDescription(),
                        chemicalBathRecipes,
                        1,
                        3,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CHEMICAL_BATH",
                        new Object[] { "VGW", "PGV", "CMC", 'M', CustomItemList.Hull_UEV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'G',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        CustomItemList.ChemicalBathUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CHEMICAL_BATH_UIV.ID,
                        "basicmachine.chemicalbath.tier.11",
                        "Epic Chemical Dunktron III",
                        11,
                        MachineType.CHEMICAL_BATH.tooltipDescription(),
                        chemicalBathRecipes,
                        1,
                        3,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CHEMICAL_BATH",
                        new Object[] { "VGW", "PGV", "CMC", 'M', CustomItemList.Hull_UIV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'G',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        CustomItemList.ChemicalBathUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CHEMICAL_BATH_UMV.ID,
                        "basicmachine.chemicalbath.tier.12",
                        "Epic Chemical Dunktron IV",
                        12,
                        MachineType.CHEMICAL_BATH.tooltipDescription(),
                        chemicalBathRecipes,
                        1,
                        3,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CHEMICAL_BATH",
                        new Object[] { "VGW", "PGV", "CMC", 'M', CustomItemList.Hull_UMV, 'P',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'V',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'G',
                                GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

    }

    private void registerChemicalReactor() {

        CustomItemList.ChemicalReactorLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CHEMICAL_REACTOR_LuV.ID,
                        "basicmachine.chemicalreactor.tier.06",
                        "Elite Chemical Reactor",
                        6,
                        MachineType.CHEMICAL_REACTOR.tooltipDescription(),
                        chemicalReactorRecipes,
                        2,
                        2,
                        true,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "CHEMICAL_REACTOR",
                        null).getStackForm(1L));

        CustomItemList.ChemicalReactorZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CHEMICAL_REACTOR_ZPM.ID,
                        "basicmachine.chemicalreactor.tier.07",
                        "Elite Chemical Reactor II",
                        7,
                        MachineType.CHEMICAL_REACTOR.tooltipDescription(),
                        chemicalReactorRecipes,
                        2,
                        2,
                        true,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "CHEMICAL_REACTOR",
                        null).getStackForm(1L));

        CustomItemList.ChemicalReactorUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CHEMICAL_REACTOR_UV.ID,
                        "basicmachine.chemicalreactor.tier.08",
                        "Ultimate Chemical Perforer",
                        8,
                        MachineType.CHEMICAL_REACTOR.tooltipDescription(),
                        chemicalReactorRecipes,
                        2,
                        2,
                        true,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "CHEMICAL_REACTOR",
                        null).getStackForm(1L));

        CustomItemList.ChemicalReactorUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CHEMICAL_REACTOR_UHV.ID,
                        "basicmachine.chemicalreactor.tier.09",
                        "Epic Chemical Performer",
                        9,
                        MachineType.CHEMICAL_REACTOR.tooltipDescription(),
                        chemicalReactorRecipes,
                        2,
                        2,
                        true,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "CHEMICAL_REACTOR",
                        null).getStackForm(1L));

        CustomItemList.ChemicalReactorUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CHEMICAL_REACTOR_UEV.ID,
                        "basicmachine.chemicalreactor.tier.10",
                        "Epic Chemical Performer II",
                        10,
                        MachineType.CHEMICAL_REACTOR.tooltipDescription(),
                        chemicalReactorRecipes,
                        2,
                        2,
                        true,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "CHEMICAL_REACTOR",
                        null).getStackForm(1L));

        CustomItemList.ChemicalReactorUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CHEMICAL_REACTOR_UIV.ID,
                        "basicmachine.chemicalreactor.tier.11",
                        "Epic Chemical Performer III",
                        11,
                        MachineType.CHEMICAL_REACTOR.tooltipDescription(),
                        chemicalReactorRecipes,
                        2,
                        2,
                        true,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "CHEMICAL_REACTOR",
                        null).getStackForm(1L));

        CustomItemList.ChemicalReactorUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CHEMICAL_REACTOR_UMV.ID,
                        "basicmachine.chemicalreactor.tier.12",
                        "Epic Chemical Performer IV",
                        12,
                        MachineType.CHEMICAL_REACTOR.tooltipDescription(),
                        chemicalReactorRecipes,
                        2,
                        2,
                        true,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "CHEMICAL_REACTOR",
                        null).getStackForm(1L));

    }

    private void registerFermenter() {
        CustomItemList.FermenterLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FERMENTER_LuV.ID,
                        "basicmachine.fermenter.tier.06",
                        "Elite Fermenter",
                        6,
                        MachineType.FERMENTER.tooltipDescription(),
                        fermentingRecipes,
                        1,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FERMENTER",
                        null).getStackForm(1L));

        CustomItemList.FermenterZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FERMENTER_ZPM.ID,
                        "basicmachine.fermenter.tier.07",
                        "Elite Fermenter II",
                        7,
                        MachineType.FERMENTER.tooltipDescription(),
                        fermentingRecipes,
                        1,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FERMENTER",
                        null).getStackForm(1L));

        CustomItemList.FermenterUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FERMENTER_UV.ID,
                        "basicmachine.fermenter.tier.08",
                        "Ultimate Fermentation Hastener",
                        8,
                        MachineType.FERMENTER.tooltipDescription(),
                        fermentingRecipes,
                        1,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FERMENTER",
                        null).getStackForm(1L));

        CustomItemList.FermenterUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FERMENTER_UHV.ID,
                        "basicmachine.fermenter.tier.09",
                        "Epic Fermentation Hastener",
                        9,
                        MachineType.FERMENTER.tooltipDescription(),
                        fermentingRecipes,
                        1,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FERMENTER",
                        null).getStackForm(1L));

        CustomItemList.FermenterUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FERMENTER_UEV.ID,
                        "basicmachine.fermenter.tier.10",
                        "Epic Fermentation Hastener II",
                        10,
                        MachineType.FERMENTER.tooltipDescription(),
                        fermentingRecipes,
                        1,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FERMENTER",
                        null).getStackForm(1L));

        CustomItemList.FermenterUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FERMENTER_UIV.ID,
                        "basicmachine.fermenter.tier.11",
                        "Epic Fermentation Hastener III",
                        11,
                        MachineType.FERMENTER.tooltipDescription(),
                        fermentingRecipes,
                        1,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FERMENTER",
                        null).getStackForm(1L));

        CustomItemList.FermenterUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FERMENTER_UMV.ID,
                        "basicmachine.fermenter.tier.12",
                        "Epic Fermentation Hastener IV",
                        12,
                        MachineType.FERMENTER.tooltipDescription(),
                        fermentingRecipes,
                        1,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FERMENTER",
                        null).getStackForm(1L));
    }

    private void registerFluidCanner() {
        CustomItemList.FluidCannerLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_CANNER_LuV.ID,
                        "basicmachine.fluidcanner.tier.06",
                        "Elite Fluid Canner",
                        6,
                        MachineType.FLUID_CANNER.tooltipDescription(),
                        fluidCannerRecipes,
                        1,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FLUID_CANNER",
                        null).getStackForm(1L));

        CustomItemList.FluidCannerZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_CANNER_ZPM.ID,
                        "basicmachine.fluidcanner.tier.07",
                        "Elite Fluid Canner II",
                        7,
                        MachineType.FLUID_CANNER.tooltipDescription(),
                        fluidCannerRecipes,
                        1,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FLUID_CANNER",
                        null).getStackForm(1L));

        CustomItemList.FluidCannerUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_CANNER_UV.ID,
                        "basicmachine.fluidcanner.tier.08",
                        "Ultimate Liquid Can Actuator",
                        8,
                        MachineType.FLUID_CANNER.tooltipDescription(),
                        fluidCannerRecipes,
                        1,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FLUID_CANNER",
                        null).getStackForm(1L));

        CustomItemList.FluidCannerUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_CANNER_UHV.ID,
                        "basicmachine.fluidcanner.tier.09",
                        "Epic Liquid Can Actuator",
                        9,
                        MachineType.FLUID_CANNER.tooltipDescription(),
                        fluidCannerRecipes,
                        1,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FLUID_CANNER",
                        null).getStackForm(1L));

        CustomItemList.FluidCannerUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_CANNER_UEV.ID,
                        "basicmachine.fluidcanner.tier.10",
                        "Epic Liquid Can Actuator II",
                        10,
                        MachineType.FLUID_CANNER.tooltipDescription(),
                        fluidCannerRecipes,
                        1,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FLUID_CANNER",
                        null).getStackForm(1L));

        CustomItemList.FluidCannerUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_CANNER_UIV.ID,
                        "basicmachine.fluidcanner.tier.11",
                        "Epic Liquid Can Actuator III",
                        11,
                        MachineType.FLUID_CANNER.tooltipDescription(),
                        fluidCannerRecipes,
                        1,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FLUID_CANNER",
                        null).getStackForm(1L));

        CustomItemList.FluidCannerUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_CANNER_UMV.ID,
                        "basicmachine.fluidcanner.tier.12",
                        "Epic Liquid Can Actuator IV",
                        12,
                        MachineType.FLUID_CANNER.tooltipDescription(),
                        fluidCannerRecipes,
                        1,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FLUID_CANNER",
                        null).getStackForm(1L));
    }

    private void registerFluidExtractor() {
        CustomItemList.FluidExtractorLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_EXTRACTOR_LuV.ID,
                        "basicmachine.fluidextractor.tier.06",
                        "Elite Fluid Extractor",
                        6,
                        MachineType.FLUID_EXTRACTOR.tooltipDescription(),
                        fluidExtractionRecipes,
                        1,
                        1,
                        true,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "FLUID_EXTRACTOR",
                        null).getStackForm(1L));

        CustomItemList.FluidExtractorZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_EXTRACTOR_ZPM.ID,
                        "basicmachine.fluidextractor.tier.07",
                        "Elite Fluid Extractor II",
                        7,
                        MachineType.FLUID_EXTRACTOR.tooltipDescription(),
                        fluidExtractionRecipes,
                        1,
                        1,
                        true,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "FLUID_EXTRACTOR",
                        null).getStackForm(1L));

        CustomItemList.FluidExtractorUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_EXTRACTOR_UV.ID,
                        "basicmachine.fluidextractor.tier.08",
                        "Ultimate Liquefying Sucker",
                        8,
                        MachineType.FLUID_EXTRACTOR.tooltipDescription(),
                        fluidExtractionRecipes,
                        1,
                        1,
                        true,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "FLUID_EXTRACTOR",
                        null).getStackForm(1L));

        CustomItemList.FluidExtractorUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_EXTRACTOR_UHV.ID,
                        "basicmachine.fluidextractor.tier.09",
                        "Epic Liquefying Sucker",
                        9,
                        MachineType.FLUID_EXTRACTOR.tooltipDescription(),
                        fluidExtractionRecipes,
                        1,
                        1,
                        true,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "FLUID_EXTRACTOR",
                        null).getStackForm(1L));

        CustomItemList.FluidExtractorUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_EXTRACTOR_UEV.ID,
                        "basicmachine.fluidextractor.tier.10",
                        "Epic Liquefying Sucker II",
                        10,
                        MachineType.FLUID_EXTRACTOR.tooltipDescription(),
                        fluidExtractionRecipes,
                        1,
                        1,
                        true,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "FLUID_EXTRACTOR",
                        null).getStackForm(1L));

        CustomItemList.FluidExtractorUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_EXTRACTOR_UIV.ID,
                        "basicmachine.fluidextractor.tier.11",
                        "Epic Liquefying Sucker III",
                        11,
                        MachineType.FLUID_EXTRACTOR.tooltipDescription(),
                        fluidExtractionRecipes,
                        1,
                        1,
                        true,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "FLUID_EXTRACTOR",
                        null).getStackForm(1L));

        CustomItemList.FluidExtractorUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_EXTRACTOR_UMV.ID,
                        "basicmachine.fluidextractor.tier.12",
                        "Epic Liquefying Sucker IV",
                        12,
                        MachineType.FLUID_EXTRACTOR.tooltipDescription(),
                        fluidExtractionRecipes,
                        1,
                        1,
                        true,
                        SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                        SpecialEffects.NONE,
                        "FLUID_EXTRACTOR",
                        null).getStackForm(1L));
    }

    private void registerFluidHeater() {
        CustomItemList.FluidHeaterLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_HEATER_LuV.ID,
                        "basicmachine.fluidheater.tier.06",
                        "Elite Fluid Heater",
                        6,
                        MachineType.FLUID_HEATER.tooltipDescription(),
                        fluidHeaterRecipes,
                        1,
                        0,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FLUID_HEATER",
                        null).getStackForm(1L));

        CustomItemList.FluidHeaterZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_HEATER_ZPM.ID,
                        "basicmachine.fluidheater.tier.07",
                        "Elite Fluid Heater II",
                        7,
                        MachineType.FLUID_HEATER.tooltipDescription(),
                        fluidHeaterRecipes,
                        1,
                        0,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FLUID_HEATER",
                        null).getStackForm(1L));

        CustomItemList.FluidHeaterUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_HEATER_UV.ID,
                        "basicmachine.fluidheater.tier.08",
                        "Ultimate Heat Infuser",
                        8,
                        MachineType.FLUID_HEATER.tooltipDescription(),
                        fluidHeaterRecipes,
                        1,
                        0,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FLUID_HEATER",
                        null).getStackForm(1L));

        CustomItemList.FluidHeaterUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_HEATER_UHV.ID,
                        "basicmachine.fluidheater.tier.09",
                        "Epic Heat Infuser",
                        9,
                        MachineType.FLUID_HEATER.tooltipDescription(),
                        fluidHeaterRecipes,
                        1,
                        0,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FLUID_HEATER",
                        null).getStackForm(1L));

        CustomItemList.FluidHeaterUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_HEATER_UEV.ID,
                        "basicmachine.fluidheater.tier.10",
                        "Epic Heat Infuser II",
                        10,
                        MachineType.FLUID_HEATER.tooltipDescription(),
                        fluidHeaterRecipes,
                        1,
                        0,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FLUID_HEATER",
                        null).getStackForm(1L));

        CustomItemList.FluidHeaterUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_HEATER_UIV.ID,
                        "basicmachine.fluidheater.tier.11",
                        "Epic Heat Infuser III",
                        11,
                        MachineType.FLUID_HEATER.tooltipDescription(),
                        fluidHeaterRecipes,
                        1,
                        0,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FLUID_HEATER",
                        null).getStackForm(1L));

        CustomItemList.FluidHeaterUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        FLUID_HEATER_UMV.ID,
                        "basicmachine.fluidheater.tier.12",
                        "Epic Heat Infuser IV",
                        12,
                        MachineType.FLUID_HEATER.tooltipDescription(),
                        fluidHeaterRecipes,
                        1,
                        0,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "FLUID_HEATER",
                        null).getStackForm(1L));
    }

    private void registerMixer() {
        CustomItemList.MixerLuV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MIXER_LuV.ID,
                        "basicmachine.mixer.tier.06",
                        "Elite Mixer",
                        6,
                        MachineType.MIXER.tooltipDescription(),
                        mixerRecipes,
                        9,
                        4,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "MIXER",
                        null).getStackForm(1L));

        CustomItemList.MixerZPM.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MIXER_ZPM.ID,
                        "basicmachine.mixer.tier.07",
                        "Elite Mixer II",
                        7,
                        MachineType.MIXER.tooltipDescription(),
                        mixerRecipes,
                        9,
                        4,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "MIXER",
                        null).getStackForm(1L));

        CustomItemList.MixerUV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MIXER_UV.ID,
                        "basicmachine.mixer.tier.08",
                        "Ultimate Matter Organizer",
                        8,
                        MachineType.MIXER.tooltipDescription(),
                        mixerRecipes,
                        9,
                        4,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "MIXER",
                        null).getStackForm(1L));

        CustomItemList.MixerUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MIXER_UHV.ID,
                        "basicmachine.mixer.tier.09",
                        "Epic Matter Organizer",
                        9,
                        MachineType.MIXER.tooltipDescription(),
                        mixerRecipes,
                        9,
                        4,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "MIXER",
                        null).getStackForm(1L));

        CustomItemList.MixerUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MIXER_UEV.ID,
                        "basicmachine.mixer.tier.10",
                        "Epic Matter Organizer II",
                        10,
                        MachineType.MIXER.tooltipDescription(),
                        mixerRecipes,
                        9,
                        4,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "MIXER",
                        null).getStackForm(1L));

        CustomItemList.MixerUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MIXER_UIV.ID,
                        "basicmachine.mixer.tier.11",
                        "Epic Matter Organizer III",
                        11,
                        MachineType.MIXER.tooltipDescription(),
                        mixerRecipes,
                        9,
                        4,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "MIXER",
                        null).getStackForm(1L));

        CustomItemList.MixerUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        MIXER_UMV.ID,
                        "basicmachine.mixer.tier.12",
                        "Epic Matter Organizer IV",
                        12,
                        MachineType.MIXER.tooltipDescription(),
                        mixerRecipes,
                        9,
                        4,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "MIXER",
                        null).getStackForm(1L));
    }

    private void registerTransformer() {
        CustomItemList.Transformer_UEV_UHV.set(
                new GT_MetaTileEntity_Transformer(
                        TRANSFORMER_UEV_UHV.ID,
                        "transformer.tier.09",
                        "Highly Ultimate Transformer",
                        9,
                        "UEV -> UHV (Use Soft Mallet to invert)").getStackForm(1L));

        CustomItemList.Transformer_UIV_UEV.set(
                new GT_MetaTileEntity_Transformer(
                        TRANSFORMER_UIV_UEV.ID,
                        "transformer.tier.10",
                        "Extremely Ultimate Transformer",
                        10,
                        "UIV -> UEV (Use Soft Mallet to invert)").getStackForm(1L));

        CustomItemList.Transformer_UMV_UIV.set(
                new GT_MetaTileEntity_Transformer(
                        TRANSFORMER_UMV_UIV.ID,
                        "transformer.tier.11",
                        "Insanely Ultimate Transformer",
                        11,
                        "UMV -> UIV (Use Soft Mallet to invert)").getStackForm(1L));

        CustomItemList.Transformer_UXV_UMV.set(
                new GT_MetaTileEntity_Transformer(
                        TRANSFORMER_UXV_UMV.ID,
                        "transformer.tier.12",
                        "Mega Ultimate Transformer",
                        12,
                        "UXV -> UMV (Use Soft Mallet to invert)").getStackForm(1L));

        CustomItemList.Transformer_MAX_UXV.set(
                new GT_MetaTileEntity_Transformer(
                        TRANSFORMER_MAX_UXV.ID,
                        "transformer.tier.13",
                        "Extended Mega Ultimate Transformer",
                        13,
                        "MAX -> UXV (Use Soft Mallet to invert)").getStackForm(1L));
    }

    private void registerBatteryBuffer4By4() {
        CustomItemList.Battery_Buffer_4by4_UEV.set(
                new GT_MetaTileEntity_BasicBatteryBuffer(
                        BATTERY_BUFFER_4_BY_4_UEV.ID,
                        "batterybuffer.16.tier.10",
                        "Extremely Ultimate Battery Buffer",
                        10,
                        "",
                        16).getStackForm(1L));

        CustomItemList.Battery_Buffer_4by4_UIV.set(
                new GT_MetaTileEntity_BasicBatteryBuffer(
                        BATTERY_BUFFER_4_BY_4_UIV.ID,
                        "batterybuffer.16.tier.11",
                        "Insanely Ultimate Battery Buffer",
                        11,
                        "",
                        16).getStackForm(1L));

        CustomItemList.Battery_Buffer_4by4_UMV.set(
                new GT_MetaTileEntity_BasicBatteryBuffer(
                        BATTERY_BUFFER_4_BY_4_UMV.ID,
                        "batterybuffer.16.tier.12",
                        "Mega Ultimate Battery Buffer",
                        12,
                        "",
                        16).getStackForm(1L));

        CustomItemList.Battery_Buffer_4by4_UXV.set(
                new GT_MetaTileEntity_BasicBatteryBuffer(
                        BATTERY_BUFFER_4_BY_4_UXV.ID,
                        "batterybuffer.16.tier.13",
                        "Extended Mega Ultimate Battery Buffer",
                        13,
                        "",
                        16).getStackForm(1L));

        CustomItemList.Battery_Buffer_4by4_MAXV.set(
                new GT_MetaTileEntity_BasicBatteryBuffer(
                        BATTERY_BUFFER_4_BY_4_MAX.ID,
                        "batterybuffer.16.tier.14",
                        "Maximum Battery Buffer",
                        14,
                        "",
                        16).getStackForm(1L));

    }

    private void registerBatteryBuffer3By3() {
        CustomItemList.Battery_Buffer_3by3_UEV.set(
                new GT_MetaTileEntity_BasicBatteryBuffer(
                        BATTERY_BUFFER_3_BY_3_UEV.ID,
                        "batterybuffer.09.tier.10",
                        "Extremely Ultimate Battery Buffer",
                        10,
                        "",
                        9).getStackForm(1L));

        CustomItemList.Battery_Buffer_3by3_UIV.set(
                new GT_MetaTileEntity_BasicBatteryBuffer(
                        BATTERY_BUFFER_3_BY_3_UIV.ID,
                        "batterybuffer.09.tier.11",
                        "Insanely Ultimate Battery Buffer",
                        11,
                        "",
                        9).getStackForm(1L));

        CustomItemList.Battery_Buffer_3by3_UMV.set(
                new GT_MetaTileEntity_BasicBatteryBuffer(
                        BATTERY_BUFFER_3_BY_3_UMV.ID,
                        "batterybuffer.09.tier.12",
                        "Mega Ultimate Battery Buffer",
                        12,
                        "",
                        9).getStackForm(1L));

        CustomItemList.Battery_Buffer_3by3_UXV.set(
                new GT_MetaTileEntity_BasicBatteryBuffer(
                        BATTERY_BUFFER_3_BY_3_UXV.ID,
                        "batterybuffer.09.tier.13",
                        "Extended Mega Ultimate Battery Buffer",
                        13,
                        "",
                        9).getStackForm(1L));

        CustomItemList.Battery_Buffer_3by3_MAXV.set(
                new GT_MetaTileEntity_BasicBatteryBuffer(
                        BATTERY_BUFFER_3_BY_3_MAX.ID,
                        "batterybuffer.09.tier.14",
                        "Maximum Battery Buffer",
                        14,
                        "",
                        9).getStackForm(1L));
    }

    private void registerBatteryBuffer2By2() {
        CustomItemList.Battery_Buffer_2by2_UEV.set(
                new GT_MetaTileEntity_BasicBatteryBuffer(
                        BATTERY_BUFFER_2_BY_2_UEV.ID,
                        "batterybuffer.04.tier.10",
                        "Extremely Ultimate Battery Buffer",
                        10,
                        "",
                        4).getStackForm(1L));

        CustomItemList.Battery_Buffer_2by2_UIV.set(
                new GT_MetaTileEntity_BasicBatteryBuffer(
                        BATTERY_BUFFER_2_BY_2_UIV.ID,
                        "batterybuffer.04.tier.11",
                        "Insanely Ultimate Battery Buffer",
                        11,
                        "",
                        4).getStackForm(1L));

        CustomItemList.Battery_Buffer_2by2_UMV.set(
                new GT_MetaTileEntity_BasicBatteryBuffer(
                        BATTERY_BUFFER_2_BY_2_UMV.ID,
                        "batterybuffer.04.tier.12",
                        "Mega Ultimate Battery Buffer",
                        12,
                        "",
                        4).getStackForm(1L));

        CustomItemList.Battery_Buffer_2by2_UXV.set(
                new GT_MetaTileEntity_BasicBatteryBuffer(
                        BATTERY_BUFFER_2_BY_2_UXV.ID,
                        "batterybuffer.04.tier.13",
                        "Extended Mega Ultimate Battery Buffer",
                        13,
                        "",
                        4).getStackForm(1L));

        CustomItemList.Battery_Buffer_2by2_MAXV.set(
                new GT_MetaTileEntity_BasicBatteryBuffer(
                        BATTERY_BUFFER_2_BY_2_MAX.ID,
                        "batterybuffer.04.tier.14",
                        "Maximum Battery Buffer",
                        14,
                        "",
                        4).getStackForm(1L));
    }

    private void registerBatteryBuffer1By1() {
        CustomItemList.Battery_Buffer_1by1_UEV.set(
                new GT_MetaTileEntity_BasicBatteryBuffer(
                        BATTERY_BUFFER_1_BY_1_UEV.ID,
                        "batterybuffer.01.tier.10",
                        "Extremely Ultimate Battery Buffer",
                        10,
                        "",
                        1).getStackForm(1L));

        CustomItemList.Battery_Buffer_1by1_UIV.set(
                new GT_MetaTileEntity_BasicBatteryBuffer(
                        BATTERY_BUFFER_1_BY_1_UIV.ID,
                        "batterybuffer.01.tier.11",
                        "Insanely Ultimate Battery Buffer",
                        11,
                        "",
                        1).getStackForm(1L));

        CustomItemList.Battery_Buffer_1by1_UMV.set(
                new GT_MetaTileEntity_BasicBatteryBuffer(
                        BATTERY_BUFFER_1_BY_1_UMV.ID,
                        "batterybuffer.01.tier.12",
                        "Mega Ultimate Battery Buffer",
                        12,
                        "",
                        1).getStackForm(1L));

        CustomItemList.Battery_Buffer_1by1_UXV.set(
                new GT_MetaTileEntity_BasicBatteryBuffer(
                        BATTERY_BUFFER_1_BY_1_UXV.ID,
                        "batterybuffer.01.tier.13",
                        "Extended Mega Ultimate Battery Buffer",
                        13,
                        "",
                        1).getStackForm(1L));

        CustomItemList.Battery_Buffer_1by1_MAXV.set(
                new GT_MetaTileEntity_BasicBatteryBuffer(
                        BATTERY_BUFFER_1_BY_1_MAX.ID,
                        "batterybuffer.01.tier.14",
                        "Maximum Battery Buffer",
                        14,
                        "",
                        1).getStackForm(1L));
    }

    private void registerBatteryCharger4By4() {
        CustomItemList.Battery_Charger_4by4_UEV.set(
                new GT_MetaTileEntity_Charger(
                        BATTERY_CHARGER_4_4_UEV.ID,
                        "batterycharger.16.tier.10",
                        "Extremely Ultimate Battery Charger",
                        10,
                        "",
                        4).getStackForm(1L));

        CustomItemList.Battery_Charger_4by4_UIV.set(
                new GT_MetaTileEntity_Charger(
                        BATTERY_CHARGER_4_4_UIV.ID,
                        "batterycharger.16.tier.11",
                        "Insanely Ultimate Battery Charger",
                        11,
                        "",
                        4).getStackForm(1L));

        CustomItemList.Battery_Charger_4by4_UMV.set(
                new GT_MetaTileEntity_Charger(
                        BATTERY_CHARGER_4_4_UMV.ID,
                        "batterycharger.16.tier.12",
                        "Mega Ultimate Battery Charger",
                        12,
                        "",
                        4).getStackForm(1L));

        CustomItemList.Battery_Charger_4by4_UXV.set(
                new GT_MetaTileEntity_Charger(
                        BATTERY_CHARGER_4_4_UXV.ID,
                        "batterycharger.16.tier.13",
                        "Extended Mega Ultimate Battery Charger",
                        13,
                        "",
                        4).getStackForm(1L));
    }

    private void registerDynamoHatches() {
        CustomItemList.Hatch_Dynamo_UEV.set(
                new GT_MetaTileEntity_Hatch_Dynamo(DYNAMO_HATCH_UEV.ID, "hatch.dynamo.tier.10", "UEV Dynamo Hatch", 10)
                        .getStackForm(1L));

        CustomItemList.Hatch_Dynamo_UIV.set(
                new GT_MetaTileEntity_Hatch_Dynamo(DYNAMO_HATCH_UIV.ID, "hatch.dynamo.tier.11", "UIV Dynamo Hatch", 11)
                        .getStackForm(1L));

        CustomItemList.Hatch_Dynamo_UMV.set(
                new GT_MetaTileEntity_Hatch_Dynamo(DYNAMO_HATCH_UMV.ID, "hatch.dynamo.tier.12", "UMV Dynamo Hatch", 12)
                        .getStackForm(1L));

        CustomItemList.Hatch_Dynamo_UXV.set(
                new GT_MetaTileEntity_Hatch_Dynamo(DYNAMO_HATCH_UXV.ID, "hatch.dynamo.tier.13", "UXV Dynamo Hatch", 13)
                        .getStackForm(1L));
    }

    private void registerEnergyHatches() {
        CustomItemList.Hatch_Energy_UEV.set(
                new GT_MetaTileEntity_Hatch_Energy(ENERGY_HATCH_UEV.ID, "hatch.energy.tier.10", "UEV Energy Hatch", 10)
                        .getStackForm(1L));

        CustomItemList.Hatch_Energy_UIV.set(
                new GT_MetaTileEntity_Hatch_Energy(ENERGY_HATCH_UIV.ID, "hatch.energy.tier.11", "UIV Energy Hatch", 11)
                        .getStackForm(1L));

        CustomItemList.Hatch_Energy_UMV.set(
                new GT_MetaTileEntity_Hatch_Energy(ENERGY_HATCH_UMV.ID, "hatch.energy.tier.12", "UMV Energy Hatch", 12)
                        .getStackForm(1L));

        CustomItemList.Hatch_Energy_UXV.set(
                new GT_MetaTileEntity_Hatch_Energy(ENERGY_HATCH_UXV.ID, "hatch.energy.tier.13", "UXV Energy Hatch", 13)
                        .getStackForm(1L));
    }

    private void registerWetTransformer() {
        CustomItemList.WetTransformer_LV_ULV.set(
                new GT_MetaTileEntity_WetTransformer(
                        WET_TRANSFORMER_LV_ULV.ID,
                        "wettransformer.tier.00",
                        "Ultra Low Voltage Power Transformer",
                        0,
                        "LV -> ULV (Use Soft Mallet to invert)").getStackForm(1L));

        CustomItemList.WetTransformer_MV_LV.set(
                new GT_MetaTileEntity_WetTransformer(
                        WET_TRANSFORMER_MV_LV.ID,
                        "wetransformer.tier.01",
                        "Low Voltage Power Transformer",
                        1,
                        "MV -> LV (Use Soft Mallet to invert)").getStackForm(1L));

        CustomItemList.WetTransformer_HV_MV.set(
                new GT_MetaTileEntity_WetTransformer(
                        WET_TRANSFORMER_HV_MV.ID,
                        "wettransformer.tier.02",
                        "Medium Voltage Power Transformer",
                        2,
                        "HV -> MV (Use Soft Mallet to invert)").getStackForm(1L));

        CustomItemList.WetTransformer_EV_HV.set(
                new GT_MetaTileEntity_WetTransformer(
                        WET_TRANSFORMER_EV_HV.ID,
                        "wettransformer.tier.03",
                        "High Voltage Power Transformer",
                        3,
                        "EV -> HV (Use Soft Mallet to invert)").getStackForm(1L));

        CustomItemList.WetTransformer_IV_EV.set(
                new GT_MetaTileEntity_WetTransformer(
                        WET_TRANSFORMER_IV_EV.ID,
                        "wettransformer.tier.04",
                        "Extreme Power Transformer",
                        4,
                        "IV -> EV (Use Soft Mallet to invert)").getStackForm(1L));

        CustomItemList.WetTransformer_LuV_IV.set(
                new GT_MetaTileEntity_WetTransformer(
                        WET_TRANSFORMER_LuV_IV.ID,
                        "wettransformer.tier.05",
                        "Insane Power Transformer",
                        5,
                        "LuV -> IV (Use Soft Mallet to invert)").getStackForm(1L));

        CustomItemList.WetTransformer_ZPM_LuV.set(
                new GT_MetaTileEntity_WetTransformer(
                        WET_TRANSFORMER_ZPM_LuV.ID,
                        "wettransformer.tier.06",
                        "Ludicrous Power Transformer",
                        6,
                        "ZPM -> LuV (Use Soft Mallet to invert)").getStackForm(1L));

        CustomItemList.WetTransformer_UV_ZPM.set(
                new GT_MetaTileEntity_WetTransformer(
                        WET_TRANSFORMER_UV_ZPM.ID,
                        "wettransformer.tier.07",
                        "ZPM Voltage Power Transformer",
                        7,
                        "UV -> ZPM (Use Soft Mallet to invert)").getStackForm(1L));

        CustomItemList.WetTransformer_UHV_UV.set(
                new GT_MetaTileEntity_WetTransformer(
                        WET_TRANSFORMER_UHV_UV.ID,
                        "wettransformer.tier.08",
                        "Ultimate Power Transformer",
                        8,
                        "UHV -> UV (Use Soft Mallet to invert)").getStackForm(1L));

        CustomItemList.WetTransformer_UEV_UHV.set(
                new GT_MetaTileEntity_WetTransformer(
                        WET_TRANSFORMER_UEV_UHV.ID,
                        "wettransformer.tier.09",
                        "Highly Ultimate Power Transformer",
                        9,
                        "UEV -> UHV (Use Soft Mallet to invert)").getStackForm(1L));

        CustomItemList.WetTransformer_UIV_UEV.set(
                new GT_MetaTileEntity_WetTransformer(
                        WET_TRANSFORMER_UIV_UEV.ID,
                        "wettransformer.tier.10",
                        "Extremely Ultimate Power Transformer",
                        10,
                        "UIV -> UEV (Use Soft Mallet to invert)").getStackForm(1L));

        CustomItemList.WetTransformer_UMV_UIV.set(
                new GT_MetaTileEntity_WetTransformer(
                        WET_TRANSFORMER_UMV_UIV.ID,
                        "wettransformer.tier.11",
                        "Insanely Ultimate Power Transformer",
                        11,
                        "UMV -> UIV (Use Soft Mallet to invert)").getStackForm(1L));

        CustomItemList.WetTransformer_UXV_UMV.set(
                new GT_MetaTileEntity_WetTransformer(
                        WET_TRANSFORMER_UXV_UMV.ID,
                        "wettransformer.tier.12",
                        "Mega Ultimate Power Transformer",
                        12,
                        "UXV -> UMV (Use Soft Mallet to invert)").getStackForm(1L));

        CustomItemList.WetTransformer_MAX_UXV.set(
                new GT_MetaTileEntity_WetTransformer(
                        WET_TRANSFORMER_MAX_UXV.ID,
                        "wettransformer.tier.13",
                        "Extended Mega Ultimate Power Transformer",
                        13,
                        "MAX -> UXV (Use Soft Mallet to invert)").getStackForm(1L));
    }

    private void registerHighAmpTransformer() {
        if (GTPlusPlus.isModLoaded()) {
            CustomItemList.Transformer_HA_UEV_UHV.set(
                    new GregtechMetaTransformerHiAmp(
                            HIGH_AMP_TRANSFORMER_UEV_UHV.ID,
                            "transformer.ha.tier.09",
                            "Highly Ultimate Hi-Amp Transformer",
                            9,
                            "UEV -> UHV (Use Soft Mallet to invert)").getStackForm(1L));
            CustomItemList.Transformer_HA_UIV_UEV.set(
                    new GregtechMetaTransformerHiAmp(
                            HIGH_AMP_TRANSFORMER_UIV_UEV.ID,
                            "transformer.ha.tier.10",
                            "Extremely Ultimate Hi-Amp Transformer",
                            10,
                            "UIV -> UEV (Use Soft Mallet to invert)").getStackForm(1L));
            CustomItemList.Transformer_HA_UMV_UIV.set(
                    new GregtechMetaTransformerHiAmp(
                            HIGH_AMP_TRANSFORMER_UMV_UIV.ID,
                            "transformer.ha.tier.11",
                            "Insanely Ultimate Hi-Amp Transformer",
                            11,
                            "UMV -> UIV (Use Soft Mallet to invert)").getStackForm(1L));
            CustomItemList.Transformer_HA_UXV_UMV.set(
                    new GregtechMetaTransformerHiAmp(
                            HIGH_AMP_TRANSFORMER_UXV_UMV.ID,
                            "transformer.ha.tier.12",
                            "Mega Ultimate Hi-Amp Transformer",
                            12,
                            "UXV -> UMV (Use Soft Mallet to invert)").getStackForm(1L));
            CustomItemList.Transformer_HA_MAX_UXV.set(
                    new GregtechMetaTransformerHiAmp(
                            HIGH_AMP_TRANSFORMER_MAX_UXV.ID,
                            "transformer.ha.tier.13",
                            "Extended Mega Ultimate Hi-Amp Transformer",
                            13,
                            "MAX -> UXV (Use Soft Mallet to invert)").getStackForm(1L));

        }
    }

    private void registerAirFilter() {
        CustomItemList.Machine_Multi_AirFilterT1.set(
                new GT_MetaTileEntity_AirFilterT1(
                        AIR_FILTER_CONTROLLER_T1.ID,
                        "multimachine.airfilter.01",
                        "Electric Air Filter T1").getStackForm(1L));
        CustomItemList.Machine_Multi_AirFilterT2.set(
                new GT_MetaTileEntity_AirFilterT2(
                        AIR_FILTER_CONTROLLER_T2.ID,
                        "multimachine.airfilter.02",
                        "Electric Air Filter T2").getStackForm(1L));
        CustomItemList.Machine_Multi_AirFilterT3.set(
                new GT_MetaTileEntity_AirFilterT3(
                        AIR_FILTER_CONTROLLER_T3.ID,
                        "multimachine.airfilter.03",
                        "Electric Air Filter T3").getStackForm(1L));
    }

    private void registerTurboCharger4By4() {
        CustomItemList.Battery_TurboCharger_4by4_ULV.set(
                new GT_MetaTileEntity_TurboCharger(
                        TURBO_CHARGER_ULV.ID,
                        "batteryturbocharger.16.tier.00",
                        "Ultra Low Voltage Turbo Charger",
                        0,
                        "64A in /16A out, 120A/item, Disable to force Charge",
                        4).getStackForm(1L));

        CustomItemList.Battery_TurboCharger_4by4_LV.set(
                new GT_MetaTileEntity_TurboCharger(
                        TURBO_CHARGER_LV.ID,
                        "batteryturbocharger.16.tier.01",
                        "Low Voltage Turbo Charger",
                        1,
                        "64A in /16A out, 120A/item, Disable to force Charge",
                        4).getStackForm(1L));

        CustomItemList.Battery_TurboCharger_4by4_MV.set(
                new GT_MetaTileEntity_TurboCharger(
                        TURBO_CHARGER_MV.ID,
                        "batteryturbocharger.16.tier.02",
                        "Medium Voltage Turbo Charger",
                        2,
                        "64A in /16A out, 120A/item, Disable to force Charge",
                        4).getStackForm(1L));

        CustomItemList.Battery_TurboCharger_4by4_HV.set(
                new GT_MetaTileEntity_TurboCharger(
                        TURBO_CHARGER_HV.ID,
                        "batteryturbocharger.16.tier.03",
                        "High Voltage Turbo Charger",
                        3,
                        "64A in /16A out, 120A/item, Disable to force Charge",
                        4).getStackForm(1L));

        CustomItemList.Battery_TurboCharger_4by4_EV.set(
                new GT_MetaTileEntity_TurboCharger(
                        TURBO_CHARGER_EV.ID,
                        "batteryturbocharger.16.tier.04",
                        "Extreme Voltage Turbo Charger",
                        4,
                        "64A in /16A out, 120A/item, Disable to force Charge",
                        4).getStackForm(1L));

        CustomItemList.Battery_TurboCharger_4by4_IV.set(
                new GT_MetaTileEntity_TurboCharger(
                        TURBO_CHARGER_IV.ID,
                        "batteryturbocharger.16.tier.05",
                        "Insane Voltage Turbo Charger",
                        5,
                        "64A in /16A out, 120A/item, Disable to force Charge",
                        4).getStackForm(1L));

        CustomItemList.Battery_TurboCharger_4by4_LuV.set(
                new GT_MetaTileEntity_TurboCharger(
                        TURBO_CHARGER_LuV.ID,
                        "batteryturbocharger.16.tier.06",
                        "Ludicrous Voltage Turbo Charger",
                        6,
                        "64A in /16A out, 120A/item, Disable to force Charge",
                        4).getStackForm(1L));

        CustomItemList.Battery_TurboCharger_4by4_ZPM.set(
                new GT_MetaTileEntity_TurboCharger(
                        TURBO_CHARGER_ZPM.ID,
                        "batteryturbocharger.16.tier.07",
                        "ZPM Voltage Turbo Charger",
                        7,
                        "64A in /16A out, 120A/item, Disable to force Charge",
                        4).getStackForm(1L));

        CustomItemList.Battery_TurboCharger_4by4_UV.set(
                new GT_MetaTileEntity_TurboCharger(
                        TURBO_CHARGER_UV.ID,
                        "batteryturbocharger.16.tier.08",
                        "Ultimate Voltage Turbo Charger",
                        8,
                        "64A in /16A out, 120A/item, Disable to force Charge",
                        4).getStackForm(1L));

        CustomItemList.Battery_TurboCharger_4by4_UHV.set(
                new GT_MetaTileEntity_TurboCharger(
                        TURBO_CHARGER_UHV.ID,
                        "batteryturbocharger.16.tier.09",
                        "Highly Ultimate Voltage Turbo Charger",
                        9,
                        "64A in /16A out, 120A/item, Disable to force Charge",
                        4).getStackForm(1L));

    }

    private void registerChestBuffer() {
        CustomItemList.Automation_ChestBuffer_UEV.set(
                new GT_MetaTileEntity_ChestBuffer(
                        CHEST_BUFFER_UEV.ID,
                        "automation.chestbuffer.tier.10",
                        "Ultra High Voltage Chest Buffer",
                        10).getStackForm(1L));

        CustomItemList.Automation_ChestBuffer_UIV.set(
                new GT_MetaTileEntity_ChestBuffer(
                        CHEST_BUFFER_UIV.ID,
                        "automation.chestbuffer.tier.11",
                        "UIV Voltage Chest Buffer",
                        11).getStackForm(1L));

        CustomItemList.Automation_ChestBuffer_UMV.set(
                new GT_MetaTileEntity_ChestBuffer(
                        CHEST_BUFFER_UMV.ID,
                        "automation.chestbuffer.tier.12",
                        "UMV Voltage Chest Buffer",
                        12).getStackForm(1L));
    }

    private void registerNameRemover() {
        CustomItemList.nameRemover
                .set(new NameRemover(NAME_REMOVER.ID, "fix.name.remover", "Name Remover", 0).getStackForm(1L));
    }

    private void registerRockBreaker() {
        CustomItemList.RockBreakerLuV.set(
                new GT_MetaTileEntity_RockBreaker(
                        ROCK_BREAKER_LuV.ID,
                        "rockbreaker.tier.06",
                        "Cryogenic Magma Solidifier R-9200",
                        6).getStackForm(1L));

        CustomItemList.RockBreakerZPM.set(
                new GT_MetaTileEntity_RockBreaker(
                        ROCK_BREAKER_ZPM.ID,
                        "rockbreaker.tier.07",
                        "Cryogenic Magma Solidifier R-10200",
                        7).getStackForm(1L));

        CustomItemList.RockBreakerUV.set(
                new GT_MetaTileEntity_RockBreaker(
                        ROCK_BREAKER_UV.ID,
                        "rockbreaker.tier.08",
                        "Cryogenic Magma Solidifier R-11200",
                        8).getStackForm(1L));

        CustomItemList.RockBreakerUHV.set(
                new GT_MetaTileEntity_RockBreaker(
                        ROCK_BREAKER_UHV.ID,
                        "rockbreaker.tier.09",
                        "Cryogenic Magma Solidifier R-12200",
                        9).getStackForm(1L));

        CustomItemList.RockBreakerUEV.set(
                new GT_MetaTileEntity_RockBreaker(
                        ROCK_BREAKER_UEV.ID,
                        "rockbreaker.tier.10",
                        "Cryogenic Magma Solidifier R-13200",
                        10).getStackForm(1L));

        CustomItemList.RockBreakerUIV.set(
                new GT_MetaTileEntity_RockBreaker(
                        ROCK_BREAKER_UIV.ID,
                        "rockbreaker.tier.11",
                        "Cryogenic Magma Solidifier R-14200",
                        11).getStackForm(1L));

        CustomItemList.RockBreakerUMV.set(
                new GT_MetaTileEntity_RockBreaker(
                        ROCK_BREAKER_UMV.ID,
                        "rockbreaker.tier.12",
                        "Cryogenic Magma Solidifier R-15200",
                        12).getStackForm(1L));
    }

    private void registerCircuitAssembler() {
        CustomItemList.CircuitAssemblerUHV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CIRCUIT_ASSEMBLER_UHV.ID,
                        "basicmachine.circuitassembler.tier.09",
                        "Ultimate Circuit Assembling Machine",
                        9,
                        MachineType.CIRCUIT_ASSEMBLER.tooltipDescription(),
                        circuitAssemblerRecipes,
                        6,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CIRCUITASSEMBLER",
                        new Object[] { "RCE", "KHK", "WCW", 'R', ItemList.Robot_Arm_UHV, 'E', ItemList.Emitter_UHV, 'H',
                                ItemList.Hull_MAX, 'K', ItemList.Conveyor_Module_UHV, 'C',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));
        CustomItemList.CircuitAssemblerUEV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CIRCUIT_ASSEMBLER_UEV.ID,
                        "basicmachine.circuitassembler.tier.10",
                        "Ultimate Circuit Assembling Machine II",
                        10,
                        MachineType.CIRCUIT_ASSEMBLER.tooltipDescription(),
                        circuitAssemblerRecipes,
                        6,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CIRCUITASSEMBLER",
                        new Object[] { "RCE", "KHK", "WCW", 'R', ItemList.Robot_Arm_UEV, 'E', ItemList.Emitter_UEV, 'H',
                                CustomItemList.Hull_UEV, 'K', ItemList.Conveyor_Module_UEV, 'C',
                                OrePrefixes.circuit.get(Materials.UIV), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        CustomItemList.CircuitAssemblerUIV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CIRCUIT_ASSEMBLER_UIV.ID,
                        "basicmachine.circuitassembler.tier.11",
                        "Ultimate Circuit Assembling Machine III",
                        11,
                        MachineType.CIRCUIT_ASSEMBLER.tooltipDescription(),
                        circuitAssemblerRecipes,
                        6,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CIRCUITASSEMBLER",
                        new Object[] { "RCE", "KHK", "WCW", 'R', ItemList.Robot_Arm_UIV, 'E', ItemList.Emitter_UIV, 'H',
                                CustomItemList.Hull_UIV, 'K', ItemList.Conveyor_Module_UIV, 'C',
                                OrePrefixes.circuit.get(Materials.UMV), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));
        CustomItemList.CircuitAssemblerUMV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CIRCUIT_ASSEMBLER_UMV.ID,
                        "basicmachine.circuitassembler.tier.12",
                        "Ultimate Circuit Assembling Machine IV",
                        12,
                        MachineType.CIRCUIT_ASSEMBLER.tooltipDescription(),
                        circuitAssemblerRecipes,
                        6,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CIRCUITASSEMBLER",
                        new Object[] { "RCE", "KHK", "WCW", 'R', ItemList.Robot_Arm_UMV, 'E', ItemList.Emitter_UMV, 'H',
                                CustomItemList.Hull_UMV, 'K', ItemList.Conveyor_Module_UMV, 'C',
                                OrePrefixes.circuit.get(Materials.UXV), 'W',
                                GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));
        CustomItemList.CircuitAssemblerUXV.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CIRCUIT_ASSEMBLER_UXV.ID,
                        "basicmachine.circuitassembler.tier.13",
                        "Ultimate Circuit Assembling Machine V",
                        13,
                        MachineType.CIRCUIT_ASSEMBLER.tooltipDescription(),
                        circuitAssemblerRecipes,
                        6,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CIRCUITASSEMBLER",
                        null).getStackForm(1L));
        CustomItemList.CircuitAssemblerMAX.set(
                new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                        CIRCUIT_ASSEMBLER_MAX.ID,
                        "basicmachine.circuitassembler.tier.14",
                        "MAX Circuit Assembling Machine",
                        14,
                        MachineType.CIRCUIT_ASSEMBLER.tooltipDescription(),
                        circuitAssemblerRecipes,
                        6,
                        1,
                        true,
                        SoundResource.NONE,
                        SpecialEffects.NONE,
                        "CIRCUITASSEMBLER",
                        null).getStackForm(1L));
    }

    private void registerInputHatch() {
        CustomItemList.Hatch_Input_UEV.set(
                new GT_MetaTileEntity_Hatch_Input(INPUT_HATCH_UEV.ID, "hatch.input.tier.10", "Input Hatch (UEV)", 10)
                        .getStackForm(1L));
        CustomItemList.Hatch_Input_UIV.set(
                new GT_MetaTileEntity_Hatch_Input(INPUT_HATCH_UIV.ID, "hatch.input.tier.11", "Input Hatch (UIV)", 11)
                        .getStackForm(1L));
        CustomItemList.Hatch_Input_UMV.set(
                new GT_MetaTileEntity_Hatch_Input(INPUT_HATCH_UMV.ID, "hatch.input.tier.12", "Input Hatch (UMV)", 12)
                        .getStackForm(1L));
        CustomItemList.Hatch_Input_UXV.set(
                new GT_MetaTileEntity_Hatch_Input(INPUT_HATCH_UXV.ID, "hatch.input.tier.13", "Input Hatch (UXV)", 13)
                        .getStackForm(1L));
        CustomItemList.Hatch_Input_MAX.set(
                new GT_MetaTileEntity_Hatch_Input(INPUT_HATCH_MAX.ID, "hatch.input.tier.14", "Input Hatch (MAX)", 14)
                        .getStackForm(1L));
    }

    private void registerOutputHatches() {
        CustomItemList.Hatch_Output_UEV.set(
                new GT_MetaTileEntity_Hatch_Output(
                        OUTPUT_HATCH_UEV.ID,
                        "hatch.output.tier.10",
                        "Output Hatch (UEV)",
                        10).getStackForm(1L));
        CustomItemList.Hatch_Output_UIV.set(
                new GT_MetaTileEntity_Hatch_Output(
                        OUTPUT_HATCH_UIV.ID,
                        "hatch.output.tier.11",
                        "Output Hatch (UIV)",
                        11).getStackForm(1L));
        CustomItemList.Hatch_Output_UMV.set(
                new GT_MetaTileEntity_Hatch_Output(
                        OUTPUT_HATCH_UMV.ID,
                        "hatch.output.tier.12",
                        "Output Hatch (UMV)",
                        12).getStackForm(1L));
        CustomItemList.Hatch_Output_UXV.set(
                new GT_MetaTileEntity_Hatch_Output(
                        OUTPUT_HATCH_UXV.ID,
                        "hatch.output.tier.13",
                        "Output Hatch (UXV)",
                        13).getStackForm(1L));
        CustomItemList.Hatch_Output_MAX.set(
                new GT_MetaTileEntity_Hatch_Output(
                        OUTPUT_HATCH_MAX.ID,
                        "hatch.output.tier.14",
                        "Output Hatch (MAX)",
                        14).getStackForm(1L));
    }

    private void registerMachines2() {

        // ===================================================================================================
        // Electric Oven - nah - daaaah
        // ===================================================================================================

        /*
         * TODO: WE USE RANGE 10750-12500 ID's occupied from 15000-15500!! (in EM branch) ID's occupied from
         * 12500-13000!! (bartimaeusnek) A List of all registered MetaTileEntities <p/> 0 - 1199 are used by GregTech.
         * 1200 - 2047 are used for GregTech Cables. 2048 - 2559 are reserved for OvermindDL. 2560 - 3071 are reserved
         * for Immibis. 3072 - 3583 are reserved for LinusPhoenix. 3584 - 4095 are reserved for BloodyAsp. 4096 - 5095
         * are used for GregTech Frames. 5096 - 6099 are used for GregTech Pipes. 6100 - 8191 are used for GregTech
         * Decoration Blocks. 8192 - 8703 are reserved for ZL123. 8704 - 9215 are reserved for Mr10Movie. 9216 - 9727
         * are used for GregTech Automation Machines. 9728 - 10239 are reserved for 28Smiles. 10240 - 10751 are reserved
         * for VirMan. 10752 - 11263 are reserved for Briareos81. 11264 - 12000 are reserved for the next one who asks
         * me. 12500 - 13000 are reserved for bartimaeusnek 9728 - 32766 are currently free. <p/> Contact me if you need
         * a free ID-Range, which doesn't conflict with other Addons. You could make an ID-Config, but we all know, what
         * "stupid" customers think about conflicting ID's 27.01.2016 Namikon updated: 30.08.2019 bartimaeusnek
         */
    }
}
