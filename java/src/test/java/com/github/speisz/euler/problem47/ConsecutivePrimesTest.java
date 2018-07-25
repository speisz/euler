package com.github.speisz.euler.problem47;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConsecutivePrimesTest {

    @Test
    public void findsConsecutivePrimesWithNumberOfDistinctPrimeFactors() {
        assertThat(new ConsecutivePrimes(2, 2).compute(), is(14));
        assertThat(new ConsecutivePrimes(3, 3).compute(), is(644));
    }
}
