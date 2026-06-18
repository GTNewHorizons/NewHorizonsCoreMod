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
    private final List<String> fallbackSources;
    private final List<Override> overrides = new ArrayList<>();
    private final RecipeIndex index;
    private final Set<String> rawStops;
    /** The low-level frontier, used as the raw boundary when costing a chain: a frontier item ends production at 0. */
    private final Frontier rawBoundary;
    /**
     * Wall-clock ceiling on the whole cost walk. A healthy resolve finishes in seconds; if it runs past this an
     * uncosted recipe cycle is multiplying the work, so the command aborts with a clear error instead of hanging the
     * game thread indefinitely. Checked only every {@link #STEP_CHECK_MASK}+1 steps to keep the clock read off the hot
     * path.
     */
    private static final long MAX_MILLIS = 180_000L;
    private static final long STEP_CHECK_MASK = 0xFFFFFL;

    /** Memoized least total production time per item (in ticks per unit), shared across both passes. */
    private final Map<String, Double> timeMemo = new HashMap<>();
    private long costSteps;
    private long startMillis = -1L;

    public RecipeSelector(List<String> denySources, List<String> fallbackSources, List<String> overrideSpecs,
            RecipeIndex index, Set<String> rawStops, Frontier rawBoundary) {
        this.denySources = denySources;
        this.fallbackSources = fallbackSources;
        this.index = index;
        this.rawStops = rawStops;
        this.rawBoundary = rawBoundary;
        for (String spec : overrideSpecs) {
            if (spec == null || spec.trim().isEmpty() || spec.startsWith("#")) continue;
            overrides.add(Override.parse(spec));
        }
    }

    public RecipeCandidate select(SGItem item, List<RecipeCandidate> candidates, Set<String> visiting,
            Consumer<String> log) {
        // Split producers into primary and fallback tiers, dropping denied sources entirely (e.g. the replicator, which
        // would create spurious UU-matter demand). Fallback sources (vanilla crafting) are only consulted when no
        // primary producer yields a usable recipe, so an item with a real machine recipe never resolves through a
        // crafting-table short-circuit, while one that genuinely has only a vanilla recipe still resolves.
        // A per-item override naming a source rescues that source past the deny list, so a single item can be pointed
        // at an otherwise-denied map (e.g. the canner for one coolant cell) without re-enabling it for everything.
        Override active = matchingOverride(item);
        List<RecipeCandidate> primary = new ArrayList<>();
        List<RecipeCandidate> fallback = new ArrayList<>();
        for (RecipeCandidate c : candidates) {
            boolean overridden = active != null && sourceMatches(active.sourceId, c.sourceId);
            if (!overridden && isDenied(c.sourceId)) continue;
            (!overridden && isFallback(c.sourceId) ? fallback : primary).add(c);
        }

        RecipeCandidate chosen = selectFrom(item, primary, visiting, log);
        if (chosen == null) chosen = selectFrom(item, fallback, visiting, log);
        if (chosen == null && !(primary.isEmpty() && fallback.isEmpty())) {
            log.accept("no acyclic recipe for " + item.displayName() + "; every producer needs an in-progress item");
        }
        return chosen;
    }

    /** The first override whose matcher accepts {@code item}, or null when none applies. */
    private Override matchingOverride(SGItem item) {
        for (Override override : overrides) {
            if (override.matcher.matches(item)) return override;
        }
        return null;
    }

    /** Applies overrides, drops cyclic producers and ranks the survivors; returns null if {@code pool} yields none. */
    private RecipeCandidate selectFrom(SGItem item, List<RecipeCandidate> pool, Set<String> visiting,
            Consumer<String> log) {
        if (pool.isEmpty()) return null;

        for (Override override : overrides) {
            if (!override.matcher.matches(item)) continue;
            List<RecipeCandidate> filtered = new ArrayList<>();
            for (RecipeCandidate c : pool) {
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
        if (acyclic.isEmpty()) return null;
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
                cheapest = Math.min(cheapest, itemTime(alt, visiting));
            }
            if (cheapest == Double.POSITIVE_INFINITY) return Double.POSITIVE_INFINITY;
            time += cheapest * ing.amount / effectiveOutput;
        }
        return time;
    }

    /** Least total production time of one unit of {@code item}, or 0 when it is a raw material. */
    private double itemTime(SGItem item, Set<String> visiting) {
        if (++costSteps == 1) {
            startMillis = System.currentTimeMillis();
        } else if ((costSteps & STEP_CHECK_MASK) == 0 && System.currentTimeMillis() - startMillis > MAX_MILLIS) {
            throw new IllegalStateException(
                    "sgcalc cost walk ran past " + (MAX_MILLIS / 1000)
                            + "s ("
                            + costSteps
                            + " steps); an uncosted recipe cycle is likely multiplying the work. See the last progress"
                            + " line in sgcalc-trace.log for where it was.");
        }
        String key = item.key;
        Double cached = timeMemo.get(key);
        if (cached != null) return cached;
        // A raw material ends the chain at no cost: an explicit raw source output, a mined ore, or a low-level frontier
        // item (the boundary at which the breakdown stops counting). Memoize it -- these are the leaves of every chain,
        // so the ore-dictionary lookup and frontier scan here would otherwise repeat on every encounter.
        if (rawStops.contains(key) || item.isRawOreForm() || rawBoundary.find(item) != null) {
            timeMemo.put(key, 0.0);
            return 0.0;
        }
        if (visiting.contains(key)) return Double.POSITIVE_INFINITY;

        boolean hasProducer = false;
        visiting.add(key);
        double best = Double.POSITIVE_INFINITY;
        for (RecipeCandidate c : index.producersOf(key)) {
            if (isDenied(c.sourceId) || isFallback(c.sourceId)) continue;
            hasProducer = true;
            best = Math.min(best, recipeTime(c, key, visiting));
        }
        // Only price a fallback (vanilla) producer when there is no primary one, mirroring select(), so the 1-tick cost
        // of a crafting-table recipe never undercuts a real machine recipe that exists for the same item.
        if (!hasProducer) {
            for (RecipeCandidate c : index.producersOf(key)) {
                if (isDenied(c.sourceId) || !isFallback(c.sourceId)) continue;
                hasProducer = true;
                best = Math.min(best, recipeTime(c, key, visiting));
            }
        }
        visiting.remove(key);

        // An item with no producer at all is unmakeable: a finished tool, machine or block, or a dead-end intermediate.
        // An infinite cost keeps a reversal recipe -- one melting, cutting or macerating a finished item back into its
        // material -- from looking free and beating the real forward recipe. The producer list never changes, so this
        // is memoized to avoid re-walking the same dead-end subtree for every reversal candidate that consumes it.
        if (!hasProducer) {
            timeMemo.put(key, Double.POSITIVE_INFINITY);
            return Double.POSITIVE_INFINITY;
        }
        // Every producer loops back into an item already on the current path, so there is no acyclic way to make this
        // here. Report it as unmakeable but do not memoize: it is relative to the in-progress path.
        if (best == Double.POSITIVE_INFINITY) return Double.POSITIVE_INFINITY;
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
        return matchesAny(denySources, sourceId);
    }

    private boolean isFallback(String sourceId) {
        return matchesAny(fallbackSources, sourceId);
    }

    private static boolean matchesAny(List<String> patterns, String sourceId) {
        if (patterns == null) return false;
        for (String pattern : patterns) {
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
