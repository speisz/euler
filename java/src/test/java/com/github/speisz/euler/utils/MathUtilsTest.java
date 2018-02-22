package com.github.speisz.euler.utils;

import org.junit.Test;

import static com.github.speisz.euler.utils.MathUtils.isPrime;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MathUtilsTest {

    @Test
    public void testsThatIntegerIsNotPrime() {
        assertThat(isPrime(1), is(false));
        assertThat(isPrime(4), is(false));
        assertThat(isPrime(20), is(false));
    }

    @Test
    public void testsThatIntegerIsPrime() {
        assertThat(isPrime(2), is(true));
        assertThat(isPrime(3), is(true));
        assertThat(isPrime(17), is(true));
    }
}
