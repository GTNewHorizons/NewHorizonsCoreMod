package com.dreammaster.gthandler.recipes;

import static com.dreammaster.MissingModIDs.DraconicEvolution;
import static com.dreammaster.MissingModIDs.Genetics;
import static gregtech.api.enums.ModIDs.BartWorks;
import static gregtech.api.enums.ModIDs.Gendustry;
import static gregtech.api.enums.ModIDs.HardcoreEnderExpansion;
import static gregtech.api.enums.ModIDs.IndustrialCraft2;
import static gregtech.api.enums.ModIDs.IndustrialCraft2Classic;
import static gregtech.api.enums.ModIDs.Natura;
import static gregtech.api.enums.ModIDs.NewHorizonsCoreMod;
import static gregtech.api.enums.ModIDs.TinkerConstruct;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import ic2.core.Ic2Items;

public class ChemicalReactorRecipes implements Runnable {

    @Override
    public void run() {
        singleBlockOnly();
        multiBlockOnly();

        // Potassium Hydroxide
        GT_Values.RA.addChemicalRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 1L),
                GT_Utility.getIntegratedCircuit(1),
                Materials.Water.getFluid(3000),
                Materials.Hydrogen.getGas(1000),
                GT_ModHandler.getModItem(NewHorizonsCoreMod.modID, "item.PotassiumHydroxideDust", 3L, 0),
                1200,
                30);
        // Rock Salt
        GT_Values.RA.addChemicalRecipe(
                GT_ModHandler.getModItem(NewHorizonsCoreMod.modID, "item.PotassiumHydroxideDust", 1L, 0),
                GT_Utility.getIntegratedCircuit(2),
                Materials.HydrochloricAcid.getFluid(1000),
                Materials.Water.getFluid(1000),
                Materials.RockSalt.getDust(1),
                100,
                30);

        // NaAlO2 + 2H2O = Al(OH)3 + NaOH
        GT_Values.RA.addChemicalRecipe(
                Materials.SodiumAluminate.getDust(4),
                GT_Utility.getIntegratedCircuit(1),
                Materials.Water.getFluid(2000L),
                GT_Values.NF,
                Materials.Aluminiumhydroxide.getDust(7),
                Materials.SodiumHydroxide.getDust(3),
                50,
                120);

        GT_Values.RA.addChemicalRecipe(
                ItemList.Circuit_Board_Phenolic.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 4),
                Materials.IronIIIChloride.getFluid(100L),
                GT_Values.NF,
                ItemList.Circuit_Board_Phenolic_Good.get(1L),
                600,
                30);
        GT_Values.RA.addChemicalRecipe(
                ItemList.Circuit_Board_Phenolic.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 4),
                Materials.SodiumPersulfate.getFluid(200),
                GT_Values.NF,
                ItemList.Circuit_Board_Phenolic_Good.get(1L),
                600,
                30);

        GT_Values.RA.addChemicalRecipe(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 1),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 4),
                Materials.SulfuricAcid.getFluid(500L),
                GT_Values.NF,
                ItemList.Circuit_Board_Plastic.get(1L),
                500,
                10);
        GT_Values.RA.addChemicalRecipe(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.PolyvinylChloride, 1),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 4),
                Materials.SulfuricAcid.getFluid(500L),
                GT_Values.NF,
                ItemList.Circuit_Board_Plastic.get(2L),
                500,
                10);
        GT_Values.RA.addChemicalRecipe(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Polytetrafluoroethylene, 1),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 4),
                Materials.SulfuricAcid.getFluid(500L),
                GT_Values.NF,
                ItemList.Circuit_Board_Plastic.get(4L),
                500,
                10);
        GT_Values.RA.addChemicalRecipe(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Polybenzimidazole, 1),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 4),
                Materials.SulfuricAcid.getFluid(500L),
                GT_Values.NF,
                ItemList.Circuit_Board_Plastic.get(8L),
                500,
                10);
        GT_Values.RA.addChemicalRecipe(
                ItemList.Circuit_Board_Plastic.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 6),
                Materials.IronIIIChloride.getFluid(250L),
                GT_Values.NF,
                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                800,
                30);
        GT_Values.RA.addChemicalRecipe(
                ItemList.Circuit_Board_Plastic.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 6),
                Materials.SodiumPersulfate.getFluid(500),
                GT_Values.NF,
                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                800,
                30);

        GT_Values.RA.addChemicalRecipe(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Epoxid, 1),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 8),
                Materials.SulfuricAcid.getFluid(500L),
                GT_Values.NF,
                ItemList.Circuit_Board_Epoxy.get(1L),
                600,
                30);
        GT_Values.RA.addChemicalRecipe(
                ItemList.Circuit_Board_Epoxy.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8),
                Materials.IronIIIChloride.getFluid(500L),
                GT_Values.NF,
                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                1200,
                30);
        GT_Values.RA.addChemicalRecipe(
                ItemList.Circuit_Board_Epoxy.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8),
                Materials.SodiumPersulfate.getFluid(1000L),
                GT_Values.NF,
                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                1200,
                30);

        GT_Values.RA.addChemicalRecipe(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EpoxidFiberReinforced, 1),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 12),
                Materials.SulfuricAcid.getFluid(500L),
                GT_Values.NF,
                ItemList.Circuit_Board_Fiberglass.get(1L),
                500,
                10);

        GT_Values.RA.addChemicalRecipe(
                ItemList.Circuit_Board_Fiberglass.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.EnergeticAlloy, 12),
                Materials.IronIIIChloride.getFluid(1000L),
                GT_Values.NF,
                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                GT_Values.NI,
                1800,
                30,
                true);
        GT_Values.RA.addChemicalRecipe(
                ItemList.Circuit_Board_Fiberglass.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.EnergeticAlloy, 12),
                Materials.SodiumPersulfate.getFluid(2000L),
                GT_Values.NF,
                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                GT_Values.NI,
                1800,
                30,
                true);
        GT_Values.RA.addChemicalRecipe(
                ItemList.Circuit_Board_Fiberglass.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Palladium, 16),
                Materials.SulfuricAcid.getFluid(500L),
                null,
                ItemList.Circuit_Board_Multifiberglass.get(1L),
                GT_Values.NI,
                600,
                480,
                true);
        GT_Values.RA.addChemicalRecipe(
                ItemList.Circuit_Board_Multifiberglass.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 8),
                Materials.IronIIIChloride.getFluid(2000L),
                GT_Values.NF,
                ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                GT_Values.NI,
                2400,
                120,
                true);
        GT_Values.RA.addChemicalRecipe(
                ItemList.Circuit_Board_Wetware.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 32),
                Materials.IronIIIChloride.getFluid(5000L),
                GT_Values.NF,
                ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                GT_Values.NI,
                3000,
                480,
                true);
        GT_Values.RA.addChemicalRecipe(
                ItemList.Circuit_Board_Multifiberglass.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 8),
                Materials.SodiumPersulfate.getFluid(4000L),
                GT_Values.NF,
                ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                GT_Values.NI,
                2400,
                120,
                true);
        GT_Values.RA.addChemicalRecipe(
                ItemList.Circuit_Board_Wetware.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 32),
                Materials.SodiumPersulfate.getFluid(10000L),
                GT_Values.NF,
                ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                GT_Values.NI,
                3000,
                480,
                true);
        GT_Values.RA.addChemicalRecipe(
                ItemList.Circuit_Board_Bio.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 24),
                Materials.IronIIIChloride.getFluid(7500L),
                GT_Values.NF,
                ItemList.Circuit_Board_Bio_Ultra.get(1L),
                GT_Values.NI,
                3600,
                1920,
                true);
        GT_Values.RA.addChemicalRecipe(
                ItemList.Circuit_Board_Bio.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 24),
                Materials.SodiumPersulfate.getFluid(15000L),
                GT_Values.NF,
                ItemList.Circuit_Board_Bio_Ultra.get(1L),
                GT_Values.NI,
                3600,
                1920,
                true);

        GT_Values.RA.addChemicalRecipe(
                CustomItemList.MutatedEgg.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HeeEndium, 64),
                FluidRegistry.getFluidStack("ender", 1000),
                GT_Values.NF,
                CustomItemList.EnderEgg.get(1L),
                GT_Values.NI,
                72000,
                480,
                true);

        GT_Values.RA.addChemicalRecipe(
                ItemList.Circuit_Wafer_PIC.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IndiumGalliumPhosphide, 2),
                Materials.VanadiumGallium.getMolten(288L),
                GT_Values.NF,
                ItemList.Circuit_Wafer_HPIC.get(1L),
                GT_Values.NI,
                1200,
                7860,
                true);
        GT_Values.RA.addChemicalRecipe(
                ItemList.Circuit_Wafer_HPIC.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IndiumGalliumPhosphide, 8),
                Materials.Naquadah.getMolten(576L),
                GT_Values.NF,
                ItemList.Circuit_Wafer_UHPIC.get(1L),
                GT_Values.NI,
                1200,
                30720,
                true);
        GT_Values.RA.addChemicalRecipe(
                ItemList.Circuit_Wafer_NPIC.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IndiumGalliumPhosphide, 64),
                Materials.Sunnarium.getMolten(1440L),
                GT_Values.NF,
                ItemList.Circuit_Wafer_PPIC.get(1L),
                GT_Values.NI,
                1200,
                122880,
                true);

        GT_Values.RA.addChemicalRecipe(
                ItemList.Circuit_Wafer_CPU.get(1L),
                GT_Utility.copyAmount(16, Ic2Items.carbonFiber),
                Materials.Glowstone.getMolten(576L),
                GT_Values.NF,
                ItemList.Circuit_Wafer_NanoCPU.get(1L),
                GT_Values.NI,
                1200,
                1920,
                true);
        GT_Values.RA.addChemicalRecipe(
                ItemList.Circuit_Wafer_NanoCPU.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IndiumGalliumPhosphide, 1),
                Materials.Radon.getGas(50L),
                GT_Values.NF,
                ItemList.Circuit_Wafer_QuantumCPU.get(1L),
                GT_Values.NI,
                1200,
                1920,
                true);
        GT_Values.RA.addChemicalRecipe(
                ItemList.Circuit_Wafer_NanoCPU.get(1L),
                ItemList.QuantumEye.get(2L),
                Materials.GalliumArsenide.getMolten(288L),
                GT_Values.NF,
                ItemList.Circuit_Wafer_QuantumCPU.get(1L),
                GT_Values.NI,
                900,
                1920,
                true);

        GT_Values.RA.addChemicalRecipe(
                GT_OreDictUnificator.get(Materials.Hydrogen.getCells(3)),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnetite, 0),
                Materials.Nitrogen.getGas(1000L),
                Materials.Ammonia.getGas(1000),
                ItemList.Cell_Empty.get(3L),
                320,
                384);

        GT_Values.RA.addChemicalRecipe(
                new ItemStack(Items.ghast_tear),
                GT_Utility.getIntegratedCircuit(1),
                Materials.Water.getFluid(1000L),
                Materials.SaltWater.getFluid(1000L),
                Materials.Potassium.getDustTiny(1),
                Materials.Lithium.getDustTiny(1),
                400,
                30,
                false);

        GT_Values.RA.addChemicalRecipe(
                new ItemStack(Items.ghast_tear, 9, 0),
                GT_Utility.getIntegratedCircuit(9),
                Materials.Water.getFluid(9000L),
                Materials.SaltWater.getFluid(9000L),
                Materials.Potassium.getDust(1),
                Materials.Lithium.getDust(1),
                3600,
                30,
                false);

        if (HardcoreEnderExpansion.isModLoaded()) {
            GT_Values.RA.addChemicalRecipe(
                    CustomItemList.EnderEgg.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 64),
                    FluidRegistry.getFluidStack("endergoo", 1000),
                    GT_Values.NF,
                    CustomItemList.DraconiumEgg.get(1L),
                    GT_Values.NI,
                    72000,
                    1024,
                    true);
        }

        if (DraconicEvolution.isModLoaded()) {
            GT_Values.RA.addChemicalRecipe(
                    CustomItemList.DraconiumEgg.get(1L),
                    GT_ModHandler.getModItem(DraconicEvolution.modID, "dragonHeart", 0L, 0),
                    FluidRegistry.getFluidStack("molten.enderium", 1000),
                    GT_Values.NF,
                    new ItemStack(Blocks.dragon_egg, 1, 0),
                    GT_Values.NI,
                    72000,
                    1920,
                    true);
        }

        if (Genetics.isModLoaded()) {
            GT_Values.RA.addChemicalRecipe(
                    new ItemStack(Items.spawn_egg, 1, GT_Values.W),
                    GT_ModHandler.getModItem(Genetics.modID, "misc", 64L, 4),
                    FluidRegistry.getFluidStack("binnie.bacteria", 1000),
                    GT_Values.NF,
                    CustomItemList.TheBigEgg.get(1L),
                    GT_Values.NI,
                    72000,
                    120,
                    true);
        }

        if (Gendustry.isModLoaded() && IndustrialCraft2.isModLoaded()) {
            GT_Values.RA.addChemicalRecipe(
                    CustomItemList.TheBigEgg.get(1L),
                    GT_ModHandler.getModItem(IndustrialCraft2Classic.modID, "itemUran238", 64L, 0),
                    FluidRegistry.getFluidStack("mutagen", 1000),
                    GT_Values.NF,
                    CustomItemList.MutatedEgg.get(1L),
                    GT_Values.NI,
                    72000,
                    256,
                    true);
        }

        if (Natura.isModLoaded()) {
            GT_Values.RA.addChemicalRecipe(
                    GT_ModHandler.getModItem(Natura.modID, "florasapling", 2L, 6),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L),
                    Materials.Water.getFluid(1000L),
                    GT_Values.NF,
                    ItemList.IC2_Fertilizer.get(2),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L),
                    200,
                    120);
            GT_Values.RA.addChemicalRecipe(
                    GT_ModHandler.getModItem(Natura.modID, "Dark Leaves", 8L, 0),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L),
                    Materials.Water.getFluid(1000L),
                    GT_Values.NF,
                    ItemList.IC2_Fertilizer.get(2),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L),
                    200,
                    120);
            GT_Values.RA.addChemicalRecipe(
                    GT_ModHandler.getModItem(Natura.modID, "Dark Tree", 2L, 0),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L),
                    Materials.Water.getFluid(1000L),
                    GT_Values.NF,
                    ItemList.IC2_Fertilizer.get(8),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TricalciumPhosphate, 1L),
                    200,
                    120);
            GT_Values.RA.addChemicalRecipe(
                    GT_ModHandler.getModItem(Natura.modID, "Natura.netherfood", 1L, 0),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L),
                    Materials.Water.getFluid(1000L),
                    GT_Values.NF,
                    ItemList.IC2_Fertilizer.get(32),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TricalciumPhosphate, 1L),
                    200,
                    120);
        }

        if (TinkerConstruct.isModLoaded()) {
            // Chemical Reactor
            GT_Values.RA.addChemicalRecipe(
                    new ItemStack(Blocks.diamond_block, 8, 0),
                    new ItemStack(Items.golden_apple, 1, 1),
                    Materials.Blaze.getMolten(144),
                    GT_Values.NF,
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "diamondApple", 1L, 0),
                    GT_Values.NI,
                    3600,
                    480);
        }

    }

    public static void singleBlockOnly() {
        // 6HF + Al(OH)3 + 3NaOH = Na3AlF6 + 6H2O
        GT_Values.RA.addChemicalRecipeForBasicMachineOnly(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumhydroxide, 7L),
                Materials.HydrofluoricAcid.getFluid(6000L),
                Materials.Water.getFluid(6000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cryolite, 10L),
                GT_Values.NI,
                300,
                30);

        GT_Values.RA.addChemicalRecipeForBasicMachineOnly(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bauxite, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                Materials.Water.getFluid(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
                GT_Values.NI,
                150,
                120);

    }

    public static void multiBlockOnly() {
        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumhydroxide, 49L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 63L),
                        GT_Utility.getIntegratedCircuit(24) },
                new FluidStack[] { Materials.HydrofluoricAcid.getFluid(42000L) },
                new FluidStack[] { Materials.Water.getFluid(42000L) },
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cryolite, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cryolite, 6L) },
                600,
                480);

        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bauxite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumCarbonate, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 16L),
                        GT_Utility.getIntegratedCircuit(24) },
                new FluidStack[] { Materials.Water.getFluid(2000L) },
                new FluidStack[] { Materials.Hydrogen.getGas(1000L), Materials.CarbonDioxide.getGas(4000L),
                        Materials.RedMud.getFluid(1000L) },
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L) },
                400,
                480);
        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bauxite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GT_Utility.getIntegratedCircuit(24) },
                new FluidStack[] { Materials.Water.getFluid(4000L) },
                new FluidStack[] {},
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L) },
                400,
                480);
        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 16L),
                        GT_Utility.getIntegratedCircuit(24) },
                new FluidStack[] { Materials.Water.getFluid(4000L) },
                new FluidStack[] {},
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L) },
                400,
                480);
        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Alumite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 16L),
                        GT_Utility.getIntegratedCircuit(24) },
                new FluidStack[] { Materials.Water.getFluid(4000L) },
                new FluidStack[] {},
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L) },
                400,
                480);
        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zeolite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 11L),
                        GT_Utility.getIntegratedCircuit(24) },
                new FluidStack[] { Materials.Water.getFluid(4000L) },
                new FluidStack[] {},
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L) },
                400,
                480);
        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tanzanite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 16L),
                        GT_Utility.getIntegratedCircuit(24) },
                new FluidStack[] { Materials.Water.getFluid(4000L) },
                new FluidStack[] {},
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L) },
                400,
                480);
        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lazurite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 16L),
                        GT_Utility.getIntegratedCircuit(24) },
                new FluidStack[] { Materials.Water.getFluid(4000L) },
                new FluidStack[] {},
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L) },
                400,
                480);
        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodalite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 16L),
                        GT_Utility.getIntegratedCircuit(24) },
                new FluidStack[] { Materials.Water.getFluid(4000L) },
                new FluidStack[] {},
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L) },
                400,
                480);
        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Biotite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 16L),
                        GT_Utility.getIntegratedCircuit(24) },
                new FluidStack[] { Materials.Water.getFluid(4000L) },
                new FluidStack[] {},
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L) },
                400,
                480);
        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glauconite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GT_Utility.getIntegratedCircuit(24) },
                new FluidStack[] { Materials.Water.getFluid(4000L) },
                new FluidStack[] {},
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L) },
                400,
                480);
        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lepidolite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GT_Utility.getIntegratedCircuit(24) },
                new FluidStack[] { Materials.Water.getFluid(4000L) },
                new FluidStack[] {},
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L) },
                400,
                480);
        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GlauconiteSand, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GT_Utility.getIntegratedCircuit(24) },
                new FluidStack[] { Materials.Water.getFluid(4000L) },
                new FluidStack[] {},
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L) },
                400,
                480);
        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vermiculite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GT_Utility.getIntegratedCircuit(24) },
                new FluidStack[] { Materials.Water.getFluid(4000L) },
                new FluidStack[] {},
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L) },
                400,
                480);

        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[] { com.dreammaster.item.ItemList.RawPicoWafer.getIS(),
                        Materials.MysteriousCrystal.getDust(2),
                        GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.InfinityCatalyst, 1L).copy()
                                .splitStack(0),
                        com.dreammaster.item.ItemList.TCetiESeaweedExtract.getIS(1) },
                new FluidStack[] { Materials.Neutronium.getMolten(144L) },
                new FluidStack[] { GT_Values.NF },
                new ItemStack[] { com.dreammaster.item.ItemList.PicoWafer.getIS() },
                3000,
                (int) (GT_Values.V[9] - (GT_Values.V[9] / 10)));

        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 48L),
                        GT_Utility.getIntegratedCircuit(24) },
                new FluidStack[] { Materials.Water.getFluid(16000L) },
                new FluidStack[] { Materials.Hydrogen.getGas(48000L) },
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L) },
                400,
                480);

        if (BartWorks.isModLoaded()) {
            GT_Values.RA.addMultiblockChemicalRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zeolite, 0, false),
                            GT_Utility.getIntegratedCircuit(1) },
                    new FluidStack[] { Materials.Grade4PurifiedWater.getFluid(1000) },
                    new FluidStack[] { Materials.Grade5PurifiedWater.getFluid(900), },
                    null,
                    500 * 10,
                    491_520);
        }
    }
}
