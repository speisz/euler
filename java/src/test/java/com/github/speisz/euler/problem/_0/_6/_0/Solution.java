package com.github.speisz.euler.problem._0._6._0;

import org.junit.jupiter.api.Test;

import static com.github.speisz.euler.testutils.matcher.optionalint.HasValueMatcher.hasValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class Solution {

    private final ConcatPrimeFinder concatPrimeFinder = ConcatPrimeFinder.forUpperBound(9_997);

    @Test
    void findsMinimalSumQuadrupleOfPrimesWithConcatenationsPrime() {
        assertThat(concatPrimeFinder.findConcatenationPrimes(4)
//                .peek(System.out::println)
                .mapToInt(primes -> primes.stream().mapToInt(prime -> prime).sum())
                .min(), hasValue(26_033));
    }
}
