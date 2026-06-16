package com.dreammaster.sgcalc;

import java.util.List;

/** A source-agnostic recipe: a list of inputs (each a set of acceptable alternatives) and the outputs it produces. */
public final class RecipeCandidate {

    public final String sourceId;
    public final List<Ingredient> inputs;
    public final List<Output> outputs;

    public RecipeCandidate(String sourceId, List<Ingredient> inputs, List<Output> outputs) {
        this.sourceId = sourceId;
        this.inputs = inputs;
        this.outputs = outputs;
    }

    /** How many of the item with {@code key} a single craft yields (at least 1). */
    public long outputAmount(String key) {
        for (Output o : outputs) {
            if (o.item.key.equals(key)) return Math.max(1, o.amount);
        }
        return 1;
    }

    /** Whether {@code key} is this recipe's main product (its first output), rather than a byproduct. */
    public boolean isPrimaryOutput(String key) {
        return !outputs.isEmpty() && outputs.get(0).item.key.equals(key);
    }

    /** One input slot: any of {@link #alts} satisfies it, consuming {@link #amount} per craft. */
    public static final class Ingredient {

        public final List<SGItem> alts;
        public final long amount;

        public Ingredient(List<SGItem> alts, long amount) {
            this.alts = alts;
            this.amount = amount;
        }
    }

    public static final class Output {

        public final SGItem item;
        public final long amount;

        public Output(SGItem item, long amount) {
            this.item = item;
            this.amount = amount;
        }
    }
}
