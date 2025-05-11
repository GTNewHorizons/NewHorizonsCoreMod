package com.dreammaster.iguana;

import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;

import com.dreammaster.fluids.FluidList;

import cpw.mods.fml.common.registry.GameRegistry;
import iguanaman.iguanatweakstconstruct.claybuckets.ClayBucketHandler;
import iguanaman.iguanatweakstconstruct.claybuckets.items.BaseClayBucket;

public class IguanaProxy {

    public static Item clayBucketConcrete;

    public static void doInitialization() {
        registerConcreteClayBucket();
    }

    private static void registerConcreteClayBucket() {
        String concreteClayBucketName = "clayBucketConcrete";
        Fluid concrete = FluidList.Concrete.getFluidStack().getFluid();
        clayBucketConcrete = new BaseClayBucket(
                concrete.getBlock(),
                concreteClayBucketName,
                "dreamcraft:itemClayBucketConcrete");
        GameRegistry.registerItem(clayBucketConcrete, concreteClayBucketName);
        ClayBucketHandler.registerClayBucket(clayBucketConcrete, concrete, concrete.getBlock());
    }

}
