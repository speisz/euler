package com.github.speisz.euler.problem._0._4._7;

import com.github.speisz.euler.math.PrimeFactorization;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class ConsecutivePrimes {
    private final int consecutiveCount;
    private final int distinctPrimesCount;

    public ConsecutivePrimes(int consecutiveCount, int distinctPrimesCount) {
        this.consecutiveCount = consecutiveCount;
        this.distinctPrimesCount = distinctPrimesCount;
    }

    public int compute() {
        return IntStream.iterate(2, i -> i + 1)
                .filter(this::hasDistinctPrimesAndSuccessorsWithDistinctPrimes)
                .findFirst().orElseThrow(IllegalStateException::new);
    }

    private boolean hasDistinctPrimesAndSuccessorsWithDistinctPrimes(int n) {
        return range(n, n + consecutiveCount).allMatch(i -> PrimeFactorization.of(i).keySet().size() == distinctPrimesCount);
    }
}
