package com.dreammaster.sgcalc;

import java.util.Locale;

/**
 * Formats large quantities the way the Stargate wiki cost tables do: a `T`/`B`/`M`/`k` suffix with three significant
 * figures (e.g. `1.68T`, `458B`, `67.3B`, `9.70B`, `503k`), and a bare integer below 1000.
 */
public final class Magnitudes {

    private Magnitudes() {}

    public static String format(double value) {
        if (value < 0) return "-" + format(-value);
        if (value < 1000) return Long.toString(Math.round(value));

        String suffix;
        double scaled;
        if (value >= 1e12) {
            suffix = "T";
            scaled = value / 1e12;
        } else if (value >= 1e9) {
            suffix = "B";
            scaled = value / 1e9;
        } else if (value >= 1e6) {
            suffix = "M";
            scaled = value / 1e6;
        } else {
            suffix = "k";
            scaled = value / 1e3;
        }

        int decimals = scaled >= 100 ? 0 : scaled >= 10 ? 1 : 2;
        return String.format(Locale.US, "%." + decimals + "f", scaled) + suffix;
    }
}
