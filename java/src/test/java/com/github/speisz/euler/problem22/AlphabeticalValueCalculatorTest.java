package com.github.speisz.euler.problem22;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AlphabeticalValueCalculatorTest {
    @Test
    public void calculatesValueBasedOnAlphabeticalValues() {
        assertThat(AlphabeticalValueCalculator.create().calculateFor("COLIN"), is(53));
    }
}
