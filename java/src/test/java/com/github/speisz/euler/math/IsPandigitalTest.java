package com.github.speisz.euler.math;

import org.junit.jupiter.api.Test;

import static com.github.speisz.euler.math.IsPandigital.isPandigital;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class IsPandigitalTest {

    @Test
    void testsIfNumberIsPandigital() {
        assertThat(isPandigital(132), is(true));
        assertThat(isPandigital(15324), is(true));
    }

    @Test
    void testsIfNumberIsNotPandigital() {
        assertThat(isPandigital(122), is(false));
        assertThat(isPandigital(124), is(false));
        assertThat(isPandigital(15325), is(false));
    }
}
