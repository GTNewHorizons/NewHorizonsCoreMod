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

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.RedstoneAlloy, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.RedstoneAlloy, Shapes.ingot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.RedstoneAlloy, Shapes.dust, 1)).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.RedstoneAlloy, Shapes.ingot, 1))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.ConductiveIron, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.ConductiveIron, Shapes.ingot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.ConductiveIron, Shapes.dust, 1))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.ConductiveIron, Shapes.ingot, 1))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.ingot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, 1000))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.dust, 1))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.ingot, 1))
                .duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.EnergeticSilver, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.EnergeticSilver, Shapes.ingot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, 1000))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.EnergeticSilver, Shapes.dust, 1))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.EnergeticSilver, Shapes.ingot, 1))
                .duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.VibrantAlloy, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.VibrantAlloy, Shapes.ingotHot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, 1000))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.VibrantAlloy, Shapes.dust, 1)).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.VibrantAlloy, Shapes.ingotHot, 1)).duration(5 * MINUTES)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.VividAlloy, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.VividAlloy, Shapes.ingotHot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, 1000))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.VividAlloy, Shapes.dust, 1)).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.VividAlloy, Shapes.ingotHot, 1)).duration(5 * MINUTES)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.CrystallineAlloy, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.CrystallineAlloy, Shapes.ingotHot, 1))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4500).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.CrystallinePinkSlime, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.CrystallinePinkSlime, Shapes.ingotHot, 1))
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.MelodicAlloy, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.MelodicAlloy, Shapes.ingotHot, 1))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.StellarAlloy, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.StellarAlloy, Shapes.ingotHot, 1))
                .duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 7200)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.ElectricalSteel, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.ElectricalSteel, Shapes.ingot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.ElectricalSteel, Shapes.dust, 1))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.ElectricalSteel, Shapes.ingot, 1))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.PulsatingIron, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.PulsatingIron, Shapes.ingot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1800)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.PulsatingIron, Shapes.dust, 1)).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.PulsatingIron, Shapes.ingot, 1))
                .duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Soularium, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Soularium, Shapes.ingot, 1)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true)
                .metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.ingot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1800).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.dust, 1)).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.ingot, 1))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.EndSteel, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.EndSteel, Shapes.ingot, 1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4500).metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true)
                .metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.EnderiumBase, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.EnderiumBase, Shapes.ingotHot, 1))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3300)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Enderium, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Enderium, Shapes.ingotHot, 1))
                .duration(2 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 4500)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Reinforced, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Reinforced, Shapes.ingot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1700).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Reinforced, Shapes.dust, 1)).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Reinforced, Shapes.ingot, 1))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1700)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Galgadorian, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Galgadorian, Shapes.ingotHot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, 1000))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2800)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Galgadorian, Shapes.dust, 1)).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Galgadorian, Shapes.ingotHot, 1))
                .duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.EnhancedGalgadorian, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.EnhancedGalgadorian, Shapes.ingotHot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, 1000))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 4200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Draconium, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Draconium, Shapes.ingotHot, 1))
                .duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 7200)
                .metadata(ADDITIVE_AMOUNT, 1000).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.DraconiumAwakened, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.DraconiumAwakened, Shapes.ingotHot, 1))
                .duration(4 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9900)
                .metadata(ADDITIVE_AMOUNT, 1000).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Cobalt, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Cobalt, Shapes.ingot, 1))
                .duration(1 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1700)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Ardite, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Ardite, Shapes.ingot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, 1000))
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1600)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Ardite, Shapes.dust, 1)).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Ardite, Shapes.ingot, 1)).duration(2 * MINUTES)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Manyullyn, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Manyullyn, Shapes.ingotHot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, 1000))
                .duration(1 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 3300)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Manyullyn, Shapes.dust, 1)).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Manyullyn, Shapes.ingotHot, 1)).duration(2 * MINUTES)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 3600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Desh, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Desh, Shapes.ingotHot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Desh, Shapes.dust, 1)).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Desh, Shapes.ingotHot, 1))
                .duration(2 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.ElectrumFlux, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.ElectrumFlux, Shapes.ingotHot, 1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9000).metadata(ADDITIVE_AMOUNT, 1000)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.FierySteel, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.FierySteel, Shapes.ingot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.FierySteel, Shapes.dust, 1)).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.FierySteel, Shapes.ingot, 1))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1900)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Sunnarium, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Sunnarium, Shapes.ingotHot, 1))
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4500)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.HSSG, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.HSSG, Shapes.ingotHot, 1))
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4200)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.HSSE, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.HSSE, Shapes.ingotHot, 1))
                .duration(2 * MINUTES + 5 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.HSSS, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.HSSS, Shapes.ingotHot, 1))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Naquadah, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Naquadah, Shapes.ingotHot, 1)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5000).metadata(ADDITIVE_AMOUNT, 1000)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.ingotHot, 1))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_ZPM / 2).metadata(COIL_HEAT, 7200)
                .metadata(ADDITIVE_AMOUNT, 1000).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.NaquadahEnriched, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.NaquadahEnriched, Shapes.ingotHot, 1))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5350).metadata(ADDITIVE_AMOUNT, 1000)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Naquadria, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Naquadria, Shapes.ingotHot, 1)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9000).metadata(ADDITIVE_AMOUNT, 1000)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Trinium, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Trinium, Shapes.ingotHot, 1)).duration(70 * SECONDS)
                .eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 7200).metadata(ADDITIVE_AMOUNT, 1000)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Osmium, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Osmium, Shapes.ingotHot, 1)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 4500).metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true)
                .metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Iridium, Shapes.ingotHot, 1)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 4500).metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true)
                .metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Oriharukon, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Oriharukon, Shapes.ingotHot, 1))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Vyroxeres, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Vyroxeres, Shapes.ingotHot, 1))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Orichalcum, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Orichalcum, Shapes.ingotHot, 1))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 6000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Alduorite, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Alduorite, Shapes.ingotHot, 1))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 6600)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Mithril, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Mithril, Shapes.ingotHot, 1))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 6600)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Ceruclase, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Ceruclase, Shapes.ingotHot, 1))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 6600)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Vulcanite, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Vulcanite, Shapes.ingotHot, 1))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 8400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.ShadowIron, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.ShadowIron, Shapes.ingotHot, 1))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 8400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Chrysotile, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Chrysotile, Shapes.ingotHot, 1))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_UV).metadata(COIL_HEAT, 9400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Tartarite, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Tartarite, Shapes.ingotHot, 1))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_UHV).metadata(COIL_HEAT, 10400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.ingotHot, 1))
                .duration(5 * MINUTES).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9000).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.VanadiumSteel, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.VanadiumSteel, Shapes.ingot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1453).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.VanadiumSteel, Shapes.dust, 1)).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.VanadiumSteel, Shapes.ingot, 1))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1453)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.DamascusSteel, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.DamascusSteel, Shapes.ingot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.DamascusSteel, Shapes.dust, 1)).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.DamascusSteel, Shapes.ingot, 1))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.BlackSteel, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.BlackSteel, Shapes.ingot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.BlackSteel, Shapes.dust, 1)).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.BlackSteel, Shapes.ingot, 1))
                .duration(1 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.RedSteel, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.RedSteel, Shapes.ingot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(55 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1300).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.RedSteel, Shapes.dust, 1)).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.RedSteel, Shapes.ingot, 1))
                .duration(1 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1300)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.BlueSteel, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.BlueSteel, Shapes.ingot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1400).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.BlueSteel, Shapes.dust, 1)).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.BlueSteel, Shapes.ingot, 1))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1400)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.SiliconSolarGrade, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.SiliconSolarGrade, Shapes.ingotHot, 1))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2273)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        // 2Al(OH)3 = Al2O3 + 3H2O

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.AluminiumHydroxide, Shapes.dust, 8))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, 5))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1300).addTo(blastFurnaceRecipes);
        // 2NaAlO2 + CO2 = Al2O3 + Na2CO3

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, 8))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, 5),
                        MaterialLibAPI.getStack(Materials.SodiumCarbonate, Shapes.dust, 6))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.CarbonDioxide, FluidShapes.fluidGas, 1000))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);
        // 2Al2O3 + 3C = 4Al + 3CO2

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, 10),
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, 3))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Aluminium, Shapes.ingot, 4))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.CarbonDioxide, FluidShapes.fluidGas, 3000))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2054).addTo(blastFurnaceRecipes);
        // 6Al2O3 =Na3AlF6= 12Al

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, 10),
                        MaterialLibAPI.getStack(Materials.Cryolite, Shapes.dust, 5))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Aluminium, Shapes.ingot, 4))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 963)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Aluminium, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Aluminium, Shapes.ingot, 1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2054).metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true)
                .metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        // NEEDED TO MOVE FROM GREG, CODE WAS TOO LONG

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Osmiridium, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Osmiridium, Shapes.ingotHot, 1))
                .duration(1 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 4500)
                .metadata(ADDITIVE_AMOUNT, 1000).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, 1),
                        new OreDictItemStack("dustAnyCarbon", 1))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.ingot, 1),
                        MaterialLibAPI.getStack(Materials.Ash, Shapes.dust, 1))
                .outputChances(10000, 1111)
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.CarbonDioxide, FluidShapes.fluidGas, 250))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, 50),
                        new OreDictItemStack("dustAnyCarbon", 1))
                .circuit(2)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.ingot, 50),
                        MaterialLibAPI.getStack(Materials.Ash, Shapes.dust, 1))
                .outputChances(10000, 1111).duration(150 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 2000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.CastIron, Shapes.dust, 1)).circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.ingot, 1),
                        MaterialLibAPI.getStack(Materials.Ash, Shapes.dust, 1))
                .outputChances(10000, 1111)
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.ShadowIron, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.ShadowSteel, Shapes.ingot, 4)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 2000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.MeteoricIron, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.MeteoricSteel, Shapes.ingot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.GalliumArsenide, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.GalliumArsenide, Shapes.ingot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Gallium, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.Arsenic, Shapes.dust, 1))
                .itemOutputs(ItemList.GalliumArsenideCrystal.get(1L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1511).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.GalliumArsenide, Shapes.dust, 2))
                .circuit(2).itemOutputs(ItemList.GalliumArsenideCrystal.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1511).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Ilmenite, Shapes.dust, 5),
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, 1))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.CastIron, Shapes.ingot, 1),
                        MaterialLibAPI.getStack(Materials.Rutile, Shapes.dust, 3))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.CarbonMonoxide, FluidShapes.fluidGas, 1000))
                .duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1700)
                .addTo(blastFurnaceRecipes);
        // 2Mg + TiCl4 = Ti + 2MgCl2

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Magnesium, Shapes.dust, 2)).circuit(12)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.ingotHot, 1),
                        MaterialLibAPI.getStack(Materials.Magnesiumchloride, Shapes.dust, 6))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.Titaniumtetrachloride, FluidShapes.fluidLiquid, 1000))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2140).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Copper, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.AnnealedCopper, Shapes.ingot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Titanium, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Titanium, Shapes.ingotHot, 1))
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 1940)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Tungsten, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Tungsten, Shapes.ingotHot, 1))
                .duration(8 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 3000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Tantalum, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Tantalum, Shapes.ingotHot, 1)).duration(2 * MINUTES)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2400).metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true)
                .metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.TPVAlloy, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.TPVAlloy, Shapes.ingotHot, 1))
                .duration(2 * MINUTES + 5 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 3000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.ingotHot, 1))
                .duration(2 * MINUTES + 5 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.TungstenCarbide, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.TungstenCarbide, Shapes.ingotHot, 1))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 2460)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.VanadiumGallium, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.VanadiumGallium, Shapes.ingotHot, 1))
                .duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 4500)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.NiobiumTitanium, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.NiobiumTitanium, Shapes.ingotHot, 1))
                .duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 4500)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Nichrome, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Nichrome, Shapes.ingotHot, 1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 2700).metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true)
                .metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.dust, 1))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.ingot, 1))
                .duration(1 * MINUTES + 25 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1700)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.ingot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1700).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.Pentacadmiummagnesiumhexaoxid, Shapes.dust, 1))
                .circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Pentacadmiummagnesiumhexaoxid, Shapes.ingot, 1))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2500)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.Titaniumonabariumdecacoppereikosaoxid, Shapes.dust, 1))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Titaniumonabariumdecacoppereikosaoxid, Shapes.ingotHot, 1))
                .duration(1 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 3300)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Uraniumtriplatinid, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Uraniumtriplatinid, Shapes.ingotHot, 1))
                .duration(2 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Vanadiumtriindinid, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.Vanadiumtriindinid, Shapes.ingotHot, 1))
                .duration(2 * MINUTES + 50 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5200)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(
                                Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                                Shapes.dust,
                                1))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                                Shapes.ingotHot,
                                1))
                .duration(3 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 6000)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.DeepIron, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.DeepIron, Shapes.ingotHot, 1)).duration(4 * MINUTES)
                .eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 7500).metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true)
                .metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.Tetranaquadahdiindiumhexaplatiumosminid, Shapes.dust, 1))
                .circuit(11)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Tetranaquadahdiindiumhexaplatiumosminid, Shapes.ingotHot, 1))
                .duration(4 * MINUTES).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 8100).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.Longasssuperconductornameforuvwire, Shapes.dust, 1))
                .circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Longasssuperconductornameforuvwire, Shapes.ingotHot, 1))
                .duration(7 * MINUTES).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 9900).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.Longasssuperconductornameforuhvwire, Shapes.dust, 1))
                .circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Longasssuperconductornameforuhvwire, Shapes.ingotHot, 1))
                .duration(9 * MINUTES).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 10500).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Tritanium, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Tritanium, Shapes.ingotHot, 1)).duration(6 * MINUTES)
                .eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9900).metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true)
                .metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Quantium, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Quantium, Shapes.ingotHot, 1))
                .duration(3 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5400)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.ingotHot, 1))
                .duration(9 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9900)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.MysteriousCrystal, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.MysteriousCrystal, Shapes.ingotHot, 1))
                .duration(5 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 7200)
                .metadata(ADDITIVE_AMOUNT, 1000).metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1)
                .addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.CosmicNeutronium, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.CosmicNeutronium, Shapes.ingotHot, 1))
                .duration(9 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9900)
                .metadata(ADDITIVE_AMOUNT, 1000).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.InfinityCatalyst, Shapes.dust, 1))
                .circuit(11).itemOutputs(MaterialLibAPI.getStack(Materials.InfinityCatalyst, Shapes.ingotHot, 1))
                .duration(15 * MINUTES).eut(TierEU.RECIPE_UV).metadata(COIL_HEAT, 10800).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Infinity, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Infinity, Shapes.ingotHot, 1)).duration(30 * MINUTES)
                .eut(TierEU.RECIPE_UHV).metadata(COIL_HEAT, 10800).metadata(ADDITIVE_AMOUNT, 1000)
                .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Kanthal, Shapes.dust, 1)).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Kanthal, Shapes.ingotHot, 1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1800).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Kanthal, Shapes.dust, 1)).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Kanthal, Shapes.ingotHot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(45 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1800).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.FerriteMixture, Shapes.dust, 1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.NickelZincFerrite, Shapes.ingot, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 2000))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, MaterialUtils.blastFurnaceTemp(Materials.NickelZincFerrite))
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get("ingotBrickNether", 1L)).circuit(1)
                .itemOutputs(NHItemList.HotNetherrackBrick.get())
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.InfernalBrick.get(), NHItemList.CokeOvenBrick.get())
                .itemOutputs(NHItemList.AdvancedCokeOvenBrick.get(2))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, 1000))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.RawNeutronium.get()).circuit(11)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Neutronium, Shapes.ingotHot, 1))
                .duration(6 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_UV).metadata(COIL_HEAT, 9000)
                .metadata(ADDITIVE_AMOUNT, 1000).addTo(BlastFurnaceWithGas);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Sapphire, Shapes.dust, 3)).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, 1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.GreenSapphire, Shapes.dust, 3)).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, 1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Ruby, Shapes.dust, 3)).circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, 1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Sapphire, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, 1))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.DarkAsh, Shapes.dust, 1))
                .outputChances(10000, 1111).duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.GreenSapphire, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, 1))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.DarkAsh, Shapes.dust, 1))
                .outputChances(10000, 1111).duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Ruby, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, 1))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, 1),
                        MaterialLibAPI.getStack(Materials.DarkAsh, Shapes.dust, 1))
                .outputChances(10000, 1111).duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Silicon_Wafer7.get(1),
                        MaterialLibAPI.getStack(Materials.Eternity, Shapes.dust, 4),
                        MaterialLibAPI.getStack(Materials.Shirabon, Shapes.dust, 4))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Infinity, FluidShapes.fluidPlasma, 576))
                .itemOutputs(ItemList.Circuit_Silicon_Wafer8.get(1)).duration(30 * SECONDS).eut(TierEU.RECIPE_UXV)
                .metadata(COIL_HEAT, 22000).addTo(blastFurnaceRecipes);

        if (TinkerConstruct.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "materials", 1, 12)).circuit(11)
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Aluminium, Shapes.ingot, 1)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1300).metadata(ADDITIVE_AMOUNT, 1000)
                    .metadata(NO_GAS, true).metadata(NO_GAS_CIRCUIT_CONFIG, 1).addTo(BlastFurnaceWithGas);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.glass, 1, 0)).circuit(1)
                    .itemOutputs(getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.glass_pane, 1, 0)).circuit(1)
                    .itemOutputs(getModItem(TinkerConstruct.ID, "GlassPane", 1, 0)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Parts_RawCrystalChip.get(1L),
                            MaterialLibAPI.getStack(Materials.Emerald, Shapes.plate, 1))
                    .itemOutputs(ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L)).duration(45 * SECONDS)
                    .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 5000).metadata(ADDITIVE_AMOUNT, 1000)
                    .addTo(BlastFurnaceWithGas);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Parts_RawCrystalChip.get(1L),
                            MaterialLibAPI.getStack(Materials.Olivine, Shapes.plate, 1))
                    .itemOutputs(ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L)).duration(45 * SECONDS)
                    .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 5000).metadata(ADDITIVE_AMOUNT, 1000)
                    .addTo(BlastFurnaceWithGas);

        }

        if (EnderIO.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.dust, 2),
                            MaterialLibAPI.getStack(Materials.Glass, Shapes.dust, 1))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.NetherQuartz, Shapes.dust, 2),
                            MaterialLibAPI.getStack(Materials.Glass, Shapes.dust, 1))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.dust, 2),
                            MaterialLibAPI.getStack(Materials.Quartzite, Shapes.dust, 2))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.NetherQuartz, Shapes.dust, 2),
                            MaterialLibAPI.getStack(Materials.Quartzite, Shapes.dust, 2))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.dust, 1),
                            MaterialLibAPI.getStack(Materials.BorosilicateGlass, Shapes.dust, 1))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.NetherQuartz, Shapes.dust, 1),
                            MaterialLibAPI.getStack(Materials.BorosilicateGlass, Shapes.dust, 1))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        }

        if (SGCraft.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(NHItemList.StargateCrystalDust.get().splitStack(64)).fluidInputs(
                    MaterialLibAPI.getFluidStack(Materials.sgcrystalslurry, FluidShapes.fluidLiquid, 128_000_000))
                    .itemOutputs(getModItem(SGCraft.ID, "sgCoreCrystal", 1)).duration(7 * 24 * HOURS * 2)
                    .eut(TierEU.RECIPE_MAX).metadata(COIL_HEAT, 100_000).addTo(blastFurnaceRecipes); // ^ 2 weeks

            GTValues.RA.stdBuilder().itemInputs(NHItemList.StargateCrystalDust.get().splitStack(64))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials.MagnetohydrodynamicallyConstrainedStarMatter,
                                    FluidShapes.fluidMolten,
                                    128_000_000))
                    .itemOutputs(getModItem(SGCraft.ID, "sgControllerCrystal", 1)).duration(7 * 24 * HOURS * 2)
                    .eut(TierEU.RECIPE_MAX).metadata(COIL_HEAT, 100_000).addTo(blastFurnaceRecipes);

        }
    }
}
