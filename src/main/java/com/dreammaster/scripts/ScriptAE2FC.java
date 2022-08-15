package com.dreammaster.scripts;
import com.dreammaster.gthandler.CustomItemList;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import com.glodblock.github.common.Config;
import com.glodblock.github.common.item.ItemBasicFluidStorageCell;
import com.glodblock.github.common.storage.CellType;
import com.glodblock.github.util.ModAndClassUtil;

import static com.glodblock.github.loader.ItemAndBlockHolder.*;
import static gregtech.api.util.GT_ModHandler.getModItem;

public class ScriptAE2FC implements IScriptLoader {

    public ScriptAE2FC(){

    }

    @Override
    public void initScriptData(){
        scriptName.setLength(0);
        scriptName.append("AE2FC");
        dependencies.clear();
        dependencies.addAll(java.util.Arrays.asList("ae2fc", "appliedenergistics2", "extracells"));
    }

    @Override
    public void loadRecipes() {
        final ItemStack AE2_INTERFACE = GameRegistry.findItemStack("appliedenergistics2", "tile.BlockInterface", 1);
        final ItemStack AE2_PROCESS_ENG = new ItemStack(GameRegistry.findItem("appliedenergistics2", "item.ItemMultiMaterial"), 1, 24);
        final ItemStack AE2_STORAGE_BUS = new ItemStack(GameRegistry.findItem("appliedenergistics2", "item.ItemMultiPart"), 1, 220);
        final ItemStack AE2_GLASS_CABLE = new ItemStack(GameRegistry.findItem("appliedenergistics2", "item.ItemMultiPart"), 1, 16);
        final ItemStack AE2_PROCESS_CAL = new ItemStack(GameRegistry.findItem("appliedenergistics2", "item.ItemMultiMaterial"), 1, 23);
        final ItemStack AE2_WORK_BENCH = GameRegistry.findItemStack("appliedenergistics2", "tile.BlockCellWorkbench", 1);
        final ItemStack AE2_PATTERN_TERM = new ItemStack(GameRegistry.findItem("appliedenergistics2", "item.ItemMultiPart"), 1, 340);
        final ItemStack AE2_PROCESS_LOG = new ItemStack(GameRegistry.findItem("appliedenergistics2", "item.ItemMultiMaterial"), 1, 22);
        final ItemStack AE2_PURE_CERTUS = new ItemStack(GameRegistry.findItem("appliedenergistics2", "item.ItemMultiMaterial"), 1, 10);
        final ItemStack AE2_QUARTZ_GLASS = GameRegistry.findItemStack("appliedenergistics2", "tile.BlockQuartzGlass", 1);
        final ItemStack AE2_LAMP_GLASS = GameRegistry.findItemStack("appliedenergistics2", "tile.BlockQuartzLamp", 1);
        final ItemStack AE2_CELL_HOUSING = new ItemStack(GameRegistry.findItem("appliedenergistics2", "item.ItemMultiMaterial"), 1, 39);
        final ItemStack AE2_CORE_ANN = new ItemStack(GameRegistry.findItem("appliedenergistics2", "item.ItemMultiMaterial"), 1, 44);
        final ItemStack AE2_CORE_FOM = new ItemStack(GameRegistry.findItem("appliedenergistics2", "item.ItemMultiMaterial"), 1, 43);
        final ItemStack AE2_BLANK_PATTERN = new ItemStack(GameRegistry.findItem("appliedenergistics2", "item.ItemMultiMaterial"), 1, 52);
        final ItemStack BUCKET = new ItemStack(Items.bucket, 1);
        final ItemStack IRON_BAR = new ItemStack(Blocks.iron_bars, 1);
        final ItemStack IRON_PLATE = GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L);
        final ItemStack LAPIS_PLATE = GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 1L);
        final ItemStack NIOBIUM_PLATE = GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NiobiumTitanium, 1L);
        final ItemStack CERTUS_PLATE = GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L);
        final ItemStack LAPIS_SCREW = GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Lapis, 1L);
        final ItemStack FLUID_CORE_1 = getModItem("dreamcraft", "item.EngineeringProcessorFluidDiamondCore", 1);
        //registering cell
        if (Config.fluidCells) {
            OreDictionary.registerOre("anyCertusCrystal", AE2_PURE_CERTUS);
            for (ItemStack it : OreDictionary.getOres("crystalCertusQuartz"))
                OreDictionary.registerOre("anyCertusCrystal", it);

            ItemBasicFluidStorageCell[] cells = new ItemBasicFluidStorageCell[]{
                    CELL1K, CELL4K, CELL16K, CELL64K, CELL256K, CELL1024K, CELL4096K
            };

            for (ItemBasicFluidStorageCell cell : cells) {
                GameRegistry.addRecipe(new ShapedOreRecipe(cell, "GDG", "DCD", "III", 'D', "dustRedstone", 'G', AE2_QUARTZ_GLASS, 'C', cell.getComponent(), 'I', "ingotIron"));
                GameRegistry.addRecipe(new ShapelessOreRecipe(cell, AE2_CELL_HOUSING, cell.getComponent()));
            }
        }
        //recursive components for those who want to do this weird stuff
        GameRegistry.addRecipe(new ShapedOreRecipe(CellType.Cell1kPart.stack(1), "DCD", "CEC", "DCD", 'D', "dyeBlue", 'C', "anyCertusCrystal", 'E', AE2_PROCESS_ENG));
        GameRegistry.addRecipe(new ShapedOreRecipe(CellType.Cell4kPart.stack(1), "DPD", "CGC", "DCD", 'D', "dyeBlue", 'C', CellType.Cell1kPart.stack(1), 'P', AE2_PROCESS_CAL, 'G', AE2_QUARTZ_GLASS));
        GameRegistry.addRecipe(new ShapedOreRecipe(CellType.Cell16kPart.stack(1), "DPD", "CGC", "DCD", 'D', "dyeBlue", 'C', CellType.Cell4kPart.stack(1), 'P', AE2_PROCESS_LOG, 'G', AE2_QUARTZ_GLASS));
        GameRegistry.addRecipe(new ShapedOreRecipe(CellType.Cell64kPart.stack(1), "DPD", "CGC", "DCD", 'D', "dyeBlue", 'C', CellType.Cell16kPart.stack(1), 'P', AE2_PROCESS_ENG, 'G', AE2_QUARTZ_GLASS));
        GameRegistry.addRecipe(new ShapedOreRecipe(CellType.Cell256kPart.stack(1), "DPD", "CGC", "DCD", 'D', "dyeBlue", 'C', CellType.Cell64kPart.stack(1), 'P', AE2_PROCESS_CAL, 'G', AE2_LAMP_GLASS));
        GameRegistry.addRecipe(new ShapedOreRecipe(CellType.Cell1024kPart.stack(1), "DPD", "CGC", "DCD", 'D', "dyeBlue", 'C', CellType.Cell256kPart.stack(1), 'P', AE2_PROCESS_LOG, 'G', AE2_LAMP_GLASS));
        GameRegistry.addRecipe(new ShapedOreRecipe(CellType.Cell4096kPart.stack(1), "DPD", "CGC", "DCD", 'D', "dyeBlue", 'C', CellType.Cell1024kPart.stack(1), 'P', AE2_PROCESS_ENG, 'G', AE2_LAMP_GLASS));

        //Big Long But: Components in Circuit Assembler
        // 1k ME Storage Component
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 2),
                        CustomItemList.ChargedCertusQuartzDust.get(2),
                        ItemList.Electric_Pump_LV.get(1),
                        ItemList.Circuit_Board_Basic.get(1),
                        GT_Utility.getIntegratedCircuit(1)
                },
                Materials.Lead.getMolten(288),
                CellType.Cell1kPart.stack(1),
                200,
                30,
                false
        );

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 2),
                        CustomItemList.ChargedCertusQuartzDust.get(2),
                        ItemList.Electric_Pump_LV.get(1),
                        ItemList.Circuit_Board_Basic.get(1),
                        GT_Utility.getIntegratedCircuit(1)
                },
                Materials.Tin.getMolten(144),
                CellType.Cell1kPart.stack(1),
                200,
                30,
                false
        );

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 2),
                        CustomItemList.ChargedCertusQuartzDust.get(2),
                        ItemList.Electric_Pump_LV.get(1),
                        ItemList.Circuit_Board_Basic.get(1),
                        GT_Utility.getIntegratedCircuit(1)
                },
                Materials.SolderingAlloy.getMolten(72),
                CellType.Cell1kPart.stack(1),
                200,
                30,
                false
        );

        // 4k ME Storage Component
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 16),
                        ItemList.Electric_Pump_LV.get(2),
                        ItemList.Circuit_Board_Coated_Basic.get(1),
                        GT_Utility.getIntegratedCircuit(1)
                },
                Materials.Lead.getMolten(288),
                CellType.Cell4kPart.stack(1),
                200,
                30,
                true
        );

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 16),
                        ItemList.Electric_Pump_LV.get(2),
                        ItemList.Circuit_Board_Coated_Basic.get(1),
                        GT_Utility.getIntegratedCircuit(1)
                },
                Materials.Tin.getMolten(144),
                CellType.Cell4kPart.stack(1),
                200,
                30,
                true
        );

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 16),
                        ItemList.Electric_Pump_LV.get(2),
                        ItemList.Circuit_Board_Coated_Basic.get(1),
                        GT_Utility.getIntegratedCircuit(1)
                },
                Materials.SolderingAlloy.getMolten(72),
                CellType.Cell4kPart.stack(1),
                200,
                30,
                true
        );

        // 16k ME Storage Component
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 16),
                        ItemList.Electric_Pump_MV.get(1),
                        ItemList.Circuit_Board_Phenolic_Good.get(1),
                        GT_Utility.getIntegratedCircuit(1)
                },
                Materials.Lead.getMolten(288),
                CellType.Cell16kPart.stack(1),
                200,
                120,
                true
        );

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 16),
                        ItemList.Electric_Pump_MV.get(1),
                        ItemList.Circuit_Board_Phenolic_Good.get(1),
                        GT_Utility.getIntegratedCircuit(1)
                },
                Materials.Tin.getMolten(144),
                CellType.Cell16kPart.stack(1),
                200,
                120,
                true
        );

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 16),
                        ItemList.Electric_Pump_MV.get(1),
                        ItemList.Circuit_Board_Phenolic_Good.get(1),
                        GT_Utility.getIntegratedCircuit(1)
                },
                Materials.SolderingAlloy.getMolten(72),
                CellType.Cell16kPart.stack(1),
                200,
                120,
                true
        );

        // 64k ME Storage Component
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 16),
                        ItemList.Electric_Pump_MV.get(2),
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1),
                        GT_Utility.getIntegratedCircuit(1)
                },
                Materials.Lead.getMolten(288),
                CellType.Cell64kPart.stack(1),
                200,
                480,
                true
        );

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 16),
                        ItemList.Electric_Pump_MV.get(2),
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1),
                        GT_Utility.getIntegratedCircuit(1)
                },
                Materials.Tin.getMolten(144),
                CellType.Cell64kPart.stack(1),
                200,
                480,
                true
        );

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 16),
                        ItemList.Electric_Pump_MV.get(2),
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1),
                        GT_Utility.getIntegratedCircuit(1)
                },
                Materials.SolderingAlloy.getMolten(72),
                CellType.Cell64kPart.stack(1),
                200,
                480,
                true
        );
        // 256k ME Storage Component
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 16),
                        ItemList.Electric_Pump_HV.get(1),
                        ItemList.Circuit_Board_Fiberglass_Advanced.get(1),
                        GT_Utility.getIntegratedCircuit(1)
                },
                Materials.Lead.getMolten(288),
                CellType.Cell256kPart.stack(1),
                200,
                1920,
                true
        );

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 16),
                        ItemList.Electric_Pump_HV.get(1),
                        ItemList.Circuit_Board_Fiberglass_Advanced.get(1),
                        GT_Utility.getIntegratedCircuit(1)
                },
                Materials.Tin.getMolten(144),
                CellType.Cell256kPart.stack(1),
                200,
                1920,
                true
        );

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 16),
                        ItemList.Electric_Pump_HV.get(1),
                        ItemList.Circuit_Board_Fiberglass_Advanced.get(1),
                        GT_Utility.getIntegratedCircuit(1)
                },
                Materials.SolderingAlloy.getMolten(72),
                CellType.Cell256kPart.stack(1),
                200,
                1920,
                true
        );

        // 1024k ME Storage Component
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 16),
                        ItemList.Electric_Pump_HV.get(2),
                        ItemList.Circuit_Board_Multifiberglass_Elite.get(1),
                        GT_Utility.getIntegratedCircuit(1)
                },
                Materials.Lead.getMolten(288),
                CellType.Cell1024kPart.stack(1),
                200,
                7680,
                true
        );

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 16),
                        ItemList.Electric_Pump_HV.get(2),
                        ItemList.Circuit_Board_Multifiberglass_Elite.get(1),
                        GT_Utility.getIntegratedCircuit(1)
                },
                Materials.Tin.getMolten(144),
                CellType.Cell1024kPart.stack(1),
                200,
                7680,
                true
        );

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 16),
                        ItemList.Electric_Pump_HV.get(2),
                        ItemList.Circuit_Board_Multifiberglass_Elite.get(1),
                        GT_Utility.getIntegratedCircuit(1)
                },
                Materials.SolderingAlloy.getMolten(72),
                CellType.Cell1024kPart.stack(1),
                200,
                7680,
                true
        );

        // 4096k ME Storage Component
        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 16),
                        ItemList.Electric_Pump_EV.get(1),
                        ItemList.Circuit_Board_Wetware_Extreme.get(1),
                        GT_Utility.getIntegratedCircuit(1)
                },
                Materials.Lead.getMolten(288),
                CellType.Cell4096kPart.stack(1),
                200,
                30720,
                true
        );

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 16),
                        ItemList.Electric_Pump_EV.get(1),
                        ItemList.Circuit_Board_Wetware_Extreme.get(1),
                        GT_Utility.getIntegratedCircuit(1)
                },
                Materials.Tin.getMolten(144),
                CellType.Cell4096kPart.stack(1),
                200,
                30720,
                true
        );

        GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 16),
                        ItemList.Electric_Pump_EV.get(1),
                        ItemList.Circuit_Board_Wetware_Extreme.get(1),
                        GT_Utility.getIntegratedCircuit(1)
                },
                Materials.SolderingAlloy.getMolten(72),
                CellType.Cell4096kPart.stack(1),
                200,
                30720,
                true
        );

        //interface
        addShapedRecipe(INTERFACE.stack(), new Object[]{
                IRON_PLATE, LAPIS_PLATE, IRON_PLATE,
                FLUID_CORE_1, AE2_INTERFACE, FLUID_CORE_1,
                IRON_PLATE, LAPIS_PLATE, IRON_PLATE});
        //Fluid discretizer
        addShapedRecipe(DISCRETIZER.stack(), new Object[]{
                IRON_PLATE, BUCKET, IRON_PLATE,
                AE2_STORAGE_BUS, ItemList.Electric_Pump_EV.get(1), AE2_STORAGE_BUS,
                IRON_PLATE, AE2_PROCESS_ENG, IRON_PLATE});
        //Fluid encoder
        addShapedRecipe(ENCODER.stack(), new Object[]{
                LAPIS_PLATE, ItemList.Machine_HV_Assembler.get(1), LAPIS_PLATE,
                IRON_PLATE, AE2_WORK_BENCH, IRON_PLATE,
                IRON_PLATE, IRON_PLATE, IRON_PLATE});
        //Fluid encoder
        addShapedRecipe(DECODER.stack(), new Object[]{
                IRON_PLATE, ItemList.Machine_HV_Disassembler.get(1), IRON_PLATE,
                AE2_GLASS_CABLE, AE2_WORK_BENCH, AE2_GLASS_CABLE,
                IRON_PLATE, IRON_PLATE, IRON_PLATE});
        //Ingredient Buffer
        addShapedRecipe(BUFFER.stack(), new Object[]{
                IRON_PLATE, FLUID_CORE_1, IRON_PLATE,
                BUCKET, AE2_WORK_BENCH, BUCKET,
                IRON_PLATE, AE2_PROCESS_CAL, IRON_PLATE});
        //Large Ingredient Buffer
        addShapedRecipe(LARGE_BUFFER.stack(), new Object[]{
                NIOBIUM_PLATE, FLUID_CORE_1, NIOBIUM_PLATE,
                ItemList.Super_Tank_LV.get(1), BUFFER.stack(), ItemList.Super_Chest_LV.get(1),
                NIOBIUM_PLATE, AE2_PROCESS_CAL, NIOBIUM_PLATE});
        //Fluid Terminal
        addShapedRecipe(FLUID_TERMINAL.stack(), new Object[]{
                NIOBIUM_PLATE, FLUID_CORE_1, NIOBIUM_PLATE,
                BUCKET, AE2_PATTERN_TERM, BUCKET,
                NIOBIUM_PLATE, AE2_PROCESS_CAL, NIOBIUM_PLATE});
        //Fluid Processing Terminal
        addShapedRecipe(FLUID_TERMINAL_EX.stack(), new Object[]{
                LAPIS_PLATE, FLUID_TERMINAL.stack(), LAPIS_PLATE,
                ItemList.Conveyor_Module_LuV.get(1), AE2_CORE_ANN, ItemList.Conveyor_Module_LuV.get(1),
                ItemList.Electric_Motor_LuV.get(1), ItemList.Robot_Arm_LuV.get(1), ItemList.Electric_Motor_LuV.get(1)});

        if (Config.fluidIOBus) {
            //Fluid Export Bus
            addShapedRecipe(FLUID_EXPORT_BUS.stack(), new Object[]{
                    IRON_PLATE, LAPIS_PLATE, IRON_PLATE,
                    LAPIS_SCREW, AE2_CORE_FOM, LAPIS_SCREW,
                    CERTUS_PLATE, ItemList.Electric_Piston_LV.get(1), CERTUS_PLATE});
            //Fluid Import Bus
            addShapedRecipe(FLUID_IMPORT_BUS.stack(), new Object[]{
                    IRON_PLATE, LAPIS_PLATE, IRON_PLATE,
                    LAPIS_SCREW, AE2_CORE_ANN, LAPIS_SCREW,
                    CERTUS_PLATE, ItemList.Electric_Piston_LV.get(1), CERTUS_PLATE});
        }
        //OC Component
        if (ModAndClassUtil.OC) {
            ItemStack CHIP_T1 = new ItemStack(GameRegistry.findItem("OpenComputers", "item"), 1, 24);
            GameRegistry.addRecipe(new ShapedOreRecipe(OC_EDITOR, "IMI", "CBC", "IPI", 'I', IRON_BAR, 'M', CHIP_T1, 'C', "oc:cable", 'B', BUCKET, 'P', AE2_BLANK_PATTERN));
        }

    }

}
