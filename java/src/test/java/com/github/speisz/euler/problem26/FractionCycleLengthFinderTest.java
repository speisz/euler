package com.github.speisz.euler.problem26;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FractionCycleLengthFinderTest {
    @Test
    public void findsLengthOfRecurringCyclesForNonPeriodicUnitFractions() {
        assertThat(FractionCycleLengthFinder.findFor(1), is(0));
        assertThat(FractionCycleLengthFinder.findFor(2), is(0));
        assertThat(FractionCycleLengthFinder.findFor(5), is(0));
        assertThat(FractionCycleLengthFinder.findFor(8), is(0));
        assertThat(FractionCycleLengthFinder.findFor(10), is(0));
    }

    @Test
    public void findsLengthOfRecurringCyclesForPeriodicUnitFractions() {
        assertThat(FractionCycleLengthFinder.findFor(3), is(1));
        assertThat(FractionCycleLengthFinder.findFor(6), is(1));
        assertThat(FractionCycleLengthFinder.findFor(7), is(6));
    }

    @Test
    public void findsLengthOfRecurringCyclesForLongPeriodicUnitFractions() {
        assertThat(FractionCycleLengthFinder.findFor(85), is(17));
    }
}
