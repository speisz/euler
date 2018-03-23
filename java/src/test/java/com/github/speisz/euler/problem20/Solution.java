package com.github.speisz.euler.problem20;

import com.github.speisz.euler.utils.CrossSum;
import com.github.speisz.euler.utils.Factorial;
import org.junit.Test;

import static java.math.BigInteger.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Solution {
    @Test
    public void calculateCrossSumOfFactorialOf100() {
        assertThat(CrossSum.of(Factorial.of(100)), is(valueOf(648)));
    }
}
