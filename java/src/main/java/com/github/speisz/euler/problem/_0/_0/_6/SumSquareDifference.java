package com.github.speisz.euler.problem._0._0._6;

import java.math.BigInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

class SumSquareDifference {
    static BigInteger computeFor(Supplier<Stream<BigInteger>> numbers) {
        return sumSquare(numbers).subtract(squaresSum(numbers));
    }

    private static BigInteger squaresSum(Supplier<Stream<BigInteger>> numbers) {
        return numbers.get()
                .map(n -> n.pow(2))
                .reduce(BigInteger::add)
                .orElseThrow(IllegalStateException::new);
    }

    private static BigInteger sumSquare(Supplier<Stream<BigInteger>> numbers) {
        return numbers.get()
                .reduce(BigInteger::add)
                .orElseThrow(IllegalStateException::new)
                .pow(2);
    }

    private SumSquareDifference() {
    }
}
