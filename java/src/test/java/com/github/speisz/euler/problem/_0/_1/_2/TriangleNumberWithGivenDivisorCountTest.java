package com.github.speisz.euler.problem._0._1._2;

import org.junit.jupiter.api.Test;

import static java.math.BigInteger.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class TriangleNumberWithGivenDivisorCountTest {

    @Test
    void computesForLowDivisorCount() {
        assertThat(TriangleNumberWithGivenDivisorCount.compute(5), is(28L));
    }

    @Test
    void computesForHighDivisorCount() {
        assertThat(TriangleNumberWithGivenDivisorCount.compute(500), is(76_576_500L));
    }
}
