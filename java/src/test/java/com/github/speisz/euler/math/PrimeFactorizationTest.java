package com.github.speisz.euler.math;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.math.BigInteger;

import static java.math.BigInteger.valueOf;
import static java.util.Collections.emptyMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PrimeFactorizationTest {
    @Test
    public void computesFactorizationOfBigIntegerOneAsEmpty() {
        assertThat(PrimeFactorization.of(BigInteger.ONE), is(emptyMap()));
    }

    @Test
    public void computesFactorizationOfPrimeBigIntegers() {
        assertThat(PrimeFactorization.of(valueOf(2)), is(ImmutableMap.of(valueOf(2), 1)));
        assertThat(PrimeFactorization.of(valueOf(3)), is(ImmutableMap.of(valueOf(3), 1)));
        assertThat(PrimeFactorization.of(valueOf(5)), is(ImmutableMap.of(valueOf(5), 1)));
    }

    @Test
    public void computesFactorizationOfMultiplesOfPrimeBigIntegers() {
        assertThat(PrimeFactorization.of(valueOf(2 * 2)), is(ImmutableMap.of(valueOf(2), 2)));
        assertThat(PrimeFactorization.of(valueOf(3 * 3 * 3)), is(ImmutableMap.of(valueOf(3), 3)));
        assertThat(PrimeFactorization.of(valueOf(5 * 5 * 5 * 5)), is(ImmutableMap.of(valueOf(5), 4)));
    }

    @Test
    public void computesFactorizationOfArbitraryBigIntegers() {
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
    public void computesFactorizationOfIntegerOneAsEmpty() {
        assertThat(PrimeFactorization.of(1), is(emptyMap()));
    }

    @Test
    public void computesFactorizationOfPrimeIntegers() {
        assertThat(PrimeFactorization.of(2), is(ImmutableMap.of(2, 1)));
        assertThat(PrimeFactorization.of(3), is(ImmutableMap.of(3, 1)));
        assertThat(PrimeFactorization.of(5), is(ImmutableMap.of(5, 1)));
    }

    @Test
    public void computesFactorizationOfMultiplesOfPrimeIntegers() {
        assertThat(PrimeFactorization.of(2 * 2), is(ImmutableMap.of(2, 2)));
        assertThat(PrimeFactorization.of(3 * 3 * 3), is(ImmutableMap.of(3, 3)));
        assertThat(PrimeFactorization.of(5 * 5 * 5 * 5), is(ImmutableMap.of(5, 4)));
    }

    @Test
    public void computesFactorizationOfArbitraryIntegers() {
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
