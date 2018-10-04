package com.github.speisz.euler.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.speisz.euler.utils.MathUtil.pow;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ScalingPrimeSieveTest {

    private ScalingPrimeSieve sieve;

    @BeforeEach
    public void setUp() {
        sieve = ScalingPrimeSieve.create(100, 10);
    }

    @Test
    void scalesUpperBoundOnPurpose() {
        assertTrue(sieve.test(101));
        assertFalse(sieve.test(102));

        assertThat(sieve.getUpperBound(), is(1_000));
    }

    @Test
    void scalesEvenForHigherGaps() {
        assertTrue(sieve.test((int) pow(2, 17) - 1));

        assertThat(sieve.getUpperBound(), is(1_000_000));
    }
}
