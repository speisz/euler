package com.github.speisz.euler.utils;

import org.junit.Test;

import static com.github.speisz.euler.utils.MathUtils.isPrime;
import static com.github.speisz.euler.utils.MathUtils.roundedSqrt;
import static java.math.BigInteger.valueOf;
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

    @Test
    public void testsThatBigIntegerIsNotPrime() {
        assertThat(isPrime(valueOf(1)), is(false));
        assertThat(isPrime(valueOf(4)), is(false));
        assertThat(isPrime(valueOf(20)), is(false));
    }

    @Test
    public void testsThatBigIntegerIsPrime() {
        assertThat(isPrime(valueOf(2)), is(true));
        assertThat(isPrime(valueOf(3)), is(true));
        assertThat(isPrime(valueOf(17)), is(true));
    }

    @Test
    public void computesRoundedSqrt() {
        assertThat(roundedSqrt(valueOf(1)), is(valueOf(1)));
        assertThat(roundedSqrt(valueOf(2)), is(valueOf(1)));
        assertThat(roundedSqrt(valueOf(3)), is(valueOf(2)));
        assertThat(roundedSqrt(valueOf(7)), is(valueOf(2)));
        assertThat(roundedSqrt(valueOf(8)), is(valueOf(3)));
        assertThat(roundedSqrt(valueOf(14)), is(valueOf(3)));
        assertThat(roundedSqrt(valueOf(15)), is(valueOf(4)));
        assertThat(roundedSqrt(valueOf(24)), is(valueOf(4)));
    }
}
