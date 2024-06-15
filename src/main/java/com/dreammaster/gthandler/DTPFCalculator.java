package com.dreammaster.gthandler;

import static gregtech.api.recipe.RecipeMaps.blastFurnaceRecipes;
import static gregtech.api.recipe.RecipeMaps.vacuumFreezerRecipes;

import java.util.ArrayList;
import java.util.Collection;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;

public class DTPFCalculator {

    public DTPFCalculator() {};

    protected long duration = -1;
    protected ItemStack customInput = null;
    protected long ebfEUpertick = 0;
    protected long ebfDuration = 0;
    protected long freezerEUpertick = 0;
    protected long freezerDuration = 0;
    protected long baseParallel = 1;
    protected long DTPFEUt = 0;
    protected long totalBaseEU = 0;
    protected long minCatalystTier = 0;
    protected long maxCatalystTier = 3;
    protected long catalystDiscount = 0;
    protected long processingTimeDiscount = 0;
    protected long recipeDuration = 0;
    protected long scalingFactor = 2;
    protected float EUtDivisor = 1f;
    Collection<GT_Recipe> ebfRecipes = blastFurnaceRecipes.getAllRecipes();
    Collection<GT_Recipe> freezerRecipes = vacuumFreezerRecipes.getAllRecipes();
    private int[] catalyst_amounts = new int[5];
    private static final FluidStack[] CATALYSTS = new FluidStack[] { MaterialsUEVplus.ExcitedDTCC.getFluid(1),
            MaterialsUEVplus.ExcitedDTPC.getFluid(1), MaterialsUEVplus.ExcitedDTRC.getFluid(1),
            MaterialsUEVplus.ExcitedDTEC.getFluid(1), MaterialsUEVplus.ExcitedDTSC.getFluid(1) };
    // These were calculated based on their respective mixer + laser engraver recipes & their plasma energy values
    private static final long[] CATALYST_ENERGY_VALUES = new long[] { 14_514_983L, 66_768_460L, 269_326_451L,
            1_073_007_393L, 4_276_767_521L };

    /**
     * Calculates the dtpf recipe parameters for a material based on its blast furnace and vacuum freezer recipes. Only
     * checks for ebf recipes with radon or no gas as input fluids, if these do not exist for the material use
     * calculateNonEBFRecipe instead.
     * 
     * @param material The material to generate dtpf recipes for
     */
    public DTPFCalculator calculateGenericEBFBasedRecipe(Materials material) {
        determineEBFParams(material);
        determineFreezerParams(material);
        calculateBaseDTPFPowerConsumption();
        calculateCatalystAmounts(ebfDuration);
        return this;
    }

    /**
     * Calculates the dtpf recipe parameters for any recipe based on its voltage and duration. If a recipe produces more
     * than 1 ingot/dust/molten equivalent at once, it is recommended to normalize recipe time to reflect 1
     * ingot/dust/molten equivalent. For recipes containing more than 1 relevant output, it is recommended to choose one
     * main output and normalize voltage and recipe time to one unit of that output (see molten quantum as an example).
     *
     * @param base_voltage  Recipe voltage
     * @param base_duration Recipe duration in ticks
     */
    public DTPFCalculator calculateNonEBFRecipe(long base_voltage, long base_duration) {
        recipeDuration = base_duration;
        calculateNonEBFBaseDTPFPowerConsumption(base_voltage, base_duration);
        calculateCatalystAmounts(base_duration);
        return this;
    }

    private void determineEBFParams(Materials material) {
        ArrayList<GT_Recipe> foundEBFRecipes = new ArrayList<>();
        ItemStack input = material.getDust(1);
        if (customInput != null) {
            input = customInput;
        }
        // Find correct ebf recipes
        for (GT_Recipe recipe : ebfRecipes) {
            if (GT_Utility.areStacksEqual(input, recipe.mInputs[0])) {
                foundEBFRecipes.add(recipe);
            }
        }
        // Determine oganesson recipe stats
        for (GT_Recipe recipe : foundEBFRecipes) {
            if (recipe.mFluidInputs.length == 0) {
                ebfDuration = (long) (recipe.mDuration * 0.3);
                ebfEUpertick = recipe.mEUt;
            } else if (recipe.mFluidInputs[0].isFluidEqual(Materials.Radon.getGas(1000L))) {
                ebfDuration = (long) (recipe.mDuration / 0.7 * 0.3);
                ebfEUpertick = recipe.mEUt;
                break;
            }
        }
        recipeDuration = ebfDuration;
    }

    private void determineFreezerParams(Materials material) {
        // Find correct freezer recipe
        for (GT_Recipe recipe : freezerRecipes) {
            if (recipe.mInputs.length != 0 && GT_Utility
                    .areStacksEqual(GT_OreDictUnificator.get(OrePrefixes.ingotHot, material, 1L), recipe.mInputs[0])) {
                // There's only one freezer recipe per material
                freezerDuration = recipe.mDuration;
                freezerEUpertick = recipe.mEUt;
                break;
            }
        }
    }

    private void calculateBaseDTPFPowerConsumption() {
        totalBaseEU = (freezerEUpertick * freezerDuration + ebfEUpertick * ebfDuration) * baseParallel;
        DTPFEUt = totalBaseEU / ebfDuration / 10;
        while (DTPFEUt > (Integer.MAX_VALUE / Math.pow(scalingFactor, maxCatalystTier - minCatalystTier))) {
            DTPFEUt /= scalingFactor;
        }
    }

