package com.github.speisz.euler.math;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static java.math.BigInteger.valueOf;
import static java.util.Collections.emptyMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PrimeFactorizationTest {
    @Test
    void computesFactorizationOfBigIntegerOneAsEmpty() {
        assertThat(PrimeFactorization.of(BigInteger.ONE), is(emptyMap()));
    }

    @Test
    void computesFactorizationOfPrimeBigIntegers() {
        assertThat(PrimeFactorization.of(valueOf(2)), is(ImmutableMap.of(valueOf(2), 1)));
        assertThat(PrimeFactorization.of(valueOf(3)), is(ImmutableMap.of(valueOf(3), 1)));
        assertThat(PrimeFactorization.of(valueOf(5)), is(ImmutableMap.of(valueOf(5), 1)));
    }

    @Test
    void computesFactorizationOfMultiplesOfPrimeBigIntegers() {
        assertThat(PrimeFactorization.of(valueOf(2 * 2)), is(ImmutableMap.of(valueOf(2), 2)));
        assertThat(PrimeFactorization.of(valueOf(3 * 3 * 3)), is(ImmutableMap.of(valueOf(3), 3)));
        assertThat(PrimeFactorization.of(valueOf(5 * 5 * 5 * 5)), is(ImmutableMap.of(valueOf(5), 4)));
    }

    @Test
    void computesFactorizationOfArbitraryBigIntegers() {
        assertThat(PrimeFactorization.of(valueOf(2 * 2 * 3)), is(ImmutableMap.builder()
                .put(valueOf(2), 2)
                .put(valueOf(3), 1)
                .build()));
        assertThat(PrimeFactorization.of(valueOf(2 * 3 * 3 * 5 * 5 * 5)), is(ImmutableMap.builder()
                .put(valueOf(2), 1)
                .put(valueOf(3), 2)
                .put(valueOf(5), 3)
                .build()));
    }

    @Test
    void computesFactorizationOfIntegerOneAsEmpty() {
        assertThat(PrimeFactorization.of(1), is(emptyMap()));
    }

    @Test
    void computesFactorizationOfPrimeIntegers() {
        assertThat(PrimeFactorization.of(2), is(ImmutableMap.of(2, 1)));
        assertThat(PrimeFactorization.of(3), is(ImmutableMap.of(3, 1)));
        assertThat(PrimeFactorization.of(5), is(ImmutableMap.of(5, 1)));
    }

    @Test
    void computesFactorizationOfMultiplesOfPrimeIntegers() {
        assertThat(PrimeFactorization.of(2 * 2), is(ImmutableMap.of(2, 2)));
        assertThat(PrimeFactorization.of(3 * 3 * 3), is(ImmutableMap.of(3, 3)));
        assertThat(PrimeFactorization.of(5 * 5 * 5 * 5), is(ImmutableMap.of(5, 4)));
    }

    @Test
    void computesFactorizationOfArbitraryIntegers() {
        assertThat(PrimeFactorization.of(2 * 2 * 3), is(ImmutableMap.builder()
                .put(2, 2)
                .put(3, 1)
                .build()));
        assertThat(PrimeFactorization.of(2 * 3 * 3 * 5 * 5 * 5), is(ImmutableMap.builder()
                .put(2, 1)
                .put(3, 2)
                .put(5, 3)
                .build()));
    }
}
