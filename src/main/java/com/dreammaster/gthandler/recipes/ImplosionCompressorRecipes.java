package com.dreammaster.gthandler.recipes;

import static bartworks.API.recipe.BartWorksRecipeMaps.electricImplosionCompressorRecipes;
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

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;

public class ImplosionCompressorRecipes implements Runnable {

    @Override
    public void run() {
        if (GalaxySpace.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(GTOreDictUnificator.get(OrePrefixes.compressed, Materials.Aluminium, 2L))
                    .itemOutputs(
                            GTModHandler.getModItem(GalaxySpace.ID, "item.CompressedDualAluminium", 1L, 0),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.compressed, Materials.Bronze, 2L))
                    .itemOutputs(
                            GTModHandler.getModItem(GalaxySpace.ID, "item.CompressedDualBronze", 1L, 0),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(CustomItemList.RawSDHCAlloy.get(1L))
                    .itemOutputs(
                            GTModHandler.getModItem(GalaxySpace.ID, "item.CompressedSDHD120", 1L, 0),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.StainlessSteel, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 5).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.block, Materials.Coal, 1L))
                    .itemOutputs(
                            GTModHandler.getModItem(GalaxySpace.ID, "item.CompressedCoal", 1L, 0),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.BlackPlutonium, 1L))
                    .itemOutputs(
                            CustomItemList.BlackPlutoniumCompressedPlate.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Adamantium, 1L))
                    .itemOutputs(
                            GTModHandler.getModItem(GalaxySpace.ID, "item.CompressedPlates", 1L, 0),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Cobalt, 1L))
                    .itemOutputs(
                            GTModHandler.getModItem(GalaxySpace.ID, "item.CompressedPlates", 1L, 1),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Duralumin, 1L))
                    .itemOutputs(
                            GTModHandler.getModItem(GalaxySpace.ID, "item.CompressedPlates", 1L, 2),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Lead, 1L))
                    .itemOutputs(
                            GTModHandler.getModItem(GalaxySpace.ID, "item.CompressedPlates", 1L, 3),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Magnesium, 1L))
                    .itemOutputs(
                            GTModHandler.getModItem(GalaxySpace.ID, "item.CompressedPlates", 1L, 4),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Mithril, 1L))
                    .itemOutputs(
                            GTModHandler.getModItem(GalaxySpace.ID, "item.CompressedPlates", 1L, 5),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Nickel, 1L))
                    .itemOutputs(
                            GTModHandler.getModItem(GalaxySpace.ID, "item.CompressedPlates", 1L, 6),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Oriharukon, 1L))
                    .itemOutputs(
                            GTModHandler.getModItem(GalaxySpace.ID, "item.CompressedPlates", 1L, 7),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Platinum, 1L))
                    .itemOutputs(
                            GTModHandler.getModItem(GalaxySpace.ID, "item.CompressedPlates", 1L, 8),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Tungsten, 1L))
                    .itemOutputs(
                            GTModHandler.getModItem(GalaxySpace.ID, "item.CompressedPlates", 1L, 9),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

        }
        if (GalacticraftMars.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 2L, 6))
                    .itemOutputs(
                            CustomItemList.TitaniumDualCompressedPlates.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalacticraftMars.ID, "item.null", 2L, 5))
                    .itemOutputs(
                            CustomItemList.DeshDualCompressedPlates.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

        }

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.IceCompressedPlate.get(2L))
                .itemOutputs(
                        CustomItemList.IceDualCompressedPlates.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.QuantinumCompressedPlate.get(2L))
                .itemOutputs(
                        CustomItemList.QuantinumDualCompressedPlates.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.MytrylCompressedPlate.get(2L))
                .itemOutputs(
                        CustomItemList.MytrylDualCompressedPlates.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.MysteriousCrystalCompressedPlate.get(2L))
                .itemOutputs(
                        CustomItemList.MysteriousCrystalDualCompressedPlates.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

        if (GalacticraftCore.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalacticraftCore.ID, "item.basicItem", 2L, 9))
                    .itemOutputs(
                            CustomItemList.SteelDualCompressedPlates.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalacticraftCore.ID, "item.basicItem", 2L, 7))
                    .itemOutputs(
                            CustomItemList.TinDualCompressedPlates.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalacticraftCore.ID, "item.basicItem", 2L, 6))
                    .itemOutputs(
                            CustomItemList.CopperDualCompressedPlates.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalacticraftCore.ID, "item.basicItem", 2L, 11))
                    .itemOutputs(
                            CustomItemList.IronDualCompressedPlates.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(GalacticraftCore.ID, "item.meteoricIronIngot", 2L, 1))
                    .itemOutputs(
                            CustomItemList.MeteoricIronDualCompressedPlates.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

        }

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.HeavyDutyAlloyIngotT5.get(1L))
                .itemOutputs(
                        CustomItemList.HeavyDutyPlateTier5.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Europium, 5L))
                .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 40).addTo(implosionRecipes);

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.HeavyDutyAlloyIngotT6.get(1L))
                .itemOutputs(
                        CustomItemList.HeavyDutyPlateTier6.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Tritanium, 6L))
                .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 48).addTo(implosionRecipes);

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.HeavyDutyAlloyIngotT7.get(1L))
                .itemOutputs(
                        CustomItemList.HeavyDutyPlateTier7.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Neutronium, 7L))
                .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 56).addTo(implosionRecipes);

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.HeavyDutyAlloyIngotT8.get(1L))
                .itemOutputs(
                        CustomItemList.HeavyDutyPlateTier8.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.BlackPlutonium, 8L))
                .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 64).addTo(implosionRecipes);

        // Avaritia recipes
        if (Avaritia.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(Avaritia.ID, "Resource", 9L, 2))
                    .itemOutputs(GTModHandler.getModItem(Avaritia.ID, "Resource", 1L, 3)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(Avaritia.ID, "Resource", 9L, 3))
                    .itemOutputs(GTModHandler.getModItem(Avaritia.ID, "Resource", 1L, 4)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 4).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(Avaritia.ID, "Resource", 9L, 4))
                    .itemOutputs(GTModHandler.getModItem(Avaritia.ID, "Resource_Block", 1L, 0)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 16).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(Avaritia.ID, "Resource", 9L, 6))
                    .itemOutputs(GTModHandler.getModItem(Avaritia.ID, "Resource_Block", 1L, 1)).duration(20 * TICKS)
                    .eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 64).addTo(implosionRecipes);

        }
        // extra utils
        if (ExtraUtilities.isModLoaded()) {
            // CC

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9L, 0))
                    .itemOutputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1L, 1))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9L, 1))
                    .itemOutputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1L, 2))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9L, 2))
                    .itemOutputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1L, 3))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9L, 3))
                    .itemOutputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1L, 4))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9L, 4))
                    .itemOutputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1L, 5))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 8).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9L, 5))
                    .itemOutputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1L, 6))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 10).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9L, 6))
                    .itemOutputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1L, 7))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 16).addTo(implosionRecipes);
            // CD

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9L, 8))
                    .itemOutputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1L, 9))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9L, 9))
                    .itemOutputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1L, 10))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9L, 10))
                    .itemOutputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1L, 11))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 4).addTo(implosionRecipes);
            // CG

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9L, 12))
                    .itemOutputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1L, 13))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);
            // CS

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9L, 14))
                    .itemOutputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1L, 15))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 9))
                    .itemOutputs(GTModHandler.getModItem(ExtraUtilities.ID, "block_bedrockium", 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 8).addTo(implosionRecipes);

        }

        if (StevesCarts2.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(StevesCarts2.ID, "ModuleComponents", 1L, 18))
                    .itemOutputs(GTModHandler.getModItem(StevesCarts2.ID, "ModuleComponents", 1L, 19))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 1).addTo(implosionRecipes);

        }

        if (Translocator.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Diamond, 1L))
                    .itemOutputs(
                            GTModHandler.getModItem(Translocator.ID, "diamondNugget", 2L, 0),
                            GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.DarkAsh, 1L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

        }

        if (DraconicEvolution.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(DraconicEvolution.ID, "chaosFragment", 9L, 2))
                    .itemOutputs(GTModHandler.getModItem(DraconicEvolution.ID, "chaosShard", 1L, 0))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 8).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(DraconicEvolution.ID, "chaosFragment", 9L, 1))
                    .itemOutputs(GTModHandler.getModItem(DraconicEvolution.ID, "chaosFragment", 1L, 2))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 4).addTo(implosionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(DraconicEvolution.ID, "chaosFragment", 9L, 0))
                    .itemOutputs(GTModHandler.getModItem(DraconicEvolution.ID, "chaosFragment", 1L, 1))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_LV).metadata(ADDITIVE_AMOUNT, 2).addTo(implosionRecipes);

        }

        // Nether Star Dust -> Gem EIC recipe
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherStar, 4))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.gem, Materials.NetherStar, 3)).duration(25)
                .eut(TierEU.RECIPE_UEV).addTo(electricImplosionCompressorRecipes);
    }
}
