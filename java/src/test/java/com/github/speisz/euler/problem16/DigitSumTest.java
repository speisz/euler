package com.github.speisz.euler.problem16;

import org.junit.Test;

import static java.math.BigInteger.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DigitSumTest {
    @Test
    public void computesSumOfDigits() {
        assertThat(DigitSum.of(valueOf(0)), is(valueOf(0)));
        assertThat(DigitSum.of(valueOf(1)), is(valueOf(1)));
        assertThat(DigitSum.of(valueOf(123)), is(valueOf(1 + 2 + 3)));
    }
}
