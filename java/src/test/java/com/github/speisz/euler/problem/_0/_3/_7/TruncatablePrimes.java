package com.github.speisz.euler.problem._0._3._7;

import com.github.speisz.euler.math.ScalingPrimeSieve;
import com.github.speisz.euler.utils.Truncations;

import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TruncatablePrimes {

    private static final int NUMBER_OF_TRUNCATABLE_PRIMES = 11;
    private static final int MIN_TRUNCATABLE_PRIME = 23;

    private Predicate<Integer> isPrime;

    public TruncatablePrimes(Predicate<Integer> isPrime) {
        this.isPrime = isPrime;
    }

    public TruncatablePrimes() {
        this(ScalingPrimeSieve.create(10_000, 10));
    }

    Stream<Integer> stream() {
        return IntStream.iterate(MIN_TRUNCATABLE_PRIME, n -> n + 1).boxed()
                .filter(isPrime)
                .filter(n -> Truncations.stream(n).allMatch(isPrime))
                .limit(NUMBER_OF_TRUNCATABLE_PRIMES);
    }
}
