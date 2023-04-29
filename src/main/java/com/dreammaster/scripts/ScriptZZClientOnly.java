package com.dreammaster.scripts;

import java.util.Arrays;
import java.util.List;

public class ScriptZZClientOnly implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "ZZ Client Only";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList();
    }

    @Override
    public void loadRecipes() {
        // TODO !!!
        /*
         * GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.CoinBlank", 1, 0, missing),
         * getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing)).itemOutputs(getModItem("dreamcraft",
         * "item.CoinChunkloaderTierI", 1, 0, missing)).fluidInputs(FluidRegistry.getFluidStack("ender",
         * 3000)).noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
         * GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.CoinBlank", 1, 0, missing),
         * getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing)).itemOutputs(getModItem("dreamcraft",
         * "item.CoinChunkloaderTierII", 1, 0, missing)).fluidInputs(FluidRegistry.getFluidStack("ender",
         * 6000)).noFluidOutputs().duration(600).eut(480).addTo(sAssemblerRecipes);
         * GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.CoinBlank", 1, 0, missing),
         * getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing)).itemOutputs(getModItem("dreamcraft",
         * "item.CoinChunkloaderTierIII", 1, 0, missing)).fluidInputs(FluidRegistry.getFluidStack("ender",
         * 12000)).noFluidOutputs().duration(600).eut(1920).addTo(sAssemblerRecipes);
         * GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.CoinBlank", 1, 0, missing),
         * getModItem("gregtech", "gt.integrated_circuit", 0, 4, missing)).itemOutputs(getModItem("dreamcraft",
         * "item.CoinChunkloaderTierIV", 1, 0, missing)).fluidInputs(FluidRegistry.getFluidStack("ender",
         * 24000)).noFluidOutputs().duration(600).eut(7680).addTo(sAssemblerRecipes);
         * GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.CoinBlank", 1, 0, missing),
         * getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing)).itemOutputs(getModItem("dreamcraft",
         * "item.CoinChunkloaderTierV", 1, 0, missing)).fluidInputs(FluidRegistry.getFluidStack("ender",
         * 48000)).noFluidOutputs().duration(600).eut(30720).addTo(sAssemblerRecipes);
         */
    }
}
