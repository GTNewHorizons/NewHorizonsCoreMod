package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
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

import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.FluidShapes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.material.MaterialParts;
import gregtech.api.material.MaterialUtils;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gregtech.common.items.CombType;
import gregtech.loaders.misc.GTBees;

public class CentrifugeRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AdsorptionFilterDirty.get()).circuit(1)
                .itemOutputs(
                        NHItemList.AdsorptionFilterCasing.get(),
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.DarkAsh, Shapes.dust, 4))
                .outputChances(8000, 10000, 10000)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Pollution, FluidShapes.fluidLiquid, 100))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AdsorptionFilterDirty.get()).circuit(2)
                .itemOutputs(
                        NHItemList.AdsorptionFilterCasing.get(),
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, 8),
                        MaterialLibAPI.getStack(Materials.DarkAsh, Shapes.dust, 8))
                .outputChances(9000, 10000, 10000)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Pollution, FluidShapes.fluidLiquid, 250))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AdsorptionFilterDirty.get()).circuit(3)
                .itemOutputs(
                        NHItemList.AdsorptionFilterCasing.get(),
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, 12),
                        MaterialLibAPI.getStack(Materials.DarkAsh, Shapes.dust, 12))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Pollution, FluidShapes.fluidLiquid, 500))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AdsorptionFilterDirty.get()).circuit(4)
                .itemOutputs(
                        NHItemList.AdsorptionFilterCasing.get(),
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, 16),
                        MaterialLibAPI.getStack(Materials.DarkAsh, Shapes.dust, 16))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Pollution, FluidShapes.fluidLiquid, 1000))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.BandedIron, Shapes.dust, 5),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, 3),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, 2),
                        MaterialLibAPI.getStack(Materials.Rutile, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.Quicklime, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.SodiumOxide, Shapes.dust, 1))
                .outputChances(10000, 10000, 9000, 7500, 5000, 2500)
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.RedMud, FluidShapes.fluidLiquid, 1000))
                .fluidOutputs(GTUtility.getWater(500L)).duration(30 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.fire_charge, 1, 0))
                .itemOutputs(
                        new ItemStack(Items.blaze_powder, 1, 0),
                        new ItemStack(Items.gunpowder, 1, 0),
                        MaterialLibAPI.getStack(Materials.Coal, Shapes.dust, 1))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoonStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Manganese, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Olivine, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.RareEarth, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.PlatinumMetallicPowder, Shapes.dust, 8),
                        MaterialLibAPI.getStack(Materials.Tungstate, Shapes.dust, 4))
                .outputChances(5000, 2000, 1000, 750, 500, 250).duration(2 * MINUTES + 42 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MarsStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.BandedIron, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Magnesium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Ruby, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.IridiumMetalResidue, Shapes.dust, 8))
                .outputChances(5000, 3000, 1000, 750, 500, 250).duration(2 * MINUTES + 1 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.PhobosStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.BandedIron, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Bauxite, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Molybdenite, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Desh, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Uranium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Plutonium, Shapes.dust, 4))
                .outputChances(5000, 2500, 1000, 750, 500, 150).duration(2 * MINUTES + 1 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.DeimosStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Magnesite, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Lapis, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Pitchblende, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Cooperite, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Neodymium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Tungstate, Shapes.dust, 4))
                .outputChances(5000, 3000, 1000, 750, 650, 350)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.SulfuricAcid, FluidShapes.fluidLiquid, 1800))
                .duration(2 * MINUTES + 1 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AsteroidsStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Lead, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Ruby, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.RarestMetalResidue, Shapes.dust, 8))
                .outputChances(5000, 3000, 1000, 750, 500, 150).duration(5 * MINUTES + 24 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CeresStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.MeteoricIron, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Beryllium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.PlatinumMetallicPowder, Shapes.dust, 18),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Tungsten, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.NaquadahOxideMixture, Shapes.dust, 8))
                .outputChances(5000, 2500, 1000, 750, 500, 150).duration(5 * MINUTES + 24 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.EuropaIceDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Ledox, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Lapis, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Lazurite, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Oriharukon, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Barium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.NaquadahOxideMixture, Shapes.dust, 8))
                .outputChances(5000, 2500, 1250, 750, 500, 150)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1800))
                .duration(5 * MINUTES + 24 * SECONDS).eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.EuropaStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Ledox, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Sodalite, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Barium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Uranium, Shapes.dust, 4))
                .outputChances(5000, 3000, 1000, 750, 500, 300)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Nitrogen, FluidShapes.fluidGas, 3600))
                .duration(5 * MINUTES + 24 * SECONDS).eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.GanymedeStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Chromite, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Galena, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Uranium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.PalladiumMetallicPowder, Shapes.dust, 8))
                .outputChances(5000, 3000, 1000, 750, 600, 250).duration(5 * MINUTES + 24 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CallistoStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.CallistoIce, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Galena, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Topaz, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.BlueTopaz, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Lithium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Tungsten, Shapes.dust, 4))
                .outputChances(5000, 3000, 1000, 900, 750, 250).duration(5 * MINUTES + 24 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.IoStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Sulfur, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Tantalite, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Tungsten, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Jasper, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.InfusedGold, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.IridiumMetalResidue, Shapes.dust, 8))
                .outputChances(5000, 3000, 1000, 750, 500, 250)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.SulfuricGas, FluidShapes.fluidGas, 3600))
                .duration(3 * MINUTES + 36 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.VenusStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Quantium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Mytryl, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Amethyst, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Mithril, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Draconium, Shapes.dust, 4))
                .outputChances(10000, 3000, 1000, 750, 500, 250)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.CarbonDioxide, FluidShapes.fluidGas, 18000))
                .duration(3 * MINUTES + 36 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MercuryStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Vanadium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Tungstate, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Draconium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Jade, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.dust, 4))
                .outputChances(5000, 3000, 1000, 750, 500, 250)
                .fluidOutputs(MaterialUtils.gas(Materials.Helium3, 1800L)).duration(3 * MINUTES + 36 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MercuryCoreDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Ilmenite, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Tungstate, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Draconium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Jade, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.dust, 4))
                .outputChances(5000, 3000, 1000, 750, 500, 250)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Helium, FluidShapes.fluidGas, 9000))
                .duration(3 * MINUTES + 36 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.EnceladusIceDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.MysteriousCrystal, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.IridiumMetalResidue, Shapes.dust, 18),
                        MaterialLibAPI.getStack(Materials.Ledox, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Trinium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.NaquadahOxideMixture, Shapes.dust, 8))
                .outputChances(5000, 3000, 1000, 750, 400, 200)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 5400))
                .duration(8 * MINUTES + 6 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.EnceladusStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.IridiumMetalResidue, Shapes.dust, 18),
                        MaterialLibAPI.getStack(Materials.RarestMetalResidue, Shapes.dust, 18),
                        MaterialLibAPI.getStack(Materials.MysteriousCrystal, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Trinium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.NaquadahOxideMixture, Shapes.dust, 8))
                .outputChances(5000, 3000, 1000, 1000, 400, 100)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Nitrogen, FluidShapes.fluidGas, 5400))
                .duration(8 * MINUTES + 6 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.TitanStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Nickel, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.IridiumMetalResidue, Shapes.dust, 18),
                        MaterialLibAPI.getStack(Materials.RarestMetalResidue, Shapes.dust, 18),
                        MaterialLibAPI.getStack(Materials.Emerald, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Gallium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Trinium, Shapes.dust, 4))
                .outputChances(5000, 2500, 1000, 900, 500, 200)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Methane, FluidShapes.fluidGas, 3600))
                .duration(8 * MINUTES + 6 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.OberonStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.IridiumMetalResidue, Shapes.dust, 18),
                        MaterialLibAPI.getStack(Materials.RarestMetalResidue, Shapes.dust, 18),
                        MaterialLibAPI.getStack(Materials.NaquadahOxideMixture, Shapes.dust, 18),
                        MaterialLibAPI.getStack(Materials.Uranium235, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Plutonium241, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Trinium, Shapes.dust, 4))
                .outputChances(4000, 2000, 800, 300, 150, 150)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Argon, FluidShapes.fluidGas, 1800))
                .duration(8 * MINUTES + 6 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MirandaStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Tetrahedrite, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.IridiumMetalResidue, Shapes.dust, 18),
                        MaterialLibAPI.getStack(Materials.Desh, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.RarestMetalResidue, Shapes.dust, 8))
                .outputChances(4000, 2000, 1000, 750, 500, 350)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Argon, FluidShapes.fluidGas, 1800))
                .duration(8 * MINUTES + 6 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.TritonStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Neodymium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.RareEarth, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Niobium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Yttrium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Gallium, Shapes.dust, 4))
                .outputChances(5000, 3000, 1000, 750, 500, 350).duration(5 * MINUTES + 2 * SECONDS + 8 * TICKS)
                .eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ProteusStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Uraninite, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Adamantium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Uranium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Plutonium, Shapes.dust, 4))
                .outputChances(5000, 2500, 1000, 750, 500, 350)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Radon, FluidShapes.fluidGas, 360))
                .duration(5 * MINUTES + 2 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.PlutoIceDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Thorium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Uranium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Plutonium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Ledox, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.NaquadahOxideMixture, Shapes.dust, 8))
                .outputChances(5000, 2500, 1250, 750, 500, 400).duration(10 * MINUTES + 48 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.PlutoStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Thorium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Uranium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.GarnetRed, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.GarnetYellow, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.NaquadahOxideMixture, Shapes.dust, 8))
                .outputChances(5000, 2500, 850, 500, 500, 300).duration(10 * MINUTES + 48 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MakeMakeStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.GarnetRed, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.GarnetYellow, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Gallium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Yttrium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Niobium, Shapes.dust, 4))
                .outputChances(2500, 2500, 1000, 750, 500, 350).duration(10 * MINUTES + 48 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.HaumeaStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.InfusedGold, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.NaquadahOxideMixture, Shapes.dust, 18),
                        MaterialLibAPI.getStack(Materials.NetherStar, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Lanthanum, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Caesium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.CeriumRichMixture, Shapes.dust, 8))
                .outputChances(5000, 2500, 850, 750, 500, 450).duration(10 * MINUTES + 48 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CentauriASurfaceDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.IridiumMetalResidue, Shapes.dust, 18),
                        MaterialLibAPI.getStack(Materials.EnrichedNaquadahOxideMixture, Shapes.dust, 18),
                        MaterialLibAPI.getStack(Materials.Draconium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.IridiumMetalResidue, Shapes.dust, 8),
                        getModItem(Avaritia.ID, "Resource", 36, 2),
                        MaterialLibAPI.getStack(Materials.InfinityCatalyst, Shapes.dust, 4))
                .outputChances(5000, 3000, 1000, 1000, 100, 50)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Mercury, FluidShapes.fluidLiquid, 3600))
                .duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS).eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CentauriAStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.RarestMetalResidue, Shapes.dust, 18),
                        MaterialLibAPI.getStack(Materials.EnrichedNaquadahOxideMixture, Shapes.dust, 18),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.dust, 4),
                        getModItem(Avaritia.ID, "Resource", 36, 2),
                        MaterialLibAPI.getStack(Materials.Tartarite, Shapes.dust, 1))
                .outputChances(5000, 2000, 500, 2500, 150, 80)
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Mercury, FluidShapes.fluidLiquid, 7200))
                .duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS).eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.VegaBStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Uranium235, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Plutonium241, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Europium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.NaquadriaOxideMixture, Shapes.dust, 8),
                        MaterialLibAPI.getStack(Materials.DraconiumAwakened, Shapes.dust, 4))
                .outputChances(5000, 3000, 1500, 800, 500, 50).duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS)
                .eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.BarnardaEStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Niobium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Yttrium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Gallium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Unstable, Shapes.dust, 4))
                .outputChances(2500, 2000, 1500, 750, 250, 250).duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS)
                .eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.BarnardaFStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Gallium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Yttrium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Niobium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Unstable, Shapes.dust, 4))
                .outputChances(2500, 2000, 1500, 750, 250, 250).duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS)
                .eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.TCetiEStoneDust.get(36))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Lapis, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Apatite, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Draconium, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.InfinityCatalyst, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Trinium, Shapes.dust, 4))
                .outputChances(5000, 2500, 1000, 750, 150, 50).duration(6 * MINUTES + 28 * SECONDS + 16 * TICKS)
                .eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CokeOvenBrickDust.get(4))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Clay, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.QuartzSand, Shapes.dust, 2))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AdvancedCokeOvenBrickDust.get(36)).circuit(2)
                .itemOutputs(
                        NHItemList.CokeOvenBrickDust.get(36),
                        MaterialLibAPI.getStack(Materials.Netherrack, Shapes.dust, 36),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, 9),
                        MaterialLibAPI.getStack(Materials.Brick, Shapes.dust, 4))
                .outputChances(10000, 9000, 7500, 6500).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopGrass", 1, 0))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials.Clay, Shapes.dustSmall, 1))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopDirt", 1, 0))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials.Clay, Shapes.dustSmall, 1))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopDirt", 1, 1))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials.Clay, Shapes.dustSmall, 1))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopDirt", 1, 2))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials.Flint, Shapes.dustSmall, 1))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopDirt", 1, 3))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials.Flint, Shapes.dustSmall, 1))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopGrass", 1, 2))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials.QuartzSand, Shapes.dustSmall, 1))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopDirt", 1, 4))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials.QuartzSand, Shapes.dustSmall, 1))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "newBopDirt", 1, 5))
                .itemOutputs(
                        new ItemStack(Blocks.dirt, 1, 0),
                        MaterialLibAPI.getStack(Materials.QuartzSand, Shapes.dustSmall, 1))
                .outputChances(10000, 3300).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "driedDirt", 1, 0))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Clay, Shapes.dustSmall, 1),
                        new ItemStack(Blocks.sand, 1, 0),
                        MaterialLibAPI.getStack(Materials.Ash, Shapes.dust, 1))
                .outputChances(9000, 5000, 277).duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockEldritch", 1, 4))
                .itemOutputs(
                        new ItemStack(Items.glowstone_dust, 1, 0),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14))
                .outputChances(10000, 3300, 1000, 200).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.GlowstoneDusts", 1, 0))
                .itemOutputs(
                        new ItemStack(Items.glowstone_dust, 2, 0),
                        NHItemList.CeresStoneDust.get(),
                        NHItemList.CeresStoneDust.get())
                .outputChances(10000, 9000, 7500).duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.GlowstoneDusts", 1, 4))
                .itemOutputs(
                        new ItemStack(Items.glowstone_dust, 2, 0),
                        NHItemList.PlutoStoneDust.get(),
                        NHItemList.PlutoStoneDust.get())
                .outputChances(10000, 9000, 7500).duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.GlowstoneDusts", 1, 1))
                .itemOutputs(
                        new ItemStack(Items.glowstone_dust, 2, 0),
                        NHItemList.IoStoneDust.get(),
                        NHItemList.IoStoneDust.get())
                .outputChances(10000, 9000, 7500).duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.GlowstoneDusts", 1, 2))
                .itemOutputs(
                        new ItemStack(Items.glowstone_dust, 2, 0),
                        NHItemList.EnceladusStoneDust.get(),
                        NHItemList.EnceladusStoneDust.get())
                .outputChances(10000, 9000, 7500).duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.GlowstoneDusts", 1, 3))
                .itemOutputs(
                        new ItemStack(Items.glowstone_dust, 2, 0),
                        NHItemList.ProteusStoneDust.get(),
                        NHItemList.ProteusStoneDust.get())
                .outputChances(10000, 9000, 7500).duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.QuartzSand, Shapes.dust, 9))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Stone, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.NetherQuartz, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.Quartzite, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.Cassiterite, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, 1))
                .outputChances(9000, 3000, 2000, 1500, 1000, 750).duration(1 * MINUTES + 48 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                GTOreDictUnificator.get(MaterialParts.craftIngredient(OrePrefixes.dust, Materials.DeepIron), 4L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, 3),
                        MaterialLibAPI.getStack(Materials.Trinium, Shapes.dust, 1))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.dust, 1))
                .itemOutputs(
                        getModItem(Avaritia.ID, "Resource", 1, 2),
                        getModItem(Avaritia.ID, "Resource", 1, 2),
                        getModItem(Avaritia.ID, "Resource", 1, 2))
                .outputChances(5000, 2000, 1000).duration(60 * SECONDS).eut(TierEU.RECIPE_EV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MaceratedPlantmass.get())
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemBiochaff", 1, 0)).duration(15 * SECONDS).eut(4)
                .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Electrotine, Shapes.dust, 8))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Redstone, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.Electrum, Shapes.dust, 1))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Cell_Air.get(10L))
                .itemOutputs(MaterialParts.requireCell(Materials.Oxygen, 1), ItemList.Cell_Empty.get(9L))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Nitrogen, FluidShapes.fluidGas, 3900))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(centrifugeRecipes);

        if (PamsHarvestCraft.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "coconutItem", 1, 0))
                    .itemOutputs(getModItem(PamsHarvestCraft.ID, "coconutmilkItem", 9, 0)).duration(5 * SECONDS).eut(2)
                    .addTo(centrifugeRecipes);

        }

        if (TinkerConstruct.isModLoaded()) {
            // Centrifuge

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "strangeFood", 1, 0))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.RawRubber, Shapes.dust, 2))
                    .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, 50))
                    .duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.slime_ball, 1, 0))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.RawRubber, Shapes.dust, 2))
                    .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, 50))
                    .duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "slime.gel", 1, 2))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Rubber, Shapes.dust, 8))
                    .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, 200))
                    .duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "slime.gel", 1, 1))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.RawRubber, Shapes.dust, 8))
                    .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, 200))
                    .duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "slime.gel", 1, 0))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.RawRubber, Shapes.dust, 8))
                    .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, 200))
                    .duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 0))
                    .itemOutputs(
                            new ItemStack(Blocks.dirt, 1, 32767),
                            MaterialLibAPI.getStack(Materials.RawRubber, Shapes.dust, 1),
                            getModItem(TinkerConstruct.ID, "strangeFood", 1, 0))
                    .outputChances(10000, 10000, 1000)
                    .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, 25))
                    .duration(15 * SECONDS).eut(5).addTo(centrifugeRecipes);

        }

        if (Gendustry.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(NHItemList.FieryBloodDrop.get())
                    .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.FierySteel, FluidShapes.fluidLiquid, 10))
                    .duration(12 * TICKS).eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);
        }
        if (Forestry.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(getModItem(Forestry.ID, "beeCombs", 1, 9))
                    .itemOutputs(
                            getModItem(Forestry.ID, "beeswax", 1, 0),
                            MaterialLibAPI.getStack(Materials.IridiumMetalResidue, Shapes.dust, 2))
                    .outputChances(10000, 11).duration(15 * SECONDS).eut(TierEU.RECIPE_IV).addTo(centrifugeRecipes);
            GTValues.RA.stdBuilder().itemInputs(GTBees.combs.getStackForType(CombType.INDIUM, 8)).circuit(2)
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials.ThoriumBasedLiquidFuelDepleted,
                                    FluidShapes.fluidLiquid,
                                    1000))
                    .itemOutputs(
                            MaterialLibAPI.getStack(Materials.Thorium232, Shapes.dust, 64),
                            MaterialLibAPI.getStack(Materials.Thorium232, Shapes.dust, 16),
                            MaterialLibAPI.getStack(Materials.Praseodymium, Shapes.dust, 64),
                            MaterialLibAPI.getStack(Materials.Praseodymium, Shapes.dust, 32),
                            MaterialLibAPI.getStack(Materials.Boron, Shapes.dust, 2),
                            MaterialLibAPI.getStack(Materials.Indium, Shapes.dust, 12))
                    .outputChances(10000, 8000, 10000, 8000, 3000, 5000).duration(1 * MINUTES + 15 * SECONDS)
                    .eut(TierEU.RECIPE_EV / 2).addTo(centrifugeRecipes);
        }
    }
}
