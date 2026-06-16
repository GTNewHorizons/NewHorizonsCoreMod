package com.dreammaster.sgcalc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MagnitudesTest {

    @Test
    void formatsWikiSampleValues() {
        assertThat(Magnitudes.format(1_680_000_000_000.0)).isEqualTo("1.68T");
        assertThat(Magnitudes.format(458_000_000_000.0)).isEqualTo("458B");
        assertThat(Magnitudes.format(160_000_000_000.0)).isEqualTo("160B");
        assertThat(Magnitudes.format(67_300_000_000.0)).isEqualTo("67.3B");
        assertThat(Magnitudes.format(9_700_000_000.0)).isEqualTo("9.70B");
        assertThat(Magnitudes.format(699_000_000.0)).isEqualTo("699M");
        assertThat(Magnitudes.format(98_700_000.0)).isEqualTo("98.7M");
        assertThat(Magnitudes.format(503_000.0)).isEqualTo("503k");
    }

    @Test
    void formatsSmallValuesAsIntegers() {
        assertThat(Magnitudes.format(512)).isEqualTo("512");
        assertThat(Magnitudes.format(192)).isEqualTo("192");
        assertThat(Magnitudes.format(0)).isEqualTo("0");
    }

    @Test
    void usesThreeSignificantFigures() {
        assertThat(Magnitudes.format(1_510_000_000.0)).isEqualTo("1.51B");
        assertThat(Magnitudes.format(46_000_000.0)).isEqualTo("46.0M");
        assertThat(Magnitudes.format(3_310_000_000.0)).isEqualTo("3.31B");
    }
}
