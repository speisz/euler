package com.github.speisz.euler.utils;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;

public class CrossSum {
    public static BigInteger of(BigInteger n) {
        return n.toString()
                .chars()
                .map(Character::getNumericValue)
                .mapToObj(BigInteger::valueOf)
                .reduce(ZERO, BigInteger::add);
    }
}
