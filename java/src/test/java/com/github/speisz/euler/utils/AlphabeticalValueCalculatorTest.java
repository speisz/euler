package com.github.speisz.euler.utils;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AlphabeticalValueCalculatorTest {

    private AlphabeticalValueCalculator calculator = AlphabeticalValueCalculator.create();

    @Test
    public void calculatesValueBasedOnAlphabeticalValues() {
        assertThat(calculator.calculateFor("A"), is(1));
        assertThat(calculator.calculateFor("Z"), is(26));
        assertThat(calculator.calculateFor("CB"), is(3 + 2));
        assertThat(calculator.calculateFor("COLIN"), is(53));
    }
}
