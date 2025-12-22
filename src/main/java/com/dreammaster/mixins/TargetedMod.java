package com.dreammaster.mixins;

import org.jetbrains.annotations.NotNull;

import com.gtnewhorizon.gtnhmixins.builders.ITargetMod;
import com.gtnewhorizon.gtnhmixins.builders.TargetModBuilder;

public enum TargetedMod implements ITargetMod {

    // spotless:off
    WITCHERY("witchery"),
            ;
    // spotless:on

    private final TargetModBuilder builder;

    TargetedMod(TargetModBuilder builder) {
        this.builder = builder;
    }

    TargetedMod(String modId) {
        this(null, modId, null);
    }

    TargetedMod(String coreModClass, String modId) {
        this(coreModClass, modId, null);
    }

    TargetedMod(String coreModClass, String modId, String targetClass) {
        this.builder = new TargetModBuilder().setCoreModClass(coreModClass).setModId(modId).setTargetClass(targetClass);
    }

    @NotNull
    @Override
    public TargetModBuilder getBuilder() {
        return builder;
    }
}
