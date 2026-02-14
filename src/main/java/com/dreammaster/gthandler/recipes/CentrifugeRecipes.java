package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.Gendustry;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.centrifugeRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.item.NHItemList;

import bartworks.system.material.WerkstoffLoader;
import goodgenerator.items.GGMaterial;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.common.items.CombType;
import gregtech.loaders.misc.GTBees;

public class CentrifugeRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AdsorptionFilterDirty.get()).circuit(1)
                .itemOutputs(
                        NHItemList.AdsorptionFilterCasing.get(),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.AshDark, 4L))
                .outputChances(8000, 10000, 10000)
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("pollution"), 100)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AdsorptionFilterDirty.get()).circuit(2)
                .itemOutputs(
                        NHItemList.AdsorptionFilterCasing.get(),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 8L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.AshDark, 8L))
                .outputChances(9000, 10000, 10000)
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("pollution"), 250)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AdsorptionFilterDirty.get()).circuit(3)
                .itemOutputs(
                        NHItemList.AdsorptionFilterCasing.get(),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 12L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.AshDark, 12L))
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("pollution"), 500)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AdsorptionFilterDirty.get()).circuit(4)
                .itemOutputs(
                        NHItemList.AdsorptionFilterCasing.get(),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 16L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.AshDark, 16L))
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("pollution"), 1000)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().circuit(1)
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 2L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Rutile, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Quicklime, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumOxide, 1L))
                .outputChances(10000, 10000, 9000, 7500, 5000, 2500).fluidInputs(Materials.RedMud.getFluid(1000L))
                .fluidOutputs(Materials.Water.getFluid(500L)).duration(30 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.fire_charge, 1, 0))
                .itemOutputs(
                        new ItemStack(Items.blaze_powder, 1, 0),
                        new ItemStack(Items.gunpowder, 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoonStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Olivine, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungstate, 4L))
                .outputChances(5000, 2000, 1000, 750, 500, 250).duration(2 * MINUTES + 42 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MarsStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 4L))
                .outputChances(5000, 3000, 1000, 750, 500, 250).duration(2 * MINUTES + 1 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.PhobosStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Bauxite, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Molybdenite, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Desh, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 4L))
                .outputChances(5000, 2500, 1000, 750, 500, 150).duration(2 * MINUTES + 1 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.DeimosStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Magnesite, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Pitchblende, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Cooperite, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungstate, 4L))
                .outputChances(5000, 3000, 1000, 750, 650, 350).fluidOutputs(Materials.SulfuricAcid.getFluid(1800L))
                .duration(2 * MINUTES + 1 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AsteroidsStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 4L))
                .outputChances(5000, 3000, 1000, 750, 500, 150).duration(5 * MINUTES + 24 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CeresStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.MeteoricIron, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Beryllium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 4L))
                .outputChances(5000, 2500, 1000, 750, 500, 150).duration(5 * MINUTES + 24 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.EuropaIceDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lazurite, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Oriharukon, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Barium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 4L))
                .outputChances(5000, 2500, 1250, 750, 500, 150).fluidOutputs(Materials.Oxygen.getGas(1800L))
                .duration(5 * MINUTES + 24 * SECONDS).eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.EuropaStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sodalite, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Barium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 4L))
                .outputChances(5000, 3000, 1000, 750, 500, 300).fluidOutputs(Materials.Nitrogen.getGas(3600L))
                .duration(5 * MINUTES + 24 * SECONDS).eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.GanymedeStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chromite, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Galena, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Palladium, 4L))
                .outputChances(5000, 3000, 1000, 750, 600, 250).duration(5 * MINUTES + 24 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CallistoStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CallistoIce, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Galena, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Topaz, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlueTopaz, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lithium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 4L))
                .outputChances(5000, 3000, 1000, 900, 750, 250).duration(5 * MINUTES + 24 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.IoStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tantalite, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Jasper, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.InfusedGold, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 4L))
                .outputChances(5000, 3000, 1000, 750, 500, 250).fluidOutputs(Materials.SulfuricGas.getGas(3600L))
                .duration(3 * MINUTES + 36 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.VenusStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Quantium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Mytryl, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Amethyst, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Mithril, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 4L))
                .outputChances(10000, 3000, 1000, 750, 500, 250).fluidOutputs(Materials.CarbonDioxide.getGas(18000L))
                .duration(3 * MINUTES + 36 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MercuryStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungstate, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Jade, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 4L))
                .outputChances(5000, 3000, 1000, 750, 500, 250).fluidOutputs(Materials.Helium3.getGas(1800L))
                .duration(3 * MINUTES + 36 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MercuryCoreDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungstate, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Jade, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 4L))
                .outputChances(5000, 3000, 1000, 750, 500, 250).fluidOutputs(Materials.Helium.getGas(9000L))
                .duration(3 * MINUTES + 36 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.EnceladusIceDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 4L))
                .outputChances(5000, 3000, 1000, 750, 400, 200).fluidOutputs(Materials.Oxygen.getGas(5400L))
                .duration(8 * MINUTES + 6 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.EnceladusStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 4L))
                .outputChances(5000, 3000, 1000, 1000, 400, 100).fluidOutputs(Materials.Nitrogen.getGas(5400L))
                .duration(8 * MINUTES + 6 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.TitanStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Emerald, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 4L))
                .outputChances(5000, 2500, 1000, 900, 500, 200).fluidOutputs(Materials.Methane.getGas(3600L))
                .duration(8 * MINUTES + 6 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.OberonStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium241, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 4L))
                .outputChances(4000, 2000, 800, 300, 150, 150).fluidOutputs(Materials.Argon.getGas(1800L))
                .duration(8 * MINUTES + 6 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MirandaStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Desh, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 4L))
                .outputChances(4000, 2000, 1000, 750, 500, 350).fluidOutputs(Materials.Argon.getGas(1800L))
                .duration(8 * MINUTES + 6 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.TritonStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 4L))
                .outputChances(5000, 3000, 1000, 750, 500, 350).duration(5 * MINUTES + 2 * SECONDS + 8 * TICKS)
                .eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ProteusStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uraninite, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Adamantium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 4L))
                .outputChances(5000, 2500, 1000, 750, 500, 350).fluidOutputs(Materials.Radon.getGas(360L))
                .duration(5 * MINUTES + 2 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.PlutoIceDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 4L))
                .outputChances(5000, 2500, 1250, 750, 500, 400).duration(10 * MINUTES + 48 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.PlutoStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.GarnetRed, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.GarnetYellow, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 4L))
                .outputChances(5000, 2500, 850, 500, 500, 300).duration(10 * MINUTES + 48 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MakeMakeStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.GarnetRed, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.GarnetYellow, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 4L))
                .outputChances(2500, 2500, 1000, 750, 500, 350).duration(10 * MINUTES + 48 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.HaumeaStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.InfusedGold, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherStar, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lanthanum, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Caesium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Cerium, 4L))
                .outputChances(5000, 2500, 850, 750, 500, 450).duration(10 * MINUTES + 48 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CentauriASurfaceDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 4L),
                        GTModHandler.getModItem(Avaritia.ID, "Resource", 36L, 2),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.InfinityCatalyst, 4L))
                .outputChances(5000, 3000, 1000, 1000, 100, 50).fluidOutputs(Materials.Mercury.getFluid(3600L))
                .duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS).eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CentauriAStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Neutronium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 4L),
                        GTModHandler.getModItem(Avaritia.ID, "Resource", 36L, 2),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.InfinityCatalyst, 4L))
                .outputChances(5000, 2000, 500, 2500, 150, 80).fluidOutputs(Materials.Mercury.getFluid(7200L))
                .duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS).eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.VegaBStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium241, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Europium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Neutronium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadria, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.DraconiumAwakened, 4L))
                .outputChances(5000, 3000, 1500, 800, 500, 50).duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS)
                .eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.BarnardaEStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Neutronium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Unstable, 4L))
                .outputChances(2500, 2000, 1500, 750, 250, 250).duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS)
                .eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.BarnardaFStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Neutronium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Unstable, 4L))
                .outputChances(2500, 2000, 1500, 750, 250, 250).duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS)
                .eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.TCetiEStoneDust.get(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.InfinityCatalyst, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 4L))
                .outputChances(5000, 2500, 1000, 750, 150, 50).duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS)
                .eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CokeOvenBrickDust.get(4))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 2L))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AdvancedCokeOvenBrickDust.get(36)).circuit(2)
                .itemOutputs(
                        NHItemList.CokeOvenBrickDust.get(36),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Netherrack, 36L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Brick, 4L))
                .outputChances(10000, 9000, 7500, 6500).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(BiomesOPlenty.ID, "newBopGrass", 1L, 0))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Clay, 1L))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(BiomesOPlenty.ID, "newBopDirt", 1L, 0))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Clay, 1L))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(BiomesOPlenty.ID, "newBopDirt", 1L, 1))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Clay, 1L))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(BiomesOPlenty.ID, "newBopDirt", 1L, 2))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Flint, 1L))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(BiomesOPlenty.ID, "newBopDirt", 1L, 3))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Flint, 1L))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(BiomesOPlenty.ID, "newBopGrass", 1L, 2))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.QuartzSand, 1L))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(BiomesOPlenty.ID, "newBopDirt", 1L, 4))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.QuartzSand, 1L))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(BiomesOPlenty.ID, "newBopDirt", 1L, 5))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.QuartzSand, 1L))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(BiomesOPlenty.ID, "driedDirt", 1L, 0))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Clay, 1L),
                        new ItemStack(Blocks.sand, 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L))
                .outputChances(9000, 5000, 277).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(Thaumcraft.ID, "blockEldritch", 1L, 4))
                .itemOutputs(
                        new ItemStack(Items.glowstone_dust, 1, 0),
                        GTModHandler.getModItem(Thaumcraft.ID, "ItemResource", 1L, 14),
                        GTModHandler.getModItem(Thaumcraft.ID, "ItemResource", 1L, 14),
                        GTModHandler.getModItem(Thaumcraft.ID, "ItemResource", 1L, 14))
                .outputChances(10000, 3300, 1000, 200).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "item.GlowstoneDusts", 1L, 0))
                .itemOutputs(
                        new ItemStack(Items.glowstone_dust, 2, 0),
                        NHItemList.CeresStoneDust.get(),
                        NHItemList.CeresStoneDust.get())
                .outputChances(10000, 9000, 7500).duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "item.GlowstoneDusts", 1L, 4))
                .itemOutputs(
                        new ItemStack(Items.glowstone_dust, 2, 0),
                        NHItemList.PlutoStoneDust.get(),
                        NHItemList.PlutoStoneDust.get())
                .outputChances(10000, 9000, 7500).duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "item.GlowstoneDusts", 1L, 1))
                .itemOutputs(
                        new ItemStack(Items.glowstone_dust, 2, 0),
                        NHItemList.IoStoneDust.get(),
                        NHItemList.IoStoneDust.get())
                .outputChances(10000, 9000, 7500).duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "item.GlowstoneDusts", 1L, 2))
                .itemOutputs(
                        new ItemStack(Items.glowstone_dust, 2, 0),
                        NHItemList.EnceladusStoneDust.get(),
                        NHItemList.EnceladusStoneDust.get())
                .outputChances(10000, 9000, 7500).duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "item.GlowstoneDusts", 1L, 3))
                .itemOutputs(
                        new ItemStack(Items.glowstone_dust, 2, 0),
                        NHItemList.ProteusStoneDust.get(),
                        NHItemList.ProteusStoneDust.get())
                .outputChances(10000, 9000, 7500).duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 9L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Cassiterite, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L))
                .outputChances(9000, 3000, 2000, 1500, 1000, 750).duration(1 * MINUTES + 48 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust.get(Materials.DeepIron), 4L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1L))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1L))
                .itemOutputs(
                        GTModHandler.getModItem(Avaritia.ID, "Resource", 1L, 2),
                        GTModHandler.getModItem(Avaritia.ID, "Resource", 1L, 2),
                        GTModHandler.getModItem(Avaritia.ID, "Resource", 1L, 2))
                .outputChances(5000, 2000, 1000).duration(60 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MaceratedPlantmass.get())
                .itemOutputs(GTModHandler.getModItem(IndustrialCraft2.ID, "itemBiochaff", 1L, 0)).duration(15 * SECONDS)
                .eut(4).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Electrotine, 8L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Electrum, 1L))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Cell_Air.get(5L))
                .itemOutputs(Materials.Oxygen.getCells(1), ItemList.Cell_Empty.get(4L))
                .fluidOutputs(Materials.Nitrogen.getGas(3900L)).duration(1 * MINUTES + 20 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(centrifugeRecipes);

        if (PamsHarvestCraft.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(PamsHarvestCraft.ID, "coconutItem", 1L, 0))
                    .itemOutputs(GTModHandler.getModItem(PamsHarvestCraft.ID, "coconutmilkItem", 9L, 0))
                    .duration(5 * SECONDS).eut(2).addTo(centrifugeRecipes);

        }

        if (TinkerConstruct.isModLoaded()) {
            // Centrifuge

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "strangeFood", 1L, 0))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.RubberRaw, 2L))
                    .fluidOutputs(Materials.Glue.getFluid(50)).duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.slime_ball, 1, 0))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.RubberRaw, 2L))
                    .fluidOutputs(Materials.Glue.getFluid(50)).duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "slime.gel", 1L, 2))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Rubber, 8L))
                    .fluidOutputs(Materials.Glue.getFluid(200)).duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "slime.gel", 1L, 1))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.RubberRaw, 8L))
                    .fluidOutputs(Materials.Glue.getFluid(200)).duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "slime.gel", 1L, 0))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.RubberRaw, 8L))
                    .fluidOutputs(Materials.Glue.getFluid(200)).duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "CraftedSoil", 1L, 0))
                    .itemOutputs(
                            new ItemStack(Blocks.dirt, 1, 32767),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.RubberRaw, 1L),
                            GTModHandler.getModItem(TinkerConstruct.ID, "strangeFood", 1L, 0))
                    .outputChances(10000, 10000, 1000).fluidOutputs(Materials.Glue.getFluid(25)).duration(15 * SECONDS)
                    .eut(5).addTo(centrifugeRecipes);

        }

        if (Gendustry.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(NHItemList.FieryBloodDrop.get())
                    .fluidOutputs(Materials.FierySteel.getFluid(10L)).duration(12 * TICKS).eut(TierEU.RECIPE_HV)
                    .addTo(centrifugeRecipes);
        }
        if (Forestry.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(Forestry.ID, "beeCombs", 1L, 9))
                    .itemOutputs(
                            GTModHandler.getModItem(Forestry.ID, "beeswax", 1L, 0),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1L))
                    .outputChances(10000, 11).duration(15 * SECONDS).eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);
            GTValues.RA.stdBuilder().itemInputs(GTBees.combs.getStackForType(CombType.INDIUM, 8)).circuit(2)
                    .fluidInputs(GGMaterial.thoriumBasedLiquidFuelDepleted.getFluidOrGas(1000))
                    .itemOutputs(
                            WerkstoffLoader.Thorium232.get(OrePrefixes.dust, 64),
                            WerkstoffLoader.Thorium232.get(OrePrefixes.dust, 16),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Praseodymium, 64),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Praseodymium, 32),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Boron, 2),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 12))
                    .outputChances(10000, 8000, 10000, 8000, 3000, 5000).duration(1 * MINUTES + 15 * SECONDS)
                    .eut(TierEU.RECIPE_EV / 2).addTo(centrifugeRecipes);
        }
    }
}
