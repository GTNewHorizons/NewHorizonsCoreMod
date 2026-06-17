package com.dreammaster.sgcalc;

import java.util.List;

/** A source-agnostic recipe: a list of inputs (each a set of acceptable alternatives) and the outputs it produces. */
public final class RecipeCandidate {

    public final String sourceId;
    public final List<Ingredient> inputs;
    public final List<Output> outputs;
    /** Energy draw in EU/t; 0 for crafting-table sources that have no machine power. */
    public final int euT;
    /** Processing time in ticks; 0 for instant (crafting-table) sources. */
    public final int duration;

    public RecipeCandidate(String sourceId, List<Ingredient> inputs, List<Output> outputs) {
        this(sourceId, inputs, outputs, 0, 0);
    }

    public RecipeCandidate(String sourceId, List<Ingredient> inputs, List<Output> outputs, int euT, int duration) {
        this.sourceId = sourceId;
        this.inputs = inputs;
        this.outputs = outputs;
        this.euT = euT;
        this.duration = duration;
    }

    /** How many of the item with {@code key} a single craft yields (at least 1). */
    public long outputAmount(String key) {
        for (Output o : outputs) {
            if (o.item.key.equals(key)) return Math.max(1, o.amount);
        }
        return 1;
    }

    /** This recipe's output chance for {@code key}, out of 10000 (10000 = guaranteed); 10000 if it is not an output. */
    public int outputChance(String key) {
        for (Output o : outputs) {
            if (o.item.key.equals(key)) return o.chance;
        }
        return 10000;
    }

    /**
     * Whether {@code key} is one of this recipe's main products rather than a byproduct. The first item output and the
     * first fluid output both count as primary, since a recipe whose real product is a fluid may still list an item
     * (e.g. catalyst residue) first.
     */
    public boolean isPrimaryOutput(String key) {
        Output primaryItem = null;
        Output primaryFluid = null;
        for (Output o : outputs) {
            if (o.item.isFluid()) {
                if (primaryFluid == null) primaryFluid = o;
            } else if (primaryItem == null) {
                primaryItem = o;
            }
        }
        return (primaryItem != null && primaryItem.item.key.equals(key))
                || (primaryFluid != null && primaryFluid.item.key.equals(key));
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
        /** Output chance out of 10000 (10000 = guaranteed); below that for chanced byproducts. */
        public final int chance;

        public Output(SGItem item, long amount) {
            this(item, amount, 10000);
        }

        public Output(SGItem item, long amount, int chance) {
            this.item = item;
            this.amount = amount;
            this.chance = chance;
        }
    }
}
