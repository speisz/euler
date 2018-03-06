package com.github.speisz.euler.problem12;

import org.junit.Test;

import static java.math.BigInteger.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TriangleNumberWithGivenDivisorCountTest {

    @Test
    public void computesForLowDivisorCount() {
        assertThat(new TriangleNumberWithGivenDivisorCount().compute(5), is(valueOf(28)));
    }

    @Test
    public void computesForHighDivisorCount() {
        assertThat(new TriangleNumberWithGivenDivisorCount().compute(500), is(valueOf(76576500)));
    }
}
