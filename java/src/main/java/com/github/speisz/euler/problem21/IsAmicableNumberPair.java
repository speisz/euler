package com.github.speisz.euler.problem21;

import java.math.BigInteger;
import java.util.function.BiPredicate;

import static java.math.BigInteger.ZERO;

public class IsAmicableNumberPair implements BiPredicate<BigInteger, BigInteger> {

    @Override
    public boolean test(BigInteger n, BigInteger m) {
        return properDivisorSumOf(n).equals(m) && properDivisorSumOf(m).equals(n);
    }

    private BigInteger properDivisorSumOf(BigInteger n) {
        return ProperDivisors.of(n).stream().reduce(ZERO, BigInteger::add);
    }
}
