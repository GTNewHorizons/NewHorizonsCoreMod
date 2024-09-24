package com.dreammaster.gthandler.recipes;

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
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gtnhlanth.common.register.WerkstoffMaterialPool.Gangue;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
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
                    GTUtility.copyAmountUnsafe(7296, GTOreDictUnificator.get(OrePrefixes.block, Materials.Iron, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1L, 0)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(1215, GTOreDictUnificator.get(OrePrefixes.block, Materials.Gold, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1L, 1)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(1215, GTOreDictUnificator.get(OrePrefixes.block, Materials.Lapis, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1L, 2)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(7296, GTOreDictUnificator.get(OrePrefixes.block, Materials.Redstone, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1L, 3)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    1215,
                                    GTOreDictUnificator.get(OrePrefixes.block, Materials.NetherQuartz, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1L, 4)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(3648, GTOreDictUnificator.get(OrePrefixes.block, Materials.Copper, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1L, 5)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(3648, GTOreDictUnificator.get(OrePrefixes.block, Materials.Tin, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1L, 6)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(3648, GTOreDictUnificator.get(OrePrefixes.block, Materials.Lead, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1L, 7)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(7296, GTOreDictUnificator.get(OrePrefixes.block, Materials.Silver, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1L, 8)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(3648, GTOreDictUnificator.get(OrePrefixes.block, Materials.Nickel, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1L, 9)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(608, GTOreDictUnificator.get(OrePrefixes.block, Materials.Enderium, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1L, 10)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(3648, GTOreDictUnificator.get(OrePrefixes.block, Materials.Coal, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.vanilla.singularity", 1, 0))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(729, GTOreDictUnificator.get(OrePrefixes.block, Materials.Emerald, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.vanilla.singularity", 1, 1))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(729, GTOreDictUnificator.get(OrePrefixes.block, Materials.Diamond, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.vanilla.singularity", 1, 2))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility
                            .copyAmountUnsafe(1824, GTOreDictUnificator.get(OrePrefixes.block, Materials.Aluminium, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 0))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(1824, GTOreDictUnificator.get(OrePrefixes.block, Materials.Brass, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 1))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(1824, GTOreDictUnificator.get(OrePrefixes.block, Materials.Bronze, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 2))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(7296, GTOreDictUnificator.get(OrePrefixes.block, Materials.Charcoal, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 3))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(912, GTOreDictUnificator.get(OrePrefixes.block, Materials.Electrum, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 4))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(1824, GTOreDictUnificator.get(OrePrefixes.block, Materials.Invar, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 5))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility
                            .copyAmountUnsafe(3648, GTOreDictUnificator.get(OrePrefixes.block, Materials.Magnesium, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 6))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(406, GTOreDictUnificator.get(OrePrefixes.block, Materials.Osmium, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 7))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(608, GTOreDictUnificator.get(OrePrefixes.block, Materials.Olivine, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 8))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(608, GTOreDictUnificator.get(OrePrefixes.block, Materials.Ruby, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 9))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(608, GTOreDictUnificator.get(OrePrefixes.block, Materials.Sapphire, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 10))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(912, GTOreDictUnificator.get(OrePrefixes.block, Materials.Steel, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 11))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(2024, GTOreDictUnificator.get(OrePrefixes.block, Materials.Titanium, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 12))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(244, GTOreDictUnificator.get(OrePrefixes.block, Materials.Tungsten, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 13))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(507, GTOreDictUnificator.get(OrePrefixes.block, Materials.Uranium, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 14))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(3648, GTOreDictUnificator.get(OrePrefixes.block, Materials.Zinc, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 15))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    365,
                                    GTOreDictUnificator.get(OrePrefixes.block, Materials.TricalciumPhosphate, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 16))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(136, GTOreDictUnificator.get(OrePrefixes.block, Materials.Palladium, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 17))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    153,
                                    GTOreDictUnificator.get(OrePrefixes.block, Materials.DamascusSteel, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 18))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility
                            .copyAmountUnsafe(304, GTOreDictUnificator.get(OrePrefixes.block, Materials.BlackSteel, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 19))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    16,
                                    GTOreDictUnificator.get(OrePrefixes.block, Materials.ElectrumFlux, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 20))
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
                                    GTOreDictUnificator.get(OrePrefixes.block, Materials.ShadowSteel, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 22))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(62, GTOreDictUnificator.get(OrePrefixes.block, Materials.Iridium, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 23))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility
                            .copyAmountUnsafe(512, GTOreDictUnificator.get(OrePrefixes.block, Materials.NetherStar, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 24))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(406, GTOreDictUnificator.get(OrePrefixes.block, Materials.Platinum, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 25))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(66, GTOreDictUnificator.get(OrePrefixes.block, Materials.Naquadria, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 26))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(244, GTOreDictUnificator.get(OrePrefixes.block, Materials.Plutonium, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 27))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    912,
                                    GTOreDictUnificator.get(OrePrefixes.block, Materials.MeteoricIron, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 28))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(203, GTOreDictUnificator.get(OrePrefixes.block, Materials.Desh, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 29))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(62, GTOreDictUnificator.get(OrePrefixes.block, Materials.Europium, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 30))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            if (DraconicEvolution.isModLoaded()) {
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        1296,
                                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Draconium, 1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.draconicEvolution.singularity", 1, 0))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        760,
                                        GTOreDictUnificator.get(OrePrefixes.block, Materials.DraconiumAwakened, 1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.draconicEvolution.singularity", 1, 1))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            }
            if (EnderIO.isModLoaded()) {
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        912,
                                        GTOreDictUnificator.get(OrePrefixes.block, Materials.ConductiveIron, 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 0))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        912,
                                        GTOreDictUnificator.get(OrePrefixes.block, Materials.ElectricalSteel, 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 1))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        191,
                                        GTOreDictUnificator.get(OrePrefixes.block, Materials.EnergeticAlloy, 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 2))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        912,
                                        GTOreDictUnificator.get(OrePrefixes.block, Materials.DarkSteel, 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 3))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        912,
                                        GTOreDictUnificator.get(OrePrefixes.block, Materials.PulsatingIron, 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 4))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        912,
                                        GTOreDictUnificator.get(OrePrefixes.block, Materials.RedstoneAlloy, 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 5))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        456,
                                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Soularium, 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 6))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        145,
                                        GTOreDictUnificator.get(OrePrefixes.block, Materials.VibrantAlloy, 1)))
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
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        1215,
                                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Electrotine, 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.projectRed.singularity", 1, 0))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            }
            if (TinkerConstruct.isModLoaded()) {
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        1824,
                                        GTOreDictUnificator.get(OrePrefixes.block, Materials.AluminiumBrass, 1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 0))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        229,
                                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Alumite, 1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 1))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder().itemInputsUnsafe(
                        GTUtility
                                .copyAmountUnsafe(304, GTOreDictUnificator.get(OrePrefixes.block, Materials.Ardite, 1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 2))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        1824,
                                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Cobalt, 1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 3))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        608,
                                        GTOreDictUnificator.get(OrePrefixes.block, Materials.EnderPearl, 1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 4))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        308,
                                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Manyullyn, 1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 6))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            }
            GTValues.RA.stdBuilder()
                    .itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.InfinityCatalyst, 64))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 1L, 5)).duration(3 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(neutroniumCompressorRecipes);

            // Recipes which require stabilized black hole - not from original neutronium compressor

            // Eternal Singularity
            GTValues.RA.stdBuilder().fluidInputs(MaterialsUEVplus.SpaceTime.getMolten(72L))
                    .itemOutputs(getModItem(EternalSingularity.ID, "eternal_singularity", 1)).duration(100 * SECONDS)
                    .eut(TierEU.RECIPE_UMV).metadata(COMPRESSION_TIER, 2).addTo(neutroniumCompressorRecipes);

            // Iron Singularity
            GTValues.RA.stdBuilder().fluidInputs(Materials.Iron.getMolten(9455616L))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1L, 0)).duration(1 * TICKS)
                    .eut(TierEU.RECIPE_UIV).metadata(COMPRESSION_TIER, 2).addTo(neutroniumCompressorRecipes);

            // Gangue Singularity
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(GTUtility.copyAmountUnsafe(444444, Gangue.get(OrePrefixes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 31))
                    .duration(120 * SECONDS).eut(TierEU.RECIPE_UEV).metadata(COMPRESSION_TIER, 2)
                    .addTo(neutroniumCompressorRecipes);

            // Copper Singularity
            GTValues.RA.stdBuilder().fluidInputs(Materials.Copper.getMolten(3648 * 9 * 144L))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1L, 5)).duration(1 * TICKS)
                    .eut(TierEU.RECIPE_UIV).metadata(COMPRESSION_TIER, 2).addTo(neutroniumCompressorRecipes);
        }
    }
}
