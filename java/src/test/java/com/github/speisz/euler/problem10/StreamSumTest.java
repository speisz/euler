package com.github.speisz.euler.problem10;

import com.github.speisz.euler.math.SieveOfEratosthenes;
import com.github.speisz.euler.utils.MathUtil;
import org.junit.Test;

import java.util.function.Predicate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StreamSumTest {

    private StreamSum streamSum = new StreamSum();

    @Test
    public void sumsAllIntegersUpToUpperBound() {
        assertThat(streamSum.get(5), is(1 + 2 + 3 + 4 + 5L));
    }

    @Test
    public void sumsAllIntegersWithGivenConditionUpToUpperBound() {
        assertThat(streamSum.get(5, MathUtil::isEven), is(2 + 4L));
    }

    @Test
    public void sumsAllPrimes() {
        assertThat(streamSum.get(20, MathUtil::isPrime), is(2 + 3 + 5 + 7 + 11 + 13 + 17 + 19L));
    }

    @Test
    public void sumsAllPrimesForHighUpperBound() {
        SieveOfEratosthenes primeSieve = new SieveOfEratosthenes(2_000_000);
        assertThat(streamSum.get(2_000_000, primeSieve.asIntPredicate()), is(142913828922L));
    }
}
