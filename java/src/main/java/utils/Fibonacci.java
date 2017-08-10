package utils;

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
        return Stream.iterate(Tuple.of(ONE, valueOf(2)), t -> Tuple.of(t.second, t.first.add(t.second)))
                .map(Tuple::first);
    }

    public static Stream<BigInteger> evenFibonaccis() {
        return Stream.iterate(Tuple.of(valueOf(2), valueOf(8)), t -> Tuple.of(t.second, t.first.add(t.second.multiply(valueOf(4)))))
                .map(Tuple::first);
    }
}
