package com.github.speisz.euler.problem12;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.math.BigInteger;

import static java.math.BigInteger.valueOf;
import static java.util.Collections.emptyMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PrimeFactorizationTest {
    @Test
    public void computesFactorizationOfOneAsEmpty() {
        assertThat(PrimeFactorization.of(BigInteger.ONE), is(emptyMap()));
    }

    @Test
    public void computesFactorizationOfPrimes() {
        assertThat(PrimeFactorization.of(valueOf(2)), is(ImmutableMap.of(valueOf(2), 1)));
        assertThat(PrimeFactorization.of(valueOf(3)), is(ImmutableMap.of(valueOf(3), 1)));
        assertThat(PrimeFactorization.of(valueOf(5)), is(ImmutableMap.of(valueOf(5), 1)));
    }

    @Test
    public void computesFactorizationOfMultiplesOfPrimes() {
        assertThat(PrimeFactorization.of(valueOf(2 * 2)), is(ImmutableMap.of(valueOf(2), 2)));
        assertThat(PrimeFactorization.of(valueOf(3 * 3 * 3)), is(ImmutableMap.of(valueOf(3), 3)));
        assertThat(PrimeFactorization.of(valueOf(5 * 5 * 5 * 5)), is(ImmutableMap.of(valueOf(5), 4)));
    }

    @Test
    public void computesFactorizationOfArbitraryNumbers() {
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
}
