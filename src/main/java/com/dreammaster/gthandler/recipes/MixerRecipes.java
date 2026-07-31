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
import static gtPlusPlus.core.material.MaterialsElements.STANDALONE.CHRONOMATIC_GLASS;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import goodgenerator.items.GGMaterial;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2FluidShapes;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.material.MU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gtPlusPlus.core.fluids.GTPPFluids;
import gtPlusPlus.core.material.MaterialsElements;
import gtPlusPlus.core.material.Particle;

public class MixerRecipes implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.CallistoIce, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Ledox, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Ice, Materials2Shapes.dust, (int) (2L)))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperCoolant,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (2000)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Bauxite, Materials2Shapes.dust, (int) (4L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 12L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (16L)))
                .duration(1 * SECONDS + 5 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Bauxite, Materials2Shapes.dustImpure, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(18 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Bauxite, Materials2Shapes.dustPure, (int) (2L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 6L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (8L)))
                .duration(1 * SECONDS + 5 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Aluminium, Materials2Shapes.dustImpure, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(15 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Aluminium, Materials2Shapes.dustPure, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(10 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Sodalite, Materials2Shapes.dust, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 13 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Sodalite, Materials2Shapes.dustImpure, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Sodalite, Materials2Shapes.dustPure, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(3 * SECONDS + 6 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Alunite, Materials2Shapes.dust, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 13 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Alunite, Materials2Shapes.dustImpure, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Alunite, Materials2Shapes.dustPure, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(3 * SECONDS + 6 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Lepidolite, Materials2Shapes.dust, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 5 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.Lepidolite, Materials2Shapes.dustImpure, (int) (1L)),
                GTOreDictUnificator.get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(3 * SECONDS + 15 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Lepidolite, Materials2Shapes.dustPure, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(2 * SECONDS + 10 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Mica, Materials2Shapes.dust, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 13 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Mica, Materials2Shapes.dustImpure, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Mica, Materials2Shapes.dustPure, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(3 * SECONDS + 6 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Tanzanite, Materials2Shapes.dust, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 13 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Tanzanite, Materials2Shapes.dustImpure, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Tanzanite, Materials2Shapes.dustPure, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(3 * SECONDS + 6 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Biotite, Materials2Shapes.dust, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 13 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Lazurite, Materials2Shapes.dust, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 13 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Lazurite, Materials2Shapes.dustImpure, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(5 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Lazurite, Materials2Shapes.dustPure, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(3 * SECONDS + 6 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Glauconite, Materials2Shapes.dust, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 5 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.Glauconite, Materials2Shapes.dustImpure, (int) (1L)),
                GTOreDictUnificator.get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(3 * SECONDS + 15 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Glauconite, Materials2Shapes.dustPure, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(2 * SECONDS + 10 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.GlauconiteSand, Materials2Shapes.dust, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 5 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.GlauconiteSand, Materials2Shapes.dustImpure, (int) (1L)),
                GTOreDictUnificator.get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(3 * SECONDS + 15 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.GlauconiteSand, Materials2Shapes.dustPure, (int) (1L)),
                GTOreDictUnificator.get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(2 * SECONDS + 10 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Vermiculite, Materials2Shapes.dust, (int) (1)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 5 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.Vermiculite, Materials2Shapes.dustImpure, (int) (1L)),
                GTOreDictUnificator.get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(3 * SECONDS + 15 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Vermiculite, Materials2Shapes.dustPure, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(2 * SECONDS + 10 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Zeolite, Materials2Shapes.dust, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(10 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Zeolite, Materials2Shapes.dustImpure, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS + 10 * TICKS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Zeolite, Materials2Shapes.dustPure, (int) (1L)),
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.SodiumHydroxideGT5U), 3L))
                .circuit(5)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (4L)))
                .duration(1 * SECONDS).eut(48).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Clay, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Flint, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Stone, Materials2Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.CrudeSteel, Materials2Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Redstone, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Silicon, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Coal, Materials2Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.RedstoneAlloy, Materials2Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.RedstoneAlloy, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Silver, Materials2Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.ConductiveIron, Materials2Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.ConductiveIron, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Gold, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.BlackSteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.EnergeticAlloy, Materials2Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.ConductiveIron, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Silver, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.BlackSteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(3)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.EnergeticSilver, Materials2Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.EnergeticAlloy, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.EnderEye, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Chrome, Materials2Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.VibrantAlloy, Materials2Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.EnergeticSilver, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.EnderEye, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Chrome, Materials2Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.VividAlloy, Materials2Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.EndSteel, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.EnderEye, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Oriharukon, Materials2Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.MelodicAlloy, Materials2Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.MelodicAlloy, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.NetherStar, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Naquadah, Materials2Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.StellarAlloy, Materials2Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Steel, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Coal, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Silicon, Materials2Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.ElectricalSteel, Materials2Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.EnderPearl, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.RedstoneAlloy, Materials2Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.PulsatingIron, Materials2Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.soul_sand, 1, 0),
                        MaterialLibAPI.getStack(Materials2Materials.Gold, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Ash, Materials2Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Soularium, Materials2Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.ElectricalSteel, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Coal, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Obsidian, Materials2Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.DarkSteel, Materials2Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.DarkSteel, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Endstone, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Tungsten, Materials2Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.EndSteel, Materials2Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Tin, Materials2Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials2Materials.Silver, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Platinum, Materials2Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.EnderiumBase, Materials2Shapes.dust, (int) (4L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.EnderiumBase, Materials2Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials2Materials.Thaumium, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.EnderPearl, Materials2Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Enderium, Materials2Shapes.dust, (int) (4L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        // Superconductor dust recipes in mixer.

        // MV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Cadmium, Materials2Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials2Materials.Magnesium, Materials2Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.Pentacadmiummagnesiumhexaoxid,
                                Materials2Shapes.dust,
                                (int) (12L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (6000)))
                .duration(10 * 20).eut(TierEU.RECIPE_MV).addTo(mixerRecipes);
        // HV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Titanium, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Barium, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Copper, Materials2Shapes.dust, (int) (10L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.Titaniumonabariumdecacoppereikosaoxid,
                                Materials2Shapes.dust,
                                (int) (40L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (20000)))
                .duration(10 * 20).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);
        // EV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Uranium, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Platinum, Materials2Shapes.dust, (int) (3L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.Uraniumtriplatinid, Materials2Shapes.dust, (int) (4L)))
                .duration(10 * 20).eut(TierEU.RECIPE_EV).addTo(mixerRecipes);
        // IV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Vanadium, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Indium, Materials2Shapes.dust, (int) (3L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.Vanadiumtriindinid, Materials2Shapes.dust, (int) (4L)))
                .duration(10 * 20).eut(TierEU.RECIPE_IV).addTo(mixerRecipes);
        // LuV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Indium, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Tin, Materials2Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials2Materials.Barium, Materials2Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials2Materials.Titanium, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Copper, Materials2Shapes.dust, (int) (7L)))
                .circuit(3)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                                Materials2Shapes.dust,
                                (int) (30L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (14000)))
                .duration(10 * 20).eut(TierEU.RECIPE_LuV).addTo(mixerRecipes);
        // ZPM Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Naquadah, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Indium, Materials2Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials2Materials.Palladium, Materials2Shapes.dust, (int) (6L)),
                        MaterialLibAPI.getStack(Materials2Materials.Osmium, Materials2Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.Tetranaquadahdiindiumhexaplatiumosminid,
                                Materials2Shapes.dust,
                                (int) (13L)))
                .duration(10 * 20).eut(TierEU.RECIPE_ZPM).addTo(mixerRecipes);
        // UV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Naquadria, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Osmiridium, Materials2Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials2Materials.Europium, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Samarium, Materials2Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.Longasssuperconductornameforuvwire,
                                Materials2Shapes.dust,
                                (int) (9L)))
                .duration(10 * 20).eut(TierEU.RECIPE_UV).addTo(mixerRecipes);
        // UHV Superconductor Recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Draconium, Materials2Shapes.dust, (int) (6L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.CosmicNeutronium, Materials2Shapes.dust, (int) (7L)),
                        MaterialLibAPI.getStack(Materials2Materials.Tritanium, Materials2Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials2Materials.Americium, Materials2Shapes.dust, (int) (6L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.Longasssuperconductornameforuhvwire,
                                Materials2Shapes.dust,
                                (int) (24L)))
                .duration(10 * 20).eut(TierEU.RECIPE_UHV).addTo(mixerRecipes);
        // UEV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.DraconiumAwakened, Materials2Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials2Materials.Infinity, Materials2Shapes.dust, (int) (5L)),
                        MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN.getDust(1),
                        MaterialsElements.STANDALONE.ADVANCED_NITINOL.getDust(1))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.SuperconductorUEVBase,
                                Materials2Shapes.dust,
                                (int) (12L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Iron,
                                Materials2FluidShapes.fluidPlasma,
                                (int) (144L)))
                .duration(10 * 20).eut(TierEU.RECIPE_UEV).addTo(mixerRecipes);
        // UIV Superconductor dust recipe.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.RadoxPoly, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.TranscendentMetal, Materials2Shapes.dust, (int) (10L)),
                        MaterialsElements.STANDALONE.RHUGNOR.getDust(6),
                        CHRONOMATIC_GLASS.getDust(5))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.SuperconductorUIVBase,
                                Materials2Shapes.dust,
                                (int) (25L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Bismuth,
                                Materials2FluidShapes.fluidPlasma,
                                (int) (144L)))
                .duration(10 * 20).eut(TierEU.RECIPE_UIV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Cobalt, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Manyullyn, Materials2Shapes.dust, (int) (2L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Mica, Materials2Shapes.dust, (int) (3L)),
                        ItemList.IC2_Resin.get(1L))
                .circuit(2).itemOutputs(NHItemList.MicaBasedPulp.get(4)).duration(20 * SECONDS).eut(TierEU.RECIPE_ULV)
                .addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Mica, Materials2Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials2Materials.RawRubber, Materials2Shapes.dust, (int) (2L)))
                .circuit(2).itemOutputs(NHItemList.MicaBasedPulp.get(4)).duration(20 * SECONDS).eut(TierEU.RECIPE_ULV)
                .addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Naquadah, Materials2Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials2Materials.Trinium, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Carbon, Materials2Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(
                        GTOreDictUnificator.getDust(
                                MU.materialOf(Materials2Materials.NaquadahAlloy),
                                4L * OrePrefixes.dust.getMaterialAmount()))
                .duration((int) (400L * OrePrefixes.dust.getMaterialAmount() / 3628800L)).eut(TierEU.RECIPE_IV)
                .addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Yttrium, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Barium, Materials2Shapes.dust, (int) (2L)),
                        GTOreDictUnificator.get("dustAnyCopper", 3L))
                .circuit(2)
                .itemOutputs(
                        GTOreDictUnificator.getDust(
                                MU.materialOf(Materials2Materials.YttriumBariumCuprate),
                                13L * OrePrefixes.dust.getMaterialAmount()))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (7000)))
                .duration((int) (600L * OrePrefixes.dust.getMaterialAmount() / 3628800L)).eut(TierEU.RECIPE_EV)
                .addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Aluminium, Materials2Shapes.dust, (int) (6L)),
                        GTOreDictUnificator.get("dustAnyCopper", 1L),
                        MaterialLibAPI.getStack(Materials2Materials.Manganese, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Magnesium, Materials2Shapes.dust, (int) (1L)))
                .circuit(3)
                .itemOutputs(
                        GTOreDictUnificator.getDust(
                                MU.materialOf(Materials2Materials.Duralumin),
                                9L * OrePrefixes.dust.getMaterialAmount()))
                .duration((int) (900L * OrePrefixes.dust.getMaterialAmount() / 3628800L)).eut(TierEU.RECIPE_EV)
                .addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Steel, Materials2Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials2Materials.Zinc, Materials2Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials2Materials.Obsidian, Materials2Shapes.dust, (int) (2L)))
                .circuit(2)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Alumite, Materials2Shapes.dust, (int) (5)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.IC2_Energium_Dust.get(9L),
                        MaterialLibAPI.getStack(Materials2Materials.Lapis, Materials2Shapes.dust, (int) (6L)))
                .circuit(2).itemOutputs(NHItemList.LapotronDust.get(15)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Flint, Materials2Shapes.dustSmall, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.QuartzSand, Materials2Shapes.dust, (int) (4L)))
                .circuit(2)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.dust, (int) (4L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Flint, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.QuartzSand, Materials2Shapes.dust, (int) (16L)))
                .circuit(4)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.dust, (int) (16L)))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Flint, Materials2Shapes.dustSmall, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Quartzite, Materials2Shapes.dust, (int) (4L)))
                .circuit(2)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.dust, (int) (5L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Flint, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Quartzite, Materials2Shapes.dust, (int) (16L)))
                .circuit(4)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.dust, (int) (20L)))
                .duration(32 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Vanadium, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Chrome, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Steel, Materials2Shapes.dust, (int) (7L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.VanadiumSteel, Materials2Shapes.dust, (int) (9L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Copper, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Gold, Materials2Shapes.dust, (int) (4L)))
                .circuit(2)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.RoseGold, Materials2Shapes.dust, (int) (5L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.dust, (int) (6L)),
                        MaterialLibAPI.getStack(Materials2Materials.Nickel, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Manganese, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Chrome, Materials2Shapes.dust, (int) (1L)))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.StainlessSteel, Materials2Shapes.dust, (int) (9L)))
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.RoseGold, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.InfusedGold, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.AstralSilver, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.SterlingSilver, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.SolderingAlloy, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.RedSteel, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.BlueSteel, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Naquadah, Materials2Shapes.dust, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Redstone,
                                Materials2FluidShapes.fluidMolten,
                                (int) (20 * INGOTS)))
                .circuit(4)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.ElectrumFlux, Materials2Shapes.dust, (int) (4L)))
                .duration(2 * SECONDS + 10 * TICKS).eut(900).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Steel, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Nickel, Materials2Shapes.dust, (int) (6L)),
                        MaterialLibAPI.getStack(Materials2Materials.Coal, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Silicon, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Manganese, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Chrome, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Molybdenum, Materials2Shapes.dust, (int) (1L)))
                .circuit(18)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.DamascusSteel, Materials2Shapes.dust, (int) (18L)))
                .duration(11 * SECONDS + 5 * TICKS).eut(900).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Steel, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Manganese, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Chrome, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Coal, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Silicon, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Vanadium, Materials2Shapes.dust, (int) (1L)))
                .circuit(9)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.DamascusSteel, Materials2Shapes.dust, (int) (18L)))
                .duration(11 * SECONDS + 5 * TICKS).eut(900).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Calcite, Materials2Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials2Materials.Stone, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Clay, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.QuartzSand, Materials2Shapes.dust, (int) (1L)))
                .circuit(2).fluidInputs(MU.materialOf(Materials2Materials.Water).getFluid(2000L))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Concrete,
                                Materials2FluidShapes.fluidMolten,
                                (int) (2304L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Clay, Materials2Shapes.dustSmall, (int) (2L)))
                .circuit(2).itemOutputs(new ItemStack(Items.clay_ball, 1, 0))
                .fluidInputs(MU.materialOf(Materials2Materials.Water).getFluid(250L)).duration(1 * SECONDS + 5 * TICKS)
                .eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Copper, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Redstone, Materials2Shapes.dust, (int) (4L)))
                .circuit(2)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.RedAlloy, Materials2Shapes.dust, (int) (1L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Lead, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Antimony, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.BatteryAlloy, Materials2Shapes.dust, (int) (5L)))
                .duration(5 * SECONDS).eut(4).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Tin, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Antimony, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.SolderingAlloy, Materials2Shapes.dust, (int) (10L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Magnesium, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Aluminium, Materials2Shapes.dust, (int) (2L)))
                .circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Magnalium, Materials2Shapes.dust, (int) (3L)))
                .duration(5 * SECONDS).eut(4).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Neutronium, Materials2Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(NHItemList.RawNeutronium.get())
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Helium,
                                Materials2FluidShapes.fluidPlasma,
                                (int) (144L)))
                .duration(11 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_ZPM).addTo(mixerRecipes);

        // One Step Alloy Dust Mixer

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Redstone, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Silicon, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Coal, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials2Materials.Silver, Materials2Shapes.dust, (int) (3L)))
                .circuit(15)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.ConductiveIron, Materials2Shapes.dust, (int) (9L)))
                .duration(6 * SECONDS).eut(TierEU.RECIPE_MV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Redstone, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Silicon, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Coal, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials2Materials.Silver, Materials2Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials2Materials.Gold, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.BlackSteel, Materials2Shapes.dust, (int) (9L)))
                .circuit(17)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.EnergeticAlloy, Materials2Shapes.dust, (int) (27L)))
                .duration(12 * SECONDS).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Redstone, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Silicon, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Coal, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials2Materials.Silver, Materials2Shapes.dust, (int) (12L)),
                        MaterialLibAPI.getStack(Materials2Materials.BlackSteel, Materials2Shapes.dust, (int) (9L)))
                .circuit(16)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.EnergeticSilver, Materials2Shapes.dust, (int) (27L)))
                .duration(12 * SECONDS).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Redstone, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Silicon, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Coal, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials2Materials.Silver, Materials2Shapes.dust, (int) (12L)),
                        MaterialLibAPI.getStack(Materials2Materials.BlackSteel, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.EnderEye, Materials2Shapes.dust, (int) (27L)),
                        MaterialLibAPI.getStack(Materials2Materials.Chrome, Materials2Shapes.dust, (int) (27L)))
                .circuit(18)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.VividAlloy, Materials2Shapes.dust, (int) (64L)),
                        MaterialLibAPI.getStack(Materials2Materials.VividAlloy, Materials2Shapes.dust, (int) (17L)))
                .duration(24 * SECONDS).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Redstone, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Silicon, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Coal, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials2Materials.Silver, Materials2Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials2Materials.BlackSteel, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.EnderEye, Materials2Shapes.dust, (int) (27L)),
                        MaterialLibAPI.getStack(Materials2Materials.Chrome, Materials2Shapes.dust, (int) (27L)),
                        MaterialLibAPI.getStack(Materials2Materials.Gold, Materials2Shapes.dust, (int) (9L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.VibrantAlloy, Materials2Shapes.dust, (int) (64L)),
                        MaterialLibAPI.getStack(Materials2Materials.VibrantAlloy, Materials2Shapes.dust, (int) (17L)))
                .duration(24 * SECONDS).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Steel, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Coal, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Silicon, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Obsidian, Materials2Shapes.dust, (int) (3L)))
                .circuit(14)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.DarkSteel, Materials2Shapes.dust, (int) (9L)))
                .duration(6 * SECONDS).eut(TierEU.RECIPE_MV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Steel, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Coal, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Silicon, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Obsidian, Materials2Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials2Materials.Endstone, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Tungsten, Materials2Shapes.dust, (int) (9L)))
                .circuit(16)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.EndSteel, Materials2Shapes.dust, (int) (27L)))
                .duration(12 * SECONDS).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Steel, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Coal, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Silicon, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Obsidian, Materials2Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials2Materials.Endstone, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.Tungsten, Materials2Shapes.dust, (int) (9L)),
                        MaterialLibAPI.getStack(Materials2Materials.EnderEye, Materials2Shapes.dust, (int) (27L)),
                        MaterialLibAPI.getStack(Materials2Materials.Oriharukon, Materials2Shapes.dust, (int) (27L)))
                .circuit(18)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.MelodicAlloy, Materials2Shapes.dust, (int) (64L)),
                        MaterialLibAPI.getStack(Materials2Materials.MelodicAlloy, Materials2Shapes.dust, (int) (17L)))
                .duration(24 * SECONDS).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 16, 0),
                        MaterialLibAPI.getStack(Materials2Materials.Flint, Materials2Shapes.dust, (int) (2L)))
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
                        MaterialLibAPI.getStack(Materials2Materials.GravitonShard, Materials2Shapes.gem, (int) (4)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Grade8PurifiedWater,
                                Materials2FluidShapes.fluidLiquid,
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
                        MaterialLibAPI.getStack(Materials2Materials.GravitonShard, Materials2Shapes.gem, (int) (4)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Grade8PurifiedWater,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1_000_000_000L)))
                .itemOutputs(NHItemList.StargateCrystalDust.get()).duration(3 * MINUTES).eut(TierEU.RECIPE_UXV)
                .addTo(mixerRecipes);

        // Legacy Stargate Crystal Dust
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.TCetiESeaweedExtract.get().splitStack(64),
                        MaterialLibAPI.getStack(Materials2Materials.Dolomite, Materials2Shapes.dust, (int) (64)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SamariumMagnetic, Materials2Shapes.dust, (int) (21)),
                        MaterialLibAPI.getStack(Materials2Materials.ChromiumDioxide, Materials2Shapes.dust, (int) (64)),
                        MaterialLibAPI.getStack(Materials2Materials.Jasper, Materials2Shapes.gemExquisite, (int) (54L)),
                        MaterialLibAPI.getStack(Materials2Materials.Opal, Materials2Shapes.gemExquisite, (int) (47L)))
                .itemOutputs(NHItemList.StargateDustAncients.get()).duration(3 * MINUTES).eut(262144)
                .addTo(mixerRecipes);

        // Astral Silver & Soldering Alloy + reverse

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Silver, Materials2Shapes.dust, (int) (2)),
                        MaterialLibAPI.getStack(Materials2Materials.Thaumium, Materials2Shapes.dust, (int) (1)))
                .circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.AstralSilver, Materials2Shapes.dust, (int) (3)))
                .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(mixerRecipes);

        // Spinmatron Tier2 Fluid
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.CosmicNeutronium, Materials2Shapes.dust, (int) (4)),
                        GTOreDictUnificator.get(OrePrefixes.nanite, MU.materialOf(Materials2Materials.Glowstone), 2))
                .fluidInputs(
                        new FluidStack(GTPPFluids.Kerosene, 4000),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.BrightLumipodExtract,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1000)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.BiocatalyzedPropulsionFluid,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (5000)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(mixerNonCellRecipes);

        if (PamsHarvestCraft.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "soybeanItem", 1, 0))
                    .itemOutputs(NHItemList.WetTofu.get())
                    .fluidInputs(MU.materialOf(Materials2Materials.Water).getFluid(100L)).duration(30 * SECONDS).eut(2)
                    .addTo(mixerRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "soybeanItem", 1, 0))
                    .itemOutputs(NHItemList.WetTofu.get()).fluidInputs(GTModHandler.getDistilledWater(50L))
                    .duration(20 * SECONDS).eut(2).addTo(mixerRecipes);
        }
        if (Botania.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials2Materials.Terrasteel, Materials2Shapes.dust, (int) (1L)),
                            getModItem(Botania.ID, "manaResource", 4, 5))
                    .itemOutputs(
                            MaterialLibAPI.getStack(Materials2Materials.GaiaSpirit, Materials2Shapes.dust, (int) (1L)))
                    .duration(30 * SECONDS).eut(200).addTo(mixerRecipes);

        }

        if (OpenComputers.isModLoaded()) {
            // Chamelium
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials2Materials.Redstone, Materials2Shapes.dust, (int) (4L)),
                            MaterialLibAPI.getStack(Materials2Materials.Coal, Materials2Shapes.dust, (int) (1L)),
                            MaterialLibAPI.getStack(Materials2Materials.Flint, Materials2Shapes.dust, (int) (4L)))
                    .circuit(2).itemOutputs(getModItem(OpenComputers.ID, "item", 9, 96))
                    .fluidInputs(MU.materialOf(Materials2Materials.Water).getFluid(1000L)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(mixerRecipes);
        }

        if (BiomesOPlenty.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.dirt, 1, 0)).circuit(4)
                    .itemOutputs(getModItem(BiomesOPlenty.ID, "mudball", 4, 0))
                    .fluidInputs(MU.materialOf(Materials2Materials.Water).getFluid(1000L))
                    .duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        }

        if (EnderIO.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(EnderIO.ID, "itemMaterial", 1, 14),
                            MaterialLibAPI.getStack(Materials2Materials.Gold, Materials2Shapes.dust, (int) (1L)),
                            MaterialLibAPI.getStack(Materials2Materials.Emerald, Materials2Shapes.dust, (int) (1L)))
                    .circuit(2)
                    .itemOutputs(
                            MaterialLibAPI
                                    .getStack(Materials2Materials.CrystallineAlloy, Materials2Shapes.dust, (int) (3L)))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

        }

        if (ExtraTrees.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "misc", 4, 2)).circuit(1)
                    .itemOutputs(ItemList.FR_Mulch.get(1L))
                    .fluidInputs(MU.materialOf(Materials2Materials.Water).getFluid(500L)).duration(30 * SECONDS).eut(2)
                    .addTo(mixerRecipes);

        }

        if (TinkerConstruct.isModLoaded() && Natura.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(TinkerConstruct.ID, "slime.gel", 1, 2),
                            MaterialLibAPI.getStack(Materials2Materials.Diamond, Materials2Shapes.dust, (int) (1L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.CrystallineAlloy, Materials2Shapes.dust, (int) (1L)))
                    .circuit(2)
                    .itemOutputs(
                            MaterialLibAPI.getStack(
                                    Materials2Materials.CrystallinePinkSlime,
                                    Materials2Shapes.dust,
                                    (int) (3L)))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Blocks.sand, 3, 0),
                            new ItemStack(Blocks.gravel, 3, 0),
                            new ItemStack(Blocks.clay, 2, 0))
                    .itemOutputs(getModItem(TinkerConstruct.ID, "CraftedSoil", 8, 1))
                    .fluidInputs(MU.materialOf(Materials2Materials.Water).getFluid(2000L)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV / 2).addTo(mixerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Blocks.sand, 3, 1),
                            new ItemStack(Blocks.gravel, 3, 0),
                            new ItemStack(Blocks.clay, 2, 0))
                    .itemOutputs(getModItem(TinkerConstruct.ID, "CraftedSoil", 8, 1))
                    .fluidInputs(MU.materialOf(Materials2Materials.Water).getFluid(2000L)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV / 2).addTo(mixerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Items.nether_wart, 1, 0),
                            new ItemStack(Blocks.soul_sand, 1, 0),
                            new ItemStack(Blocks.gravel, 1, 0),
                            getModItem(Natura.ID, "soil.tainted", 1, 0))
                    .circuit(1).itemOutputs(getModItem(TinkerConstruct.ID, "CraftedSoil", 2, 6))
                    .fluidInputs(MU.materialOf(Materials2Materials.Water).getFluid(2000L)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV / 2).addTo(mixerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Items.nether_wart, 1, 0),
                            new ItemStack(Blocks.soul_sand, 1, 0),
                            new ItemStack(Blocks.gravel, 1, 0),
                            new ItemStack(Blocks.sand, 1, 32767))
                    .circuit(2).itemOutputs(getModItem(TinkerConstruct.ID, "CraftedSoil", 2, 6))
                    .fluidInputs(MU.materialOf(Materials2Materials.Water).getFluid(2000L)).duration(10 * SECONDS)
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
                    .fluidInputs(MU.materialOf(Materials2Materials.Water).getFluid(1000L)).duration(20 * SECONDS)
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
                            MaterialLibAPI.getStack(Materials2Materials.Wheat, Materials2Shapes.dust, (int) (1L)),
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
                            GTOreDictUnificator
                                    .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.ChargedCertusQuartz), 1),
                            MaterialLibAPI.getStack(Materials2Materials.Redstone, Materials2Shapes.dust, (int) (1L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.NetherQuartz, Materials2Shapes.dust, (int) (1L)))
                    .circuit(4).itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 8))
                    .fluidInputs(MU.materialOf(Materials2Materials.Water).getFluid(500L)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV / 2).addTo(mixerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator
                                    .get(OrePrefixes.dust, MU.materialOf(Materials2Materials.ChargedCertusQuartz), 1),
                            MaterialLibAPI.getStack(Materials2Materials.Redstone, Materials2Shapes.dust, (int) (1L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.NetherQuartz, Materials2Shapes.dust, (int) (1L)))
                    .circuit(4).itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 8))
                    .fluidInputs(GTModHandler.getDistilledWater(500L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV / 2)
                    .addTo(mixerRecipes);

        }

        if (Chisel.isModLoaded()) {
            for (int meta = 0; meta < 16; ++meta) {
                GTValues.RA.stdBuilder().itemInputs(getModItem(Chisel.ID, "hempcretesand", 1, meta))
                        .fluidInputs(MU.materialOf(Materials2Materials.Water).getFluid(100L))
                        .itemOutputs(getModItem(Chisel.ID, "hempcrete", 1, meta)).duration(5 * SECONDS)
                        .eut(TierEU.RECIPE_LV).addTo(mixerRecipes);
            }
        }

        if (UniversalSingularities.isModLoaded() && Avaritia.isModLoaded()) {
            // Star Fuel
            GTValues.RA.stdBuilder().itemInputs(
                    GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Neutronium), 64),
                    GTOreDictUnificator
                            .get(OrePrefixes.block, MU.materialOf(Materials2Materials.CosmicNeutronium), 64L),
                    // Diamond Singularity
                    getModItem(UniversalSingularities.ID, "universal.vanilla.singularity", 1, 2))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 1, 8))
                    .fluidInputs(
                            GGMaterial.naquadahBasedFuelMkV.getFluidOrGas(1000),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ExcitedDTEC,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (128000)))
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
