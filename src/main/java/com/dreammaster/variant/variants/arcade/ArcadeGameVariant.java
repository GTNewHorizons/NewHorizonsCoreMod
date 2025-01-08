package com.dreammaster.variant.variants.arcade;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import com.dreammaster.variant.GameVariants;
import com.dreammaster.variant.api.GameVariant;
import com.dreammaster.variant.api.IGameVariant;

@GameVariant(
        variantId = GameVariants.ARCADE,
        variantName = GameVariants.ARCADE_NAME,
        author = GameVariants.ARCADE_AUTHOR,
        version = GameVariants.ARCADE_VERSION)
public class ArcadeGameVariant implements IGameVariant {

    public static final Logger logger = LogManager.getLogger("GTNH Arcade Variant");

    @Override
    public String[] getDependencies() {
        return GameVariants.ARCADE_DEPENDENCIES;
    }

    @Override
    public String[] getIncompatibilities() {
        return GameVariants.ARCADE_INCOMPATIBILITIES;
    }

    @Override
    public @NotNull Logger getLogger() {
        return logger;
    }
}
