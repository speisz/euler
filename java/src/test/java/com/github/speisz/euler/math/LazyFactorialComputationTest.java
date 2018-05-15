package com.github.speisz.euler.math;

import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LazyFactorialComputationTest {

    private LazyFactorialComputation lazyFactorialComputation = new LazyFactorialComputation();

    @Test
    public void computesFactorials() {
        assertFactorial(0, 1);
        assertFactorial(1, 1);
        assertFactorial(2, 2);
        assertFactorial(3, 2 * 3);
        assertFactorial(10, 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10);
    }

    private void assertFactorial(int givenNumber, int expectedFactorial) {
        assertThat(lazyFactorialComputation.of(givenNumber), is(BigInteger.valueOf(expectedFactorial)));
    }
}
