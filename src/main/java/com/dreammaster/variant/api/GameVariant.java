package com.dreammaster.variant.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker annotation for {@link IGameVariant} objects. Specifies metadata for a game variant, such as the name, id, and
 * variants that it requires or cannot be loaded alongside.
 *
 * @author serenibyss
 * @since todo
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface GameVariant {

    /**
     * The ID of this game variant.
     */
    String variantId();

    /**
     * The human-readable name of this game variant.
     */
    String variantName();

    /**
     * The author of this game variant.
     */
    String author();

    /**
     * The pack version this game variant was introduced (should be a stable pack version).
     */
    String version();
}
