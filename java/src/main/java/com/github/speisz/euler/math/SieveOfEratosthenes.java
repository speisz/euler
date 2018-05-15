package com.github.speisz.euler.math;

import java.util.BitSet;
import java.util.function.Predicate;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;
import static java.util.stream.IntStream.rangeClosed;

public class SieveOfEratosthenes implements Predicate<Integer> {
    private BitSet isNotPrime;

    public SieveOfEratosthenes(int upperBound) {
        isNotPrime = new BitSet(upperBound + 1);
        filterOutNonPrimes(upperBound);
    }

    private void filterOutNonPrimes(int upperBound) {
        rangeClosed(2, (int) floor(sqrt(upperBound)))
                .filter(this::isPrime)
                .forEach(n -> rangeClosed(0, (upperBound / n - n))
                        .map(k -> n * n + k * n)
                        .forEach(m -> isNotPrime.set(m)));
    }

    @Override
    public boolean test(Integer n) {
        return isPrime(n);
    }

    private boolean isPrime(Integer n) {
        return !isNotPrime.get(n);
    }
}
