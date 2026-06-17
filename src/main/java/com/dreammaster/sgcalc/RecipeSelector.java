package com.dreammaster.sgcalc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import com.dreammaster.sgcalc.RecipeCandidate.Ingredient;

/**
 * Chooses which recipe to follow when several produce the same item. After per-item overrides and denied sources are
 * applied, the production path is the one with the highest output per second measured across every step back to raw
 * materials -- i.e. the least total machine time to make one unit. Ties fall to a recipe that makes this item as a main
 * product, then the highest-powered machine (most EU/t), then fewest inputs. Every decision is logged so the
 * configuration can be tuned against the wiki.
 */
public final class RecipeSelector {

    private final List<String> denySources;
    private final List<Override> overrides = new ArrayList<>();
    private final RecipeIndex index;
    private final Set<String> rawStops;
    /** Memoized least total production time per item (in ticks per unit), shared across both passes. */
    private final Map<String, Double> timeMemo = new HashMap<>();

    public RecipeSelector(List<String> denySources, List<String> overrideSpecs, RecipeIndex index,
            Set<String> rawStops) {
        this.denySources = denySources;
        this.index = index;
        this.rawStops = rawStops;
        for (String spec : overrideSpecs) {
            if (spec == null || spec.trim().isEmpty() || spec.startsWith("#")) continue;
            overrides.add(Override.parse(spec));
        }
    }

    public RecipeCandidate select(SGItem item, List<RecipeCandidate> candidates, Set<String> visiting,
            Consumer<String> log) {
        // Drop recipe sources that should never be a production path (e.g. the replicator, which would create spurious
        // UU-matter demand). If this leaves nothing, the item has no producer and resolves as a raw leaf.
        List<RecipeCandidate> allowed = new ArrayList<>();
        for (RecipeCandidate c : candidates) {
            if (!isDenied(c.sourceId)) allowed.add(c);
        }
        if (allowed.isEmpty()) return null;

        List<RecipeCandidate> pool = allowed;
        for (Override override : overrides) {
            if (!override.matcher.matches(item)) continue;
            List<RecipeCandidate> filtered = new ArrayList<>();
            for (RecipeCandidate c : allowed) {
                if (sourceMatches(override.sourceId, c.sourceId)) filtered.add(c);
            }
            if (!filtered.isEmpty()) {
                pool = filtered;
                break;
            }
            log.accept("override for " + item.displayName() + " -> " + override.sourceId + " matched no candidate");
        }

        // Drop recipes that would consume an item still being resolved further up the stack (including the item
        // itself); following one would form a production cycle, such as a rod cut from a long rod that is in turn
        // forged from rods. If every producer is cyclic the item has no acyclic path and resolves as a raw leaf.
        List<RecipeCandidate> acyclic = new ArrayList<>();
        for (RecipeCandidate c : pool) {
            if (!createsCycle(c, visiting)) acyclic.add(c);
        }
        if (acyclic.isEmpty()) {
            log.accept("no acyclic recipe for " + item.displayName() + "; every producer needs an in-progress item");
            return null;
        }
        pool = acyclic;

        RecipeCandidate best = null;
        double bestTime = Double.POSITIVE_INFINITY;
        for (RecipeCandidate c : pool) {
            double time = totalTime(c, item.key);
            if (best == null || time < bestTime || (time == bestTime && tiePreferred(c, best, item.key))) {
                best = c;
                bestTime = time;
            }
        }
        if (pool.size() > 1) {
            log.accept(
                    "ambiguous " + item.displayName()
                            + ": "
                            + pool.size()
                            + " candidates, chose "
                            + (best != null ? best.sourceId : "none"));
        }
        return best;
    }

    /**
     * Least total production time (ticks per unit of {@code key}) when following this recipe, summing the per-unit
     * machine time of every step from raw materials. Lower means more output per second across the whole chain.
     */
    private double totalTime(RecipeCandidate candidate, String key) {
        Set<String> visiting = new HashSet<>();
        visiting.add(key);
        return recipeTime(candidate, key, visiting);
    }

