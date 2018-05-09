package com.github.speisz.euler.problem32;

import org.junit.Test;

import static com.github.speisz.euler.problem32.IsPandigital.isPandigital;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class IsPandigitalTest {

    @Test
    public void testsIfNumberIsPandigital() {
        assertThat(isPandigital(132), is(true));
        assertThat(isPandigital(15324), is(true));
    }

    @Test
    public void testsIfNumberIsNotPandigital() {
        assertThat(isPandigital(122), is(false));
        assertThat(isPandigital(124), is(false));
        assertThat(isPandigital(15325), is(false));
    }
}
