package com.github.speisz.euler.problem._0._1._2;

import org.junit.jupiter.api.Test;

import static java.math.BigInteger.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class DivisorCountTest {
    @Test
    void countsNumberOfDivisors() {
        assertThat(DivisorCount.of(valueOf(1)), is(1));
        assertThat(DivisorCount.of(valueOf(2)), is(2));
        assertThat(DivisorCount.of(valueOf(3)), is(2));
        assertThat(DivisorCount.of(valueOf(4)), is(3));
        assertThat(DivisorCount.of(valueOf(5)), is(2));
        assertThat(DivisorCount.of(valueOf(12)), is(6));
    }
}
