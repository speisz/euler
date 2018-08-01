package com.github.speisz.euler.math;

import org.junit.Before;
import org.junit.Test;

import static com.github.speisz.euler.utils.MathUtil.pow;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ScalingPrimeSieveTest {

    private ScalingPrimeSieve sieve;

    @Before
    public void setUp() {
        sieve = new ScalingPrimeSieve(100, 10);
    }

    @Test
    public void scalesUpperBoundOnPurpose() {
        assertTrue(sieve.test(101));
        assertFalse(sieve.test(102));

        assertThat(sieve.getUpperBound(), is(1_000));
    }

    @Test
    public void scalesEvenForHigherGaps() {
        assertTrue(sieve.test((int) pow(2, 17) - 1));

        assertThat(sieve.getUpperBound(), is(1_000_000));
    }
}
