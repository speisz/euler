package com.github.speisz.euler.math;

import java.util.BitSet;
import java.util.function.Predicate;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;
import static java.util.stream.IntStream.rangeClosed;

public class SieveOfEratosthenes implements Predicate<Integer>, ToIntPredicate {

    private final int upperBound;
    private final BitSet isNotPrime;

    private SieveOfEratosthenes(int upperBound) {
        this.upperBound = upperBound;
        isNotPrime = new BitSet(upperBound + 1);
        filterOutNonPrimes();
    }

    public static SieveOfEratosthenes forUpperBound(int upperBound) {
        return new SieveOfEratosthenes(upperBound);
    }

    private void filterOutNonPrimes() {
        rangeClosed(2, (int) floor(sqrt(upperBound)))
                .filter(this::isPrime)
                .forEach(n -> rangeClosed(0, (upperBound / n - n))
                        .map(k -> n * n + k * n)
                        .forEach(isNotPrime::set));
    }

    @Override
    public boolean test(Integer n) {
        if (n > upperBound) {
            throw new IllegalArgumentException(n + " is out of range for prime testing.");
        }
        if (n < 2) {
            return false;
        }
        return isPrime(n);
    }

    private boolean isPrime(Integer n) {
        return !isNotPrime.get(n);
    }
}
