package com.dreammaster.sgcalc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.minecraft.item.ItemStack;

import com.dreammaster.sgcalc.RecipeCandidate.Ingredient;

import gregtech.api.enums.GTValues;
import gregtech.api.objects.ItemData;
import gregtech.api.util.GTOreDictUnificator;

/**
 * Walks the recipe graph from the Stargate roots and tallies cost against a frontier allowlist (section 6 of the plan).
 * Unit costs are memoized per item so shared sub-graphs are computed once; recipe cycles are broken via a visiting set
 * and reported as unresolved leaves.
 */
public final class CostResolver {

    /** One unit of molten material is 144 L (one ingot-equivalent). */
    private static final double LITRES_PER_UNIT = 144.0;

    private final RecipeIndex index;
    private final RecipeSelector selector;
    private final List<String> trace = new ArrayList<>();
    /** Stack of `item <recipe-source>` frames for the chain currently being resolved, used to report leaf consumers. */
    private final Deque<String> consumerPath = new ArrayDeque<>();
    private final Set<String> loggedLeaves = new HashSet<>();

    public CostResolver(RecipeIndex index, RecipeSelector selector) {
        this.index = index;
        this.selector = selector;
    }

    public List<String> trace() {
        return trace;
    }

    public static final class Root {

        private final ItemStack stack;
        private final double quantity;

        public Root(ItemStack stack, double quantity) {
            this.stack = stack;
            this.quantity = quantity;
        }

        public ItemStack stack() {
            return stack;
        }

        public double quantity() {
            return quantity;
        }
    }

    public static final class Bucket {

        public final String label;
        public final String unit;
        public final boolean bold;
        public final boolean resolved;
        public double amount;

        Bucket(String label, String unit, boolean bold, boolean resolved) {
            this.label = label;
            this.unit = unit;
            this.bold = bold;
            this.resolved = resolved;
        }
    }

    public static final class PassResult {

        /** Items that matched the frontier allowlist -- the actual table rows. */
        public final List<Bucket> entries;
        /** Items that decomposed past the frontier with no recipe -- below the frontier or a bad path; a tuning aid. */
        public final List<Bucket> unresolved;

        PassResult(List<Bucket> entries, List<Bucket> unresolved) {
            this.entries = entries;
            this.unresolved = unresolved;
        }

        public int unresolvedCount() {
            return unresolved.size();
        }
    }

    public PassResult resolve(List<Root> roots, Frontier frontier, Frontier boldFrontier, Set<String> rawStops,
            boolean countRawStops) {
        Map<String, Map<String, Double>> memo = new HashMap<>();
        Map<String, Bucket> buckets = new LinkedHashMap<>();
        Set<String> visiting = new HashSet<>();
        Map<String, Double> totals = new HashMap<>();

        for (Root root : roots) {
            if (root.stack() == null) continue;
            Map<String, Double> unit = unitCost(
                    SGItem.of(root.stack()),
                    frontier,
                    boldFrontier,
                    rawStops,
                    countRawStops,
                    memo,
                    buckets,
                    visiting);
            for (Map.Entry<String, Double> e : unit.entrySet()) {
                totals.merge(e.getKey(), e.getValue() * root.quantity(), Double::sum);
            }
        }

        List<Bucket> entries = new ArrayList<>();
        List<Bucket> unresolvedEntries = new ArrayList<>();
        for (Map.Entry<String, Double> e : totals.entrySet()) {
            Bucket bucket = buckets.get(e.getKey());
            if (bucket == null) continue;
            bucket.amount = e.getValue();
            (bucket.resolved ? entries : unresolvedEntries).add(bucket);
        }
        Comparator<Bucket> byAmountDesc = Comparator.comparingDouble((Bucket b) -> b.amount).reversed();
        entries.sort(byAmountDesc);
        unresolvedEntries.sort(byAmountDesc);
        return new PassResult(entries, unresolvedEntries);
    }

