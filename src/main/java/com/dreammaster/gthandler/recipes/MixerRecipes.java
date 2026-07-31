package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.Chisel;
import static gregtech.api.enums.Mods.CropsNH;
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
import static gregtech.api.util.GTRecipeBuilder.INGOTS;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gtPlusPlus.api.recipe.GTPPRecipeMaps.mixerNonCellRecipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.FluidShapes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.material.MaterialUtils;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gtPlusPlus.core.fluids.GTPPFluids;
import gtPlusPlus.core.material.Particle;

public class MixerRecipes implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.CallistoIce, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Ledox, Shapes.dust, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Ice, Shapes.dust, (int) (2L)))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(Materials.SuperCoolant, FluidShapes.fluidLiquid, (int) (2000)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Bauxite, Shapes.dust, (int) (4L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 12L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (16L)))
                .duration(1 * SECONDS + 5 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Bauxite, Shapes.dustImpure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(18 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Bauxite, Shapes.dustPure, (int) (2L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 6L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (8L)))
                .duration(1 * SECONDS + 5 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.dustImpure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(15 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.dustPure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(10 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Sodalite, Shapes.dust, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 13 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Sodalite, Shapes.dustImpure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Sodalite, Shapes.dustPure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(3 * SECONDS + 6 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Alunite, Shapes.dust, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 13 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Alunite, Shapes.dustImpure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Alunite, Shapes.dustPure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(3 * SECONDS + 6 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Lepidolite, Shapes.dust, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 5 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Lepidolite, Shapes.dustImpure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(3 * SECONDS + 15 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Lepidolite, Shapes.dustPure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(2 * SECONDS + 10 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Mica, Shapes.dust, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 13 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Mica, Shapes.dustImpure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Mica, Shapes.dustPure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(3 * SECONDS + 6 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Tanzanite, Shapes.dust, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 13 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Tanzanite, Shapes.dustImpure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Tanzanite, Shapes.dustPure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(3 * SECONDS + 6 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Biotite, Shapes.dust, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 13 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Lazurite, Shapes.dust, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 13 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Lazurite, Shapes.dustImpure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Lazurite, Shapes.dustPure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(3 * SECONDS + 6 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Glauconite, Shapes.dust, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 5 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Glauconite, Shapes.dustImpure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(3 * SECONDS + 15 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Glauconite, Shapes.dustPure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(2 * SECONDS + 10 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.GlauconiteSand, Shapes.dust, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 5 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.GlauconiteSand, Shapes.dustImpure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(3 * SECONDS + 15 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.GlauconiteSand, Shapes.dustPure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(2 * SECONDS + 10 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Vermiculite, Shapes.dust, (int) (1)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 5 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Vermiculite, Shapes.dustImpure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(3 * SECONDS + 15 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Vermiculite, Shapes.dustPure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(2 * SECONDS + 10 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Zeolite, Shapes.dust, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(10 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Zeolite, Shapes.dustImpure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 10 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Zeolite, Shapes.dustPure, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3L))
                .circuit(5).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Clay, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Flint, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Stone, Shapes.dust, (int) (1L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.CrudeSteel, Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Redstone, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Silicon, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Coal, Shapes.dust, (int) (1L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.RedstoneAlloy, Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.RedstoneAlloy, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Silver, Shapes.dust, (int) (1L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.ConductiveIron, Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.ConductiveIron, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.BlackSteel, Shapes.dust, (int) (1L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.ConductiveIron, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Silver, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.BlackSteel, Shapes.dust, (int) (1L)))
                .circuit(3).itemOutputs(MaterialLibAPI.getStack(Materials.EnergeticSilver, Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.EnderEye, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.dust, (int) (1L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.VibrantAlloy, Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.EnergeticSilver, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.EnderEye, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.dust, (int) (1L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.VividAlloy, Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.EndSteel, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.EnderEye, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Oriharukon, Shapes.dust, (int) (1L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.MelodicAlloy, Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.MelodicAlloy, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.NetherStar, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.dust, (int) (1L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.StellarAlloy, Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Coal, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Silicon, Shapes.dust, (int) (1L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.ElectricalSteel, Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.EnderPearl, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.RedstoneAlloy, Shapes.dust, (int) (1L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.PulsatingIron, Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.soul_sand, 1, 0),
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Ash, Shapes.dust, (int) (1L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.Soularium, Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.ElectricalSteel, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Coal, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Obsidian, Shapes.dust, (int) (1L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Endstone, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Tungsten, Shapes.dust, (int) (1L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.EndSteel, Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Silver, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Platinum, Shapes.dust, (int) (1L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.EnderiumBase, Shapes.dust, (int) (4L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.EnderiumBase, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Thaumium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.EnderPearl, Shapes.dust, (int) (1L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.Enderium, Shapes.dust, (int) (4L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        // Superconductor dust recipes in mixer.

        // MV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Cadmium, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.Magnesium, Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Pentacadmiummagnesiumhexaoxid, Shapes.dust, (int) (12L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (6000)))
                .duration(10 * 20).eut(TierEU.RECIPE_MV).addTo(mixerRecipes);
        // HV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Barium, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.dust, (int) (10L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials.Titaniumonabariumdecacoppereikosaoxid, Shapes.dust, (int) (40L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (20000)))
                .duration(10 * 20).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);
        // EV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Uranium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Platinum, Shapes.dust, (int) (3L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.Uraniumtriplatinid, Shapes.dust, (int) (4L)))
                .duration(10 * 20).eut(TierEU.RECIPE_EV).addTo(mixerRecipes);
        // IV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Vanadium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Indium, Shapes.dust, (int) (3L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.Vanadiumtriindinid, Shapes.dust, (int) (4L)))
                .duration(10 * 20).eut(TierEU.RECIPE_IV).addTo(mixerRecipes);
        // LuV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Indium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Barium, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.dust, (int) (7L)))
                .circuit(3)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                                Shapes.dust,
                                (int) (30L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (14000)))
                .duration(10 * 20).eut(TierEU.RECIPE_LuV).addTo(mixerRecipes);
        // ZPM Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Indium, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Palladium, Shapes.dust, (int) (6L)),
                        MaterialLibAPI.getStack(Materials.Osmium, Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials.Tetranaquadahdiindiumhexaplatiumosminid, Shapes.dust, (int) (13L)))
                .duration(10 * 20).eut(TierEU.RECIPE_ZPM).addTo(mixerRecipes);
        // UV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Naquadria, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Osmiridium, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Europium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Samarium, Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Longasssuperconductornameforuvwire, Shapes.dust, (int) (9L)))
                .duration(10 * 20).eut(TierEU.RECIPE_UV).addTo(mixerRecipes);
        // UHV Superconductor Recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Draconium, Shapes.dust, (int) (6L)),
                        MaterialLibAPI.getStack(Materials.CosmicNeutronium, Shapes.dust, (int) (7L)),
                        MaterialLibAPI.getStack(Materials.Tritanium, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.Americium, Shapes.dust, (int) (6L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials.Longasssuperconductornameforuhvwire, Shapes.dust, (int) (24L)))
                .duration(10 * 20).eut(TierEU.RECIPE_UHV).addTo(mixerRecipes);
        // UEV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.DraconiumAwakened, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.Infinity, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.CelestialTungsten, Shapes.dust, (int) (1)),
                        MaterialLibAPI.getStack(Materials.AdvancedNitinol, Shapes.dust, (int) (1)))
                .circuit(2)
                .itemOutputs(MaterialLibAPI.getStack(Materials.SuperconductorUEVBase, Shapes.dust, (int) (12L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Iron, FluidShapes.fluidPlasma, (int) (144L)))
                .duration(10 * 20).eut(TierEU.RECIPE_UEV).addTo(mixerRecipes);
        // UIV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.RadoxPoly, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.TranscendentMetal, Shapes.dust, (int) (10L)),
                        MaterialLibAPI.getStack(Materials.Rhugnor, Shapes.dust, (int) (6)),
                        MaterialLibAPI.getStack(Materials.ChromaticGlass, Shapes.dust, (int) (5)))
                .circuit(2)
                .itemOutputs(MaterialLibAPI.getStack(Materials.SuperconductorUIVBase, Shapes.dust, (int) (25L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Bismuth, FluidShapes.fluidPlasma, (int) (144L)))
                .duration(10 * 20).eut(TierEU.RECIPE_UIV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Cobalt, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Ardite, Shapes.dust, (int) (1L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.Manyullyn, Shapes.dust, (int) (2L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Mica, Shapes.dust, (int) (3L)),
                        ItemList.IC2_Resin.get(1L))
                .circuit(2).itemOutputs(NHItemList.MicaBasedPulp.get(4)).duration(20 * SECONDS).eut(TierEU.RECIPE_ULV)
                .addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Mica, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.RawRubber, Shapes.dust, (int) (2L)))
                .circuit(2).itemOutputs(NHItemList.MicaBasedPulp.get(4)).duration(20 * SECONDS).eut(TierEU.RECIPE_ULV)
                .addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Trinium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(
                        GTOreDictUnificator.getDust(Materials.NaquadahAlloy, 4L * OrePrefixes.dust.getMaterialAmount()))
                .duration((int) (400L * OrePrefixes.dust.getMaterialAmount() / 3628800L)).eut(TierEU.RECIPE_IV)
                .addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Yttrium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Barium, Shapes.dust, (int) (2L)),
                        GTOreDictUnificator.get("dustAnyCopper", 3L))
                .circuit(2)
                .itemOutputs(
                        GTOreDictUnificator
                                .getDust(Materials.YttriumBariumCuprate, 13L * OrePrefixes.dust.getMaterialAmount()))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (7000)))
                .duration((int) (600L * OrePrefixes.dust.getMaterialAmount() / 3628800L)).eut(TierEU.RECIPE_EV)
                .addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.dust, (int) (6L)),
                        GTOreDictUnificator.get("dustAnyCopper", 1L),
                        MaterialLibAPI.getStack(Materials.Manganese, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Magnesium, Shapes.dust, (int) (1L)))
                .circuit(3)
                .itemOutputs(
                        GTOreDictUnificator.getDust(Materials.Duralumin, 9L * OrePrefixes.dust.getMaterialAmount()))
                .duration((int) (900L * OrePrefixes.dust.getMaterialAmount() / 3628800L)).eut(TierEU.RECIPE_EV)
                .addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Zinc, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.Obsidian, Shapes.dust, (int) (2L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.Alumite, Shapes.dust, (int) (5)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.IC2_Energium_Dust.get(9L),
                        MaterialLibAPI.getStack(Materials.Lapis, Shapes.dust, (int) (6L)))
                .circuit(2).itemOutputs(NHItemList.LapotronDust.get(15)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Flint, Shapes.dustSmall, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.QuartzSand, Shapes.dust, (int) (4L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.Glass, Shapes.dust, (int) (4L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Flint, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.QuartzSand, Shapes.dust, (int) (16L)))
                .circuit(4).itemOutputs(MaterialLibAPI.getStack(Materials.Glass, Shapes.dust, (int) (16L)))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Flint, Shapes.dustSmall, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Quartzite, Shapes.dust, (int) (4L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.Glass, Shapes.dust, (int) (5L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Flint, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Quartzite, Shapes.dust, (int) (16L)))
                .circuit(4).itemOutputs(MaterialLibAPI.getStack(Materials.Glass, Shapes.dust, (int) (20L)))
                .duration(32 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Vanadium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.dust, (int) (7L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.VanadiumSteel, Shapes.dust, (int) (9L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.dust, (int) (4L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.RoseGold, Shapes.dust, (int) (5L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (6L)),
                        MaterialLibAPI.getStack(Materials.Nickel, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Manganese, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.dust, (int) (1L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.dust, (int) (9L)))
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.RoseGold, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.InfusedGold, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.AstralSilver, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.SterlingSilver, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.SolderingAlloy, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.RedSteel, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.BlueSteel, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.dust, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.Redstone, FluidShapes.fluidMolten, (int) (20 * INGOTS)))
                .circuit(4).itemOutputs(MaterialLibAPI.getStack(Materials.ElectrumFlux, Shapes.dust, (int) (4L)))
                .duration(2 * SECONDS + 10 * TICKS).eut(900).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Nickel, Shapes.dust, (int) (6L)),
                        MaterialLibAPI.getStack(Materials.Coal, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Silicon, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Manganese, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Molybdenum, Shapes.dust, (int) (1L)))
                .circuit(18).itemOutputs(MaterialLibAPI.getStack(Materials.DamascusSteel, Shapes.dust, (int) (18L)))
                .duration(11 * SECONDS + 5 * TICKS).eut(900).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Manganese, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Coal, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Silicon, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Vanadium, Shapes.dust, (int) (1L)))
                .circuit(9).itemOutputs(MaterialLibAPI.getStack(Materials.DamascusSteel, Shapes.dust, (int) (18L)))
                .duration(11 * SECONDS + 5 * TICKS).eut(900).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Calcite, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Stone, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Clay, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.QuartzSand, Shapes.dust, (int) (1L)))
                .circuit(2).fluidInputs(MaterialUtils.fluid(Materials.Water, 2000L))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Concrete, FluidShapes.fluidMolten, (int) (2304L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(mixerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Clay, Shapes.dustSmall, (int) (2L)))
                .circuit(2).itemOutputs(new ItemStack(Items.clay_ball, 1, 0))
                .fluidInputs(MaterialUtils.fluid(Materials.Water, 250L)).duration(1 * SECONDS + 5 * TICKS)
                .eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Redstone, Shapes.dust, (int) (4L)))
                .circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.dust, (int) (1L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Lead, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Antimony, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.BatteryAlloy, Shapes.dust, (int) (5L)))
                .duration(5 * SECONDS).eut(4).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Antimony, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.SolderingAlloy, Shapes.dust, (int) (10L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Magnesium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.dust, (int) (2L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.Magnalium, Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(4).addTo(mixerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Neutronium, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(NHItemList.RawNeutronium.get())
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Helium, FluidShapes.fluidPlasma, (int) (144L)))
                .duration(11 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_ZPM).addTo(mixerRecipes);

        // One Step Alloy Dust Mixer

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Redstone, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Silicon, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Coal, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Silver, Shapes.dust, (int) (3L)))
                .circuit(15).itemOutputs(MaterialLibAPI.getStack(Materials.ConductiveIron, Shapes.dust, (int) (9L)))
                .duration(6 * SECONDS).eut(TierEU.RECIPE_MV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Redstone, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Silicon, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Coal, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Silver, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.BlackSteel, Shapes.dust, (int) (9L)))
                .circuit(17).itemOutputs(MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.dust, (int) (27L)))
                .duration(12 * SECONDS).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Redstone, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Silicon, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Coal, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Silver, Shapes.dust, (int) (12L)),
                        MaterialLibAPI.getStack(Materials.BlackSteel, Shapes.dust, (int) (9L)))
                .circuit(16).itemOutputs(MaterialLibAPI.getStack(Materials.EnergeticSilver, Shapes.dust, (int) (27L)))
                .duration(12 * SECONDS).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Redstone, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Silicon, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Coal, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Silver, Shapes.dust, (int) (12L)),
                        MaterialLibAPI.getStack(Materials.BlackSteel, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.EnderEye, Shapes.dust, (int) (27L)),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.dust, (int) (27L)))
                .circuit(18)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.VividAlloy, Shapes.dust, (int) (64L)),
                        MaterialLibAPI.getStack(Materials.VividAlloy, Shapes.dust, (int) (17L)))
                .duration(24 * SECONDS).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Redstone, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Silicon, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Coal, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Silver, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.BlackSteel, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.EnderEye, Shapes.dust, (int) (27L)),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.dust, (int) (27L)),
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.dust, (int) (9L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.VibrantAlloy, Shapes.dust, (int) (64L)),
                        MaterialLibAPI.getStack(Materials.VibrantAlloy, Shapes.dust, (int) (17L)))
                .duration(24 * SECONDS).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Coal, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Silicon, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Obsidian, Shapes.dust, (int) (3L)))
                .circuit(14).itemOutputs(MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.dust, (int) (9L)))
                .duration(6 * SECONDS).eut(TierEU.RECIPE_MV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Coal, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Silicon, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Obsidian, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Endstone, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Tungsten, Shapes.dust, (int) (9L)))
                .circuit(16).itemOutputs(MaterialLibAPI.getStack(Materials.EndSteel, Shapes.dust, (int) (27L)))
                .duration(12 * SECONDS).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Coal, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Silicon, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Obsidian, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Endstone, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.Tungsten, Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials.EnderEye, Shapes.dust, (int) (27L)),
                        MaterialLibAPI.getStack(Materials.Oriharukon, Shapes.dust, (int) (27L)))
                .circuit(18)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.MelodicAlloy, Shapes.dust, (int) (64L)),
                        MaterialLibAPI.getStack(Materials.MelodicAlloy, Shapes.dust, (int) (17L)))
                .duration(24 * SECONDS).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 16, 0),
                        MaterialLibAPI.getStack(Materials.Flint, Shapes.dust, (int) (2L)))
                .circuit(1).itemOutputs(NHItemList.BioBall.get()).duration(10 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(mixerRecipes);

        // TODO: remove for 2.10
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
                        MaterialLibAPI.getStack(Materials.GravitonShard, Shapes.gem, (int) (4)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.Grade8PurifiedWater,
                                FluidShapes.fluidLiquid,
                                (int) (1_000_000_000L)))
                .itemOutputs(NHItemList.StargateCrystalDust.get()).duration(3 * MINUTES).eut(TierEU.RECIPE_UXV)
                .addTo(mixerRecipes);
        // Stargate-Crystal Dust
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.StableAdhesive.get(64),
                        ItemList.SuperconductorComposite.get(64),
                        ItemList.NaquadriaSupersolid.get(64),
                        ItemList.Timepiece.get(64),
                        ItemList.StableBaryonContainmentUnit.get(8),
                        ItemList.StableLeptonContainmentUnit.get(8),
                        ItemList.StableMesonContainmentUnit.get(8),
                        ItemList.StableBosonContainmentUnit.get(8),
                        MaterialLibAPI.getStack(Materials.GravitonShard, Shapes.gem, (int) (4)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.Grade8PurifiedWater,
                                FluidShapes.fluidLiquid,
                                (int) (1_000_000_000L)))
                .itemOutputs(NHItemList.StargateCrystalDust.get()).duration(3 * MINUTES).eut(TierEU.RECIPE_UXV)
                .addTo(mixerRecipes);

        // Legacy Stargate Crystal Dust
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.TCetiESeaweedExtract.get().splitStack(64),
                        MaterialLibAPI.getStack(Materials.Dolomite, Shapes.dust, (int) (64)),
                        MaterialLibAPI.getStack(Materials.SamariumMagnetic, Shapes.dust, (int) (21)),
                        MaterialLibAPI.getStack(Materials.ChromiumDioxide, Shapes.dust, (int) (64)),
                        MaterialLibAPI.getStack(Materials.Jasper, Shapes.gemExquisite, (int) (54L)),
                        MaterialLibAPI.getStack(Materials.Opal, Shapes.gemExquisite, (int) (47L)))
                .itemOutputs(NHItemList.StargateDustAncients.get()).duration(3 * MINUTES).eut(262144)
                .addTo(mixerRecipes);

        // Astral Silver & Soldering Alloy + reverse

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Silver, Shapes.dust, (int) (2)),
                        MaterialLibAPI.getStack(Materials.Thaumium, Shapes.dust, (int) (1)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.AstralSilver, Shapes.dust, (int) (3)))
                .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        // Spinmatron Tier2 Fluid
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.CosmicNeutronium, Shapes.dust, (int) (4)),
                        GTOreDictUnificator.get(OrePrefixes.nanite, Materials.Glowstone, 2))
                .fluidInputs(
                        new FluidStack(GTPPFluids.Kerosene, 4000),
                        MaterialLibAPI
                                .getFluidStack(Materials.BrightLumipodExtract, FluidShapes.fluidLiquid, (int) (1000)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.BiocatalyzedPropulsionFluid,
                                FluidShapes.fluidLiquid,
                                (int) (5000)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(mixerNonCellRecipes);

        if (PamsHarvestCraft.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "soybeanItem", 1, 0))
                    .itemOutputs(NHItemList.WetTofu.get()).fluidInputs(MaterialUtils.fluid(Materials.Water, 100L))
                    .duration(30 * SECONDS).eut(2).addTo(mixerRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "soybeanItem", 1, 0))
                    .itemOutputs(NHItemList.WetTofu.get()).fluidInputs(GTModHandler.getDistilledWater(50L))
                    .duration(20 * SECONDS).eut(2).addTo(mixerRecipes);
        }
        if (Botania.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.Terrasteel, Shapes.dust, (int) (1L)),
                            getModItem(Botania.ID, "manaResource", 4, 5))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.GaiaSpirit, Shapes.dust, (int) (1L)))
                    .duration(30 * SECONDS).eut(200).addTo(mixerRecipes);

        }

        if (OpenComputers.isModLoaded()) {
            // Chamelium
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.Redstone, Shapes.dust, (int) (4L)),
                            MaterialLibAPI.getStack(Materials.Coal, Shapes.dust, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.Flint, Shapes.dust, (int) (4L)))
                    .circuit(2).itemOutputs(getModItem(OpenComputers.ID, "item", 9, 96))
                    .fluidInputs(MaterialUtils.fluid(Materials.Water, 1000L)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(mixerRecipes);
        }

        if (BiomesOPlenty.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.dirt, 1, 0)).circuit(4)
                    .itemOutputs(getModItem(BiomesOPlenty.ID, "mudball", 4, 0))
                    .fluidInputs(MaterialUtils.fluid(Materials.Water, 1000L)).duration(2 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        }

        if (EnderIO.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(EnderIO.ID, "itemMaterial", 1, 14),
                            MaterialLibAPI.getStack(Materials.Gold, Shapes.dust, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.Emerald, Shapes.dust, (int) (1L)))
                    .circuit(2)
                    .itemOutputs(MaterialLibAPI.getStack(Materials.CrystallineAlloy, Shapes.dust, (int) (3L)))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        }

        if (ExtraTrees.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "misc", 4, 2)).circuit(1)
                    .itemOutputs(ItemList.FR_Mulch.get(1L)).fluidInputs(MaterialUtils.fluid(Materials.Water, 500L))
                    .duration(30 * SECONDS).eut(2).addTo(mixerRecipes);

        }

        if (TinkerConstruct.isModLoaded() && Natura.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(TinkerConstruct.ID, "slime.gel", 1, 2),
                            MaterialLibAPI.getStack(Materials.Diamond, Shapes.dust, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.CrystallineAlloy, Shapes.dust, (int) (1L)))
                    .circuit(2)
                    .itemOutputs(MaterialLibAPI.getStack(Materials.CrystallinePinkSlime, Shapes.dust, (int) (3L)))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Blocks.sand, 3, 0),
                            new ItemStack(Blocks.gravel, 3, 0),
                            new ItemStack(Blocks.clay, 2, 0))
                    .itemOutputs(getModItem(TinkerConstruct.ID, "CraftedSoil", 8, 1))
                    .fluidInputs(MaterialUtils.fluid(Materials.Water, 2000L)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV / 2).addTo(mixerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Blocks.sand, 3, 1),
                            new ItemStack(Blocks.gravel, 3, 0),
                            new ItemStack(Blocks.clay, 2, 0))
                    .itemOutputs(getModItem(TinkerConstruct.ID, "CraftedSoil", 8, 1))
                    .fluidInputs(MaterialUtils.fluid(Materials.Water, 2000L)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV / 2).addTo(mixerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Items.nether_wart, 1, 0),
                            new ItemStack(Blocks.soul_sand, 1, 0),
                            new ItemStack(Blocks.gravel, 1, 0),
                            getModItem(Natura.ID, "soil.tainted", 1, 0))
                    .circuit(1).itemOutputs(getModItem(TinkerConstruct.ID, "CraftedSoil", 2, 6))
                    .fluidInputs(MaterialUtils.fluid(Materials.Water, 2000L)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV / 2).addTo(mixerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Items.nether_wart, 1, 0),
                            new ItemStack(Blocks.soul_sand, 1, 0),
                            new ItemStack(Blocks.gravel, 1, 0),
                            new ItemStack(Blocks.sand, 1, 32767))
                    .circuit(2).itemOutputs(getModItem(TinkerConstruct.ID, "CraftedSoil", 2, 6))
                    .fluidInputs(MaterialUtils.fluid(Materials.Water, 2000L)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV / 2).addTo(mixerRecipes);

        }

        if (Witchery.isModLoaded() && Genetics.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Items.sugar, 1, 0),
                            new ItemStack(Items.bone, 1, 0),
                            ItemList.FR_Mulch.get(1L),
                            getModItem(Witchery.ID, "ingredient", 1, 18))
                    .circuit(2).itemOutputs(getModItem(Genetics.ID, "misc", 1, 4))
                    .fluidInputs(MaterialUtils.fluid(Materials.Water, 1000L)).duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_LV / 2).addTo(mixerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Items.sugar, 1, 0),
                            new ItemStack(Items.bone, 1, 0),
                            ItemList.FR_Mulch.get(1L),
                            getModItem(Witchery.ID, "ingredient", 1, 18))
                    .circuit(3).itemOutputs(getModItem(Genetics.ID, "misc", 1, 4))
                    .fluidInputs(GTModHandler.getDistilledWater(800L)).duration(20 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                    .addTo(mixerRecipes);

        }

        if (Thaumcraft.isModLoaded() && DraconicEvolution.isModLoaded() && Witchery.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.Wheat, Shapes.dust, (int) (1L)),
                            getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                            new ItemStack(Items.sugar, 1, 0),
                            getModItem(DraconicEvolution.ID, "draconiumDust", 1, 0))
                    .circuit(2).itemOutputs(NHItemList.MalformedSlush.get(2))
                    .fluidInputs(FluidRegistry.getFluidStack("witchery:fluidspirit", 1000)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_IV).addTo(mixerRecipes);

        }

        if (AppliedEnergistics2.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.ChargedCertusQuartz, 1),
                            MaterialLibAPI.getStack(Materials.Redstone, Shapes.dust, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.NetherQuartz, Shapes.dust, (int) (1L)))
                    .circuit(4).itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 8))
                    .fluidInputs(MaterialUtils.fluid(Materials.Water, 500L)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV / 2).addTo(mixerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.ChargedCertusQuartz, 1),
                            MaterialLibAPI.getStack(Materials.Redstone, Shapes.dust, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.NetherQuartz, Shapes.dust, (int) (1L)))
                    .circuit(4).itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 8))
                    .fluidInputs(GTModHandler.getDistilledWater(500L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV / 2)
                    .addTo(mixerRecipes);

        }

        if (Chisel.isModLoaded()) {
            for (int meta = 0; meta < 16; ++meta) {
                GTValues.RA.stdBuilder().itemInputs(getModItem(Chisel.ID, "hempcretesand", 1, meta))
                        .fluidInputs(MaterialUtils.fluid(Materials.Water, 100L))
                        .itemOutputs(getModItem(Chisel.ID, "hempcrete", 1, meta)).duration(5 * SECONDS)
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
                            getModItem(UniversalSingularities.ID, "universal.vanilla.singularity", 1, 2))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 1, 8))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials.NaquadahBasedLiquidFuelMkV,
                                    FluidShapes.fluidLiquid,
                                    (int) (1000)),
                            MaterialLibAPI
                                    .getFluidStack(Materials.ExcitedDTEC, FluidShapes.fluidLiquid, (int) (128000)))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_UIV).addTo(mixerNonCellRecipes);
        }
        if (EnderIO.isModLoaded() && BiomesOPlenty.isModLoaded() && Witchery.isModLoaded() && CropsNH.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            kubatech.api.enums.ItemList.EarlGrayTea.get(1),
                            kubatech.api.enums.ItemList.LemonTea.get(1),
                            kubatech.api.enums.ItemList.MilkTea.get(1),
                            kubatech.api.enums.ItemList.PeppermintTea.get(1),
                            getModItem(EnderIO.ID, "bucketVapor_of_levity", 1),
                            ItemList.ThermosCan_Ice_Tea.get(1L),
                            getModItem(BiomesOPlenty.ID, "food", 1, 10),
                            getModItem(Witchery.ID, "potion", 1),
                            getModItem(Witchery.ID, "ingredient", 1, 40))
                    .itemOutputs(
                            new ItemStack(Items.glass_bottle, 2, 0),
                            new ItemStack(Items.bucket, 1, 0),
                            ItemList.ThermosCan_Empty.get(1L))
                    .fluidInputs(
                            FluidRegistry.getFluidStack("potion.diablosauce", 7500),
                            FluidRegistry.getFluidStack("potion.piratebrew", 2500),
                            FluidRegistry.getFluidStack(CropsNH.ID + ":jagi", 2500),
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
