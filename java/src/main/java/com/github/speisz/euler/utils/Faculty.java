package com.github.speisz.euler.utils;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.util.stream.LongStream.rangeClosed;

public abstract class Faculty {
    public static BigInteger of(int m) {
        return rangeClosed(1, m).mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).orElse(ONE);
    }

    private Faculty() {
    }
}
