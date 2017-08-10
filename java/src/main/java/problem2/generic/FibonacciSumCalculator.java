package problem2.generic;

import java.math.BigInteger;
import java.util.function.Predicate;

import static java.math.BigInteger.ZERO;
import static utils.Fibonacci.fibonaccis;
import static utils.Fibonacci.upperBoundForNumberOfIterations;
import static utils.MathUtils.lowerOrEqual;

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
        return fibonaccis()
                .limit(upperBoundForNumberOfIterations(boundary).longValue()) // urgh... In Java 9: .takeWhile(value -> value < boundary)
                .filter(value -> lowerOrEqual(value, boundary))
                .filter(condition)
                .reduce(ZERO, BigInteger::add);
    }
}
