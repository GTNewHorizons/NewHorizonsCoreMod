package com.dreammaster.fluids;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.creativetab.ModTabList;
import com.dreammaster.lib.Refstrings;
import com.dreammaster.main.MainRegistry;

import eu.usrv.yamcore.fluids.ModFluidManager;
import eu.usrv.yamcore.fluids.ModSimpleBaseFluid;

public enum FluidList {

    Concrete(new ModSimpleBaseFluid(ModFluidManager.GetNewFluid("Concrete"), Material.water), ModTabList.ModFluidsTab),
    // Do not delete this
    EndOfList(null, null);

    // ################################################################################
    public ModSimpleBaseFluid Fluid;

    FluidList(ModSimpleBaseFluid pFluid, String pCreativeTabName) {
        Fluid = pFluid;
        if (Fluid != null) {
            Fluid.SetModID(Refstrings.MODID);
            Fluid.setCreativeTabName(pCreativeTabName);
        }
    }

    public static boolean AddToItemManager(ModFluidManager pFluidManager) {
        boolean tResult = true;
        for (FluidList il : FluidList.values()) {
            if (il.Fluid != null) {
                if (!pFluidManager.AddItemToManagedRegistry(il.Fluid)) {
                    MainRegistry.LOGGER.error("Fluid [{}] failed to register", il.toString());
                    tResult = false;
                }
            }
        }

        return tResult;
    }

    public FluidStack getFluidStack() {
        return getFluidStack(1000L);
    }

    public FluidStack getFluidStack(long ammount) {
        return new FluidStack(this.Fluid.getFluid(), (int) ammount);
    }
}
