package com.github.speisz.euler.problem._0._1._0;

import com.github.speisz.euler.math.SieveOfEratosthenes;
import com.github.speisz.euler.utils.MathUtil;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class StreamSumTest {

    private StreamSum streamSum = new StreamSum();

    @Test
    void sumsAllIntegersUpToUpperBound() {
        assertThat(streamSum.get(5), is(1 + 2 + 3 + 4 + 5L));
    }

    @Test
    void sumsAllIntegersWithGivenConditionUpToUpperBound() {
        assertThat(streamSum.get(5, MathUtil::isEven), is(2 + 4L));
    }

    @Test
    void sumsAllPrimes() {
        assertThat(streamSum.get(20, MathUtil::isPrime), is(2 + 3 + 5 + 7 + 11 + 13 + 17 + 19L));
    }

    @Test
    void sumsAllPrimesForHighUpperBound() {
        SieveOfEratosthenes primeSieve = SieveOfEratosthenes.createForUpperBound(2_000_000);
        assertThat(streamSum.get(2_000_000, primeSieve.toIntPredicate()), is(142913828922L));
    }
}
