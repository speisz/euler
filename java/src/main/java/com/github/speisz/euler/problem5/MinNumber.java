package com.github.speisz.euler.problem5;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

class MinNumber {
    BigInteger getMinimalNumberDivisibleBy(Stream<BigInteger> numbers) {
        return numbers
                .reduce(this::lcm)
                .orElseThrow(IllegalArgumentException::new);
    }

    BigInteger getMinimalNumberDivisibleBy(Integer... numbers) {
        return getMinimalNumberDivisibleBy(stream(numbers).map(BigInteger::valueOf));
    }

    private BigInteger lcm(BigInteger n, BigInteger m) {
        return n.multiply(m).divide(n.gcd(m));
    }
}
