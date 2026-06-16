package com.dreammaster.sgcalc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        public double amount;

        Bucket(String label, String unit, boolean bold) {
            this.label = label;
            this.unit = unit;
            this.bold = bold;
        }
    }

    public static final class PassResult {

        public final List<Bucket> entries;
        public final int unresolvedCount;

        PassResult(List<Bucket> entries, int unresolvedCount) {
            this.entries = entries;
            this.unresolvedCount = unresolvedCount;
        }
    }

    public PassResult resolve(List<Root> roots, Frontier frontier, Frontier boldFrontier) {
        Map<String, Map<String, Double>> memo = new HashMap<>();
        Map<String, Bucket> buckets = new LinkedHashMap<>();
        Set<String> unresolved = new HashSet<>();
        Set<String> visiting = new HashSet<>();
        Map<String, Double> totals = new HashMap<>();

        for (Root root : roots) {
            if (root.stack() == null) continue;
            Map<String, Double> unit = unitCost(
                    SGItem.of(root.stack()),
                    frontier,
                    boldFrontier,
                    memo,
                    buckets,
                    unresolved,
                    visiting);
            for (Map.Entry<String, Double> e : unit.entrySet()) {
                totals.merge(e.getKey(), e.getValue() * root.quantity(), Double::sum);
            }
        }

        List<Bucket> entries = new ArrayList<>();
        for (Map.Entry<String, Double> e : totals.entrySet()) {
            Bucket bucket = buckets.get(e.getKey());
            if (bucket == null) continue;
            bucket.amount = e.getValue();
            entries.add(bucket);
        }
        entries.sort(Comparator.comparingDouble((Bucket b) -> b.amount).reversed());
        return new PassResult(entries, unresolved.size());
    }

    private Map<String, Double> unitCost(SGItem item, Frontier frontier, Frontier boldFrontier,
            Map<String, Map<String, Double>> memo, Map<String, Bucket> buckets, Set<String> unresolved,
            Set<String> visiting) {
        Matcher matcher = frontier.find(item);
        if (matcher != null) {
            String key = matcher.bucketKey();
            buckets.computeIfAbsent(
                    key,
                    k -> new Bucket(matcher.label(item), unitOf(matcher), isBold(boldFrontier, item)));
            return Collections.singletonMap(key, perUnitContribution(matcher, item));
        }

        Map<String, Double> cached = memo.get(item.key);
        if (cached != null) return cached;
        if (visiting.contains(item.key)) {
            trace.add("cycle broken at " + item.key);
            return leaf(item, boldFrontier, buckets, unresolved);
        }

        RecipeCandidate recipe = selector.select(item, index.producersOf(item.key), trace::add);
        if (recipe == null) {
            Map<String, Double> result = leaf(item, boldFrontier, buckets, unresolved);
            memo.put(item.key, result);
            return result;
        }

        visiting.add(item.key);
        long produced = recipe.outputAmount(item.key);
        Map<String, Double> result = new HashMap<>();
        for (Ingredient ing : recipe.inputs) {
            SGItem alt = chooseAlt(ing, frontier);
            Map<String, Double> sub = unitCost(alt, frontier, boldFrontier, memo, buckets, unresolved, visiting);
            double factor = (double) ing.amount / produced;
            for (Map.Entry<String, Double> e : sub.entrySet()) {
                result.merge(e.getKey(), e.getValue() * factor, Double::sum);
            }
        }
        visiting.remove(item.key);
        memo.put(item.key, result);
        return result;
    }

    private Map<String, Double> leaf(SGItem item, Frontier boldFrontier, Map<String, Bucket> buckets,
            Set<String> unresolved) {
        String key = "unresolved:" + item.key;
        unresolved.add(item.key);
        buckets.computeIfAbsent(
                key,
                k -> new Bucket(item.displayName(), item.isFluid() ? "L" : "", isBold(boldFrontier, item)));
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

    private SGItem chooseAlt(Ingredient ing, Frontier frontier) {
        if (ing.alts.size() == 1) return ing.alts.get(0);
        for (SGItem alt : ing.alts) {
            if (frontier.find(alt) != null) return alt;
        }
        for (SGItem alt : ing.alts) {
            if (!index.producersOf(alt.key).isEmpty()) return alt;
        }
        SGItem guess = ing.alts.get(0);
        trace.add("ore-dict input guessed -> " + guess.key);
        return guess;
    }
}
