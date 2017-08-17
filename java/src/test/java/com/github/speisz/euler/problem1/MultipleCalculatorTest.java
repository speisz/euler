package com.github.speisz.euler.problem1;

import org.junit.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

public class MultipleCalculatorTest {

    @Test
    public void givesEmptyIfThereIsNoPositiveMultipleNotGreaterThanSpecifiedBoundary() {
        assertThat(MultipleCalculator.forBase(3).computeUpTo(0), is(empty()));
    }

    @Test
    public void givesBaseAsSingleMultipleIfItIsEqualToSpecifiedBoundary() {
        Set<Integer> multiples = MultipleCalculator.forBase(3).computeUpTo(3);

        assertThat(multiples, hasSize(1));
        assertThat(multiples, containsInAnyOrder(3));
    }

    @Test
    public void givesMultiplesUpToSpecifiedBoundary() {
        Set<Integer> multiples = MultipleCalculator.forBase(3).computeUpTo(20);

        assertThat(multiples, hasSize(6));
        assertThat(multiples, containsInAnyOrder(3, 6, 9, 12, 15, 18));
    }
}
