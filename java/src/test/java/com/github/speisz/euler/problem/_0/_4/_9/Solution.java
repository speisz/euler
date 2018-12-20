package com.github.speisz.euler.problem._0._4._9;

import com.github.speisz.euler.math.SieveOfEratosthenes;
import com.github.speisz.euler.utils.LexicographicPermutations;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {

    private static final SieveOfEratosthenes PRIME_SIEVE = SieveOfEratosthenes.forUpperBound(10_000);
    private static final IntPredicate INT_PRIME_SIEVE = PRIME_SIEVE.toIntPredicate();
    private static final int ALREADY_KNOWN = 1_487;

    @Test
    void findsPrimePermutationsOfLengthThreeForFourDigitNumbers() {
        String concatenation = rangeClosed(1_000, 9_999)
                .filter(INT_PRIME_SIEVE)
                .filter(n -> n != ALREADY_KNOWN)
                .mapToObj(this::findThreePermutationsAndConcatenate)
                .flatMap(stream -> stream)
                .findFirst().orElseThrow();
        assertThat(concatenation, is("296962999629"));
    }

    private Stream<String> findThreePermutationsAndConcatenate(int n) {
        List<Integer> permutations = LexicographicPermutations.stream(n).distinct().collect(toList());
        return permutations.stream()
                .filter(m -> m > n)
                .filter(PRIME_SIEVE)
                .filter(m -> permutations.contains(2 * m - n))
                .filter(m -> PRIME_SIEVE.test(2 * m - n))
                .map(m -> String.format("%s%s%s", n, m, 2 * m - n));
    }
}
