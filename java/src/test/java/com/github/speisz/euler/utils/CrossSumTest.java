package com.github.speisz.euler.utils;

import org.junit.jupiter.api.Test;

import static java.math.BigInteger.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CrossSumTest {
    @Test
    void computesSumOfDigits() {
        assertThat(CrossSum.of(valueOf(0)), is(valueOf(0)));
        assertThat(CrossSum.of(valueOf(1)), is(valueOf(1)));
        assertThat(CrossSum.of(valueOf(123)), is(valueOf(1 + 2 + 3)));
    }
}
