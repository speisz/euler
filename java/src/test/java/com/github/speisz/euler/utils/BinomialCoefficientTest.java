package com.github.speisz.euler.utils;

import org.junit.jupiter.api.Test;

import static java.math.BigInteger.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class BinomialCoefficientTest {
    @Test
    void computesBinomialCoefficients() {
        assertThat(BinomialCoefficient.of(1, 1), is(valueOf(1)));
        assertThat(BinomialCoefficient.of(2, 1), is(valueOf(2)));
        assertThat(BinomialCoefficient.of(3, 1), is(valueOf(3)));
        assertThat(BinomialCoefficient.of(3, 2), is(valueOf(3)));
        assertThat(BinomialCoefficient.of(4, 1), is(valueOf(4)));
        assertThat(BinomialCoefficient.of(4, 2), is(valueOf(6)));
        assertThat(BinomialCoefficient.of(4, 3), is(valueOf(4)));
    }
}
