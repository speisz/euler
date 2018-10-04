package com.github.speisz.euler.math;

import java.util.function.Function;
import java.util.function.Predicate;

public class ScalingPrimeSieve implements Predicate<Integer>, ToIntPredicate {
    private final int upperBoundMultiplier;
    private final Function<Integer, Predicate<Integer>> sieveSupplier;
    private int upperBound;
    private Predicate<Integer> sieve;

    private ScalingPrimeSieve(int initialUpperBound, int upperBoundMultiplier, Function<Integer, Predicate<Integer>> sieveSupplier) {
        this.upperBoundMultiplier = upperBoundMultiplier;
        this.sieveSupplier = sieveSupplier;
        this.upperBound = initialUpperBound;
        sieve = sieveSupplier.apply(upperBound);
    }

    private ScalingPrimeSieve(int initialUpperBound, int upperBoundMultiplier) {
        this(initialUpperBound, upperBoundMultiplier, SieveOfEratosthenes::createForUpperBound);
    }

    public static ScalingPrimeSieve create(int initialUpperBound, int upperBoundMultiplier) {
        return new ScalingPrimeSieve(initialUpperBound, upperBoundMultiplier);
    }

    @Override
    public boolean test(Integer number) {
        if (number > upperBound) {
            determineNewSieve(number);
        }
        return sieve.test(number);
    }

    private void determineNewSieve(Integer number) {
        determineNewUpperBound(number);
        sieve = sieveSupplier.apply(upperBound);
    }

    private void determineNewUpperBound(Integer number) {
        while (number > upperBound) {
            upperBound *= upperBoundMultiplier;
        }
    }

    int getUpperBound() {
        return upperBound;
    }
}