    private void calculateNonEBFBaseDTPFPowerConsumption(long base_voltage, long base_duration) {
        totalBaseEU = base_voltage * base_duration * baseParallel;
        DTPFEUt = totalBaseEU / base_duration / 10;
        while (DTPFEUt > (Integer.MAX_VALUE / Math.pow(scalingFactor, maxCatalystTier - minCatalystTier))) {
            DTPFEUt /= scalingFactor;
        }
    }

    private void calculateCatalystAmounts(long recipe_duration) {
        for (long i = 0; i <= (maxCatalystTier - minCatalystTier); i++) {
            catalyst_amounts[(int) (minCatalystTier
                    + i)] = (int) (((totalBaseEU * (0.8 - i * 0.1) * Math.pow(scalingFactor, i)
                            - DTPFEUt * Math.pow(scalingFactor, i)
                                    * (recipe_duration / Math.pow(scalingFactor, i + 1))
                                    / EUtDivisor)
                            / CATALYST_ENERGY_VALUES[(int) (minCatalystTier + i)]) * (1 - catalystDiscount / 100f));
        }
    }

    /**
     * Sets the parallel for the first recipe in its set. Default is 1.
     * 
     * @param parallel Number of parallel
     */
    public DTPFCalculator setBaseParallel(long parallel) {
        this.baseParallel = parallel;
        return this;
    }

    /**
     * Sets the lowest catalyst tier for this material. Default is 0 (Crude).
     * 
     * @param tier Catalyst tier, from 0 (Crude) to 4 (Stellar)
     */
    public DTPFCalculator setLowestCatalystTier(long tier) {
        this.minCatalystTier = tier;
        return this;
    }

    /**
     * Sets the highest catalyst tier for this material. Default is 3 (Exotic).
     * 
     * @param tier Catalyst tier, from 0 (Crude) to 4 (Stellar)
     */
    public DTPFCalculator setHighestCatalystTier(long tier) {
        this.maxCatalystTier = tier;
        return this;
    }

    /**
     * Sets a discount for catalyst consumption that gets applied after regular calculations. Default is 0.
     * 
     * @param discount Discount in % (e.g. 15 = 15%)
     */
    public DTPFCalculator setCatalystDiscount(long discount) {
        this.catalystDiscount = discount;
        return this;
    }

    /**
     * Sets a discount for processing time that gets applied after regular calculations. Default is 0.
     * 
     * @param discount Discount in % (e.g. 15 = 15%)
     */
    public DTPFCalculator setProcessingTimeDiscount(long discount) {
        this.processingTimeDiscount = discount;
        return this;
    }

    /**
     * Sets a divisor for recipe voltage. The difference of energy between pre- and post-division gets added to the
     * recipe in form of catalyst instead. Default is 1.
     * 
     * @param divisor Voltage divisor as a float (e.g. 2 = half voltage)
     */
    public DTPFCalculator setEUtDivisor(float divisor) {
        this.EUtDivisor = divisor;
        return this;
    }

    /**
     * Use if the ebf recipe for the given material does not use its respective dust as input (e.g. neutronium needs raw
     * neutronium dust instead of regular neutronium dust).
     *
     * @param item The input item for the material's ebf recipe
     */
    public DTPFCalculator setCustomEBFinputItem(ItemStack item) {
        this.customInput = item;
        return this;
    }

    /**
     * Sets the scaling factor for dtpf recipes. This factor determines both the parallel increase and recipe time
     * decrease per catalyst tier (e.g. a factor of 2 means double parallel and half recipe time for each increase in
     * catalyst tier). Default is 2.
     *
     * @param factor The input item for the material's ebf recipe
     */
    public DTPFCalculator setScalingFactor(long factor) {
        this.scalingFactor = factor;
        return this;
    }

    /**
     * Gets the recipe duration for the given catalyst tier.
     *
     * @param catalystTier Catalyst tier of the recipe
     */
    public long getDuration(int catalystTier) {
        return (long) ((recipeDuration / Math.pow(scalingFactor, catalystTier + 1 - minCatalystTier))
                * (1 - processingTimeDiscount / 100f));
    }

    /**
     * Gets the recipe voltage for the given catalyst tier.
     *
     * @param catalystTier Catalyst tier of the recipe
     */
    public long getEUt(int catalystTier) {
        return (long) (DTPFEUt * Math.pow(scalingFactor, catalystTier - minCatalystTier) / EUtDivisor);
    }

    /**
     * Gets the amount of catalyst used for the given catalyst tier.
     *
     * @param catalystTier Catalyst tier of the recipe
     */
    public long getCatalystAmount(int catalystTier) {
        return catalyst_amounts[catalystTier];
    }

    /**
     * Gets the amount of residue produced for the given catalyst tier.
     *
     * @param catalystTier Catalyst tier of the recipe
     */
    public long getResidueAmount(int catalystTier) {
        return (long) (catalyst_amounts[catalystTier] * (Math.pow(2, catalystTier) / 8));
    }

    public static DTPFCalculator dtpfCalculator() {
        return new DTPFCalculator();
    }

}
