package com.github.speisz.euler.problem12;

import com.github.speisz.euler.math.PrimeFactorization;

import java.math.BigInteger;

public class DivisorCount {
    public static int of(BigInteger n) {
        return PrimeFactorization.of(n).values().stream()
                .mapToInt(Integer::intValue)
                .map(operand -> operand + 1)
                .reduce(1, (k, l) -> k * l);
    }
}
