package com.github.speisz.euler.problem._0._4._7;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {

    @Test
    void findsFourConsecutivePrimesWithFourDistinctPrimeFactors() {
        assertThat(new ConsecutivePrimes(4, 4).compute(), is(134043));
    }
}
