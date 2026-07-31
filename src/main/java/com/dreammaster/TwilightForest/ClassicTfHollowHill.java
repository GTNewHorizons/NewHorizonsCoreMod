package com.dreammaster.TwilightForest;

import static twilightforest.world.TFGenCaveStalactite.glowstone;

import java.util.Random;

import gregtech.api.enums.materials2.Materials2Materials;
import twilightforest.world.TFGenCaveStalactite;

public class ClassicTfHollowHill {

    private static final TFGenCaveStalactite diamond = new GregtechStalactite(Materials2Materials.Diamond, 0.5F, 4, 16);
    private static final TFGenCaveStalactite lapis = new GregtechStalactite(Materials2Materials.Lapis, 0.8F, 8, 1);
    private static final TFGenCaveStalactite emerald = new GregtechStalactite(Materials2Materials.Emerald, 0.5F, 3, 12);
    private static final TFGenCaveStalactite gold = new GregtechStalactite(Materials2Materials.Gold, 0.6F, 6, 1);
    private static final TFGenCaveStalactite redstone = new GregtechStalactite(
            Materials2Materials.Redstone,
            0.8F,
            8,
            1);
    private static final TFGenCaveStalactite iron = new GregtechStalactite(Materials2Materials.Iron, 0.7F, 8, 1);
    private static final TFGenCaveStalactite coal = new GregtechStalactite(Materials2Materials.Coal, 0.8F, 12, 1);

    // Copied from Twilight Forest's implementation, but returns our own stalactites most of the time
    static TFGenCaveStalactite makeStalactite(Random rand, int hillSize) {
        if (hillSize >= 3 || hillSize >= 2 && rand.nextInt(5) == 0) {
            int s3 = rand.nextInt(13);
            if (s3 == 0 || s3 == 1) {
                return diamond;
            }

            if (s3 == 2 || s3 == 3) {
                return lapis;
            }

            if (s3 == 4) {
                return emerald;
            }
        }

        if (hillSize >= 2 || hillSize >= 1 && rand.nextInt(5) == 0) {
            int s2 = rand.nextInt(6);
            if (s2 == 0) {
                return gold;
            }

            if (s2 == 1 || s2 == 2) {
                return redstone;
            }
        }

        int s1 = rand.nextInt(5);
        if (s1 != 0 && s1 != 1) {
            if (s1 != 2 && s1 != 3) {
                return glowstone;
            } else {
                return coal;
            }
        } else {
            return iron;
        }
    }
}
