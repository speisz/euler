package com.github.speisz.euler.utils;

import java.math.BigInteger;

import static com.github.speisz.euler.utils.MathUtil.digits;
import static java.math.BigInteger.ZERO;

public class CrossSum {
    public static BigInteger of(BigInteger n) {
        return digits(n)
                .mapToObj(BigInteger::valueOf)
                .reduce(ZERO, BigInteger::add);
    }
}
