package com.github.speisz.euler.problem._0._5._1;

import com.github.speisz.euler.math.ScalingPrimeSieve;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

import static com.github.speisz.euler.utils.MathUtil.digits;
import static com.google.common.collect.Sets.powerSet;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.iterate;
import static java.util.stream.IntStream.range;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {

    private static final IntPredicate PRIME_SIEVE = new ScalingPrimeSieve(100_000, 10).toIntPredicate();

    @Test
    void findNumberWithReplacementsYieldingEightPrimes() {
        Set<Integer> primes1 = iterate(100, i -> i + 1).boxed()
                .flatMap(this::replacementPrimes)
                .filter(primes -> primes.size() >= 8)
                .findFirst().orElseThrow();
        assertThat(primes1.stream().min(Integer::compareTo), is(0));
    }

    private Stream<Set<Integer>> replacementPrimes(Integer n) {
        Set<Integer> indexes = range(0, (int) digits(n).count()).boxed().collect(toSet());
        return powerSet(indexes).stream()
                .map(indexesCombination -> indexesCombination.stream().mapToInt(m -> m).toArray())
                .map(indexesCombination -> new DigitReplacementPrimeFinder(PRIME_SIEVE, n).findReplacedAtDigits(indexesCombination));
    }
}
