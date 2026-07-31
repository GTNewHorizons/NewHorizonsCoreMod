package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.ProjectRedCore;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.UniversalSingularities;
import static gregtech.api.recipe.RecipeMaps.neutroniumCompressorRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static toxiceverglades.dimension.DimensionEverglades.blockSecondLayer;

import net.minecraft.item.ItemStack;

import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2FluidShapes;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.material.MU;
import gregtech.api.recipe.metadata.CompressionTierKey;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;

// All recipes from Avaritia's Neutronium Compressor - now in GT!
public class NeutroniumCompressorRecipes implements Runnable {

    // Use .metadata(COMPRESSION_TIER, 2) if you want a recipe to be black hole only
    // Use itemInputsUnsafe for stack sizes > 64

    @Override
    public void run() {

        final CompressionTierKey COMPRESSION_TIER = CompressionTierKey.INSTANCE;

        if (Avaritia.isModLoaded() && UniversalSingularities.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            7296,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Iron), 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 0)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            1215,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Gold), 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 1)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            1215,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Lapis), 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 2)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            7296,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Redstone), 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 3)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            1215,
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.NetherQuartz), 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 4)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            3648,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Copper), 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 5)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            3648,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Tin), 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 6)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            3648,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Lead), 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 7)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            7296,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Silver), 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 8)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            3648,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Nickel), 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 9)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            608,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Enderium), 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 10)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            3648,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Coal), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.vanilla.singularity", 1, 0))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            729,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Emerald), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.vanilla.singularity", 1, 1))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            729,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Diamond), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.vanilla.singularity", 1, 2))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().fluidInputs(MU.materialOf(Materials2Materials.Water).getFluid(2147483647L))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.vanilla.singularity", 1, 3))
                    .duration(30 * SECONDS).eut(TierEU.RECIPE_UV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    1824,
                                    GTOreDictUnificator
                                            .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Aluminium), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 0))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            1824,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Brass), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 1))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            1824,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Bronze), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 2))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            7296,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Charcoal), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 3))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            912,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Electrum), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 4))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            1824,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Invar), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 5))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    3648,
                                    GTOreDictUnificator
                                            .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Magnesium), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 6))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            406,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Osmium), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 7))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            608,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Olivine), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 8))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            608,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Ruby), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 9))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            608,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Sapphire), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 10))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            912,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Steel), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 11))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            2024,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Titanium), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 12))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            244,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Tungsten), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 13))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            507,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Uranium), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 14))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            3648,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Zinc), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 15))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            365,
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.TricalciumPhosphate), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 16))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    136,
                                    GTOreDictUnificator
                                            .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Palladium), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 17))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            153,
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.DamascusSteel), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 18))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    304,
                                    GTOreDictUnificator
                                            .get(OrePrefixes.block, MU.materialOf(Materials2Materials.BlackSteel), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 19))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            16,
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.ElectrumFlux), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 20))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            12345,
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Rubber, Materials2Shapes.plateSuperdense, (int) (1))))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.rubber.singularity", 1, 0))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    12345,
                                    MaterialLibAPI.getStack(
                                            Materials2Materials.StyreneButadieneRubber,
                                            Materials2Shapes.plateSuperdense,
                                            (int) (1))))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.rubber.singularity", 1, 1))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    12345,
                                    MaterialLibAPI.getStack(
                                            Materials2Materials.Silicone,
                                            Materials2Shapes.plateSuperdense,
                                            (int) (1))))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.rubber.singularity", 1, 2))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    12345,
                                    MaterialLibAPI.getStack(
                                            Materials2Materials.PolyphenyleneSulfide,
                                            Materials2Shapes.plateSuperdense,
                                            (int) (1))))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.rubber.singularity", 1, 3))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    12345,
                                    MaterialLibAPI.getStack(
                                            Materials2Materials.PolyvinylChloride,
                                            Materials2Shapes.plateSuperdense,
                                            (int) (1))))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.rubber.singularity", 1, 4))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(GTUtility.copyAmountUnsafe(4321, new ItemStack(blockSecondLayer)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.toxic.singularity"))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);

            if (ThaumicBases.isModLoaded()) {
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(1824, getModItem(ThaumicBases.ID, "quicksilverBlock", 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 21))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            }
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    406,
                                    GTOreDictUnificator
                                            .get(OrePrefixes.block, MU.materialOf(Materials2Materials.ShadowSteel), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 22))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            62,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Iridium), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 23))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    512,
                                    GTOreDictUnificator
                                            .get(OrePrefixes.block, MU.materialOf(Materials2Materials.NetherStar), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 24))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            406,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Platinum), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 25))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    66,
                                    GTOreDictUnificator
                                            .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Naquadria), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 26))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    244,
                                    GTOreDictUnificator
                                            .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Plutonium), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 27))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            912,
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.MeteoricIron), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 28))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            203,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Desh), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 29))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            62,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Europium), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 30))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            1824,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.RoseGold), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 32))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            if (DraconicEvolution.isModLoaded()) {
                GTValues.RA.stdBuilder().itemInputsUnsafe(
                        GTUtility.copyAmountUnsafe(
                                1296,
                                GTOreDictUnificator
                                        .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Draconium), 1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.draconicEvolution.singularity", 1, 0))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        760,
                                        GTOreDictUnificator.get(
                                                OrePrefixes.block,
                                                MU.materialOf(Materials2Materials.DraconiumAwakened),
                                                1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.draconicEvolution.singularity", 1, 1))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            }
            if (EnderIO.isModLoaded()) {
                GTValues.RA.stdBuilder().itemInputsUnsafe(
                        GTUtility.copyAmountUnsafe(
                                912,
                                GTOreDictUnificator
                                        .get(OrePrefixes.block, MU.materialOf(Materials2Materials.ConductiveIron), 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 0))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder().itemInputsUnsafe(
                        GTUtility.copyAmountUnsafe(
                                912,
                                GTOreDictUnificator
                                        .get(OrePrefixes.block, MU.materialOf(Materials2Materials.ElectricalSteel), 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 1))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder().itemInputsUnsafe(
                        GTUtility.copyAmountUnsafe(
                                191,
                                GTOreDictUnificator
                                        .get(OrePrefixes.block, MU.materialOf(Materials2Materials.EnergeticAlloy), 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 2))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder().itemInputsUnsafe(
                        GTUtility.copyAmountUnsafe(
                                912,
                                GTOreDictUnificator
                                        .get(OrePrefixes.block, MU.materialOf(Materials2Materials.DarkSteel), 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 3))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder().itemInputsUnsafe(
                        GTUtility.copyAmountUnsafe(
                                912,
                                GTOreDictUnificator
                                        .get(OrePrefixes.block, MU.materialOf(Materials2Materials.PulsatingIron), 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 4))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder().itemInputsUnsafe(
                        GTUtility.copyAmountUnsafe(
                                912,
                                GTOreDictUnificator
                                        .get(OrePrefixes.block, MU.materialOf(Materials2Materials.RedstoneAlloy), 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 5))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder().itemInputsUnsafe(
                        GTUtility.copyAmountUnsafe(
                                456,
                                GTOreDictUnificator
                                        .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Soularium), 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 6))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder().itemInputsUnsafe(
                        GTUtility.copyAmountUnsafe(
                                145,
                                GTOreDictUnificator
                                        .get(OrePrefixes.block, MU.materialOf(Materials2Materials.VibrantAlloy), 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 7))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            }
            if (ExtraUtilities.isModLoaded()) {
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(66, getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 5)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.extraUtilities.singularity", 1, 0))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            }
            if (ProjectRedCore.isModLoaded()) {
                GTValues.RA.stdBuilder().itemInputsUnsafe(
                        GTUtility.copyAmountUnsafe(
                                1215,
                                GTOreDictUnificator
                                        .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Electrotine), 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.projectRed.singularity", 1, 0))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            }
            if (TinkerConstruct.isModLoaded()) {
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        229,
                                        GTOreDictUnificator
                                                .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Alumite), 1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 1))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        304,
                                        GTOreDictUnificator
                                                .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Ardite), 1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 2))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        1824,
                                        GTOreDictUnificator
                                                .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Cobalt), 1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 3))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder().itemInputsUnsafe(
                        GTUtility.copyAmountUnsafe(
                                608,
                                GTOreDictUnificator
                                        .get(OrePrefixes.block, MU.materialOf(Materials2Materials.EnderPearl), 1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 4))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder().itemInputsUnsafe(
                        GTUtility.copyAmountUnsafe(
                                308,
                                GTOreDictUnificator
                                        .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Manyullyn), 1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 6))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            }
            GTValues.RA.stdBuilder().itemInputs(
                    MaterialLibAPI.getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.dust, (int) (64)))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 1, 5)).duration(3 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(neutroniumCompressorRecipes);

            // Recipes which require stabilized black hole - not from original neutronium compressor

            // Eternal Singularity
            GTValues.RA.stdBuilder()
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.SpaceTime,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (72L)))
                    .itemOutputs(getModItem(EternalSingularity.ID, "eternal_singularity", 1)).duration(100 * SECONDS)
                    .eut(TierEU.RECIPE_UMV).metadata(COMPRESSION_TIER, 2).addTo(neutroniumCompressorRecipes);

            // Iron Singularity
            GTValues.RA.stdBuilder()
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Iron,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (9455616L)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 0)).duration(1 * TICKS)
                    .eut(TierEU.RECIPE_UIV).metadata(COMPRESSION_TIER, 2).addTo(neutroniumCompressorRecipes);

            // Gangue Singularity
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            444444,
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Gangue), 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 31))
                    .duration(120 * SECONDS).eut(TierEU.RECIPE_UEV).metadata(COMPRESSION_TIER, 2)
                    .addTo(neutroniumCompressorRecipes);

            // Copper Singularity
            GTValues.RA.stdBuilder()
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Copper,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (3648 * 9 * 144L)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 5)).duration(1 * TICKS)
                    .eut(TierEU.RECIPE_UIV).metadata(COMPRESSION_TIER, 2).addTo(neutroniumCompressorRecipes);

            // Tin Singularity
            GTValues.RA.stdBuilder()
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Tin,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (3648 * 9 * 144L)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 6)).duration(1 * TICKS)
                    .eut(TierEU.RECIPE_UIV).metadata(COMPRESSION_TIER, 2).addTo(neutroniumCompressorRecipes);

            // Leaden Singularity
            GTValues.RA.stdBuilder()
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Lead,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (3648 * 9 * 144L)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 7)).duration(1 * TICKS)
                    .eut(TierEU.RECIPE_UIV).metadata(COMPRESSION_TIER, 2).addTo(neutroniumCompressorRecipes);

            // Base Computation Singularity
            GTValues.RA.stdBuilder()
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ComputationBase,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (Integer.MAX_VALUE)))
                    .itemInputs(NHItemList.SingularityComputationCore.get(1))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.circuit2.singularity", 1, 6))
                    .duration(4500 * SECONDS).eut(TierEU.RECIPE_UXV).metadata(COMPRESSION_TIER, 2)
                    .addTo(neutroniumCompressorRecipes);
        }
    }
}
