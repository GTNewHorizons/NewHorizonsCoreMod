package com.dreammaster.sgcalc;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.dreammaster.sgcalc.CostResolver.Bucket;

class WikiWriterTest {

    private static Bucket bucket(String label, String unit, boolean bold, double amount) {
        Bucket b = new Bucket(label, unit, bold);
        b.amount = amount;
        return b;
    }

    @Test
    void rendersWikiTableInTheExpectedFormat(@TempDir File dir) throws Exception {
        List<Bucket> high = new ArrayList<>();
        high.add(bucket("Stargate Frame Part", "", false, 1326));
        high.add(bucket("UXV Field Generator", "", false, 561));
        List<Bucket> low = new ArrayList<>();
        low.add(bucket("Iron", "L", false, 1_680_000_000_000.0));
        low.add(bucket("UU-Matter", "L", true, 458_000_000_000.0));

        File file = WikiWriter.write(dir, "wiki-tables.txt", high, low);
        String content = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);

        assertThat(content).contains("{| class=\"wikitable\" style=\"width:100%;\"");
        assertThat(content).contains(
                "| colspan=\"4\" style=\"background-color:#12364B; color:white; text-align:center;\"|'''HIGH-LEVEL COST BREAKDOWN'''");
        assertThat(content).contains("|- style=\"height:50px;\"");
        assertThat(content).contains("| style=\"width:25%\" |1326 Stargate Frame Part");
        assertThat(content).contains("| style=\"width:25%\" |1.68T (L) Iron");
        assertThat(content).contains("| style=\"width:25%\" |'''458B (L) UU-Matter'''");
        assertThat(content).contains("|}");
    }

    @Test
    void padsTheFinalRowWithEmptyCells(@TempDir File dir) throws Exception {
        List<Bucket> single = new ArrayList<>();
        single.add(bucket("Stargate Core Crystal", "", false, 1));

        File file = WikiWriter.write(dir, "wiki-tables.txt", single, new ArrayList<>());
        String content = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);

        assertThat(content).contains("| style=\"width:25%\" |1 Stargate Core Crystal");
        // one populated cell followed by three empty padding cells in the four-column row
        assertThat(content).contains(
                "| style=\"width:25%\" |1 Stargate Core Crystal\n"
                        + "| style=\"width:25%\" |\n| style=\"width:25%\" |\n| style=\"width:25%\" |\n");
    }
}
