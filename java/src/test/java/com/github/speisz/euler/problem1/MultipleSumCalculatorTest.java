package com.github.speisz.euler.problem1;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MultipleSumCalculatorTest {

    @Test
    public void sumsMultiplesUpToSpecifiedBoundary() {
        int sum = MultipleSumCalculator.forBases(3).computeSumOfMultiplesUpTo(20);
        assertThat(sum, is(3 + 6 + 9 + 12 + 15 + 18));
    }

    @Test
    public void sumsMultiplesForAllGivenBasesUpToSpecifiedBoundary() {
        MultipleSumCalculator multipleSumCalculator = MultipleSumCalculator.forBases(3, 5);

        assertThat(multipleSumCalculator.computeSumOfMultiplesUpTo(15), is(3 + 5 + 6 + 9 + 10 + 12 + 15));
        assertThat(multipleSumCalculator.computeSumOfMultiplesUpTo(999), is(233168));
    }
}
