package com.github.speisz.euler.problem._0._5._8;

import com.github.speisz.euler.math.ScalingPrimeSieve;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;

import static com.github.speisz.euler.testutils.matcher.optionalint.HasValueMatcher.hasValue;
import static com.github.speisz.euler.utils.StreamUtil.lastElement;
import static java.util.stream.IntStream.iterate;
import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.MatcherAssert.assertThat;

class Solution {

    IntPredicate primeSieve = ScalingPrimeSieve.create(1_000, 100).toIntPredicate();
    IntUnaryOperator toEdgeLength = n -> 2 * n + 1;
    AtomicLong overallPrimeCount = new AtomicLong(0);

    @Test
    @Disabled("slow (~20s)")
    void findsEdgeLengthWithVerticesPrimeRatioLower10Percent() {
        assertThat(lastElement(iterate(1, n -> n + 1)
                .takeWhile(this::primeRatioAbove10Percent)
                .map(toEdgeLength)), hasValue(26241));
    }

    boolean primeRatioAbove10Percent(int n) {
        int firstVertex = 4 * n * n - 2 * n + 1;
        long currentPrimeCount = rangeClosed(0, 3)
                .map(m -> firstVertex + 2 * n * m)
                .filter(primeSieve)
                .count();
        int vertexCount = 4 * n;
        return 10 * overallPrimeCount.addAndGet(currentPrimeCount) / vertexCount > 0;
    }
}
