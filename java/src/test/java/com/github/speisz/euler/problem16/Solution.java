package com.github.speisz.euler.problem16;

import com.github.speisz.euler.utils.CrossSum;
import org.junit.jupiter.api.Test;

import static com.github.speisz.euler.utils.MathUtil.TWO;
import static java.math.BigInteger.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {
    @Test
    void computesDigitSumOf2Pow1000() {
        assertThat(CrossSum.of(TWO.pow(1000)), is(valueOf(1366)));
    }
}
