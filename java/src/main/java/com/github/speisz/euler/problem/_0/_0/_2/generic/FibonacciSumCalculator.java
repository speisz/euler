package com.github.speisz.euler.problem._0._0._2.generic;

import java.math.BigInteger;
import java.util.function.Predicate;

import static com.github.speisz.euler.utils.Fibonacci.fibonaccis;
import static com.github.speisz.euler.utils.Fibonacci.upperBoundForNumberOfIterations;
import static com.github.speisz.euler.utils.MathUtil.TWO;
import static com.github.speisz.euler.utils.MathUtil.lowerOrEqual;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

class FibonacciSumCalculator {
    private Predicate<BigInteger> condition;

    FibonacciSumCalculator() {
        this(value -> true);
    }

    FibonacciSumCalculator(Predicate<BigInteger> condition) {
        this.condition = condition;
    }

    BigInteger sum(long boundary) {
        return sum(BigInteger.valueOf(boundary));
    }

    BigInteger sum(BigInteger boundary) {
        return fibonaccis(ONE, TWO)
                .limit(upperBoundForNumberOfIterations(boundary).longValue()) // urgh... In Java 9: .takeWhile(value -> value < boundary)
                .filter(value -> lowerOrEqual(value, boundary))
                .filter(condition)
                .reduce(ZERO, BigInteger::add);
    }
}
