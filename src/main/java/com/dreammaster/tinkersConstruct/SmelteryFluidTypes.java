package com.dreammaster.tinkersConstruct;

import javax.annotation.Nonnull;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import tconstruct.TConstruct;
import tconstruct.library.crafting.FluidType;
import tconstruct.library.crafting.Smeltery;
import tconstruct.smeltery.TinkerSmeltery;
import tconstruct.world.TinkerWorld;

public class SmelteryFluidTypes {

    public static void registerGregtechFluidTypes() {
        // Zinc looks the same as TiCo Aluminium when melting but results in GT Zinc instead of TiCo Aluminium
        Fluid moltenZinc = FluidRegistry.getFluid("molten.zinc");
        Fluid moltenBrass = FluidRegistry.getFluid(getMoltenPatternFluidName());
        FluidType.registerFluidType("Zinc", TinkerWorld.metalBlock, 6, 350, moltenZinc, false);
        FluidType
                .registerFluidType(getMoltenPatternFluidTypeName(), TinkerWorld.metalBlock, 7, 350, moltenBrass, false);
        Smeltery.addAlloyMixing(
                new FluidStack(moltenBrass, TConstruct.nuggetLiquidValue * 3),
                new FluidStack(TinkerSmeltery.moltenCopperFluid, TConstruct.nuggetLiquidValue * 3),
                new FluidStack(moltenZinc, TConstruct.nuggetLiquidValue * 1)); // Brass
    }

    @Nonnull
    public static String getMoltenPatternFluidTypeName() {
        return "Brass";
    }

    @Nonnull
    public static String getMoltenPatternFluidName() {
        return "molten.brass";
    }

}
