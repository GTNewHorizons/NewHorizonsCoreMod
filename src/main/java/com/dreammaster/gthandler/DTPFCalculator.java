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
    protected ItemStack[] itemInputs = new ItemStack[0];
    protected FluidStack[] fluidInputs = new FluidStack[0];
    protected long ebfEUpertick = 0;
    protected long ebfDuration = 0;
    protected long freezerEUpertick = 0;
    protected long freezerDuration = 0;
    protected long baseParallel = 0;
    protected long DTPFEUt = 0;
    protected long totalBaseEU = 0;
    protected long minCatalystTier = 0;
    protected long maxCatalystTier = 4;
    Collection<GT_Recipe> ebfRecipes = blastFurnaceRecipes.getAllRecipes();
    Collection<GT_Recipe> freezerRecipes = vacuumFreezerRecipes.getAllRecipes();
    private int[] catalyst_amounts = new int[5];
    private static final FluidStack[] CATALYSTS = new FluidStack[] { MaterialsUEVplus.ExcitedDTCC.getFluid(1),
            MaterialsUEVplus.ExcitedDTPC.getFluid(1), MaterialsUEVplus.ExcitedDTRC.getFluid(1),
            MaterialsUEVplus.ExcitedDTEC.getFluid(1), MaterialsUEVplus.ExcitedDTSC.getFluid(1) };
    // These were calculated based on their respective mixer + laser engraver recipes & their plasma energy values
    private static final long[] CATALYST_ENERGY_VALUES = new long[] { 14_514_983L, 66_768_460L, 269_326_451L,
            1_073_007_393L, 4_276_767_521L };

    public DTPFCalculator calculateGenericEBFBasedRecipe(Materials material) {
        determineEBFParams(material);
        determineFreezerParams(material);
        calculateBaseDTPFPowerConsumption();
        calculateCatalystAmounts();
        return this;
    }

    private void determineEBFParams(Materials material) {
        ArrayList<GT_Recipe> foundEBFRecipes = new ArrayList<>();
        // Find correct ebf recipes
        for (GT_Recipe recipe : ebfRecipes) {
            if (GT_Utility.areStacksEqual(material.getDust(1), recipe.mInputs[0])) {
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
    }

    private void calculateCatalystAmounts() {
        for (long i = 0; i <= (maxCatalystTier - minCatalystTier); i++) {
            catalyst_amounts[(int) (minCatalystTier + i)] = (int) (((totalBaseEU * (0.8 - i * 0.1) * Math.pow(2, i)
                    - DTPFEUt * Math.pow(2, i) * (ebfDuration / Math.pow(2, i + 1)))
                    / CATALYST_ENERGY_VALUES[(int) (minCatalystTier + i)]));
        }
    }

    public DTPFCalculator setBaseParallel(long parallel) {
        this.baseParallel = parallel;
        return this;
    }

    public DTPFCalculator setLowestCatalystTier(long tier) {
        this.minCatalystTier = tier;
        return this;
    }

    public DTPFCalculator setHighestCatalystTier(long tier) {
        this.maxCatalystTier = tier;
        return this;
    }

    public DTPFCalculator fluidInputs(FluidStack... fluidInputs) {
        this.fluidInputs = fluidInputs;
        return this;
    }

    public long getDuration(int catalystTier) {
        return (long) (ebfDuration / Math.pow(2, catalystTier + 1));
    }

    public long getEUt(int catalystTier) {
        return (long) (DTPFEUt * Math.pow(2, catalystTier));
    }

    public long getCatalystAmount(int catalystTier) {
        return catalyst_amounts[catalystTier];
    }

    public long getResidueAmount(int catalystTier) {
        return (long) (catalyst_amounts[catalystTier] * (Math.pow(2, catalystTier) / 8));
    }

    public static DTPFCalculator dtpfCalculator() {
        return new DTPFCalculator();
    }

}
