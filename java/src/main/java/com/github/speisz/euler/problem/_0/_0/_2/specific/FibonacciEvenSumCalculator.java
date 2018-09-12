package com.github.speisz.euler.problem._0._0._2.specific;

import java.math.BigInteger;

import static com.github.speisz.euler.utils.Fibonacci.evenFibonaccis;
import static com.github.speisz.euler.utils.MathUtil.lowerOrEqual;
import static java.math.BigInteger.ZERO;

class FibonacciEvenSumCalculator {
    BigInteger sum(long boundary) {
        return sum(BigInteger.valueOf(boundary));
    }

    BigInteger sum(BigInteger boundary) {
        return evenFibonaccis().takeWhile(number -> lowerOrEqual(number, boundary)).reduce(BigInteger::add).orElse(ZERO);
    }
}
