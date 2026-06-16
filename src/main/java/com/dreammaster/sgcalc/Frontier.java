package com.dreammaster.sgcalc;

import java.util.ArrayList;
import java.util.List;

/** An ordered set of {@link Matcher}s; recursion stops at the first matcher that accepts an item. */
public final class Frontier {

    private final List<Matcher> matchers = new ArrayList<>();

    public Frontier(List<String> specs) {
        for (String spec : specs) {
            if (spec == null || spec.trim().isEmpty() || spec.startsWith("#")) continue;
            matchers.add(Matcher.parse(spec.trim()));
        }
    }

    public Matcher find(SGItem item) {
        for (Matcher m : matchers) {
            if (m.matches(item)) return m;
        }
        return null;
    }
}
