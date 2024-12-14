package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.Chisel;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.ExtraTrees;
import static gregtech.api.enums.Mods.Genetics;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.UniversalSingularities;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gtPlusPlus.api.recipe.GTPPRecipeMaps.mixerNonCellRecipes;
import static gtPlusPlus.core.material.MaterialsElements.STANDALONE.CHRONOMATIC_GLASS;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;

import goodgenerator.items.GGMaterial;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gtPlusPlus.core.material.MaterialsElements;
import gtPlusPlus.core.material.Particle;

public class MixerRecipes implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CallistoIce, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 1L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ice, 2L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000))
                .fluidOutputs(Materials.SuperCoolant.getFluid(2000)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Bauxite, 16L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 48L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.Bauxite, 16L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 48L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L))
                .duration(15 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustPure, Materials.Bauxite, 16L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 48L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L))
                .duration(10 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.Aluminium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 4L))
                .duration(15 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustPure, Materials.Aluminium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 4L))
                .duration(10 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sodalite, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 9L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.Sodalite, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 9L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
                .duration(15 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustPure, Materials.Sodalite, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 9L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
                .duration(10 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Alunite, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 9L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.Alunite, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 9L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
                .duration(15 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustPure, Materials.Alunite, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 9L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
                .duration(10 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lepidolite, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.Lepidolite, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
                .duration(15 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustPure, Materials.Lepidolite, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
                .duration(10 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 9L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.Mica, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 9L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
                .duration(15 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustPure, Materials.Mica, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 9L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
                .duration(10 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tanzanite, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 9L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.Tanzanite, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 9L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
                .duration(15 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustPure, Materials.Tanzanite, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 9L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
                .duration(10 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Biotite, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 9L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lazurite, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 9L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.Lazurite, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 9L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
                .duration(15 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustPure, Materials.Lazurite, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 9L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
                .duration(10 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Glauconite, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.Glauconite, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
                .duration(15 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustPure, Materials.Glauconite, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
                .duration(10 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.GlauconiteSand, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.GlauconiteSand, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
                .duration(15 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustPure, Materials.GlauconiteSand, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
                .duration(10 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Vermiculite, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.Vermiculite, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
                .duration(15 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustPure, Materials.Vermiculite, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
                .duration(10 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Zeolite, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 27L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 36L))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.Zeolite, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 27L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 36L))
                .duration(15 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustPure, Materials.Zeolite, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 27L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 36L))
                .duration(10 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.CrudeSteel, 3L)).duration(5 * SECONDS)
                .eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 3L))
                .duration(5 * SECONDS).eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 3L))
                .duration(5 * SECONDS).eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 3L))
                .duration(5 * SECONDS).eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 1L),
                        GTUtility.getIntegratedCircuit(3))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 3L))
                .duration(5 * SECONDS).eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 3L))
                .duration(5 * SECONDS).eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.VividAlloy, 3L)).duration(5 * SECONDS)
                .eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Oriharukon, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 3L))
                .duration(5 * SECONDS).eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherStar, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.StellarAlloy, 3L))
                .duration(5 * SECONDS).eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 3L))
                .duration(5 * SECONDS).eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.PulsatingIron, 3L))
                .duration(5 * SECONDS).eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.soul_sand, 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Soularium, 3L)).duration(5 * SECONDS)
                .eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 3L)).duration(5 * SECONDS)
                .eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Endstone, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 3L)).duration(5 * SECONDS)
                .eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 2L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 4L))
                .duration(20 * SECONDS).eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 2L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Enderium, 4L)).duration(10 * SECONDS)
                .eut(8).addTo(mixerRecipes);

        // Superconductor dust recipes in mixer.

        // MV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Cadmium, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Pentacadmiummagnesiumhexaoxid, 12L))
                .fluidInputs(Materials.Oxygen.getGas(6000)).duration(10 * 20).eut(TierEU.RECIPE_MV).addTo(mixerRecipes);
        // HV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Barium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 10L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Titaniumonabariumdecacoppereikosaoxid, 40L))
                .fluidInputs(Materials.Oxygen.getGas(20000)).duration(10 * 20).eut(TierEU.RECIPE_HV)
                .addTo(mixerRecipes);
        // EV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 3L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uraniumtriplatinid, 4L))
                .duration(10 * 20).eut(TierEU.RECIPE_EV).addTo(mixerRecipes);
        // IV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 3L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Vanadiumtriindinid, 4L))
                .duration(10 * 20).eut(TierEU.RECIPE_IV).addTo(mixerRecipes);
        // LuV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 2L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Barium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 7L),
                        GTUtility.getIntegratedCircuit(3))
                .itemOutputs(
                        GTOreDictUnificator.get(
                                OrePrefixes.dust,
                                Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                                30L))
                .fluidInputs(Materials.Oxygen.getGas(14000)).duration(10 * 20).eut(TierEU.RECIPE_LuV)
                .addTo(mixerRecipes);
        // ZPM Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Palladium, 6L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 13L))
                .duration(10 * 20).eut(TierEU.RECIPE_ZPM).addTo(mixerRecipes);
        // UV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadria, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmiridium, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Europium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Samarium, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuvwire, 9L))
                .duration(10 * 20).eut(TierEU.RECIPE_UV).addTo(mixerRecipes);
        // UHV Superconductor Recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 6L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CosmicNeutronium, 7L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tritanium, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Americium, 6L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuhvwire, 24L))
                .duration(10 * 20).eut(TierEU.RECIPE_UHV).addTo(mixerRecipes);
        // UEV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.DraconiumAwakened, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Infinity, 5L),
                        MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN.getDust(1),
                        MaterialsElements.STANDALONE.ADVANCED_NITINOL.getDust(1),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SuperconductorUEVBase, 12L))
                .fluidInputs(Materials.Iron.getPlasma(144L)).duration(10 * 20).eut(TierEU.RECIPE_UEV)
                .addTo(mixerRecipes);
        // UIV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.RadoxPolymer, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, MaterialsUEVplus.TranscendentMetal, 10L),
                        MaterialsElements.STANDALONE.RHUGNOR.getDust(6),
                        CHRONOMATIC_GLASS.getDust(5),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SuperconductorUIVBase, 25L))
                .fluidInputs(Materials.Bismuth.getPlasma(144L)).duration(10 * 20).eut(TierEU.RECIPE_UIV)
                .addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ardite, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 2L)).duration(20 * SECONDS)
                .eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 3L),
                        ItemList.IC2_Resin.get(1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(CustomItemList.MicaBasedPulp.get(4L)).duration(20 * SECONDS).eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.RawRubber, 2L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(CustomItemList.MicaBasedPulp.get(4L)).duration(20 * SECONDS).eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 2L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(
                        GTOreDictUnificator.getDust(Materials.NaquadahAlloy, 4L * OrePrefixes.dust.mMaterialAmount))
                .duration((int) (400L * OrePrefixes.dust.mMaterialAmount / 3628800L)).eut(TierEU.RECIPE_IV)
                .addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Barium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.AnyCopper, 3L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(
                        GTOreDictUnificator
                                .getDust(Materials.YttriumBariumCuprate, 13L * OrePrefixes.dust.mMaterialAmount))
                .fluidInputs(Materials.Oxygen.getGas(7000))
                .duration((int) (600L * OrePrefixes.dust.mMaterialAmount / 3628800L)).eut(TierEU.RECIPE_EV)
                .addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 6L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.AnyCopper, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1L),
                        GTUtility.getIntegratedCircuit(3))
                .itemOutputs(GTOreDictUnificator.getDust(Materials.Duralumin, 9L * OrePrefixes.dust.mMaterialAmount))
                .duration((int) (900L * OrePrefixes.dust.mMaterialAmount / 3628800L)).eut(TierEU.RECIPE_EV)
                .addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 2L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 2L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Alumite, 9)).duration(10 * SECONDS)
                .eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.IC2_Energium_Dust.get(9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 6L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(CustomItemList.LapotronDust.get(15L)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Flint, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 4L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 4L)).duration(10 * SECONDS)
                .eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 16L),
                        GTUtility.getIntegratedCircuit(4))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 16L)).duration(40 * SECONDS)
                .eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Flint, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 4L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 5L)).duration(8 * SECONDS)
                .eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 16L),
                        GTUtility.getIntegratedCircuit(4))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 20L)).duration(32 * SECONDS)
                .eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 7L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumSteel, 9L))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 4L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.RoseGold, 5L)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 6L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 9L))
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.RoseGold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.InfusedGold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.AstralSilver, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SterlingSilver, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SolderingAlloy, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.RedSteel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlueSteel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L),
                        GTUtility.getIntegratedCircuit(4))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.ElectrumFlux, 4L))
                .duration(2 * SECONDS + 10 * TICKS).eut(900).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 6L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Molybdenum, 1L),
                        GTUtility.getIntegratedCircuit(18))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.DamascusSteel, 18L))
                .duration(11 * SECONDS + 5 * TICKS).eut(900).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 1L),
                        GTUtility.getIntegratedCircuit(9))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.DamascusSteel, 18L))
                .duration(11 * SECONDS + 5 * TICKS).eut(900).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 2L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .fluidInputs(Materials.Water.getFluid(2000L)).fluidOutputs(Materials.Concrete.getMolten(2304L))
                .duration(5 * SECONDS).eut(16).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Clay, 8L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(new ItemStack(Items.clay_ball, 4, 0)).fluidInputs(GTModHandler.getWater(1000L))
                .duration(5 * SECONDS).eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 4L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.RedAlloy, 1L)).duration(5 * SECONDS)
                .eut(16).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 2L),
                        new ItemStack(Blocks.sand, 4, 0))
                .itemOutputs(ItemList.IC2_Fertilizer.get(4)).fluidInputs(Materials.Water.getFluid(1000L))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Antimony, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.BatteryAlloy, 5L))
                .duration(5 * SECONDS).eut(4).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Antimony, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SolderingAlloy, 10L))
                .duration(5 * SECONDS).eut(8).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 2L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Magnalium, 3L)).duration(5 * SECONDS)
                .eut(4).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Neutronium, 16L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.RawNeutronium.get(16L)).fluidInputs(Materials.Helium.getPlasma(2304L))
                .duration(3 * MINUTES).eut(TierEU.RECIPE_ZPM).addTo(mixerRecipes);

        // One Step Alloy Dust Mixer

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 3L),
                        GTUtility.getIntegratedCircuit(15))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 9L))
                .duration(6 * SECONDS).eut(TierEU.RECIPE_MV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 9L),
                        GTUtility.getIntegratedCircuit(17))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 27L))
                .duration(12 * SECONDS).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 12L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 9L),
                        GTUtility.getIntegratedCircuit(16))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 27L))
                .duration(12 * SECONDS).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 12L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 27L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 27L),
                        GTUtility.getIntegratedCircuit(18))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.VividAlloy, 64L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.VividAlloy, 17L))
                .duration(24 * SECONDS).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 27L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 27L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 9L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 64L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 17L))
                .duration(24 * SECONDS).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 3L),
                        GTUtility.getIntegratedCircuit(14))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 9L)).duration(6 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Endstone, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 9L),
                        GTUtility.getIntegratedCircuit(16))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 27L)).duration(12 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Endstone, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 27L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Oriharukon, 27L),
                        GTUtility.getIntegratedCircuit(18))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 64L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 17L))
                .duration(24 * SECONDS).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTModHandler.getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 16L, 0),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 2L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.BioBall.get(1L)).duration(10 * SECONDS).eut(16).addTo(mixerRecipes);

        // Stargate-Crystal Dust
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.StableAdhesive.get(64),
                        ItemList.SuperconductorComposite.get(64),
                        ItemList.NaquadriaSupersolid.get(64),
                        ItemList.Timepiece.get(64),
                        GTUtility.copyAmount(64, Particle.getBaseParticle(Particle.Z_BOSON)),
                        GTUtility.copyAmount(64, Particle.getBaseParticle(Particle.ETA_MESON)),
                        GTUtility.copyAmount(64, Particle.getBaseParticle(Particle.LAMBDA)),
                        GTUtility.copyAmount(64, Particle.getBaseParticle(Particle.OMEGA)),
                        GTOreDictUnificator.get(OrePrefixes.gem, MaterialsUEVplus.GravitonShard, 4))
                .fluidInputs(Materials.Grade8PurifiedWater.getFluid(1_000_000_000L))
                .itemOutputs(com.dreammaster.item.ItemList.StargateCrystalDust.getIS()).duration(3 * MINUTES)
                .eut(TierEU.RECIPE_UXV).addTo(mixerRecipes);

        // Legacy Stargate Crystal Dust
        GTValues.RA.stdBuilder()
                .itemInputs(
                        com.dreammaster.item.ItemList.TCetiESeaweedExtract.getIS().splitStack(64),
                        Materials.Dolomite.getDust(64),
                        Materials.SamariumMagnetic.getDust(21),
                        Materials.ChromiumDioxide.getDust(64),
                        GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Jasper, 54L),
                        GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Opal, 47L))
                .itemOutputs(com.dreammaster.item.ItemList.StargateDustAncients.getIS()).duration(3 * MINUTES)
                .eut(262144).addTo(mixerRecipes);

        // Astral Silver & Soldering Alloy + reverse

        GTValues.RA.stdBuilder()
                .itemInputs(
                        Materials.Silver.getDust(2),
                        Materials.Thaumium.getDust(1),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(Materials.AstralSilver.getDust(3)).duration(3 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(mixerRecipes);

        if (PamsHarvestCraft.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(PamsHarvestCraft.ID, "soybeanItem", 1, 0))
                    .itemOutputs(CustomItemList.WetTofu.get(1L)).fluidInputs(Materials.Water.getFluid(100L))
                    .duration(30 * SECONDS).eut(2).addTo(mixerRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(PamsHarvestCraft.ID, "soybeanItem", 1, 0))
                    .itemOutputs(CustomItemList.WetTofu.get(1L)).fluidInputs(GTModHandler.getDistilledWater(50L))
                    .duration(20 * SECONDS).eut(2).addTo(mixerRecipes);
        }

        if (OpenComputers.isModLoaded()) {
            // Chamelium
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 4L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 4L),
                            GTUtility.getIntegratedCircuit(2))
                    .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 9L, 96))
                    .fluidInputs(Materials.Water.getFluid(1000L)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(mixerRecipes);
        }

        if (BiomesOPlenty.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.dirt, 1, 0), GTUtility.getIntegratedCircuit(4))
                    .itemOutputs(GTModHandler.getModItem(BiomesOPlenty.ID, "mudball", 4L, 0))
                    .fluidInputs(Materials.Water.getFluid(1000L)).duration(2 * SECONDS + 10 * TICKS).eut(8)
                    .addTo(mixerRecipes);

        }

        if (EnderIO.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(EnderIO.ID, "itemMaterial", 1L, 14),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Emerald, 1L),
                            GTUtility.getIntegratedCircuit(2))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.CrystallineAlloy, 3L))
                    .duration(5 * SECONDS).eut(8).addTo(mixerRecipes);

        }

        if (ExtraTrees.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(ExtraTrees.ID, "misc", 4L, 2),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(ItemList.FR_Mulch.get(1L)).fluidInputs(Materials.Water.getFluid(500L))
                    .duration(30 * SECONDS).eut(2).addTo(mixerRecipes);

        }

        if (TinkerConstruct.isModLoaded() && Natura.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 3L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
                            GTUtility.getIntegratedCircuit(2))
                    .itemOutputs(GTModHandler.getModItem(TinkerConstruct.ID, "materials", 4L, 42))
                    .duration(10 * SECONDS).eut(8).addTo(mixerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(TinkerConstruct.ID, "slime.gel", 1L, 2),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.CrystallineAlloy, 1L),
                            GTUtility.getIntegratedCircuit(2))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.CrystallinePinkSlime, 3L))
                    .duration(5 * SECONDS).eut(8).addTo(mixerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Blocks.sand, 3, 0),
                            new ItemStack(Blocks.gravel, 3, 0),
                            new ItemStack(Blocks.clay, 2, 0))
                    .itemOutputs(GTModHandler.getModItem(TinkerConstruct.ID, "CraftedSoil", 8L, 1))
                    .fluidInputs(Materials.Water.getFluid(2000L)).duration(10 * SECONDS).eut(16).addTo(mixerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Blocks.sand, 3, 1),
                            new ItemStack(Blocks.gravel, 3, 0),
                            new ItemStack(Blocks.clay, 2, 0))
                    .itemOutputs(GTModHandler.getModItem(TinkerConstruct.ID, "CraftedSoil", 8L, 1))
                    .fluidInputs(Materials.Water.getFluid(2000L)).duration(10 * SECONDS).eut(16).addTo(mixerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Items.nether_wart, 1, 0),
                            new ItemStack(Blocks.soul_sand, 1, 0),
                            new ItemStack(Blocks.gravel, 1, 0),
                            GTModHandler.getModItem(Natura.ID, "soil.tainted", 1L, 0),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(GTModHandler.getModItem(TinkerConstruct.ID, "CraftedSoil", 2L, 6))
                    .fluidInputs(Materials.Water.getFluid(2000L)).duration(10 * SECONDS).eut(16).addTo(mixerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Items.nether_wart, 1, 0),
                            new ItemStack(Blocks.soul_sand, 1, 0),
                            new ItemStack(Blocks.gravel, 1, 0),
                            new ItemStack(Blocks.sand, 1, 32767),
                            GTUtility.getIntegratedCircuit(2))
                    .itemOutputs(GTModHandler.getModItem(TinkerConstruct.ID, "CraftedSoil", 2L, 6))
                    .fluidInputs(Materials.Water.getFluid(2000L)).duration(10 * SECONDS).eut(16).addTo(mixerRecipes);

        }

        if (Witchery.isModLoaded() && Genetics.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Items.sugar, 1, 0),
                            new ItemStack(Items.bone, 1, 0),
                            ItemList.FR_Mulch.get(1L),
                            GTModHandler.getModItem(Witchery.ID, "ingredient", 1L, 18),
                            GTUtility.getIntegratedCircuit(2))
                    .itemOutputs(GTModHandler.getModItem(Genetics.ID, "misc", 1L, 4))
                    .fluidInputs(Materials.Water.getFluid(1000L)).duration(20 * SECONDS).eut(16).addTo(mixerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Items.sugar, 1, 0),
                            new ItemStack(Items.bone, 1, 0),
                            ItemList.FR_Mulch.get(1L),
                            GTModHandler.getModItem(Witchery.ID, "ingredient", 1L, 18),
                            GTUtility.getIntegratedCircuit(3))
                    .itemOutputs(GTModHandler.getModItem(Genetics.ID, "misc", 1L, 4))
                    .fluidInputs(GTModHandler.getDistilledWater(800L)).duration(20 * SECONDS).eut(16)
                    .addTo(mixerRecipes);

        }

        if (Thaumcraft.isModLoaded() && DraconicEvolution.isModLoaded() && Witchery.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L),
                            GTModHandler.getModItem(Thaumcraft.ID, "ItemResource", 1L, 14),
                            new ItemStack(Items.sugar, 1, 0),
                            GTModHandler.getModItem(DraconicEvolution.ID, "draconiumDust", 1L, 0),
                            GTUtility.getIntegratedCircuit(2))
                    .itemOutputs(CustomItemList.MalformedSlush.get(2L))
                    .fluidInputs(FluidRegistry.getFluidStack("witchery:fluidspirit", 1000)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_IV).addTo(mixerRecipes);

        }

        if (AppliedEnergistics2.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartzCharged, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L),
                            GTUtility.getIntegratedCircuit(4))
                    .itemOutputs(GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2L, 8))
                    .fluidInputs(Materials.Water.getFluid(500L)).duration(20 * TICKS).eut(16).addTo(mixerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartzCharged, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L),
                            GTUtility.getIntegratedCircuit(4))
                    .itemOutputs(GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2L, 8))
                    .fluidInputs(GTModHandler.getDistilledWater(500L)).duration(20 * TICKS).eut(16).addTo(mixerRecipes);

        }

        if (Chisel.isModLoaded()) {
            for (int meta = 0; meta < 16; ++meta) {
                GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(Chisel.ID, "hempcretesand", 1L, meta))
                        .fluidInputs(Materials.Water.getFluid(100L))
                        .itemOutputs(GTModHandler.getModItem(Chisel.ID, "hempcrete", 1L, meta)).duration(5 * SECONDS)
                        .eut(TierEU.RECIPE_LV).addTo(mixerRecipes);
            }
        }

        if (UniversalSingularities.isModLoaded() && Avaritia.isModLoaded()) {
            // Star Fuel
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.Neutronium, 64),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 64L),
                            // Diamond Singularity
                            getModItem(UniversalSingularities.ID, "universal.vanilla.singularity", 1L, 2))
                    .itemOutputs(GTModHandler.getModItem(Avaritia.ID, "Resource", 1L, 8))
                    .fluidInputs(
                            GGMaterial.naquadahBasedFuelMkV.getFluidOrGas(1000),
                            MaterialsUEVplus.ExcitedDTEC.getFluid(128000))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_UIV).addTo(mixerNonCellRecipes);
        }
        if (EnderIO.isModLoaded() && BiomesOPlenty.isModLoaded() && Witchery.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            kubatech.api.enums.ItemList.EarlGrayTea.get(1),
                            kubatech.api.enums.ItemList.LemonTea.get(1),
                            kubatech.api.enums.ItemList.MilkTea.get(1),
                            kubatech.api.enums.ItemList.PeppermintTea.get(1),
                            GTModHandler.getModItem(EnderIO.ID, "bucketVapor_of_levity", 1L),
                            ItemList.ThermosCan_Ice_Tea.get(1L),
                            GTModHandler.getModItem(BiomesOPlenty.ID, "food", 1L, 10),
                            GTModHandler.getModItem(Witchery.ID, "potion", 1L),
                            GTModHandler.getModItem(Witchery.ID, "ingredient", 1L, 40))
                    .itemOutputs(
                            new ItemStack(Items.glass_bottle, 2, 0),
                            new ItemStack(Items.bucket, 1, 0),
                            ItemList.ThermosCan_Empty.get(1L))
                    .fluidInputs(
                            FluidRegistry.getFluidStack("potion.diablosauce", 7500),
                            FluidRegistry.getFluidStack("potion.piratebrew", 2500),
                            FluidRegistry.getFluidStack("potion.jagi", 2500),
                            FluidRegistry.getFluidStack("potion.alcopops", 2500),
                            FluidRegistry.getFluidStack("potion.goldencider", 2500),
                            FluidRegistry.getFluidStack("potion.chocolatemilk", 7500))
                    .fluidOutputs(
                            FluidRegistry.getFluidStack("potion.diablosauce.strong", 12000),
                            FluidRegistry.getFluidStack("potion.mundane", 22000))
                    .duration(200 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(mixerNonCellRecipes);
        }
    }
}
