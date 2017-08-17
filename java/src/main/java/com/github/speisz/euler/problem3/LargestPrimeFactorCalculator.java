package com.github.speisz.euler.problem3;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;
import static com.github.speisz.euler.utils.MathUtils.lowerOrEqual;

class LargestPrimeFactorCalculator {
    BigInteger calculateFor(BigInteger number) {
        if (lowerOrEqual(number, ONE)) {
            throw new IllegalArgumentException("Given number has to >= 2. Was: " + number);
        }
        if (number.isProbablePrime(10)) {
            return number;
        }
        return calculateFor(number.divide(findDivisor(number)));
    }

    private BigInteger findDivisor(BigInteger number) {
        return Stream.iterate(valueOf(2), n -> n.add(ONE))
                .filter(current -> number.mod(current).equals(ZERO))
                .findFirst()
                .orElse(number);
    }
}
