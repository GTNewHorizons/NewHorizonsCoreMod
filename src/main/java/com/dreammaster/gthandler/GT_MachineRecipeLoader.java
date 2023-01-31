package com.dreammaster.gthandler;

import static gregtech.api.enums.GT_Values.*;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.recipes.*;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;

public class GT_MachineRecipeLoader implements Runnable {

    @Override
    public void run() {
        new RecipeRemoval().run();

        new AlloySmelterRecipes().run();
        new AssemblerRecipes().run();
        new AssemblingLineRecipes().run();
        new AutoclaveRecipes().run();
        new BendingMachineRecipes().run();
        new BlastFurnaceRecipes().run();
        new BrewingMachineRecipes().run();
        new CannerRecipes().run();
        new CentrifugeRecipes().run();
        new ChemicalBathRecipes().run();
        new ChemicalReactorRecipes().run();
        new CircuitAssemblerRecipes().run();
        new CompressorRecipes().run();
        new CuttingMachineRecipes().run();
        new DistillationRecipes().run();
        new DTPFRecipes().run();
        new ElectrolyzerRecipes().run();
        new ExtractorRecipes().run();
        new ExtruderRecipes().run();
        new FermenterRecipes().run();
        new FluidCannerRecipes().run();
        new FluidExtractorRecipes().run();
        new FluidSolidifierRecipes().run();
        new ForgeHammerRecipes().run();
        new FormingPressRecipes().run();
        new ImplosionCompressorRecipes().run();
        new LaserEngraverRecipes().run();
        new LatheRecipes().run();
        new MaceratorRecipes().run();
        new MixerRecipes().run();
        new SifterRecipes().run();
        new VacuumFreezerRecipes().run();
        new WiremillRecipes().run();

        if (Loader.isModLoaded("extracells")) {
            // 256k ME Storage Component
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 16),
                            CustomItemList.EngineeringProcessorItemEmeraldCore.get(1),
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1), GT_Utility.getIntegratedCircuit(1) },
                    Materials.Lead.getMolten(288),
                    GT_ModHandler.getModItem("extracells", "storage.component", 1L, 0),
                    200,
                    1920,
                    true);

            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 16),
                            CustomItemList.EngineeringProcessorItemEmeraldCore.get(1),
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1), GT_Utility.getIntegratedCircuit(1) },
                    Materials.Tin.getMolten(144),
                    GT_ModHandler.getModItem("extracells", "storage.component", 1L, 0),
                    200,
                    1920,
                    true);

            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 16),
                            CustomItemList.EngineeringProcessorItemEmeraldCore.get(1),
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1), GT_Utility.getIntegratedCircuit(1) },
                    Materials.SolderingAlloy.getMolten(72),
                    GT_ModHandler.getModItem("extracells", "storage.component", 1L, 0),
                    200,
                    1920,
                    true);

            // 1024k ME Storage Component
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 16),
                            CustomItemList.EngineeringProcessorItemEmeraldCore.get(1),
                            ItemList.Circuit_Board_Multifiberglass_Elite.get(1), GT_Utility.getIntegratedCircuit(1) },
                    Materials.Lead.getMolten(288),
                    GT_ModHandler.getModItem("extracells", "storage.component", 1L, 1),
                    200,
                    7680,
                    true);

            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 16),
                            CustomItemList.EngineeringProcessorItemEmeraldCore.get(1),
                            ItemList.Circuit_Board_Multifiberglass_Elite.get(1), GT_Utility.getIntegratedCircuit(1) },
                    Materials.Tin.getMolten(144),
                    GT_ModHandler.getModItem("extracells", "storage.component", 1L, 1),
                    200,
                    7680,
                    true);

            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 16),
                            CustomItemList.EngineeringProcessorItemEmeraldCore.get(1),
                            ItemList.Circuit_Board_Multifiberglass_Elite.get(1), GT_Utility.getIntegratedCircuit(1) },
                    Materials.SolderingAlloy.getMolten(72),
                    GT_ModHandler.getModItem("extracells", "storage.component", 1L, 1),
                    200,
                    7680,
                    true);

            // 4096k ME Storage Component
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 16),
                            CustomItemList.EngineeringProcessorItemAdvEmeraldCore.get(1),
                            ItemList.Circuit_Board_Wetware_Extreme.get(1), GT_Utility.getIntegratedCircuit(1) },
                    Materials.Lead.getMolten(288),
                    GT_ModHandler.getModItem("extracells", "storage.component", 1L, 2),
                    200,
                    30720,
                    true);

            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 16),
                            CustomItemList.EngineeringProcessorItemAdvEmeraldCore.get(1),
                            ItemList.Circuit_Board_Wetware_Extreme.get(1), GT_Utility.getIntegratedCircuit(1) },
                    Materials.Tin.getMolten(144),
                    GT_ModHandler.getModItem("extracells", "storage.component", 1L, 2),
                    200,
                    30720,
                    true);

            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 16),
                            CustomItemList.EngineeringProcessorItemAdvEmeraldCore.get(1),
                            ItemList.Circuit_Board_Wetware_Extreme.get(1), GT_Utility.getIntegratedCircuit(1) },
                    Materials.SolderingAlloy.getMolten(72),
                    GT_ModHandler.getModItem("extracells", "storage.component", 1L, 2),
                    200,
                    30720,
                    true);

            // 16384k ME Storage Component
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 16),
                            CustomItemList.EngineeringProcessorItemAdvEmeraldCore.get(1),
                            ItemList.Circuit_Board_Bio_Ultra.get(1), GT_Utility.getIntegratedCircuit(1) },
                    Materials.Lead.getMolten(288),
                    GT_ModHandler.getModItem("extracells", "storage.component", 1L, 3),
                    200,
                    500000,
                    true);

            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 16),
                            CustomItemList.EngineeringProcessorItemAdvEmeraldCore.get(1),
                            ItemList.Circuit_Board_Bio_Ultra.get(1), GT_Utility.getIntegratedCircuit(1) },
                    Materials.Tin.getMolten(144),
                    GT_ModHandler.getModItem("extracells", "storage.component", 1L, 3),
                    200,
                    500000,
                    true);

            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 16),
                            CustomItemList.EngineeringProcessorItemAdvEmeraldCore.get(1),
                            ItemList.Circuit_Board_Bio_Ultra.get(1), GT_Utility.getIntegratedCircuit(1) },
                    Materials.SolderingAlloy.getMolten(72),
                    GT_ModHandler.getModItem("extracells", "storage.component", 1L, 3),
                    200,
                    500000,
                    true);
        }

        if (Loader.isModLoaded("TConstruct")) GT_ModHandler.addExtractionRecipe(
                GT_ModHandler.getModItem("TConstruct", "Smeltery", 1L, 2),
                GT_ModHandler.getModItem("TConstruct", "materials", 4L, 2));

        RA.addArcFurnaceRecipe(
                GT_ModHandler.getModItem("IC2", "blockMiningPipe", 1L),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Steel, 2L), },
                null,
                50,
                90);

        // Wood Plates
        GT_Recipe.GT_Recipe_Map.sAssemblerRecipes.addRecipe(
                false,
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 64),
                        GT_Utility.getIntegratedCircuit(2) },
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 64) },
                null,
                new FluidStack[] { Materials.Glue.getFluid(144L) },
                null,
                2400,
                30,
                0);

        registerOpticalComponentRecipes();

        // --------------------------------------------------------
        // Rocket Circuits
        final int[] EUperRecipe = new int[] { 480, // t2 = HV
                1920, // t3 = EV
                7680, // t4 = IV
                30720, // t5 = LuV (Gated behind Assline)
                30720, // t6 = LuV
                130870, // t7 = ZPM
                520400, // t8 = UV
        };

        ItemStack[] RocketMaterial = new ItemStack[8];
        RocketMaterial[0] = GT_ModHandler.getModItem("GalacticraftCore", "item.heavyPlating", 1L);
        RocketMaterial[1] = GT_ModHandler.getModItem("GalacticraftMars", "item.null", 1L, 3);
        RocketMaterial[2] = GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L);
        RocketMaterial[3] = CustomItemList.HeavyDutyPlateTier4.get(1L);
        RocketMaterial[4] = CustomItemList.HeavyDutyPlateTier5.get(1L);
        RocketMaterial[5] = CustomItemList.HeavyDutyPlateTier6.get(1L);
        RocketMaterial[6] = CustomItemList.HeavyDutyPlateTier7.get(1L);
        RocketMaterial[7] = CustomItemList.HeavyDutyPlateTier8.get(1L);

        ItemStack[] RocketChip = new ItemStack[8];
        RocketChip[0] = CustomItemList.SchematicsTier1.get(1L);
        RocketChip[1] = CustomItemList.SchematicsTier2.get(1L);
        RocketChip[2] = CustomItemList.SchematicsTier3.get(1L);
        RocketChip[3] = CustomItemList.SchematicsTier4.get(1L);
        RocketChip[4] = CustomItemList.SchematicsTier5.get(1L);
        RocketChip[5] = CustomItemList.SchematicsTier6.get(1L);
        RocketChip[6] = CustomItemList.SchematicsTier7.get(1L);
        RocketChip[7] = CustomItemList.SchematicsTier8.get(1L);

        ItemStack[] ExtraChips = new ItemStack[3];
        ExtraChips[0] = CustomItemList.SchematicsMoonBuggy.get(1L);
        ExtraChips[1] = CustomItemList.SchematicsCargoRocket.get(1L);
        ExtraChips[2] = CustomItemList.SchematicsAstroMiner.get(1L);
        // put the soldering Materials in this array
        Materials[] solderingMaterials = new Materials[] { Materials.Lead, Materials.SolderingAlloy, Materials.Tin };

        for (Materials tMat : solderingMaterials)

        { // TODO dream things using soldering go in here!

            int tMultiplier = tMat.contains(SubTag.SOLDERING_MATERIAL_GOOD) ? 1
                    : tMat.contains(SubTag.SOLDERING_MATERIAL_BAD) ? 4 : 2;

            // Rocket Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Quantumprocessor.get(1L), RocketMaterial[0],
                            GT_Utility.getIntegratedCircuit(1) },
                    tMat.getMolten(576L * tMultiplier / 2L),
                    RocketChip[0],
                    9000,
                    480,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Data.get(1L), RocketMaterial[0],
                            GT_Utility.getIntegratedCircuit(1) },
                    tMat.getMolten(576L * tMultiplier / 2L),
                    RocketChip[0],
                    9000,
                    480,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Nanocomputer.get(1L), RocketMaterial[0],
                            GT_Utility.getIntegratedCircuit(1) },
                    tMat.getMolten(576L * tMultiplier / 2L),
                    RocketChip[0],
                    9000,
                    480,
                    true);

            for (byte i = 2; i < 9; ++i) {
                ItemStack DataStickWScheme = ItemList.Tool_DataStick.get(1L);
                DataStickWScheme.setTagCompound(
                        GT_Utility.getNBTContainingShort(new NBTTagCompound(), "rocket_tier", (short) i));
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { RocketMaterial[(i - 1)], ItemList.Circuit_Elite.get(1L),
                                DataStickWScheme.splitStack(0) },
                        tMat.getMolten(576L * tMultiplier / 2L),
                        RocketChip[(i - 1)],
                        9000,
                        EUperRecipe[(i - 2)],
                        true);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { RocketMaterial[(i - 1)], ItemList.Circuit_Elitenanocomputer.get(1L),
                                DataStickWScheme.splitStack(0) },
                        tMat.getMolten(576L * tMultiplier / 2L),
                        RocketChip[(i - 1)],
                        9000,
                        EUperRecipe[(i - 2)],
                        true);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { RocketMaterial[(i - 1)], ItemList.Circuit_Quantumcomputer.get(1L),
                                DataStickWScheme.splitStack(0) },
                        tMat.getMolten(576L * tMultiplier / 2L),
                        RocketChip[(i - 1)],
                        9000,
                        EUperRecipe[(i - 2)],
                        true);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { RocketMaterial[(i - 1)], ItemList.Circuit_Crystalprocessor.get(1L),
                                DataStickWScheme.splitStack(0) },
                        tMat.getMolten(576L * tMultiplier / 2L),
                        RocketChip[(i - 1)],
                        9000,
                        EUperRecipe[(i - 2)],
                        true);
            }

            for (byte i = 0; i < 3; ++i) {
                ItemStack DataStickWScheme = ItemList.Tool_DataStick.get(1L);
                DataStickWScheme.setTagCompound(
                        GT_Utility.getNBTContainingShort(new NBTTagCompound(), "rocket_tier", (short) (i + 100)));
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { RocketMaterial[i], ItemList.Circuit_Quantumprocessor.get(1L),
                                DataStickWScheme.splitStack(0) },
                        tMat.getMolten(576L * tMultiplier / 2L),
                        ExtraChips[i],
                        9000,
                        EUperRecipe[i],
                        true);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { RocketMaterial[i], ItemList.Circuit_Data.get(1L),
                                DataStickWScheme.splitStack(0) },
                        tMat.getMolten(576L * tMultiplier / 2L),
                        ExtraChips[i],
                        9000,
                        EUperRecipe[i],
                        true);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { RocketMaterial[i], ItemList.Circuit_Nanocomputer.get(1L),
                                DataStickWScheme.splitStack(0) },
                        tMat.getMolten(576L * tMultiplier / 2L),
                        ExtraChips[i],
                        9000,
                        EUperRecipe[i],
                        true);
            }
            // Primitive Circuit
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 1) },
                    tMat.getMolten(36L * tMultiplier / 2L),
                    CustomItemList.NandChipBoard.get(1),
                    300,
                    120);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 1) },
                    tMat.getMolten(36L * tMultiplier / 2L),
                    CustomItemList.NandChipBoard.get(1),
                    150,
                    120);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 1) },
                    tMat.getMolten(36L * tMultiplier / 2L),
                    CustomItemList.NandChipBoard.get(2),
                    300,
                    480);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 1) },
                    tMat.getMolten(36L * tMultiplier / 2L),
                    CustomItemList.NandChipBoard.get(2),
                    150,
                    480);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 1) },
                    tMat.getMolten(36L * tMultiplier / 2L),
                    CustomItemList.NandChipBoard.get(4),
                    300,
                    1920);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 1) },
                    tMat.getMolten(36L * tMultiplier / 2L),
                    CustomItemList.NandChipBoard.get(4),
                    150,
                    1920);

            // Basic Circuit
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Coated_Basic.get(1L),
                            ItemList.Circuit_Parts_Resistor.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2),
                            ItemList.Circuit_Parts_Vacuum_Tube.get(2L) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    GT_ModHandler.getModItem("IC2", "itemPartCircuit", 1L, 0),
                    200,
                    16);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Coated_Basic.get(1L),
                            ItemList.Circuit_Parts_ResistorSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2),
                            ItemList.Circuit_Parts_Vacuum_Tube.get(2L) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    GT_ModHandler.getModItem("IC2", "itemPartCircuit", 1L, 0),
                    200,
                    16);

            // Good Circuit
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            GT_ModHandler.getModItem("IC2", "itemPartCircuit", 2L, 0),
                            ItemList.Circuit_Parts_Diode.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Good.get(1L),
                    300,
                    30);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            GT_ModHandler.getModItem("IC2", "itemPartCircuit", 2L, 0),
                            ItemList.Circuit_Parts_DiodeSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Good.get(1L),
                    300,
                    30);

            // Integraded Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L),
                            ItemList.Circuit_Parts_Resistor.get(2L), ItemList.Circuit_Parts_Diode.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Basic.get(1L),
                    200,
                    16);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L),
                            ItemList.Circuit_Parts_ResistorSMD.get(2L), ItemList.Circuit_Parts_Diode.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Basic.get(1L),
                    200,
                    16);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L),
                            ItemList.Circuit_Parts_ResistorSMD.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Basic.get(1L),
                    200,
                    16);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L),
                            ItemList.Circuit_Parts_Resistor.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Basic.get(1L),
                    200,
                    16);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L),
                            ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_Diode.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Integrated_Good.get(1L),
                    400,
                    24);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L),
                            ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_Diode.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Integrated_Good.get(1L),
                    400,
                    24);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L),
                            ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_DiodeSMD.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Integrated_Good.get(1L),
                    400,
                    24);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L),
                            ItemList.Circuit_Parts_ResistorASMD.get(1L), ItemList.Circuit_Parts_DiodeASMD.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Integrated_Good.get(1L),
                    200,
                    24);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L),
                            ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_DiodeSMD.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Integrated_Good.get(1L),
                    400,
                    24);

            // Advanced circuit
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Integrated_Good.get(1L), ItemList.Circuit_Chip_ILC.get(2L),
                            ItemList.Circuit_Chip_Ram.get(2L), ItemList.Circuit_Parts_Transistor.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    GT_ModHandler.getIC2Item("advancedCircuit", 1L),
                    800,
                    30,
                    false);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Integrated_Good.get(1L), ItemList.Circuit_Chip_ILC.get(2L),
                            ItemList.Circuit_Chip_Ram.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    GT_ModHandler.getIC2Item("advancedCircuit", 1L),
                    800,
                    30,
                    false);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Integrated_Good.get(1L), ItemList.Circuit_Chip_ILC.get(2L),
                            ItemList.Circuit_Chip_Ram.get(2L), ItemList.Circuit_Parts_TransistorASMD.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    GT_ModHandler.getIC2Item("advancedCircuit", 1L),
                    400,
                    30,
                    false);

            // Integrated Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(2L),
                            ItemList.Circuit_Parts_Capacitor.get(2L), ItemList.Circuit_Parts_Transistor.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Microprocessor.get(2L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L),
                            ItemList.Circuit_Parts_Capacitor.get(2L), ItemList.Circuit_Parts_Transistor.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Microprocessor.get(2L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(2L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(2L), ItemList.Circuit_Parts_Transistor.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Microprocessor.get(2L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(2L),
                            ItemList.Circuit_Parts_Capacitor.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Microprocessor.get(2L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(2L), ItemList.Circuit_Parts_Transistor.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Microprocessor.get(2L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L),
                            ItemList.Circuit_Parts_Capacitor.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Microprocessor.get(2L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(2L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Microprocessor.get(2L),
                    200,
                    60,
                    true);

            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L),
                            ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_Transistor.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L),
                            ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_Transistor.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorASMD.get(1L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(1L), ItemList.Circuit_Parts_TransistorASMD.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    100,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_Transistor.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L),
                            ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_Transistor.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L),
                            ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Processor.get(2L), ItemList.Circuit_Parts_Coil.get(4L),
                            ItemList.Circuit_Parts_Capacitor.get(8L), ItemList.Circuit_Chip_Ram.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Computer.get(1L),
                    400,
                    120,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(2L), ItemList.Circuit_Chip_NAND.get(32L),
                            ItemList.Circuit_Chip_Ram.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 16),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 4) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Tool_DataStick.get(1L),
                    400,
                    90,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Advanced.get(2L), ItemList.Circuit_Parts_Diode.get(4L),
                            ItemList.Circuit_Chip_Ram.get(8L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Data.get(1L),
                    400,
                    120,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
                            ItemList.Circuit_Parts_Coil.get(12L), ItemList.Circuit_Parts_Capacitor.get(24),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 24) },
                    tMat.getMolten(144L * tMultiplier * 2),
                    ItemList.Circuit_Elite.get(1L),
                    1600,
                    480,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Microprocessor.get(2L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    200,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Processor.get(2L), ItemList.Circuit_Parts_Coil.get(4L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(8L), ItemList.Circuit_Chip_Ram.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Computer.get(1L),
                    400,
                    96,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorASMD.get(4L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(1L), ItemList.Circuit_Parts_TransistorASMD.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    100,
                    60,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Processor.get(2L), ItemList.Circuit_Parts_InductorASMD.get(1L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(2L), ItemList.Circuit_Chip_Ram.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Computer.get(1L),
                    200,
                    96,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Advanced.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(4L),
                            ItemList.Circuit_Chip_Ram.get(8L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Data.get(1L),
                    400,
                    120,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Advanced.get(2L), ItemList.Circuit_Parts_DiodeASMD.get(1L),
                            ItemList.Circuit_Chip_Ram.get(8L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Data.get(1L),
                    200,
                    120,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
                            ItemList.Circuit_Parts_Coil.get(12L), ItemList.Circuit_Parts_CapacitorSMD.get(16L),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 16) },
                    tMat.getMolten(144L * tMultiplier * 2),
                    ItemList.Circuit_Elite.get(1L),
                    1600,
                    480,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
                            ItemList.Circuit_Parts_InductorASMD.get(3L), ItemList.Circuit_Parts_CapacitorASMD.get(4L),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 16) },
                    tMat.getMolten(144L * tMultiplier * 2),
                    ItemList.Circuit_Elite.get(1L),
                    800,
                    480,
                    true);

            // Nanotech Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(8L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(8L), ItemList.Circuit_Parts_TransistorSMD.get(8L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Nanoprocessor.get(1L),
                    200,
                    600,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_ResistorASMD.get(2L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(2L), ItemList.Circuit_Parts_TransistorASMD.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Nanoprocessor.get(1L),
                    100,
                    600,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Nanoprocessor.get(2L), ItemList.Circuit_Parts_InductorSMD.get(8L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(8L), ItemList.Circuit_Chip_Ram.get(8L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Nanocomputer.get(1L),
                    400,
                    600,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Nanoprocessor.get(2L), ItemList.Circuit_Parts_InductorASMD.get(2L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(2L), ItemList.Circuit_Chip_Ram.get(8L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Nanocomputer.get(1L),
                    200,
                    600,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Nanoprocessor.get(2L), ItemList.Circuit_Chip_Ram.get(4L),
                            ItemList.Circuit_Chip_NOR.get(32L), ItemList.Circuit_Chip_NAND.get(64L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 32) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Tool_DataOrb.get(1L),
                    400,
                    1200,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Nanocomputer.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(8L),
                            ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Elitenanocomputer.get(1L),
                    400,
                    600,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Nanocomputer.get(2L), ItemList.Circuit_Parts_DiodeASMD.get(2L),
                            ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Elitenanocomputer.get(1L),
                    200,
                    600,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            ItemList.Circuit_Elitenanocomputer.get(2L), ItemList.Circuit_Parts_InductorSMD.get(16L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(32L), ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 32) },
                    tMat.getMolten(144L * tMultiplier * 2),
                    ItemList.Circuit_Master.get(1L),
                    1600,
                    1920,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            ItemList.Circuit_Elitenanocomputer.get(2L), ItemList.Circuit_Parts_InductorASMD.get(4L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(8L), ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 32) },
                    tMat.getMolten(144L * tMultiplier * 2),
                    ItemList.Circuit_Master.get(1L),
                    800,
                    1920,
                    true);

            // Quantum Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Chip_QuantumCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(12L), ItemList.Circuit_Parts_TransistorSMD.get(12L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Quantumprocessor.get(1L),
                    200,
                    2400,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Chip_QuantumCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(3L), ItemList.Circuit_Parts_TransistorASMD.get(3L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Quantumprocessor.get(1L),
                    100,
                    2400,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Quantumprocessor.get(2L), ItemList.Circuit_Parts_InductorSMD.get(12L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(16L), ItemList.Circuit_Chip_Ram.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 24) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Quantumcomputer.get(1L),
                    400,
                    2400,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Quantumprocessor.get(2L), ItemList.Circuit_Parts_InductorASMD.get(3L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(4L), ItemList.Circuit_Chip_Ram.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 24) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Quantumcomputer.get(1L),
                    200,
                    2400,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Quantumcomputer.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(8L),
                            ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 48) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Masterquantumcomputer.get(1L),
                    400,
                    2400,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Quantumcomputer.get(2L), ItemList.Circuit_Parts_DiodeASMD.get(2L),
                            ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 48) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Circuit_Masterquantumcomputer.get(1L),
                    200,
                    2400,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            ItemList.Circuit_Masterquantumcomputer.get(2L), ItemList.Circuit_Parts_InductorSMD.get(24),
                            ItemList.Circuit_Parts_CapacitorSMD.get(48L), ItemList.Circuit_Chip_Ram.get(24),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 48) },
                    tMat.getMolten(144L * tMultiplier * 2),
                    ItemList.Circuit_Quantummainframe.get(1L),
                    1600,
                    7680,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            ItemList.Circuit_Masterquantumcomputer.get(2L), ItemList.Circuit_Parts_InductorASMD.get(6L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(12L), ItemList.Circuit_Chip_Ram.get(24),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 48) },
                    tMat.getMolten(144L * tMultiplier * 2),
                    ItemList.Circuit_Quantummainframe.get(1L),
                    800,
                    7680,
                    true);

            // SoC
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_SoC.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Copper, 2) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Microprocessor.get(2L),
                    50,
                    600,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_SoC.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 4) },
                    tMat.getMolten(144L * tMultiplier / 2L),
                    ItemList.Circuit_Processor.get(1L),
                    50,
                    2400,
                    true);

            // Lapo orbs
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Chip_PIC.get(4L), ItemList.Circuit_Parts_Crystal_Chip_Master.get(24L),
                            ItemList.Circuit_Chip_NanoCPU.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Platinum, 8) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Energy_LapotronicOrb.get(1L),
                    512,
                    1024,
                    true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Chip_HPIC.get(4L), ItemList.Energy_LapotronicOrb.get(8L),
                            ItemList.Circuit_Chip_QuantumCPU.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 16) },
                    tMat.getMolten(144L * tMultiplier),
                    ItemList.Energy_LapotronicOrb2.get(1L),
                    1024,
                    4096,
                    true);

            // Wetware Board
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Multifiberglass.get(16L),
                            ItemList.Circuit_Parts_PetriDish.get(1L), ItemList.Electric_Pump_LuV.get(1L),
                            ItemList.Sensor_IV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 16L) },
                    Materials.GrowthMediumSterilized.getFluid(4000L),
                    ItemList.Circuit_Board_Wetware.get(16L),
                    1200,
                    30720,
                    true);

            // Bio Board
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Wetware.get(32L), ItemList.Circuit_Parts_PetriDish.get(8L),
                            ItemList.Electric_Pump_UV.get(1L), ItemList.Sensor_LuV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 32L) },
                    Materials.BioMediumSterilized.getFluid(16000L),
                    ItemList.Circuit_Board_Bio.get(32L),
                    1200,
                    500000,
                    true);

            // PCBs Steve Carts
            if (Loader.isModLoaded("StevesCarts")) {
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Coated_Basic.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 8),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 9),
                        200,
                        30);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L),
                                GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 2L, 9),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 16),
                        400,
                        30);
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Coated_Basic.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 8),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 9),
                        200,
                        30);
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Phenolic_Good.get(1L),
                                GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 2L, 9),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 16),
                        200,
                        120);
            }

            // --- Advanced Solar Panel
            if (Loader.isModLoaded("AdvancedSolarPanel")) {
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Hull_LV.get(1L), ItemList.Cover_SolarPanel_LV.get(1L),
                                ItemList.Robot_Arm_LV.get(1L), ItemList.Battery_RE_LV_Lithium.get(1L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1L, 0),
                        800,
                        120);
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Hull_MV.get(1L), ItemList.Cover_SolarPanel_MV.get(1L),
                                ItemList.Robot_Arm_MV.get(1L), ItemList.Battery_RE_MV_Lithium.get(1L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(576L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1L, 1),
                        1000,
                        480);
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Hull_HV.get(1L), ItemList.Cover_SolarPanel_HV.get(1L),
                                ItemList.Robot_Arm_HV.get(1L), ItemList.Battery_RE_HV_Lithium.get(1L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(864L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1L, 2),
                        1200,
                        1920);
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Hull_EV.get(1L), ItemList.Cover_SolarPanel_EV.get(1L),
                                ItemList.Robot_Arm_EV.get(1L), CustomItemList.BatteryHull_EV_Full.get(1L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(1152L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1L, 3),
                        1400,
                        7860);
            }

            // --- Super Solar Panel
            if (Loader.isModLoaded("supersolarpanel")) {
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Hull_IV.get(1L), ItemList.Cover_SolarPanel_IV.get(1L),
                                ItemList.Robot_Arm_IV.get(1L), CustomItemList.BatteryHull_IV_Full.get(1L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(1440 * tMultiplier / 2L),
                        GT_ModHandler.getModItem("supersolarpanel", "SpectralSolarPanel", 1L, 0),
                        1600,
                        30720);
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Hull_LuV.get(1L), ItemList.Cover_SolarPanel_LuV.get(1L),
                                ItemList.Robot_Arm_LuV.get(1L), CustomItemList.BatteryHull_LuV_Full.get(1L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(1728 * tMultiplier / 2L),
                        GT_ModHandler.getModItem("supersolarpanel", "SingularSolarPanel", 1L, 0),
                        1800,
                        122880);
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Hull_ZPM.get(1L), ItemList.Cover_SolarPanel_ZPM.get(1L),
                                ItemList.Robot_Arm_ZPM.get(1L), CustomItemList.BatteryHull_ZPM_Full.get(1L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(2016 * tMultiplier / 2L),
                        GT_ModHandler.getModItem("supersolarpanel", "AdminSolarPanel", 1L, 0),
                        2000,
                        500000);
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Hull_UV.get(1L), ItemList.Cover_SolarPanel_UV.get(1L),
                                ItemList.Robot_Arm_UV.get(1L), CustomItemList.BatteryHull_UV_Full.get(1L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(2304 * tMultiplier / 2L),
                        GT_ModHandler.getModItem("supersolarpanel", "PhotonicSolarPanel", 1L, 0),
                        2200,
                        2000000);
            }

            // Quantum Armor

            GT_Values.RA.addAssemblerRecipe(
                    new ItemStack[] { CustomItemList.QuantumPartHelmet.get(1L), CustomItemList.QuantumCrystal.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 4),
                            ItemList.Energy_LapotronicOrb.get(1L), ItemList.Sensor_IV.get(1L),
                            ItemList.Field_Generator_EV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 4),
                            GT_Utility.getIntegratedCircuit(10) },
                    Materials.Titanium.getMolten(1728L),
                    GT_ModHandler.getIC2Item("quantumHelmet", 1L, 26),
                    1500,
                    7680);

            GT_Values.RA.addAssemblerRecipe(
                    new ItemStack[] { CustomItemList.QuantumPartChestplate.get(1L),
                            CustomItemList.QuantumCrystal.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 6),
                            ItemList.Energy_LapotronicOrb.get(1L), ItemList.Field_Generator_EV.get(3L),
                            ItemList.Electric_Motor_IV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 4),
                            GT_Utility.getIntegratedCircuit(11) },
                    Materials.Titanium.getMolten(2880L),
                    GT_ModHandler.getIC2Item("quantumBodyarmor", 1L, 26),
                    1500,
                    7680);

            GT_Values.RA.addAssemblerRecipe(
                    new ItemStack[] { CustomItemList.QuantumPartLeggings.get(1L), CustomItemList.QuantumCrystal.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 6),
                            ItemList.Energy_LapotronicOrb.get(1L), ItemList.Field_Generator_EV.get(2L),
                            ItemList.Electric_Motor_IV.get(4L),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 4),
                            GT_Utility.getIntegratedCircuit(12) },
                    Materials.Titanium.getMolten(2304L),
                    GT_ModHandler.getIC2Item("quantumLeggings", 1L, 26),
                    1500,
                    7680);

            GT_Values.RA.addAssemblerRecipe(
                    new ItemStack[] { CustomItemList.QuantumPartBoots.get(1L), CustomItemList.QuantumCrystal.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 4),
                            ItemList.Energy_LapotronicOrb.get(1L), ItemList.Field_Generator_EV.get(1L),
                            ItemList.Electric_Piston_IV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 4),
                            GT_Utility.getIntegratedCircuit(13) },
                    Materials.Titanium.getMolten(1440L),
                    GT_ModHandler.getIC2Item("quantumBoots", 1L, 26),
                    1500,
                    7680);

            // solar 1EU
            GT_Values.RA.addAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Silicon_Wafer.get(2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2L),
                            GT_ModHandler.getIC2Item("reinforcedGlass", 1L),
                            GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2L),
                            CustomItemList.AluminiumIronPlate.get(1) },
                    tMat.getMolten(72L * tMultiplier / 2L),
                    ItemList.Cover_SolarPanel.get(1L),
                    200,
                    120);

            // solar 8EU
            GT_Values.RA.addAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L),
                            ItemList.Cover_SolarPanel.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Tin, 2L),
                            ItemList.Circuit_Silicon_Wafer.get(1),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.GalliumArsenide, 1L),
                            CustomItemList.ReinforcedAluminiumIronPlate.get(1) },
                    tMat.getMolten(72L * tMultiplier / 2L),
                    ItemList.Cover_SolarPanel_8V.get(1L),
                    400,
                    120);

            if (Loader.isModLoaded("OpenComputers")) {

                // display t1
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Casing_MV.get(1L), ItemList.Cover_Screen.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L),
                                ItemList.Circuit_Parts_Transistor.get(2L), GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "screen1", 1L, 0),
                        240,
                        64);
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Casing_MV.get(1L), ItemList.Cover_Screen.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L),
                                ItemList.Circuit_Parts_TransistorSMD.get(1L), GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "screen1", 1L, 0),
                        240,
                        64);
                // display t2
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Casing_HV.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "screen1", 1L, 0),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L),
                                ItemList.Circuit_Parts_Transistor.get(4L), GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0),
                        240,
                        120);
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Casing_HV.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "screen1", 1L, 0),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0),
                        240,
                        120);
                // display t3
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Casing_EV.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L),
                                ItemList.Circuit_Parts_Transistor.get(8L), GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "screen3", 1L, 0),
                        240,
                        256);
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Casing_EV.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L),
                                ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "screen3", 1L, 0),
                        240,
                        256);
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Casing_EV.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L),
                                ItemList.Circuit_Parts_TransistorASMD.get(1L), GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "screen3", 1L, 0),
                        120,
                        256);
                // ALU
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_ILC.get(16L), GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 2L, 27),
                        400,
                        64);
                // CU
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Parts_Transistor.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                        200,
                        30);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                        200,
                        30);
                // anylyser
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Tool_Scanner.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                ItemList.Circuit_Parts_Transistor.get(2L), ItemList.Sensor_HV.get(1L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0),
                        300,
                        120);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Tool_Scanner.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                ItemList.Circuit_Parts_TransistorSMD.get(1L), ItemList.Sensor_HV.get(1L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0),
                        300,
                        120);
                // CPU 1
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 8L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 29),
                        200,
                        120);
                // CPU 2
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 12L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 28),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 42),
                        200,
                        120);
                // CPU 3
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 16L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(3) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 43),
                        200,
                        120);
                // Graphics Card 1
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 8L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 8),
                        400,
                        120);
                // Graphics Card 2
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 16L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 2),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 9),
                        400,
                        256);
                // Graphics Card 3
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 32L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 26),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 10),
                        400,
                        480);
                // Internet Crad
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L),
                                GT_ModHandler.getModItem(
                                        "ProjRed|Illumination",
                                        "projectred.illumination.lightbutton",
                                        1L,
                                        14),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 44),
                        400,
                        480);
                // APU T1
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 32L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 101),
                        200,
                        256);
                // APU T2
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 64L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 8L, 28),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(3) },
                        tMat.getMolten(288L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 102),
                        200,
                        480);
                // EEPROM
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                ItemList.Circuit_Parts_Transistor.get(6L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "eeprom", 1L, 0),
                        200,
                        120);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                ItemList.Circuit_Parts_TransistorSMD.get(6L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "eeprom", 1L, 0),
                        200,
                        120);

                // RAM 1
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(16L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1),
                        250,
                        64);
                // RAM 1.5
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(32L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 50),
                        250,
                        120);
                // RAM 2
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(64L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 2),
                        250,
                        256);
                // RAM 2.5
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(64L), ItemList.Circuit_Chip_NAND.get(16L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 3),
                        250,
                        480);
                // RAM 3
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(64L), ItemList.Circuit_Chip_NAND.get(32L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38),
                        250,
                        1024);
                // RAM 3.5
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(64L), ItemList.Circuit_Chip_NAND.get(64L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 39),
                        250,
                        1920);
                // Circuit 1
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1),
                                ItemList.Circuit_Parts_Transistor.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                        300,
                        120);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1),
                                ItemList.Circuit_Parts_TransistorSMD.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                        300,
                        120);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1),
                                ItemList.Circuit_Parts_TransistorASMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                        150,
                        120);
                // Circuit 2
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                ItemList.Circuit_Parts_Transistor.get(8L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                        300,
                        256);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                ItemList.Circuit_Parts_TransistorSMD.get(8L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                        300,
                        256);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                ItemList.Circuit_Parts_TransistorASMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(3) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                        150,
                        256);
                // Circuit 3
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                                ItemList.Circuit_Parts_Transistor.get(16L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                        300,
                        480);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                                ItemList.Circuit_Parts_TransistorSMD.get(16L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                        300,
                        480);
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                                ItemList.Circuit_Parts_TransistorASMD.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                        150,
                        480);
                // network card
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11),
                        200,
                        120);

                // tps card
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { new ItemStack(Items.clock, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 66), ItemList.Emitter_HV.get(1L),
                                ItemList.Sensor_HV.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 117),
                        200,
                        120);

                // wlan card1
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), ItemList.Emitter_LV.get(1L),
                                ItemList.Sensor_LV.get(1L), GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 113),
                        200,
                        120);
                // wlan card2
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11),
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), ItemList.Emitter_HV.get(1L),
                                ItemList.Sensor_HV.get(1L), GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13),
                        200,
                        256);
                // World sensor card
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_ModHandler.getModItem("GalacticraftCore", "item.sensorLens", 2L, 0),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 89),
                        200,
                        120);
                // redstone card 1
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0),
                                ItemList.Circuit_Chip_ILC.get(4L), new ItemStack(Blocks.redstone_torch, 2),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 66),
                        200,
                        120);
                // redstone card 2
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0),
                                ItemList.Circuit_Chip_ILC.get(16L), new ItemStack(Blocks.redstone_torch, 4),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 12),
                        200,
                        256);
                // data card 1
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4, 27),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 104),
                        300,
                        120);
                // data card 2
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1, 29),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 105),
                        300,
                        156);
                // data card 3
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1, 42),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 32L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 106),
                        300,
                        480);
                // angel upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem("ExtraUtilities", "angelBlock", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 49),
                        250,
                        256);
                // hover upgrade Tier 1
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 4L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                ItemList.Electric_Motor_MV.get(1L), GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 99),
                        250,
                        256);
                // hover upgrade Tier 2
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 8L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                ItemList.Electric_Motor_HV.get(1L), GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 100),
                        250,
                        480);
                // battery upgrade 1
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0),
                                ItemList.Circuit_Parts_Transistor.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 4L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 63),
                        250,
                        120);
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0),
                                ItemList.Circuit_Parts_TransistorSMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 4L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 63),
                        250,
                        120);
                // battery upgrade 2
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "capacitor", 2L, 0),
                                ItemList.Circuit_Parts_Transistor.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 64),
                        250,
                        256);
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "capacitor", 2L, 0),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 64),
                        250,
                        256);
                // battery upgrade 3
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "capacitor", 4L, 0),
                                ItemList.Circuit_Parts_Transistor.get(8L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 65),
                        250,
                        480);
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "capacitor", 4L, 0),
                                ItemList.Circuit_Parts_TransistorSMD.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 65),
                        250,
                        480);
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "capacitor", 4L, 0),
                                ItemList.Circuit_Parts_TransistorASMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 65),
                        125,
                        480);
                // inventory upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                new ItemStack(Blocks.chest, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 53),
                        300,
                        120);
                // inventory controller upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 53),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 61),
                        300,
                        120);
                // tank upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem("BuildCraft|Factory", "tankBlock", 1L, 0),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 76),
                        300,
                        120);
                // tank controller upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 76),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 77),
                        300,
                        120);

                // beekeper upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_ModHandler.getModItem("Forestry", "beealyzer", 1L, 0), ItemList.Sensor_MV.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 2),
                                GT_Utility.getIntegratedCircuit(10) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item.forestry", 1L, 0),
                        200,
                        120);
                // configurator upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "wrench", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 115),
                        300,
                        120);
                // riteg upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getIC2Item("RTGPellets", 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 3L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lead, 4L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 116),
                        300,
                        256);
                // card container 1
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                new ItemStack(Blocks.chest, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 57),
                        250,
                        120);
                // card container 2
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L),
                                new ItemStack(Blocks.chest, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 58),
                        250,
                        256);
                // card container 3
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L),
                                new ItemStack(Blocks.chest, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 59),
                        250,
                        480);
                // upgrade container 1
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                new ItemStack(Blocks.chest, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.StainlessSteel, 8L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 54),
                        250,
                        120);
                // upgrade container 2
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L),
                                new ItemStack(Blocks.chest, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Titanium, 8L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 55),
                        250,
                        256);
                // upgrade container 3
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L),
                                new ItemStack(Blocks.chest, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 8L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 56),
                        250,
                        480);
                // component bus t1
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 4L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 70),
                        250,
                        120);
                // component bus t2
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 2),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 71),
                        250,
                        256);
                // component bus t3
                GT_Values.RA.addCircuitAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                GT_ModHandler.getModItem("OpenComputers", "item", 8L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Diamond, 16),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 72),
                        250,
                        480);
                // database upgrade 1
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 5),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 78),
                        250,
                        120);
                // database upgrade 2
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 6),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 79),
                        250,
                        256);
                // database upgrade 3
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 7),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 80),
                        250,
                        480);
                // experience upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 2L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 52),
                        250,
                        120);
                // crafting component
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Hull_LV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                ItemList.Cover_Crafting.get(1L), GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 14),
                        250,
                        120);
                // generator upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("EnderIO", "blockStirlingGenerator", 1L, 0),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 15),
                        250,
                        120);
                // leash upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), new ItemStack(Items.lead, 4),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 85),
                        250,
                        120);
                // mfu upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "adapter", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 51),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 96),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 2L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 112),
                        250,
                        480);
                // navigation upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Hull_MV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                new ItemStack(Items.compass, 1), new ItemStack(Items.map, 1),
                                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Water, 1L) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 36),
                        250,
                        256);
                // piston upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Electric_Piston_MV.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 75),
                        250,
                        120);
                // sing IO upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                ItemList.Dye_SquidInk.get(1L), new ItemStack(Items.sign, 1),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 35),
                        250,
                        120);
                // solar upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                ItemList.Cover_SolarPanel_LV.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 34),
                        250,
                        256);
                // tractor beam upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                ItemList.Electric_Piston_HV.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 16L) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 67),
                        250,
                        480);
                // trading upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 3L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 3L),
                                ItemList.Electric_Piston_MV.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 2L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 110),
                        250,
                        256);
                // hover Boots
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 83),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 100),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 4L),
                                ItemList.Electric_Piston_MV.get(2L), GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("OpenComputers", "hoverBoots", 1L, GT_Values.W),
                        350,
                        256);
                // ME Upgrade 1
                GT_Values.RA
                        .addAssemblerRecipe(
                                new ItemStack[] { ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L),
                                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13),
                                        GT_ModHandler
                                                .getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 41),
                                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                        GT_Utility.getIntegratedCircuit(1) },
                                tMat.getMolten(144L * tMultiplier / 2L),
                                GT_ModHandler.getModItem("extracells", "oc.upgrade", 1L, 2),
                                250,
                                256);
                // ME Upgrade 2
                GT_Values.RA
                        .addAssemblerRecipe(
                                new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L),
                                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13),
                                        GT_ModHandler
                                                .getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 41),
                                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                        GT_Utility.getIntegratedCircuit(1) },
                                tMat.getMolten(144L * tMultiplier / 2L),
                                GT_ModHandler.getModItem("extracells", "oc.upgrade", 1L, 1),
                                250,
                                1024);
                // ME Upgrade 3
                GT_Values.RA
                        .addAssemblerRecipe(
                                new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Chrome, 2L),
                                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13),
                                        GT_ModHandler
                                                .getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 41),
                                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                        GT_Utility.getIntegratedCircuit(1) },
                                tMat.getMolten(144L * tMultiplier / 2L),
                                GT_ModHandler.getModItem("extracells", "oc.upgrade", 1L),
                                250,
                                4096);
            }

            if (Loader.isModLoaded("computronics")) {
                // Camera Upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("computronics", "computronics.camera", 1L, 0),
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 0),
                        250,
                        256);
                // Chat Upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("computronics", "computronics.chatBox", 1L, 0),
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 1),
                        250,
                        256);
                // Radar Upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("computronics", "computronics.radar", 1L, 0),
                                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                ItemList.Circuit_Parts_TransistorSMD.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 2),
                        250,
                        480);
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("computronics", "computronics.radar", 1L, 0),
                                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                ItemList.Circuit_Parts_TransistorASMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48),
                                GT_Utility.getIntegratedCircuit(2) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 2),
                        250,
                        480);
                // Particel Card
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                new ItemStack(Items.firework_charge, 1, W), GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 3),
                        250,
                        480);
                // Spoofing Card
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 50),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Clay, 2L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 4),
                        250,
                        480);
                // Beep Card
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                                GT_ModHandler.getModItem("computronics", "computronics.speaker", 1L, 0),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 5),
                        250,
                        480);
                // Self Destruction Card
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("OpenComputers", "item", 1L, 66),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                                GT_ModHandler.getModItem("IC2", "blockITNT", 2L, 0),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 6),
                        250,
                        256);
                // Colorful Upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_ModHandler.getModItem("computronics", "computronics.colorfulLamp", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 96),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 7),
                        250,
                        480);
                // Noise Card
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 5),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 27),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 8),
                        250,
                        480);
                // Sound Card
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 8),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 29),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 9),
                        250,
                        1024);
                // Light Board
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("computronics", "computronics.colorfulLamp", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 2L),
                                ItemList.Dye_SquidInk.get(4L), GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 10),
                        250,
                        256);
                // Server Selfdestructor
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("computronics", "computronics.ocParts", 2L, 6),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                ItemList.Dye_SquidInk.get(4L), GT_ModHandler.getModItem("IC2", "blockITNT", 2L, 0),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 11),
                        250,
                        256);
                // Rack Capacitor
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 2L),
                                ItemList.Dye_SquidInk.get(4L), GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 12),
                        250,
                        256);
                // Switch Board
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                new ItemStack(Blocks.stone_button, 64, 30720),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 2L),
                                ItemList.Dye_SquidInk.get(4L), GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 13),
                        250,
                        256);
                // Speech Upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("computronics", "computronics.speechBox", 1L, 0),
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 14),
                        250,
                        256);
                // Drone Docking Station
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 2L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("computronics", "computronics.droneStation", 1L, 0),
                        250,
                        480);
                // Drone Docking Station Upgrade
                GT_Values.RA.addAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem("computronics", "computronics.droneStation", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_Utility.getIntegratedCircuit(1) },
                        tMat.getMolten(144L * tMultiplier / 2L),
                        GT_ModHandler.getModItem("computronics", "computronics.dockingUpgrade", 1L, 0),
                        250,
                        480);
            }
        }

        // Recipes with High Tier Soldering
        Fluid solderIndalloy = FluidRegistry.getFluid("molten.indalloy140") != null
                ? FluidRegistry.getFluid("molten.indalloy140")
                : FluidRegistry.getFluid("molten.solderingalloy");

        // Crystal Circuits
        GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]

        { ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), ItemList.Circuit_Chip_CrystalCPU.get(1L),
                ItemList.Circuit_Chip_NanoCPU.get(2L), ItemList.Circuit_Parts_CapacitorASMD.get(6),
                ItemList.Circuit_Parts_TransistorASMD.get(6),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 8) }, new

        FluidStack(solderIndalloy, 72), ItemList.Circuit_Crystalprocessor.get(1L), 100, 9600, true);
        GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]

        { ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), ItemList.Circuit_Crystalprocessor.get(2L),
                ItemList.Circuit_Parts_InductorASMD.get(6L), ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                ItemList.Circuit_Chip_Ram.get(24),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16) }, new

        FluidStack(solderIndalloy, 144), ItemList.Circuit_Crystalcomputer.get(1L), 200, 9600, true);
        GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]

        { ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), ItemList.Circuit_Crystalcomputer.get(2L),
                ItemList.Circuit_Chip_Ram.get(4L), ItemList.Circuit_Chip_NOR.get(32L),
                ItemList.Circuit_Chip_NAND.get(64L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 32) }, new

        FluidStack(solderIndalloy, 144), ItemList.Circuit_Ultimatecrystalcomputer.get(1L), 400, 9600, true);
        GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]

        { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                ItemList.Circuit_Ultimatecrystalcomputer.get(2L), ItemList.Circuit_Parts_InductorASMD.get(8L),
                ItemList.Circuit_Parts_CapacitorASMD.get(16L), ItemList.Circuit_Chip_Ram.get(32L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 16) }, new

        FluidStack(solderIndalloy, 288), ItemList.Circuit_Crystalmainframe.get(1L), 800, 30720, true);

        // Wetware Circuits
        GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]

        { ItemList.Circuit_Chip_NeuroCPU.get(1L), ItemList.Circuit_Chip_CrystalCPU.get(1L),
                ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                ItemList.Circuit_Parts_TransistorASMD.get(8L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 8) }, new

        FluidStack(solderIndalloy, 72), ItemList.Circuit_Neuroprocessor.get(1L), 200, 38400, true);
        GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]

        { ItemList.Circuit_Chip_NeuroCPU.get(1L), ItemList.Circuit_Chip_CrystalCPU.get(1L),
                ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_CapacitorXSMD.get(2L),
                ItemList.Circuit_Parts_TransistorXSMD.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 8) }, new

        FluidStack(solderIndalloy, 72), ItemList.Circuit_Neuroprocessor.get(1L), 25, 153600, true);
        GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]

        { ItemList.Circuit_Board_Wetware_Extreme.get(1L), ItemList.Circuit_Neuroprocessor.get(2L),
                ItemList.Circuit_Parts_InductorASMD.get(8L), ItemList.Circuit_Parts_CapacitorASMD.get(12L),
                ItemList.Circuit_Chip_Ram.get(24L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 16) }, new

        FluidStack(solderIndalloy, 144), ItemList.Circuit_Wetwarecomputer.get(1L), 300, 38400, true);
        GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]

        { ItemList.Circuit_Board_Wetware_Extreme.get(1L), ItemList.Circuit_Neuroprocessor.get(2L),
                ItemList.Circuit_Parts_InductorXSMD.get(2L), ItemList.Circuit_Parts_CapacitorXSMD.get(3L),
                ItemList.Circuit_Chip_Ram.get(24L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 16) }, new

        FluidStack(solderIndalloy, 144), ItemList.Circuit_Wetwarecomputer.get(1L), 37, 153600, true);
        GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]

        { ItemList.Circuit_Board_Wetware_Extreme.get(2L), ItemList.Circuit_Wetwarecomputer.get(2L),
                ItemList.Circuit_Parts_DiodeASMD.get(8L), ItemList.Circuit_Chip_NOR.get(16L),
                ItemList.Circuit_Chip_Ram.get(64L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 24) }, new

        FluidStack(solderIndalloy, 144), ItemList.Circuit_Wetwaresupercomputer.get(1L), 600, 38400, true);
        GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]

        { ItemList.Circuit_Board_Wetware_Extreme.get(2L), ItemList.Circuit_Wetwarecomputer.get(2L),
                ItemList.Circuit_Parts_DiodeXSMD.get(2L), ItemList.Circuit_Chip_NOR.get(16L),
                ItemList.Circuit_Chip_Ram.get(64L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 24) }, new

        FluidStack(solderIndalloy, 144), ItemList.Circuit_Wetwaresupercomputer.get(1L), 75, 153600, true);

        // Bio Circuits
        GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]

        { ItemList.Circuit_Chip_BioCPU.get(1L), ItemList.Circuit_Chip_CrystalSoC2.get(1L),
                ItemList.Circuit_Chip_NanoCPU.get(2L), ItemList.Circuit_Parts_CapacitorASMD.get(12L),
                ItemList.Circuit_Parts_TransistorASMD.get(12L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16) }, new

        FluidStack(solderIndalloy, 72), ItemList.Circuit_Bioprocessor.get(1L), 300, 153600, true);
        GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]

        { ItemList.Circuit_Chip_BioCPU.get(1L), ItemList.Circuit_Chip_CrystalSoC2.get(1L),
                ItemList.Circuit_Chip_NanoCPU.get(2L), ItemList.Circuit_Parts_CapacitorXSMD.get(3L),
                ItemList.Circuit_Parts_TransistorXSMD.get(3L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16) }, new

        FluidStack(solderIndalloy, 72), ItemList.Circuit_Bioprocessor.get(1L), 37, 614400, true);
        GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]

        { ItemList.Circuit_Board_Bio_Ultra.get(1L), ItemList.Circuit_Bioprocessor.get(2L),
                ItemList.Circuit_Parts_InductorASMD.get(12L), ItemList.Circuit_Parts_CapacitorASMD.get(16L),
                ItemList.Circuit_Chip_Ram.get(32L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 24) }, new

        FluidStack(solderIndalloy, 144), ItemList.Circuit_Biowarecomputer.get(1L), 400, 153600, true);
        GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]

        { ItemList.Circuit_Board_Bio_Ultra.get(1L), ItemList.Circuit_Bioprocessor.get(2L),
                ItemList.Circuit_Parts_InductorXSMD.get(3L), ItemList.Circuit_Parts_CapacitorXSMD.get(4L),
                ItemList.Circuit_Chip_Ram.get(32L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 24) }, new

        FluidStack(solderIndalloy, 144), ItemList.Circuit_Biowarecomputer.get(1L), 50, 614400, true);

        // Energy Flow Circuit
        GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]

        { ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 2),
                ItemList.Circuit_Chip_UHPIC.get(4L), ItemList.Circuit_Chip_QuantumCPU.get(2L),
                ItemList.Circuit_Chip_NanoCPU.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorZPM, 64) }, new

        FluidStack(solderIndalloy, 288), CustomItemList.HighEnergyFlowCircuit.get(1L), 2400, 7680, true);

        // SoC for nano, quantum, crystal
        GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]

        { ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Chip_SoC2.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 8) }, new

        FluidStack(solderIndalloy, 72), ItemList.Circuit_Nanoprocessor.get(1L), 50, 9600, true);
        GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]

        { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Chip_SoC2.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.NiobiumTitanium, 8) }, new

        FluidStack(solderIndalloy, 72), ItemList.Circuit_Quantumprocessor.get(1L), 50, 38400, true);
        GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]

        { ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), ItemList.Circuit_Chip_CrystalSoC.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 8),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.YttriumBariumCuprate, 8) }, new

        FluidStack(solderIndalloy, 72), ItemList.Circuit_Crystalprocessor.get(1L), 50, 153600, true);

    }

    private static final void registerOpticalComponentRecipes() {

        if (Loader.isModLoaded("bartworks")) {

            Fluid solderUEV = FluidRegistry.getFluid("molten.mutatedlivingsolder") != null
                    ? FluidRegistry.getFluid("molten.mutatedlivingsolder")
                    : FluidRegistry.getFluid("molten.solderingalloy");

            // Optically Perfected CPU
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Chip_Optical.get(1L),
                            ItemList.Optical_Cpu_Containment_Housing.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Infinity, 16L) },
                    new FluidStack(solderUEV, 288),
                    ItemList.Optically_Perfected_CPU.get(1L),
                    20 * 20,
                    1_966_080,
                    true);

            GT_Recipe.GT_Recipe_Map.sFluidHeaterRecipes.addRecipe(
                    false,
                    new ItemStack[] { GT_Utility.getIntegratedCircuit(1) },
                    null,
                    null,
                    new FluidStack[] { Materials.Grade1PurifiedWater.getFluid(1000L) },
                    new FluidStack[] { Materials.Grade2PurifiedWater.getFluid(900L) },
                    5000,
                    61_440,
                    0);
        }
    }
}
