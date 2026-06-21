package com.dreammaster.TwilightForest;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureComponent;

import gregtech.api.enums.Mods;
import twilightforest.TFFeature;
import twilightforest.integration.structures.TFMajorFeatureProviders;
import twilightforest.structures.ComponentTFHollowHill;
import twilightforest.world.TFGenCaveStalactite;

public class TwilightForestMajorFeatureOverride {

    private TwilightForestMajorFeatureOverride() {}

    public static void run() {
        MapGenStructureIO.func_143031_a(ComponentGregtechHollowHill.class, "GTTFHill");
        TFMajorFeatureProviders.addProvider(TwilightForestMajorFeatureOverride::provideGregtechHollowHills);
    }

    private static StructureComponent provideGregtechHollowHills(World world, Random rand, TFFeature feature, int x,
            int y, int z) {
        if (feature == TFFeature.hill1) {
            return new ComponentGregtechHollowHill(world, rand, 0, 1, x, y, z);
        }
        if (feature == TFFeature.hill2) {
            return new ComponentGregtechHollowHill(world, rand, 0, 2, x, y, z);
        }
        if (feature == TFFeature.hill3) {
            return new ComponentGregtechHollowHill(world, rand, 0, 3, x, y, z);
        }
        return null;
    }

    private static class ComponentGregtechHollowHill extends ComponentTFHollowHill {

        public ComponentGregtechHollowHill(World world, Random rand, int i, int size, int x, int y, int z) {
            super(world, rand, i, size, x, y, z);
        }

        @Override
        protected TFGenCaveStalactite makeRandomOreStalactite(Random stalRNG) {
            if (Mods.Thaumcraft.isModLoaded()) {
                return InfusedStoneHollowHill.makeStalactite(stalRNG);
            }
            return ClassicTfHollowHill.makeStalactite(stalRNG, getHillSize());
        }
    }
}
