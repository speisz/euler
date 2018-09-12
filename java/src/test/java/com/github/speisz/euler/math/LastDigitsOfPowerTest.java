package com.github.speisz.euler.math;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LastDigitsOfPowerTest {

    @Test
    void computesLastDigitsOfPower() {
        assertThat(LastDigitsOfPower.pow(123, 4).computeLastDigits(5), is(86641L));
    }

    @Test
    void computesLastDigitsOfLargePowers() {
        assertThat(LastDigitsOfPower.pow(999, 999).computeLastDigits(10), is(499_998_999L));
    }
}
