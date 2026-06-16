package com.dreammaster.sgcalc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Chooses which recipe to follow when several produce the same item, encoding the wiki's "criteria" (DTPF for
 * superconductors, Component Assembly Line for components, PCB Factory for boards, etc.). Resolution order: per-item
 * override, then a configured source-priority list, then a deterministic tie-break. Every decision is logged so the
 * configuration can be tuned against the wiki.
 */
public final class RecipeSelector {

    private final List<String> sourcePriority;
    private final List<Override> overrides = new ArrayList<>();

    public RecipeSelector(List<String> sourcePriority, List<String> overrideSpecs) {
        this.sourcePriority = sourcePriority;
        for (String spec : overrideSpecs) {
            if (spec == null || spec.trim().isEmpty() || spec.startsWith("#")) continue;
            overrides.add(Override.parse(spec));
        }
    }

    public RecipeCandidate select(SGItem item, List<RecipeCandidate> candidates, Consumer<String> log) {
        if (candidates.isEmpty()) return null;

        List<RecipeCandidate> pool = candidates;
        for (Override override : overrides) {
            if (!override.matcher.matches(item)) continue;
            List<RecipeCandidate> filtered = new ArrayList<>();
            for (RecipeCandidate c : candidates) {
                if (sourceMatches(override.sourceId, c.sourceId)) filtered.add(c);
            }
            if (!filtered.isEmpty()) {
                pool = filtered;
                break;
            }
            log.accept("override for " + item.key + " -> " + override.sourceId + " matched no candidate");
        }

        RecipeCandidate best = null;
        int bestRank = Integer.MAX_VALUE;
        int bestInputs = Integer.MAX_VALUE;
        for (RecipeCandidate c : pool) {
            int rank = priorityRank(c.sourceId);
            int inputs = c.inputs.size();
            if (rank < bestRank || (rank == bestRank && inputs < bestInputs)) {
                best = c;
                bestRank = rank;
                bestInputs = inputs;
            }
        }
        if (pool.size() > 1) {
            log.accept(
                    "ambiguous " + item.key
                            + ": "
                            + pool.size()
                            + " candidates, chose "
                            + (best != null ? best.sourceId : "none"));
        }
        return best;
    }

    private int priorityRank(String sourceId) {
        for (int i = 0; i < sourcePriority.size(); i++) {
            if (sourceMatches(sourcePriority.get(i), sourceId)) return i;
        }
        return Integer.MAX_VALUE;
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
