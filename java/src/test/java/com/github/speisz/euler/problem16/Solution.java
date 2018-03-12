package com.github.speisz.euler.problem16;

import org.junit.Test;

import static com.github.speisz.euler.utils.MathUtil.TWO;
import static java.math.BigInteger.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Solution {
    @Test
    public void computesDigitSumOf2Pow1000() {
        assertThat(DigitSum.of(TWO.pow(1000)), is(valueOf(1366)));
    }
}
