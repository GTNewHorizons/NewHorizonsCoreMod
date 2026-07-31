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

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.FluidShapes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.material.MaterialUtils;
import gregtech.api.objects.OreDictItemStack;
import gregtech.api.util.GTOreDictUnificator;

public class BlastFurnaceRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder().itemInputs(NHItemList.UncookedSlush.get()).circuit(1)
                .itemOutputs(NHItemList.GlowingMarshmallow.get()).duration(2 * MINUTES + 50 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4500).metadata(ADDITIVE_AMOUNT, 1000)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.RedstoneAlloy, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.RedstoneAlloy, Shapes.ingot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.RedstoneAlloy, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.RedstoneAlloy, Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.ConductiveIron, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.ConductiveIron, Shapes.ingot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.ConductiveIron, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.ConductiveIron, Shapes.ingot, (int) (1L)))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.ingot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.ingot, (int) (1L)))
                .duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.EnergeticSilver, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.EnergeticSilver, Shapes.ingot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.EnergeticSilver, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.EnergeticSilver, Shapes.ingot, (int) (1L)))
                .duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.VibrantAlloy, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.VibrantAlloy, Shapes.ingotHot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.VibrantAlloy, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.VibrantAlloy, Shapes.ingotHot, (int) (1L)))
                .duration(5 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.VividAlloy, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.VividAlloy, Shapes.ingotHot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.VividAlloy, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.VividAlloy, Shapes.ingotHot, (int) (1L)))
                .duration(5 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.CrystallineAlloy, Shapes.dust, (int) (1L))).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.CrystallineAlloy, Shapes.ingotHot, (int) (1L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4500).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.CrystallinePinkSlime, Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.CrystallinePinkSlime, Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.MelodicAlloy, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.MelodicAlloy, Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.StellarAlloy, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.StellarAlloy, Shapes.ingotHot, (int) (1L)))
                .duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 7200)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.ElectricalSteel, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.ElectricalSteel, Shapes.ingot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.ElectricalSteel, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.ElectricalSteel, Shapes.ingot, (int) (1L)))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.PulsatingIron, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.PulsatingIron, Shapes.ingot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1800)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.PulsatingIron, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.PulsatingIron, Shapes.ingot, (int) (1L)))
                .duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Soularium, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Soularium, Shapes.ingot, (int) (1L)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.ingot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1800).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.EndSteel, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.EndSteel, Shapes.ingot, (int) (1L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4500).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.EnderiumBase, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.EnderiumBase, Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3300)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Enderium, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Enderium, Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 4500)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Reinforced, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Reinforced, Shapes.ingot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1700).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Reinforced, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.Reinforced, Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1700)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Galgadorian, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Galgadorian, Shapes.ingotHot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2800)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Galgadorian, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.Galgadorian, Shapes.ingotHot, (int) (1L)))
                .duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.EnhancedGalgadorian, Shapes.dust, (int) (1L))).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.EnhancedGalgadorian, Shapes.ingotHot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 4200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Draconium, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Draconium, Shapes.ingotHot, (int) (1L)))
                .duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 7200)
                .metadata(ADDITIVE_AMOUNT, 1000).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.DraconiumAwakened, Shapes.dust, (int) (1L))).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.DraconiumAwakened, Shapes.ingotHot, (int) (1L)))
                .duration(4 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9900)
                .metadata(ADDITIVE_AMOUNT, 1000).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Cobalt, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Cobalt, Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1700)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Ardite, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Ardite, Shapes.ingot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1600)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Ardite, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.Ardite, Shapes.ingot, (int) (1L)))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Manyullyn, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Manyullyn, Shapes.ingotHot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(1 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 3300)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Manyullyn, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.Manyullyn, Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 3600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Desh, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Desh, Shapes.ingotHot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Desh, Shapes.dust, (int) (1L))).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Desh, Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.ElectrumFlux, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.ElectrumFlux, Shapes.ingotHot, (int) (1L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9000).metadata(ADDITIVE_AMOUNT, 1000)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.FierySteel, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.FierySteel, Shapes.ingot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.FierySteel, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.FierySteel, Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1900)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Sunnarium, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Sunnarium, Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4500)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.HSSG, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.HSSG, Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4200)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.HSSE, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.HSSE, Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES + 5 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.HSSS, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.HSSS, Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Naquadah, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Naquadah, Shapes.ingotHot, (int) (1L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5000).metadata(ADDITIVE_AMOUNT, 1000)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.ingotHot, (int) (1L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_ZPM / 2).metadata(COIL_HEAT, 7200)
                .metadata(ADDITIVE_AMOUNT, 1000).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.NaquadahEnriched, Shapes.dust, (int) (1L))).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.NaquadahEnriched, Shapes.ingotHot, (int) (1L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5350).metadata(ADDITIVE_AMOUNT, 1000)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Naquadria, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Naquadria, Shapes.ingotHot, (int) (1L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9000).metadata(ADDITIVE_AMOUNT, 1000)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Trinium, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Trinium, Shapes.ingotHot, (int) (1L)))
                .duration(70 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 7200).metadata(ADDITIVE_AMOUNT, 1000)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Osmium, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Osmium, Shapes.ingotHot, (int) (1L)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 4500).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Iridium, Shapes.ingotHot, (int) (1L)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 4500).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Oriharukon, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Oriharukon, Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Vyroxeres, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Vyroxeres, Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Orichalcum, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Orichalcum, Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 6000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Alduorite, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Alduorite, Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 6600)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Mithril, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Mithril, Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 6600)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Ceruclase, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Ceruclase, Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 6600)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Vulcanite, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Vulcanite, Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 8400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.ShadowIron, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.ShadowIron, Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 8400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Chrysotile, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Chrysotile, Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_UV).metadata(COIL_HEAT, 9400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Tartarite, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Tartarite, Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_UHV).metadata(COIL_HEAT, 10400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.ingotHot, (int) (1L)))
                .duration(5 * MINUTES).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9000).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.VanadiumSteel, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.VanadiumSteel, Shapes.ingot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1453).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.VanadiumSteel, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.VanadiumSteel, Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1453)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.DamascusSteel, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.DamascusSteel, Shapes.ingot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.DamascusSteel, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.DamascusSteel, Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.BlackSteel, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.BlackSteel, Shapes.ingot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.BlackSteel, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.BlackSteel, Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.RedSteel, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.RedSteel, Shapes.ingot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(55 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1300).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.RedSteel, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.RedSteel, Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1300)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.BlueSteel, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.BlueSteel, Shapes.ingot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1400).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.BlueSteel, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.BlueSteel, Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1400)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.SiliconSolarGrade, Shapes.dust, (int) (1L))).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.SiliconSolarGrade, Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2273)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        // 2Al(OH)3 = Al2O3 + 3H2O

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.AluminiumHydroxide, Shapes.dust, (int) (8L))).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (5L))).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1300).addTo(blastFurnaceRecipes);
        // 2NaAlO2 + CO2 = Al2O3 + Na2CO3

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (8L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.SodiumCarbonate, Shapes.dust, (int) (6L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.CarbonDioxide, FluidShapes.fluidGas, (int) (1000L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);
        // 2Al2O3 + 3C = 4Al + 3CO2

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (10L)),
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, (int) (3L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Aluminium, Shapes.ingot, (int) (4L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(Materials.CarbonDioxide, FluidShapes.fluidGas, (int) (3000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2054).addTo(blastFurnaceRecipes);
        // 6Al2O3 =Na3AlF6= 12Al

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (10L)),
                        MaterialLibAPI.getStack(Materials.Cryolite, Shapes.dust, (int) (5L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Aluminium, Shapes.ingot, (int) (4L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 963)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Aluminium, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Aluminium, Shapes.ingot, (int) (1L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2054).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        // NEEDED TO MOVE FROM GREG, CODE WAS TOO LONG

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Osmiridium, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Osmiridium, Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 4500)
                .metadata(ADDITIVE_AMOUNT, 1000).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (1L)),
                        new OreDictItemStack("dustAnyCarbon", 1))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.ingot, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Ash, Shapes.dust, (int) (1)))
                .outputChances(10000, 1111)
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(Materials.CarbonDioxide, FluidShapes.fluidGas, (int) (1000L)))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (50L)),
                        new OreDictItemStack("dustAnyCarbon", 1))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.ingot, (int) (50L)),
                        MaterialLibAPI.getStack(Materials.Ash, Shapes.dust, (int) (1)))
                .outputChances(10000, 1111).duration(150 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 2000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.CastIron, Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.ingot, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Ash, Shapes.dust, (int) (1)))
                .outputChances(10000, 1111)
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.ShadowIron, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.ShadowSteel, Shapes.ingot, (int) (4L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 2000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.MeteoricIron, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.MeteoricSteel, Shapes.ingot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.GalliumArsenide, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.GalliumArsenide, Shapes.ingot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Gallium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Arsenic, Shapes.dust, (int) (1L)))
                .itemOutputs(ItemList.GalliumArsenideCrystal.get(1L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1511).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.GalliumArsenide, Shapes.dust, (int) (2L)))
                .circuit(2).itemOutputs(ItemList.GalliumArsenideCrystal.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1511).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Ilmenite, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.CastIron, Shapes.ingot, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Rutile, Shapes.dust, (int) (3L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(Materials.CarbonMonoxide, FluidShapes.fluidGas, (int) (1000L)))
                .duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1700)
                .addTo(blastFurnaceRecipes);
        // 2Mg + TiCl4 = Ti + 2MgCl2

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Magnesium, Shapes.dust, (int) (2L)))
                .circuit(12)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.ingotHot, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Magnesiumchloride, Shapes.dust, (int) (6L)))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.Titaniumtetrachloride, FluidShapes.fluidLiquid, (int) (1000L)))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2140).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Copper, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.AnnealedCopper, Shapes.ingot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Titanium, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Titanium, Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 1940)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Tungsten, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Tungsten, Shapes.ingotHot, (int) (1L)))
                .duration(8 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 3000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Tantalum, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Tantalum, Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2400).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.TPVAlloy, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.TPVAlloy, Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES + 5 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 3000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES + 5 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.TungstenCarbide, Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.TungstenCarbide, Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 2460)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.VanadiumGallium, Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.VanadiumGallium, Shapes.ingotHot, (int) (1L)))
                .duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 4500)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.NiobiumTitanium, Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.NiobiumTitanium, Shapes.ingotHot, (int) (1L)))
                .duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 4500)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Nichrome, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Nichrome, Shapes.ingotHot, (int) (1L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 2700).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 25 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1700)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.ingot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1700).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.Pentacadmiummagnesiumhexaoxid, Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Pentacadmiummagnesiumhexaoxid, Shapes.ingot, (int) (1L)))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2500)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials.Titaniumonabariumdecacoppereikosaoxid, Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials.Titaniumonabariumdecacoppereikosaoxid, Shapes.ingotHot, (int) (1L)))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 3300)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.Uraniumtriplatinid, Shapes.dust, (int) (1L))).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Uraniumtriplatinid, Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.Vanadiumtriindinid, Shapes.dust, (int) (1L))).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Vanadiumtriindinid, Shapes.ingotHot, (int) (1L)))
                .duration(2 * MINUTES + 50 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5200)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(
                                Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                                Shapes.dust,
                                (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                                Shapes.ingotHot,
                                (int) (1L)))
                .duration(3 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 6000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.DeepIron, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.DeepIron, Shapes.ingotHot, (int) (1L)))
                .duration(4 * MINUTES).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 7500).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials.Tetranaquadahdiindiumhexaplatiumosminid, Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials.Tetranaquadahdiindiumhexaplatiumosminid,
                                Shapes.ingotHot,
                                (int) (1L)))
                .duration(4 * MINUTES).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 8100).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Longasssuperconductornameforuvwire, Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials.Longasssuperconductornameforuvwire, Shapes.ingotHot, (int) (1L)))
                .duration(7 * MINUTES).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 9900).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Longasssuperconductornameforuhvwire, Shapes.dust, (int) (1L)))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials.Longasssuperconductornameforuhvwire, Shapes.ingotHot, (int) (1L)))
                .duration(9 * MINUTES).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 10500).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Tritanium, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Tritanium, Shapes.ingotHot, (int) (1L)))
                .duration(6 * MINUTES).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9900).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Quantium, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Quantium, Shapes.ingotHot, (int) (1L)))
                .duration(3 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.ingotHot, (int) (1L)))
                .duration(9 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9900)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.MysteriousCrystal, Shapes.dust, (int) (1L))).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.MysteriousCrystal, Shapes.ingotHot, (int) (1L)))
                .duration(5 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 7200)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.CosmicNeutronium, Shapes.dust, (int) (1L))).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.CosmicNeutronium, Shapes.ingotHot, (int) (1L)))
                .duration(9 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9900)
                .metadata(ADDITIVE_AMOUNT, 1000).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.InfinityCatalyst, Shapes.dust, (int) (1L))).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.InfinityCatalyst, Shapes.ingotHot, (int) (1L)))
                .duration(15 * MINUTES).eut(TierEU.RECIPE_UV).metadata(COIL_HEAT, 10800).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Infinity, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Infinity, Shapes.ingotHot, (int) (1L)))
                .duration(30 * MINUTES).eut(TierEU.RECIPE_UHV).metadata(COIL_HEAT, 10800)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Kanthal, Shapes.dust, (int) (1L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.Kanthal, Shapes.ingotHot, (int) (1L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1800).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Kanthal, Shapes.dust, (int) (1L)))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Kanthal, Shapes.ingotHot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(45 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1800).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.FerriteMixture, Shapes.dust, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.NickelZincFerrite, Shapes.ingot, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (2000)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, MaterialUtils.blastFurnaceTemp(Materials.NickelZincFerrite))
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get("ingotBrickNether", 1L)).circuit(1)
                .itemOutputs(NHItemList.HotNetherrackBrick.get())
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.InfernalBrick.get(), NHItemList.CokeOvenBrick.get())
                .itemOutputs(NHItemList.AdvancedCokeOvenBrick.get(2))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.RawNeutronium.get()).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Neutronium, Shapes.ingotHot, (int) (1L)))
                .duration(6 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_UV).metadata(COIL_HEAT, 9000)
                .metadata(ADDITIVE_AMOUNT, 1000).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Sapphire, Shapes.dust, (int) (3)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (1)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.GreenSapphire, Shapes.dust, (int) (3)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (1)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Ruby, Shapes.dust, (int) (3))).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (1))).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Sapphire, Shapes.dust, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (1)),
                        MaterialLibAPI.getStack(Materials.DarkAsh, Shapes.dust, (int) (1)))
                .outputChances(10000, 1111).duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.GreenSapphire, Shapes.dust, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (1)),
                        MaterialLibAPI.getStack(Materials.DarkAsh, Shapes.dust, (int) (1)))
                .outputChances(10000, 1111).duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Ruby, Shapes.dust, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (1)),
                        MaterialLibAPI.getStack(Materials.DarkAsh, Shapes.dust, (int) (1)))
                .outputChances(10000, 1111).duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Silicon_Wafer7.get(1),
                        MaterialLibAPI.getStack(Materials.Eternity, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Shirabon, Shapes.dust, (int) (4)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Infinity, FluidShapes.fluidPlasma, (int) (576L)))
                .itemOutputs(ItemList.Circuit_Silicon_Wafer8.get(1)).duration(30 * SECONDS).eut(TierEU.RECIPE_UXV)
                .metadata(COIL_HEAT, 22000).addTo(blastFurnaceRecipes);

        if (TinkerConstruct.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "materials", 1, 12)).circuit(11)
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Aluminium, Shapes.ingot, (int) (1)))
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
                            MaterialLibAPI.getStack(Materials.Emerald, Shapes.plate, (int) (1)))
                    .itemOutputs(ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L)).duration(45 * SECONDS)
                    .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 5000).metadata(ADDITIVE_AMOUNT, 1000)
                    .addTo(BlastFurnaceWithGas);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Parts_RawCrystalChip.get(1L),
                            MaterialLibAPI.getStack(Materials.Olivine, Shapes.plate, (int) (1)))
                    .itemOutputs(ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L)).duration(45 * SECONDS)
                    .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 5000).metadata(ADDITIVE_AMOUNT, 1000)
                    .addTo(BlastFurnaceWithGas);

        }

        if (EnderIO.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.dust, (int) (2)),
                            MaterialLibAPI.getStack(Materials.Glass, Shapes.dust, (int) (1)))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.NetherQuartz, Shapes.dust, (int) (2)),
                            MaterialLibAPI.getStack(Materials.Glass, Shapes.dust, (int) (1)))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.dust, (int) (2)),
                            MaterialLibAPI.getStack(Materials.Quartzite, Shapes.dust, (int) (2)))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.NetherQuartz, Shapes.dust, (int) (2)),
                            MaterialLibAPI.getStack(Materials.Quartzite, Shapes.dust, (int) (2)))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.BorosilicateGlass, Shapes.dust, (int) (1)))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.NetherQuartz, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.BorosilicateGlass, Shapes.dust, (int) (1)))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        }

        if (SGCraft.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(NHItemList.StargateCrystalDust.get().splitStack(64)).fluidInputs(
                    MaterialLibAPI
                            .getFluidStack(Materials.sgcrystalslurry, FluidShapes.fluidLiquid, (int) (128_000_000L)))
                    .itemOutputs(getModItem(SGCraft.ID, "sgCoreCrystal", 1)).duration(7 * 24 * HOURS * 2)
                    .eut(TierEU.RECIPE_MAX).metadata(COIL_HEAT, 100_000).addTo(blastFurnaceRecipes); // ^ 2 weeks

            GTValues.RA.stdBuilder().itemInputs(NHItemList.StargateCrystalDust.get().splitStack(64))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials.MagnetohydrodynamicallyConstrainedStarMatter,
                                    FluidShapes.fluidMolten,
                                    (int) (128_000_000L)))
                    .itemOutputs(getModItem(SGCraft.ID, "sgControllerCrystal", 1)).duration(7 * 24 * HOURS * 2)
                    .eut(TierEU.RECIPE_MAX).metadata(COIL_HEAT, 100_000).addTo(blastFurnaceRecipes);

        }
    }
}
