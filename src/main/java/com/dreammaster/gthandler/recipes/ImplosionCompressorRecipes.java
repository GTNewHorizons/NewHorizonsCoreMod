package com.dreammaster.gthandler.recipes;

import static bartworks.API.recipe.BartWorksRecipeMaps.electricImplosionCompressorRecipes;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.enums.Mods.Translocator;
import static gregtech.api.recipe.RecipeMaps.implosionRecipes;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeConstants.ADDITIVE_AMOUNT;

import com.dreammaster.item.NHItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;

public class ImplosionCompressorRecipes implements Runnable {

    @Override
    public void run() {
        if (GalaxySpace.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(GTOreDictUnificator.get(OrePrefixes.compressed, Materials.Aluminium, 2L))
                    .itemOutputs(
                            getModItem(GalaxySpace.ID, "item.CompressedDualAluminium", 1, 0),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.compressed, Materials.Bronze, 2L))
                    .itemOutputs(
                            getModItem(GalaxySpace.ID, "item.CompressedDualBronze", 1, 0),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.RawSDHCAlloy.get())
                    .itemOutputs(
                            getModItem(GalaxySpace.ID, "item.CompressedSDHD120", 1, 0),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.StainlessSteel, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 5).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.block, Materials.Coal, 1L))
                    .itemOutputs(
                            getModItem(GalaxySpace.ID, "item.CompressedCoal", 1, 0),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.BlackPlutonium, 1L))
                    .itemOutputs(
                            NHItemList.BlackPlutoniumCompressedPlate.get(),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Adamantium, 1L))
                    .itemOutputs(
                            getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 0),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Cobalt, 1L))
                    .itemOutputs(
                            getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 1),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Duralumin, 1L))
                    .itemOutputs(
                            getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 2),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Lead, 1L))
                    .itemOutputs(
                            getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 3),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Magnesium, 1L))
                    .itemOutputs(
                            getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 4),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Mithril, 1L))
                    .itemOutputs(
                            getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 5),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Nickel, 1L))
                    .itemOutputs(
                            getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 6),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Oriharukon, 1L))
                    .itemOutputs(
                            getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 7),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Platinum, 1L))
                    .itemOutputs(
                            getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 8),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Tungsten, 1L))
                    .itemOutputs(
                            getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 9),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

        }
        if (GalacticraftMars.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 2, 6))
                    .itemOutputs(
                            NHItemList.TitaniumDualCompressedPlates.get(),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.null", 2, 5))
                    .itemOutputs(
                            NHItemList.DeshDualCompressedPlates.get(),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

        }

        GTValues.RA.stdBuilder().itemInputs(NHItemList.IceCompressedPlate.get(2))
                .itemOutputs(
                        NHItemList.IceDualCompressedPlates.get(),
                        GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.QuantinumCompressedPlate.get(2))
                .itemOutputs(
                        NHItemList.QuantinumDualCompressedPlates.get(),
                        GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MytrylCompressedPlate.get(2))
                .itemOutputs(
                        NHItemList.MytrylDualCompressedPlates.get(),
                        GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MysteriousCrystalCompressedPlate.get(2))
                .itemOutputs(
                        NHItemList.MysteriousCrystalDualCompressedPlates.get(),
                        GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

        if (GalacticraftCore.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.basicItem", 2, 9))
                    .itemOutputs(
                            NHItemList.SteelDualCompressedPlates.get(),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.basicItem", 2, 7))
                    .itemOutputs(
                            NHItemList.TinDualCompressedPlates.get(),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.basicItem", 2, 6))
                    .itemOutputs(
                            NHItemList.CopperDualCompressedPlates.get(),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.basicItem", 2, 11))
                    .itemOutputs(
                            NHItemList.IronDualCompressedPlates.get(),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.meteoricIronIngot", 2, 1))
                    .itemOutputs(
                            NHItemList.MeteoricIronDualCompressedPlates.get(),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

        }

        GTValues.RA.stdBuilder().itemInputs(NHItemList.HeavyDutyAlloyIngotT5.get())
                .itemOutputs(
                        NHItemList.HeavyDutyPlateTier5.get(),
                        GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Europium, 5L))
                .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 40).addTo(implosionRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.HeavyDutyAlloyIngotT6.get())
                .itemOutputs(
                        NHItemList.HeavyDutyPlateTier6.get(),
                        GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Tritanium, 6L))
                .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 48).addTo(implosionRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.HeavyDutyAlloyIngotT7.get())
                .itemOutputs(
                        NHItemList.HeavyDutyPlateTier7.get(),
                        GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Neutronium, 7L))
                .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 56).addTo(implosionRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.HeavyDutyAlloyIngotT8.get())
                .itemOutputs(
                        NHItemList.HeavyDutyPlateTier8.get(),
                        GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.BlackPlutonium, 8L))
                .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 64).addTo(implosionRecipes);

        // Avaritia recipes
        if (Avaritia.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(Avaritia.ID, "Resource", 9, 2))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 1, 3)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                    .metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(Avaritia.ID, "Resource", 9, 3))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 1, 4)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                    .metadata(ADDITIVE_AMOUNT, 4).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(Avaritia.ID, "Resource", 9, 4))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource_Block", 1, 0)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 16).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(Avaritia.ID, "Resource", 9, 6))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource_Block", 1, 1)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 64).addTo(implosionRecipes);

        }
        // extra utils
        if (ExtraUtilities.isModLoaded()) {
            // CC

            GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 0))
                    .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 1)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 1))
                    .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 2)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 2))
                    .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 3)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 3))
                    .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 4)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 4))
                    .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 5)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 8).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 5))
                    .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 6)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 10).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 6))
                    .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 7)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 16).addTo(implosionRecipes);
            // CD

            GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 8))
                    .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 9)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 9))
                    .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 10)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 10))
                    .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 11)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 4).addTo(implosionRecipes);
            // CG

            GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 12))
                    .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 13)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);
            // CS

            GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 14))
                    .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 15)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "bedrockiumIngot", 9))
                    .itemOutputs(getModItem(ExtraUtilities.ID, "block_bedrockium", 1)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 8).addTo(implosionRecipes);

        }

        if (StevesCarts2.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 18))
                    .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 19)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

        }

        if (Translocator.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Diamond, 1L))
                    .itemOutputs(
                            getModItem(Translocator.ID, "diamondNugget", 2, 0),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.AshDark, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

        }

        if (DraconicEvolution.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(DraconicEvolution.ID, "chaosFragment", 9, 2))
                    .itemOutputs(getModItem(DraconicEvolution.ID, "chaosShard", 1, 0)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 8).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(DraconicEvolution.ID, "chaosFragment", 9, 1))
                    .itemOutputs(getModItem(DraconicEvolution.ID, "chaosFragment", 1, 2)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 4).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(DraconicEvolution.ID, "chaosFragment", 9, 0))
                    .itemOutputs(getModItem(DraconicEvolution.ID, "chaosFragment", 1, 1)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

        }

        // Nether Star Dust -> Gem EIC recipe
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherStar, 4))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.gem, Materials.NetherStar, 3)).duration(25)
                .eut(TierEU.RECIPE_UEV).addTo(electricImplosionCompressorRecipes);
    }
}
