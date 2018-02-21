package com.github.speisz.euler.utils;

import org.apache.commons.lang3.tuple.Triple;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;

public abstract class MathUtils {
    public static boolean isEven(BigInteger value) {
        return value.mod(BigInteger.valueOf(2)).equals(ZERO);
    }

    public static boolean lowerOrEqual(BigInteger first, BigInteger second) {
        return first.compareTo(second) < 1;
    }

    public static boolean isDivisible(BigInteger m, BigInteger n) {
        return m.mod(n).equals(ZERO);
    }

    public static boolean isPythagorean(Triple<Integer, Integer, Integer> triple) {
        return square(triple.getLeft()) + square(triple.getMiddle()) == square(triple.getRight());
    }

    private static int square(int n) {
        return n * n;
    }

    private MathUtils() {
    }
}
