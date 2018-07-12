package com.github.speisz.euler.problem27;

import com.github.speisz.euler.math.QuadraticForm;
import com.github.speisz.euler.utils.MathUtil;

import static java.util.stream.IntStream.iterate;

public class NumberOfConsecutivePrimes {
    public static long of(QuadraticForm quadraticForm) {
        return iterate(0, n -> n + 1).boxed()
                .map(quadraticForm)
                .takeWhile(MathUtil::isPrime)
                .count();
    }
}
