package com.github.speisz.euler.problem2.specific;

import com.github.speisz.euler.utils.BoundedStream;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;
import static com.github.speisz.euler.utils.Fibonacci.evenFibonaccis;
import static com.github.speisz.euler.utils.MathUtils.lowerOrEqual;

class FibonacciEvenSumCalculator {
    BigInteger sum(long boundary) {
        return sum(BigInteger.valueOf(boundary));
    }

    BigInteger sum(BigInteger boundary) {
        Sum sum = new Sum();
        BoundedStream.of(evenFibonaccis())
                .withConditionExclusive(number -> lowerOrEqual(number, boundary))
                .doForEach(sum::add);
        return sum.get();
    }

    class Sum {
        BigInteger sum = ZERO;

        void add(BigInteger summand) {
            sum = sum.add(summand);
        }

        BigInteger get() {
            return sum;
        }
    }
}
