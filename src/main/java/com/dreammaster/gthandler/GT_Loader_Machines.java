package com.dreammaster.gthandler;

import com.dreammaster.gthandler.multiAirFilter.GT_MetaTileEntity_AirFilterT1;
import com.dreammaster.gthandler.multiAirFilter.GT_MetaTileEntity_AirFilterT2;
import com.dreammaster.gthandler.multiAirFilter.GT_MetaTileEntity_AirFilterT3;
import com.dreammaster.gthandler.nameRemover.NameRemover;
import com.dreammaster.item.food.QuantumBread;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsKevlar;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OreDictNames;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_BasicMachine_GT_Recipe;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static com.dreammaster.gthandler.enums.MetaTileEntityIDs.*;
import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.slicerRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

public class GT_Loader_Machines {

    public static long bitsd = GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE
            | GT_ModHandler.RecipeBits.REVERSIBLE
            | GT_ModHandler.RecipeBits.BUFFERED;
    private Materials LuVMat2;

    public void run() {
        LuVMat2 = Materials.get("Rhodium-PlatedPalladium");
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
        registerMicrowave();
        registerOreWashingPlant();
        registerPolarizer();
        registerRecycler();
        registerSiftingMachine();
        registerSlicingMachine();
        registerThermalCentrifuge();
        registerWiremill();
        registerArcFurnace();
        registerCentrifuge();
        registerPlasmaArcFurnace();
        registerCanningMachine();
        registerChemicalBath();
        registerAirFilter();
        registerNameRemover();
        registerCircuitAssembler();
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

    private void registerAlloySmelter() {

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AlloySmelterLuV.get(1L),
                bitsd,
                new Object[] { "ECE", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getHCoil()});

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AlloySmelterZPM.get(1L),
                bitsd,new Object[] { "ECE", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getHCoil() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AlloySmelterUV.get(1L),
                bitsd,new Object[] { "ECE", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getHCoil() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AlloySmelterUHV.get(1L),
                bitsd,new Object[] { "ECE", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getHCoil() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AlloySmelterUEV.get(1L),
                bitsd,new Object[] { "ECE", "CMC", "WCW", 'M', CustomItemList.Hull_UEV, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getHCoil() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AlloySmelterUIV.get(1L),
                bitsd,new Object[] { "ECE", "CMC", "WCW", 'M', CustomItemList.Hull_UIV, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getHCoil() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AlloySmelterUMV.get(1L),
                bitsd,new Object[] { "ECE", "CMC", "WCW", 'M', CustomItemList.Hull_UMV, 'E',
            GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
            GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'C',
            GT_CustomLoader.AdvancedGTMaterials.UMV.getHCoil()});
    }

    private void registerMatterAmplifier() {

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AmplifabricatorLuV.get(1L),
                bitsd,
                new Object[] { "WPW", "PMP", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable4(), });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AmplifabricatorZPM.get(1L),
                bitsd,
                new Object[] { "WPW", "PMP", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable4(), });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AmplifabricatorUV.get(1L),
                bitsd,
                new Object[] { "WPW", "PMP", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable4(), });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AmplifabricatorUHV.get(1L),
                bitsd,
                new Object[] { "WPW", "PMP", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable4(), });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AmplifabricatorUEV.get(1L),
                bitsd,
                new Object[] { "WPW", "PMP", "CPC", 'M', CustomItemList.Hull_UEV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable4(), });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AmplifabricatorUIV.get(1L),
                bitsd,
                new Object[] { "WPW", "PMP", "CPC", 'M', CustomItemList.Hull_UIV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable4(), });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AmplifabricatorUMV.get(1L),
                bitsd,
                new Object[] { "WPW", "PMP", "CPC", 'M', CustomItemList.Hull_UMV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable4(), });
    }

    private void registerAssemblingMachine() {
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AssemblingMachineLuV.get(1L),
                bitsd,
                new Object[] { "ACA", "VMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'A',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.ROBOT_ARM, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AssemblingMachineZPM.get(1L),
                bitsd,
                new Object[] { "ACA", "VMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'A',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.ROBOT_ARM, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AssemblingMachineUV.get(1L),
                bitsd,
                new Object[] { "ACA", "VMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'A',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.ROBOT_ARM, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AssemblingMachineUHV.get(1L),
                bitsd,
                new Object[] { "ACA", "VMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'A',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.ROBOT_ARM, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AssemblingMachineUEV.get(1L),
                bitsd,
                new Object[] { "ACA", "VMV", "WCW", 'M', CustomItemList.Hull_UEV, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'A',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.ROBOT_ARM, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AssemblingMachineUIV.get(1L),
                bitsd,
                new Object[] { "ACA", "VMV", "WCW", 'M', CustomItemList.Hull_UIV, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'A',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.ROBOT_ARM, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() });

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


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AutoclaveLuV.get(1L),
                bitsd,
                new Object[] { "IGI", "IMI", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'I',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getPlate(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getGlass() });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AutoclaveZPM.get(1L),
                bitsd,
                new Object[] { "IGI", "IMI", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'I',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getPlate(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getGlass() });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AutoclaveUV.get(1L),
                bitsd,
                new Object[] { "IGI", "IMI", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'I',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getPlate(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getGlass(), });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AutoclaveUHV.get(1L),
                bitsd,
                new Object[] { "IGI", "IMI", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'I',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getPlate(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getGlass(), });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AutoclaveUEV.get(1L),
                bitsd,
                new Object[] { "IGI", "IMI", "CPC", 'M', CustomItemList.Hull_UEV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'I',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getPlate(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getGlass(), });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AutoclaveUIV.get(1L),
                bitsd,
                new Object[] { "IGI", "IMI", "CPC", 'M', CustomItemList.Hull_UIV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'I',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getPlate(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getGlass(), });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.AutoclaveUMV.get(1L),
                bitsd,
                new Object[] { "IGI", "IMI", "CPC", 'M', CustomItemList.Hull_UMV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'I',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getPlate(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getGlass(), });
    }

    private void registerBendingMachine() {



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.BendingMachineLuV.get(1L),
                bitsd,
                new Object[] { "PWP", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.BendingMachineZPM.get(1L),
                bitsd,
                new Object[] { "PWP", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.BendingMachineUV.get(1L),
                bitsd,
                new Object[] { "PWP", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable() });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.BendingMachineUHV.get(1L),
                bitsd,
                new Object[] { "PWP", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.BendingMachineUEV.get(1L),
                bitsd,
                new Object[] { "PWP", "CMC", "EWE", 'M', CustomItemList.Hull_UEV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.BendingMachineUIV.get(1L),
                bitsd,
                new Object[] { "PWP", "CMC", "EWE", 'M', CustomItemList.Hull_UIV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.BendingMachineUMV.get(1L),
                bitsd,
                new Object[] { "PWP", "CMC", "EWE", 'M', CustomItemList.Hull_UMV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() });
    }

    private void registerCompressor() {


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CompressorLuV.get(1L),
                bitsd,
                new Object[] { "WCW", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CompressorZPM.get(1L),
                bitsd,
                new Object[] { "WCW", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CompressorUV.get(1L),
                bitsd,
                new Object[] { "WCW", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable() });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CompressorUHV.get(1L),
                bitsd,
                new Object[] { "WCW", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CompressorUEV.get(1L),
                bitsd,
                new Object[] { "WCW", "PMP", "WCW", 'M', CustomItemList.Hull_UEV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CompressorUIV.get(1L),
                bitsd,
                new Object[] { "WCW", "PMP", "WCW", 'M', CustomItemList.Hull_UIV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CompressorUMV.get(1L),
                bitsd,
                new Object[] { "WCW", "PMP", "WCW", 'M', CustomItemList.Hull_UMV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() });
    }

    private void registerCuttingMachine() {



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CuttingMachineLuV.get(1L),
                bitsd,
                new Object[] { "WCG", "VMB", "CWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getGlass(), 'B',
                        OreDictNames.craftingDiamondBlade });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CuttingMachineZPM.get(1L),
                bitsd,
                new Object[] { "WCG", "VMB", "CWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getGlass(), 'B',
                        OreDictNames.craftingDiamondBlade });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CuttingMachineUV.get(1L),
                bitsd,
                new Object[] { "WCG", "VMB", "CWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getGlass(), 'B',
                        OreDictNames.craftingDiamondBlade });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CuttingMachineUHV.get(1L),
                bitsd,
                new Object[] { "WCG", "VMB", "CWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getGlass(), 'B',
                        OreDictNames.craftingDiamondBlade });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CuttingMachineUEV.get(1L),
                bitsd,
                new Object[] { "WCG", "VMB", "CWE", 'M', CustomItemList.Hull_UEV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getGlass(), 'B',
                        OreDictNames.craftingDiamondBlade });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CuttingMachineUIV.get(1L),
                bitsd,
                new Object[] { "WCG", "VMB", "CWE", 'M', CustomItemList.Hull_UIV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getGlass(), 'B',
                        OreDictNames.craftingDiamondBlade });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CuttingMachineUMV.get(1L),
                bitsd,
                new Object[] { "WCG", "VMB", "CWE", 'M', CustomItemList.Hull_UMV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getGlass(), 'B',
                        OreDictNames.craftingDiamondBlade });

    }

    private void registerDistillery() {



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.DistilleryLuV.get(1L),
                bitsd,
                new Object[] { "GBG", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'B',
                        OrePrefixes.pipeMedium.get(Materials.Enderium), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getGlass() });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.DistilleryZPM.get(1L),
                bitsd,
                new Object[] { "GBG", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'B',
                        OrePrefixes.pipeMedium.get(Materials.Naquadah), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getGlass() });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.DistilleryUV.get(1L),
                bitsd,
                new Object[] { "GBG", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'B',
                        OrePrefixes.pipeMedium.get(Materials.Neutronium), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getGlass() });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.DistilleryUHV.get(1L),
                bitsd,
                new Object[] { "GBG", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'B',
                        OrePrefixes.pipeLarge.get(Materials.Neutronium), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getGlass() });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.DistilleryUEV.get(1L),
                bitsd,
                new Object[] { "GBG", "CMC", "WPW", 'M', CustomItemList.Hull_UEV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'B',
                        OrePrefixes.pipeHuge.get(Materials.Neutronium), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getGlass() });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.DistilleryUIV.get(1L),
                bitsd,
                new Object[] { "GBG", "CMC", "WPW", 'M', CustomItemList.Hull_UIV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'B',
                        OrePrefixes.pipeMedium.get(Materials.Infinity), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getGlass() });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.DistilleryUMV.get(1L),
                bitsd,
                new Object[] { "GBG", "CMC", "WPW", 'M', CustomItemList.Hull_UMV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'B',
                        OrePrefixes.pipeMedium.get(MaterialsUEVplus.SpaceTime), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getGlass() });
    }

    private void registerElectricFurnace() {

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ElectricFurnaceLuV.get(1L),
                bitsd,
                new Object[] { "WCW", "CMC", "ECE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getHCoil() });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ElectricFurnaceZPM.get(1L),
                bitsd,
                new Object[] { "WCW", "CMC", "ECE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getHCoil() });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ElectricFurnaceUV.get(1L),
                bitsd,
                new Object[] { "WCW", "CMC", "ECE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getHCoil() });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ElectricFurnaceUHV.get(1L),
                bitsd,
                new Object[] { "WCW", "CMC", "ECE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getHCoil() });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ElectricFurnaceUEV.get(1L),
                bitsd,
                new Object[] { "WCW", "CMC", "ECE", 'M', CustomItemList.Hull_UEV, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getHCoil() });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ElectricFurnaceUIV.get(1L),
                bitsd,
                new Object[] { "WCW", "CMC", "ECE", 'M', CustomItemList.Hull_UIV, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getHCoil() });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ElectricFurnaceUMV.get(1L),
                bitsd,
                new Object[] { "WCW", "CMC", "ECE", 'M', CustomItemList.Hull_UMV, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getHCoil() });
    }

    private void registerElectrolyzer() {


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ElectrolyzerLuV.get(1L),
                bitsd,
                new Object[] { "IGI", "IMI", "CWC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'I',
                        OrePrefixes.wireGt02.get(Materials.Osmium), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getGlass() });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ElectrolyzerZPM.get(1L),
                bitsd,
                new Object[] { "IGI", "IMI", "CWC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'I',
                        OrePrefixes.wireGt02.get(Materials.NiobiumTitanium), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getGlass() });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ElectrolyzerUV.get(1L),
                bitsd,
                new Object[] { "IGI", "IMI", "CWC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'I',
                        OrePrefixes.wireGt04.get(Materials.VanadiumGallium), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getGlass() });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ElectrolyzerUHV.get(1L),
                bitsd,
                new Object[] { "IGI", "IMI", "CWC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'I',
                        OrePrefixes.wireGt04.get(Materials.Osmiridium), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ElectrolyzerUEV.get(1L),
                bitsd,
                new Object[] { "IGI", "IMI", "CWC", 'M', CustomItemList.Hull_UEV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'I',
                        OrePrefixes.wireGt04.get(Materials.Draconium), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ElectrolyzerUIV.get(1L),
                bitsd,
                new Object[] { "IGI", "IMI", "CWC", 'M', CustomItemList.Hull_UIV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'I',
                        OrePrefixes.wireGt04.get(Materials.DraconiumAwakened), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ElectrolyzerUMV.get(1L),
                bitsd,
                new Object[] { "IGI", "IMI", "CWC", 'M', CustomItemList.Hull_UMV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'I',
                        OrePrefixes.wireGt04.get(Materials.Infinity), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getGlass() });
    }

    private void registerElectromagneticSeparator() {

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ElectromagneticSeparatorLuV.get(1L),
                bitsd,
                new Object[] { "VWZ", "WMS", "CWZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getWire(), 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ElectromagneticSeparatorZPM.get(1L),
                bitsd,
                new Object[] { "VWZ", "WMS", "CWZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getWire(), 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ElectromagneticSeparatorUV.get(1L),
                bitsd,
                new Object[] { "VWZ", "WMS", "CWZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getWire(), 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ElectromagneticSeparatorUHV.get(1L),
                bitsd,
                new Object[] { "VWZ", "WMS", "CWZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getWire(), 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ElectromagneticSeparatorUEV.get(1L),
                bitsd,
                new Object[] { "VWZ", "WMS", "CWZ", 'M', CustomItemList.Hull_UEV, 'S',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getWire(), 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ElectromagneticSeparatorUIV.get(1L),
                bitsd,
                new Object[] { "VWZ", "WMS", "CWZ", 'M', CustomItemList.Hull_UIV, 'S',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getWire(), 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ElectromagneticSeparatorUMV.get(1L),
                bitsd,
                new Object[] { "VWZ", "WMS", "CWZ", 'M', CustomItemList.Hull_UMV, 'S',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getWire(), 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() });
    }

    private void registerExtractor() {

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ExtractorLuV.get(1L),
                bitsd,
                new Object[] { "GCG", "EMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ExtractorZPM.get(1L),
                bitsd,
                new Object[] { "GCG", "EMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ExtractorUV.get(1L),
                bitsd,
                new Object[] { "GCG", "EMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ExtractorUHV.get(1L),
                bitsd,
                new Object[] { "GCG", "EMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ExtractorUEV.get(1L),
                bitsd,
                new Object[] { "GCG", "EMP", "WCW", 'M', CustomItemList.Hull_UEV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ExtractorUIV.get(1L),
                bitsd,
                new Object[] { "GCG", "EMP", "WCW", 'M', CustomItemList.Hull_UIV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ExtractorUMV.get(1L),
                bitsd,
                new Object[] { "GCG", "EMP", "WCW", 'M', CustomItemList.Hull_UMV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getGlass() });

    }

    private void registerExtruder() {

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ExtruderLuV.get(1L),
                bitsd,
                new Object[] { "CCE", "XMP", "CCE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'X',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'P',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getPipe(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getHCoil() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ExtruderZPM.get(1L),
                bitsd,
                new Object[] { "CCE", "XMP", "CCE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'X',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'P',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getPipe(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getHCoil() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ExtruderUV.get(1L),
                bitsd,
                new Object[] { "CCE", "XMP", "CCE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'X',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'P',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getPipe(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getHCoil() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ExtruderUHV.get(1L),
                bitsd,
                new Object[] { "CCE", "XMP", "CCE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'X',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'P',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getPipe(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getHCoil() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ExtruderUEV.get(1L),
                bitsd,
                new Object[] { "CCE", "XMP", "CCE", 'M', CustomItemList.Hull_UEV, 'X',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'P',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getPipe(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getHCoil() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ExtruderUIV.get(1L),
                bitsd,
                new Object[] { "CCE", "XMP", "CCE", 'M', CustomItemList.Hull_UIV, 'X',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'P',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getPipe(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getHCoil() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ExtruderUMV.get(1L),
                bitsd,
                new Object[] { "CCE", "XMP", "CCE", 'M', CustomItemList.Hull_UMV, 'X',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'E',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'P',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getPipe(), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getHCoil() });

    }

    private void registerFluidSolidifier() {

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidSolidifierLuV.get(1L),
                bitsd,
                new Object[] { "PGP", "WMW", "CBC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getGlass(), 'B', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidSolidifierZPM.get(1L),
                bitsd,
                new Object[] { "PGP", "WMW", "CBC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getGlass(), 'B', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidSolidifierUV.get(1L),
                bitsd,
                new Object[] { "PGP", "WMW", "CBC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getGlass(), 'B', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidSolidifierUHV.get(1L),
                bitsd,
                new Object[] { "PGP", "WMW", "CBC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getGlass(), 'B', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidSolidifierUEV.get(1L),
                bitsd,
                new Object[] { "PGP", "WMW", "CBC", 'M', CustomItemList.Hull_UEV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getGlass(), 'B', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidSolidifierUIV.get(1L),
                bitsd,
                new Object[] { "PGP", "WMW", "CBC", 'M', CustomItemList.Hull_UIV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getGlass(), 'B', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FluidSolidifierUMV.get(1L),
                bitsd,
                new Object[] { "PGP", "WMW", "CBC", 'M', CustomItemList.Hull_UMV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'G',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getGlass(), 'B', OreDictNames.craftingChest });

    }

    private void registerFormingPress() {

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FormingPressLuV.get(1L),
                bitsd,
                new Object[] { "WPW", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FormingPressZPM.get(1L),
                bitsd,
                new Object[] { "WPW", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FormingPressUV.get(1L),
                bitsd,
                new Object[] { "WPW", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FormingPressUHV.get(1L),
                bitsd,
                new Object[] { "WPW", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FormingPressUEV.get(1L),
                bitsd,
                new Object[] { "WPW", "CMC", "WPW", 'M', CustomItemList.Hull_UEV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FormingPressUIV.get(1L),
                bitsd,
                new Object[] { "WPW", "CMC", "WPW", 'M', CustomItemList.Hull_UIV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.FormingPressUMV.get(1L),
                bitsd,
                new Object[] { "WPW", "CMC", "WPW", 'M', CustomItemList.Hull_UMV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() });

    }

    private void registerForgeHammer() {

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ForgeHammerLuV.get(1L),
                bitsd,
                new Object[] { "WPW", "CMC", "WAW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'O',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getHCoil(), 'A', OreDictNames.craftingAnvil });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ForgeHammerZPM.get(1L),
                bitsd,
                new Object[] { "WPW", "CMC", "WAW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'O',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getHCoil(), 'A', OreDictNames.craftingAnvil });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ForgeHammerUV.get(1L),
                bitsd,
                new Object[] { "WPW", "CMC", "WAW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'O',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getHCoil(), 'A', OreDictNames.craftingAnvil });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ForgeHammerUHV.get(1L),
                bitsd,
                new Object[] { "WPW", "CMC", "WAW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'O',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getHCoil(), 'A', OreDictNames.craftingAnvil });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ForgeHammerUEV.get(1L),
                bitsd,
                new Object[] { "WPW", "CMC", "WAW", 'M', CustomItemList.Hull_UEV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'O',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getHCoil(), 'A', OreDictNames.craftingAnvil});

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ForgeHammerUIV.get(1L),
                bitsd,
                new Object[] { "WPW", "CMC", "WAW", 'M', CustomItemList.Hull_UIV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'O',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getHCoil(), 'A', OreDictNames.craftingAnvil });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ForgeHammerUMV.get(1L),
                bitsd,
                new Object[] { "WPW", "CMC", "WAW", 'M', CustomItemList.Hull_UMV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'O',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getHCoil(), 'A', OreDictNames.craftingAnvil });

    }

    private void registerLathe() {

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.LatheLuV.get(1L),
                bitsd,
                new Object[] { "WCW", "EMD", "CWP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'D',
                        OreDictNames.craftingIndustrialDiamond });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.LatheZPM.get(1L),
                bitsd,
                new Object[] { "WCW", "EMD", "CWP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'D',
                        OreDictNames.craftingIndustrialDiamond });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.LatheUV.get(1L),
                bitsd,
                new Object[] { "WCW", "EMD", "CWP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'D',
                        OreDictNames.craftingIndustrialDiamond });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.LatheUHV.get(1L),
                bitsd,
                new Object[] { "WCW", "EMD", "CWP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'D',
                        OreDictNames.craftingIndustrialDiamond });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.LatheUEV.get(1L),
                bitsd,
                new Object[] { "WCW", "EMD", "CWP", 'M', CustomItemList.Hull_UEV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'D',
                        OreDictNames.craftingIndustrialDiamond });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.LatheUIV.get(1L),
                bitsd,
                new Object[] { "WCW", "EMD", "CWP", 'M', CustomItemList.Hull_UIV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'D',
                        OreDictNames.craftingIndustrialDiamond });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.LatheUMV.get(1L),
                bitsd,
                new Object[] { "WCW", "EMD", "CWP", 'M', CustomItemList.Hull_UMV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'D',
                        OreDictNames.craftingIndustrialDiamond });

    }

    private void registerPrecisionLaserEngraver() {

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PrecisionLaserEngraverLuV.get(1L),
                bitsd,
                new Object[] { "PEP", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PrecisionLaserEngraverZPM.get(1L),
                bitsd,
                new Object[] { "PEP", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PrecisionLaserEngraverUV.get(1L),
                bitsd,
                new Object[] { "PEP", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PrecisionLaserEngraverUHV.get(1L),
                bitsd,
                new Object[] { "PEP", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PrecisionLaserEngraverUEV.get(1L),
                bitsd,
                new Object[] { "PEP", "CMC", "WCW", 'M', CustomItemList.Hull_UEV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PrecisionLaserEngraverUIV.get(1L),
                bitsd,
                new Object[] { "PEP", "CMC", "WCW", 'M', CustomItemList.Hull_UIV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PrecisionLaserEngraverUMV.get(1L),
                bitsd,
                new Object[] { "PEP", "CMC", "WCW", 'M', CustomItemList.Hull_UMV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() });

    }

    private void registerMacerator() {

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MaceratorLuV.get(1L),
                bitsd,
                new Object[] { "PEG", "WWM", "CCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'G', OreDictNames.craftingGrinder });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MaceratorZPM.get(1L),
                bitsd,
                new Object[] { "PEG", "WWM", "CCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'G', OreDictNames.craftingGrinder });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MaceratorUV.get(1L),
                bitsd,
                new Object[] { "PEG", "WWM", "CCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'G', OreDictNames.craftingGrinder });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MaceratorUHV.get(1L),
                bitsd,
                new Object[] { "PEG", "WWM", "CCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'G', OreDictNames.craftingGrinder });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MaceratorUEV.get(1L),
                bitsd,
                new Object[] { "PEG", "WWM", "CCW", 'M', CustomItemList.Hull_UEV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'G', OreDictNames.craftingGrinder });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MaceratorUIV.get(1L),
                bitsd,
                new Object[] { "PEG", "WWM", "CCW", 'M', CustomItemList.Hull_UIV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'G', OreDictNames.craftingGrinder });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MaceratorUMV.get(1L),
                bitsd,
                new Object[] { "PEG", "WWM", "CCW", 'M', CustomItemList.Hull_UMV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'G', OreDictNames.craftingGrinder });

    }

    private void registerMicrowave() {


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MicrowaveLuV.get(1L),
                bitsd,
                new Object[] { "LWC", "LMR", "LEC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'R',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'C',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CIRCUIT, 'W',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.WIRE, 'L',
                        OrePrefixes.plateDense.get(Materials.Lead) });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MicrowaveZPM.get(1L),
                bitsd,
                new Object[] { "LWC", "LMR", "LEC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'R',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'C',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CIRCUIT, 'W',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.WIRE, 'L',
                        OrePrefixes.plateDense.get(Materials.Lead) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MicrowaveUV.get(1L),
                bitsd,
                new Object[] { "LWC", "LMR", "LEC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'R',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'C',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CIRCUIT, 'W',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.WIRE, 'L',
                        OrePrefixes.plateDense.get(Materials.Lead) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MicrowaveUHV.get(1L),
                bitsd,
                new Object[] { "LWC", "LMR", "LEC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'R',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getWire(), 'L',
                        OrePrefixes.plateDense.get(Materials.Lead) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MicrowaveUEV.get(1L),
                bitsd,
                new Object[] { "LWC", "LMR", "LEC", 'M', CustomItemList.Hull_UEV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'R',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getWire(), 'L',
                        OrePrefixes.plateDense.get(Materials.Lead) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MicrowaveUIV.get(1L),
                bitsd,
                new Object[] { "LWC", "LMR", "LEC", 'M', CustomItemList.Hull_UIV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'R',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getWire(), 'L',
                        OrePrefixes.plateDense.get(Materials.Lead) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.MicrowaveUMV.get(1L),
                bitsd,
                new Object[] { "LWC", "LMR", "LEC", 'M', CustomItemList.Hull_UMV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'R',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getWire(), 'L',
                        OrePrefixes.plateDense.get(Materials.Lead) });

    }

    private void registerOreWashingPlant() {

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.OreWashingPlantLuV.get(1L),
                bitsd,
                new Object[] { "RGR", "CEC", "WMW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'R',
                        OrePrefixes.rotor.get(LuVMat2), 'E', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR,
                        'C', GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'G',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.OreWashingPlantZPM.get(1L),
                bitsd,
                new Object[] { "RGR", "CEC", "WMW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'R',
                        OrePrefixes.rotor.get(Materials.Iridium), 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'G',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.OreWashingPlantUV.get(1L),
                bitsd,
                new Object[] { "RGR", "CEC", "WMW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'R',
                        OrePrefixes.rotor.get(Materials.Osmium), 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'G',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.OreWashingPlantUHV.get(1L),
                bitsd,
                new Object[] { "RGR", "CEC", "WMW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'R',
                        OrePrefixes.rotor.get(Materials.Neutronium), 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'G',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.OreWashingPlantUEV.get(1L),
                bitsd,
                new Object[] { "RGR", "CEC", "WMW", 'M', CustomItemList.Hull_UEV, 'R',
                        OrePrefixes.rotor.get(Materials.CosmicNeutronium), 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'G',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.OreWashingPlantUIV.get(1L),
                bitsd,
                new Object[] { "RGR", "CEC", "WMW", 'M', CustomItemList.Hull_UIV, 'R',
                        OrePrefixes.rotor.get(Materials.Infinity), 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'G',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.OreWashingPlantUMV.get(1L),
                bitsd,
                new Object[] { "RGR", "CEC", "WMW", 'M', CustomItemList.Hull_UMV, 'R',
                        OrePrefixes.rotor.get(MaterialsUEVplus.SpaceTime), 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'G',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP });

    }

    private void registerPolarizer() {

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PolarizerLuV.get(1L),
                bitsd,
                new Object[] { "ZSZ", "WMW", "ZSZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                        OrePrefixes.wireGt02.get(Materials.Osmium), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PolarizerZPM.get(1L),
                bitsd,
                new Object[] { "ZSZ", "WMW", "ZSZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                        OrePrefixes.wireGt04.get(Materials.Osmium), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PolarizerUV.get(1L),
                bitsd,
                new Object[] { "ZSZ", "WMW", "ZSZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                        OrePrefixes.wireGt08.get(Materials.Osmium), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PolarizerUHV.get(1L),
                bitsd,
                new Object[] { "ZSZ", "WMW", "ZSZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                        OrePrefixes.wireGt08.get(Materials.Osmium), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PolarizerUEV.get(1L),
                bitsd,
                new Object[] { "ZSZ", "WMW", "ZSZ", 'M', CustomItemList.Hull_UEV, 'S',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                        OrePrefixes.wireGt08.get(Materials.Osmium), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PolarizerUIV.get(1L),
                bitsd,
                new Object[] { "ZSZ", "WMW", "ZSZ", 'M', CustomItemList.Hull_UIV, 'S',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                        OrePrefixes.wireGt08.get(Materials.Osmium), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PolarizerUMV.get(1L),
                bitsd,
                new Object[] { "ZSZ", "WMW", "ZSZ", 'M', CustomItemList.Hull_UMV, 'S',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                        OrePrefixes.wireGt08.get(Materials.Osmium), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() });

    }

    private void registerRecycler() {

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.RecyclerLuV.get(1L),
                bitsd,
                new Object[] { "GCG", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'G',
                        OrePrefixes.dust.get(Materials.NetherStar) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.RecyclerZPM.get(1L),
                bitsd,
                new Object[] { "GCG", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'G',
                        OrePrefixes.dust.get(Materials.NetherStar) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.RecyclerUV.get(1L),
                bitsd,
                new Object[] { "GCG", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'G',
                        OrePrefixes.dust.get(Materials.NetherStar) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.RecyclerUHV.get(1L),
                bitsd,
                new Object[] { "GCG", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'G',
                        OrePrefixes.dust.get(Materials.NetherStar) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.RecyclerUEV.get(1L),
                bitsd,
                new Object[] { "GCG", "PMP", "WCW", 'M', CustomItemList.Hull_UEV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'G',
                        OrePrefixes.dust.get(Materials.NetherStar) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.RecyclerUIV.get(1L),
                bitsd,
                new Object[] { "GCG", "PMP", "WCW", 'M', CustomItemList.Hull_UIV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'G',
                        OrePrefixes.dust.get(Materials.NetherStar) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.RecyclerUMV.get(1L),
                bitsd,
                new Object[] { "GCG", "PMP", "WCW", 'M', CustomItemList.Hull_UMV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'G',
                        OrePrefixes.dust.get(Materials.NetherStar) });

    }

    private void registerSiftingMachine() {


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.SiftingMachineLuV.get(1L),
                bitsd,
                new Object[] { "WFW", "PMP", "CFC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'F', OreDictNames.craftingFilter,
                        'C', GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.SiftingMachineZPM.get(1L),
                bitsd,
                new Object[] { "WFW", "PMP", "CFC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'F', OreDictNames.craftingFilter,
                        'C', GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.SiftingMachineUV.get(1L),
                bitsd,
                new Object[] { "WFW", "PMP", "CFC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'F', OreDictNames.craftingFilter,
                        'C', GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.SiftingMachineUHV.get(1L),
                bitsd,
                new Object[] { "WFW", "PMP", "CFC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'F', OreDictNames.craftingFilter,
                        'C', GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.SiftingMachineUEV.get(1L),
                bitsd,
                new Object[] { "WFW", "PMP", "CFC", 'M', CustomItemList.Hull_UEV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'F', OreDictNames.craftingFilter,
                        'C', GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.SiftingMachineUIV.get(1L),
                bitsd,
                new Object[] { "WFW", "PMP", "CFC", 'M', CustomItemList.Hull_UIV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'F', OreDictNames.craftingFilter,
                        'C', GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.SiftingMachineUMV.get(1L),
                bitsd,
                new Object[] { "WFW", "PMP", "CFC", 'M', CustomItemList.Hull_UMV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'F', OreDictNames.craftingFilter,
                        'C', GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() });

    }

    private void registerSlicingMachine() {

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.SlicingMachineLuV.get(1L),
                bitsd,
                new Object[] { "WCW", "PMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.SlicingMachineZPM.get(1L),
                bitsd,
                new Object[] { "WCW", "PMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.SlicingMachineUV.get(1L),
                bitsd,
                new Object[] { "WCW", "PMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.SlicingMachineUHV.get(1L),
                bitsd,
                new Object[] { "WCW", "PMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.SlicingMachineUEV.get(1L),
                bitsd,
                new Object[] { "WCW", "PMV", "WCW", 'M', CustomItemList.Hull_UEV.get(1), 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.SlicingMachineUIV.get(1L),
                bitsd,
                new Object[] { "WCW", "PMV", "WCW", 'M', CustomItemList.Hull_UIV.get(1), 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.SlicingMachineUMV.get(1L),
                bitsd,
                new Object[] { "WCW", "PMV", "WCW", 'M', CustomItemList.Hull_UMV.get(1), 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() });

    }

    private void registerThermalCentrifuge() {

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ThermalCentrifugeLuV.get(1L),
                bitsd,
                new Object[] { "CEC", "OMO", "WEW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'O',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getHCoil() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ThermalCentrifugeZPM.get(1L),
                bitsd,
                new Object[] { "CEC", "OMO", "WEW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'O',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getHCoil() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ThermalCentrifugeUV.get(1L),
                bitsd,
                new Object[] { "CEC", "OMO", "WEW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'O',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getHCoil() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ThermalCentrifugeUHV.get(1L),
                bitsd,
                new Object[] { "CEC", "OMO", "WEW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'O',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getHCoil() });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ThermalCentrifugeUEV.get(1L),
                bitsd,
                new Object[] { "CEC", "OMO", "WEW", 'M', CustomItemList.Hull_UEV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'O',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getHCoil() });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ThermalCentrifugeUIV.get(1L),
                bitsd,
                new Object[] { "CEC", "OMO", "WEW", 'M', CustomItemList.Hull_UIV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'O',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getHCoil() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ThermalCentrifugeUMV.get(1L),
                bitsd,
                new Object[] { "CEC", "OMO", "WEW", 'M', CustomItemList.Hull_UMV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'O',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getHCoil() });

    }

    private void registerWiremill() {

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.WiremillLuV.get(1L),
                bitsd,
                new Object[] { "EWE", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.WiremillZPM.get(1L),
                bitsd,
                new Object[] { "EWE", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.WiremillUV.get(1L),
                bitsd,
                new Object[] { "EWE", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.WiremillUHV.get(1L),
                bitsd,
                new Object[] { "EWE", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.WiremillUEV.get(1L),
                bitsd,
                new Object[] { "EWE", "CMC", "EWE", 'M', CustomItemList.Hull_UEV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.WiremillUIV.get(1L),
                bitsd,
                new Object[] { "EWE", "CMC", "EWE", 'M', CustomItemList.Hull_UIV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.WiremillUMV.get(1L),
                bitsd,
                new Object[] { "EWE", "CMC", "EWE", 'M', CustomItemList.Hull_UMV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() });

    }

    private void registerArcFurnace() {

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ArcFurnaceLuV.get(1L),
                bitsd,
                new Object[] { "WGW", "CMC", "PPP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        OrePrefixes.plateDouble.get(LuVMat2), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable4(), 'G',
                        OrePrefixes.cell.get(Materials.Graphite) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ArcFurnaceZPM.get(1L),
                bitsd,
                new Object[] { "WGW", "CMC", "PPP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        OrePrefixes.plateDouble.get(Materials.Iridium), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable4(), 'G',
                        OrePrefixes.cell.get(Materials.Graphite) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ArcFurnaceUV.get(1L),
                bitsd,
                new Object[] { "WGW", "CMC", "PPP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        OrePrefixes.plateDouble.get(Materials.Osmium), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable4(), 'G',
                        OrePrefixes.cell.get(Materials.Graphite) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ArcFurnaceUHV.get(1L),
                bitsd,
                new Object[] { "WGW", "CMC", "PPP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        OrePrefixes.plateTriple.get(Materials.Osmium), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable4(), 'G',
                        OrePrefixes.cell.get(Materials.Graphite) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ArcFurnaceUEV.get(1L),
                bitsd,
                new Object[] { "WGW", "CMC", "PPP", 'M', CustomItemList.Hull_UEV, 'P',
                        OrePrefixes.plateQuadruple.get(Materials.Osmium), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable4(), 'G',
                        OrePrefixes.cell.get(Materials.Graphite) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ArcFurnaceUIV.get(1L),
                bitsd,
                new Object[] { "WGW", "CMC", "PPP", 'M', CustomItemList.Hull_UIV, 'P',
                        OrePrefixes.plateDouble.get(Materials.Osmiridium), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable4(), 'G',
                        OrePrefixes.cell.get(Materials.Graphite) });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ArcFurnaceUMV.get(1L),
                bitsd,
                new Object[] { "WGW", "CMC", "PPP", 'M', CustomItemList.Hull_UMV, 'P',
                        OrePrefixes.plateQuadruple.get(Materials.Osmiridium), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable4(), 'G',
                        OrePrefixes.cell.get(Materials.Graphite) });

    }

    private void registerCentrifuge() {

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CentrifugeLuV.get(1L),
                bitsd,
                new Object[] { "CEC", "WMW", "CEC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CentrifugeZPM.get(1L),
                bitsd,
                new Object[] { "CEC", "WMW", "CEC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CentrifugeUV.get(1L),
                bitsd,
                new Object[] { "CEC", "WMW", "CEC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CentrifugeUHV.get(1L),
                bitsd,
                new Object[] { "CEC", "WMW", "CEC", 'M', ItemList.Hull_MAX, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CentrifugeUEV.get(1L),
                bitsd,
                new Object[] { "CEC", "WMW", "CEC", 'M', CustomItemList.Hull_UEV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CentrifugeUIV.get(1L),
                bitsd,
                new Object[] { "CEC", "WMW", "CEC", 'M', CustomItemList.Hull_UIV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CentrifugeUMV.get(1L),
                bitsd,
                new Object[] { "CEC", "WMW", "CEC", 'M', CustomItemList.Hull_UMV, 'E',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() });

    }

    private void registerPlasmaArcFurnace() {



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PlasmaArcFurnaceLuV.get(1L),
                bitsd,
                new Object[] { "WGW", "CMC", "TPT", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        OrePrefixes.plateDouble.get(LuVMat2), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable4(), 'T',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'G',
                        OrePrefixes.cell.get(Materials.Graphite) });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PlasmaArcFurnaceZPM.get(1L),
                bitsd,
                new Object[] { "WGW", "CMC", "TPT", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        OrePrefixes.plateDouble.get(Materials.Iridium), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable4(), 'T',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'G',
                        OrePrefixes.cell.get(Materials.Graphite) });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PlasmaArcFurnaceUV.get(1L),
                bitsd,
                new Object[] { "WGW", "CMC", "TPT", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        OrePrefixes.plateDouble.get(Materials.Osmium), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable4(), 'T',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'G',
                        OrePrefixes.cell.get(Materials.Graphite) });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PlasmaArcFurnaceUHV.get(1L),
                bitsd,
                new Object[] { "WGW", "CMC", "TPT", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        OrePrefixes.plateTriple.get(Materials.Osmium), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable4(), 'T',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'G',
                        OrePrefixes.cell.get(Materials.Graphite) });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PlasmaArcFurnaceUEV.get(1L),
                bitsd,
                new Object[] { "WGW", "CMC", "TPT", 'M', CustomItemList.Hull_UEV, 'P',
                        OrePrefixes.plateQuadruple.get(Materials.Osmium), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable4(), 'T',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'G',
                        OrePrefixes.cell.get(Materials.Graphite) });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PlasmaArcFurnaceUIV.get(1L),
                bitsd,
                new Object[] { "WGW", "CMC", "TPT", 'M', CustomItemList.Hull_UIV, 'P',
                        OrePrefixes.plateDouble.get(Materials.Osmiridium), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable4(), 'T',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'G',
                        OrePrefixes.cell.get(Materials.Graphite) });



        GT_ModHandler.addCraftingRecipe(
                CustomItemList.PlasmaArcFurnaceUMV.get(1L),
                bitsd,
                new Object[] { "WGW", "CMC", "TPT", 'M', CustomItemList.Hull_UMV, 'P',
                        OrePrefixes.plateQuadruple.get(Materials.Osmiridium), 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable4(), 'T',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'G',
                        OrePrefixes.cell.get(Materials.Graphite) });
    }

    private void registerCanningMachine() {
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CanningMachineLuV.get(1L),
                bitsd,
                new Object[] { "WPW", "CMC", "GGG", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'G',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CanningMachineZPM.get(1L),
                bitsd,
                new Object[] { "WPW", "CMC", "GGG", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'G',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CanningMachineUV.get(1L),
                bitsd,
                new Object[] { "WPW", "CMC", "GGG", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'G',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CanningMachineUHV.get(1L),
                bitsd,
                new Object[] { "WPW", "CMC", "GGG", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'G',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CanningMachineUEV.get(1L),
                bitsd,
                new Object[] { "WPW", "CMC", "GGG", 'M', CustomItemList.Hull_UEV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'G',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS });


        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CanningMachineUIV.get(1L),
                bitsd,
                new Object[] { "WPW", "CMC", "GGG", 'M', CustomItemList.Hull_UIV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'G',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CanningMachineUMV.get(1L),
                bitsd,
                new Object[] { "WPW", "CMC", "GGG", 'M', CustomItemList.Hull_UMV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'G',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS });
    }

    private void registerChemicalBath() {
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ChemicalBathLuV.get(1L),
                bitsd,
                new Object[] { "VGW", "PGV", "CMC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.LuV.getCable(), 'G',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ChemicalBathZPM.get(1L),
                bitsd,
                new Object[] { "VGW", "PGV", "CMC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.ZPM.getCable(), 'G',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ChemicalBathUV.get(1L),
                bitsd,
                new Object[] { "VGW", "PGV", "CMC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UV.getCable(), 'G',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ChemicalBathUHV.get(1L),
                bitsd,
                new Object[] { "VGW", "PGV", "CMC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable(), 'G',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ChemicalBathUEV.get(1L),
                bitsd,
                new Object[] { "VGW", "PGV", "CMC", 'M', CustomItemList.Hull_UEV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable(), 'G',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ChemicalBathUIV.get(1L),
                bitsd,
                new Object[] { "VGW", "PGV", "CMC", 'M', CustomItemList.Hull_UIV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable(), 'G',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.ChemicalBathUMV.get(1L),
                bitsd,
                new Object[] { "VGW", "PGV", "CMC", 'M', CustomItemList.Hull_UMV, 'P',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'V',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable(), 'G',
                        GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS });
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

    private void registerNameRemover() {
        CustomItemList.nameRemover
                .set(new NameRemover(NAME_REMOVER.ID, "fix.name.remover", "Name Remover", 0).getStackForm(1L));
    }

    private void registerCircuitAssembler() {
        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CircuitAssemblerUHV.get(1L),
                bitsd,
                new Object[] { "RCE", "KHK", "WCW", 'R', ItemList.Robot_Arm_UHV, 'E', ItemList.Emitter_UHV, 'H',
                        ItemList.Hull_MAX, 'K', ItemList.Conveyor_Module_UHV, 'C',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCircuit(), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UHV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CircuitAssemblerUEV.get(1L),
                bitsd,
                new Object[] { "RCE", "KHK", "WCW", 'R', ItemList.Robot_Arm_UEV, 'E', ItemList.Emitter_UEV, 'H',
                        CustomItemList.Hull_UEV, 'K', ItemList.Conveyor_Module_UEV, 'C',
                        OrePrefixes.circuit.get(Materials.UIV), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UEV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CircuitAssemblerUIV.get(1L),
                bitsd,
                new Object[] { "RCE", "KHK", "WCW", 'R', ItemList.Robot_Arm_UIV, 'E', ItemList.Emitter_UIV, 'H',
                        CustomItemList.Hull_UIV, 'K', ItemList.Conveyor_Module_UIV, 'C',
                        OrePrefixes.circuit.get(Materials.UMV), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UIV.getCable() });

        GT_ModHandler.addCraftingRecipe(
                CustomItemList.CircuitAssemblerUMV.get(1L),
                bitsd,
                new Object[] { "RCE", "KHK", "WCW", 'R', ItemList.Robot_Arm_UMV, 'E', ItemList.Emitter_UMV, 'H',
                        CustomItemList.Hull_UMV, 'K', ItemList.Conveyor_Module_UMV, 'C',
                        OrePrefixes.circuit.get(Materials.UXV), 'W',
                        GT_CustomLoader.AdvancedGTMaterials.UMV.getCable() });
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
