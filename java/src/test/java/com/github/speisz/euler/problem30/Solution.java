package com.github.speisz.euler.problem30;

import org.junit.Test;

import static java.util.stream.LongStream.range;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Solution {

    @Test
    public void sumsNumbersEqualToTheirPower5DigitSum() {
        assertThat(range(2, 600_000)
                .filter(EqualsPowerDigitSum.forExponent(5))
                .sum(), is(443839L));
    }
}