package com.github.speisz.euler.problem._0._4._1;

import com.github.speisz.euler.math.SieveOfEratosthenes;
import com.github.speisz.euler.utils.LexicographicPermutations;
import org.junit.jupiter.api.Test;

import static com.github.speisz.euler.testutils.matcher.OptionalMatchers.hasValue;
import static org.hamcrest.MatcherAssert.assertThat;

class Solution {

    private static final SieveOfEratosthenes PRIME_SIEVE = SieveOfEratosthenes.forUpperBound(7_654_321);

    @Test
    void findsLargestPandigitalPrime() {
        assertThat(LexicographicPermutations.stream(1234567)
                .filter(PRIME_SIEVE)
                .max(Integer::compareTo), hasValue(7652413));
    }
}
