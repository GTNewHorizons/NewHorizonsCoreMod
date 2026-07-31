package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.SGCraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.blastFurnaceRecipes;
import static gregtech.api.util.GTRecipeBuilder.HOURS;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.ADDITIVE_AMOUNT;
import static gregtech.api.util.GTRecipeConstants.BlastFurnaceWithGas;
import static gregtech.api.util.GTRecipeConstants.COIL_HEAT;
import static gregtech.api.util.GTRecipeConstants.NO_GAS;
import static gregtech.api.util.GTRecipeConstants.NO_GAS_CIRCUIT_CONFIG;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

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
import gregtech.api.objects.OreDictItemStack;
import gregtech.api.util.GTOreDictUnificator;

public class BlastFurnaceRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder().itemInputs(NHItemList.UncookedSlush.get()).circuit(1)
                .itemOutputs(NHItemList.GlowingMarshmallow.get()).duration(2 * MINUTES + 50 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4500).metadata(ADDITIVE_AMOUNT, 1000)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.RedstoneAlloy, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.RedstoneAlloy, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.RedstoneAlloy, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.RedstoneAlloy, Materials2Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.ConductiveIron, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.ConductiveIron, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.ConductiveIron, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.ConductiveIron, Materials2Shapes.ingot, (int) (1L)))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.EnergeticAlloy, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.EnergeticAlloy, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Hydrogen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.EnergeticAlloy, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.EnergeticAlloy, Materials2Shapes.ingot, (int) (1L)))
                .duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.EnergeticSilver, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.EnergeticSilver, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Hydrogen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.EnergeticSilver, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.EnergeticSilver, Materials2Shapes.ingot, (int) (1L)))
                .duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.VibrantAlloy, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.VibrantAlloy, Materials2Shapes.ingotHot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Hydrogen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.VibrantAlloy, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.VibrantAlloy, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(5 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.VividAlloy, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.VividAlloy, Materials2Shapes.ingotHot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Hydrogen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.VividAlloy, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.VividAlloy, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(5 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.CrystallineAlloy, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.CrystallineAlloy, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4500).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.CrystallinePinkSlime, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.CrystallinePinkSlime,
                                Materials2Shapes.ingotHot,
                                (int) (1L)))
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.MelodicAlloy, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.MelodicAlloy, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.StellarAlloy, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.StellarAlloy, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 7200)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.ElectricalSteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.ElectricalSteel, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.ElectricalSteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.ElectricalSteel, Materials2Shapes.ingot, (int) (1L)))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.PulsatingIron, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.PulsatingIron, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1800)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.PulsatingIron, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.PulsatingIron, Materials2Shapes.ingot, (int) (1L)))
                .duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Soularium, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Soularium, Materials2Shapes.ingot, (int) (1L)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.DarkSteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.DarkSteel, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1800).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.DarkSteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.DarkSteel, Materials2Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.EndSteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.EndSteel, Materials2Shapes.ingot, (int) (1L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4500).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.EnderiumBase, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.EnderiumBase, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3300)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Enderium, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Enderium, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 4500)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Reinforced, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Reinforced, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1700).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Reinforced, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Reinforced, Materials2Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1700)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Galgadorian, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Galgadorian, Materials2Shapes.ingotHot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Hydrogen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2800)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Galgadorian, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Galgadorian, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.EnhancedGalgadorian, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.EnhancedGalgadorian,
                                Materials2Shapes.ingotHot,
                                (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Hydrogen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 4200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Draconium, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Draconium, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 7200)
                .metadata(ADDITIVE_AMOUNT, 1000).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.DraconiumAwakened, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.DraconiumAwakened, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(4 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9900)
                .metadata(ADDITIVE_AMOUNT, 1000).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Cobalt, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Cobalt, Materials2Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1700)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Hydrogen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1600)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Ardite, Materials2Shapes.ingot, (int) (1L)))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Manyullyn, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Manyullyn, Materials2Shapes.ingotHot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Hydrogen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(1 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 3300)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Manyullyn, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Manyullyn, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 3600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Desh, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Desh, Materials2Shapes.ingotHot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Desh, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Desh, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.ElectrumFlux, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.ElectrumFlux, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9000).metadata(ADDITIVE_AMOUNT, 1000)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.FierySteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.FierySteel, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.FierySteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.FierySteel, Materials2Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1900)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Sunnarium, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Sunnarium, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4500)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.HSSG, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.HSSG, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4200)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.HSSE, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.HSSE, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES + 5 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.HSSS, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.HSSS, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Naquadah, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Naquadah, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5000).metadata(ADDITIVE_AMOUNT, 1000)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.NaquadahAlloy, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.NaquadahAlloy, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_ZPM / 2).metadata(COIL_HEAT, 7200)
                .metadata(ADDITIVE_AMOUNT, 1000).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.NaquadahEnriched, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.NaquadahEnriched, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5350).metadata(ADDITIVE_AMOUNT, 1000)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Naquadria, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Naquadria, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9000).metadata(ADDITIVE_AMOUNT, 1000)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Trinium, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Trinium, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(70 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 7200).metadata(ADDITIVE_AMOUNT, 1000)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Osmium, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Osmium, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 4500).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Iridium, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Iridium, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 4500).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Oriharukon, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Oriharukon, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Vyroxeres, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Vyroxeres, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Orichalcum, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Orichalcum, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 6000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Alduorite, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Alduorite, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 6600)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Mithril, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Mithril, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 6600)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Ceruclase, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ceruclase, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 6600)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Vulcanite, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Vulcanite, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 8400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.ShadowIron, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.ShadowIron, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 8400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Chrysotile, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Chrysotile, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_UV).metadata(COIL_HEAT, 9400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Tartarite, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Tartarite, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_UHV).metadata(COIL_HEAT, 10400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.BlackPlutonium, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.BlackPlutonium, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(5 * MINUTES).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9000).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.VanadiumSteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.VanadiumSteel, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1453).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.VanadiumSteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.VanadiumSteel, Materials2Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1453)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.DamascusSteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.DamascusSteel, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.DamascusSteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.DamascusSteel, Materials2Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.BlackSteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.BlackSteel, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.BlackSteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.BlackSteel, Materials2Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.RedSteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.RedSteel, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(55 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1300).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.RedSteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.RedSteel, Materials2Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1300)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.BlueSteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.BlueSteel, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1400).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.BlueSteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.BlueSteel, Materials2Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1400)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.SiliconSolarGrade, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconSolarGrade, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2273)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        // 2Al(OH)3 = Al2O3 + 3H2O

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.AluminiumHydroxide, Materials2Shapes.dust, (int) (8L)))
                .circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Alumina, Materials2Shapes.dust, (int) (5L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1300).addTo(blastFurnaceRecipes);
        // 2NaAlO2 + CO2 = Al2O3 + Na2CO3

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.SodiumAluminate, Materials2Shapes.dust, (int) (8L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Alumina, Materials2Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials2Materials.SodiumCarbonate, Materials2Shapes.dust, (int) (6L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.CarbonDioxide,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);
        // 2Al2O3 + 3C = 4Al + 3CO2

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Alumina, Materials2Shapes.dust, (int) (10L)),
                        MaterialLibAPI.getStack(Materials2Materials.Carbon, Materials2Shapes.dust, (int) (3L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Aluminium, Materials2Shapes.ingot, (int) (4L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.CarbonDioxide,
                                Materials2FluidShapes.fluidGas,
                                (int) (3000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2054).addTo(blastFurnaceRecipes);
        // 6Al2O3 =Na3AlF6= 12Al

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Alumina, Materials2Shapes.dust, (int) (10L)),
                        MaterialLibAPI.getStack(Materials2Materials.Cryolite, Materials2Shapes.dust, (int) (5L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Aluminium, Materials2Shapes.ingot, (int) (4L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 963)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Aluminium, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Aluminium, Materials2Shapes.ingot, (int) (1L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2054).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        // NEEDED TO MOVE FROM GREG, CODE WAS TOO LONG

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Osmiridium, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Osmiridium, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 4500)
                .metadata(ADDITIVE_AMOUNT, 1000).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.dust, (int) (1L)),
                        new OreDictItemStack("dustAnyCarbon", 1))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Steel, Materials2Shapes.ingot, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Ash, Materials2Shapes.dust, (int) (1)))
                .outputChances(10000, 1111)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.CarbonDioxide,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.dust, (int) (50L)),
                        new OreDictItemStack("dustAnyCarbon", 1))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Steel, Materials2Shapes.ingot, (int) (50L)),
                        MaterialLibAPI.getStack(Materials2Materials.Ash, Materials2Shapes.dust, (int) (1)))
                .outputChances(10000, 1111).duration(150 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 2000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.CastIron, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Steel, Materials2Shapes.ingot, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Ash, Materials2Shapes.dust, (int) (1)))
                .outputChances(10000, 1111)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.ShadowIron, Materials2Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Carbon, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.ShadowSteel, Materials2Shapes.ingot, (int) (4L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 2000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.MeteoricIron, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.MeteoricSteel, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.GalliumArsenide, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.GalliumArsenide, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Gallium, Materials2Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Arsenic, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(ItemList.GalliumArsenideCrystal.get(1L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1511).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.GalliumArsenide, Materials2Shapes.dust, (int) (2L)))
                .circuit(2).itemOutputs(ItemList.GalliumArsenideCrystal.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1511).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ilmenite, Materials2Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials2Materials.Carbon, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.CastIron, Materials2Shapes.ingot, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Rutile, Materials2Shapes.dust, (int) (3L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.CarbonMonoxide,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1700)
                .addTo(blastFurnaceRecipes);
        // 2Mg + TiCl4 = Ti + 2MgCl2

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Magnesium, Materials2Shapes.dust, (int) (2L)))
                .circuit(12)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Titanium, Materials2Shapes.ingotHot, (int) (1L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.Magnesiumchloride, Materials2Shapes.dust, (int) (6L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Titaniumtetrachloride,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1000L)))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2140).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Copper, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.AnnealedCopper, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Titanium, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Titanium, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 1940)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Tungsten, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Tungsten, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(8 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 3000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Tantalum, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Tantalum, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2400).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.TPVAlloy, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.TPVAlloy, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES + 5 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 3000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.TungstenSteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.TungstenSteel, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES + 5 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.TungstenCarbide, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.TungstenCarbide, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 2460)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.VanadiumGallium, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.VanadiumGallium, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 4500)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.NiobiumTitanium, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.NiobiumTitanium, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 4500)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Nichrome, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Nichrome, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 2700).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.StainlessSteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.StainlessSteel, Materials2Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 25 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1700)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.StainlessSteel, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.StainlessSteel, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1700).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI
                        .getStack(Materials2Materials.Pentacadmiummagnesiumhexaoxid, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.Pentacadmiummagnesiumhexaoxid,
                                Materials2Shapes.ingot,
                                (int) (1L)))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2500)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.Titaniumonabariumdecacoppereikosaoxid,
                                Materials2Shapes.dust,
                                (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.Titaniumonabariumdecacoppereikosaoxid,
                                Materials2Shapes.ingotHot,
                                (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 3300)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.Uraniumtriplatinid, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.Uraniumtriplatinid,
                                Materials2Shapes.ingotHot,
                                (int) (1L)))
                .duration(2 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.Vanadiumtriindinid, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.Vanadiumtriindinid,
                                Materials2Shapes.ingotHot,
                                (int) (1L)))
                .duration(2 * MINUTES + 50 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5200)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                                Materials2Shapes.dust,
                                (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                                Materials2Shapes.ingotHot,
                                (int) (1L)))
                .duration(3 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 6000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.DeepIron, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.DeepIron, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(4 * MINUTES).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 7500).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.Tetranaquadahdiindiumhexaplatiumosminid,
                                Materials2Shapes.dust,
                                (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.Tetranaquadahdiindiumhexaplatiumosminid,
                                Materials2Shapes.ingotHot,
                                (int) (1L)))
                .duration(4 * MINUTES).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 8100).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.Longasssuperconductornameforuvwire,
                                Materials2Shapes.dust,
                                (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.Longasssuperconductornameforuvwire,
                                Materials2Shapes.ingotHot,
                                (int) (1L)))
                .duration(7 * MINUTES).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 9900).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.Longasssuperconductornameforuhvwire,
                                Materials2Shapes.dust,
                                (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.Longasssuperconductornameforuhvwire,
                                Materials2Shapes.ingotHot,
                                (int) (1L)))
                .duration(9 * MINUTES).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 10500).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Tritanium, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Tritanium, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(6 * MINUTES).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9900).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Quantium, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Quantium, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(3 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Bedrockium, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Bedrockium, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(9 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9900)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.MysteriousCrystal, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.MysteriousCrystal, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(5 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 7200)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.CosmicNeutronium, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.CosmicNeutronium, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(9 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9900)
                .metadata(ADDITIVE_AMOUNT, 1000).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(15 * MINUTES).eut(TierEU.RECIPE_UV).metadata(COIL_HEAT, 10800).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Infinity, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Infinity, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(30 * MINUTES).eut(TierEU.RECIPE_UHV).metadata(COIL_HEAT, 10800)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Kanthal, Materials2Shapes.dust, (int) (1L)))
                .circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Kanthal, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1800).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Kanthal, Materials2Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Kanthal, Materials2Shapes.ingotHot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(45 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1800).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.FerriteMixture, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.NickelZincFerrite, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (2000)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, MU.blastFurnaceTemp(Materials2Materials.NickelZincFerrite))
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get("ingotBrickNether", 1L)).circuit(1)
                .itemOutputs(NHItemList.HotNetherrackBrick.get())
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.InfernalBrick.get(), NHItemList.CokeOvenBrick.get())
                .itemOutputs(NHItemList.AdvancedCokeOvenBrick.get(2))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.fluidGas,
                                (int) (1000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.RawNeutronium.get()).circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Neutronium, Materials2Shapes.ingotHot, (int) (1L)))
                .duration(6 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_UV).metadata(COIL_HEAT, 9000)
                .metadata(ADDITIVE_AMOUNT, 1000).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Sapphire, Materials2Shapes.dust, (int) (3)))
                .circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Alumina, Materials2Shapes.dust, (int) (1)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.GreenSapphire, Materials2Shapes.dust, (int) (3)))
                .circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Alumina, Materials2Shapes.dust, (int) (1)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Ruby, Materials2Shapes.dust, (int) (3)))
                .circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Alumina, Materials2Shapes.dust, (int) (1)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Sapphire, Materials2Shapes.dust, (int) (1)),
                        MaterialLibAPI.getStack(Materials2Materials.Carbon, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Alumina, Materials2Shapes.dust, (int) (1)),
                        MaterialLibAPI.getStack(Materials2Materials.DarkAsh, Materials2Shapes.dust, (int) (1)))
                .outputChances(10000, 1111).duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.GreenSapphire, Materials2Shapes.dust, (int) (1)),
                        MaterialLibAPI.getStack(Materials2Materials.Carbon, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Alumina, Materials2Shapes.dust, (int) (1)),
                        MaterialLibAPI.getStack(Materials2Materials.DarkAsh, Materials2Shapes.dust, (int) (1)))
                .outputChances(10000, 1111).duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Ruby, Materials2Shapes.dust, (int) (1)),
                        MaterialLibAPI.getStack(Materials2Materials.Carbon, Materials2Shapes.dust, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Alumina, Materials2Shapes.dust, (int) (1)),
                        MaterialLibAPI.getStack(Materials2Materials.DarkAsh, Materials2Shapes.dust, (int) (1)))
                .outputChances(10000, 1111).duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Silicon_Wafer7.get(1),
                        MaterialLibAPI.getStack(Materials2Materials.Eternity, Materials2Shapes.dust, (int) (4L)),
                        GGMaterial.shirabon.get(OrePrefixes.dust, 4))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Infinity,
                                Materials2FluidShapes.fluidPlasma,
                                (int) (576L)))
                .itemOutputs(ItemList.Circuit_Silicon_Wafer8.get(1)).duration(30 * SECONDS).eut(TierEU.RECIPE_UXV)
                .metadata(COIL_HEAT, 22000).addTo(blastFurnaceRecipes);

        if (TinkerConstruct.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "materials", 1, 12)).circuit(11)
                    .itemOutputs(
                            MaterialLibAPI.getStack(Materials2Materials.Aluminium, Materials2Shapes.ingot, (int) (1)))
                    .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1300)
                    .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                    .addTo(BlastFurnaceWithGas);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.glass, 1, 0)).circuit(1)
                    .itemOutputs(getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.glass_pane, 1, 0)).circuit(1)
                    .itemOutputs(getModItem(TinkerConstruct.ID, "GlassPane", 1, 0)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Parts_RawCrystalChip.get(1L),
                            MaterialLibAPI.getStack(Materials2Materials.Emerald, Materials2Shapes.plate, (int) (1)))
                    .itemOutputs(ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L)).duration(45 * SECONDS)
                    .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 5000).metadata(ADDITIVE_AMOUNT, 1000)
                    .addTo(BlastFurnaceWithGas);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Parts_RawCrystalChip.get(1L),
                            MaterialLibAPI.getStack(Materials2Materials.Olivine, Materials2Shapes.plate, (int) (1)))
                    .itemOutputs(ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L)).duration(45 * SECONDS)
                    .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 5000).metadata(ADDITIVE_AMOUNT, 1000)
                    .addTo(BlastFurnaceWithGas);

        }

        if (EnderIO.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials2Materials.CertusQuartz, Materials2Shapes.dust, (int) (2)),
                            MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.dust, (int) (1)))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.dust, (int) (2)),
                            MaterialLibAPI.getStack(Materials2Materials.Glass, Materials2Shapes.dust, (int) (1)))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials2Materials.CertusQuartz, Materials2Shapes.dust, (int) (2)),
                            MaterialLibAPI.getStack(Materials2Materials.Quartzite, Materials2Shapes.dust, (int) (2)))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.dust, (int) (2)),
                            MaterialLibAPI.getStack(Materials2Materials.Quartzite, Materials2Shapes.dust, (int) (2)))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials2Materials.CertusQuartz, Materials2Shapes.dust, (int) (1)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.BorosilicateGlass, Materials2Shapes.dust, (int) (1)))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.dust, (int) (1)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.BorosilicateGlass, Materials2Shapes.dust, (int) (1)))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        }

        if (SGCraft.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(NHItemList.StargateCrystalDust.get().splitStack(64))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.sgcrystalslurry,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (128_000_000L)))
                    .itemOutputs(getModItem(SGCraft.ID, "sgCoreCrystal", 1)).duration(7 * 24 * HOURS * 2)
                    .eut(TierEU.RECIPE_MAX).metadata(COIL_HEAT, 100_000).addTo(blastFurnaceRecipes); // ^ 2 weeks

            GTValues.RA.stdBuilder().itemInputs(NHItemList.StargateCrystalDust.get().splitStack(64))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.MagnetohydrodynamicallyConstrainedStarMatter,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (128_000_000L)))
                    .itemOutputs(getModItem(SGCraft.ID, "sgControllerCrystal", 1)).duration(7 * 24 * HOURS * 2)
                    .eut(TierEU.RECIPE_MAX).metadata(COIL_HEAT, 100_000).addTo(blastFurnaceRecipes);

        }
    }
}
