package com.github.speisz.euler.problem30;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class EqualsPowerDigitSumTest {

    private EqualsPowerDigitSum equalsPower4DigitSum = EqualsPowerDigitSum.forExponent(4);

    @Test
    void testsIfNumberEqualsPower4DigitSum() {
        assertThat(equalsPower4DigitSum.test(1634), is(true));
        assertThat(equalsPower4DigitSum.test(8208), is(true));
        assertThat(equalsPower4DigitSum.test(9474), is(true));
    }
}
