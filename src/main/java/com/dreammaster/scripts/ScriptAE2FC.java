package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.dreammaster.gthandler.CustomItemList;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_ModHandler.RecipeBits;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class ScriptAE2FC implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "AE2FC";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList("ae2fc", "appliedenergistics2", "OpenComputers");
    }

    @Override
    public void loadRecipes() {
        final ItemStack AE2_INTERFACE = getModItem("appliedenergistics2", "tile.BlockInterface", 1);
        final ItemStack AE2_PROCESS_ENG = getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24);
        final ItemStack AE2_STORAGE_BUS = getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 220);
        final ItemStack AE2_GLASS_CABLE = getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16);
        final ItemStack AE2_PROCESS_CAL = getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 23);
        final ItemStack AE2_WORK_BENCH = getModItem("appliedenergistics2", "tile.BlockCellWorkbench", 1);
        final ItemStack AE2_PATTERN_TERM = getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 340);
        final ItemStack AE2_TERM = getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 380);
        final ItemStack AE2_INTERFACE_TERM = getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 480);
        final ItemStack AE2_PROCESS_LOG = getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22);
        final ItemStack AE2_QUARTZ_GLASS = getModItem("appliedenergistics2", "tile.BlockQuartzGlass", 1);
        final ItemStack AE2_LAMP_GLASS = getModItem("appliedenergistics2", "tile.BlockQuartzLamp", 1);
        final ItemStack AE2_ME_CHEST = getModItem("appliedenergistics2", "tile.BlockChest", 1, 0);
        final ItemStack AE2_ENERGY_CELL = getModItem("appliedenergistics2", "tile.BlockEnergyCell", 1, 0);
        final ItemStack AE2_CELL_HOUSING = getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 39);
        final ItemStack AE2_CORE_ANN = getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 44);
        final ItemStack AE2_CORE_FOM = getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 43);
        final ItemStack AE2_BLANK_PATTERN = getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 52);
        final ItemStack AE2_CARD_CRAFTING = getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 53);
        final ItemStack AE2_LEVEL_MAIN = getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 280);
        final ItemStack AE2_MON = getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 400);
        final ItemStack AE2_CON = getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 420);
        final ItemStack AE2_ITEM_WIRELESS = getModItem(
                "appliedenergistics2",
                "item.ToolWirelessTerminal",
                1,
                OreDictionary.WILDCARD_VALUE);
        final ItemStack AE2_PURE_CERTUS = new ItemStack(
                GameRegistry.findItem("appliedenergistics2", "item.ItemMultiMaterial"),
                1,
                10);
        final ItemStack BUCKET = new ItemStack(Items.bucket, 1);
        final ItemStack IRON_BAR = new ItemStack(Blocks.iron_bars, 1);
        final ItemStack IRON_PLATE = GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L);
        final ItemStack LAPIS_PLATE = GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 1L);
        final ItemStack NIOBIUM_PLATE = GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NiobiumTitanium, 1L);
        final ItemStack NETHER_QUARTZ_PLATE = GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L);
        final ItemStack LAPIS_SCREW = GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Lapis, 1L);
        final ItemStack FLUID_CORE_1 = getModItem("dreamcraft", "item.EngineeringProcessorFluidDiamondCore", 1);
        final ItemStack FISH = getModItem("minecraft", "fish", 1, 0);
        final ItemStack CELL_1 = getModItem("ae2fc", "fluid_storage1", 1, 0);
        final ItemStack CELL_4 = getModItem("ae2fc", "fluid_storage4", 1, 0);
        final ItemStack CELL_16 = getModItem("ae2fc", "fluid_storage16", 1, 0);
        final ItemStack CELL_64 = getModItem("ae2fc", "fluid_storage64", 1, 0);
        final ItemStack CELL_256 = getModItem("ae2fc", "fluid_storage256", 1, 0);
        final ItemStack CELL_1024 = getModItem("ae2fc", "fluid_storage1024", 1, 0);
        final ItemStack CELL_4096 = getModItem("ae2fc", "fluid_storage4096", 1, 0);
        final ItemStack CELL_16384 = getModItem("ae2fc", "fluid_storage16384", 1, 0);
        final ItemStack COMPONENT_1 = getModItem("ae2fc", "fluid_part", 1, 0);
        final ItemStack COMPONENT_4 = getModItem("ae2fc", "fluid_part", 1, 1);
        final ItemStack COMPONENT_16 = getModItem("ae2fc", "fluid_part", 1, 2);
        final ItemStack COMPONENT_64 = getModItem("ae2fc", "fluid_part", 1, 3);
        final ItemStack COMPONENT_256 = getModItem("ae2fc", "fluid_part", 1, 4);
        final ItemStack COMPONENT_1024 = getModItem("ae2fc", "fluid_part", 1, 5);
        final ItemStack COMPONENT_4096 = getModItem("ae2fc", "fluid_part", 1, 6);
        final ItemStack COMPONENT_16384 = getModItem("ae2fc", "fluid_part", 1, 7);
        final ItemStack AE2FC_INTERFACE = getModItem("ae2fc", "fluid_interface", 1, 0);
        final ItemStack AE2FC_INTERFACE_SMALL = getModItem("ae2fc", "part_fluid_interface", 1, 0);
        final ItemStack AE2FC_DISCRETIZER = getModItem("ae2fc", "fluid_discretizer", 1, 0);
        final ItemStack AE2FC_ENCODER = getModItem("ae2fc", "fluid_pattern_encoder", 1, 0);
        final ItemStack AE2FC_DECODER = getModItem("ae2fc", "fluid_packet_decoder", 1, 0);
        final ItemStack AE2FC_BUFFER = getModItem("ae2fc", "ingredient_buffer", 1, 0);
        final ItemStack AE2FC_BUFFER_LARGE = getModItem("ae2fc", "large_ingredient_buffer", 1, 0);
        final ItemStack AE2FC_TERMINAL = getModItem("ae2fc", "part_fluid_pattern_terminal", 1, 0);
        final ItemStack AE2FC_TERMINAL_PRO = getModItem("ae2fc", "part_fluid_pattern_terminal_ex", 1, 0);
        final ItemStack AE2FC_EXPORTBUS = getModItem("ae2fc", "part_fluid_export", 1, 0);
        final ItemStack AE2FC_IMPORTBUS = getModItem("ae2fc", "part_fluid_import", 1, 0);
        final ItemStack AE2FC_OCEDITOR = getModItem("ae2fc", "oc_pattern_editor", 1, 0);
        final ItemStack AE2FC_MAINTAIN = getModItem("ae2fc", "level_maintainer", 1, 0);
        final ItemStack AE2FC_FLUID_TERMINAL = getModItem("ae2fc", "part_fluid_terminal", 1, 0);
        final ItemStack AE2FC_FLUID_BUFFER = getModItem("ae2fc", "fluid_buffer", 1, 0);
        final ItemStack AE2FC_FLUID_STORAGE_BUS = getModItem("ae2fc", "part_fluid_storage_bus", 1, 0);
        final ItemStack AE2FC_AUTO_FILLER = getModItem("ae2fc", "fluid_auto_filler", 1, 0);
        final ItemStack AE2FC_LEVEL_MAIN = getModItem("ae2fc", "part_fluid_level_emitter", 1, 0);
        final ItemStack AE2FC_PORTABLE_CELL = getModItem("ae2fc", "portable_fluid_cell", 1, 0);
        final ItemStack AE2FC_TANK = getModItem("ae2fc", "certus_quartz_tank", 1, 0);
        final ItemStack AE2FC_WALRUS = getModItem("ae2fc", "walrus", 1, 0);
        final ItemStack AE2FC_MON = getModItem("ae2fc", "part_fluid_storage_monitor", 1, 0);
        final ItemStack AE2FC_CON = getModItem("ae2fc", "part_fluid_conversion_monitor", 1, 0);
        final ItemStack AE2FC_FLUID_WIRELESS = getModItem("ae2fc", "wireless_fluid_terminal", 1, 0);
        final ItemStack AE2FC_PATTERN_WIRELESS = getModItem("ae2fc", "wireless_fluid_pattern_terminal", 1, 0);
        final ItemStack AE2FC_INTERFACE_WIRELESS = getModItem("ae2fc", "wireless_interface_terminal", 1, 0);

        ItemStack[] cells = new ItemStack[] { CELL_1, CELL_4, CELL_16, CELL_64, CELL_256, CELL_1024, CELL_4096,
                CELL_16384 };
        ItemStack[] components = new ItemStack[] { COMPONENT_1, COMPONENT_4, COMPONENT_16, COMPONENT_64, COMPONENT_256,
                COMPONENT_1024, COMPONENT_4096, COMPONENT_16384 };

        for (int i = 0; i < cells.length; i++) {
            GT_ModHandler.addCraftingRecipe(
                    cells[i],
                    RecipeBits.BUFFERED | RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES,
                    new Object[] { "hCW", "SKS", "WAd", 'C', "plateCertusQuartz", 'W', "screwCertusQuartz", 'S',
                            "plateStainlessSteel", 'K', components[i], 'A', "plateAluminium" });
            GT_ModHandler.addCraftingRecipe(
                    cells[i],
                    RecipeBits.BUFFERED,
                    new Object[] { "dCW", "SKS", "WAh", 'C', "plateCertusQuartz", 'W', "screwCertusQuartz", 'S',
                            "plateStainlessSteel", 'K', components[i], 'A', "plateAluminium" });
            GT_ModHandler.addShapelessCraftingRecipe(cells[i], new Object[] { AE2_CELL_HOUSING, components[i] });
        }

        // recursive components for those who want to do this weird stuff
        GameRegistry.addRecipe(
                new ShapedOreRecipe(
                        COMPONENT_1,
                        "DCD",
                        "CEC",
                        "DCD",
                        'D',
                        "circuitPrimitive",
                        'C',
                        CustomItemList.ChargedCertusQuartzDust.get(1),
                        'E',
                        AE2_PROCESS_ENG));
        GameRegistry.addRecipe(
                new ShapedOreRecipe(
                        COMPONENT_4,
                        "DCD",
                        "CPC",
                        "DCD",
                        'D',
                        "circuitBasic",
                        'C',
                        COMPONENT_1,
                        'P',
                        AE2_PROCESS_CAL));
        GameRegistry.addRecipe(
                new ShapedOreRecipe(
                        COMPONENT_16,
                        "DCD",
                        "CPC",
                        "DCD",
                        'D',
                        "circuitGood",
                        'C',
                        COMPONENT_4,
                        'P',
                        AE2_PROCESS_LOG));
        GameRegistry.addRecipe(
                new ShapedOreRecipe(
                        COMPONENT_64,
                        "DCD",
                        "CPC",
                        "DCD",
                        'D',
                        "circuitAdvanced",
                        'C',
                        COMPONENT_16,
                        'P',
                        AE2_PROCESS_ENG));
        GameRegistry.addRecipe(
                new ShapedOreRecipe(
                        COMPONENT_256,
                        "DCD",
                        "CPC",
                        "DCD",
                        'D',
                        "circuitData",
                        'C',
                        COMPONENT_64,
                        'P',
                        AE2_PROCESS_CAL));
        GameRegistry.addRecipe(
                new ShapedOreRecipe(
                        COMPONENT_1024,
                        "DCD",
                        "CPC",
                        "DCD",
                        'D',
                        "circuitElite",
                        'C',
                        COMPONENT_256,
                        'P',
                        AE2_PROCESS_LOG));
        GameRegistry.addRecipe(
                new ShapedOreRecipe(
                        COMPONENT_4096,
                        "DCD",
                        "CPC",
                        "DCD",
                        'D',
                        "circuitMaster",
                        'C',
                        COMPONENT_1024,
                        'P',
                        AE2_PROCESS_ENG));
        GameRegistry.addRecipe(
                new ShapedOreRecipe(
                        COMPONENT_16384,
                        "DCD",
                        "CPC",
                        "DCD",
                        'D',
                        "circuitSuperconductor",
                        'C',
                        COMPONENT_4096,
                        'P',
                        AE2_PROCESS_CAL));

        // Fluid Storage Bus
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { AE2_STORAGE_BUS, GT_OreDictUnificator.get(OrePrefixes.panel, Materials.Lapis, 3), },
                null,
                AE2FC_FLUID_STORAGE_BUS,
                300,
                120);

        // Big Long But: Components in Circuit Assembler
        // 1k ME Storage Component
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 2),
                        CustomItemList.ChargedCertusQuartzDust.get(2), ItemList.Electric_Pump_LV.get(1),
                        ItemList.Circuit_Board_Basic.get(1), GT_Utility.getIntegratedCircuit(1) },
                Materials.Lead.getMolten(288),
                COMPONENT_1,
                200,
                30,
                false);

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 2),
                        CustomItemList.ChargedCertusQuartzDust.get(2), ItemList.Electric_Pump_LV.get(1),
                        ItemList.Circuit_Board_Basic.get(1), GT_Utility.getIntegratedCircuit(1) },
                Materials.Tin.getMolten(144),
                COMPONENT_1,
                200,
                30,
                false);

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 2),
                        CustomItemList.ChargedCertusQuartzDust.get(2), ItemList.Electric_Pump_LV.get(1),
                        ItemList.Circuit_Board_Basic.get(1), GT_Utility.getIntegratedCircuit(1) },
                Materials.SolderingAlloy.getMolten(72),
                COMPONENT_1,
                200,
                30,
                false);

        // 4k ME Storage Component
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 16),
                        ItemList.Electric_Pump_LV.get(2), ItemList.Circuit_Board_Coated_Basic.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                Materials.Lead.getMolten(288),
                COMPONENT_4,
                200,
                30,
                true);

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 16),
                        ItemList.Electric_Pump_LV.get(2), ItemList.Circuit_Board_Coated_Basic.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                Materials.Tin.getMolten(144),
                COMPONENT_4,
                200,
                30,
                true);

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 16),
                        ItemList.Electric_Pump_LV.get(2), ItemList.Circuit_Board_Coated_Basic.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                Materials.SolderingAlloy.getMolten(72),
                COMPONENT_4,
                200,
                30,
                true);

        // 16k ME Storage Component
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 16),
                        ItemList.Electric_Pump_MV.get(1), ItemList.Circuit_Board_Phenolic_Good.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                Materials.Lead.getMolten(288),
                COMPONENT_16,
                200,
                120,
                true);

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 16),
                        ItemList.Electric_Pump_MV.get(1), ItemList.Circuit_Board_Phenolic_Good.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                Materials.Tin.getMolten(144),
                COMPONENT_16,
                200,
                120,
                true);

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 16),
                        ItemList.Electric_Pump_MV.get(1), ItemList.Circuit_Board_Phenolic_Good.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                Materials.SolderingAlloy.getMolten(72),
                COMPONENT_16,
                200,
                120,
                true);

        // 64k ME Storage Component
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 16),
                        ItemList.Electric_Pump_MV.get(2), ItemList.Circuit_Board_Epoxy_Advanced.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                Materials.Lead.getMolten(288),
                COMPONENT_64,
                200,
                480,
                true);

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 16),
                        ItemList.Electric_Pump_MV.get(2), ItemList.Circuit_Board_Epoxy_Advanced.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                Materials.Tin.getMolten(144),
                COMPONENT_64,
                200,
                480,
                true);

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 16),
                        ItemList.Electric_Pump_MV.get(2), ItemList.Circuit_Board_Epoxy_Advanced.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                Materials.SolderingAlloy.getMolten(72),
                COMPONENT_64,
                200,
                480,
                true);
        // 256k ME Storage Component
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 16),
                        ItemList.Electric_Pump_HV.get(1), ItemList.Circuit_Board_Fiberglass_Advanced.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                Materials.Lead.getMolten(288),
                COMPONENT_256,
                200,
                1920,
                true);

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 16),
                        ItemList.Electric_Pump_HV.get(1), ItemList.Circuit_Board_Fiberglass_Advanced.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                Materials.Tin.getMolten(144),
                COMPONENT_256,
                200,
                1920,
                true);

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 16),
                        ItemList.Electric_Pump_HV.get(1), ItemList.Circuit_Board_Fiberglass_Advanced.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                Materials.SolderingAlloy.getMolten(72),
                COMPONENT_256,
                200,
                1920,
                true);

        // 1024k ME Storage Component
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 16),
                        ItemList.Electric_Pump_HV.get(2), ItemList.Circuit_Board_Multifiberglass_Elite.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                Materials.Lead.getMolten(288),
                COMPONENT_1024,
                200,
                7680,
                true);

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 16),
                        ItemList.Electric_Pump_HV.get(2), ItemList.Circuit_Board_Multifiberglass_Elite.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                Materials.Tin.getMolten(144),
                COMPONENT_1024,
                200,
                7680,
                true);

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 16),
                        ItemList.Electric_Pump_HV.get(2), ItemList.Circuit_Board_Multifiberglass_Elite.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                Materials.SolderingAlloy.getMolten(72),
                COMPONENT_1024,
                200,
                7680,
                true);

        // 4096k ME Storage Component
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 16),
                        ItemList.Electric_Pump_EV.get(1), ItemList.Circuit_Board_Wetware_Extreme.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                Materials.Lead.getMolten(288),
                COMPONENT_4096,
                200,
                30720,
                true);

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 16),
                        ItemList.Electric_Pump_EV.get(1), ItemList.Circuit_Board_Wetware_Extreme.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                Materials.Tin.getMolten(144),
                COMPONENT_4096,
                200,
                30720,
                true);

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 16),
                        ItemList.Electric_Pump_EV.get(1), ItemList.Circuit_Board_Wetware_Extreme.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                Materials.SolderingAlloy.getMolten(72),
                COMPONENT_4096,
                200,
                30720,
                true);

        // 16384k ME Storage Component
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 16),
                        ItemList.Electric_Pump_EV.get(1), ItemList.Circuit_Board_Bio_Ultra.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                Materials.Lead.getMolten(288),
                COMPONENT_16384,
                200,
                500000,
                true);

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 16),
                        ItemList.Electric_Pump_EV.get(1), ItemList.Circuit_Board_Bio_Ultra.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                Materials.Tin.getMolten(144),
                COMPONENT_16384,
                200,
                500000,
                true);

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 16),
                        ItemList.Electric_Pump_EV.get(1), ItemList.Circuit_Board_Bio_Ultra.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                Materials.SolderingAlloy.getMolten(72),
                COMPONENT_16384,
                200,
                500000,
                true);

        // level maintainer
        addShapedRecipe(
                AE2FC_MAINTAIN,
                new Object[] { NIOBIUM_PLATE, AE2_CARD_CRAFTING, NIOBIUM_PLATE, AE2_CORE_ANN, AE2_INTERFACE,
                        FLUID_CORE_1, NIOBIUM_PLATE, AE2_CARD_CRAFTING, NIOBIUM_PLATE });
        // interface
        addShapedRecipe(
                AE2FC_INTERFACE,
                new Object[] { IRON_PLATE, LAPIS_PLATE, IRON_PLATE, FLUID_CORE_1, AE2_INTERFACE, FLUID_CORE_1,
                        IRON_PLATE, LAPIS_PLATE, IRON_PLATE });
        // Fluid discretizer
        addShapedRecipe(
                AE2FC_DISCRETIZER,
                new Object[] { IRON_PLATE, BUCKET, IRON_PLATE, AE2_STORAGE_BUS, ItemList.Electric_Pump_EV.get(1),
                        AE2_STORAGE_BUS, IRON_PLATE, AE2_PROCESS_ENG, IRON_PLATE });
        // Fluid encoder
        addShapedRecipe(
                AE2FC_ENCODER,
                new Object[] { LAPIS_PLATE, ItemList.Machine_HV_Assembler.get(1), LAPIS_PLATE, IRON_PLATE,
                        AE2_WORK_BENCH, IRON_PLATE, IRON_PLATE, IRON_PLATE, IRON_PLATE });
        // Fluid decoder
        addShapedRecipe(
                AE2FC_DECODER,
                new Object[] { IRON_PLATE, ItemList.Machine_HV_Disassembler.get(1), IRON_PLATE, AE2_GLASS_CABLE,
                        AE2_WORK_BENCH, AE2_GLASS_CABLE, IRON_PLATE, IRON_PLATE, IRON_PLATE });
        // Ingredient Buffer
        addShapedRecipe(
                AE2FC_BUFFER,
                new Object[] { IRON_PLATE, FLUID_CORE_1, IRON_PLATE, BUCKET, AE2_WORK_BENCH, BUCKET, IRON_PLATE,
                        AE2_PROCESS_CAL, IRON_PLATE });
        // Large Ingredient Buffer
        addShapedRecipe(
                AE2FC_BUFFER_LARGE,
                new Object[] { NIOBIUM_PLATE, FLUID_CORE_1, NIOBIUM_PLATE, ItemList.Super_Tank_LV.get(1), AE2FC_BUFFER,
                        ItemList.Super_Chest_LV.get(1), NIOBIUM_PLATE, AE2_PROCESS_CAL, NIOBIUM_PLATE });
        // Fluid Buffer
        addShapedRecipe(
                AE2FC_FLUID_BUFFER,
                new Object[] { IRON_PLATE, LAPIS_PLATE, IRON_PLATE, FLUID_CORE_1, AE2FC_BUFFER, FLUID_CORE_1,
                        IRON_PLATE, LAPIS_PLATE, IRON_PLATE });
        // Fluid Terminal
        addShapedRecipe(
                AE2FC_FLUID_TERMINAL,
                new Object[] { LAPIS_PLATE, AE2_GLASS_CABLE, LAPIS_PLATE, AE2_CORE_FOM, AE2_TERM, AE2_CORE_ANN,
                        LAPIS_PLATE, AE2_GLASS_CABLE, LAPIS_PLATE });
        // Fluid Pattern Terminal
        addShapedRecipe(
                AE2FC_TERMINAL,
                new Object[] { NIOBIUM_PLATE, FLUID_CORE_1, NIOBIUM_PLATE, BUCKET, AE2_PATTERN_TERM, BUCKET,
                        NIOBIUM_PLATE, AE2_PROCESS_CAL, NIOBIUM_PLATE });
        // Fluid Processing Pattern Terminal
        addShapedRecipe(
                AE2FC_TERMINAL_PRO,
                new Object[] { LAPIS_PLATE, AE2FC_TERMINAL, LAPIS_PLATE, ItemList.Conveyor_Module_LuV.get(1),
                        AE2_CORE_ANN, ItemList.Conveyor_Module_LuV.get(1), ItemList.Electric_Motor_LuV.get(1),
                        ItemList.Robot_Arm_LuV.get(1), ItemList.Electric_Motor_LuV.get(1) });
        // Fluid Export Bus
        addShapedRecipe(
                AE2FC_EXPORTBUS,
                new Object[] { IRON_PLATE, LAPIS_PLATE, IRON_PLATE, LAPIS_SCREW, AE2_CORE_FOM, LAPIS_SCREW,
                        NETHER_QUARTZ_PLATE, ItemList.Electric_Piston_LV.get(1), NETHER_QUARTZ_PLATE });
        // Fluid Import Bus
        addShapedRecipe(
                AE2FC_IMPORTBUS,
                new Object[] { IRON_PLATE, LAPIS_PLATE, IRON_PLATE, LAPIS_SCREW, AE2_CORE_ANN, LAPIS_SCREW,
                        NETHER_QUARTZ_PLATE, ItemList.Electric_Piston_LV.get(1), NETHER_QUARTZ_PLATE });
        // Fluid Auto Filler
        addShapedRecipe(
                AE2FC_AUTO_FILLER,
                new Object[] { LAPIS_PLATE, AE2FC_FLUID_TERMINAL, LAPIS_PLATE, AE2_GLASS_CABLE, AE2FC_INTERFACE,
                        AE2_GLASS_CABLE, LAPIS_PLATE, AE2FC_LEVEL_MAIN, LAPIS_PLATE });
        // Walrus
        addShapedRecipe(AE2FC_WALRUS, new Object[] { FISH, FISH, FISH, FISH, null, FISH, FISH, FISH, FISH });
        // Fluid Portable Cell
        addShapedRecipe(
                AE2FC_PORTABLE_CELL,
                new Object[] { null, CELL_1, null, LAPIS_SCREW, AE2_ME_CHEST, LAPIS_SCREW, "craftingToolScrewdriver",
                        AE2_ENERGY_CELL, "craftingToolWrench" });
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { CELL_1, GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Lapis, 2), AE2_ME_CHEST,
                        AE2_ENERGY_CELL },
                null,
                AE2FC_PORTABLE_CELL,
                200,
                120);
        // Quartz Tank
        GT_Values.RA.addAssemblerRecipe(
                GT_Utility.copyAmount(8, AE2_QUARTZ_GLASS),
                GT_Utility.getIntegratedCircuit(8),
                null,
                AE2FC_TANK,
                800,
                30);
        // Fluid Level Emitter
        GT_Values.RA.addAssemblerRecipe(AE2_LEVEL_MAIN, LAPIS_PLATE, null, AE2FC_LEVEL_MAIN, 100, 120);
        // Fluid Storage Monitor
        GT_Values.RA.addAssemblerRecipe(
                AE2_MON,
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 3),
                null,
                AE2FC_MON,
                300,
                120);
        // Fluid Conversion Monitor
        GT_Values.RA.addAssemblerRecipe(
                AE2_CON,
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 3),
                null,
                AE2FC_CON,
                300,
                120);
        // Wireless Fluid ME Terminal
        GT_Values.RA.addAssemblerRecipe(AE2_ITEM_WIRELESS, AE2FC_FLUID_TERMINAL, null, AE2FC_FLUID_WIRELESS, 600, 120);
        // Wireless Fluid Pattern Terminal
        GT_Values.RA.addAssemblerRecipe(AE2_ITEM_WIRELESS, AE2FC_TERMINAL, null, AE2FC_PATTERN_WIRELESS, 600, 120);
        // Wireless Interface Terminal
        GT_Values.RA
                .addAssemblerRecipe(AE2_ITEM_WIRELESS, AE2_INTERFACE_TERM, null, AE2FC_INTERFACE_WIRELESS, 600, 120);
        // Interface from Small to Block and opposite
        GameRegistry.addShapelessRecipe(AE2FC_INTERFACE_SMALL, AE2FC_INTERFACE);
        GameRegistry.addShapelessRecipe(AE2FC_INTERFACE, AE2FC_INTERFACE_SMALL);
        // OC Component
        ItemStack CHIP_T1 = getModItem("OpenComputers", "item", 1, 24);
        GameRegistry.addRecipe(
                new ShapedOreRecipe(
                        AE2FC_OCEDITOR,
                        "IMI",
                        "CBC",
                        "IPI",
                        'I',
                        IRON_BAR,
                        'M',
                        CHIP_T1,
                        'C',
                        "oc:cable",
                        'B',
                        BUCKET,
                        'P',
                        AE2_BLANK_PATTERN));
    }
}
