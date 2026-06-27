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

import com.dreammaster.main.MainRegistry;
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

    /** How many recipe selections between progress reports; resolution can run for many seconds on a full Stargate. */
    private static final int PROGRESS_EVERY = 2000;

    private final RecipeIndex index;
    private final RecipeSelector selector;
    private final List<String> trace = new ArrayList<>();
    /** Stack of `item <recipe-source>` frames for the chain currently being resolved, used to report leaf consumers. */
    private final Deque<String> consumerPath = new ArrayDeque<>();
    private final Set<String> loggedLeaves = new HashSet<>();
    private int selectCount;
    private Runnable progressHook;

    /**
     * Per-pass attribution capture, reset at the start of each {@link #resolve}. {@link #edgesOf} maps a resolved item
     * to the items its chosen recipe consumes, each with the per-output factor (amount per one of the parent);
     * {@link #recipeSourceOf} records the recipe that did so; {@link #terminalBucketOf}/{@link #terminalUnitOf} record,
     * for every leaf (a frontier item, a raw, or an unresolved dead-end), its bucket and per-unit contribution; and
     * {@link #displayOf} keeps a friendly name per item. {@link #buildContributions} walks this graph top-down to
     * attribute each frontier item's total demand to the recipes that directly consume it.
     */
    private Map<String, List<Edge>> edgesOf = new HashMap<>();
    private Map<String, String> recipeSourceOf = new HashMap<>();
    private Map<String, String> terminalBucketOf = new HashMap<>();
    private Map<String, Double> terminalUnitOf = new HashMap<>();
    private Map<String, String> displayOf = new HashMap<>();

    public CostResolver(RecipeIndex index, RecipeSelector selector) {
        this.index = index;
        this.selector = selector;
    }

    /**
     * Invoked periodically during a resolve so the caller can flush the in-progress trace and show the run advancing.
     */
    public void setProgressHook(Runnable progressHook) {
        this.progressHook = progressHook;
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
        /** Per frontier item, the recipes that directly consume it ranked by how much of it they demand. */
        public final List<BucketContribution> contributions;

        PassResult(List<Bucket> entries, List<Bucket> unresolved, List<BucketContribution> contributions) {
            this.entries = entries;
            this.unresolved = unresolved;
            this.contributions = contributions;
        }

        public int unresolvedCount() {
            return unresolved.size();
        }
    }

    /** A single frontier item with the recipes that directly consume it, ranked by demand; see {@link PassResult}. */
    public static final class BucketContribution {

        public final String label;
        public final String unit;
        public final boolean resolved;
        public final double total;
        public final List<ConsumerShare> consumers;

        BucketContribution(String label, String unit, boolean resolved, double total, List<ConsumerShare> consumers) {
            this.label = label;
            this.unit = unit;
            this.resolved = resolved;
            this.total = total;
            this.consumers = consumers;
        }
    }

    /** One consuming recipe's share of a frontier item's demand. */
    public static final class ConsumerShare {

        public final String label;
        public final double amount;

        ConsumerShare(String label, double amount) {
            this.label = label;
            this.amount = amount;
        }
    }

    /** A consumed-item edge of a chosen recipe: {@code factor} is how many {@code child} one parent output needs. */
    private static final class Edge {

        final String child;
        final double factor;

        Edge(String child, double factor) {
            this.child = child;
            this.factor = factor;
        }
    }

    public PassResult resolve(List<Root> roots, Frontier frontier, Frontier boldFrontier, Set<String> rawStops,
            boolean countRawStops) {
        edgesOf = new HashMap<>();
        recipeSourceOf = new HashMap<>();
        terminalBucketOf = new HashMap<>();
        terminalUnitOf = new HashMap<>();
        displayOf = new HashMap<>();
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
        return new PassResult(entries, unresolvedEntries, buildContributions(roots, buckets));
    }

    /**
     * Attributes each frontier item's total demand to the recipes that directly consume it. Root quantities are pushed
     * top-down through the captured chosen-recipe edges to give every item its global demand; each leaf edge then
     * credits its bucket to the consuming recipe. The selector never lets a recipe consume an item already on its path,
     * so the captured edges form a DAG and a topological order suffices.
     */
    private List<BucketContribution> buildContributions(List<Root> roots, Map<String, Bucket> buckets) {
        Map<String, Double> demand = new HashMap<>();
        for (Root root : roots) {
            if (root.stack() == null) continue;
            demand.merge(SGItem.of(root.stack()).key, root.quantity(), Double::sum);
        }
        for (String parent : topoOrder()) {
            double d = demand.getOrDefault(parent, 0.0);
            List<Edge> edges = edgesOf.get(parent);
            if (d == 0.0 || edges == null) continue;
            for (Edge e : edges) demand.merge(e.child, d * e.factor, Double::sum);
        }

        Map<String, Map<String, Double>> attribution = new HashMap<>();
        for (Map.Entry<String, List<Edge>> entry : edgesOf.entrySet()) {
            double d = demand.getOrDefault(entry.getKey(), 0.0);
            if (d == 0.0) continue;
            String consumer = displayOf.getOrDefault(entry.getKey(), entry.getKey()) + " <"
                    + recipeSourceOf.getOrDefault(entry.getKey(), "?")
                    + ">";
            for (Edge e : entry.getValue()) {
                String bucketKey = terminalBucketOf.get(e.child);
                if (bucketKey == null) continue;
                double amount = d * e.factor * terminalUnitOf.getOrDefault(e.child, 1.0);
                attribution.computeIfAbsent(bucketKey, k -> new HashMap<>()).merge(consumer, amount, Double::sum);
            }
        }
        // A root that is itself a frontier item has no consuming recipe; credit it to the gate directly.
        for (Root root : roots) {
            if (root.stack() == null) continue;
            String key = SGItem.of(root.stack()).key;
            String bucketKey = terminalBucketOf.get(key);
            if (bucketKey == null) continue;
            double amount = root.quantity() * terminalUnitOf.getOrDefault(key, 1.0);
            attribution.computeIfAbsent(bucketKey, k -> new HashMap<>()).merge("(stargate)", amount, Double::sum);
        }

        List<BucketContribution> out = new ArrayList<>();
        for (Map.Entry<String, Map<String, Double>> entry : attribution.entrySet()) {
            Bucket bucket = buckets.get(entry.getKey());
            if (bucket != null) out.add(bucketContribution(bucket, entry.getValue()));
        }
        out.sort(Comparator.comparingDouble((BucketContribution b) -> b.total).reversed());
        return out;
    }

    /** A Kahn topological order of the captured edge graph; reports (but tolerates) a cycle that should not occur. */
    private List<String> topoOrder() {
        Map<String, Integer> indegree = new HashMap<>();
        for (Map.Entry<String, List<Edge>> entry : edgesOf.entrySet()) {
            indegree.putIfAbsent(entry.getKey(), 0);
            for (Edge e : entry.getValue()) indegree.merge(e.child, 1, Integer::sum);
        }
        Deque<String> queue = new ArrayDeque<>();
        for (Map.Entry<String, Integer> e : indegree.entrySet()) {
            if (e.getValue() == 0) queue.add(e.getKey());
        }
        List<String> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            String node = queue.poll();
            order.add(node);
            List<Edge> edges = edgesOf.get(node);
            if (edges == null) continue;
            for (Edge e : edges) {
                if (indegree.merge(e.child, -1, Integer::sum) == 0) queue.add(e.child);
            }
        }
        if (order.size() < indegree.size()) {
            trace.add("attribution: chosen-recipe graph has a cycle; contributor amounts may be partial");
        }
        return order;
    }

    private static BucketContribution bucketContribution(Bucket bucket, Map<String, Double> consumers) {
        double total = 0.0;
        List<ConsumerShare> shares = new ArrayList<>();
        for (Map.Entry<String, Double> c : consumers.entrySet()) {
            shares.add(new ConsumerShare(c.getKey(), c.getValue()));
            total += c.getValue();
        }
        shares.sort(Comparator.comparingDouble((ConsumerShare s) -> s.amount).reversed());
        int cap = 12;
        if (shares.size() > cap) {
            double other = 0.0;
            for (int i = cap; i < shares.size(); i++) other += shares.get(i).amount;
            int more = shares.size() - cap;
            shares = new ArrayList<>(shares.subList(0, cap));
            shares.add(new ConsumerShare("(" + more + " more consumers)", other));
        }
        return new BucketContribution(bucket.label, bucket.unit, bucket.resolved, total, shares);
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
            double per = perUnitContribution(matcher, item);
            recordTerminal(item, key, per);
            return Collections.singletonMap(key, per);
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
            recordTerminal(item, key, 1.0);
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
        reportProgress(item);
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
        recipeSourceOf.put(item.key, recipe.sourceId);
        displayOf.computeIfAbsent(item.key, k -> item.displayName());
        List<Edge> edges = edgesOf.computeIfAbsent(item.key, k -> new ArrayList<>());
        consumerPath.addLast(item.displayName() + " {" + item.key + "} <" + recipe.sourceId + ">");
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
            edges.add(new Edge(alt.key, factor));
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
    /** Every {@link #PROGRESS_EVERY} selections, append a progress line, log it, and flush the trace via the hook. */
    private void reportProgress(SGItem item) {
        if (++selectCount != 1 && selectCount % PROGRESS_EVERY != 0) return;
        String line = "progress: " + selectCount
                + " selections, depth "
                + consumerPath.size()
                + ", at "
                + item.displayName();
        trace.add(line);
        MainRegistry.LOGGER.info("sgcalc " + line);
        if (progressHook != null) progressHook.run();
    }

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
        recordTerminal(item, key, 1.0);
        return Collections.singletonMap(key, 1.0);
    }

    private void recordTerminal(SGItem item, String bucketKey, double perUnit) {
        terminalBucketOf.put(item.key, bucketKey);
        terminalUnitOf.put(item.key, perUnit);
        displayOf.computeIfAbsent(item.key, k -> item.displayName());
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
