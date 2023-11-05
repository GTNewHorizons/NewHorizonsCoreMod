package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.Gendustry;
import static gregtech.api.enums.Mods.Genetics;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sChemicalRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMultiblockChemicalRecipes;
import static gregtech.api.util.GT_RecipeBuilder.INGOTS;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;
import static gregtech.api.util.GT_RecipeConstants.UniversalChemical;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
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

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.PotassiumHydroxideDust", 3L, 0))
                .fluidInputs(Materials.Water.getFluid(3000)).fluidOutputs(Materials.Hydrogen.getGas(1000))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_LV).addTo(UniversalChemical);
        // Rock Salt

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.PotassiumHydroxideDust", 1L, 0),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(Materials.RockSalt.getDust(1)).fluidInputs(Materials.HydrochloricAcid.getFluid(1000))
                .fluidOutputs(Materials.Water.getFluid(1000)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(UniversalChemical);

        // NaAlO2 + 2H2O = Al(OH)3 + NaOH

        GT_Values.RA.stdBuilder().itemInputs(Materials.SodiumAluminate.getDust(4), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(Materials.Aluminiumhydroxide.getDust(7), Materials.SodiumHydroxide.getDust(3))
                .fluidInputs(Materials.Water.getFluid(2000L)).duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Phenolic.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 4))
                .itemOutputs(ItemList.Circuit_Board_Phenolic_Good.get(1L))
                .fluidInputs(Materials.IronIIIChloride.getFluid(100L)).duration(30 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Phenolic.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 4))
                .itemOutputs(ItemList.Circuit_Board_Phenolic_Good.get(1L))
                .fluidInputs(Materials.SodiumPersulfate.getFluid(200)).duration(30 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 1),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 4))
                .itemOutputs(ItemList.Circuit_Board_Plastic.get(1L)).fluidInputs(Materials.SulfuricAcid.getFluid(500L))
                .duration(25 * SECONDS).eut(10).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.PolyvinylChloride, 1),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 4))
                .itemOutputs(ItemList.Circuit_Board_Plastic.get(2L)).fluidInputs(Materials.SulfuricAcid.getFluid(500L))
                .duration(25 * SECONDS).eut(10).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Polytetrafluoroethylene, 1),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 4))
                .itemOutputs(ItemList.Circuit_Board_Plastic.get(4L)).fluidInputs(Materials.SulfuricAcid.getFluid(500L))
                .duration(25 * SECONDS).eut(10).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Polybenzimidazole, 1),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 4))
                .itemOutputs(ItemList.Circuit_Board_Plastic.get(8L)).fluidInputs(Materials.SulfuricAcid.getFluid(500L))
                .duration(25 * SECONDS).eut(10).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 6))
                .itemOutputs(ItemList.Circuit_Board_Plastic_Advanced.get(1L))
                .fluidInputs(Materials.IronIIIChloride.getFluid(250L)).duration(40 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 6))
                .itemOutputs(ItemList.Circuit_Board_Plastic_Advanced.get(1L))
                .fluidInputs(Materials.SodiumPersulfate.getFluid(500)).duration(40 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Epoxid, 1),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 8))
                .itemOutputs(ItemList.Circuit_Board_Epoxy.get(1L)).fluidInputs(Materials.SulfuricAcid.getFluid(500L))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Epoxy.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8))
                .itemOutputs(ItemList.Circuit_Board_Epoxy_Advanced.get(1L))
                .fluidInputs(Materials.IronIIIChloride.getFluid(500L)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Epoxy.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8))
                .itemOutputs(ItemList.Circuit_Board_Epoxy_Advanced.get(1L))
                .fluidInputs(Materials.SodiumPersulfate.getFluid(1000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EpoxidFiberReinforced, 1),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 12))
                .itemOutputs(ItemList.Circuit_Board_Fiberglass.get(1L))
                .fluidInputs(Materials.SulfuricAcid.getFluid(500L)).duration(25 * SECONDS).eut(10)
                .addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Fiberglass.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.EnergeticAlloy, 12))
                .itemOutputs(ItemList.Circuit_Board_Fiberglass_Advanced.get(1L))
                .fluidInputs(Materials.IronIIIChloride.getFluid(1000L)).requiresCleanRoom()
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Fiberglass.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.EnergeticAlloy, 12))
                .itemOutputs(ItemList.Circuit_Board_Fiberglass_Advanced.get(1L))
                .fluidInputs(Materials.SodiumPersulfate.getFluid(2000L)).requiresCleanRoom()
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Fiberglass.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Palladium, 16))
                .itemOutputs(ItemList.Circuit_Board_Multifiberglass.get(1L))
                .fluidInputs(Materials.SulfuricAcid.getFluid(500L)).requiresCleanRoom().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Multifiberglass.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 8))
                .itemOutputs(ItemList.Circuit_Board_Multifiberglass_Elite.get(1L))
                .fluidInputs(Materials.IronIIIChloride.getFluid(2000L)).requiresCleanRoom().duration(2 * MINUTES)
                .eut(TierEU.RECIPE_MV).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Wetware.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 32))
                .itemOutputs(ItemList.Circuit_Board_Wetware_Extreme.get(1L))
                .fluidInputs(Materials.IronIIIChloride.getFluid(5000L)).requiresCleanRoom()
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Multifiberglass.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 8))
                .itemOutputs(ItemList.Circuit_Board_Multifiberglass_Elite.get(1L))
                .fluidInputs(Materials.SodiumPersulfate.getFluid(4000L)).requiresCleanRoom().duration(2 * MINUTES)
                .eut(TierEU.RECIPE_MV).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Wetware.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 32))
                .itemOutputs(ItemList.Circuit_Board_Wetware_Extreme.get(1L))
                .fluidInputs(Materials.SodiumPersulfate.getFluid(10000L)).requiresCleanRoom()
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Bio.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 24))
                .itemOutputs(ItemList.Circuit_Board_Bio_Ultra.get(1L))
                .fluidInputs(Materials.IronIIIChloride.getFluid(7500L)).requiresCleanRoom().duration(3 * MINUTES)
                .eut(TierEU.RECIPE_EV).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Bio.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 24))
                .itemOutputs(ItemList.Circuit_Board_Bio_Ultra.get(1L))
                .fluidInputs(Materials.SodiumPersulfate.getFluid(15000L)).requiresCleanRoom().duration(3 * MINUTES)
                .eut(TierEU.RECIPE_EV).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.MutatedEgg.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HeeEndium, 64))
                .itemOutputs(CustomItemList.EnderEgg.get(1L)).fluidInputs(FluidRegistry.getFluidStack("ender", 1000))
                .requiresCleanRoom().duration(60 * MINUTES).eut(TierEU.RECIPE_HV).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Wafer_PIC.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IndiumGalliumPhosphide, 2))
                .itemOutputs(ItemList.Circuit_Wafer_HPIC.get(1L)).fluidInputs(Materials.VanadiumGallium.getMolten(288L))
                .requiresCleanRoom().duration(60 * SECONDS).eut(7860).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Wafer_HPIC.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IndiumGalliumPhosphide, 8))
                .itemOutputs(ItemList.Circuit_Wafer_UHPIC.get(1L)).fluidInputs(Materials.Naquadah.getMolten(576L))
                .requiresCleanRoom().duration(60 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Wafer_NPIC.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IndiumGalliumPhosphide, 64))
                .itemOutputs(ItemList.Circuit_Wafer_PPIC.get(1L)).fluidInputs(Materials.Sunnarium.getMolten(1440L))
                .requiresCleanRoom().duration(60 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Circuit_Wafer_CPU.get(1L), GT_Utility.copyAmount(16, Ic2Items.carbonFiber))
                .itemOutputs(ItemList.Circuit_Wafer_NanoCPU.get(1L)).fluidInputs(Materials.Glowstone.getMolten(576L))
                .requiresCleanRoom().duration(60 * SECONDS).eut(TierEU.RECIPE_EV).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Wafer_NanoCPU.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IndiumGalliumPhosphide, 1))
                .itemOutputs(ItemList.Circuit_Wafer_QuantumCPU.get(1L)).fluidInputs(Materials.Radon.getGas(50L))
                .requiresCleanRoom().duration(60 * SECONDS).eut(TierEU.RECIPE_EV).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_NanoCPU.get(1L), ItemList.QuantumEye.get(2L))
                .itemOutputs(ItemList.Circuit_Wafer_QuantumCPU.get(1L))
                .fluidInputs(Materials.GalliumArsenide.getMolten(288L)).requiresCleanRoom().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.ghast_tear), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(Materials.Potassium.getDustTiny(1), Materials.Lithium.getDustTiny(1))
                .fluidInputs(Materials.Water.getFluid(1000L)).fluidOutputs(Materials.SaltWater.getFluid(1000L))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(UniversalChemical);

        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.ghast_tear, 9, 0), GT_Utility.getIntegratedCircuit(9))
                .itemOutputs(Materials.Potassium.getDust(1), Materials.Lithium.getDust(1))
                .fluidInputs(Materials.Water.getFluid(9000L)).fluidOutputs(Materials.SaltWater.getFluid(9000L))
                .duration(3 * MINUTES).eut(TierEU.RECIPE_LV).addTo(UniversalChemical);

        if (HardcoreEnderExpansion.isModLoaded()) {

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            CustomItemList.EnderEgg.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 64))
                    .itemOutputs(CustomItemList.DraconiumEgg.get(1L))
                    .fluidInputs(FluidRegistry.getFluidStack("endergoo", 1000)).requiresCleanRoom()
                    .duration(60 * MINUTES).eut(1024).addTo(UniversalChemical);

        }

        if (DraconicEvolution.isModLoaded()) {

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            CustomItemList.DraconiumEgg.get(1L),
                            GT_ModHandler.getModItem(DraconicEvolution.ID, "dragonHeart", 0L, 0))
                    .itemOutputs(new ItemStack(Blocks.dragon_egg, 1, 0))
                    .fluidInputs(Materials.Enderium.getMolten(7 * INGOTS)).requiresCleanRoom().duration(60 * MINUTES)
                    .eut(TierEU.RECIPE_EV).addTo(UniversalChemical);

        }

        if (Genetics.isModLoaded()) {

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Items.spawn_egg, 1, GT_Values.W),
                            GT_ModHandler.getModItem(Genetics.ID, "misc", 64L, 4))
                    .itemOutputs(CustomItemList.TheBigEgg.get(1L))
                    .fluidInputs(FluidRegistry.getFluidStack("binnie.bacteria", 1000)).requiresCleanRoom()
                    .duration(60 * MINUTES).eut(TierEU.RECIPE_MV).addTo(UniversalChemical);

        }

        if (Gendustry.isModLoaded() && IndustrialCraft2.isModLoaded()) {

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            CustomItemList.TheBigEgg.get(1L),
                            GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemUran238", 64L, 0))
                    .itemOutputs(CustomItemList.MutatedEgg.get(1L))
                    .fluidInputs(FluidRegistry.getFluidStack("mutagen", 1000)).requiresCleanRoom()
                    .duration(60 * MINUTES).eut(256).addTo(UniversalChemical);

        }

        if (Natura.isModLoaded()) {

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(Natura.ID, "florasapling", 2L, 6),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L))
                    .itemOutputs(
                            ItemList.IC2_Fertilizer.get(2),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L))
                    .fluidInputs(Materials.Water.getFluid(1000L)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(UniversalChemical);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(Natura.ID, "Dark Leaves", 8L, 0),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L))
                    .itemOutputs(
                            ItemList.IC2_Fertilizer.get(2),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L))
                    .fluidInputs(Materials.Water.getFluid(1000L)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(UniversalChemical);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(Natura.ID, "Dark Tree", 2L, 0),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L))
                    .itemOutputs(
                            ItemList.IC2_Fertilizer.get(8),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TricalciumPhosphate, 1L))
                    .fluidInputs(Materials.Water.getFluid(1000L)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(UniversalChemical);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(Natura.ID, "Natura.netherfood", 1L, 0),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L))
                    .itemOutputs(
                            ItemList.IC2_Fertilizer.get(32),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TricalciumPhosphate, 1L))
                    .fluidInputs(Materials.Water.getFluid(1000L)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(UniversalChemical);

        }

        if (TinkerConstruct.isModLoaded()) {
            // Chemical Reactor

            GT_Values.RA.stdBuilder()
                    .itemInputs(new ItemStack(Blocks.diamond_block, 8, 0), new ItemStack(Items.golden_apple, 1, 1))
                    .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "diamondApple", 1L, 0))
                    .fluidInputs(Materials.Blaze.getMolten(144)).duration(3 * MINUTES).eut(TierEU.RECIPE_HV)
                    .addTo(UniversalChemical);

        }

    }

    public static void singleBlockOnly() {
        // 6HF + Al(OH)3 + 3NaOH = Na3AlF6 + 6H2O

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 9L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumhydroxide, 7L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cryolite, 10L))
                .fluidInputs(Materials.HydrofluoricAcid.getFluid(6000L)).fluidOutputs(Materials.Water.getFluid(6000L))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sChemicalRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bauxite, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
                .fluidInputs(Materials.Water.getFluid(1000L)).duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sChemicalRecipes);

    }

    public static void multiBlockOnly() {

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumhydroxide, 49L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 63L),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cryolite, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cryolite, 6L))
                .fluidInputs(Materials.HydrofluoricAcid.getFluid(42000L)).fluidOutputs(Materials.Water.getFluid(42000L))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sMultiblockChemicalRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bauxite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumCarbonate, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 16L),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L))
                .fluidInputs(Materials.Water.getFluid(2000L))
                .fluidOutputs(
                        Materials.Hydrogen.getGas(1000L),
                        Materials.CarbonDioxide.getGas(4000L),
                        Materials.RedMud.getFluid(1000L))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sMultiblockChemicalRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bauxite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L))
                .fluidInputs(Materials.Water.getFluid(4000L)).fluidOutputs().duration(20 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sMultiblockChemicalRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 16L),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L))
                .fluidInputs(Materials.Water.getFluid(4000L)).fluidOutputs().duration(20 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sMultiblockChemicalRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Alumite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 16L),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L))
                .fluidInputs(Materials.Water.getFluid(4000L)).fluidOutputs().duration(20 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sMultiblockChemicalRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zeolite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 11L),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L))
                .fluidInputs(Materials.Water.getFluid(4000L)).fluidOutputs().duration(20 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sMultiblockChemicalRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tanzanite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 16L),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L))
                .fluidInputs(Materials.Water.getFluid(4000L)).fluidOutputs().duration(20 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sMultiblockChemicalRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lazurite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 16L),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L))
                .fluidInputs(Materials.Water.getFluid(4000L)).fluidOutputs().duration(20 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sMultiblockChemicalRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodalite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 16L),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L))
                .fluidInputs(Materials.Water.getFluid(4000L)).fluidOutputs().duration(20 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sMultiblockChemicalRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Biotite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 16L),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L))
                .fluidInputs(Materials.Water.getFluid(4000L)).fluidOutputs().duration(20 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sMultiblockChemicalRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glauconite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L))
                .fluidInputs(Materials.Water.getFluid(4000L)).fluidOutputs().duration(20 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sMultiblockChemicalRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lepidolite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L))
                .fluidInputs(Materials.Water.getFluid(4000L)).fluidOutputs().duration(20 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sMultiblockChemicalRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GlauconiteSand, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L))
                .fluidInputs(Materials.Water.getFluid(4000L)).fluidOutputs().duration(20 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sMultiblockChemicalRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vermiculite, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L))
                .fluidInputs(Materials.Water.getFluid(4000L)).fluidOutputs().duration(20 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sMultiblockChemicalRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        com.dreammaster.item.ItemList.RawPicoWafer.getIS(),
                        Materials.MysteriousCrystal.getDust(2),
                        GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.InfinityCatalyst, 1L).copy()
                                .splitStack(0),
                        com.dreammaster.item.ItemList.TCetiESeaweedExtract.getIS(1))
                .itemOutputs(com.dreammaster.item.ItemList.PicoWafer.getIS())
                .fluidInputs(Materials.Neutronium.getMolten(144L)).duration(2 * MINUTES + 30 * SECONDS)
                .eut((GT_Values.V[9] - (GT_Values.V[9] / 10))).addTo(sMultiblockChemicalRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 48L),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L))
                .fluidInputs(Materials.Water.getFluid(16000L)).fluidOutputs(Materials.Hydrogen.getGas(48000L))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sMultiblockChemicalRecipes);

        if (BartWorks.isModLoaded()) {

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zeolite, 0, false),
                            GT_Utility.getIntegratedCircuit(1))
                    .fluidInputs(Materials.Grade4PurifiedWater.getFluid(1000))
                    .fluidOutputs(Materials.Grade5PurifiedWater.getFluid(900)).duration(4 * MINUTES + 10 * SECONDS)
                    .eut(TierEU.RECIPE_UV).addTo(sMultiblockChemicalRecipes);

        }
    }

}
