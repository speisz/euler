package com.github.speisz.euler.problem._0._3._7;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {

    private TruncatablePrimes truncatablePrimes = new TruncatablePrimes();

    @Test
    void findsAllTruncatablePrimes() {
        assertThat(truncatablePrimeSum(), is(748317L));
    }

    private long truncatablePrimeSum() {
        return truncatablePrimes.stream()
//                .peek(System.out::println)
                .mapToInt(n -> n)
                .sum();
    }
}
