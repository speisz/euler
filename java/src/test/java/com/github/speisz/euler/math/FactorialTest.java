package com.github.speisz.euler.math;

import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void computesFactorials() {
        assertThat(Factorial.of(0), is(BigInteger.ONE));
        assertThat(Factorial.of(1), is(BigInteger.ONE));
        assertThat(Factorial.of(2), is(BigInteger.valueOf(2)));
        assertThat(Factorial.of(3), is(BigInteger.valueOf(3 * 2)));
        assertThat(Factorial.of(4), is(BigInteger.valueOf(4 * 3 * 2)));
        assertThat(Factorial.of(5), is(BigInteger.valueOf(5 * 4 * 3 * 2)));
        assertThat(Factorial.of(10), is(BigInteger.valueOf(3628800)));
    }
}
