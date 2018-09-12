package com.github.speisz.euler.problem._0._4._8;

import com.github.speisz.euler.math.LastDigitsOfPower;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static com.github.speisz.euler.utils.MathUtil.lastDigits;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {

    @Test
    void findsLast10DigitsOfPowerSum() {
        assertThat(lastDigits(IntStream.rangeClosed(1, 1000)
                .mapToLong(n -> LastDigitsOfPower.pow(n, n).computeLastDigits(10))
                .sum(), 10), is(9_110_846_700L));
    }
}
