package com.github.speisz.euler.problem16;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;

public class DigitSum {
    public static BigInteger of(BigInteger n) {
        return n.toString()
                .chars()
                .map(Character::getNumericValue)
                .mapToObj(BigInteger::valueOf)
                .reduce(ZERO, BigInteger::add);
    }
}
