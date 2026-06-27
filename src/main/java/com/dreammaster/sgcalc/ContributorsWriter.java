package com.dreammaster.sgcalc;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Locale;

import com.dreammaster.sgcalc.CostResolver.BucketContribution;
import com.dreammaster.sgcalc.CostResolver.ConsumerShare;

/**
 * Writes the demand attribution as a CSV: one row per (frontier item, consuming recipe) pair, giving how much of that
 * item the recipe pulls and its share of the item's total demand. Rows are grouped by item (highest total demand first)
 * and, within each item, by consumer share. This answers "what is driving this material/circuit" -- the row's consumer
 * names the recipe and its output that directly demands the item.
 */
public final class ContributorsWriter {

    private ContributorsWriter() {}

    public static File write(File dir, String fileName, List<BucketContribution> contributions) throws IOException {
        StringBuilder sb = new StringBuilder("item,unit,total,consumer,amount,percent\n");
        for (BucketContribution bc : contributions) {
            for (ConsumerShare cs : bc.consumers) {
                double percent = bc.total > 0 ? cs.amount / bc.total * 100.0 : 0.0;
                sb.append(quote(bc.label)).append(',').append(quote(bc.unit)).append(',').append(amount(bc.total))
                        .append(',').append(quote(cs.label)).append(',').append(amount(cs.amount)).append(',')
                        .append(String.format(Locale.US, "%.1f", percent)).append('\n');
            }
        }
        File file = new File(dir, fileName);
        Files.write(file.toPath(), sb.toString().getBytes(StandardCharsets.UTF_8));
        return file;
    }

    private static String amount(double value) {
        return String.format(Locale.US, "%.0f", value);
    }

    private static String quote(String value) {
        return '"' + value.replace("\"", "\"\"") + '"';
    }
}
