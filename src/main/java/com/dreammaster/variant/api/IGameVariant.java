package com.dreammaster.variant.api;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import com.google.common.collect.ImmutableList;

/**
 * Represents an optional game variant, which can configurably be loaded by the player.
 *
 * @author serenibyss
 * @since todo
 */
public interface IGameVariant {

    /**
     * @return Any game variants which are required for this game variant to load.
     */
    default String[] getDependencies() {
        return new String[0];
    }

    /**
     * @return Any game variants that this game variant cannot be used with.
     */
    default String[] getIncompatibilities() {
        return new String[0];
    }

    /**
     * @return Any classes that should be registered to the event bus.
     */
    default @NotNull List<Class<?>> getEventBusSubscribers() {
        return ImmutableList.of();
    }

    @NotNull
    Logger getLogger();
}
