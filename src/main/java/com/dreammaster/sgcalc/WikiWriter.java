package com.dreammaster.sgcalc;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import com.dreammaster.sgcalc.CostResolver.Bucket;

/** Renders breakdowns as MediaWiki tables in the same shape as the Stargate wiki "Cost Breakdown" section. */
public final class WikiWriter {

    private WikiWriter() {}

    public static File write(File dir, String fileName, List<Bucket> highLevel, List<Bucket> lowLevel)
            throws IOException {
        String content = table("HIGH-LEVEL COST BREAKDOWN", highLevel) + "\n"
                + table("LOW-LEVEL COST BREAKDOWN", lowLevel)
                + "\n";
        File file = new File(dir, fileName);
        Files.write(file.toPath(), content.getBytes(StandardCharsets.UTF_8));
        return file;
    }

    private static String table(String title, List<Bucket> entries) {
        StringBuilder sb = new StringBuilder();
        sb.append("{| class=\"wikitable\" style=\"width:100%;\"\n");
        sb.append("| colspan=\"4\" style=\"background-color:#12364B; color:white; text-align:center;\"|'''")
                .append(title).append("'''\n");
        for (int i = 0; i < entries.size(); i += 4) {
            sb.append("|- style=\"height:50px;\"\n");
            for (int col = 0; col < 4; col++) {
                int idx = i + col;
                sb.append("| style=\"width:25%\" |");
                if (idx < entries.size()) sb.append(cell(entries.get(idx)));
                sb.append('\n');
            }
        }
        sb.append("|}\n");
        return sb.toString();
    }

    private static String cell(Bucket b) {
        String unitPart = b.unit.isEmpty() ? "" : " (" + b.unit + ")";
        String text = Magnitudes.format(b.amount) + unitPart + " " + b.label;
        return b.bold ? "'''" + text + "'''" : text;
    }
}
