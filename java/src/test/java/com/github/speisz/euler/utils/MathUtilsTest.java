package com.github.speisz.euler.utils;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.stream.IntStream;

import static com.github.speisz.euler.utils.MathUtil.digits;
import static com.github.speisz.euler.utils.MathUtil.floor;
import static com.github.speisz.euler.utils.MathUtil.isPerfectSquare;
import static com.github.speisz.euler.utils.MathUtil.isPrime;
import static com.github.speisz.euler.utils.MathUtil.lastDigits;
import static com.github.speisz.euler.utils.MathUtil.pow;
import static com.github.speisz.euler.utils.MathUtil.replace;
import static com.github.speisz.euler.utils.MathUtil.reverse;
import static com.github.speisz.euler.utils.MathUtil.roundedSqrt;
import static com.github.speisz.euler.utils.MathUtil.square;
import static com.github.speisz.euler.utils.MathUtil.upperBase10Pow;
import static java.math.BigInteger.valueOf;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MathUtilsTest {

    @Test
    void testsThatIntegerIsNotPrime() {
        assertThat(isPrime(1), is(false));
        assertThat(isPrime(4), is(false));
        assertThat(isPrime(20), is(false));
    }

    @Test
    void testsThatIntegerIsPrime() {
        assertThat(isPrime(2), is(true));
        assertThat(isPrime(3), is(true));
        assertThat(isPrime(17), is(true));
    }

    @Test
    void testsThatBigIntegerIsNotPrime() {
        assertThat(isPrime(valueOf(1)), is(false));
        assertThat(isPrime(valueOf(4)), is(false));
        assertThat(isPrime(valueOf(20)), is(false));
    }

    @Test
    void testsThatBigIntegerIsPrime() {
        assertThat(isPrime(valueOf(2)), is(true));
        assertThat(isPrime(valueOf(3)), is(true));
        assertThat(isPrime(valueOf(17)), is(true));
    }

    @Test
    void computesRoundedSqrt() {
        assertThat(roundedSqrt(valueOf(1)), is(valueOf(1)));
        assertThat(roundedSqrt(valueOf(2)), is(valueOf(1)));
        assertThat(roundedSqrt(valueOf(3)), is(valueOf(2)));
        assertThat(roundedSqrt(valueOf(7)), is(valueOf(2)));
        assertThat(roundedSqrt(valueOf(8)), is(valueOf(3)));
        assertThat(roundedSqrt(valueOf(14)), is(valueOf(3)));
        assertThat(roundedSqrt(valueOf(15)), is(valueOf(4)));
        assertThat(roundedSqrt(valueOf(24)), is(valueOf(4)));
    }

    @Test
    void computesPowersOfIntegers() {
        assertThat(pow(1, 0), is(1L));
        assertThat(pow(1, 1), is(1L));
        assertThat(pow(2, 0), is(1L));
        assertThat(pow(2, 1), is(2L));
        assertThat(pow(2, 2), is(4L));
        assertThat(pow(3, 3), is(27L));
    }

    @Test
    void streamsDigits() {
        assertThat(digits(123).boxed().collect(toList()), contains(1, 2, 3));
        assertThat(digits(BigInteger.valueOf(123)).boxed().collect(toList()), contains(1, 2, 3));
    }

    @Test
    void testsIfNumberIsPerfectSquare() {
        assertTrue(isPerfectSquare(1));
        assertTrue(isPerfectSquare(4));
        assertTrue(isPerfectSquare(9));
        assertTrue(isPerfectSquare(16));
        assertTrue(isPerfectSquare(square(123)));

        assertFalse(isPerfectSquare(2));
        assertFalse(isPerfectSquare(3));
        assertFalse(isPerfectSquare(5));
        assertFalse(isPerfectSquare(square(123) + 1));
    }

    @Test
    void truncsIntegerToLastNDigits() {
        assertThat(lastDigits(12345, 3), is(345L));
        assertThat(lastDigits(12345, 6), is(12345L));
        assertThat(lastDigits(12345, 0), is(0L));
    }

    @Test
    void floorsInteger() {
        assertThat(floor(123456, 0), is(123456));
        assertThat(floor(123456, 1), is(123450));
        assertThat(floor(123456, 2), is(123400));
        assertThat(floor(123456, 3), is(123000));
        assertThat(floor(123456, 4), is(120000));
        assertThat(floor(123456, 5), is(100000));
        assertThat(floor(123456, 6), is(0));
    }

    @Test
    void replacesDigitOfANumberAtGivenIndex() {
        assertThat(replace(12345, 6, 0), is(12346));
        assertThat(replace(12345, 6, 1), is(12365));
        assertThat(replace(12345, 6, 2), is(12645));
        assertThat(replace(12345, 6, 3), is(16345));
        assertThat(replace(12345, 6, 4), is(62345));
    }

    @Test
    void throwsExceptionIfReplacementIndexIsOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> replace(12345, 6, -1));
        assertThrows(IllegalArgumentException.class, () -> replace(12345, 6, 5));
    }

    @Test
    void findsUpperBase10Pow() {
        assertThat(upperBase10Pow(0), is(1));
        assertThat(upperBase10Pow(1), is(1));
        assertThat(upperBase10Pow(2), is(10));
        assertThat(upperBase10Pow(10), is(10));
        assertThat(upperBase10Pow(11), is(100));
        assertThat(upperBase10Pow(100), is(100));
        assertThat(upperBase10Pow(101), is(1000));
        assertThat(upperBase10Pow(1000), is(1000));
    }

    @Test
    void reversesLong() {
        assertThat(reverse(1234), is(4321));
    }
}
