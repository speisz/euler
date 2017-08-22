package com.github.speisz.euler.utils;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;

public class MathUtils {
    public static boolean isEven(BigInteger value) {
        return value.mod(BigInteger.valueOf(2)).equals(ZERO);
    }

    public static boolean lowerOrEqual(BigInteger first, BigInteger second) {
        return first.compareTo(second) < 1;
    }

    public static boolean isDivisible(BigInteger m, BigInteger n) {
        return m.mod(n).equals(ZERO);
    }

    private MathUtils() {
    }
}
