package com.dreammaster.sgcalc;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Locale;

import com.dreammaster.sgcalc.CostResolver.Bucket;

/** Writes a breakdown as a CSV with `name,quantity,unit` columns, sorted by quantity descending. */
public final class CsvWriter {

    private CsvWriter() {}

    public static File write(File dir, String fileName, List<Bucket> entries) throws IOException {
        StringBuilder sb = new StringBuilder("name,quantity,unit\n");
        for (Bucket b : entries) {
            sb.append(quote(b.label)).append(',').append(String.format(Locale.US, "%.0f", b.amount)).append(',')
                    .append(quote(b.unit)).append('\n');
        }
        File file = new File(dir, fileName);
        Files.write(file.toPath(), sb.toString().getBytes(StandardCharsets.UTF_8));
        return file;
    }

    private static String quote(String value) {
        return '"' + value.replace("\"", "\"\"") + '"';
    }
}