    private Map<String, Double> unitCost(SGItem item, Frontier frontier, Frontier boldFrontier, Set<String> rawStops,
            boolean countRawStops, Map<String, Map<String, Double>> memo, Map<String, Bucket> buckets,
            Set<String> visiting) {
        Matcher matcher = frontier.find(item);
        if (matcher != null) {
            String key = matcher.bucketKey();
            buckets.computeIfAbsent(
                    key,
                    k -> new Bucket(matcher.label(item), unitOf(matcher), isBold(boldFrontier, item), true));
            return Collections.singletonMap(key, perUnitContribution(matcher, item));
        }

        // Raw-source outputs (e.g. anything the Eye of Harmony produces) and mined ores are raw ingredients: stop
        // recursing in both passes. The low-level pass counts them as raws; the high-level pass treats them as
        // below-frontier leaves (unless an explicit frontier entry above already gave them a nicer label).
        if (rawStops.contains(item.key) || item.isRawOreForm()) {
            if (!countRawStops) return leaf(item, boldFrontier, buckets);
            String key = "raw:" + item.key;
            buckets.computeIfAbsent(
                    key,
                    k -> new Bucket(item.displayName(), item.isFluid() ? "L" : "", isBold(boldFrontier, item), true));
            return Collections.singletonMap(key, 1.0);
        }

        Map<String, Double> cached = memo.get(item.key);
        if (cached != null) return cached;
        if (visiting.contains(item.key)) {
            trace.add("cycle broken at " + item.displayName());
            if (countRawStops) logUnresolved(item, "cycle");
            return leaf(item, boldFrontier, buckets);
        }

        // Add the item to the in-progress set before selecting so the selector can reject any producer that would
        // consume it (or an ancestor) and form a cycle.
        visiting.add(item.key);
        RecipeCandidate recipe = selector.select(item, index.producersOf(item), visiting, trace::add);
        if (recipe == null) {
            visiting.remove(item.key);
            if (countRawStops) logUnresolved(item, "no producer");
            Map<String, Double> result = leaf(item, boldFrontier, buckets);
            memo.put(item.key, result);
            return result;
        }

        long produced = recipe.outputAmount(item.key);
        Map<String, Double> result = new HashMap<>();
        consumerPath.addLast(item.displayName() + " <" + recipe.sourceId + ">");
        for (Ingredient ing : recipe.inputs) {
            SGItem alt = chooseAlt(ing, frontier, visiting);
            Map<String, Double> sub = unitCost(
                    alt,
                    frontier,
                    boldFrontier,
                    rawStops,
                    countRawStops,
                    memo,
                    buckets,
                    visiting);
            double factor = (double) ing.amount / produced;
            for (Map.Entry<String, Double> e : sub.entrySet()) {
                result.merge(e.getKey(), e.getValue() * factor, Double::sum);
            }
        }
        consumerPath.removeLast();
        visiting.remove(item.key);
        memo.put(item.key, result);
        return result;
    }

    /**
     * Records, once per distinct unresolved leaf, the chain of `item <recipe-source>` frames that led to it. The last
     * frame is the recipe that directly consumes the leaf, which is what identifies a wrong selection (e.g. a finished
     * tool or machine pulled in as an ingredient instead of the material-level path).
     */
    private void logUnresolved(SGItem item, String why) {
        if (!loggedLeaves.add(item.key)) return;
        String chain = consumerPath.isEmpty() ? "(root)" : String.join(" > ", consumerPath);
        trace.add("UNRESOLVED [" + why + "] " + item.displayName() + " {" + item.key + "}" + "  <==  " + chain);
    }

    private Map<String, Double> leaf(SGItem item, Frontier boldFrontier, Map<String, Bucket> buckets) {
        String key = "unresolved:" + item.key;
        buckets.computeIfAbsent(
                key,
                k -> new Bucket(item.displayName(), item.isFluid() ? "L" : "", isBold(boldFrontier, item), false));
        return Collections.singletonMap(key, 1.0);
    }

    private static boolean isBold(Frontier boldFrontier, SGItem item) {
        return boldFrontier != null && boldFrontier.find(item) != null;
    }

    private double perUnitContribution(Matcher matcher, SGItem item) {
        if (matcher.type == Matcher.Type.MATERIAL && !item.isFluid()) {
            ItemData data = GTOreDictUnificator.getAssociation(item.stack);
            if (data != null && data.mMaterial != null) {
                return (data.mMaterial.mAmount / (double) GTValues.M) * LITRES_PER_UNIT;
            }
        }
        return 1.0;
    }

    private String unitOf(Matcher matcher) {
        if (!matcher.unit.isEmpty()) return matcher.unit;
        return matcher.type == Matcher.Type.MATERIAL ? "L" : "";
    }

    private SGItem chooseAlt(Ingredient ing, Frontier frontier, Set<String> visiting) {
        if (ing.alts.size() == 1) return ing.alts.get(0);
        for (SGItem alt : ing.alts) {
            if (!visiting.contains(alt.key) && frontier.find(alt) != null) return alt;
        }
        for (SGItem alt : ing.alts) {
            if (!visiting.contains(alt.key) && !index.producersOf(alt).isEmpty()) return alt;
        }
        for (SGItem alt : ing.alts) {
            if (!visiting.contains(alt.key)) return alt;
        }
        SGItem guess = ing.alts.get(0);
        trace.add("ore-dict input guessed -> " + guess.displayName());
        return guess;
    }
}
