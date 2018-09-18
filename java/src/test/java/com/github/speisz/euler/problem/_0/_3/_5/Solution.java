package com.github.speisz.euler.problem._0._3._5;

import com.github.speisz.euler.math.SieveOfEratosthenes;
import com.github.speisz.euler.utils.Rotations;
import org.junit.jupiter.api.Test;

import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {

    private static final int UPPER_BOUND = 1_000_000;
    private final SieveOfEratosthenes PRIME_SIEVE = SieveOfEratosthenes.createForUpperBound(UPPER_BOUND);

    @Test
    void countsCircularPrimes() {
        long count = rangeClosed(2, UPPER_BOUND).boxed()
                .filter(PRIME_SIEVE)
                .filter(this::isCircularPrime)
//                .peek(System.out::println)
                .count();

        assertThat(count, is(55L));
    }

    private boolean isCircularPrime(Integer n) {
        return Rotations.stream(n)
                .allMatch(PRIME_SIEVE);
    }
}
