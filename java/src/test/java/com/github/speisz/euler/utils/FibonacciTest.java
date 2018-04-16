package com.github.speisz.euler.utils;

import org.junit.Test;

import static com.github.speisz.euler.utils.Fibonacci.evenFibonaccis;
import static com.github.speisz.euler.utils.Fibonacci.fibonaccis;
import static com.github.speisz.euler.utils.Fibonacci.indexedFibonaccis;
import static com.github.speisz.euler.utils.MathUtil.bigIntegerValuesOf;
import static java.math.BigInteger.valueOf;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class FibonacciTest {
    @Test
    public void streamsFibonacciNumbers() {
        assertThat(fibonaccis().limit(10).collect(toList()), contains(bigIntegerValuesOf(1, 1, 2, 3, 5, 8, 13, 21, 34, 55)));
    }

    @Test
    public void streamsEvenFibonacciNumbers() {
        assertThat(evenFibonaccis().limit(3).collect(toList()), contains(bigIntegerValuesOf(2, 8, 34)));
    }

    @Test
    public void streamsFibonacciNumbersIndexed() {
        assertThat(indexedFibonaccis().limit(5).collect(toList()), contains(
                org.apache.commons.lang3.tuple.Pair.of(1, valueOf(1)),
                org.apache.commons.lang3.tuple.Pair.of(2, valueOf(1)),
                org.apache.commons.lang3.tuple.Pair.of(3, valueOf(2)),
                org.apache.commons.lang3.tuple.Pair.of(4, valueOf(3)),
                org.apache.commons.lang3.tuple.Pair.of(5, valueOf(5))));
    }
}