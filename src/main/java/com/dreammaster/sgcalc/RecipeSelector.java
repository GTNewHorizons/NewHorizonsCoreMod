package com.dreammaster.sgcalc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Chooses which recipe to follow when several produce the same item. After per-item overrides and denied sources are
 * applied, the production path is the fastest output (most produced per second, weighted by output chance), then a
 * recipe that makes this item as a main product rather than a byproduct, then the highest-powered machine (most EU/t).
 * Every decision is logged so the configuration can be tuned against the wiki.
 */
public final class RecipeSelector {

    private final List<String> denySources;
    private final List<Override> overrides = new ArrayList<>();

    public RecipeSelector(List<String> denySources, List<String> overrideSpecs) {
        this.denySources = denySources;
        for (String spec : overrideSpecs) {
            if (spec == null || spec.trim().isEmpty() || spec.startsWith("#")) continue;
            overrides.add(Override.parse(spec));
        }
    }

    public RecipeCandidate select(SGItem item, List<RecipeCandidate> candidates, Consumer<String> log) {
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

        RecipeCandidate best = null;
        for (RecipeCandidate c : pool) {
            if (best == null || isBetter(c, best, item.key)) best = c;
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
     * Production-path ordering: most produced per second, then where {@code key} is a main product, then most EU/t.
     * Fewest inputs and the source id break any remaining ties so selection stays deterministic.
     */
    private static boolean isBetter(RecipeCandidate c, RecipeCandidate best, String key) {
        double cRate = c.ratePerSecond(key);
        double bestRate = best.ratePerSecond(key);
        if (cRate != bestRate) return cRate > bestRate;
        boolean cPrimary = c.isPrimaryOutput(key);
        boolean bestPrimary = best.isPrimaryOutput(key);
        if (cPrimary != bestPrimary) return cPrimary;
        if (c.euT != best.euT) return c.euT > best.euT;
        if (c.inputs.size() != best.inputs.size()) return c.inputs.size() < best.inputs.size();
        return c.sourceId.compareTo(best.sourceId) < 0;
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
