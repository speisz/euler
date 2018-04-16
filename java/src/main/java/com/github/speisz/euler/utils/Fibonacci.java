package com.github.speisz.euler.utils;

import org.apache.commons.lang3.tuple.Triple;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.lang.Math.ceil;
import static java.lang.Math.log;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;

public class Fibonacci {
    public static BigInteger upperBoundForNumberOfIterations(BigInteger fibonacciNumber) {
        return BigInteger.valueOf((long) (ceil(log(fibonacciNumber.doubleValue()) / log(1.6d)) + 1d));
    }

    public static Stream<BigInteger> fibonaccis() {
        return fibonaccis(ONE, ONE);
    }

    public static Stream<BigInteger> fibonaccis(BigInteger firstSeed, BigInteger secondSeed) {
        return Stream.iterate(Pair.of(firstSeed, secondSeed), t -> Pair.of(t.second, t.first.add(t.second)))
                .map(Pair::first);
    }

    public static Stream<BigInteger> evenFibonaccis() {
        return Stream.iterate(Pair.of(valueOf(2), valueOf(8)), t -> Pair.of(t.second, t.first.add(t.second.multiply(valueOf(4)))))
                .map(Pair::first);
    }

    public static Stream<org.apache.commons.lang3.tuple.Pair<Integer, BigInteger>> indexedFibonaccis() {
        return Stream.iterate(Triple.of(1, ONE, ONE), t -> Triple.of(t.getLeft() + 1, t.getRight(), t.getMiddle().add(t.getRight())))
                .map(t -> org.apache.commons.lang3.tuple.Pair.of(t.getLeft(), t.getMiddle()));

    }
}
