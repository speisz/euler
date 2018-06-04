package com.github.speisz.euler.problem41;

import com.github.speisz.euler.math.SieveOfEratosthenes;
import com.github.speisz.euler.utils.LexicographicPermutations;
import org.junit.Test;

import static com.github.speisz.euler.testutils.matcher.OptionalMatchers.hasValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class Solution {

    private static final SieveOfEratosthenes PRIME_SIEVE = new SieveOfEratosthenes(7_654_321);

    @Test
    public void findsLargestPandigitalPrime() {
        assertThat(LexicographicPermutations.stream(1234567)
                .filter(PRIME_SIEVE)
                .max(Integer::compareTo), hasValue(7652413));
    }
}