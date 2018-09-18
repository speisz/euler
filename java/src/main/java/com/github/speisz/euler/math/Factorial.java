package com.github.speisz.euler.math;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.util.stream.IntStream.rangeClosed;

public abstract class Factorial {
    public static BigInteger of(int n) {
        return rangeClosed(2, n)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger::multiply)
                .orElse(ONE);
    }

    public static int asIntegerOf(int n) {
        if (n > 12 || n < 0) {
            throw new IllegalArgumentException(n + " is out of range.");
        }
        return rangeClosed(2, n).reduce(1, (a, b) -> a * b);
    }

    private Factorial() {
    }
}
