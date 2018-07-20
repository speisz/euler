package com.github.speisz.euler.problem46;

import com.github.speisz.euler.math.ScalingPrimeSieve;
import com.github.speisz.euler.math.SieveOfEratosthenes;
import com.github.speisz.euler.utils.MathUtil;
import org.junit.Test;

import java.util.Optional;
import java.util.function.IntPredicate;

import static com.github.speisz.euler.testutils.matcher.OptionalMatchers.hasValue;
import static com.github.speisz.euler.utils.MathUtil.isPerfectSquare;
import static java.util.stream.IntStream.iterate;
import static org.hamcrest.MatcherAssert.assertThat;

public class Solution {

    private static final IntPredicate PRIME_SIEVE = new ScalingPrimeSieve(100, 10).toIntPredicate();

    @Test
    public void __() {
        Optional<Integer> firstNonGoldbachNumber = iterate(2, n -> n + 1)
                .filter(MathUtil::isOdd)
                .filter(PRIME_SIEVE.negate())
                .filter(this::notGoldbach)
                .boxed()
                .findFirst();

        assertThat(firstNonGoldbachNumber, hasValue(5_777));
    }

    private boolean notGoldbach(int n) {
        return iterate(0, i -> i <= n, i -> i + 1)
                .filter(PRIME_SIEVE)
                .map(i-> n - i)
                .noneMatch(this::isTwiceASquare);
    }

    private boolean isTwiceASquare(int m) {
        return m % 2 == 0 && isPerfectSquare(m / 2);
    }
}
