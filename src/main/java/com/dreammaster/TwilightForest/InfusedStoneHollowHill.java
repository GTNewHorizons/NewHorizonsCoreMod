package com.dreammaster.TwilightForest;

import java.util.Random;

import gregtech.api.enums.Materials;
import twilightforest.world.TFGenCaveStalactite;

public class InfusedStoneHollowHill {

    static final TFGenCaveStalactite aer = new GregtechStalactite(Materials.InfusedAir, 0.7F, 8, 1);
    static final TFGenCaveStalactite aqua = new GregtechStalactite(Materials.InfusedWater, 0.7F, 8, 1);
    static final TFGenCaveStalactite ignis = new GregtechStalactite(Materials.InfusedFire, 0.7F, 8, 1);
    static final TFGenCaveStalactite ordo = new GregtechStalactite(Materials.InfusedOrder, 0.7F, 8, 1);
    static final TFGenCaveStalactite perditio = new GregtechStalactite(Materials.InfusedEntropy, 0.7F, 8, 1);
    static final TFGenCaveStalactite terra = new GregtechStalactite(Materials.InfusedEarth, 0.7F, 8, 1);
    static final TFGenCaveStalactite amber = new GregtechStalactite(Materials.Amber, 0.8F, 12, 1);
    static final TFGenCaveStalactite cinnabar = new GregtechStalactite(Materials.Cinnabar, 0.8F, 8, 1);

    static TFGenCaveStalactite makeStalactite(Random rand) {
        if (rand.nextInt(2) == 0) {
            return switch (rand.nextInt(6)) {
                case 0 -> aer;
                case 1 -> aqua;
                case 2 -> ignis;
                case 3 -> ordo;
                case 4 -> perditio;
                default -> terra;
            };
        } else {
            return rand.nextInt(3) == 0 ? cinnabar : amber;
        }
    }
}
