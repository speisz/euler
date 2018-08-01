package com.github.speisz.euler.math;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LastDigitsOfPowerTest {

    @Test
    public void computesLastDigitsOfPower() {
        assertThat(LastDigitsOfPower.pow(123,4).computeLastDigits(5), is(86641L));
    }

    @Test
    public void computesLastDigitsOfLargePowers() {
        assertThat(LastDigitsOfPower.pow(999,999).computeLastDigits(10), is(499_998_999L));
    }
}
