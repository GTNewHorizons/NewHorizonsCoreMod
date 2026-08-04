package com.dreammaster.mixin;

import javax.annotation.Nonnull;

import com.gtnewhorizon.gtnhmixins.builders.IMixins;
import com.gtnewhorizon.gtnhmixins.builders.MixinBuilder;

public enum Mixins implements IMixins {

    // spotless:off
    REGISTER_BOP_WOOD_VARIANTS(new MixinBuilder()
            .addCommonMixins("MixinBOPBlocks")
            .addRequiredMod(TargetedMod.BOP)
            .setPhase(Phase.LATE)),
    WARDING_FOCUS_STAYS_IN_GRID(new MixinBuilder()
            .addCommonMixins("MixinFocusWarding")
            .addRequiredMod(TargetedMod.THAUMCRAFT)
            .setPhase(Phase.LATE));
    // spotless:on

    private final MixinBuilder builder;

    Mixins(MixinBuilder builder) {
        this.builder = builder;
    }

    @Nonnull
    @Override
    public MixinBuilder getBuilder() {
        return this.builder;
    }
}
