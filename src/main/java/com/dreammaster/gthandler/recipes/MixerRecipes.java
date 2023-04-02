package com.dreammaster.gthandler.recipes;

import static com.dreammaster.MissingModIDs.DraconicEvolution;
import static com.dreammaster.MissingModIDs.ExtraTrees;
import static com.dreammaster.MissingModIDs.Genetics;
import static com.dreammaster.MissingModIDs.Witchery;
import static com.dreammaster.bartworksHandler.BartWorksMaterials.getBartWorksMaterialByIGNName;
import static gregtech.api.enums.ModIDs.AppliedEnergistics2;
import static gregtech.api.enums.ModIDs.BartWorks;
import static gregtech.api.enums.ModIDs.BiomesOPlanty;
import static gregtech.api.enums.ModIDs.EnderIO;
import static gregtech.api.enums.ModIDs.GTPlusPlus;
import static gregtech.api.enums.ModIDs.IndustrialCraft2;
import static gregtech.api.enums.ModIDs.Natura;
import static gregtech.api.enums.ModIDs.OpenComputers;
import static gregtech.api.enums.ModIDs.PamsHarvestCraft;
import static gregtech.api.enums.ModIDs.Thaumcraft;
import static gregtech.api.enums.ModIDs.TinkerConstruct;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.gthandler.GT_CoreModSupport;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class MixerRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CallistoIce, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 1L),
                GT_Values.NI,
                GT_Values.NI,
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000),
                Materials.SuperCoolant.getFluid(2000),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ice, 2L),
                200,
                480);

        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bauxite, 16L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L),
                100,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Bauxite, 16L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L),
                300,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Bauxite, 16L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L),
                200,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Aluminium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 4L),
                300,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Aluminium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 4L),
                200,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodalite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
                100,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Sodalite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
                300,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Sodalite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
                200,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Alunite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
                100,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Alunite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
                300,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Alunite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
                200,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lepidolite, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
                100,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Lepidolite, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
                300,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Lepidolite, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
                200,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
                100,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Mica, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
                300,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Mica, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
                200,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tanzanite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
                100,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Tanzanite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
                300,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Tanzanite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
                200,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Biotite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
                100,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Biotite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
                300,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Biotite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
                200,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lazurite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
                100,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Lazurite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
                300,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Lazurite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
                200,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glauconite, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
                100,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Glauconite, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
                300,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Glauconite, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
                200,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GlauconiteSand, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
                100,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.GlauconiteSand, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
                300,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.GlauconiteSand, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
                200,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vermiculite, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
                100,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Vermiculite, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
                300,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Vermiculite, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
                200,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zeolite, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 6L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 36L),
                100,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Zeolite, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 6L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 36L),
                300,
                48);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Zeolite, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 6L),
                GT_Utility.getIntegratedCircuit(5),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 36L),
                200,
                48);

        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrudeSteel, 3L),
                100,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 3L),
                100,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 3L),
                100,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 3L),
                100,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(3),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 3L),
                100,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 3L),
                100,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VividAlloy, 3L),
                100,
                8);

        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Oriharukon, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 3L),
                100,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherStar, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StellarAlloy, 3L),
                100,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 3L),
                100,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PulsatingIron, 3L),
                100,
                8);
        GT_Values.RA.addMixerRecipe(
                new ItemStack(Blocks.soul_sand, 1, 0),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Soularium, 3L),
                100,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 3L),
                100,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Endstone, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 3L),
                100,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 4L),
                400,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Enderium, 4L),
                200,
                8);

        // Superconductor dust recipes in mixer.

        // MV Superconductor dust recipe.
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cadmium, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                Materials.Oxygen.getGas(6000),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pentacadmiummagnesiumhexaoxid, 12L),
                10 * 20,
                120);

        // HV Superconductor dust recipe.
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Barium, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 10L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                Materials.Oxygen.getGas(20000),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titaniumonabariumdecacoppereikosaoxid, 40L),
                10 * 20,
                480);

        // EV Superconductor dust recipe.
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 3L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraniumtriplatinid, 4L),
                10 * 20,
                1920);

        // IV Superconductor dust recipe.
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 3L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadiumtriindinid, 4L),
                10 * 20,
                7680);

        // LuV Superconductor dust recipe.
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Barium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 7L),
                GT_Utility.getIntegratedCircuit(3),
                Materials.Oxygen.getGas(14000),
                GT_Values.NF,
                GT_OreDictUnificator.get(
                        OrePrefixes.dust,
                        Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                        30L),
                10 * 20,
                30720);

        // ZPM Superconductor dust recipe.
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Palladium, 6L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L),
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 13L),
                10 * 20,
                122880);

        // UV Superconductor dust recipe.
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadria, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmiridium, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Europium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Samarium, 1L),
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuvwire, 9L),
                10 * 20,
                491520);

        // UHV Superconductor Recipe.
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 6L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CosmicNeutronium, 7L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tritanium, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Americium, 6L),
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuhvwire, 24L),
                10 * 20,
                1966080);

        // UEV Superconductor dust recipe.
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DraconiumAwakened, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Infinity, 5L),
                GT_ModHandler.getModItem(GTPlusPlus.modID, "itemDustCelestialTungsten", 1L),
                GT_ModHandler.getModItem(GTPlusPlus.modID, "itemDustAdvancedNitinol", 1L),
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NI,
                Materials.Iron.getPlasma(144L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SuperconductorUEVBase, 12L),
                10 * 20,
                7864320);

        // UIV Superconductor dust recipe.
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, GT_CoreModSupport.RadoxPolymer, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TranscendentMetal, 10L),
                GT_ModHandler.getModItem(GTPlusPlus.modID, "itemDustRhugnor", 6L),
                GT_ModHandler.getModItem(GTPlusPlus.modID, "itemDustChromaticGlass", 5L),
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NI,
                Materials.Bismuth.getPlasma(144L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SuperconductorUIVBase, 25L),
                10 * 20,
                31457280);

        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ardite, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 2L),
                400,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 3L),
                ItemList.IC2_Resin.get(1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                CustomItemList.MicaBasedPulp.get(4L),
                400,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RawRubber, 2L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                CustomItemList.MicaBasedPulp.get(4L),
                400,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.getDust(Materials.NaquadahAlloy, 4L * OrePrefixes.dust.mMaterialAmount),
                (int) (400L * OrePrefixes.dust.mMaterialAmount / 3628800L),
                8000);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Barium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.AnyCopper, 3L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                Materials.Oxygen.getGas(7000),
                GT_Values.NF,
                GT_OreDictUnificator.getDust(Materials.YttriumBariumCuprate, 13L * OrePrefixes.dust.mMaterialAmount),
                (int) (600L * OrePrefixes.dust.mMaterialAmount / 3628800L),
                2000);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 6L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.AnyCopper, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1L),
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(3),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.getDust(Materials.Duralumin, 9L * OrePrefixes.dust.mMaterialAmount),
                (int) (900L * OrePrefixes.dust.mMaterialAmount / 3628800L),
                2000);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 2L),
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                CustomItemList.AlumiteDust.get(9L),
                200,
                8);

        GT_Values.RA.addMixerRecipe(
                ItemList.IC2_Energium_Dust.get(9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 6L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                CustomItemList.LapotronDust.get(15L),
                600,
                480);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Flint, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 4L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 4L),
                200,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 16L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(4),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 16L),
                800,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Flint, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 4L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 5L),
                160,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 16L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(4),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 20L),
                640,
                8);

        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 7L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumSteel, 9L),
                100,
                30);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 4L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RoseGold, 5L),
                200,
                120);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 6L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 9L),
                900,
                120);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RoseGold, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedGold, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.AstralSilver, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SterlingSilver, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SolderingAlloy, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlueSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L),
                GT_Utility.getIntegratedCircuit(4),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectrumFlux, 4L),
                50,
                900);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 6L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Molybdenum, 1L),
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(18),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DamascusSteel, 18L),
                225,
                900);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(9),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DamascusSteel, 18L),
                225,
                900);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Electrum, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Electrotine, 1L),
                200,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L),
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                Materials.Water.getFluid(2000L),
                Materials.Concrete.getMolten(2304L),
                GT_Values.NI,
                100,
                16);

        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Clay, 8L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_ModHandler.getWater(1000L),
                GT_Values.NF,
                new ItemStack(Items.clay_ball, 4, 0),
                100,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 4L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedAlloy, 1L),
                100,
                16);

        GT_Values.RA.addMixerRecipe(
                new ItemStack(Blocks.dirt, 1, 0),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 2L),
                new ItemStack(Blocks.sand, 4, 0),
                GT_Values.NI,
                Materials.Water.getFluid(1000L),
                GT_Values.NF,
                ItemList.IC2_Fertilizer.get(4),
                100,
                30);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Antimony, 1L),
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BatteryAlloy, 5L),
                100,
                4);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Antimony, 1L),
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SolderingAlloy, 10L),
                100,
                8);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 2L),
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnalium, 3L),
                100,
                4);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neutronium, 16L),
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NI,
                Materials.Helium.getPlasma(2304L),
                GT_Values.NF,
                CustomItemList.RawNeutronium.get(16L),
                3600,
                122880);
        // One Step Alloy Dust Mixer
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 3L),
                GT_Utility.getIntegratedCircuit(15),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 9L),
                120,
                120);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 9L),
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(17),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 27L),
                240,
                480);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 12L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 9L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(16),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 27L),
                240,
                480);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 12L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 27L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 27L),
                GT_Utility.getIntegratedCircuit(18),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VividAlloy, 64L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VividAlloy, 17L),
                GT_Values.NI,
                GT_Values.NI,
                480,
                480);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 27L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 27L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 9L),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 64L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 17L),
                GT_Values.NI,
                GT_Values.NI,
                480,
                480);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 3L),
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(14),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 9L),
                120,
                120);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Endstone, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 9L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(16),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 27L),
                240,
                480);
        GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Endstone, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 27L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Oriharukon, 27L),
                GT_Utility.getIntegratedCircuit(18),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 64L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 17L),
                GT_Values.NI,
                GT_Values.NI,
                480,
                480);

        GT_Values.RA.addMixerRecipe(
                new ItemStack[] { GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemFuelPlantBall", 16L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 2L),
                        GT_Utility.getIntegratedCircuit(1) },
                new FluidStack[] { GT_Values.NF },
                new ItemStack[] { CustomItemList.BioBall.get(1L) },
                new FluidStack[] { GT_Values.NF },
                200,
                16);

        GT_Values.RA.addMixerRecipe(
                com.dreammaster.item.ItemList.TCetiESeaweedExtract.getIS().splitStack(64),
                Materials.Dolomite.getDust(64),
                Materials.SamariumMagnetic.getDust(21),
                Materials.ChromiumDioxide.getDust(64),
                GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Jasper, 54L),
                GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Opal, 47L),
                GT_Values.NF,
                GT_Values.NF,
                com.dreammaster.item.ItemList.StargateCrystalDust.getIS(),
                3600,
                262144);

        // Astral Silver & Soldering Alloy + reverse
        GT_Values.RA.addMixerRecipe(
                Materials.Silver.getDust(2),
                Materials.Thaumium.getDust(1),
                GT_Utility.getIntegratedCircuit(1),
                null,
                null,
                null,
                Materials.AstralSilver.getDust(3),
                60,
                480);
        GT_Values.RA.addMixerRecipe(
                Materials.Tin.getDust(9),
                Materials.Antimony.getDust(1),
                GT_Utility.getIntegratedCircuit(1),
                null,
                null,
                null,
                Materials.SolderingAlloy.getDust(10),
                60,
                30);

        if (PamsHarvestCraft.isModLoaded()) {
            GT_Values.RA.addMixerRecipe(
                    new ItemStack[] { GT_ModHandler.getModItem(PamsHarvestCraft.modID, "soybeanItem", 1, 0) },
                    new FluidStack[] { Materials.Water.getFluid(100L) },
                    new ItemStack[] { CustomItemList.WetTofu.get(1L) },
                    new FluidStack[] { GT_Values.NF },
                    600,
                    2);

            GT_Values.RA.addMixerRecipe(
                    new ItemStack[] { GT_ModHandler.getModItem(PamsHarvestCraft.modID, "soybeanItem", 1, 0) },
                    new FluidStack[] { GT_ModHandler.getDistilledWater(50L), },
                    new ItemStack[] { CustomItemList.WetTofu.get(1L) },
                    new FluidStack[] { GT_Values.NF },
                    400,
                    2);
        }

        if (OpenComputers.isModLoaded()) {
            // Chamelium
            GT_Values.RA.addMixerRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 4L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 4L),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(2),
                    Materials.Water.getFluid(1000L),
                    GT_Values.NF,
                    GT_ModHandler.getModItem(OpenComputers.modID, "item", 9L, 96),
                    200,
                    120);
        }

        if (BiomesOPlanty.isModLoaded()) {
            GT_Values.RA.addMixerRecipe(
                    new ItemStack(Blocks.dirt, 1, 0),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(4),
                    Materials.Water.getFluid(1000L),
                    GT_Values.NF,
                    GT_ModHandler.getModItem(BiomesOPlanty.modID, "mudball", 4L, 0),
                    50,
                    8);
        }

        if (BartWorks.isModLoaded()) {
            // UMV Superconductor dust recipe.
            GT_Values.RA.addMixerRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SpaceTime, 6L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, getBartWorksMaterialByIGNName("Orundum"), 3L),
                    GT_ModHandler.getModItem(GTPlusPlus.modID, "itemDustHypogen", 11L),
                    GT_ModHandler.getModItem(GTPlusPlus.modID, "itemDustTitansteel", 5L),
                    GT_ModHandler.getModItem(GTPlusPlus.modID, "itemDustDragonblood", 2L),
                    GT_Utility.getIntegratedCircuit(2),
                    Materials.Oxygen.getPlasma(144L),
                    GT_Values.NF,
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SuperconductorUMVBase, 27L),
                    10 * 20,
                    125829120);
        }

        if (EnderIO.isModLoaded()) {
            GT_Values.RA.addMixerRecipe(
                    GT_ModHandler.getModItem(EnderIO.modID, "itemMaterial", 1L, 14),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Emerald, 1L),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(2),
                    GT_Values.NF,
                    GT_Values.NF,
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallineAlloy, 3L),
                    100,
                    8);
        }

        if (ExtraTrees.isModLoaded()) {
            GT_Values.RA.addMixerRecipe(
                    GT_ModHandler.getModItem(ExtraTrees.modID, "misc", 4L, 2),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(1),
                    Materials.Water.getFluid(500L),
                    GT_Values.NF,
                    ItemList.FR_Mulch.get(1L),
                    600,
                    2);
        }

        if (TinkerConstruct.isModLoaded() && Natura.isModLoaded()) {
            GT_Values.RA.addMixerRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 3L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(2),
                    GT_Values.NF,
                    GT_Values.NF,
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "materials", 4L, 42),
                    200,
                    8);

            GT_Values.RA.addMixerRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "slime.gel", 1L, 2),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallineAlloy, 1L),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(2),
                    GT_Values.NF,
                    GT_Values.NF,
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallinePinkSlime, 3L),
                    100,
                    8);

            GT_Values.RA.addMixerRecipe(
                    new ItemStack(Blocks.sand, 3, 0),
                    new ItemStack(Blocks.gravel, 3, 0),
                    new ItemStack(Blocks.clay, 2, 0),
                    GT_Values.NI,
                    Materials.Water.getFluid(2000L),
                    GT_Values.NF,
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "CraftedSoil", 8L, 1),
                    200,
                    16);
            GT_Values.RA.addMixerRecipe(
                    new ItemStack(Blocks.sand, 3, 1),
                    new ItemStack(Blocks.gravel, 3, 0),
                    new ItemStack(Blocks.clay, 2, 0),
                    GT_Values.NI,
                    Materials.Water.getFluid(2000L),
                    GT_Values.NF,
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "CraftedSoil", 8L, 1),
                    200,
                    16);
            GT_Values.RA.addMixerRecipe(
                    new ItemStack(Items.nether_wart, 1, 0),
                    new ItemStack(Blocks.soul_sand, 1, 0),
                    new ItemStack(Blocks.gravel, 1, 0),
                    GT_ModHandler.getModItem(Natura.modID, "soil.tainted", 1L, 0),
                    GT_Utility.getIntegratedCircuit(1),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    Materials.Water.getFluid(2000L),
                    GT_Values.NF,
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "CraftedSoil", 2L, 6),
                    200,
                    16);
            GT_Values.RA.addMixerRecipe(
                    new ItemStack(Items.nether_wart, 1, 0),
                    new ItemStack(Blocks.soul_sand, 1, 0),
                    new ItemStack(Blocks.gravel, 1, 0),
                    new ItemStack(Blocks.sand, 1, 32767),
                    GT_Utility.getIntegratedCircuit(2),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    Materials.Water.getFluid(2000L),
                    GT_Values.NF,
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "CraftedSoil", 2L, 6),
                    200,
                    16);
        }

        if (Witchery.isModLoaded() && Genetics.isModLoaded()) {
            GT_Values.RA.addMixerRecipe(
                    new ItemStack(Items.sugar, 1, 0),
                    new ItemStack(Items.bone, 1, 0),
                    ItemList.FR_Mulch.get(1L),
                    GT_ModHandler.getModItem(Witchery.modID, "ingredient", 1L, 18),
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(2),
                    Materials.Water.getFluid(1000L),
                    GT_Values.NF,
                    GT_ModHandler.getModItem(Genetics.modID, "misc", 1L, 4),
                    400,
                    16);
            GT_Values.RA.addMixerRecipe(
                    new ItemStack(Items.sugar, 1, 0),
                    new ItemStack(Items.bone, 1, 0),
                    ItemList.FR_Mulch.get(1L),
                    GT_ModHandler.getModItem(Witchery.modID, "ingredient", 1L, 18),
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(3),
                    GT_ModHandler.getDistilledWater(800L),
                    GT_Values.NF,
                    GT_ModHandler.getModItem(Genetics.modID, "misc", 1L, 4),
                    400,
                    16);
        }

        if (Thaumcraft.isModLoaded() && DraconicEvolution.isModLoaded() && Witchery.isModLoaded()) {
            GT_Values.RA.addMixerRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L),
                    GT_ModHandler.getModItem(Thaumcraft.modID, "ItemResource", 1L, 14),
                    new ItemStack(Items.sugar, 1, 0),
                    GT_ModHandler.getModItem(DraconicEvolution.modID, "draconiumDust", 1L, 0),
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(2),
                    FluidRegistry.getFluidStack("witchery:fluidspirit", 1000),
                    GT_Values.NF,
                    CustomItemList.MalformedSlush.get(2L),
                    600,
                    7680);
        }

        if (AppliedEnergistics2.isModLoaded()) {
            GT_Values.RA.addMixerRecipe(
                    CustomItemList.ChargedCertusQuartzDust.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(4),
                    Materials.Water.getFluid(500L),
                    GT_Values.NF,
                    GT_ModHandler.getModItem(AppliedEnergistics2.modID, "item.ItemMultiMaterial", 2L, 8),
                    20,
                    16);
            GT_Values.RA.addMixerRecipe(
                    CustomItemList.ChargedCertusQuartzDust.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(4),
                    GT_ModHandler.getDistilledWater(500L),
                    GT_Values.NF,
                    GT_ModHandler.getModItem(AppliedEnergistics2.modID, "item.ItemMultiMaterial", 2L, 8),
                    20,
                    16);
        }
    }
}