    private double recipeTime(RecipeCandidate candidate, String key, Set<String> visiting) {
        double effectiveOutput = Math.max(1, candidate.outputAmount(key)) * (candidate.outputChance(key) / 10000.0);
        if (effectiveOutput <= 0) return Double.POSITIVE_INFINITY;
        // An instant (crafting-table) step still costs a notional tick so chains of them stay finite and comparable.
        double time = Math.max(1, candidate.duration) / effectiveOutput;
        for (Ingredient ing : candidate.inputs) {
            double cheapest = Double.POSITIVE_INFINITY;
            for (SGItem alt : ing.alts) {
                cheapest = Math.min(cheapest, itemTime(alt.key, visiting));
            }
            if (cheapest == Double.POSITIVE_INFINITY) return Double.POSITIVE_INFINITY;
            time += cheapest * ing.amount / effectiveOutput;
        }
        return time;
    }

    /** Least total production time of one unit of {@code key}, or 0 when it is a raw material (or has no producer). */
    private double itemTime(String key, Set<String> visiting) {
        if (rawStops.contains(key)) return 0.0;
        Double cached = timeMemo.get(key);
        if (cached != null) return cached;
        if (visiting.contains(key)) return Double.POSITIVE_INFINITY;

        boolean hasProducer = false;
        visiting.add(key);
        double best = Double.POSITIVE_INFINITY;
        for (RecipeCandidate c : index.producersOf(key)) {
            if (isDenied(c.sourceId)) continue;
            hasProducer = true;
            best = Math.min(best, recipeTime(c, key, visiting));
        }
        visiting.remove(key);

        if (!hasProducer) {
            timeMemo.put(key, 0.0);
            return 0.0;
        }
        // Every producer cycles back into the current path: treat as raw here, but do not memoize since that is only
        // true relative to this in-progress path, not globally.
        if (best == Double.POSITIVE_INFINITY) return 0.0;
        timeMemo.put(key, best);
        return best;
    }

    /** Deterministic tie-break when two recipes have equal total time: main product, then EU/t, then fewest inputs. */
    private static boolean tiePreferred(RecipeCandidate c, RecipeCandidate best, String key) {
        boolean cPrimary = c.isPrimaryOutput(key);
        boolean bestPrimary = best.isPrimaryOutput(key);
        if (cPrimary != bestPrimary) return cPrimary;
        if (c.euT != best.euT) return c.euT > best.euT;
        if (c.inputs.size() != best.inputs.size()) return c.inputs.size() < best.inputs.size();
        return c.sourceId.compareTo(best.sourceId) < 0;
    }

    /** A candidate is cyclic when one of its inputs can only be satisfied by an item that is already being resolved. */
    private static boolean createsCycle(RecipeCandidate candidate, Set<String> visiting) {
        for (Ingredient ing : candidate.inputs) {
            boolean satisfiable = false;
            for (SGItem alt : ing.alts) {
                if (!visiting.contains(alt.key)) {
                    satisfiable = true;
                    break;
                }
            }
            if (!satisfiable) return true;
        }
        return false;
    }

    private boolean isDenied(String sourceId) {
        for (String pattern : denySources) {
            if (pattern == null || pattern.trim().isEmpty() || pattern.startsWith("#")) continue;
            if (sourceMatches(pattern.trim(), sourceId)) return true;
        }
        return false;
    }

    private static boolean sourceMatches(String pattern, String sourceId) {
        if (pattern.equals("*")) return true;
        if (pattern.endsWith(":*")) return sourceId.startsWith(pattern.substring(0, pattern.length() - 1));
        return pattern.equals(sourceId);
    }

    private static final class Override {

        final Matcher matcher;
        final String sourceId;

        Override(Matcher matcher, String sourceId) {
            this.matcher = matcher;
            this.sourceId = sourceId;
        }

        static Override parse(String spec) {
            int arrow = spec.indexOf("=>");
            String left = spec.substring(0, arrow).trim();
            String right = spec.substring(arrow + 2).trim();
            int semi = right.indexOf(';');
            String sourceId = (semi >= 0 ? right.substring(0, semi) : right).trim();
            return new Override(Matcher.parse(left), sourceId);
        }
    }
}
