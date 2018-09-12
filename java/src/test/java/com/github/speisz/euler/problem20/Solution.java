package com.github.speisz.euler.problem20;

import com.github.speisz.euler.math.Factorial;
import com.github.speisz.euler.utils.CrossSum;
import org.junit.jupiter.api.Test;

import static java.math.BigInteger.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {
    @Test
    void calculateCrossSumOfFactorialOf100() {
        assertThat(CrossSum.of(Factorial.of(100)), is(valueOf(648)));
    }
}
