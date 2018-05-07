package com.github.speisz.euler.problem30;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class EqualsPowerDigitSumTest {

    private EqualsPowerDigitSum equalsPower4DigitSum = EqualsPowerDigitSum.forExponent(4);

    @Test
    public void testsIfNumberEqualsPower4DigitSum() {
        assertThat(equalsPower4DigitSum.test(1634), is(true));
        assertThat(equalsPower4DigitSum.test(8208), is(true));
        assertThat(equalsPower4DigitSum.test(9474), is(true));
    }
}