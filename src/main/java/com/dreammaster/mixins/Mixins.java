package com.dreammaster.mixins;

import org.jetbrains.annotations.NotNull;

import com.gtnewhorizon.gtnhmixins.builders.IMixins;
import com.gtnewhorizon.gtnhmixins.builders.MixinBuilder;

public enum Mixins implements IMixins {

    // spotless:off
    WITCHERY_SILVER_VAT(new MixinBuilder()
            .addCommonMixins("witchery.MixinBlockSilverVat")
            .addRequiredMod(TargetedMod.WITCHERY)
            .setPhase(Phase.LATE)),
    ;
    // spotless:on

    private final MixinBuilder builder;

    Mixins(MixinBuilder builder) {
        this.builder = builder;
    }

    @NotNull
    @Override
    public MixinBuilder getBuilder() {
        return builder;
    }
}
