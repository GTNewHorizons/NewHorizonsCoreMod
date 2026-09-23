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
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.BlockShapes;
import gregtech.api.enums.materials.FluidShapes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.recipe.metadata.CompressionTierKey;
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
                    GTUtility.copyAmountUnsafe(7296, MaterialLibAPI.getStack(Materials.Iron, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 0)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(1215, MaterialLibAPI.getStack(Materials.Gold, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 1)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(1215, MaterialLibAPI.getStack(Materials.Lapis, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 2)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(7296, MaterialLibAPI.getStack(Materials.Redstone, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 3)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    1215,
                                    MaterialLibAPI.getStack(Materials.NetherQuartz, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 4)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(3648, MaterialLibAPI.getStack(Materials.Copper, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 5)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(3648, MaterialLibAPI.getStack(Materials.Tin, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 6)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(3648, MaterialLibAPI.getStack(Materials.Lead, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 7)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(7296, MaterialLibAPI.getStack(Materials.Silver, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 8)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(3648, MaterialLibAPI.getStack(Materials.Nickel, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 9)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(608, MaterialLibAPI.getStack(Materials.Enderium, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 10)).duration(3 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(3648, MaterialLibAPI.getStack(Materials.Coal, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.vanilla.singularity", 1, 0))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(729, MaterialLibAPI.getStack(Materials.Emerald, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.vanilla.singularity", 1, 1))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(729, MaterialLibAPI.getStack(Materials.Diamond, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.vanilla.singularity", 1, 2))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().fluidInputs(GTUtility.getWater(2147483647L))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.vanilla.singularity", 1, 3))
                    .duration(30 * SECONDS).eut(TierEU.RECIPE_UV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility
                            .copyAmountUnsafe(1824, MaterialLibAPI.getStack(Materials.Aluminium, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 0))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(1824, MaterialLibAPI.getStack(Materials.Brass, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 1))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(1824, MaterialLibAPI.getStack(Materials.Bronze, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 2))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(7296, MaterialLibAPI.getStack(Materials.Charcoal, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 3))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(912, MaterialLibAPI.getStack(Materials.Electrum, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 4))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(1824, MaterialLibAPI.getStack(Materials.Invar, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 5))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility
                            .copyAmountUnsafe(3648, MaterialLibAPI.getStack(Materials.Magnesium, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 6))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(406, MaterialLibAPI.getStack(Materials.Osmium, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 7))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(608, MaterialLibAPI.getStack(Materials.Olivine, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 8))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(608, MaterialLibAPI.getStack(Materials.Ruby, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 9))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(608, MaterialLibAPI.getStack(Materials.Sapphire, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 10))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(912, MaterialLibAPI.getStack(Materials.Steel, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 11))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(2024, MaterialLibAPI.getStack(Materials.Titanium, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 12))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(244, MaterialLibAPI.getStack(Materials.Tungsten, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 13))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(507, MaterialLibAPI.getStack(Materials.Uranium, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 14))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(3648, MaterialLibAPI.getStack(Materials.Zinc, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 15))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    365,
                                    MaterialLibAPI.getStack(Materials.TricalciumPhosphate, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 16))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(136, MaterialLibAPI.getStack(Materials.Palladium, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 17))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    153,
                                    MaterialLibAPI.getStack(Materials.DamascusSteel, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 18))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility
                            .copyAmountUnsafe(304, MaterialLibAPI.getStack(Materials.BlackSteel, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 19))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    16,
                                    MaterialLibAPI.getStack(Materials.ElectrumFlux, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 20))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    12345,
                                    MaterialLibAPI.getStack(Materials.Rubber, Shapes.plateSuperdense, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.rubber.singularity", 1, 0))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(
                            12345,
                            MaterialLibAPI.getStack(Materials.StyreneButadieneRubber, Shapes.plateSuperdense, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.rubber.singularity", 1, 1))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    12345,
                                    MaterialLibAPI.getStack(Materials.Silicone, Shapes.plateSuperdense, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.rubber.singularity", 1, 2))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    12345,
                                    MaterialLibAPI.getStack(Materials.PolyphenyleneSulfide, Shapes.plateSuperdense, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.rubber.singularity", 1, 3))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    12345,
                                    MaterialLibAPI.getStack(Materials.PolyvinylChloride, Shapes.plateSuperdense, 1)))
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
                                    MaterialLibAPI.getStack(Materials.ShadowSteel, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 22))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(62, MaterialLibAPI.getStack(Materials.Iridium, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 23))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility
                            .copyAmountUnsafe(512, MaterialLibAPI.getStack(Materials.NetherStar, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 24))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(406, MaterialLibAPI.getStack(Materials.Platinum, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 25))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(66, MaterialLibAPI.getStack(Materials.Naquadria, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 26))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(244, MaterialLibAPI.getStack(Materials.Plutonium, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 27))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputsUnsafe(
                            GTUtility.copyAmountUnsafe(
                                    912,
                                    MaterialLibAPI.getStack(Materials.MeteoricIron, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 28))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(203, MaterialLibAPI.getStack(Materials.Desh, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 29))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(62, MaterialLibAPI.getStack(Materials.Europium, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 30))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(1824, MaterialLibAPI.getStack(Materials.RoseGold, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 32))
                    .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            if (DraconicEvolution.isModLoaded()) {
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        1296,
                                        MaterialLibAPI.getStack(Materials.Draconium, BlockShapes.block, 1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.draconicEvolution.singularity", 1, 0))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        760,
                                        MaterialLibAPI.getStack(Materials.DraconiumAwakened, BlockShapes.block, 1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.draconicEvolution.singularity", 1, 1))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            }
            if (EnderIO.isModLoaded()) {
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        912,
                                        MaterialLibAPI.getStack(Materials.ConductiveIron, BlockShapes.block, 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 0))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        912,
                                        MaterialLibAPI.getStack(Materials.ElectricalSteel, BlockShapes.block, 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 1))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        191,
                                        MaterialLibAPI.getStack(Materials.EnergeticAlloy, BlockShapes.block, 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 2))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        912,
                                        MaterialLibAPI.getStack(Materials.DarkSteel, BlockShapes.block, 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 3))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        912,
                                        MaterialLibAPI.getStack(Materials.PulsatingIron, BlockShapes.block, 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 4))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        912,
                                        MaterialLibAPI.getStack(Materials.RedstoneAlloy, BlockShapes.block, 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 5))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        456,
                                        MaterialLibAPI.getStack(Materials.Soularium, BlockShapes.block, 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 6))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        145,
                                        MaterialLibAPI.getStack(Materials.VibrantAlloy, BlockShapes.block, 1)))
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
                                        MaterialLibAPI.getStack(Materials.Electrotine, BlockShapes.block, 1)))
                        .itemOutputs(getModItem(UniversalSingularities.ID, "universal.projectRed.singularity", 1, 0))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            }
            if (TinkerConstruct.isModLoaded()) {
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        229,
                                        MaterialLibAPI.getStack(Materials.Alumite, BlockShapes.block, 1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 1))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder().itemInputsUnsafe(
                        GTUtility
                                .copyAmountUnsafe(304, MaterialLibAPI.getStack(Materials.Ardite, BlockShapes.block, 1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 2))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        1824,
                                        MaterialLibAPI.getStack(Materials.Cobalt, BlockShapes.block, 1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 3))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        608,
                                        MaterialLibAPI.getStack(Materials.EnderPearl, BlockShapes.block, 1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 4))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
                GTValues.RA.stdBuilder()
                        .itemInputsUnsafe(
                                GTUtility.copyAmountUnsafe(
                                        308,
                                        MaterialLibAPI.getStack(Materials.Manyullyn, BlockShapes.block, 1)))
                        .itemOutputs(
                                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 6))
                        .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(neutroniumCompressorRecipes);
            }
            GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.InfinityCatalyst, Shapes.dust, 64))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 1, 5)).duration(3 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(neutroniumCompressorRecipes);

            // Recipes which require stabilized black hole - not from original neutronium compressor

            // Eternal Singularity
            GTValues.RA.stdBuilder()
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.SpaceTime, FluidShapes.fluidMolten, 72))
                    .itemOutputs(getModItem(EternalSingularity.ID, "eternal_singularity", 1)).duration(100 * SECONDS)
                    .eut(TierEU.RECIPE_UMV).metadata(COMPRESSION_TIER, 2).addTo(neutroniumCompressorRecipes);

            // Iron Singularity
            GTValues.RA.stdBuilder()
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Iron, FluidShapes.fluidMolten, 9455616))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 0)).duration(1 * TICKS)
                    .eut(TierEU.RECIPE_UIV).metadata(COMPRESSION_TIER, 2).addTo(neutroniumCompressorRecipes);

            // Gangue Singularity
            GTValues.RA.stdBuilder().itemInputsUnsafe(
                    GTUtility.copyAmountUnsafe(444444, MaterialLibAPI.getStack(Materials.Gangue, BlockShapes.block, 1)))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 31))
                    .duration(120 * SECONDS).eut(TierEU.RECIPE_UEV).metadata(COMPRESSION_TIER, 2)
                    .addTo(neutroniumCompressorRecipes);

            // Copper Singularity
            GTValues.RA.stdBuilder().fluidInputs(
                    MaterialLibAPI.getFluidStack(Materials.Copper, FluidShapes.fluidMolten, (int) (3648 * 9 * 144L)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 5)).duration(1 * TICKS)
                    .eut(TierEU.RECIPE_UIV).metadata(COMPRESSION_TIER, 2).addTo(neutroniumCompressorRecipes);

            // Tin Singularity
            GTValues.RA.stdBuilder().fluidInputs(
                    MaterialLibAPI.getFluidStack(Materials.Tin, FluidShapes.fluidMolten, (int) (3648 * 9 * 144L)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 6)).duration(1 * TICKS)
                    .eut(TierEU.RECIPE_UIV).metadata(COMPRESSION_TIER, 2).addTo(neutroniumCompressorRecipes);

            // Leaden Singularity
            GTValues.RA.stdBuilder().fluidInputs(
                    MaterialLibAPI.getFluidStack(Materials.Lead, FluidShapes.fluidMolten, (int) (3648 * 9 * 144L)))
                    .itemOutputs(getModItem(Avaritia.ID, "Singularity", 1, 7)).duration(1 * TICKS)
                    .eut(TierEU.RECIPE_UIV).metadata(COMPRESSION_TIER, 2).addTo(neutroniumCompressorRecipes);

            // Base Computation Singularity
            GTValues.RA.stdBuilder().fluidInputs(
                    MaterialLibAPI.getFluidStack(Materials.ComputationBase, FluidShapes.fluidLiquid, Integer.MAX_VALUE))
                    .itemInputs(NHItemList.SingularityComputationCore.get(1))
                    .itemOutputs(getModItem(UniversalSingularities.ID, "universal.circuit2.singularity", 1, 6))
                    .duration(4500 * SECONDS).eut(TierEU.RECIPE_UXV).metadata(COMPRESSION_TIER, 2)
                    .addTo(neutroniumCompressorRecipes);
        }
    }
}
