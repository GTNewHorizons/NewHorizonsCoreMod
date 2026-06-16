package com.dreammaster.sgcalc;

import java.util.function.Consumer;

/** A provider of {@link RecipeCandidate}s from one of GTNH's many recipe systems. */
public interface RecipeSource {

    void collect(Consumer<RecipeCandidate> sink);
}
